package com.example.study.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TestEntity {

    @Id
    @GeneratedValue
    private Long Idkeys;

    @Column(nullable = false, length = 45)
    private String content;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="test2Entity")
    private Test2Entity test2Entity;

}
