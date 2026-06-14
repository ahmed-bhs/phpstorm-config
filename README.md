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
- `options/editor.xml` — strip trailing whitespace, ensure final newline,
  reformat on paste.
- `options/php.xml` — PHP smart keys settings.
- `idea-template/scopes/Hexagonal_Architecture.xml` — named scopes matching
  `src/{Module}/{Layer}/...` convention (Domain, Application, Infrastructure,
  Port Out, Port In (Bus), Adapter In/Out, UseCase Command/Query, etc).

## Per-project setup (scopes + File Colors)

Scopes must be defined per-project (global scopes file did not get picked up
reliably). For each new project:

1. Copy `idea-template/scopes/Hexagonal_Architecture.xml` into the project's
   `.idea/scopes/` directory.
2. Add to the project's `.idea/workspace.xml`:

```xml
<component name="FileColors">
  <fileColor scope="Domain" color="5c960e" />
  <fileColor scope="Infrastructure" color="0f81c1" />
</component>
```

`Domain` files are green (`#5c960e`), `Infrastructure` files are blue
(`#0f81c1`). Custom hex colors are passed as 6-digit hex without `#`.
Restart PhpStorm after adding the scopes file.
