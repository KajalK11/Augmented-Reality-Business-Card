package com.kajalk11.AR.BUSINESS.CARD.user.service;

import com.kajalk11.AR.BUSINESS.CARD.user.model.User;

import java.util.List;
import java.util.Optional;

public interface Userimpl {

    User CreateUser(User user);

    List<User> getALLUser();

    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User getUserByEmail(String email);
    User updateUser(long id, User userDetails);
    void deleteUser(long id);

}
