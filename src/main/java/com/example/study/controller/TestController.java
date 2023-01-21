package com.example.study.controller;

import com.example.study.dto.EntityDTO;
import com.example.study.entity.Test2Entity;
import com.example.study.entity.TestEntity;
import com.example.study.repository.TestRepository;
import com.example.study.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    TestRepository testRepository;

    @PostMapping(value = "/data/{stringData}")
    public String addNewData(@RequestBody EntityDTO request, @PathVariable String stringData) {

        TestEntity te = testService.saveNewData(stringData);
//        TestEntity te = testService.saveNewData(request.getContent());
        return "데이터를 성공적으로 저장했습니다. 키값 : " + te.getIdkeys();
    }

    @GetMapping(value = "/data/{keys}")
    public String getData(@PathVariable Long keys) {
        String content = testService.getData(keys).getContent();
        return content;
    }

    @RequestMapping(value = "/testMethod" , method = RequestMethod.GET)
    public void unknownMethod() {
        TestEntity abcs = new TestEntity();
        abcs.setContent("abc");

        TestEntity tea = testRepository.save(abcs); // 값을 저장하는 데이터
        TestEntity te = testRepository.findById(tea.getIdkeys()).get(); // Repository에서 찾은 값은 자동으로 영속 컨테이너에 들어가 있습니다.

        Test2Entity te2 = new Test2Entity(); // 영속 컨테이너에 들어가 있지 않은 상태
        te.setTest2Entity(te2); // 영속성 컨테이너에 자동으로 포함시키는 cascade 가 설정되어 있어야합니다.
    }

    @RequestMapping(value = "/findIds/{keys}" , method = RequestMethod.GET)
    public String getDataDataData(@PathVariable Long keys) {
        return testRepository.findIdQuery(keys); //  해당 키값에 해당하는 데이터를 반환합니다.
    }

    @RequestMapping(value = "/modify/{keys}" , method = RequestMethod.GET)
    public int modifyData(@PathVariable Long keys) {
        return testRepository.modifyTest(keys); // 수정문이며 수정된 값을 확인할 수 있습니다.
    }

    @RequestMapping(value = "/delete/{keys}" , method = RequestMethod.GET)
    public int deleteData(@PathVariable Long keys) {
        return testRepository.deleteTest(keys); // 삭제문이며 값을 삭제할 수 있습니다.
    }

    @RequestMapping(value = "/contents/{data}" , method = RequestMethod.GET)
    public List<TestEntity> contentscontents(@PathVariable String data) {
        return testRepository.findByContent(data); // Content의 값으로 탐색을 진행합니다.
    }


}
