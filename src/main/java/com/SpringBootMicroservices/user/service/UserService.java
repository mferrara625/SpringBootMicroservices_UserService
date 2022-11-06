package com.SpringBootMicroservices.user.service;

import com.SpringBootMicroservices.user.VO.Department;
import com.SpringBootMicroservices.user.VO.ResponseTemplateVO;
import com.SpringBootMicroservices.user.entity.User1;
import com.SpringBootMicroservices.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User1 saveUser(User1 user1) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user1);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User1 user1 = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user1.getDepartmentId(), Department.class);

        vo.setUser1(user1);
        vo.setDepartment(department);

        return vo;

    }
}
