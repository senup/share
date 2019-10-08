//设置cookie
/*
* cname:参数名
* cvalue：参数值
* exdays：保存期限（日）
*/
function setCookie(cname,cvalue,exdays)
{
	var day = new Date();
	day.setTime(day.getTime()+(exdays*24*60*60*1000));
	var expires = "expires="+day.toGMTString();
	document.cookie = cname + "=" + cvalue + "; " + "path" + "=" + "/;" + expires;
}
//读取对应的参数值并返回对应的字符串（须处理） 查找不到则返回空串
function getCookie(cname)
{
	//设置搜索格式
	var name = cname + "=";
	//创建cookie数组
	var ca = document.cookie.split(';');
	//查到找对应参数值
	for(var i=0; i<ca.length; i++)
	{
		//清除空格
		var c = ca[i].trim();
		//判断是否正确
		if (c.indexOf(name)==0){
			//获取两个下标之间的值并返回
			return c.substring(name.length,c.length);
		}
	}
	//查询不到返回空串
	return ""; 
}
function clearCookie(cname){
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval = getCookie(name);
  if (cval != null) 
    document.cookie = cname + "=" + cval + ";expires=" + exp.toGMTString()+";path=/";
}