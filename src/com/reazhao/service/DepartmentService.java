package com.reazhao.service;

import com.reazhao.domain.Department;
import com.reazhao.domain.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void saveInfo(Department department);

	Department findByDid(Integer did);

	void updateSuccess(Department department);

	void deleteSuccess(Department department);

}
