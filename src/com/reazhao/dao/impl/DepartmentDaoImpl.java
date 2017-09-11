package com.reazhao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.reazhao.dao.DepartmentDao;
import com.reazhao.domain.Department;
/**
 *部门的dao实现类
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao{

	@Override
	public int findCount() {
		String hql="select count(*) from Department";
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
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		@SuppressWarnings("unchecked")
		List<Department> list=(List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	/**
	 * 添加部门
	 */
	@Override
	public void saveInfo(Department department) {
		this.getHibernateTemplate().save(department);
	}
	/**
	 * 根据did查询部门
	 */
	@Override
	public Department findByDid(Integer did) {
//		String hql="from Department  where did=?";
//		List<Department> list= (List<Department>) this.getHibernateTemplate().find(hql, did);
//		return list.get(0);
		Department editDepartment=this.getHibernateTemplate().get(Department.class, did);
		return editDepartment;
	}
	@Override
	public void updateSuccess(Department department) {
		this.getHibernateTemplate().update(department);
	}
	@Override
	public void deleteSuccess(Department department) {
		this.getHibernateTemplate().delete(department);
	}
	
}
