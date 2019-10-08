<?php
	//修改信息
	$sessionId = $_COOKIE["PHPSESSID"];
	$articleId = $_GET["id"];
	session_id($sessionId);
	session_start();
	class json{
		public $status = 0;
		public $data = array("title"=>"","content"=>"","sortName" => "");
	}
	$articles =array(array("title" => "a", "content" => "aaaaaaaaaaaaaa
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
	
	aaaaa", "sortName" => "前端", "id" => 1),
				array("title" => "b", "content" => "bbbbbbbbb", "sortName" => "前端", "id" => 2),
				array("title" => "c", "content" => "ccccccccc", "sortName" => "前端", "id" => 3),
				array("title" => "d", "content" => "ddddddddd", "sortName" => "前端", "id" => 4),
				array("title" => "e", "content" => "eeeeeeeee", "sortName" => "前端", "id" => 5),
				array("title" => "f", "content" => "fffffffff", "sortName" => "前端", "id" => 6),
				array("title" => "g", "content" => "ggggggggg", "sortName" => "前端", "id" => 7),
				array("title" => "a", "content" => "aaaaaaaaa", "sortName" => "前端", "id" => 8),
				array("title" => "b", "content" => "bbbbbbbbb", "sortName" => "前端", "id" => 9),
				array("title" => "c", "content" => "cccccccc", "sortName" => "前端", "id" => 10),
				array("title" => "d", "content" => "dddddddd", "sortName" => "前端", "id" => 11),
				array("title" => "e", "content" => "eeeeeeee", "sortName" => "前端", "id" => 12),
				array("title" => "f", "content" => "ffffffff", "sortName" => "前端", "id" => 13),
				array("title" => "a", "content" => "aaaaaaaaa", "sortName" => "前端", "id" => 14),
				array("title" => "b", "content" => "bbbbbbbbb", "sortName" => "前端", "id" => 15),
				array("title" => "c", "content" => "ccccccccc", "sortName" => "前端", "id" => 16),
				array("title" => "d", "content" => "ddddddddd", "sortName" => "前端", "id" => 17),
				array("title" => "e", "content" => "eeeeeeeee", "sortName" => "前端", "id" => 18),
				array("title" => "f", "content" => "fffffffff", "sortName" => "前端", "id" => 19));
	$j = new json();
	for($i = 0; $i < count($articles); $i++){
		if($articles[$i]["id"] == $articleId){
			$j->data["title"] = $articles[$i]["title"];
			$j->data["content"] = $articles[$i]["content"];
			$j->data["sortName"] = $articles[$i]["sortName"];
			break;
		}
	}
	$j->status = 1;
	
	echo (json_encode($j));
?>