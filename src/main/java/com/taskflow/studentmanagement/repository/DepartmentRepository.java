package com.taskflow.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskflow.studentmanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
