<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 
<%@ include file="base/navBar.jsp" %> 

<body>
    <div class="container">
        <div>
            <div>
                <p style="font-family: 'Roboto', sans-serif; font-size: 21px;">
                    Date: ${event.date}
                </p>
            </div>
            <form:form action='/jototools/dayplanner/event/update/${event.id}' method="POST" modelAttribute="newEvent">
    
                <input type="hidden" name="_method" value="put">
    
                <div class="form-group">
                    <form:errors path="date" class="text-danger" />
                    <form:input path="date" type="hidden" value="${event.date}" class="form-control"/>
                    <p class="text-danger"><c:out value="${error}"/></p>
                </div>
                
                <div class="form-group">
                    <form:label path="breakfast">Breakfast:</form:label>
                    <form:errors path="breakfast" class="text-danger" />
                    <form:input path="breakfast" value="${event.breakfast}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="morning">Morning:</form:label>
                    <form:errors path="morning" class="text-danger" />
                    <form:input path="morning" value="${event.morning}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="lunch">Lunch:</form:label>
                    <form:errors path="lunch" class="text-danger" />
                    <form:input path="lunch" value="${event.lunch}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="afternoon">Afternoon:</form:label>
                    <form:errors path="afternoon" class="text-danger" />
                    <form:input path="afternoon" value="${event.afternoon}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="dinner">Dinner:</form:label>
                    <form:errors path="dinner" class="text-danger" />
                    <form:input path="dinner" value="${event.dinner}" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="evening">Evening:</form:label>
                    <form:errors path="evening" class="text-danger" />
                    <form:input path="evening" value="${event.evening}" class="form-control"/>
                </div>
    
                <div class="form-group">
                    <form:errors path="user" class="text-danger"/>
                    <form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
                </div>
                
                <div>
                    <a href="/jototools/dayplanner/dashboard" class="btn btn-danger" style="font-size: 10.5px; margin-right:5px;">Cancel</a>
                    <input type="submit" class="btn btn-primary" style="font-size: 10.5px; margin-right:5px;" value="Update Event" />
                </div>
    
    
            </form:form>
        </div>
    </div><br><br>
</body>

<%@ include file="base/footer.jsp" %> 

</html>


