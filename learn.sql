CREATE TABLE `user`
(
    `user_id`   BIGINT unsigned NOT NULL AUTO_INCREMENT,
    `user_name` varchar(50) NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `health_record`
(
    `record_id` BIGINT unsigned NOT NULL AUTO_INCREMENT,
    `user_id`   BIGINT unsigned NOT NULL,
    `level_id`  BIGINT unsigned NOT NULL,
    `remark`    varchar(50) NOT NULL,
    PRIMARY KEY (`record_id`)
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `health_level`
(
    `level_id`   BIGINT unsigned NOT NULL AUTO_INCREMENT,
    `level_name` varchar(50) NOT NULL,
    PRIMARY KEY (`level_id`)
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `health_task`
(
    `task_id`   BIGINT unsigned NOT NULL AUTO_INCREMENT,
    `record_id` BIGINT unsigned NOT NULL,
    `user_id`   BIGINT unsigned NOT NULL,
    `task_name` varchar(50) NOT NULL,
    PRIMARY KEY (`task_id`)
) ENGINE=InnoDB CHARSET=utf8mb4;
