/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.system.model.resp.role;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.continew.admin.common.enums.DataScopeEnum;
import top.continew.starter.excel.converter.ExcelBaseEnumConverter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 角色导出响应参数
 *
 * @author Charles7c
 * @since 2023/2/8 23:11
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "角色导出响应参数")
public class RoleExportResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Schema(description = "ID", example = "1")
    @ExcelProperty(value = "ID")
    private Long id;

    /**
     * 角色名称
     */
    @Schema(description = "角色名称", example = "管理员")
    @ExcelProperty(value = "角色名称")
    private String name;

    /**
     * 角色编码
     */
    @Schema(description = "角色编码", example = "admin")
    @ExcelProperty(value = "角色编码")
    private String code;

    /**
     * 数据权限
     */
    @Schema(description = "数据权限", example = "1")
    @ExcelProperty(value = "数据权限", converter = ExcelBaseEnumConverter.class)
    private DataScopeEnum dataScope;

    /**
     * 角色描述
     */
    @Schema(description = "角色描述", example = "系统管理员")
    @ExcelProperty(value = "角色描述")
    private String description;

    /**
     * 排序
     */
    @Schema(description = "排序", example = "1")
    @ExcelProperty(value = "排序")
    private Integer sort;

    /**
     * 是否为系统内置角色
     */
    @Schema(description = "是否为系统内置角色", example = "false")
    @ExcelProperty(value = "是否为系统内置角色")
    private Boolean isSystem;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间", example = "2023-08-08 08:08:08", type = "string")
    @ExcelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @Schema(description = "创建人", example = "admin")
    @ExcelProperty(value = "创建人")
    private String createUserString;
}