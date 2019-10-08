<?php
	//发布文章
	$sessionId = $_GET["userid"];
	$title = $_GET["title"];
	$content = $_GET["content"];
	$typename = $_GET["sortName"];
	class json{
		public $status = 0;
	}
	$j = new json();
	$j->status = 1;
	echo (json_encode($j));
?>