package com.reazhao.dao;

import java.util.List;

import com.reazhao.domain.Department;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void saveInfo(Department department);

	Department findByDid(Integer did);

	void updateSuccess(Department department);

	void deleteSuccess(Department department);

}
