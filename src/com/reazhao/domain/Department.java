package com.reazhao.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * 部门实体
 * @author reazhao
 *
 */
public class Department implements Serializable{
	private Integer did;
	private String dname;
	private String ddesc;
	private Set<Employee> employees=new HashSet<>();
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDdesc() {
		return ddesc;
	}
	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", ddesc="
				+ ddesc + "]";
	}
	
	
}
