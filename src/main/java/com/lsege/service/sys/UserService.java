package com.lsege.service.sys;

import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;
import com.lsege.entity.vo.URRelate;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/20.
 */
public interface UserService {

    List<User> getUsers(Integer pageNum,Integer pageSize);

    Long getUserTotal();

    List<Role> getRoleByUser(Long uId);

    User addUser(User user,List<Long> rIds);

    User editUser(User user);

    List<Role> associatedRole(Long uId);

    void associatedRoleUpdate(Long uId, List<URRelate> urRelates);

}
