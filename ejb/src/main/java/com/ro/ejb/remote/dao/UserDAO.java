package com.ro.ejb.remote.dao;

import com.ro.ejb.entity.Location;
import com.ro.ejb.entity.User;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface UserDAO {

    User findById(Long id);
    List<User> findAll();
    Boolean save(User user);
    Boolean update(User user);
    Boolean delete(User user);

    User findUserByEmail(String email);

}
