<?php
	//获取信息
	$userId = $_GET["userid"];
	class json{
		public $status = 0;
		public $data = array('username' => "", "gender" => "", "idiograph" => "");
	}
	$j = new json();
	$j->status = 1;
	$j->data["username"] = "aaa";
	$j->data["gender"] = "男";
	$j->data["idiograph"] = "内容内容";
	
	echo (json_encode($j));
?>