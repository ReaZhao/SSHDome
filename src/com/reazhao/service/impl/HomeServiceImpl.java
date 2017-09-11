package com.reazhao.service.impl;

import com.reazhao.dao.HomeDao;
import com.reazhao.domain.Employee;
import com.reazhao.service.HomeService;

public class HomeServiceImpl implements HomeService {
	private HomeDao homeDao;
	


	public void setHomeDao(HomeDao homeDao) {
		this.homeDao = homeDao;
	}



	/**
	 * 业务登录的方法
	 */
	@Override
	public Employee login(Employee employee) {
		Employee existemployee = homeDao
				.findByUsernameAndPassword(employee);
		return existemployee;
	}

}
