package com.pidev.backend.service;

import com.pidev.backend.entity.User;

public interface IUserService {
    public User ajoutuser(User u);
    public User afficheuser(String idu);
}
