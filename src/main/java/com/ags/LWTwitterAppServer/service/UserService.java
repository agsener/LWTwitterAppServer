package com.ags.LWTwitterAppServer.service;

import com.ags.LWTwitterAppServer.dto.UserDto;
import com.ags.LWTwitterAppServer.entity.User;

public interface UserService {

    UserDto getById(Long id);

    User getUserById(Long id);
}
