# Emotecraft Recording Addon — Fork / Port to Minecraft 26.3

> **This is a fork / port for Minecraft Java Edition 26.3 only.** It is not the original IceCraft Studio repository or an official upstream release.

The addon records Emotecraft emote packets in replay recordings. The Flashback bridge is retained from upstream. The Replay Mod bridge is retained using reflection so this project does not compile against a Replay Mod build for Minecraft 26.2; **Replay Mod itself does not currently list a 26.3-compatible release, so that integration cannot yet be claimed as working on 26.3.**

## Attribution and source

- **Upstream project:** https://github.com/IceCraft-Studio/emotecraft-recording-addon
- **Original author / upstream credit:** Pavel Dobiáš (GitHub: [PavelDobCZ23](https://github.com/PavelDobCZ23)) / IceCraft Studio
- **This port:** MrLan112
- **License:** GNU GPL v3.0 or later (**GPL-3.0-or-later**)

See [UPSTREAM_ORIGIN.md](UPSTREAM_ORIGIN.md) for the imported upstream revision and attribution, and [CHANGELOG.md](CHANGELOG.md) for fork-specific changes.

## Target and dependencies

| Component | Target |
| --- | --- |
| Minecraft Java Edition | **26.3 only** |
| Fabric Loader | 0.19.5 or newer |
| Java | 25 or newer |
| Gradle | **9.6.0 or newer** |
| Fabric Loom | 1.17.21 |
| Fabric API | 0.161.0+26.3 |
| Emotecraft | 3.5.0-a.build.171 (26.3) |
| Flashback | 0.43.6 (26.3) |
| Replay Mod | No 26.3 release listed as of 2026-10-14; integration remains unverified |

**Important: Gradle 9.3 is not supported for this build.** Fabric Loom 1.17.21 declares Gradle Plugin API 9.5.0, while Gradle 9.3 provides API 9.3.0. This mismatch causes the “No matching variant” error during project configuration. Use Gradle 9.6.0 or newer, as recommended by Fabric for Minecraft 26.3: https://www.fabricmc.net/2026/09/15/263.html

## Build from source

Requirements: JDK 25+, Gradle 9.6.0+, and network access to the Minecraft, Fabric, Kosmx and Modrinth repositories.

This repository includes Gradle Wrapper scripts, so you do **not** need to install Gradle globally or add it to PATH. From the repository root in PowerShell, run:

```powershell
.\gradlew.bat --version
.\gradlew.bat clean build
```

The first command automatically downloads and runs Gradle 9.6.0. The second builds the mod. Set the Gradle JVM to JDK 25 in IntelliJ IDEA. In **Settings → Build, Execution, Deployment → Build Tools → Gradle**, choose the project Gradle Wrapper (the `gradle-wrapper.properties` file) as the Gradle distribution rather than a locally installed Gradle 9.3.

A settings-level version check stops early with an explanatory message if Gradle is too old. The built mod JAR is placed in `build/libs/`. GitHub Actions uses Gradle 9.6.0 too.

## Fork status

The source keeps the original packet recording code and GPL license. Minecraft/Fabric/Emotecraft/Flashback dependencies and metadata are updated for 26.3, the obsolete 26.2 Replay Mod compile dependency is removed, and the Replay Mod bridge is isolated from compile-time Replay Mod classes. A passing compile does not by itself confirm in-game compatibility; test recording and playback with the exact installed mod versions.
