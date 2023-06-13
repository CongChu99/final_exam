package com.example.finalexam.repository;

import com.example.finalexam.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGroupRepository extends JpaRepository<Group, Integer> {
}
