ALTER TABLE `sys_resource` ADD INDEX `RESOURCE_CODE_URL`(`resource_code`, `url`) USING HASH COMMENT '资源code和url的联合索引';