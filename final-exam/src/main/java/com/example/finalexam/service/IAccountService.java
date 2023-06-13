package com.example.finalexam.service;

import com.example.finalexam.dto.AccountDto;
import com.example.finalexam.entity.Account;
import com.example.finalexam.form.AccountFilterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAccountService {
    Page<AccountDto> findAll(AccountFilterForm form, Pageable pageable);

    Account findById(Integer id);

    void create(Account account);

    void update(Account account);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
