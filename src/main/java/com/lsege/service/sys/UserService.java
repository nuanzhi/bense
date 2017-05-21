package com.lsege.service.sys;

import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/20.
 */
public interface UserService {

    List<User> getUsers();

    List<Role> getRoleByUser(Long uId);

    void addUser(User user,List<Long> rIds);

}
