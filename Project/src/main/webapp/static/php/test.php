<?php
	$username = $_POST["username"];
	$password = $_POST["password"];
	class json{
		public $status = 0;
		public $data = array("userid" => "");
	}
	$j = new json();
	if($username == "aaa" && $password == "123"){
		$j->data["userid"] = "1";
		$j->status = 1;
	}
	echo json_encode($j);
?>