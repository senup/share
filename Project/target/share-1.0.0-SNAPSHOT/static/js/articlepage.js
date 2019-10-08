// 函数中的参数为 要获取的cookie键的名称。
function getCookie(userName) {
	if(document.cookie.length > 0) {
		c_start = document.cookie.indexOf(userName + "=");
		if(c_start != -1) {
			c_start = c_start + userName.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if(c_end == -1) {
				c_end = document.cookie.length;
			}
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}
var userid = localStorage.getItem("id");

var username = localStorage.getItem("userName");
var artId = localStorage.getItem("artId");

//获取文章内容
$.ajax({
	type: "GET",
//	url: "http://2zu4901772.zicp.vip:57279/process.php",

	url: "http://127.0.0.1:8080/article/visitArticle",
	async: true,
	data: {
		"artId": artId,
	},
	success: function(d) {
		//java
		var d = d.data;
		$('title').html(d.title); //文章标题
		$('#username1').html(d.userName); //用户名
		$('.username1').html(d.userName); //用户名
		$('.article-title h2').html(d.title); //文章标题
		$('.neirong').html(d.content); //文章内容
		$('.time').html(d.time); //文章发表时间
		var lx;
		if(d.sortId == 1){
			lx = "前端"
		}
		$('#zanshu').html(d.articleLikeNum); //文章赞数
		$('.lx').html(lx); //文章类型
//php
//		var d = JSON.parse(data);
//		$('title').html(d.title); //文章标题
//		var username = d.username;
//		$('#username1').html(username); //用户名
//		$('.username1').html(username); //用户名
//		$('.article-title h2').html(d.title); //文章标题
//		$('.neirong').html(d.content); //文章内容	
//		$('.time').html(d.time); //文章发表时间
//		$('#zanshu').html(d.zanshu); //文章赞数
//		$('.lx').html(d.lx); //文章类型

	},
	error: function() {
		alert("评论获取失败!");

	}

});
//获取文章评论
$.ajax({
	type: "GET",
//	url: "http://2zu4901772.zicp.vip:57279/process.php",
				          
	url: "http://127.0.0.1:8080/comment/getCommentByArtId",
	async: true,
	data: {
		"artId": artId
	},
	success: function(d) {
		var pl='';
		var d = d.data;
		for (var i = 0;i<d.length;i++) {
			if(userid == d[i].commentUserId){
						pl +=` <p class="cr"><img src="img/logo1.jpg" /><span class="plname" data-id = "${d[i].commentUserId}" >${d[i].commentUserName}</span>:<span class="plnr" >${d[i].commentContent}</span><span class="plnr">${d[0].time}</span><span id="huifu"><a class="jubao" plid = ${d[i].commentId} onclick="shanchu(this)">删除</a></p>
						
			`;	
			}else{
				pl +=`<p class="cr"><img src="img/logo1.jpg" /><span class="plname" data-id = "${d[i].commentUserId}" >${d[i].commentUserName}</span>:<span class="plnr" plid = ${d[i].commentId} >${d[i].commentContent}</span><span class="plnr">${d[0].time}</span><span id="huifu"><a  class="jubao" >举报</a> <a class="jubao">回复</a></p>
				`;

			}
			
			
		}
		$('.comment1').prepend(pl);

				
//		var d = JSON.parse(data);
//		console.log(userid);
//		console.log(d.userid +  "11")
//		if(userid === d.uesrid){
//		var pl = `<img src="img/logo1.jpg" /><span class="plname" data-id = "1" >${d.plname}</span>:<span class="plnr">${d.comment}</span><span id="huifu"><a class="jubao">删除</a>`;
//		$('.cr').html(pl);
//			
//		}else{
//		var pl = `<img src="img/logo1.jpg" /><span class="plname" data-id = "1" >${d.plname}</span>:<span class="plnr">${d.comment}</span><span id="huifu"><a  class="jubao" >举报</a> <a class="jubao">回复</a>`;
//		$('.cr').html(pl);
//			
//		}
//		

	},
	error: function() {
		alert("文章获取失败!");

	}

});


//评论框获得焦点，高度增加
$('#pingl').focus(function() {
	$(this).animate({
		height: "100px"
	}, 300);
})
//评论框失去焦点，高度还原
$('#pingl').blur(function() {

	$(this).animate({
		height: "38px"
	}, 300);

})
//点赞



$("#dizan").click(function() {
	
	 var id = userid;
	if(userid ==null){
		alert("请先登录");
		return ;
	}
	if(localStorage.getItem("key") == 1) {
	localStorage.setItem("key","0");

		//评论人ID；文章id
	
		var plname = $('.plname').text();
		var plnr = $('.plnr').text();
		var zanshu = $('#zanshu').text();
		var xzs = parseInt(zanshu) + 1;
		console.log(xzs);
		//传递点赞用户id，
	
				$.ajax({
					type:"GET",
					url:"http://127.0.0.1:8080/article/addArticleLikeNum",
					async:true,
					data:{"artId":artId,"id":userid},
					success:function(d){
							console.log(d);
							if(d.status==1){
							$("#dizan").css("color","red");
							$('#zanshu').html(xzs);								
							}

					},
					error:function(){
				
					alert("删除失败")
			}
		 		});

	} else {
		localStorage.setItem("key","1");

		var plname = $('.plname').text();
		var plnr = $('.plnr').text();
		var zanshu = $('#zanshu').text();
		var xzs = parseInt(zanshu) - 1;
	
				$.ajax({
					type:"GET",
					url:"http://127.0.0.1:8080/article/removeArticleLike",
					async:true,
					data:{"artId":artId,"id":userid},
					success:function(d){
									if(d.status==1){
									$("#dizan").css("color","black");
									$('#zanshu').html(xzs);		
										
									}

					},
					error:function(){
				
					alert("删除失败")
			}
		 		});
		
	}

})

$(function() {


//	userid = getCookie('userid');
	if(userid != null) {
		$('.double').css('display', 'none');

	}

})
//发表评论
$('.fb-btn').click(function(){
	var text = $("textarea").val();
	if(userid === null){
		
		alert("请先登录！！！");
		return;
	}
			
	if(text ==' '){
			
			alert("评论不能为空");
			return;
	}
	

		$("textarea").val(' ');
		var arr = {"commentUserId":userid,"artId":artId,"commentContent":text};
		//向后台发请求，储存评论内容
		$.ajax({
			type:"POST",
			url:"http://127.0.0.1:8080/comment/addComment",
			async:true,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data:JSON.stringify(arr),
			success:function(d){
				if(d.status==1){
					var pl = `<p class="cr"><img src="img/logo1.jpg" /><span class="plname" data-id = "1" >${username}</span>:<span class="plnr">${text}</span><span id="huifu"><a class="jubao" onclick="shanchu(this);">删除</a></p>`;
					$('.comment1').prepend(pl);			
					
				}else{
					alert("失败")
				}
					

				
			},
			error:function(){
				
				alert("发表失败")
			}
		
		});
		
	

	

});
var gz = true;
$("#gz").click(function(){
	if(gz == true){
			 gz = false;
			$(this).css('background','#b2b8bd');
	}
  else{
  			$(this).css('background','white');
  			gz = true;
  	
  }

})
//删除评论内容
function shanchu(even){
		commentUserId = even.getAttribute("plid");
		console.log(commentUserId );
		console.log(userid)
		console.log(artId);

		$.ajax({
			type:"GET",
			url:"http://127.0.0.1:8080/comment/removeComment",
			async:true,
			data:{"commentUserId":userid,"commentId":commentUserId,"artId":artId },
			success:function(d){	
			console.log(d);
			},
			error:function(){
				
				alert("删除失败")
			}

		});
		
	
 var comm = even.parentNode.parentNode;
 	 comm.remove();

	
}
$(function(){
	if(localStorage.getItem("key") ==0){
	$("#dizan").css("color","red");
	
}
	
})
