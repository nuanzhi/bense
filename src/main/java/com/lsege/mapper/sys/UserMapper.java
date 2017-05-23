package com.lsege.mapper.sys;

import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;
import com.lsege.entity.vo.URRelate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/19.
 */
@Mapper
@Repository(value = "userMapper")
public interface UserMapper {


    List<User> getUsers(@Param("startCount") Integer startCount, @Param("pageSize") Integer pageSize);

    Long getUserTotal();

    List<Role> getRoleByUser(Long uId);

    Long addUser(User user);

    Long editUser(User user);

    Long addUserRole(List<URRelate> urRelates);

    Long removeUser(Long uId);

    Long removeURRelate(Long uId);

    List<Role> associatedRole(Long uId);

    Long associatedRoleDel(Long uId);

    Long associatedRoleSave(List<URRelate> urRelates);

}
