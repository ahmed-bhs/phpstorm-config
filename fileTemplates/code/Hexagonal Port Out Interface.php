<?php

declare(strict_types=1);

namespace App\\${MODULE}\\Domain\\Port\\Out;

interface ${NAME}RepositoryInterface
{
    public function save(${NAME} \$entity): void;

    public function find(string \$id): ?${NAME};
}
