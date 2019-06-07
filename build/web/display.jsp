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

            <form action="dataServlet" method="post" autocomplete="on">

                <input type="text" placeholder="Search (by ISP name,price,rating)" id ="service" name="service" required="required" size="44">

                <button>Search</button>

            </form>

        </div> 
	<br/><br/><br/>
        <!-- **************************************************************************** -->
         <table class="container">
     
     <thead>
     		<tr>
                    <th><h1>Service Provider</h1></th>
		<th><h1>Lowest Price</h1></th>
	</tr>
</thead>
<tbody>
    <c:forEach items="${data}" var="data">
     <tr>
         <td>${data.name}</td>
	<td>Rs.${data.lowest_price}</td>
	</tr>
    </c:forEach>
</tbody>
         </table>  
        <!-- **************************************************************************** -->
        
        <br/> <br/> <br/>
                <center>
                    <form action="sorted" method="post">
                        Sort by :<input type="radio" name="sortby" id="sortby" value="lowest_price" checked="checked"> Price
                       <input type="radio" name="sortby" id="sortby" value="rating" > Rating
                       <input type="submit" placeholder="Sort" size="44" ></p>
                 
               </form>
                </center>

    </div>

</body>

</html>