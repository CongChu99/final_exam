package com.example.finalexam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GroupDto {
    @JsonProperty("groupId")
    private Integer id;
    private String group_name;
    private Integer member;
    private String creator;
    private LocalDateTime createdDate;

    @Getter
    @Setter
    public static class AccountDto {
        @JsonProperty("accountId")
        private Integer id;
        private String username;
    }
}
