<?php
	class Util {
		public static function create_random_qr_string() {
			return mt_rand() . '' . mt_rand();
		}
		
		public static function get_user_email_from_header() {
			foreach (getallheaders() as $name => $value)
				if ($name == 'x-user-email')
					return $value;
			
			return null;
		}
		
		public static function get_qr_string_from_header() {
			foreach (getallheaders() as $name => $value)
				if ($name == 'x-qr-string')
					return $value;
			
			return null;
		}
		
		public static function get_device_id_from_header() {
			foreach (getallheaders() as $name => $value)
				if ($name == 'x-device-id')
					return $value;
			
			return null;
		}
	}
?>
