# 🩹 EssentialCraft 3 Patched

An updated version of [EssentialCraft 3 by Modbder](https://www.curseforge.com/minecraft/mc-mods/essentialcraft-3).

![Excluded Dependency DummyCore](https://img.shields.io/badge/Excluded_Dependency-DummyCore-purple.svg?labelColor=grey&style=for-the-badge)

---

## ❓ Why This Exists
Original mod and its only working fork (EssentialCraft 4 Unofficial) have both been long unmaintained.

My goal was to bring the codebase to a stable state and conduct some gameplay rebalancing.

## 🙏 Special Thanks
- English localization fix ~ RaidhoSketch
- Tips and bug reports ~ phdSmith

## 📜 Updated Description
EssentialCraft 3 is a huge technomagical mod which adds a new energy system, MRU (Magical Radiation Unit), and various ways to harness it. 

There are a lot of new devices for automation means, new weapon types and armor sets, accessories and ways to interact with MRU directly, including irradiating the world around you.

Also features a new dimension and a unique boss!

## ♻️ List of Changes
- The basic rule of EC3 Patched is "don't remove, don't add"

(*This only applies to the content portion; the idea is to be able to install EC Patched into an existing world without breaking anything*)

### Bug fixes
- Fixed numerous grammatical errors and typos in en_US.lang
- Fixed all GUI strings/Soul Stone tooltip being hardcoded. Added to en_US.lang.
- Fixed clumsy Wind Mages (MRU Arrows having invalid spawn speed).
- Fixed MRU-powered items having broken MRU storage when crafted by non-players.
- Fixed MRUCU Mover Tier 1 being unbreakable.
- Fixed Holy Mace not having Smite.
- Fixed Wind Mages being afraid of the sun.
- Fixed Ring of Experience spawning XP orbs inside blocks.
- Fixed Magician's Table slots being inaccessible to hoppers.
- Fixed MRUCU spawn egg summoning an invalid entity without MRU/balance.
- Optimized TileEntity rendering for MRU Coil, Magical Enchanter, Charging Chamber and Monster Holder.
### Assets changes
- Models of all magical devices have been optimized, corrected (blurry textures) and partially improved.
- Changed MRU Radiation potion icon texture.
- Changed Chaos Fork texture from 16×16 → 32×32.
- Changed plating textures to 32×32 when connected.
- Changed Magical Shield and Spiked Buckler textures (removed mixels)
- Changed Magical Furnaces textures (removed mixels)
- Fixed Sniper Scope texture offset.
### Balance changes
- Elemental Ores are now affected by Fortune enchantment
- Tool stats:
  - Weak elemental:
    - (durability) 300 -> 64
    - (efficiency) 7 -> 30
    - (enchantability): 14 -> 22
    - (harvest level): 3 -> 2
    - (damage): 6.5 -> 6
  - Elemental:
    - (durability) 500 -> 2068
    - (enchantability) : 36 -> 10
  - Wind:
    - (enchantability) 40 -> 10
    - (durability): 15684 -> 1561
- Special tool stats:
  - Frost Mace: (damage) 16 -> 12
  - Holy Mace: (damage) 12 -> 9
- Armor stats:
  - Wind:
  - (enchantability) 42 -> 10
  - Void:
    - (enchantability) 42 -> 10
- Armor set vis discounts:
  - MHS: 20% -> 10% (=Thaumaturge's)
  - Void: 30% ->  15% (=Void Thaumaturge's)
  - Wind Mage's : 8% -> 12% (=Thaumaturge's + 2)
  - Computer: 70% -> 100%
- Crafts:
  - Magmatic Staff: Matter of Eternity -> Red Soul Matter
- Ender Generator energy output: 500 MRU/hit (20,000/kill) -> 5 MRU/hit (200/kill)
### Name changes
- Renamed Chaos / Magic -> Chaotic / Magical
- Renamed Elemental / Weak Elemental -> Crystalline / Weak Crystalline.
- Renamed weapon stats Knockback → Recoil
### Other changes
- Sorted the Creative Tabs
- Added removeClosestMRUCU command
- Renamed chat commands:
  - setMRU → setMRUClosestMRUCU
  - setBalance → setBalanceClosestMRUCU
- Changed chat command syntax:
  - /command → /essentialcraft (command) or /ec (command)
### Added
- Book of Knowledge: added more specific information about various Magician's Table upgrades.
- Book of Knowledge: clarified that Mithriline Crystals need to see the sky to operate.
- Book of Knowledge: expanded Weapon Bench entry.
### Removed features
- Removed flickering creative-tab icons; replaced them with simple items.
- Removed custom font from the Book of Knowledge; now uses the default Minecraft font.
- Removed alternative Main Menu GUIs.
- Removed automatic version checker; not needed with Curseforge/Modrinth
- Removed WAILA compatibility; planned to be rewritten.
- Removed ru_RU.lang; planned to be rewritten.
