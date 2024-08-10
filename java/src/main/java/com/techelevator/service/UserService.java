package com.techelevator.service;


import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //TODO use this class to call on users if needed

private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int getUserIdByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        if (user != null) {
            return user.getId();
        }
        throw new UsernameNotFoundException("User not found" + username);
    }
}
