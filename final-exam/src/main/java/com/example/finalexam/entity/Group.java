package com.example.finalexam.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_name", length = 50, unique = true, nullable = false)
    private String group_name;

    @Column(name = "member", nullable = false)
    private Integer member;

    @Column(name = "creator", length = 10, nullable = false)
    private String creator;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @CreationTimestamp
    @Column(name = "update_date", nullable = false, updatable = false)
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Account> accounts;
}
