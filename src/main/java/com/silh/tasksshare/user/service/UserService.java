package com.silh.tasksshare.user.service;

import com.silh.tasksshare.user.dto.UserDto;
import com.silh.tasksshare.user.entity.UserEntity;
import com.silh.tasksshare.user.exceptions.UserNotFoundException;
import com.silh.tasksshare.user.repository.UserRepository;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;

import static java.lang.String.format;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static UserEntity toUserEntity(@Nonnull UserDto userDto) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        return userEntity;
    }

    private static UserDto toUserDto(@Nonnull UserEntity userEntity) {
        final UserDto userDto = new UserDto();
        userDto.setName(userEntity.getName());
        userDto.setEmail(userEntity.getEmail());
        return userDto;
    }

    @Transactional
    @Nonnull
    public UserDto createUser(UserDto userDto) {
        final UserEntity userEntity = userRepository.save(toUserEntity(userDto));
        return toUserDto(userEntity);
    }

    @Nonnull
    public UserDto getUser(Long id) {
        return userRepository.findById(id)
                             .map(UserService::toUserDto)
                             .orElseThrow(() -> new UserNotFoundException(format("User with ID %s was not found.",
                                                                                 id)));
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
