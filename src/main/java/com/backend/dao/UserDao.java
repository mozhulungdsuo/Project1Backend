package com.backend.dao;

import org.springframework.stereotype.Service;

import com.backend.model.*;
//

public interface UserDao {
public void insertUser(User user);
public void deleteUser(User user);
}
