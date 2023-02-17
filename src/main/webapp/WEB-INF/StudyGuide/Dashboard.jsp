<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 
<%@ include file="base/navBar.jsp" %> 

<body>
    <div class="container">
        <h1 style="text-align: center;">Study Guide</h1>
        <form:form action="/jototools/studyguide/submit" method="post" modelAttribute="newKey">
            <div class="form-group">
                <form:label path="key">Key:</form:label>
                <form:errors path="key" class="text-danger" />
                <form:input path="key" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="value">Description:</form:label>
                <form:errors path="value" class="text-danger" />
                <form:textarea path="value" class="form-control"/>
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

<%@ include file="base/footer.jsp" %> 

</html>


