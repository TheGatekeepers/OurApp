<?php
	error_reporting(E_ALL);
	require 'util.php';
	require 'db.php';
	$db = new DBUtil();
	
	$status_message = 'false';
	$device_id = Util::get_device_id_from_header();
	$qr_string = Util::get_qr_string_from_header();
	
	
	if ($device_id && $qr_string && $db->is_qr_string_valid($qr_string)) {
		$db->update_device_id($device_id, $qr_string);
		$status_message = 'true';
	}
?>
<?=$status_message?>
