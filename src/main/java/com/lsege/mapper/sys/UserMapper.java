package com.lsege.mapper.sys;

import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;
import com.lsege.entity.vo.URRelate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/19.
 */
@Mapper
@Repository(value = "userMapper")
public interface UserMapper {


    List<User> getUsers();

    List<Role> getRoleByUser(Long uId);

    Long addUser(User user);

    Long addUserRole(List<URRelate> urRelates);

}
