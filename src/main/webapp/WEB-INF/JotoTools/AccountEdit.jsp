<%@ include file="base2/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base2/head.jsp" %> 
<%@ include file="base2/navBar.jsp" %> 

<body>
    <div>
        <div class="container">
            <div><h2 style="text-align: center;">Update Account Information</h2></div>
            <div class="container-content">
                <form:form class="margin-t" action="/jototools/account/update/${user.id}" method="post" modelAttribute="newUser">
                    <input type="hidden" name="_method" value="put">
                    <div class="form-group">
                        <form:label path="name">Name:</form:label>
                        <form:errors path="name" class="text-danger" />
                        <form:input path="name" class="form-control" value="${user.name}"/>
                    </div>
                    <div class="form-group">
                        <form:label path="email">Email:</form:label>
                        <form:errors path="email" class="text-danger" />
                        <form:input path="email" class="form-control" value="${user.email}" />
                    </div>
                    <div class="form-group">
                        <form:label path="password">Password:</form:label>
                        <form:errors path="password" class="text-danger" />
                        <form:input path="password" type="password" class="form-control" value="${user.password}"/>
                    </div>
                    <div class="form-group">
                        <form:label path="confirm">Confirm:</form:label>
                        <form:errors path="confirm" class="text-danger" />
                        <form:input path="confirm" type="password" class="form-control" />
                    </div>
                    <div>
                        <a href="/jototools/account" class="btn btn-danger">Cancel</a>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div><br><br>
</body>

</html>




