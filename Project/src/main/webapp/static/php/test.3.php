<?php
	//检查用户名
	$username = $_GET["username"];
	class json{
		public $status = 0;
	}
	$j = new json();
	$j->status = 0;
	echo(json_encode($j));
?>