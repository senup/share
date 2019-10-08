<?php
	//修改信息
	$sessionId = $_GET["userid"];
	class json{
		public $status = 0;
		public $username = "aaa";
		public $data =array(array("title" => "a", "content" => "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
	aaaaaaaaaaaaaaaaaaa
	aaaaaaaa
	aaaaa
	aaaa
	aa
	aaaaaaa
	aaaaaaaaaaaaaaa
	aa
	aaaa
	aaaaaaaaaaaa
	aaaaaaaaaaaaaaaa
	a
	aaaa
	aaaa
	aaaaaaaaaaaaaaa
	aaaaa
	aaaaaa
	aaaaa
	aaaaaaaaaaaaa
	aaaaa
	aaaa
	aaaaaa
	aa
	
	aaaaa", "sortName" => "前端", "artid" => 1, "time" => "2019/5/25"),
							array("title" => "b", "content" => "bbbbbbbbb", "sortName" => "前端", "artid" => 2, "time" => "2019/4/25"),
							array("title" => "c", "content" => "ccccccccc", "sortName" => "前端", "artid" => 3, "time" => "2019/3/25"),
							array("title" => "d", "content" => "ddddddddd", "sortName" => "前端", "artid" => 4, "time" => "2019/2/25"),
							array("title" => "e", "content" => "eeeeeeeee", "sortName" => "前端", "artid" => 5, "time" => "2019/1/25"),
							array("title" => "f", "content" => "fffffffff", "sortName" => "前端", "artid" => 6,"time" => "2019/5/20"),
							array("title" => "g", "content" => "ggggggggg", "sortName" => "前端", "artid" => 7,"time" => "2019/5/21"),
							array("title" => "a", "content" => "aaaaaaaaa", "sortName" => "前端", "artid" => 8,"time" => "2019/5/25"),
							array("title" => "b", "content" => "bbbbbbbbb", "sortName" => "前端", "artid" => 9,"time" => "2019/5/25"),
							array("title" => "c", "content" => "cccccccc", "sortName" => "前端", "artid" => 10,"time" => "2019/5/25"),
							array("title" => "d", "content" => "dddddddd", "sortName" => "前端", "artid" => 11,"time" => "2019/5/25"),
							array("title" => "e", "content" => "eeeeeeee", "sortName" => "前端", "artid" => 12,"time" => "2019/5/25"),
							array("title" => "f", "content" => "ffffffff", "sortName" => "前端", "artid" => 13,"time" => "2019/5/25"),
							array("title" => "a", "content" => "aaaaaaaaa", "sortName" => "前端", "artid" => 14,"time" => "2019/5/25"),
							array("title" => "b", "content" => "bbbbbbbbb", "sortName" => "前端", "artid" => 15,"time" => "2019/5/25"),
							array("title" => "c", "content" => "ccccccccc", "sortName" => "前端", "artid" => 16,"time" => "2019/5/25"),
							array("title" => "d", "content" => "ddddddddd", "sortName" => "前端", "artid" => 17,"time" => "2019/5/25"),
							array("title" => "e", "content" => "eeeeeeeee", "sortName" => "前端", "artid" => 18,"time" => "2019/5/25"),
							array("title" => "f", "content" => "fffffffff", "sortName" => "前端", "artid" => 19,"time" => "2019/5/25"));
	}
	$j = new json();
	$j->status = 1;
	
	echo (json_encode($j));
?>