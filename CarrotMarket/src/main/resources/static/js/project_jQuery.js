
function connectSummonAddressSearchAreaEvent() {
	$("#memberJoinAddr1, #memberJoinAddr2").click(function() {
		new daum.Postcode({
	        oncomplete: function(data) {
	            $("#memberJoinAddr1").val(data.zonecode);
	            $("#memberJoinAddr2").val(data.address);
	        }
	    }).open();
	});
}

function connectMemberIDCheckEvent(){
	$("#memberJoinID").keyup(function(e) {
		var id = $(this).val();
		$.ajax({
			uri : "member.get",
			data : {id : id},
			success : function(memberData) {
				if(memberData.members[0] == null) {
					$("#memberJoinID").css("color", "black");
				} else {
					$("#memberJoinID").css("color", rgb(255, 0, 0));
				}
			}
		});
	});
}

$(function(){
	connectSummonAddressSearchAreaEvent();
	connectMemberIDCheckEvent();
});