package com.good.service;

import com.good.model.User;

import java.util.List;

/**
 * Created by dai on 2017/2/16.
 */
public interface UserService {
    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);

}
