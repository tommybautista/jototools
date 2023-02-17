<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 
<%@ include file="base/navBar.jsp" %> 

<body>
    <div style="padding:20px ;">
        <form:form action="/jototools/classifieds/sell/submit" method="post" modelAttribute="newProduct" enctype="multipart/form-data">
            <div class="form-group">
                <form:label path="category">Categories</form:label>
                <form:select path="category" class="form-control">
                    <option value="auto">Auto and Motorcycle</option>
                    <option value="baby">Baby Stuff</option>
                    <option value="clothes">Clothes</option>
                    <option value="jewelry">Jewelry and Accessories</option>
                    <option value="tools">Tools</option>
                    <option value="misc">Miscellaneous</option>
                </form:select>
            </div>
            <div class="form-group">
                <form:label path="title">Product Name:</form:label>
                <form:errors path="title" class="text-danger" />
                <form:input path="title" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="description">Description:</form:label>
                <form:errors path="description" class="text-danger" />
                <form:input path="description" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="price">Price:</form:label>
                <form:errors path="price" class="text-danger" />
                <form:input path="price" class="form-control"/>
            </div>
            <div class="form-row">
                <form:errors path="user" class="text-danger"/>
                <form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
            </div>
            <div>
                <form:label path="photos">Photos:</form:label>
                <input type="file" name="image" accept="image/png, image/jpeg" />
            </div>
            <br>
            <div>
                <a href="/jototools/classifieds/dashboard" class="btn btn-danger" style="font-size: 10.5px; margin-right:5px;">Cancel</a>
                <input type="submit" class="btn btn-primary" style="font-size: 10.5px; margin-right:5px;" value="Create" />
            </div>
        </form:form>
    
    </div>
</body>

<%@ include file="base/footer.jsp" %> 

</html>


