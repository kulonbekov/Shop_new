package com.company.db;

import com.company.models.Employee;

import java.util.List;

public interface DBEmployee {

    void insertEmployee(Employee employee);

    List<Employee> selectAllEmployee();

    void updateEmployee(Long id, int numberEmployee, String name, int age);

    void deleteEmployee(Long id);

}
