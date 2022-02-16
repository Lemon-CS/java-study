package com.lemon.mp.generator.user.service.impl;

import com.lemon.mp.generator.user.entity.User;
import com.lemon.mp.generator.user.mapper.UserMapper;
import com.lemon.mp.generator.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zimu
 * @since 2022-02-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
