<%@ include file="base2/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base2/head.jsp" %> 
<%@ include file="base2/navBar.jsp" %> 

<body>
    <div>
        <div class="container">
            <div><h2 style="text-align: center;">Your Account Information</h2></div>
            <div>
                <table class="table table-hover">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Name:</td>
                            <td><c:out value="${user.name}"/></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><c:out value="${user.email}"/></td>
                        </tr>
                        <tr>
                            <td>Member Since:</td>
                            <td><fmt:formatDate pattern = "MMM-dd-yyyy" value = "${user.createdAt}" /></td>
                        </tr>
                    </tbody>
                    
                </table>
                <div style="display: flex;">
                    <a href="/jototools/edit/${user.id}" class="btn btn-success" style="font-size: 10.5px; margin-right:5px;">Edit</a> 
                    <form action="/jototools/account/delete/${user.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete" class="btn btn-danger" style="font-size: 10.5px; margin-right:5px;">
                    </form>
                </div>

        </div>
    </div><br><br>
</body>

</html>




