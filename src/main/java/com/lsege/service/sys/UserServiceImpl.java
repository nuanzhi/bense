package com.lsege.service.sys;

import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;
import com.lsege.entity.vo.URRelate;
import com.lsege.mapper.sys.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public List<Role> getRoleByUser(Long uId) {
        return userMapper.getRoleByUser(uId);
    }

    @Override
    @Transactional
    public void addUser(User user, List<Long> rIds) {
        userMapper.addUser(user);
        List<URRelate> urRelates = new ArrayList<>();
        for (Long rId:rIds){
            urRelates.add(new URRelate(user.getuId(),rId));
        }
        userMapper.addUserRole(urRelates);
    }
}
