// JavaScript Document
function drawChart(data) {
	var chart1;
	var chart2;
	var chart3;
	var chart4;
	
	var dataMaterialQty = data[0];
	var dataMaterialCost = data[1];
	var dataMaterialName = data[2][0];
	var dataMaterialCostPer = data[2][1];
	var dataMaterialCostValue = data[2][2];
	var dataSupplierName = data[3][0];
	var dataSupplierCostPer = data[3][1];
	var dataSupplierCostValue = data[3][2];
    chart1 = new Highcharts.Chart({
        chart: {
            renderTo: 'container1',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '物料货源地/物料数量占比'
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
        	percentageDecimals: 1
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    formatter: function() {
                        return '<b>'+ this.point.name +'</b>: ' + this.percentage.toFixed(2) + ' %';
                    }
                }
            }
        },
        
		series: [{
            type: 'pie',
            name: 'Browser share',
            data: dataMaterialQty
        }]
    });
    
    chart2 = new Highcharts.Chart({
        chart: {
            renderTo: 'container2',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '物料货源地/金额占比'
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage}%</b>',
        	percentageDecimals: 1
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    formatter: function() {
                        return '<b>'+ this.point.name +'</b>: '+ this.percentage.toFixed(2) +' %';
                    }
                }
            }
        },
        
		series: [{
            type: 'pie',
            name: 'Browser share',
            data: dataMaterialCost
        }]
    });


    chart3 = new Highcharts.Chart({
        chart: {
            renderTo: 'container3',
            //type: 'column',
            zoomType: 'xy'
        },
        title: {
            text: '物料累计占比'
        },
        xAxis: [{
            categories: dataMaterialName,
            labels:{
            	rotation:-45,
            	align:'right',
            },
        }],
        yAxis: [{ // Primary yAxis
            labels: {
                formatter: function() {
                    return this.value +'万元';
                },
                style: {
                    color: '#89A54E'
                }
            },
            title: {
                text: '支出',
                style: {
                    color: '#89A54E'
                }
            }
        }, { // Secondary yAxis
            title: {
                text: '百分比',
                style: {
                    color: '#4572A7'
                }
            },
            labels: {
                formatter: function() {
                    return this.value +' %';
                },
                style: {
                    color: '#4572A7'
                }
            },
            opposite: true
        }],
        tooltip: {
            formatter: function() {
                return ''+
                    this.x +': '+ this.y +
                    (this.series.name == '百分比' ? '%' : '万元');
            }
        },
        legend: {
            //layout: 'vertical',
            align: 'left',
            x: 1000,
            verticalAlign: 'top',
            y: 10,
            floating: true,
            backgroundColor: '#FFFFFF'
        },
        series: [{
        	 name: '支出',
             color: '#89A54E',
             type: 'column',
             data: dataMaterialCostValue,
             pointRange: 42,
             pointWidth: 20
        }, {
        	 name: '百分比',
             color: '#4572A7',
             type: 'spline',
             yAxis: 1,
             data: dataMaterialCostPer
        }]
    });
	
    chart4 = new Highcharts.Chart({
        chart: {
            renderTo: 'container4',
            zoomType: 'xy'
        },
        title: {
            text: '供应商支出及累计占比'
        },
        xAxis: [{
            categories: dataSupplierName,
            labels:{
            	rotation:-45,
            	align:'right'
            },
        }],
        yAxis: [{ // Primary yAxis
            labels: {
                formatter: function() {
                    return this.value +'万元';
                },
                style: {
                    color: '#89A54E'
                }
            },
            title: {
                text: '支出',
                style: {
                    color: '#89A54E'
                }
            }
        }, { // Secondary yAxis
            title: {
                text: '百分比',
                style: {
                    color: '#4572A7'
                }
            },
            labels: {
                formatter: function() {
                    return this.value +' %';
                },
                style: {
                    color: '#4572A7'
                }
            },
            opposite: true
        }],
        tooltip: {
            formatter: function() {
                return ''+
                    this.x +': '+ this.y +
                    (this.series.name == '百分比' ? '%' : '万元');
            }
        },
        legend: {
            //layout: 'vertical',
            align: 'left',
            x: 1000,
            verticalAlign: 'top',
            y: 10,
            floating: true,
            backgroundColor: '#FFFFFF'
        },
        series: [{
        	name: '支出',
            color: '#89A54E',
            type: 'column',
            data: dataSupplierCostValue,
            pointRange: 42,
            pointWidth: 20
        }, {
        	 name: '百分比',
             color: '#4572A7',
             type: 'spline',
             yAxis: 1,
             data: dataSupplierCostPer
        }]
});
}

   