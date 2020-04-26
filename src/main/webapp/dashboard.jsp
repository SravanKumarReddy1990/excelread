<!DOCTYPE html>
<!-- Template by Quackit.com -->
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Portal 2</title>

      <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>


    <!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
    <link href="css/custom.css" rel="stylesheet">
<style>
.img-responsive {
  max-width: 100%; /* or to whatever you want here */
  max-height: auto; 
  height: auto; /* or to whatever you want here */
}
</style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<%@ page import="java.sql.*" %>
<%String tempid=request.getParameter("tempid"); %>
<div id="tempid" style="display:none"><%= tempid %></div>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Logo and responsive toggle -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-globe"></span> Logo</a>
            </div>
            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="#">Home</a>
                    </li>
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Products</a>
                    </li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Services <span class="caret"></span></a>
						<ul class="dropdown-menu" aria-labelledby="about-us">
							<li><a href="#">Engage</a></li>
							<li><a href="#">Pontificate</a></li>
							<li><a href="#">Synergize</a></li>
						</ul>
					</li>    
                </ul>

				<!-- Search -->
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control">
					</div>
					<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Search</button>
				</form>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

	<br><br>

<div class="container-fluid">

		<!-- Left Column -->
		<div class="col-sm-3">

			<!-- List-Group Panel -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title"><span class="glyphicon glyphicon-random"></span> Other</h1>
				</div>
				<div class="list-group">
					<a href="./chatroom" target="_blank" class="list-group-item">Chat Room</a>
					<a href="#" class="list-group-item">Premier Niche Markets <span class="badge">New</span></a>
					<a href="#" class="list-group-item">Dynamically Innovate</a>
					<a href="#" class="list-group-item">Objectively Innovate</a>
					<a href="#" class="list-group-item">Proactively Envisioned</a>
				</div>
			</div>

			<!-- Text Panel -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title"><span class="glyphicon glyphicon-cog"></span> Dramatically Engage</h1>
				</div>

				<div class="panel-body">
					<p>Objectively innovate empowered manufactured products whereas parallel platforms. Holisticly predominate extensible testing procedures for reliable supply chains. Dramatically engage top-line web services vis-a-vis cutting-edge deliverables.</p>
					<p><button class="btn btn-default">Engage</button></p>
				</div>
			</div>
		
		</div><!--/Left Column-->
  
  
		<!-- Center Column -->
		<div class="col-sm-6">
		
			<!-- Alert -->
			<div class="alert alert-danger alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<strong>Synergize:</strong> Seamlessly visualize quality intellectual capital!
			</div>		
		<% String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
            Connection conn = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");

ResultSet resultSet = conn.prepareStatement("select * from posts order by p_id DESC limit 3").executeQuery();

while(resultSet.next()){ %>
				
			<!-- Articles -->
			<div class="row">
				<article class="col-xs-12">
					<div class="media">
						<div class="media-left">
							<a href="#">
								<img class="media-object" src="http://part1290.herokuapp.com/DisplayImage?imgid=962683" height="100" weight="100" alt="">
							</a>
						</div>
						<div class="media-body">
							<h2 class="media-heading"><a href="#"><%=resultSet.getString("p_title") %></a></h2>
							<p><%=resultSet.getString("p_desc") %></p>
						
						<ul class="list-inline">
							<li><a href="#"><span class="glyphicon glyphicon-comment"></span> 2 Comments</a></li>
							<li><a href="#"><span class="glyphicon glyphicon-share"></span> 8 Shares</a></li>
						</ul>
						</div>
						<div class="media-left">
							<a href="#">
								<iframe height="300px" width="100%" src="http://www.sravankumar19.orgfree.com" name="iframe_a"></iframe>
							</a>
						</div>
					</div>
				</article>
			</div>
<hr>
<% }  
resultSet.close();
conn.close();
	%>	</div><!--/Center Column-->


	  <!-- Right Column -->
	  <div class="col-sm-3">
 
			<!-- Form --> 
			<div class="panel panel-default">
        
                            <form action="./CreatePost" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="title" placeholder="Title">
            </div>
            <textarea id="editor" cols="33" name="desc" rows="12"></textarea>
            <br>
            <div class="form-group">
                <input type="hidden" class="form-control" value="<%= tempid %>" name="tempid" placeholder="Tags">
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" id="submit" value="Create Post"></input>
            </div>
       </form>
    
			</div>
 
			<!-- Text Panel -->
			
				<div class="col-md-4">
        <form method="post" enctype="multipart/form-data">
            <input type="file" id="files" name="files" multiple="multiple" />
            <p style="text-align: right; margin-top: 20px;">
                <input type="submit" value="Upload Your Photo" class="btn btn-lg btn-primary" />
            </p>
        </form>
    </div>


	  </div><!--/Right Column -->

	</div><!--/container-fluid-->
	
	<footer>
		<div class="footer-blurb">
			<div class="container">
				<div class="row">
					<div class="col-sm-3 footer-blurb-item">
						<h3><span class="glyphicon glyphicon-text-size"></span> Dynamic</h3>
						<p>Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C users after installed base benefits. Dramatically visualize customer directed convergence without revolutionary ROI.</p>
						<p><a class="btn btn-default" href="#">Procrastinate</a></p>
					</div>
					<div class="col-sm-3 footer-blurb-item">
						<h3><span class="glyphicon glyphicon-wrench"></span> Efficient</h3>
						<p>Dramatically maintain clicks-and-mortar solutions without functional solutions. Efficiently unleash cross-media information without cross-media value. Quickly maximize timely deliverables for real-time schemas. </p>
						<p><a class="btn btn-default" href="#">Unleash</a></p>
					</div>
					<div class="col-sm-3 footer-blurb-item">
						<h3><span class="glyphicon glyphicon-paperclip"></span> Complete</h3>
						<p>Professionally cultivate one-to-one customer service with robust ideas. Completely synergize resource taxing relationships via premier niche markets. Dynamically innovate resource-leveling customer service for state of the art customer service.</p>
						<p><a class="btn btn-default" href="#">Complete</a></p>
					</div>
					<div class="col-sm-3 footer-blurb-item">
						
						<!-- Thumbnails --> 
						<h3><span class="glyphicon glyphicon-camera"></span> Phosfluorescent</h3>
							<div class="row">
								<div class="col-xs-6">
									<a href="#" class="thumbnail">
										<img src="holder.js/110x80" alt="">
									</a>
								</div>
								<div class="col-xs-6">
									<a href="#" class="thumbnail">
										<img src="holder.js/110x80" alt="">
									</a>
								</div>
								<div class="col-xs-6">
									<a href="#" class="thumbnail">
										<img src="holder.js/110x80" alt="">
									</a>
								</div>
								<div class="col-xs-6">
									<a href="#" class="thumbnail">
										<img src="holder.js/110x80" alt="">
									</a>
								</div>
							</div>
							
					</div>

				</div>
				<!-- /.row -->	
			</div>
        </div>
        
        <div class="small-print">
        	<div class="container">
        		<p><a href="#">Terms &amp; Conditions</a> | <a href="#">Privacy Policy</a> | <a href="#">Contact</a></p>
        		<p>Copyright &copy; Example.com 2015 </p>
        	</div>
        </div>
	</footer>

	<style>
    #row_style {
        margin-top: 30px;
    }

    #submit {
        display: block;
        margin: auto;
    }
</style>

<!-- you need to include the shieldui css and js assets in order for the charts to work -->

<link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>

<script>
    $(function () {
        $("#editor").shieldEditor({
            height: 260
        });
    })
</script>
    <!-- jQuery -->
    <script src="js/jquery-1.11.3.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	
	<!-- IE10 viewport bug workaround -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
	
	<!-- Placeholder Images -->
	<script src="js/holder.min.js"></script>
	
</body>

</html>
