package com.reazhao.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.reazhao.dao.EmployeeDao;
import com.reazhao.domain.Department;
import com.reazhao.domain.Employee;
import com.reazhao.domain.PageBean;
import com.reazhao.service.EmployeeService;

/**
 * 员工管理的service借口的实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	/**
	 * 查询员工分页
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页显示的记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页显示的数据
		int begin = (currPage - 1) * +pageSize;
		List<Employee> list = employeeDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 查询所有部门
	 */
	@Override
	public List<Department> findAll() {
		return employeeDao.findAll();
	}

	/**
	 * 添加员工
	 */
	@Override
	public void saveSuccess(Employee employee) {
		employeeDao.saveSuccess(employee);
	}

	/**
	 * 根据id查找员工
	 */
	@Override
	public Employee findByDid(Integer eid) {
		return employeeDao.findByDid(eid);
	}

	/**
	 * 删除员工
	 */
	@Override
	public void deleteSuccess(Employee employee) {
		employeeDao.deleteSuccess(employee);
	}
	/**
	 * 修改员工
	 */
	@Override
	public void updateSuccess(Employee employee) {
		employeeDao.updateSuccess(employee);
	}

}
