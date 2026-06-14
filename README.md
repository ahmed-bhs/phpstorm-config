# PhpStorm Config

Personal PhpStorm setup: code style, inspections, file templates for hexagonal
architecture (Symfony DDD), shared scopes for Domain/Application/Infrastructure/Port
layers, editor/php settings.

## Install on a fresh PhpStorm

1. Close PhpStorm.
2. Clone this repo:
   ```bash
   git clone <repo-url> phpstorm-config
   cd phpstorm-config
   ```
3. Run:
   ```bash
   ./install.sh
   ```
   Optionally pass the version dir name, e.g. `./install.sh PhpStorm2025.2`.
4. Start PhpStorm.
5. Install plugins listed in `plugins.txt` (Settings > Plugins > Marketplace).

## What's included

- `codestyles/Default.xml` — PHP code style: 4-space indent, no tab chars,
  no assignment alignment, return type on new line.
- `inspection/Default.xml` — global inspection profile with PhpCSFixer and
  PHPStan validation enabled by default.
- `fileTemplates/code/` — "New File" templates for hexagonal building blocks:
  Command, Command Handler, Query, Query Handler, Domain Entity, Value Object,
  Port Out interface. Each asks for `MODULE` and `NAME`.
- `options/scopes/scopes.xml` — named scopes matching `src/{Module}/{Layer}/...`
  convention (Domain, Application, Infrastructure, Port Out, Port In (Bus),
  Adapter In/Out, UseCase Command/Query, etc). Used for File Colors and
  navigation filters.
- `options/editor.xml` — strip trailing whitespace, ensure final newline,
  reformat on paste.
- `options/php.xml` — PHP smart keys settings.

## Per-project File Colors

File Colors (the colored editor tabs/file tree rows per scope) are stored per
project in `.idea/workspace.xml`. To enable them in a new project, add to its
`.idea/workspace.xml`:

```xml
<component name="FileColors">
  <fileColor scope="Shared Module" color="ROSE" />
  <fileColor scope="Bounded Context Modules" color="BLUE" />
</component>
```

`Shared Module` (`src/Shared/...`) is rose, every other bounded context
module (`src/{Module}/...`) shares the same blue. `Shared Module` must come
first so it takes priority over `Bounded Context Modules` for files under
`src/Shared/`.

This requires the scopes from `options/scopes/scopes.xml` to be installed
globally first (step 3 above).
