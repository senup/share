/*ajax
 *  参数
 *  请求方法：type
 *  请求地址：url
 *  参数对象：data
 *  成功函数：success
 *  失败函数：error
 *  限定时间：timeout
 * 	数据型式：dataTpye
 */
function ajax(option){
	//将参数对象转换为字符串
	var str
	if(option.dataType){
		if(option.dataType.toLowerCase() == "json"){
			if(option.data != null){
				str = JSON.stringify(option.data);
			}
		}
	}else{
		if(option.data != null){
			let array = [];
			for(let key in option.data){
				//防止url中有中文
				array.push(encodeURIComponent(key) + "=" + encodeURIComponent(option.data[key]));
				array.push("t=" + (new Date().getTime()));
			}
			str = array.join("&");
		}
	}
	
	//定时器标识
	let time;
	
	//1.创建异步对象
	let xmlhttp; 
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari 
		xmlhttp=new XMLHttpRequest(); 
	} 
	else {// code for IE6, IE5 
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
	}
	
	if(option.type.toLowerCase() == "get" && option.data != null)
		option.url += "?" + str;
	
	//2.设置请求方式和请求地址
	xmlhttp.open(option.type.toLowerCase(), option.url, true);
	
	//3发送请求
	if(option.type.toLowerCase() == "post"){
		//POST
		//添加HTTP头
		xmlhttp.setRequestHeader("Content-type", option.contentType ? option.contentType : "application/x-www-form-urlencoded");
		if(option.data != null){
			xmlhttp.send(str);
		}else{
			xmlhttp.send();
		}
	}else{
		//GET
		xmlhttp.send();
	}
	
	//4.监听状态的变化
	xmlhttp.onreadystatechange = ()=>{
		if (xmlhttp.readyState === 4) {
			//判断是否请求成功
			if ((xmlhttp.status >= 200 && xmlhttp.status <= 300) || xmlhttp.status === 304) {
				//停止定时
				if(option.timeout)
					clearInterval(time);
				option.success(xmlhttp);
			}else{
				option.error(xmlhttp);
			}
		}
	}
	
	//超过请求限定时间便停止请求（可设可不设，timeout参数为最后一个）
	if(option.timeout){
		time = setInterval(
					()=>{
						xmlhttp.abort();
						clearInterval(time);
					},
					option.timeout
				);
	}
}