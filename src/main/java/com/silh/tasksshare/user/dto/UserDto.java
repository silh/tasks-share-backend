package com.silh.tasksshare.user.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
}
