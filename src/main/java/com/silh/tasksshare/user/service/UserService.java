package com.silh.tasksshare.user.service;

import com.silh.tasksshare.user.dto.UserDto;
import com.silh.tasksshare.user.entity.UserEntity;
import com.silh.tasksshare.user.repository.UserRepository;

import javax.transaction.Transactional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDto createUser(UserDto userDto) {
        final UserEntity userEntity = userRepository.save(toUserEntity(userDto));
        return toUserDto(userEntity);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private static UserEntity toUserEntity(UserDto userDto) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        return userEntity;
    }

    private static UserDto toUserDto(UserEntity userEntity) {
        final UserDto userDto = new UserDto();
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        return userDto;
    }
}
