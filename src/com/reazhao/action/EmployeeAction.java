package com.reazhao.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.reazhao.domain.Department;
import com.reazhao.domain.Employee;
import com.reazhao.domain.PageBean;
import com.reazhao.service.EmployeeService;

/**
 * 员工管理的Action类
 */
@SuppressWarnings("serial")
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {
	// 是struts与spring融合后自动注入的
	private Employee employee = new Employee();
	// 使用spring将service注入
	private EmployeeService employeeService;
	// 当前页 表示显示第几页
	private Integer currPage = 1;

	public Employee getModel() {
		return employee;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * 查询全部员工
	 * 
	 * @return
	 */
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 将pageBean保存到栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	/**
	 * 跳转到添加员工页面
	 * 
	 * @return
	 */
	public String saveInfo() {
		// 先查询出所有部门的信息 用于员工选择部门
		List<Department> list = employeeService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveInfo";
	}

	/**
	 * 添加员工成功
	 * 
	 * @return
	 */
	public String saveSuccess() {
		employeeService.saveSuccess(employee);
		return "saveSuccess";
	}

	/**
	 * 跳转到员工编辑页面
	 * 
	 * @return
	 */
	public String findByDid() {
		// 根据id查找员工
		Employee editEmployee = employeeService.findByDid(employee.getEid());
		ActionContext.getContext().getSession().put("editEmployee", editEmployee);

		// 先查询出所有部门的信息 用于员工选择部门
		List<Department> list = employeeService.findAll();
		ActionContext.getContext().getSession().put("list", list);
		return "findByDid";
	}

	/**
	 * 修改成功
	 * 
	 * @return
	 */
	public String updateSuccess() {
		employeeService.updateSuccess(employee);
		return "updateSuccess";
	}

	/**
	 * 删除员工
	 * 
	 * @return
	 */
	public String deleteSuccess() {
		employeeService.deleteSuccess(employee);
		return "deleteSuccess";
	}
}
