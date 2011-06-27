<?php
	error_reporting(E_ALL);
	require 'util.php';
	require 'db.php';
	$db = new DBUtil();
	
	$qr_string = Util::create_random_qr_string();
	$user_email = Util::get_user_email_from_header();
	$db->insert_qr_string($user_email, $qr_string);
?>
<?=$qr_string?>
