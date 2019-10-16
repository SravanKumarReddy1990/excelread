<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>5 Живой чат / Live chat </title>
    
    
    <link rel="stylesheet" href="css/normalize.css">

    
        <link rel="stylesheet" href="css/style.css">

    
    
    
  </head>

  <body>
<%@ page import="java.sql.*" %>

<%String id=(String)session.getAttribute("id");  %>
    	<div class="ui">
		<div class="left-menu">
				<form action="#" class="search">
					<input placeholder="search..." type="search" name="" id="">
					<input type="submit" value="&#xf002;">
				</form>
				<menu class="list-friends">
<% String url = "jdbc:postgresql://ec2-23-21-160-80.compute-1.amazonaws.com:5432/d4ovlnqvutd1j7";
            Connection conn = 							DriverManager.getConnection(url,"ckimwlfkyjkcvd","8a898408823185c78744e7bd54d71c87a4b0953ccd7271657265386796e24cbd");

ResultSet resultSet = conn.prepareStatement("select id,name,imageid from users").executeQuery();
 int id=0;
while(resultSet.next()){ %>
					<li>
						<img width="50" height="50" src="http://cs625730.vk.me/v625730358/1126a/qEjM1AnybRA.jpg">
						<div class="info">
							<div class="user"><%=resultSet.getString("name"); %></div>
							<div class="status on"> online</div>
						</div>
					</li>
<% }  
resultSet.close();
conn.close();
	%>			</menu>
		</div>
		<div class="chat">
			<div class="top">
				<div class="avatar">
					<img width="50" height="50" src="http://cs625730.vk.me/v625730358/1126a/qEjM1AnybRA.jpg">
				</div>
				<div class="info">
					<div class="name">Юния Гапонович</div>
					<div class="count">already 1 902 messages</div>
				</div>
				<i class="fa fa-star"></i>
			</div>
			<ul class="messages">
				<li class="i">
					<div class="head">
						<span class="time">10:13 AM, Today</span>
						<span class="name">Буль</span>
					</div>
					<div class="message">Привет!</div>
				</li>
				<li class="i">
					<div class="head">
						<span class="time">10:13 AM, Today</span>
						<span class="name">Буль</span>
					</div>
					<div class="message">)</div>
				</li>
				<li class="i">
					<div class="head">
						<span class="time">10:14 AM, Today</span>
						<span class="name">Буль</span>
					</div>
					<div class="message">М не счастья..</div>
				</li>
				<li class="friend-with-a-SVAGina">
					<div class="head">
						<span class="name">Юния</span>
						<span class="time">10:15 AM, Today</span>
					</div>
					<div class="message">чего тебе?</div>
				</li>
			</ul>
			<div class="write-form">
				<textarea placeholder="Type your message" name="e" id="texxt"  rows="2"></textarea>
				<i class="fa fa-picture-o"></i>
				<i class="fa fa-file-o"></i>
				<span class="send">Send</span>
			</div>
		</div>
	</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/nicescroll/3.5.4/jquery.nicescroll.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
