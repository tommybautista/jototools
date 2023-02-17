<%@ include file="base2/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base2/head.jsp" %> 
<%@ include file="base2/navBar.jsp" %> 

<body>
    <div class="container">
        <h1 style="text-align: center;">Application Idea Submission</h1>
        <form:form action="/jototools/idea/submit" method="post" modelAttribute="newIdea">
            <div class="form-group">
                <form:label path="name">Idea Name:</form:label>
                <form:errors path="name" class="text-danger" />
                <form:input path="name" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="description">Description:</form:label>
                <form:errors path="description" class="text-danger" />
                <form:textarea path="description" class="form-control"/>
            </div>
            <div class="form-row">
                <form:errors path="user" class="text-danger"/>
                <form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
            </div>
            <div>
                <a href="/jototools/dashboard" class="btn btn-danger" style="font-size: 10.5px; margin-right:5px;">Cancel</a>
                <input type="submit" class="btn btn-primary" style="font-size: 10.5px; margin-right:5px;" value="Create" />
            </div>
        </form:form>
    </div>

</body>

<%@ include file="base2/footer.jsp" %> 

</html>


