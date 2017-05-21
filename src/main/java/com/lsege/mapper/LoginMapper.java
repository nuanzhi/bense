package com.lsege.mapper;

import com.lsege.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@Mapper
@Repository(value = "loginMapper")
public interface LoginMapper {

    User login(String account);

}
