package com.example.finalexam.controller;

import com.example.finalexam.dto.GroupDto;
import com.example.finalexam.entity.Group;
import com.example.finalexam.service.IGroupService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    @Autowired
    private IGroupService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<GroupDto> findAll(Pageable pageable){
        Page<Group> groups = service.findAll(pageable);
        return groups.map(group -> {
            return mapper.map(group, GroupDto.class);
        });
    }

    @GetMapping("/{id}")
    public GroupDto findById(@PathVariable("id") Integer id) {
        Group group = service.findById(id);
        GroupDto dto = mapper.map(group, GroupDto.class);
        return dto;
    }

    @PostMapping
    public void create(@RequestBody Group group){
        service.create(group);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Group group){
        group.setId(id);
        service.update(group);
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
