-- 添加菜单和部门选择关联列
ALTER TABLE `sys_role_archive`
ADD COLUMN `menu_check_strictly` tinyint NOT NULL DEFAULT 0 COMMENT '菜单选择是否父子节点关联（0：否 1：是）' AFTER `is_system`,
ADD COLUMN `dept_check_strictly` tinyint NOT NULL DEFAULT 0 COMMENT '部门选择是否父子节点关联（0：否 1：是）' AFTER `menu_check_strictly`;

-- 更新现有数据的默认值
UPDATE `sys_role_archive` SET `menu_check_strictly` = 0, `dept_check_strictly` = 0 WHERE `menu_check_strictly` IS NULL;