package com.taskflow.studentmanagement.mapper;

import org.springframework.stereotype.Component;

import com.taskflow.studentmanagement.dto.request.DepartmentRequest;
import com.taskflow.studentmanagement.dto.response.DepartmentResponse;
import com.taskflow.studentmanagement.entity.Department;

@Component
public class DepartmentMapper {

    public DepartmentResponse toResponse(Department department) {
        return DepartmentResponse.builder()
            .id(department.getId())
            .name(department.getName())
            .code(department.getCode())
            .description(department.getDescription())
            .build();
    }

    public Department toEntity(DepartmentRequest request) {
        return Department.builder()
            .name(request.getName())
            .code(request.getCode())
            .description(request.getDescription())
            .build();
    }

    public void updateFromRequest(DepartmentRequest request, Department department) {
        if (request == null || department == null) {
            return;
        }
        if (request.getName() != null) {
            department.setName(request.getName());
        }
        if (request.getCode() != null) {
            department.setCode(request.getCode());
        }
        if (request.getDescription() != null) {
            department.setDescription(request.getDescription());
        }
    }
}
