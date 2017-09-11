package com.reazhao.dao;

import java.util.List;

import com.reazhao.domain.Department;
import com.reazhao.domain.Employee;

public interface EmployeeDao {

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	List<Department> findAll();

	void saveSuccess(Employee employee);

	Employee findByDid(Integer eid);

	void deleteSuccess(Employee employee);

	void updateSuccess(Employee employee);

}
