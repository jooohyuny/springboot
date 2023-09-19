function bye(){
	var really = prompt("탈퇴하려면 bye 입력");
	if (really == "bye") {
		location.href = "member.bye";
	}
}

function deleteMember(id){
	if (confirm("delete?")) {
		location.href = "member.delete?id="+id;
	}
}

function showProfile(id){
	location.href = "member.profile.show?id="+id;
}

function getProducts(id){
	location.href = "member.products.show?id="+id;
}

function getTownNews(id){
	location.href = "member.townNews.show?id="+id;
}

function getReportDetail(title, text, category){
	// js : replace는 첫줄만 바뀌게 -> 정규식 사용해야 다 변경 가능
	text = text.replace(/<br>/g, "\r\n");
	$("#adminReportTitle").val(title);
	$("#adminReportText").val(text);
	$("#adminReportCategory").val(category);
	
	$("#blackArea").css("left", "0px");
	$("#blackArea").css("top", "0px");
	$("#blackArea").css("background-color", "rgba(0, 0, 0, 0.7)");
}

function getReportPhoto(photo){
	location.href = "report.photo.get?photo="+photo;
}

function closeReportDetail(){
	$("#blackArea").css("left", "-100%");
	$("#blackArea").css("top", "-100%");
	$("#blackArea").css("background-color", "rgba(0, 0, 0, 0)");
}

function deleteTownNews(townNewsNum, id){
	if (confirm("delete?")) {
		location.href = "member.townNews.delete?townNewsNum="+townNewsNum+"&id="+id;
	}
}

function deleteProducts(productId, memberId){
	if (confirm("delete?")) {
		location.href = "member.products.delete?productId="+productId+"&id="+memberId;
	}
}

$(document).ready(function() {
	$('#memberProductsBtn').removeClass('active1');
	$('#memberTownNewsBtn').removeClass('active2');

    // 버튼1 클릭 시
    $('#memberProductsBtn').click(function() {
        // 다른 버튼의 스타일 제거
        $('#memberTownNewsBtn').removeClass('active2');
        
        // 버튼1 스타일 적용
        $(this).addClass('active1');
    });

    // 버튼2 클릭 시
    $('#memberTownNewsBtn').click(function() {
        // 다른 버튼의 스타일 제거
        $('#memberProductsBtn').removeClass('active1');
        
        // 버튼2 스타일 적용
        $(this).addClass('active2');
    });
});