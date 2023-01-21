package com.example.study.service;

import com.example.study.repository.TestRepository;
import com.example.study.entity.TestEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TestService {

    @Autowired
    TestRepository testRepos;

    public TestEntity saveNewData(String content){
        TestEntity te = new TestEntity();
        te.setContent(content);

        return testRepos.save(te);
    }

    public TestEntity getData(Long keys){
        TestEntity te = testRepos.findById(keys).get();

        return te;
    }

}
