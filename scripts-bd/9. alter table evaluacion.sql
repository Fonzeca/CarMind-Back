ALTER TABLE `evaluacion` ADD `empresa_id` INT NOT NULL AFTER `nombre`;

ALTER TABLE `evaluacion` ADD CONSTRAINT `empresa_evaluacion` FOREIGN KEY (`empresa_id`) REFERENCES `empresa`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;