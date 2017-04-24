package com.lsege.mapper;

import com.lsege.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/24
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@Mapper
@Repository(value = "roleMapper")
public interface RoleMapper {

    /**
     * 获取该用户的角色
     * @param uId
     * @return
     */
    List<Role> getUserRoles(Long uId);

}
