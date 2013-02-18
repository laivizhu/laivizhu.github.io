
function msgBox(string, tip){
	$('body').append('<div class="modal hide fade" id="bodyId"></div>');
	$('#bodyId').append('<div class="modal-header" id="headId"></div>');
	$('#headId').append('<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick=CloseMsg()>×</button>');
	if(tip){
		$('#headId').append('<h3>'+tip+'</h3>');
	}else{
		$('#headId').append('<h3>提示</h3>');
	}
	$('#bodyId').append('<div class="modal-body" id="msgBodyId"></div>');
	$('#msgBodyId').append(string);
	$('#bodyId').append('<div class="modal-footer" id="footId"></div>');
	$('#footId').append('<button class="btn" data-dismiss="modal" aria-hidden="true" onclick=CloseMsg()>确定</button>');
	$('#bodyId').on('hide', function () {
		$('#bodyId').remove();
	}); 
	$('#bodyId').modal('show');
}

function CloseMsg(){
	$('#bodyId').modal('hide');
}
