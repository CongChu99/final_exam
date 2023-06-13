package com.example.finalexam.service;

import com.example.finalexam.entity.Group;
import com.example.finalexam.repository.IGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private IGroupRepository repository;

    @Override
    public Page<Group> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Override
    public Group findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Group group){
        repository.save(group);
    }

    @Override
    public void update(Group group){
        repository.save(group);
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
