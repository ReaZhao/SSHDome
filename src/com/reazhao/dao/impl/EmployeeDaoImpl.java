package com.reazhao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.reazhao.dao.EmployeeDao;
import com.reazhao.domain.Department;
import com.reazhao.domain.Employee;
/**
 *员工管理的dao借口的实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{
	

	@Override
	public int findCount() {
		String hql="select count(*) from Employee";
		@SuppressWarnings("unchecked")
		List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 分页查询部门
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> list=(List<Employee>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	/**
	 * 查询所有部门
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		String hql="from Department";
		List<Department> list=(List<Department>) this.getHibernateTemplate().find(hql);
		return list;
	}
	/**
	 * 添加员工
	 */
	@Override
	public void saveSuccess(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	/**
	 * 根据id查找员工
	 */
	@Override
	public Employee findByDid(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
	/**
	 * 删除员工
	 */
	@Override
	public void deleteSuccess(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}
	@Override
	public void updateSuccess(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}
	

}
