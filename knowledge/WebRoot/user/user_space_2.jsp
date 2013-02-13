<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="row" id="friendsListDivId">
		
</div>
							
<script type="text/javascript">
	$(document).ready(laivi.init(function(){
		laivi.scrollBreakPage('autoGraph_listFriendAutoGraph.action', $("#friendsListDivId"), function(item){
			return "<div class='span8'><p>"+item.content+"</p><p><div align='right'>"+item.createDate+"|"+item.user.userName+"</div></p></div>";
		});
	}));
</script>