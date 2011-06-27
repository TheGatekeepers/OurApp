<?php
	class DBUtil {
		private $hostname = 'localhost';
		private $database = 'hackend';
		private $username = 'root';
		private $password = 'hackend';
		private $conn;

		public function __construct() {
			$this->open();
		}

		public function open() {
			$this->conn = mysql_connect($this->hostname, $this->username, $this->password);
			if(!$this->conn)
				$this->showerror();

			if (!mysql_select_db($this->database, $this->conn))
				$this->showerror();
		}

		public function close() {
			mysql_close($this->conn);
		}

		public function select_devices() {
			$query = "select * from devices";
			$result = mysql_query($query) or die(mysql_error());
			return $result;
		}

		public function insert_qr_string($username, $qr_string) {
			$insert = "insert ignore into devices (username, qr_string) values ('{$username}', '{$qr_string}');";
			mysql_query($insert) or die(mysql_error());
		}

		public function is_qr_string_valid($qr_string) {
			$select = "select id from devices where qr_string = '{$qr_string}'";
			$result = mysql_query($select) or die(mysql_error());
			return mysql_num_rows($result) == 1;
		}

		public function user_email_for_qr_string($qr_string) {
			$select = "select username from devices where qr_string = '{$qr_string}'";
			$result = mysql_query($select) or die(mysql_error());
			$row = mysql_fetch_assoc($result);
			return $row['username'];
		}

		public function correct_image_index_for_user_email($user_email) {
			$select = "select correct_image_index from user_orders where username = '{$user_email}'";
			$result = mysql_query($select) or die(mysql_error());
			$row = mysql_fetch_assoc($result);
			return $row['correct_image_index'];
		}

		public function order_image_set_for_user_email($user_email) {
			$select = "select order_image_set from user_orders where username = '{$user_email}'";
			$result = mysql_query($select) or die(mysql_error());
			$row = mysql_fetch_assoc($result);
			return $row['order_image_set'];
		}

		public function update_device_id($device_id, $qr_string) {
			$update = "update devices set device_id = '{$device_id}' where qr_string = '{$qr_string}'";
			mysql_query($update) or die(mysql_error());
		}

		function showerror() {
			die("Error " . mysql_errno() . ":" . mysql_error());
		}
	}
?>
