ALTER TABLE `tipo_pregunta` ADD `info` VARCHAR(200) NOT NULL AFTER `codigo`;
UPDATE `tipo_pregunta` SET `info` = 'El conductor puede sacar una foto' WHERE `tipo_pregunta`.`codigo` = 'F';
UPDATE `tipo_pregunta` SET `info` = 'El conductor puede marcar con tick o cruz en cada opción individualmente' WHERE `tipo_pregunta`.`codigo` = 'S1';
UPDATE `tipo_pregunta` SET `info` = 'El conductor puede marcar con tick o cruz' WHERE `tipo_pregunta`.`codigo` = 'S3';
UPDATE `tipo_pregunta` SET `info` = 'El conductor puede dejar algo escrito' WHERE `tipo_pregunta`.`codigo` = 'TX';