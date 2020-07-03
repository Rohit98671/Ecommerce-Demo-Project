package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.Admin;
import com.ecommerce.OnlineShopping.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin accessAdmin(String uname, String pword) {
        return adminMapper.findAdmin(uname, pword);
    }

}
