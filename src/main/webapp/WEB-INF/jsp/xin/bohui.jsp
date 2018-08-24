<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
    <script src="<%=request.getContextPath()%>/js/js/jquery.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/drilldown.js"></script>
    <script src="https://code.highcharts.com/modules/data.js"></script>
</head>
<body>
<div id="container" style="min-width:400px;height:400px"></div>
<div id="container2" style="min-width:400px;height:400px"></div>
<script type="text/javascript">
    $(function(){
        test1();
        test2();
    });
    function test1(){
        $.ajax({
            url: "<%=request.getContextPath()%>/caoxin/querylist",
            type: "post",
            dataType: "json",
            success: function(result){
                //条形图
                var chart = Highcharts.chart('container', {
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: '18年每个月的流程条形图'
                    },
                    xAxis: {
                        categories: result.xlist,
                        title: {
                            text: null
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '流程总量 (个)',
                            align: 'high'
                        },
                        labels: {
                            overflow: 'column'
                        }
                    },
                    tooltip: {
                        valueSuffix: '个'
                    },
                    plotOptions: {
                        bar: {
                            dataLabels: {
                                enabled: true,
                                allowOverlap: false // 允许数据标签重叠
                            }
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'top',
                        x: -40,
                        y: 100,
                        floating: true,
                        borderWidth: 1,
                        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                        shadow: true
                    },
                    series: [{
                        data: result.ylist
                    }]
                });
            }
        });
    }


    function test2() {
        $.ajax({
            url: "<%=request.getContextPath()%>/caoxin/querylist",
            type: "post",
            dataType: "json",
            success: function (result) {
                var chart = Highcharts.chart('container2', {
                    data: {
                        table: 'datatable'
                    },
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Data extracted from a HTML table in the page'
                    },
                    yAxis: {
                        allowDecimals: false,
                        title: {
                            text: 'Units'
                        }
                    },
                    tooltip: {
                        formatter: function () {
                            return '<b>' + this.series.name + '</b><br/>' +
                                this.point.y + ' ' + this.point.name.toLowerCase();
                        }
                    }
                });
            }
        })
    }
</script>

</body>
</html>
