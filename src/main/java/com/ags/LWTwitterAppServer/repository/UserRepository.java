package com.ags.LWTwitterAppServer.repository;

import com.ags.LWTwitterAppServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
