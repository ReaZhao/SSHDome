package com.reazhao.service;

import java.util.List;

import com.reazhao.domain.Department;
import com.reazhao.domain.Employee;
import com.reazhao.domain.PageBean;


public interface EmployeeService {

	PageBean<Employee> findByPage(Integer currPage);

	List<Department> findAll();

	void saveSuccess(Employee employee);

	Employee findByDid(Integer eid);

	void deleteSuccess(Employee employee);

	void updateSuccess(Employee employee);
	
}	
