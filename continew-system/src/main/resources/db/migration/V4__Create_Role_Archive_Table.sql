-- 创建角色归档表
CREATE TABLE `sys_role_archive` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `original_id` bigint NOT NULL COMMENT '原角色ID',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `code` varchar(20) NOT NULL COMMENT '角色编码',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `data_scope` tinyint NOT NULL DEFAULT 1 COMMENT '数据权限（1：全部数据权限 2：自定义数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `is_system` tinyint NOT NULL DEFAULT 0 COMMENT '是否系统内置角色（0：否 1：是）',
  `is_enabled` tinyint NOT NULL DEFAULT 1 COMMENT '是否启用（0：禁用 1：启用）',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
  `archive_time` datetime NOT NULL COMMENT '归档时间',
  `archive_user_id` bigint NOT NULL COMMENT '归档人ID',
  `archive_user_name` varchar(20) NOT NULL COMMENT '归档人姓名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  KEY `idx_original_id` (`original_id`),
  KEY `idx_archive_time` (`archive_time`),
  KEY `idx_archive_user_id` (`archive_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色归档表';