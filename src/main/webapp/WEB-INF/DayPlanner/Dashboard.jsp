<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 
<%@ include file="base/navBar.jsp" %> 

<body>
    
    <div class="container">
        <div><h2 style="text-align: center;">Plan Your Day</h2></div>
        <div>
            <form:form action='/jototools/dayplanner/add' method="POST" modelAttribute="newEvent">

                <div class="form-group">
                    <form:label path="date">Date:</form:label>
                    <form:errors path="date" class="text-danger" />
                    <form:input path="date" type="date" class="form-control"/>
                    <p class="text-danger"><c:out value="${error}"/></p>
                </div>
                <div class="form-group">
                    <form:label path="breakfast">Breakfast:</form:label>
                    <form:errors path="breakfast" class="text-danger" />
                    <form:input path="breakfast" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="morning">Morning:</form:label>
                    <form:errors path="morning" class="text-danger" />
                    <form:input path="morning" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="lunch">Lunch:</form:label>
                    <form:errors path="lunch" class="text-danger" />
                    <form:input path="lunch" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="afternoon">Afternoon:</form:label>
                    <form:errors path="afternoon" class="text-danger" />
                    <form:input path="afternoon" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="dinner">Dinner:</form:label>
                    <form:errors path="dinner" class="text-danger" />
                    <form:input path="dinner" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="evening">Evening:</form:label>
                    <form:errors path="evening" class="text-danger" />
                    <form:input path="evening" class="form-control"/>
                </div>

                <div class="form-group">
                    <form:errors path="user" class="text-danger"/>
                    <form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
                </div>
                
                <div>
                    <a href="/jototools/dayplanner/dashboard" class="btn btn-danger" style="font-size: 10.5px; margin-right:5px;">Cancel</a>
                    <input type="submit" class="btn btn-primary" style="font-size: 10.5px; margin-right:5px;" value="Add Event" />
                </div>


            </form:form>
        </div>
    </div><br><br>

    <div>
        <div class="container">
            <c:forEach var="event" items="${events}">
                <c:if test = "${event.user.id==user.id}">
                    <div>    
                        <div class="row">
                            <c:choose>
                                <c:when test = "${events.isEmpty()}">
                                    <h2></h2>
                                </c:when>
                                <c:otherwise>
                                    <h2 style="text-align: center;">Your Agenda</h2>
                                </c:otherwise>
                            </c:choose>
                                <div>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 21px;"><c:out value="${event.date}"/></td>
                                                <td  scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px; display: flex; justify-content: end;">
                                                    <a href="/jototools/dayplanner/update/${event.id}" class="btn btn-success" style="font-size: 10.5px; margin-right:5px;">Edit</a> 
                                                    <form action="/jototools/dayplanner/event/delete/${event.id}" method="post">
                                                        <input type="hidden" name="_method" value="delete">
                                                        <input type="submit" value="Delete" class="btn btn-danger" style="font-size: 10.5px; margin-right:5px;">
                                                    </form>
                                                </td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;">Breakfast:</td>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;"><c:out value="${event.breakfast}"/></td>
                                            </tr>
                                            <tr>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;">Morning:</td>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;"><c:out value="${event.morning}"/></td>
                                            </tr>
                                            <tr>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;">Lunch:</td>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;"><c:out value="${event.lunch}"/></td>
                                            </tr>
                                            <tr>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;">Afternoon:</td>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;"><c:out value="${event.afternoon}"/></td>
                                            </tr>
                                            <tr>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;">Dinner:</td>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;"><c:out value="${event.dinner}"/></td>
                                            </tr>
                                            <tr>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;">Evening:</td>
                                                <td scope="row" style="font-family: 'Roboto', sans-serif; font-size: 17px;"><c:out value="${event.evening}"/></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    </div>
                                </div>
                            </div>
                    </c:if>
            </c:forEach>
        </div>
    </div><br><br>
</body>

<%@ include file="base/footer.jsp" %> 

</html>


