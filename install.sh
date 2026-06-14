#!/usr/bin/env bash
set -euo pipefail

# Usage: ./install.sh [PhpStormVersion]
# Example: ./install.sh PhpStorm2025.2
# If no version given, picks the most recent PhpStormXXXX.X dir under ~/.config/JetBrains

CONFIG_ROOT="$HOME/.config/JetBrains"

if [ "${1:-}" != "" ]; then
    VERSION="$1"
else
    VERSION=$(find "$CONFIG_ROOT" -maxdepth 1 -type d -name "PhpStorm*" | sort -V | tail -n1 | xargs basename)
fi

TARGET="$CONFIG_ROOT/$VERSION"
SRC="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "Installing PhpStorm config into: $TARGET"
mkdir -p "$TARGET"

echo "-> codestyles"
mkdir -p "$TARGET/codestyles"
cp "$SRC/codestyles/Default.xml" "$TARGET/codestyles/"

echo "-> inspection profile (global default)"
mkdir -p "$TARGET/inspection"
cp "$SRC/inspection/Default.xml" "$TARGET/inspection/"

echo "-> file templates (hexagonal architecture)"
mkdir -p "$TARGET/fileTemplates/code"
cp "$SRC/fileTemplates/code/"*.php "$TARGET/fileTemplates/code/"

echo "-> scopes"
mkdir -p "$TARGET/options/scopes"
cp "$SRC/options/scopes/scopes.xml" "$TARGET/options/scopes/"

echo "-> editor / php options"
mkdir -p "$TARGET/options"
cp "$SRC/options/editor.xml" "$TARGET/options/"
cp "$SRC/options/php.xml" "$TARGET/options/"

if [ -f "$SRC/keymaps/Default copy.xml" ]; then
    echo "-> keymap"
    mkdir -p "$TARGET/keymaps"
    cp "$SRC/keymaps/Default copy.xml" "$TARGET/keymaps/"
fi

echo ""
echo "Done. Restart PhpStorm to load the new settings."
echo "Then install plugins listed in plugins.txt via Settings > Plugins > Marketplace,"
echo "or run: ./install-plugins.sh"
