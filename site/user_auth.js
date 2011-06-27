window.init = function() {
	window.emailInput = document.getElementById('email-input');
	window.passwordInput = document.getElementById('password-input');
	window.generateButton = document.getElementById('generate-qr-code-button');
	window.blankInputMessage = document.getElementById('blank-input-message');
	window.badEmailMessage = document.getElementById('bad-email-message');
	window.qrImageSection = document.getElementById('qr-image-section');
	window.qrImage = document.getElementById('qr-image');
	window.qrImageSource = 'http://qrcode.kaywa.com/img.php?s=8&d=';
	
	window.generateButton.onclick = generateQrCodeButtonWasPressed;
};

window.generateQrCodeButtonWasPressed = function() {
	if (!emailInput.value || !passwordInput.value) {
		window.blankInputMessage.show();
		window.badEmailMessage.hide();
	} else if (!emailInput.value.contains('@')) {
		window.badEmailMessage.show();
		window.blankInputMessage.hide();
	} else {
		showQrCode();
	}
};

window.showQrCode = function() {
	window.addDbEntry(emailInput.value);
	
	window.blankInputMessage.hide();
	window.badEmailMessage.hide();
	window.qrImageSection.makeOpaque();
	
	window.generateButton.onclick = null;
	window.generateButton.className = 'inactive';
	window.emailInput.disabled = true;
	window.passwordInput.disabled = true;
};

window.addDbEntry = function(userEmail) {
	var req = new XMLHttpRequest();
	req.open('POST', 'user_auth.php', false);
	req.setRequestHeader('Content-Type', 'text/plain;charset=UTF-8');
	req.setRequestHeader('x-user-email', userEmail);
	req.send(userEmail);
	if (req.status == 200) {
		window.qrImage.src = window.qrImageSource + req.responseText;
	}
}


// util
HTMLElement.prototype.hide = function() { this.className += ' hidden'; };
HTMLElement.prototype.show = function() { this.className = this.className.replace(/ ?hidden/g, ''); };
HTMLElement.prototype.makeTransparent = function() { this.className += ' transparent'; };
HTMLElement.prototype.makeOpaque = function() { this.className = this.className.replace(/ ?transparent/g, ''); };
Array.prototype.contains = function(element) { return this.indexOf(element) >= 0; };
String.prototype.contains = function(substring) { return this.indexOf(substring) >= 0; };
// /util
