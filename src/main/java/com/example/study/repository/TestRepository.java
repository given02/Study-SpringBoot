package com.example.study.repository;

import com.example.study.entity.TestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long> {

    @Query(value="select p.content from TestEntity p where p.Idkeys = :number")
    public String findIdQuery(@Param("number") Long keys);

    public List<TestEntity> findByContent(String content);

    @Transactional
    @Modifying
    @Query(value="delete from TestEntity p where p.Idkeys = :number")
    public int deleteTest(@Param("number") Long keys);

    @Transactional
    @Modifying
    @Query(value="UPDATE TestEntity p set p.content='changeData' where p.Idkeys = :number")
    public int modifyTest(@Param("number") Long keys);
}
