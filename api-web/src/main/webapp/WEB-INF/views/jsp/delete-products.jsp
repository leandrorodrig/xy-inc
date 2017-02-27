<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>delete of products by id</title>
<style>
        .navbar-header button{color:#fff;}
        .full-screen {width:100%;}
        main{
        	padding-top: 56px;
        }
        footer{
            background:#333;
            color:#fff;
            text-align: center;
            padding: 20px 0; 
        }
</style>

<c:url var="home" value="/" scope="request" />

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<script src="${jqueryJs}"></script>
</head>

<body>

		<header>
			<nav class="navbar navbar-fixed-top navbar-inverse">
				<div class="navbar-header" align="left">
					<a class="navbar-brand" href="http://www.webstuff.eti.br">Web Stuff</a>
					<button class="navbar-toggle" type="button" data-target=".navbar-collapse" data-toggle="collapse">Menu</button>
				</div>
				<div class="collapse navbar-collapse" align="center">
					<ul class="nav navbar-nav ">
						<li><a href="/api-web/save/">Save Product</a></li>
						<li><a href="/api-web/delete/">Delete Product</a></li>
						<li><a href="/api-web/update/">Update Product</a></li>
					</ul>
					
					<%@ include file="/WEB-INF/views/jsp/comum/core-id.jsp" %> 
					
				</div>		
                
			</nav>
		</header>
<main>		

<div class="container" style="min-height: 500px">

	<div class="starter-template">
	    
	    <br><br><br><br><br><br>
	    <h1 align="center">Delete Product By ID</h1>
	
		

		<form class="form-horizontal" id="search-form">
		
		    <div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Id</label>
				<div class="col-sm-10" id="div-id">
					<input type=text class="form-control" id="id">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Name</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="name">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Description</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="description">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Category</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="category">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Price</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="price">
				</div>
			</div>
			
			
	     <div class="container">
	        <div class="row">
				<div class="col-sm-3">
					<!-- Inserindo funcionalidade de deletar na Tela -->
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" id="bth-delete-search"
								class="btn btn-primary btn-lg">Delete</button>
						</div>
					</div>
				</div>
			</div>		
		</div>	
			
			
		</form>

	</div>

</div>


</main>
<footer>
	<p align="center">Todos os direitos reservados</p>
	<p align="center">
			&copy; <a href="http://www.webstuff.eti.br">Web Stuff</a> 2017
	</p>
</footer>
<script>
	jQuery(document).ready(function($) {
		
		
		$("#search-id-form").submit(function(event) {
			// Disble the search button
			enableSearchButton(false);
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			searchProductsByIdViaAjax();
		});
		
		$("#search-form").submit(function(event) {
			
			// Disble the search button
			enableSearchButton(false);
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			delteProductsByIdViaAjax();
		});
	});
	
	
	
	function delteProductsByIdViaAjax() {

		var search = {}
		search["id"] = $("#id").val();
	
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}search/api/deleteProductsById",   
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
				
				document.getElementById('id').value = "";
				document.getElementById('name').value = "";
				document.getElementById('description').value = "";
				document.getElementById('category').value = "";
				document.getElementById('price').value = "";
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});
	}

	function searchProductsByIdViaAjax() {
		
		var search = {}
		search["id"] = $("#byid").val();
	
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}search/api/getProductsById",   
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
				
				//$('#id').val($('#byid'));
				$('#name').val(data.products.name);
				$('#description').val(data.products.description);
				$('#category').val(data.products.category);
				$('#price').val(data.products.price);
				$('#id').val(data.products.id);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});
	}
	
	
	
	
	
	
	

	function enableSearchButton(flag) {
		$("#btn-search").prop("disabled", flag);
	}

	function display(data) {
		var json = "<h4>Ajax Response</h4><pre>"
				+ JSON.stringify(data, null, 4) + "</pre>";
		$('#feedback').html(json);
	}
</script>



</body>
</html>