package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service // 서비스 객체 생성
public class CoffeeService {
    // 게시글 리파지터리 객체 주입
    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee show(Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee create(CoffeeDto dto) {
        Coffee coffee = dto.toEntity();
        if (coffee.getId() != null) {
            return null;
        }
        return coffeeRepository.save(coffee);
    }

    public Coffee update(Long id, CoffeeDto dto) {
        // 1. DTO -> 엔티티 변환하기
        Coffee coffee = dto.toEntity();
        log.info("id: {}, coffee: {}", id, coffee.toString());
        // 2. 타깃 조회하기
        Coffee target = coffeeRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기
        if (target == null || id != coffee.getId()) {
            log.info("잘못된 요청! id: {}, coffee: {}", id, coffee.toString());
            return null;
        }
        // 4. 업데이트 및 정상 응답(200) 하기
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return updated;
    }

    public Coffee delete(Long id) {
        // 1. 대상 찾기
        Coffee target = coffeeRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if (target == null) {
            return null;
        }
        // 3. 대상 삭제하기
        coffeeRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Coffee> createCoffees(List<CoffeeDto> dtos) {
        // 1. dto 묶음을 엔티티 묶음으로 변환하기
        List<Coffee> coffeeList = dtos.stream().map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        // 2. 엔티티 묶음을 DB에 저장하기
        coffeeList.stream()
                .forEach(coffee -> coffeeRepository.save(coffee));
        // 3. 강제 예외 발생시키기
        coffeeRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("결제 실패!"));
        // 4. 결과 값 반환하기
        return coffeeList;
    }
}
