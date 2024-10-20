package org.example.mvcspringboot.service;

import org.example.mvcspringboot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);
    List<User> findAll();
    Optional <User> findById(int id);
    void update(User user);
    void deleteById(int id);
}