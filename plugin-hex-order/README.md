# Hex Layer Order

PhpStorm/IntelliJ plugin: forces `Infrastructure`, `Application`, `Domain`
folders to appear in this order in the Project tree (instead of alphabetical).

## Build

```bash
./gradlew buildPlugin
```

Output: `build/distributions/hex-layer-order-1.0.0.zip`

## Install

Settings > Plugins > gear icon > Install Plugin from Disk > select the zip,
then restart PhpStorm.

## How it works

`HexLayerTreeStructureProvider` wraps `Infrastructure`/`Application`/`Domain`
directory nodes and overrides `getTypeSortWeight()` (10/20/30) so the
Project view's type comparator orders them Infrastructure, Application,
Domain regardless of name.

## Rebuilding for a new PhpStorm version

Bump `version.set("2025.2")` in `build.gradle.kts` to match the target
PhpStorm version, then `./gradlew buildPlugin` again.
