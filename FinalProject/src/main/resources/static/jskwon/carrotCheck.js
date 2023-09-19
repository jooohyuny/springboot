function uploadCheck(form) {
	var photoField = form.photoo;
	var nameField = form.name;
	var priceField = form.price;
	var descField = form.description;
	var cateField = form.category;

	if (isEmpty(nameField)) {
		alert("상품명을 입력하세요.");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	if (isNotType(photoField, "png") && isNotType(photoField, "jpg")) {
		alert("사진 파일이 아닙니다.");
		photoField.value = "";
		return false;
	}
	if (isNotNum(priceField) || isEmpty(priceField)) {
		alert("가격을 제대로 입력하세요.");
		priceField.value = "";
		priceField.focus();
		return false;
	}
	if (isEmpty(descField)) {
		alert("상품 설명을 입력하세요.");
		descField.focus();
		return false;
	}

	if (cateField.value === "카테고리를 선택하세요." || cateField.value === "---------------------------------") {
		alert("카테고리를 선택하세요.");
		return false;
	}

	return true;

}