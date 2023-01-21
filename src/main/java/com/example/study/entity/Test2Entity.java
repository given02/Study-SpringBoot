package com.example.study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Test2Entity {
    @Id
    @GeneratedValue
    private Long Idkeys;

    @OneToOne(mappedBy="test2Entity")
    TestEntity testEntity;
}
