package studio.icecraft.emotecraftrecording;

import java.lang.reflect.Method;
import java.util.Arrays;

import io.github.kosmx.emotes.arch.network.NetworkPlatformTools;
import io.github.kosmx.emotes.common.network.EmotePacket.Builder;

/**
 * Fork / Port to Minecraft Java Edition 26.3.
 *
 * Replay Mod currently has no listed release for 26.3. Keep this bridge isolated
 * from compile-time Replay Mod classes so the 26.3 build does not depend on a
 * Minecraft 26.2 artifact. Runtime recording requires a compatible Replay Mod API.
 */
public class EmotecraftReplayAddonClient {
    public static void recordPacket(Builder builder) {
        try {
            Class<?> recordingClass = Class.forName("com.replaymod.recording.ReplayModRecording");
            Object recording = recordingClass.getField("instance").get(null);
            if (recording == null) {
                return;
            }

            Builder safeBuilder = builder.copy();
            EmotePacketVersionFix.ensureVersions(safeBuilder);
            Object packet = NetworkPlatformTools.playPacket(safeBuilder.build());

            Object connectionEventHandler =
                recordingClass.getMethod("getConnectionEventHandler").invoke(recording);
            Object packetListener =
                connectionEventHandler.getClass().getMethod("getPacketListener").invoke(connectionEventHandler);

            Method saveMethod = Arrays.stream(packetListener.getClass().getMethods())
                .filter(method -> method.getName().equals("save"))
                .filter(method -> method.getParameterCount() == 1)
                .filter(method -> method.getParameterTypes()[0].isAssignableFrom(packet.getClass()))
                .findFirst()
                .orElseThrow(() -> new NoSuchMethodException(
                    "Replay Mod packet listener has no compatible save(packet) method"
                ));

            saveMethod.invoke(packetListener, packet);
        } catch (ClassNotFoundException ignored) {
            // Replay Mod was removed or is unavailable. The caller normally gates this path by mod ID.
        } catch (ReflectiveOperationException | RuntimeException exception) {
            EmotecraftRecordingInit.log.warn(
                "Could not record an Emotecraft packet with Replay Mod. Its 26.3 API may be incompatible.",
                exception
            );
        }
    }
}
