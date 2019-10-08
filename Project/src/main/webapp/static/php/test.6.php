<?php
	//修改信息
	$sessionId = $_COOKIE["PHPSESSID"];
	session_id($sessionId);
	session_start();
	session_destroy();
?>