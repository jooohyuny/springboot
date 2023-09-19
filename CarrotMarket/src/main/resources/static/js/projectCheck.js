function joinCheck(form) {
	var idField = form.id;
	var pwField = form.pw;
	var pwChkField = form.pwChk;
	var nameField = form.name;
	var birthField = form.birth;
	var addr1Field = form.address1;
	var addr2Field = form.address2;
	var addr3Field = form.address3;
	var photoField = form.photoo;

	if (isEmpty(idField) || containsHS(idField) || 
			$("#memberJoinID").css("color") == "rgb(255, 0, 0)") {
		alert("id?");
		idField.value = "";
		idField.focus();
		return false;
	}
	if (isEmpty(pwField) || lessThan(pwField, 4) || notEquals(pwField, pwChkField) || notContains(pwField, "1234567890")) {
		alert("pw?");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	}
	if (isEmpty(nameField)) {
		alert("name?");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	if (isEmpty(birthField)) {
		alert("birthday?");
		birthField.value = "";
		birthField.focus();
		return false;
	}
	if (isEmpty(addr1Field) || isEmpty(addr2Field) || isEmpty(addr3Field)) {
		alert("address?");
		addr1Field.value = "";
		addr2Field.value = "";
		addr3Field.value = "";
		addr1Field.focus();
		return false;
	}
	if (isEmpty(photoField) || 
			(isNotType(photoField, "png") && isNotType(photoField, "jpg") && isNotType(photoField, "gif"))) {
		alert("photo?");
		photoField.value = "";
		return false;
	}
	return true;
}

function loginCheck(f) {
	var idField = f.id;
	var pwField = f.pw;

	if (isEmpty(idField)) {
		alert("id?");
		idField.value = "";
		idField.focus();
		return false;
	}
	if (isEmpty(pwField)) {
		alert("pw?");
		pwField.value = "";
		pwField.focus();
		return false;
	}
	return true;
}

function memberUpdateCheck(f) {
	var pwField = f.dm_pw;
	var pwChkField = f.dm_pwChk;
	var nameField = f.dm_name;
	var addr1Field = f.dm_address1;
	var addr2Field = f.dm_address2;
	var addr3Field = f.dm_address3;
	var photoField = f.dm_photo;

	if (isEmpty(pwField) || lessThan(pwField, 4) || notEquals(pwField, pwChkField) || notContains(pwField, "1234567890")) {
		alert("pw?");
		pwField.value = "";
		pwChkField.value = "";
		pwField.focus();
		return false;
	}
	if (isEmpty(nameField)) {
		alert("name?");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	if (isEmpty(addr1Field) || isEmpty(addr2Field) || isEmpty(addr3Field)) {
		alert("address?");
		addr1Field.value = "";
		addr2Field.value = "";
		addr3Field.value = "";
		addr1Field.focus();
		return false;
	}
	if (isEmpty(photoField)) {
		return true;
	}
	if ((isNotType(photoField, "png") && isNotType(photoField, "jpg") && isNotType(photoField, "gif"))) {
		alert("photo?");
		photoField.value = "";
		return false;
	}
	return true;
}