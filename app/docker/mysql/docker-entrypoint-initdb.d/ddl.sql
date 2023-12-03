CREATE TABLE IF NOT EXISTS `room`.`devices` (
    `room` INT,
    `device_id` VARCHAR(32),
    `status` BOOLEAN,
    PRIMARY KEY (`room`, `device_id`)
);

INSERT INTO `room`.`devices`(`room`,`device_id`,`status`) 
VALUES (828, 'ML001', TRUE), (828, 'BL001', FALSE);