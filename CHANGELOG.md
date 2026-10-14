# Changelog

## 1.5.0-26.3-fork.1 — 2026-10-14

**Fork / Port to Minecraft Java Edition 26.3**

- Retargeted the project from Minecraft 26.2 to 26.3 only.
- Updated Fabric Loader, Fabric API, Loom, Java target, Emotecraft and Flashback build dependencies.
- Updated Fabric metadata, author credits and issue/source links.
- Removed the compile-time Replay Mod dependency targeting Minecraft 26.2.
- Kept the Replay Mod packet-recording bridge via reflection; runtime compatibility remains unverified until a Replay Mod build for 26.3 is available.
- Added this fork's source attribution, build notes and CI workflow.
- Retained the upstream GPL-3.0-or-later license and original packet recording mixins.

## Upstream

Imported from IceCraft Studio's Emotecraft Recording Addon source tree at revision a28227e16cb55fc786e6cf766211935e24e029db (upstream version 1.5.0).
