<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 
<%@ include file="base/navBar.jsp" %>

<body>
    <div class="container" style="display: flex; justify-content:center;">
        <div class="card mb-3">
            <img class="card-img-top" src="https://www.caspianpolicy.org/no-image.png" class="img-responsive" style="width:600px; height:400px;" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">Item: <c:out value="${product.title}"/></h5>
                <p class="card-text">Category: <c:out value="${product.category}"/></p>
                <p class="card-text">Price: <c:out value="${product.price}"/></p>
                <p class="card-text">Description: <c:out value="${product.description}"/></p>
                <p class="card-text">Posted by: <c:out value="${product.user.name}"/></div>
                <p>
                    <c:choose>
                        <c:when test = "${product.updatedAt == null}">
                            <div>Posted On: <fmt:formatDate pattern = "yyyy-MM-dd" value = "${product.createdAt}" /></div>
                        </c:when>
                        <c:otherwise>
                            <div>Posted On: <fmt:formatDate pattern = "yyyy-MM-dd" value = "${product.updatedAt}" /></div>
                        </c:otherwise>
                    </c:choose>
                </p>
                <div style="display: flex;">
                    <a href="/jototools/classifieds/dashboard" class="btn btn-primary" style="font-size: 10.5px; margin-right:5px;">Back</a>
                    <c:if test = "${product.user.id==user.id}">
                        <a href="/jototools/classifieds/edit/${product.id}" class="btn btn-success" style="font-size: 10.5px; margin-right:5px;">Edit</a> 
                        <form action="/jototools/classifieds/product/delete/${product.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Delete" class="btn btn-danger" style="font-size: 10.5px; margin-right:5px;">
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
    </div><br><br>
</body>


<%@ include file="base/footer.jsp" %> 

</html>


