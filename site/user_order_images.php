
<?php
	error_reporting(E_ALL);
	require 'util.php';
	require 'db.php';
	$db = new DBUtil();
	
	//$device_id = Util::get_device_id_from_header();
	$qr_string = Util::get_qr_string_from_header();
	
	$user_email = ($qr_string) ? $db->user_email_for_qr_string($qr_string) : '';
	
	$correct_image_index = ($user_email) ? $db->correct_image_index_for_user_email($user_email) : 1;
	$image_set_index = ($user_email) ? $db->order_image_set_for_user_email($user_email) : 0;
	$image_url_set = Util::$image_url_sets[$image_set_index];
?>
{
	image_urls : <?=$image_url_set?>,
	correct_image_index : <?=$correct_image_index?>
}
