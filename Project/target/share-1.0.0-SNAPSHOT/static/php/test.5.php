<?php
	//修改信息
	$password = $_POST["password"];
	$newpassword = $_POST["newpassword"];
	$sessionId = $_POST["username"];
	class json{
		public $status = 0;
	}
	$j = new json();
	if($password == 123){
		$j->status = 1;
	}
	
	echo(json_encode($j));
?>