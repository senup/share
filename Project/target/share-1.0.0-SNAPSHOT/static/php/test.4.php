<?php
	//修改信息
	$username = $_GET["username"];
	$idiograph = $_GET["idiograph"];
	$gender = $_GET["gender"];
	class json{
		public $status = 0;
		// public $data = array("username" => "", "gender" => "", "idiograph" => "");
	}
	$j = new json();
	$j->status = 1;
	// $j->data["username"] = $username;
	// $j->data["gender"] = $gender;
	// $j->data["idiograph"] = $idiograph;
	
	echo(json_encode($j));
?>