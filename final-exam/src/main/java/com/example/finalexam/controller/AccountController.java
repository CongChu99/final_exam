package com.example.finalexam.controller;

import com.example.finalexam.dto.AccountDto;
import com.example.finalexam.entity.Account;
import com.example.finalexam.form.AccountFilterForm;
import com.example.finalexam.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<AccountDto> findAll(AccountFilterForm form, Pageable pageable) {
        return service.findAll(form, pageable);
    }

    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable("id") Integer id) {
        Account account = service.findById(id);
        AccountDto dto = mapper.map(account, AccountDto.class);
        return dto;
    }

    @PostMapping
    public void create(@RequestBody Account account){
        service.create(account);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Account account){
        account.setId(id);
        service.update(account);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable  Integer id){
        service.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllById(@RequestBody List<Integer> ids) {
        service.deleteAllById(ids);
    }
}
