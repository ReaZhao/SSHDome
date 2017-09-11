package com.reazhao.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.reazhao.dao.DepartmentDao;
import com.reazhao.domain.Department;
import com.reazhao.domain.PageBean;
import com.reazhao.service.DepartmentService;

/**
 *部门的service实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	/**
	 * 查询部门分页
	 */
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean=new PageBean<>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize=10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*+pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 添加部门
	 */
	@Override
	public void saveInfo(Department department) {
		departmentDao.saveInfo(department);
	}
	@Override
	public Department findByDid(Integer did) {
		Department editDepartment=departmentDao.findByDid(did);
		return editDepartment;
	}
	@Override
	public void updateSuccess(Department department) {
		departmentDao.updateSuccess(department);
	}
	@Override
	public void deleteSuccess(Department department) {
		departmentDao.deleteSuccess(department);
	}
	
	
}
