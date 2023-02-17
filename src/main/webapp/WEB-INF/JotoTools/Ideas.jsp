<%@ include file="base2/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base2/head.jsp" %> 
<%@ include file="base2/navBar.jsp" %> 

<body>
    <div class="container">
        <h1 style="text-align: center;">Ideas</h1>
        
        <div>
            <c:forEach var="idea" items="${ideas}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><c:out value="${idea.name}"/></h4>
                            </div>
                            <div class="modal-body">
                                <p>Description: <c:out value="${idea.description}"/></p>
                                <p>Submitted by: <c:out value="${idea.user.email}"/></p>
                                <p>Submitted on: <fmt:formatDate pattern = "yyyy-MM-dd" value = "${idea.createdAt}" /></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Reject</button>
                                <button type="button" class="btn btn-primary">Mark Complete</button>
                            </div>
                        </div>
                    </div>
            </c:forEach>
        </div>
    </div>

    <div class="modal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Modal body text goes here.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

</body>

<%@ include file="base2/footer.jsp" %> 

</html>


