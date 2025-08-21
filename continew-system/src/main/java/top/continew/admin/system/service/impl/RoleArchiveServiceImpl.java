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

package top.continew.admin.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import top.continew.admin.common.context.UserContextHolder;
import top.continew.admin.system.mapper.RoleArchiveMapper;
import top.continew.admin.system.mapper.RoleMapper;
import top.continew.admin.system.model.entity.RoleArchiveDO;
import top.continew.admin.system.model.entity.RoleDO;
import top.continew.admin.system.service.RoleArchiveService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * 角色归档业务实现
 *
 * @author Charles7c
 * @since 2023/2/8 22:54
 */
@Service
@RequiredArgsConstructor
public class RoleArchiveServiceImpl implements RoleArchiveService {

    private final RoleArchiveMapper baseMapper;
    private final RoleMapper roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void archiveRole(Long roleId) {
        // 获取角色信息
        RoleDO roleDO = roleMapper.selectById(roleId);
        if (roleDO == null) {
            return;
        }

        // 创建归档对象
        RoleArchiveDO archiveDO = new RoleArchiveDO();
        BeanUtil.copyProperties(roleDO, archiveDO);

        // 设置归档信息
        archiveDO.setOriginalId(roleId);
        archiveDO.setArchiveTime(LocalDateTime.now());
        Long currentUserId = UserContextHolder.getUserId();
        archiveDO.setArchiveUserId(currentUserId);
        archiveDO.setArchiveUserName(UserContextHolder.getNickname());

        // 保存归档记录
        baseMapper.insert(archiveDO);
    }

    @Override
    public BaseMapper<RoleArchiveDO> getBaseMapper() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBaseMapper'");
    }

    @Override
    public Class<RoleArchiveDO> getEntityClass() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEntityClass'");
    }

    @Override
    public Map<String, Object> getMap(Wrapper<RoleArchiveDO> queryWrapper) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMap'");
    }

    @Override
    public <V> V getObj(Wrapper<RoleArchiveDO> queryWrapper, Function<? super Object, V> mapper) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getObj'");
    }

    @Override
    public RoleArchiveDO getOne(Wrapper<RoleArchiveDO> queryWrapper, boolean throwEx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOne'");
    }

    @Override
    public Optional<RoleArchiveDO> getOneOpt(Wrapper<RoleArchiveDO> queryWrapper, boolean throwEx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOneOpt'");
    }

    @Override
    public boolean saveBatch(Collection<RoleArchiveDO> entityList, int batchSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveBatch'");
    }

    @Override
    public boolean saveOrUpdate(RoleArchiveDO entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveOrUpdate'");
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<RoleArchiveDO> entityList, int batchSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveOrUpdateBatch'");
    }

    @Override
    public boolean updateBatchById(Collection<RoleArchiveDO> entityList, int batchSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBatchById'");
    }
}