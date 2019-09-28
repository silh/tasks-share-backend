package com.silh.tasksshare.user.repository;


import com.silh.tasksshare.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
