<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 
<%@ include file="base/navBar.jsp" %> 

<body>
    <div>
        <div class="container">    
            <div class="row">
                <c:choose>
                    <c:when test = "${products.isEmpty()}">
                        <div style="text-align: center;"><h2>No items found. Post an <a href="/jototools/classifieds/sell">item</a>!</h2></div>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="product" items="${products}">
                            <div class="col-sm-4">
                                <div class="modal-content" style="margin-bottom: 20px;">
                                    <div class="panel-heading"></div>
                                    <div class="panel-body"><img src="https://us.123rf.com/450wm/infadel/infadel1712/infadel171200119/91684826-a-black-linear-photo-camera-logo-like-no-image-available-.jpg?ver=6" class="img-responsive" style="width:400px; height:200px;" alt="Image"></div>
                                    <div class="panel-footer" style="font-weight: bold;">Item: <c:out value="${product.title}"/></div>
                                    <div class="panel-footer">Category: <c:out value="${product.category}"/></div>
                                    <div class="panel-footer">Price: $<c:out value="${product.price}"/></div>
                                    <div class="panel-footer">Description: <c:out value="${product.description}"/></div>
                                    <div class="panel-footer">Posted by: <c:out value="${product.user.name}"/></div>
                                    <c:choose>
                                        <c:when test = "${product.updatedAt == null}">
                                            <div class="panel-footer">Posted On: <fmt:formatDate pattern = "yyyy-MM-dd" value = "${product.createdAt}" /></div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="panel-footer">Posted On: <fmt:formatDate pattern = "yyyy-MM-dd" value = "${product.updatedAt}" /></div>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="panel-footer" style="display: flex;">
                                        <a href="/jototools/classifieds/view/${product.id}" class="btn btn-primary" style="font-size: 10.5px; margin-right:5px;">View</a>
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
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
    
            </div>
        </div>
    </div><br><br>
</body>

<%@ include file="base/footer.jsp" %> 

</html>


