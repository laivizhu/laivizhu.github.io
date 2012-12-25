var ReportTable;
$(document).ready(function(e) {
	var level1 = $("#materialCategoryClassifyID");
	var level2 = $("#materialCategoryID");
	var level3 = $("#materialSubCategoryID");
	var level4 = $("#materialTeamID");
	
	var level21 = $("#materialCategoryClassifyID2");
	var level22 = $("#materialCategoryID2");
	var level23 = $("#materialSubCategoryID2");
	var level24 = $("#materialTeamID2");
	//drawChart();
	
	setChoiceItems();
	setChoiceItems2();
	
	var categoryListUrl='materialExpenditure_categoryListByType.action';
	cascadeChoose(categoryListUrl,level1,level2,level3,level4,true);
	cascadeChoose(categoryListUrl,level21,level22,level23,level24,true);
	
	categoryExpenditureChartSearch();
	
	var parentid1=$("#materialTeamID2").val();
	var parentid2=$("#materialSubCategoryID2").val();
	var parentid3=$("#materialCategoryID2").val();
	var parentid4=$("#materialCategoryClassifyID2").val();
	materialCostReportTable=new HouQianTable({
		url:"materialExpenditure_searchReport.action?parentId1="+parentid1+
			 "&parentId2="+parentid2+
			 "&parentId3="+parentid3+
			 "&parentId4="+parentid4,
		parentContainer:"#materialReportTableId",
		columns:[
			{name:"序号",width:"10%",bindingProperty:"no"},
			{name:"行标签",width:"40%",bindingProperty:"category"},
			{name:"支出金额",width:"30%",bindingProperty:"expenditure"},
			{name:"比例",width:"20%",bindingProperty:"per"},
		],
		pageCount:30,
		selectType:0
	});
	
});

function setChoiceItems(){
	$("#materialCategoryClassifyID").empty();
	$("#materialCategoryID").empty();
	$("#materialSubCategoryID").empty();
	$("#materialTeamID").empty();
	$("#materialCategoryID").attr("disabled","diabled");
	$("#materialSubCategoryID").attr("disabled","diabled");
	$("#materialTeamID").attr("disabled","diabled");
	categoryList('materialExpenditure_categoryListByType.action',$("#materialCategoryClassifyID"),"categoryValue=0&id=0");
};

function setChoiceItems2(){
	$("#materialCategoryClassifyID2").empty();
	$("#materialCategoryID2").empty();
	$("#materialSubCategoryID2").empty();
	$("#materialTeamID2").empty();
	$("#materialCategoryID2").attr("disabled","diabled");
	$("#materialSubCategoryID2").attr("disabled","diabled");
	$("#materialTeamID2").attr("disabled","diabled");
	categoryList('materialExpenditure_categoryListByType.action',$("#materialCategoryClassifyID2"),"categoryValue=0&id=0");
};



function categoryExpenditureChartSearch(){
	var parentid1=$("#materialTeamID").val();
	var parentid2=$("#materialSubCategoryID").val();
	var parentid3=$("#materialCategoryID").val();
	var parentid4=$("#materialCategoryClassifyID").val();

	var url="materialExpenditure_searchChart.action?parentId1="+parentid1+
	 "&parentId2="+parentid2+
	 "&parentId3="+parentid3+
	 "&parentId4="+parentid4;
	$.getJSON(url,
		     function(data){
				drawChart(data);
			  });
};

function categoryExpenditureReportSearch(){
	var parentid1=$("#materialTeamID2").val();
	var parentid2=$("#materialSubCategoryID2").val();
	var parentid3=$("#materialCategoryID2").val();
	var parentid4=$("#materialCategoryClassifyID2").val();

	var url="materialExpenditure_searchReport.action?parentId1="+parentid1+
	 "&parentId2="+parentid2+
	 "&parentId3="+parentid3+
	 "&parentId4="+parentid4;
	materialCostReportTable.refresh(url);
};
