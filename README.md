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
| Fabric API | 0.161.0+26.3 |
| Emotecraft | 3.5.0-a.build.171 (26.3) |
| Flashback | 0.43.6 (26.3) |
| Replay Mod | No 26.3 release listed as of 2026-10-14; integration remains unverified |

Install Emotecraft and the replay recorder separately in your client. Flashback is the supported recorder target for the current 26.3 dependency set. A compatible Replay Mod release is required before its bridge can be runtime-tested.

## Build from source

Requirements: JDK 25+, Gradle 9.6.0+, and network access to the Minecraft, Fabric, Kosmx and Modrinth repositories.

Run from the repository root:

```bash
gradle clean build
```

On Windows PowerShell, run `gradle clean build` from the project directory. The built mod JAR is placed in `build/libs/`. This repository intentionally does not include the upstream Gradle wrapper JAR binary; use a local Gradle 9.6 installation. GitHub Actions builds the project on pushes and pull requests.

## Fork status

The source keeps the original packet recording code and GPL license. Minecraft/Fabric/Emotecraft/Flashback dependencies and metadata are updated for 26.3, the obsolete 26.2 Replay Mod compile dependency is removed, and the Replay Mod bridge is isolated from compile-time Replay Mod classes. A passing compile does not by itself confirm in-game compatibility; test recording and playback with the exact installed mod versions.
