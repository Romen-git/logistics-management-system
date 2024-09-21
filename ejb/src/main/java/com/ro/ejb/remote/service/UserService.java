package com.ro.ejb.remote.service;

import jakarta.ejb.Remote;

@Remote
public interface UserService {

    Boolean registerUser(String password, String email, String name, String phoneNumber, Integer role);

    Boolean loginUser(String password, String email);

}
