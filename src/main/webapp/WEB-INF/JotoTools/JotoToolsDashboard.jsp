<%@ include file="base/tags.jsp" %> 

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <title>Dashboard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
        .navbar {
            margin-bottom: 50px;
            background-color: rgb(35, 35, 35);
            border-radius: 0;
            border-color: transparent;
        }
        
        .jumbotron {
            margin-bottom: 0;
            background-color: rgb(35, 35, 35);
            color: aliceblue;
            height: 200px;
        }

        body {
            background-color: rgb(83, 83, 83);
        }

        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }
        </style>
    </head>


    <div class="jumbotron">
        <div class="container text-center">
        <h1>JotoTools</h1>      
        <p>Unlimited Solutions</p>
        </div>
    </div>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/jototools/ideas">Ideas</a></li>
                    <li><a href="/jototools/ideasform">Submit an Idea</a></li>
                    <li><a href="/jototools/account"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
                    <li><a href="/jototools/logout"> Log Out</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <body>
<div class="container bg-dark">    
	<div class="row bg-dark">
        <div class="col-sm-3">
            <div class="panel panel-primary">
                <div class="panel-body"><a href="/jototools/classifieds/showall"><img src="https://www.blogtyrant.com/wp-content/uploads/2019/07/how-to-start-an-online-store-min.png" class="img-responsive" style="width:400px; height:200px;" alt="Image"></a></div>
                <div class="panel-footer">Classifieds</div>
            </div>
        </div>
        <div class="col-sm-3"> 
            <div class="panel panel-primary">
                <div class="panel-body"><a href="/jototools/dayplanner/dashboard"><img src="https://www.ksdr1.net/wp-content/uploads/2020/08/Calendar.jpg" class="img-responsive" style="width:400px; height:200px;" alt="Image"></a></div>
                <div class="panel-footer">Day Planner</div>
            </div>
        </div>
        <div class="col-sm-3"> 
            <div class="panel panel-success">
                <div class="panel-body"><a href="/jototools/studyguide/dashboard"><img src="https://www.insidehighered.com/sites/default/server_files/media/iStock-477979994.jpg" class="img-responsive" style="width:400px; height:200px;" alt="Image"></a></div>
                <div class="panel-footer">Study Guide Builder</div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="panel panel-danger">
                <div class="panel-body"><a href="/jototools/bling"><img src="https://crypto-economy.com/wp-content/uploads/2019/10/crypto-trading.jpg" class="img-responsive" style="width:400px; height:200px;" alt="Image"></a></div>
                <div class="panel-footer">Stock Calculator</div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="panel panel-danger">
                <div class="panel-body"><a href="/jototools/user/dashboard"><img src="https://crypto-economy.com/wp-content/uploads/2019/10/crypto-trading.jpg" class="img-responsive" style="width:400px; height:200px;" alt="Image"></a></div>
                <div class="panel-footer">User Search</div>
            </div>
        </div>
    </div>
</div><br><br>


<%@ include file="base/footer.jsp" %> 


</html>


