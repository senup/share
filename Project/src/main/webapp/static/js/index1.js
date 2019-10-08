//判断登录，加载不同的模块
window.onload = ()=>{
	let hander = document.getElementsByTagName("header")[0];
	if(localStorage.getItem("id")){
		let div = document.createElement("div");
		div.id = "user";
		div.innerHTML = '<a href="userInformation.html">'+
						localStorage.getItem("userName")+
						'</a>'+'<nav class="hidden">'+
						'<li><a href="userInformation.html">个人信息</a></li>'+
						'<li><a href="userArticle.html">我的文章</a></li>'+
						'<li><a href="#">退出</a></li></nav>';
		hander.appendChild(div);
		let exit = document.getElementsByClassName("hidden")[0].lastElementChild;
		exit.onclick = ()=>{
			localStorage.clear();
			location.href = "index.html";
		}
	}else{
		let nav = document.createElement("nav");
		nav.id = "login_regiter";
		nav.innerHTML = '<a href="login.html">登陆</a>'+
						'<a href="register.html">注册</a>';
		hander.appendChild(nav);
	}
}