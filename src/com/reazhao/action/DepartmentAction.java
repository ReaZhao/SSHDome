package com.reazhao.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.reazhao.domain.Department;
import com.reazhao.domain.PageBean;
import com.reazhao.service.DepartmentService;
/**
 *部门action
 */
@SuppressWarnings("serial")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	private Department department =new Department();
	private Integer currPage=1;
	private DepartmentService departmentService;
	@Override
	public Department getModel() {
		return department;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	/**
	 * 分页查询的方法
	 * @return
	 */
	public String findAll(){
		PageBean<Department>pageBean=departmentService.findByPage(currPage);
		//将pageBean保存到栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 跳转到添加部门的页面方法
	 * @return
	 */
	public String saveInfo(){
		return "saveInfo";
	}
	/**
	 * 添加部门的方法
	 * @return
	 */
	public String saveSuccess(){
		departmentService.saveInfo(department);
		return "saveSuccess";
	}
	/**
	 * 跳转到部门编辑页面
	 * @return
	 */
	public String findByDid(){
		Department editDepartment=departmentService.findByDid(department.getDid());
		ActionContext.getContext().getSession().put("editDepartment", editDepartment);
		// jsp 中的<s:textfield name="dname"  value="%{#session.editDepartment.dname}" />
//		ActionContext.getContext().getValueStack().push(editDepartment);
		//jsp 中的<s:textfield name="dname"  value="%{#dname}" />
		return "findByDid";
	}
	/**
	 * 编辑部门的方法
	 * @return
	 */
	public String updateSuccess(){
		departmentService.updateSuccess(department);
		return "updateSuccess";
	}
	/**
	 * 删除部门
	 * @return
	 */
	public String deleteSuccess(){
		
		departmentService.deleteSuccess(departmentService.findByDid(department.getDid()));
		return "deleteSuccess";
	}
}
