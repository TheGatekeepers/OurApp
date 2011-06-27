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
		
		public static $image_url_sets = array(
			"[ 'https://s3.amazonaws.com/hackend/books/alera.jpg', 'https://s3.amazonaws.com/hackend/books/changes.jpg', 'https://s3.amazonaws.com/hackend/books/dancewithdragons.jpg', 'https://s3.amazonaws.com/hackend/books/dragonbook4.jpg', 'https://s3.amazonaws.com/hackend/books/ghoststory.jpg', 'https://s3.amazonaws.com/hackend/books/robots.jpg', 'https://s3.amazonaws.com/hackend/books/throneoffire.jpg', 'https://s3.amazonaws.com/hackend/books/wwz.jpg', 'https://s3.amazonaws.com/hackend/books/zombieguide.jpg' ]",
			"[ 'https://s3.amazonaws.com/hackend/games/assassains_creed_brotherhood.jpg', 'https://s3.amazonaws.com/hackend/games/battlefield_3.jpg', 'https://s3.amazonaws.com/hackend/games/bioshock2.jpg', 'https://s3.amazonaws.com/hackend/games/codmw3.jpg', 'https://s3.amazonaws.com/hackend/games/duke_nukem_forever.jpg', 'https://s3.amazonaws.com/hackend/games/gears3.jpg', 'https://s3.amazonaws.com/hackend/games/me2.jpg', 'https://s3.amazonaws.com/hackend/games/me3.jpg', 'https://s3.amazonaws.com/hackend/games/xbox360.jpg' ]"
		);
	}
?>
