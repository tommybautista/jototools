<%@ include file="base/tags.jsp" %> 

<!DOCTYPE html>
<html lang="en"> 

<%@ include file="base/head.jsp" %> 

<body class="main-bg">
    <div class="login-container text-c animated flipInX">
        <div>
            <h1 class="logo-badge text-whitesmoke"><span class="fa fa-user-circle"></span></h1>
        </div>
            <h3 class="text-whitesmoke">JotoTools</h3>
            <p class="text-whitesmoke">Register</p>
        <div class="container-content">
            <form:form class="margin-t" action="/jototools/register/submit" method="post" modelAttribute="newUser">
                <div class="form-group">
                    <form:errors path="name" class="text-danger" />
                    <form:input path="name" class="form-control" placeholder="Name" />
                </div>
                <div class="form-group">
                    <form:errors path="email" class="text-danger" />
                    <form:input path="email" class="form-control" placeholder="Email" />
                </div>
                <div class="form-group">
                    <form:errors path="password" class="text-danger" />
                    <form:input path="password" type="password" class="form-control" placeholder="*****" />
                </div>
                <div class="form-group">
                    <form:errors path="confirm" class="text-danger" />
                    <form:input path="confirm" type="password" class="form-control" placeholder="*****" />
                </div>
                <button type="submit" class="form-button button-l margin-b">Sign Up</button>

                <a class="text-darkyellow" href="#"><small>Forgot your password?</small></a>
                <p class="text-whitesmoke text-center"><small>Already have an account?</small></p>
                <a class="text-darkyellow" href="/jototools/login"><small>Login</small></a>
            </form:form>
            <p class="margin-t text-whitesmoke"><small> Your Name &copy; 2018</small> </p>
        </div>
    </div>
</body>
</html>