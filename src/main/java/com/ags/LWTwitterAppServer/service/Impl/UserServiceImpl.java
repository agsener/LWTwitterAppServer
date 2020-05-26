package com.ags.LWTwitterAppServer.service.Impl;

import com.ags.LWTwitterAppServer.dto.UserDto;
import com.ags.LWTwitterAppServer.entity.User;
import com.ags.LWTwitterAppServer.repository.UserRepository;
import com.ags.LWTwitterAppServer.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getById(Long id) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }
}
