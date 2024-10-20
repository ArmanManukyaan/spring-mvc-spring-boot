package org.example.mvcspringboot.service;

import lombok.RequiredArgsConstructor;
import org.example.mvcspringboot.entity.User;
import org.example.mvcspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> listUser = userRepository.findAll();
        return listUser.isEmpty() ? Collections.emptyList() : listUser;
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void update(User user) {
        Optional<User> userById = userRepository.findById(user.getId());
        userById.ifPresent(u -> {
            u.setName(user.getName());
            u.setAge(user.getAge());
            userRepository.save(u);
        });
    }

    @Override
    public void deleteById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}