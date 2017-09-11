package com.reazhao.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.reazhao.dao.HomeDao;
import com.reazhao.domain.Employee;

public class HomeDaoImpl extends HibernateDaoSupport implements HomeDao {

	/**
	 * dao中根据用户名和密码查询
	 */
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql="from Employee where username=? and password=?";
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
