package com.ro.ejb.impl.service;

import com.ro.ejb.annotation.LogUserActivity;
import com.ro.ejb.entity.User;
import com.ro.ejb.remote.dao.UserDAO;
import com.ro.ejb.remote.service.UserService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;

@Stateless
@LogUserActivity
public class UserServiceImpl implements UserService {

    @EJB
    private UserDAO userDAO;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Boolean registerUser(String password, String email, String name, String phoneNumber, Integer role) {
        if (userDAO.findUserByEmail(email) != null) {
            throw new IllegalArgumentException("Email already in use.");
        }
        User user = new User(password, email, name, phoneNumber, role);

        return userDAO.save(user);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Boolean loginUser(String password, String email) {
        User user = userDAO.findUserByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
