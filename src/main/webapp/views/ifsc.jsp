<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IFSC Finder</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/js/bootstrap-select.min.js"></script>
</head>
<body>
<div class="container">
	<div class="form-group">
	<label>Bank Name</label>
		<select id="bankName" class="form-control" onchange="getState(this.value);">
			<option value="">...Select...</option>
			<c:forEach items="${bankName}" var="bankName">
				<option value="${bankName}" >${bankName}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
	<label>Bank State</label>
		<select class="form-control"  id="bankState" onchange="getCity(this.value);">
		<option value="">...Select...</option>
			<c:forEach items="${bankstate}" var="bankstate">
				<option value="${bankstate}" >${bankstate}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
	<label>Bank City</label>
		<select class="form-control"  id="bankCity" onchange="getBranch(this.value);">
		<option value="">...Select...</option>
			<c:forEach items="${bankCity}" var="bankCity">
				<option value="${bankCity}" >${bankCity}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
	<label>Bank Branch</label>
		<select class="form-control"  id="bankBranch" onchange="getIfsc(this.value);">
		<option value="">...Select...</option>
			<c:forEach items="${bankBranch}" var="bankBranch">
				<option value="${bankBranch}" >${bankBranch}</option>
			</c:forEach>
		</select>
	</div>
	<div>
	<span class="text-info">IFSC::</span>   <span id="ifsc" class="text-success"></span><br>
	<span class="text-info">ADDRESS::</span><span id="address" class="text-success"></span>
	<div class="text-right">
	<button type="button" class="btn btn-primary" onclick="resetValues();">Reset</button>
	</div>
	</div>
	
</div>
<script src="/views/script.js"></script>
</body>
</html>