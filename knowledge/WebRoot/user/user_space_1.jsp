<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="row" id="personListDivId">
	<div class="span8">
		<form id="autoGraphAddFormId">
			<textarea rows="5" style="width:100%" name="autoGraph.content" id="contentFormFieldId"></textarea>
			<div align='center'><p><button type="reset" class="btn btn-warning">重置</button>&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">提交</button></p></div>
		</form>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(laivi.init(function(){
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[id="contentFormFieldId"]', {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
				items : ['forecolor', 'hilitecolor','|','emoticons', 'image', 'link'],
				afterBlur:function(){
					this.sync();
				}
			});
		});
		laivi.submitForm($("#autoGraphAddFormId"),'autoGraph_add.action',function(){
			window.location.reload();
		},false,false);
		
		laivi.scrollBreakPage('autoGraph_list.action', $("#personListDivId"), function(item){
			return "<div class='span8'><p>"+item.content+"</p><p><div align='right'>"+item.createDate+"|<a onclick=deleteObject('autoGraph_delete.action?id="+item.id+"')>删除</a></div></p></div>";
		});
	}));
</script>
							
