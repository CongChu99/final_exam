package com.example.finalexam.dto;

import com.example.finalexam.entity.Group;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AccountDto {
    private Integer id;
    private String username;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private String groupGroup_name;
}
