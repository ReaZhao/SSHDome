<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 部门管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/dep.saveInfo.com">添加</a></td>
</tr>
</table>
<br/>
<table cellspacing="0" border="1" class="table1">
<thead>
   <tr>
    	<th width="300">部门名称</th>
   		<th  width="300">编辑</th>
   		<th  width="300">删除</th>
   </tr>
</thead>
<tbody>
<s:iterator value="list" var="d">
	<tr>
		<td align="center"><s:property value="#d.dname"/></td>
		<td align="center"><a href="${pageContext.request.contextPath}/dep.findByDid.com?did=<s:property value="#d.did"/>"><img src="<%=basePath %>images/edit.png"/></a></td>
		<td align="center"><a href="${pageContext.request.contextPath}/dep.deleteSuccess.com?did=<s:property value="#d.did"/>"><img src="<%=basePath %>images/trash.gif"/></a></td>
	</tr>
</s:iterator>
</tbody>
</table>
<br/>


<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页&nbsp;&nbsp;</span>
   <span>
   <s:if test="currPage == 1">
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </s:if>
   <s:elseif test="currPage > 1 && currPage<totalPage">
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
   </s:elseif>
   <s:else>
 	   <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/dep.findAll.com?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
  </s:else>
   </span>
</td>
</tr>
</table>
</body>
</html>