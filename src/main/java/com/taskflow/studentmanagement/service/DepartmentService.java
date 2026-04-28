package com.taskflow.studentmanagement.service;

import java.util.List;

import com.taskflow.studentmanagement.dto.request.DepartmentRequest;
import com.taskflow.studentmanagement.dto.response.DepartmentResponse;

public interface DepartmentService {


    DepartmentResponse create(DepartmentRequest request);
    DepartmentResponse getById(Integer id);
    List<DepartmentResponse> getAll();
    DepartmentResponse update(Integer id, DepartmentRequest request);
    void delete(Integer id);


}
