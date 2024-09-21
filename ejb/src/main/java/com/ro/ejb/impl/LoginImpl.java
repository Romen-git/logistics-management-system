package com.ro.ejb.impl;

import com.ro.ejb.remote.Login;
import jakarta.ejb.Stateless;

@Stateless
public class LoginImpl implements Login {

    @Override
    public void login() {
        System.out.println("login");
    }
}
