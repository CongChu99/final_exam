package com.example.finalexam.service;

import com.example.finalexam.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGroupService {
    Page<Group> findAll(Pageable pageable);

    Group findById(Integer id);

    void create(Group group);

    void update(Group group);

    void deleteById(Integer id);

    void deleteAllById(List<Integer> ids);
}
