<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basket</title>
<style>
	.form-group>span{
		display: block;
		margin-left: 16.67%;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/person">Person</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/description">Description</a></li>
					<li><a href="/admin/production">Product</a></li>
					<li class="active"><a href="/admin/basket">Basket</a><span
						class="sr-only">(current)</span></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/basket" method="POST" modelAttribute="basket">
					<div class="form-group">
    					<label for="product" class="col-sm-2 control-label">Products</label>
    					<div class="col-sm-10">
      						<form:select path="product" class="form-control" items="${productions}" itemLabel="presentation" itemValue="id" id="product"/>
    					</div>
  					</div>
					<div class="form-group">
    					<label for="person" class="col-sm-2 control-label">Person</label>
    					<div class="col-sm-10">
      						<form:select path="person" class="form-control" items="${persons}" itemLabel="presentation" itemValue="id" id="person"/>
    					</div>
  					</div>
					<div class="form-group">
    					<label for="dataship" class="col-sm-2 control-label">Data_Ship</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="dataship" id="dataship"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="is_deleted" class="col-sm-2 control-label">Is_deleted</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="is_deleted" id="is_deleted"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Save</button>
      						<a class="btn btn-primary" href="/admin/basket/cancel">Cancel</a>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>Products</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Person</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Data_Ship</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Deleted</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Operation</h3></div>
		</div>
			<c:forEach items="${baskets}" var="basket">
				<div class="row">
					<div class="col-md-2 col-xs-2">${production.presentation}</div>
					<div class="col-md-3 col-xs-3">${person.email}</div>
					<div class="col-md-2 col-xs-2">${basket.dataship}</div>
					<div class="col-md-2 col-xs-2">${basket.is_deleted}</div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-warning" href="/admin/basket/update/${basket.id}">update</a>
					<a class="btn btn-danger" href="/admin/basket/delete/${basket.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>
</body>
</html>