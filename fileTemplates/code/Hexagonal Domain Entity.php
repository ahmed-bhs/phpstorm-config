<?php

declare(strict_types=1);

namespace App\\${MODULE}\\Domain\\Entity;

final class ${NAME}
{
    private function __construct(
        private readonly string \$id,
    ) {
    }

    public static function create(string \$id): self
    {
        return new self(\$id);
    }

    public function id(): string
    {
        return \$this->id;
    }
}
