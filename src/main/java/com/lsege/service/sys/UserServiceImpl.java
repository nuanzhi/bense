package com.lsege.service.sys;

import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;
import com.lsege.entity.vo.URRelate;
import com.lsege.mapper.sys.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUsers(Integer pageNum,Integer pageSize) {
        return userMapper.getUsers(pageNum,pageSize);
    }

    @Override
    public Long getUserTotal() {
        return userMapper.getUserTotal();
    }

    @Override
    public List<Role> getRoleByUser(Long uId) {
        return userMapper.getRoleByUser(uId);
    }

    @Override
    @Transactional
    public User addUser(User user, List<Long> rIds) {
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setuStatus((long) 0);
        userMapper.addUser(user);
        List<URRelate> urRelates = new ArrayList<>();
        for (Long rId : rIds) {
            urRelates.add(new URRelate(user.getuId(), rId));
        }
        if (urRelates.size() != 0) {
            userMapper.addUserRole(urRelates);
        }
        return user;
    }

    @Override
    public User editUser(User user) {
        userMapper.editUser(user);
        return user;
    }

    @Override
    public List<Role> associatedRole(Long uId) {
        return userMapper.associatedRole(uId);
    }

    @Override
    @Transactional
    public void associatedRoleUpdate(Long uId, List<URRelate> urRelates) {
        userMapper.associatedRoleDel(uId);
        if (urRelates.size() != 0)
            userMapper.associatedRoleSave(urRelates);
    }
}
