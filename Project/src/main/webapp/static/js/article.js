	sessionStorage.setItem('userid',1); 
function setCookie(c_name,value,expiredays){
    var exdate=new Date();

    exdate.setDate(exdate.getDate()+expiredays);//设置时期 获取 + 1
    document.cookie=c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
  }
	var user =  sessionStorage.getItem('userid');
    setCookie('userName',user,1); // cookie过期时间为1天。
// 函数中的参数为 要获取的cookie键的名称。
//function getCookie(userName){
//    if (document.cookie.length>0){
//      c_start=document.cookie.indexOf(userName+ "=");
//      if (c_start!=-1){
//        c_start=c_start + userName.length+1;
//        c_end=document.cookie.indexOf(";",c_start);
//        if (c_end==-1){ 
//            c_end=document.cookie.length;
//        }
//        return unescape(document.cookie.substring(c_start,c_end));
//      }
//   }
//  return "";
//}
//var  userName = getCookie('userName');
//  console.log(userName);
$("#btn").click(function(){
	

	
	
	//获取select option中文本的值，标题，文章分类，文章内容
	var title = $("#title").val();
	var Ttypename= $('#sel  option:selected').text();
	var content = $("#content").val();
//	console.log(title +Ttypename+content)
	$.ajax({
		type:"POST",
		url:"http://2zu4901772.zicp.vip:57279/process.php",

		data:{"Ttypename":Ttypename,"title":title,"content":content},
		success:function(data){
			console.log(data)
			console.log(title);
		
			location.href = "new_file.html"  //跳转页面
											
		},
		error:function(){
			alert("文章发布失败!");
			
		}
	});
	
	
	
	
	
	
	
})





