<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head></head>
<body>
<table border="0" width="600px">
<tr>
<td align="center" style="font-size:24px; color:#666">员工修改</td>
</tr>
<tr>
<td align="right" > 
<a href="javascript:document.getElementById('saveForm').submit()">保存</a> &nbsp;&nbsp;
<a href="javascript:history.go(-1)">退回 </a>
</td>
</tr>
</table>
<br/>
<br/>
<!-- action对应一个action标签，id对应提交时的对应关系 -->
<s:form id="saveForm" action="emp.updateSuccess" method="post" namespace="/" theme="simple">
	<s:hidden name="eid" value="%{#session.editEmployee.eid}" />
	<table style="font-size::16px">
		<tr>
		  <td>员工姓名：</td>
		  <td><s:textfield name="ename" value="%{#session.editEmployee.ename}"/></td>
		  <td>性别：</td>
		  <td><s:radio list="{'男','女'}" name="sex" value="%{#session.editEmployee.sex}"/></td>
		</tr>
		<tr>
		  <td>生日：</td>
		  <td><input type="text" name="birthday"  value="<s:date name="%{#session.editEmployee.birthday}" format="yyyy-MM-dd"/>" /></td>
		  <td>入职日期：</td>
		  <td><input type="text" name="joinDay" value="<s:date name="%{#session.editEmployee.joinDay}" format="yyyy-MM-dd"/>"/></td> 
		</tr>
		<tr>
		  <td>用户名：</td>
		  <td><s:textfield name="username" value="%{#session.editEmployee.username}"/></td>
		  <td>密码：</td>
		  <td><s:textfield type="password" name="password" value="%{#session.editEmployee.password}" showPassword="true"/></td>
		</tr>
		<tr>
		  <td>编号：</td>
		  <td><s:textfield name="eno"  value="%{#session.editEmployee.eno}"/></td>
		  <td>部门：</td>
		  <td><s:select name="department.did" headerKey="" value="%{#session.editEmployee.department.did}" headerValue="--请选择--" list="%{#session.list}" listKey="did" listValue="dname"/></td>
		</tr>
	</table>
</s:form>
</body>
</html> 