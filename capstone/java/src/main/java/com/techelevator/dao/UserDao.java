package com.techelevator.dao;

import com.techelevator.model.PasswordChangeDTO;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    void switchFirstTime(User user);

    void changePassword(PasswordChangeDTO user);

    boolean create(String username, String password, String role);

    boolean createWithAppId(String username, String password, String role, int applicationId);

    void updateRole(int applicationId, String newRole);

    User getUserByApplicationId(int applicationId);
}
