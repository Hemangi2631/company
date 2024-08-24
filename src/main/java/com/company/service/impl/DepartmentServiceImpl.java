package com.company.service.impl;

import com.company.entity.DepartmentEntity;
import com.company.repository.DepartmentEntityRepository;
import com.company.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentEntityRepository repository;

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        return repository.findAll();
    }




//    @Override
//    public List<DepartmentEntity> findByShopifyStoreUrl(String shopifyStoreUrl) {
//        return repository.findByShopifyStoreUrl(shopifyStoreUrl);
//    }
}