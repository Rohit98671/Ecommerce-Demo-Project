package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.ProductExample;
import com.ecommerce.OnlineShopping.domain.Users;
import com.ecommerce.OnlineShopping.domain.UsersExample;
import com.ecommerce.OnlineShopping.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UsersMapper usersMapper;

    public Users getByUsername(String uname) {
        return usersMapper.selectByPrimaryKey(uname);
    }

    public void saveOrUpdateUser(Users users) {
        if (users.getUsername() != null){
            usersMapper.updateByPrimaryKey(users);
        } else {
            usersMapper.insert(users);
        }
    }

    public Users accessUser(String username, String password) {
        return usersMapper.findUser(username, password);
    }

}
