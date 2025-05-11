package com.showmaster.show_master.service;
import java.util.Optional;

import com.showmaster.show_master.model.User;

public interface UserService {
    User registerUser(User user);
    Optional<User> findByUsername(String username);
    Optional<User> loginUser(String username, String password);
}
