package com.reazhao.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.reazhao.domain.Employee;
import com.reazhao.service.HomeService;

@SuppressWarnings("serial")
public class HomeAction extends ActionSupport implements ModelDriven<Employee>{
	//是struts与spring融合后自动注入的
	private Employee employee = new Employee();
	private HomeService homeService;
	@Override
	public Employee getModel() {
		return employee;
	}
	
	

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}



	/**
	 * 登录
	 * @return
	 */
	public String login(){
		//判断是否进入登录界面
		if(employee.getUsername()==null||"".equals(employee.getUsername().trim())){
			return INPUT;
		}
		Employee existemployee=homeService.login(employee);
		if(existemployee==null){
			//登录失败
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("exsitEmploy", existemployee);
			return SUCCESS;
		}
	}
	
}
