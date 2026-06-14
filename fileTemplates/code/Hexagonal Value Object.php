<?php

declare(strict_types=1);

namespace App\\${MODULE}\\Domain\\ValueObject;

final readonly class ${NAME}
{
    public function __construct(
        private string \$value,
    ) {
        if (trim(\$value) === '') {
            throw new \InvalidArgumentException('${NAME} cannot be empty.');
        }
    }

    public function value(): string
    {
        return \$this->value;
    }

    public function equals(self \$other): bool
    {
        return \$this->value === \$other->value;
    }

    public function __toString(): string
    {
        return \$this->value;
    }
}
