# Zero Tick Farms (Minecraft 26.1.2)

A Fabric mod that restores **0-tick plant growth**, the behavior Mojang removed
in the Minecraft 1.16 update. This mod forces a scheduled block tick on a supported
plant using a sticky piston or an observer, and makes the plant grow, enabling
fast 0-tick style farms.

This is a port to **Minecraft 26.1.2** of the original mod by **tildejustin**. It was originally mapped in Yarn, and 
this mod is ported to Mojang mappings for 26.1.

## Supported plants

updated for 26.1:

- Bamboo
- Cactus
- Chorus flower
- Sugar cane
- Kelp
- Twisting vines
- Weeping vines

## Not supported

The original mod also targeted several blocks that cannot be 0-ticked in
26.1, because the game no longer schedules a tick on them from a block update. The crops/plants that are not in this mod are the following:

- Wheat / carrots / potatoes / beetroot (crops)
- Cocoa, nether wart, sweet berries
- Vines (the climbing kind)

Farmland, fluids, and redstone ore were also dropped because they don't have growth
behavior to trigger (Originally present in tildejustin's mod).

## How to use

Growth triggers when a supported plant receives a forced scheduled tick.
The reliable way to do that is to pulse a block next to the plant. For e.g. a
sticky piston that extends and retracts with a 0-tick pulse.

Notes:
- Growth for some plants (kelp, cactus) is probabilistic per tick, & you may need to continuously trigger it.
- A static observer placed directly beside a cactus will break it (cactus
  breaks when a solid block is adjacent), so use a 0-tick sticky piston pulse adjacent to the cactus.

## Requirements

- **Minecraft** 26.1.2
- **Fabric Loader** 0.19.2 or newer
- **Fabric API** (the build for Minecraft 26.1.2)

The loader requirement is a minimum: 0.19.2 or any newer version works. If your
Fabric Loader is older than 0.19.2, update it or the mod won't load.

## Install

1. Install **Fabric Loader** (0.19.2+) for Minecraft 26.1.2 using the official
   Fabric installer from fabricmc.net.
2. Download **Fabric API** for 26.1.2.
3. Put both the Fabric API `.jar` and this mod's `.jar` in your `mods/` folder.
4. Launch Minecraft with the Fabric profile.

Intended for single-player or servers that allow fast farms.

## Credit

Original mod: [tildejustin/zero-tick-crops](https://github.com/tildejustin/zero-tick-crops) (MIT License).
All credit for the concept and original implementation goes to tildejustin.
This repository updates it to run on Minecraft 26.1.2 and documents which
blocks the current game still supports.

## License

MIT. See [LICENSE](LICENSE). Original copyright (c) 2023 tildejustin.
