package com.task.Respository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.task.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {}

