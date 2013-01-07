$(document).ready(function(){
	$('#informationListDivId').portlet({
        sortable: true,
        create: function() {
            //alert('created portlet.');
        },
        removeItem: function() {
            alert('after remove');
        },
        columns: [{
            width: 350,
            portlets: [{
                title: function() {
                    return '系统消息('+ laivi.getCurrentDateString()+ ')';
                },
                content: {
                    type: 'ajax',
                    dataType: 'json',
                    url: 'information_list.action',
                    formatter: function(o, pio, data) {
                        var ct = "<table width='100%'>";
                        $.each(data.root, function(i,item) {
                            ct += "<tr><td><a href='#' onclick='viewInformation("+item.id+")' title='"+item.content+"'>" + item.title + "</a></td><td align='right'>"+item.createDate+"</td></tr>";
                            //ct += "<tr><td><a href='#' rel='information_get.action?type=1&id="+item.id+"'>" + item.title + "</a></td><td align='right'>"+item.pubDate+"</td></tr>";
                        });
                        return ct + "</table>";
                    }
                }
            }]
        }]
    });
	$('#content a[href][title]').qtip({
	      content: {
	         text: false // Use each elements title attribute
	      },
	      style: 'cream' // Give it some style
	   });
});
function viewInformation(id){
	laivi.setFormVaule("information_get.action?type=1&id="+id, false);
	laivi.dialogOpen($("#informationDivId"), "详细信息", 380, 700);
}