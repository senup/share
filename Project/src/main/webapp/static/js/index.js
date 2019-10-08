////判断登录，加载不同的模块
//window.onload = ()=>{
//	let hander = document.getElementsByTagName("header")[0];
//	if(localStorage.getItem("id")){
//		let div = document.createElement("div");
//		div.id = "user";
//		div.innerHTML = '<a href="userInformation.html">'+
//						localStorage.getItem("userName")+
//						'</a>'+'<nav class="hidden">'+
//						'<li><a href="userInformation.html">个人信息</a></li>'+
//						'<li><a href="userArticle.html">我的文章</a></li>'+
//						'<li><a href="#">退出</a></li></nav>';
//		hander.appendChild(div);
//		let exit = document.getElementsByClassName("hidden")[0].lastElementChild;
//		exit.onclick = ()=>{
//			localStorage.clear();
//			location.href = "index.html";
//		}
//	}else{
//		let nav = document.createElement("nav");
//		nav.id = "login_regiter";
//		nav.innerHTML = '<a href="login.html">登陆</a>'+
//						'<a href="register.html">注册</a>';
//		hander.appendChild(nav);
//	}
//}
	//进入页面发送请求，获取文章信息
	$.ajax({
	type: "GET",
//	type: "POST",
	url: "http://127.0.0.1:8080/article/getAllArticle",

//	url: "process.php",
//	url: "http://127.0.0.1:8080/article/getAllArticle",
	async: true,
	data: {
		"sortI": 1,
		"title": 1,
		"content": 1
	},
	success: function(d) {

		
		console.log(d);

		var pl= '';
		for (var i = 0;i<d.data.length;i++) {
			 pl+= `	<li class="wenzhang">
					<h2><a href="articlepage.html" onclick="print(this)" data = "${d.data[i].artId}" >${d.data[i].title}</a></h2>
					<div class="con">
					${d.data[i].content}
					</div>
						<div class="user">
						<img src="img/logo1.jpg"/>
						<span class="name" data-id = "${d.data[i].userid}">
						 ${d.data[i].userName}
							</span>
							<div class="interval">
										
							</div>
							<span class="time">
								${d.data[i].time}
									</span>
								</div>
							</li>
		`;
	
		
		}
//			console.log(pl);
		$("#crnr").prepend(pl);	
		


	},
	error: function() {
		alert("页面加载失败！！！");

	}

});
// 先绑定事件再添加div
function print(e) {
			var c = e.getAttribute('data');
			
			localStorage.setItem("artId",c);


	console.log(localStorage.getItem("artId") + "这是最后的值");
	
	

	

}


	//点击侧边栏变换背景颜色，发送文章请求
	$(".nva_com ul li").click(function(){
		
		$(this).css("background","#F44444").siblings().css("background","white");
		$(this).siblings().children().css("color","#707070");
		$(this).children().css("color","white")
		//同时发送请求
		
	
	})

	
	
	


window.onscroll = function(){
	
	var scrollTop = document.documentElement.scrollTop||window.pageYoffset||document.body.scrollTop;
	if(scrollTop >=80){
		$("#nav").addClass("posi");
		
	}
	else{
	
	$("#nav").removeClass("posi");
	}
	
	
//	console.log(scrollTop);

}
//搜索查询
$("#sousuo").click(function(){
	var title = $("#userval").val();

	$.ajax({
		type:"post",
		url:"http://127.0.0.1:8080/article/getAllArticleByTitle",
		data:{"title":title},
		async:true,
		success:function(d){	
//		var d = JSON.parse(da);
//		$("#crnr").empty();
////php后台		
//		for (var i = 20;i<30;i++) {
//			var pl = `<li class="wenzhang">
//					<h2><a  href="articlepage.html" onclick="print(this)" data = "${i}">${d.title}${i}</a></h2>
//					<div class="con">
//					${d.content}
//					</div>
//						<div class="user">
//						<img src="img/logo1.jpg"/>
//						<span class="name" data-id = "${d.userid}">
//						 ${d.username}
//							</span>
//							<div class="interval">
//										
//							</div>
//							<span class="time">
//								${d.time}
//									</span>
//								</div>
//							</li>
//		
//		
//		`;
//		$("#crnr").prepend(pl);	
//		}	
//java后台	
		$("#crnr").empty();
		var pl ='';
		for (var i = 0;i<d.data.length;i++) {
			 pl+= `<li class="wenzhang">
					<h2><a href="articlepage.html" onclick="print(this)" data = "${d.data[i].artId}" >${d.data[i].title}</a></h2>
					<div class="con">
					${d.data[i].content}
					</div>
						<div class="user">
						<img src="img/logo1.jpg"/>
						<span class="name" data-id = "${d.data[i].userid}">
						 ${d.data[i].userName}
							</span>
							<div class="interval">
										
							</div>
							<span class="time">
								${d.data[i].time}
									</span>
								</div>
							</li>
		`;
	
		
		}
//			console.log(pl);
		$("#crnr").prepend(pl);	
		},
		error:function(){
			alert("失败!!!");
		}
	});
})
//分类搜索
$(".artid").click(function(){
	 var sortId =  $(this).text();
	 console.log(sortId);
		$.ajax({
		type:"GET",
		url:"http://127.0.0.1:8080/article/getAllArticleBySortId",
		data:{"sortId":1},
		async:true,
		success:function(d){	
			console.log(d);
//		var d = JSON.parse(da);
//		$("#crnr").empty();
////php后台		
//		for (var i = 20;i<30;i++) {
//			var pl = `<li class="wenzhang">
//					<h2><a  href="articlepage.html" onclick="print(this)" data = "${i}">${d.title}${i}</a></h2>
//					<div class="con">
//					${d.content}
//					</div>
//						<div class="user">
//						<img src="img/logo1.jpg"/>
//						<span class="name" data-id = "${d.userid}">
//						 ${d.username}
//							</span>
//							<div class="interval">
//										
//							</div>
//							<span class="time">
//								${d.time}
//									</span>
//								</div>
//							</li>
//		
//		
//		`;
//		$("#crnr").prepend(pl);	
//		}	
//java后台		

console.log(2);
$("#crnr").empty();
		var pl ='';
		for (var i = 0;i<d.data.length;i++) {
			 pl+= `	<li class="wenzhang">
					<h2><a href="articlepage.html" onclick="print(this)" data = "${d.data[i].artId}" >${d.data[i].title}</a></h2>
					<div class="con">
					${d.data[i].content}
					</div>
						<div class="user">
						<img src="img/logo1.jpg"/>
						<span class="name" data-id = "${d.data[i].userid}">
						 ${d.data[i].userName}
							</span>
							<div class="interval">
										
							</div>
							<span class="time">
								${d.data[i].time}
									</span>
								</div>
							</li>
		`;
	
		
		}
//			console.log(pl);
		$("#crnr").prepend(pl);		
		},
		error:function(){
			alert("失败!!!");
		}
	});
	
	
})
localStorage.setItem("key","1");