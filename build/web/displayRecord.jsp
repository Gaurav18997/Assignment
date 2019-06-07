<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Service Providers India</title>
        <link rel="stylesheet" type="text/css" href="css/display.css">  
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
        <link rel="stylesheet" type="text/css" href="css/displayRecords.css">
    </head>

<body>

    <div class="nav">

        <a href="displayData">Home</a>

        <div class="search">

            <form action="/dataServlet">

                <input type="text" placeholder="Search (by ISP name,price,rating)" required="required" size="44">

                <button>Search</button>

            </form>
        </div> 
	<br/><br/><br/>
        <!-- ************************************************************************************** -->
        <table class="container">
            <c:forEach items="${data}" var="data">
	<thead>
            		<tr>
			<th><h1>Attribute</h1></th>
			<th><h1>Values</h1></th>
		</tr>
	</thead>
	<tbody>
            
            <tr>
			<td>Service Name</td>
			<td>${data.name}</td>	
		</tr>
		<tr>
			<td>Rating(1-5)</td>
			<td>${data.rating}</td>	
		</tr>
		<tr>
			<td>Maximum Speed</td>
			<td>${data.max_speed}</td>
		</tr>
		<tr>
			<td>Description</td>
			<td>${data.description}</td>
		</tr>
    <tr>
			<td>Contact Number</td>
			<td>${data.contact_no}</td>
		</tr>
    <tr>
			<td>Email</td>
			<td>${data.email}</td>
		</tr>
    <tr>
			<td>URL</td>
			<td>${data.url}</td>
		</tr>
	</tbody>
            </c:forEach>
</table>
        
        
        
        
       <!-- ************************************************************************************** -->
	 <div style="background-color:white; width:800px; margin:0 auto;">
		 <p  align="center" ><i class="fas fa-sort" ></i>Sort by : <input type="radio" name="sortby" value="price"> Price
<input type="radio" name="sortby" value="rating"> Rating</p>
	</div> 

    </div>

</body>

</html>