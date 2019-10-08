<?php
	//修改信息
	$artId= $_GET["artId"];
	class json{
		public $status = 0;
	}
	$j = new json();
	$j->status = 1;
	
	echo (json_encode($j));
?>