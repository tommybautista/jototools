<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 
<%@ include file="base/navBar.jsp" %> 

<body>
      <div>
      	<form action="/jototools/user/dashboard">
		    Name:
		    <input type="text" name="name" value="${name}" />
		    Email:
		    <input type="text" name="email" value="${email}" />
		    
		    <input type="submit" value="Search">
		    <input type="button" value="Clear" onclick="clearFilter()">
		</form>
      </div>
      
      <div>
      		<table>
			    <tr>
			        <th>Name</th>
			        <th>Email</th>
			    </tr>
			    <c:forEach var="user" items="${users}">
			        <tr>
			            <td><c:out value="${user.name}"/></td>
			            <td><c:out value="${user.email}"/></td>
			        </tr>
			    </c:forEach>
			</table>
      </div>
</body>

<script type="text/javascript">
    function clearFilter(){
        window.location = "/jototools/user/dashboard";
    }
</script>

</html>



