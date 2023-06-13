package com.example.finalexam.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @CreationTimestamp
    @Column(name = "update_date", nullable = false, updatable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
