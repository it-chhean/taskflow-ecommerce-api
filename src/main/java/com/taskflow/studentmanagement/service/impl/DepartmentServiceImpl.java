package com.taskflow.studentmanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskflow.studentmanagement.dto.request.DepartmentRequest;
import com.taskflow.studentmanagement.dto.response.DepartmentResponse;
import com.taskflow.studentmanagement.entity.Department;
import com.taskflow.studentmanagement.exception.ResourceNotFoundException;
import com.taskflow.studentmanagement.mapper.DepartmentMapper;
import com.taskflow.studentmanagement.repository.DepartmentRepository;
import com.taskflow.studentmanagement.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    
    @Override
    public DepartmentResponse create(DepartmentRequest request) {
        Department department = departmentMapper.toEntity(request);
        return departmentMapper.toResponse(departmentRepository.save(department));
    }
    
    
    @Override
    public DepartmentResponse getById(Integer id) {
        Department department = departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found with id:" + id ));
        return departmentMapper.toResponse(department);
    }
    
    
    @Override
    public List<DepartmentResponse> getAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(departmentMapper::toResponse)
                .toList();
    }
    
    
    @Override
    public DepartmentResponse update(Integer id, DepartmentRequest request) {
        Department department = departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found with id:" + id ));
        departmentMapper.updateFromRequest(request, department);
        return departmentMapper.toResponse(departmentRepository.save(department));
    }
    
    
    @Override
    public void delete(Integer id) {
        Department department = departmentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Department not found with id:" + id ));
        departmentRepository.delete(department);
    }
    
    
}
