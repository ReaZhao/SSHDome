package com.reazhao.dao;

import com.reazhao.domain.Employee;

public interface HomeDao {

	Employee findByUsernameAndPassword(Employee employee);

}
