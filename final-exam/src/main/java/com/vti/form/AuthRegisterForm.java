package com.vti.form;

import com.vti.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegisterForm {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private Account.Role role;
    private Integer departmentId;
}
