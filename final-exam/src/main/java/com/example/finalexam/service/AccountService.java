package com.example.finalexam.service;

import com.example.finalexam.dto.AccountDto;
import com.example.finalexam.entity.Account;
import com.example.finalexam.form.AccountFilterForm;
import com.example.finalexam.repository.IAccountRepository;
import com.example.finalexam.specification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;

    private ModelMapper mapper;

    @Override
    public Page<AccountDto> findAll(AccountFilterForm form, Pageable pageable) {
        Specification<Account> spec = AccountSpecification.buildSpec(form);
        return repository.findAll(spec, pageable)
                .map(account -> mapper.map(account, AccountDto.class));
    }

    @Override
    public Account findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Account account){
        repository.save(account);
    }

    @Override
    public void update(Account account){
        repository.save(account);
    }

    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        repository.deleteAllById(ids);
    }
}
