<?php
	//注册
	$username = $_POST["username"];
	$password = $_POST["password"];
	class json{
		public $status = 0;
		public $data = array("userid" => "");
	}
	$j = new json();
	$j->status = 1;
	$j->data["userid"] = "1";
	echo(json_encode($j));
?>