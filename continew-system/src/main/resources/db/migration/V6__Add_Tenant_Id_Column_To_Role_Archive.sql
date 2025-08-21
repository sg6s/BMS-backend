-- 为角色归档表添加租户ID列
ALTER TABLE `sys_role_archive`
ADD COLUMN `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户ID' AFTER `update_user`;

-- 为租户ID列添加索引
CREATE INDEX `idx_role_archive_tenant_id` ON `sys_role_archive` (`tenant_id`);