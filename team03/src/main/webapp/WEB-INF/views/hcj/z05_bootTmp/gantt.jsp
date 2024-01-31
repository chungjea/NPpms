<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" > --%>
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<link rel="stylesheet" href="${path}/a00_com/gantt/codebase/dhtmlxgantt.css?v=8.0.6">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css?v=8.0.6" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css?v=8.0.6" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	
	
	
	
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js?v=8.0.6" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style>
   html, body {
			height: 100%;
			padding: 0px;
			margin: 0px;
		}

		.weekend {
			background: #f4f7f4 !important;
		}

		.gantt_selected .weekend {
			background: #FFF3A1 !important;
		}

		.well {
			text-align: right;
		}

		@media (max-width: 991px) {
			.nav-stacked > li {
				float: left;
			}
		}

		.container-fluid .row {
			margin-bottom: 10px;
		}

		.container-fluid .gantt_wrapper {
			height: 700px;
			width: 100%;
		}

		.gantt_container {
			border-radius: 4px;
		}

		.gantt_grid_scale {
			background-color: transparent;
		}

		.gantt_hor_scroll {
			margin-bottom: 1px;
		}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="${path}/a00_com/gantt/codebase/dhtmlxgantt.js?v=8.0.6"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js?v=8.0.6" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script type="text/javascript">
   $(document).ready(function(){
   
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>타이틀</h2>

</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="navbar navbar-inverse">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
								data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Basic Gantt Chart</a>
					</div>
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Project <span
										class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Project information</a></li>
									<li><a href="#">Custom fields</a></li>
									<li><a href="#">Change working time</a></li>
									<li class="divider"></li>
									<li><a href="#">Export</a></li>
								</ul>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">Task <span
										class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Add task</a></li>
									<li><a href="#">Add milestone</a></li>
									<li class="divider"></li>
									<li><a href="#">Summary</a></li>
								</ul>
							</li>
							<li><a href="#">Team</a></li>
							<li><a href="#">Format</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-push-10">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Gantt info</h3>
				</div>
				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked" id="gantt_info">
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-10 col-md-pull-2">
			<div class="gantt_wrapper panel" id="gantt_here"></div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="well">
				<div>
					<a class="logo" title="DHTMLX - JavaScript Web App Framework &amp; UI Widgets"
					   href="https://dhtmlx.com/docs/products/dhtmlxGantt/">&copy; DHTMLX</a>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	var demo_tasks = {
		data:[
			{id:1, text:"Office itinerancy", type:gantt.config.types.project, progress: 0.4, open: false},
			{id:2, text:"Office facing", type:gantt.config.types.project, start_date:"02-04-2023", duration:"8", progress: 0.6, parent:"1", open: true},
			{id:3, text:"Furniture installation", type:gantt.config.types.project, start_date:"11-04-2023", duration:"8", parent:"1", progress: 0.6, open: true},
			{id:4, text:"The employee relocation", type:gantt.config.types.project, start_date:"13-04-2023", duration:"6", parent:"1", progress: 0.5, open: true},
			{id:5, text:"Interior office", start_date:"02-04-2023", duration:"7", parent:"2", progress: 0.6, open: true},
			{id:6, text:"Air conditioners check", start_date:"03-04-2023", duration:"7", parent:"2", progress: 0.6, open: true},
			{id:7, text:"Workplaces preparation", start_date:"11-04-2023", duration:"8", parent:"3", progress: 0.6, open: true},
			{id:8, text:"Preparing workplaces", start_date:"14-04-2023", duration:"5", parent:"4", progress: 0.5, open: true},
			{id:9, text:"Workplaces importation", start_date:"14-04-2023", duration:"4", parent:"4", progress: 0.5, open: true},
			{id:10, text:"Workplaces exportation", start_date:"14-04-2023", duration:"3", parent:"4", progress: 0.5, open: true},
			{id:11, text:"Product launch", type:gantt.config.types.project, progress: 0.6, open: true},
			{id:12, text:"Perform Initial testing", start_date:"03-04-2023", duration:"5", parent:"11", progress: 1, open: true},
			{id:13, text:"Development", type:gantt.config.types.project, start_date:"02-04-2023", duration:"7", parent:"11", progress: 0.5, open: true},
			{id:14, text:"Analysis", start_date:"02-04-2023", duration:"6", parent:"11", progress: 0.8, open: true},
			{id:15, text:"Design", type:gantt.config.types.project, start_date:"02-04-2023", duration:"5", parent:"11", progress: 0.2, open: false},
			{id:16, text:"Documentation creation", start_date:"02-04-2023", duration:"7", parent:"11", progress: 0, open: true},
			{id:17, text:"Develop System", start_date:"03-04-2023", duration:"2", parent:"13", progress: 1, open: true},
			{id:25, text:"Beta Release", start_date:"06-04-2023",type:gantt.config.types.milestone, parent:"13", progress: 0, open: true},
			{id:18, text:"Integrate System", start_date:"08-04-2023", duration:"2", parent:"13", progress: 0.8, open: true},
			{id:19, text:"Test", start_date:"10-04-2023", duration:"4", parent:"13", progress: 0.2, open: true},
			{id:20, text:"Marketing", start_date:"10-04-2023", duration:"4", parent:"13", progress: 0, open: true},
			{id:21, text:"Design database", start_date:"03-04-2023", duration:"4", parent:"15", progress: 0.5, open: true},
			{id:22, text:"Software design", start_date:"03-04-2023", duration:"4", parent:"15", progress: 0.1, open: true},
			{id:23, text:"Interface setup", start_date:"03-04-2023", duration:"5", parent:"15", progress: 0, open: true},
			{id:24, text:"Release v1.0", start_date:"15-04-2023",type:gantt.config.types.milestone, parent:"11", progress: 0, open: true}
		],
		links: [
			{id: "1", source: "1", target: "2", type: "1"},

			{id: "2", source: "2", target: "3", type: "0"},
			{id: "3", source: "3", target: "4", type: "0"},
			{id: "4", source: "2", target: "5", type: "2"},
			{id: "5", source: "2", target: "6", type: "2"},
			{id: "6", source: "3", target: "7", type: "2"},
			{id: "7", source: "4", target: "8", type: "2"},
			{id: "8", source: "4", target: "9", type: "2"},
			{id: "9", source: "4", target: "10", type: "2"},

			{id: "10", source: "11", target: "12", type: "1"},
			{id: "11", source: "11", target: "13", type: "1"},
			{id: "12", source: "11", target: "14", type: "1"},
			{id: "13", source: "11", target: "15", type: "1"},
			{id: "14", source: "11", target: "16", type: "1"},

			{id: "15", source: "13", target: "17", type: "1"},
			{id: "16", source: "17", target: "25", type: "0"},
			{id: "23", source: "25", target: "18", type: "0"},
			{id: "17", source: "18", target: "19", type: "0"},
			{id: "18", source: "19", target: "20", type: "0"},
			{id: "19", source: "15", target: "21", type: "2"},
			{id: "20", source: "15", target: "22", type: "2"},
			{id: "21", source: "15", target: "23", type: "2"},
			{id: "22", source: "13", target: "24", type: "0"}
		]
	};

	var getListItemHTML = function (type, count, active) {
		return '<li' + (active ? ' class="active"' : '') + '><a href="#">' + type + 's <span class="badge">' + count + '</span></a></li>';
	};

	var updateInfo = function () {
		var state = gantt.getState(),
			tasks = gantt.getTaskByTime(state.min_date, state.max_date),
			types = gantt.config.types,
			result = {},
			html = "",
			active = false;

		// get available types
		result[types.task] = 0;
		result[types.project] = 0;
		result[types.milestone] = 0;

		// sort tasks by type
		for (var i = 0, l = tasks.length; i < l; i++) {
			if (tasks[i].type && result[tasks[i].type] != "undefined")
				result[tasks[i].type] += 1;
			else
				result[types.task] += 1;
		}
		// render list items for each type
		for (var j in result) {
			if (j == types.task)
				active = true;
			else
				active = false;
			html += getListItemHTML(j, result[j], active);
		}

		document.getElementById("gantt_info").innerHTML = html;
	};

	gantt.templates.scale_cell_class = function (date) {
		if (date.getDay() == 0 || date.getDay() == 6) {
			return "weekend";
		}
	};
	gantt.templates.timeline_cell_class = function (item, date) {
		if (date.getDay() == 0 || date.getDay() == 6) {
			return "weekend";
		}
	};

	gantt.templates.rightside_text = function (start, end, task) {
		if (task.type == gantt.config.types.milestone) {
			return task.text;
		}
		return "";
	};

	gantt.config.columns = [
		{name: "text", label: "Task name", width: "*", tree: true},
		{name: "start_date", label: "Start time", align: "center", width: 60},
		{name: "duration", label: "Duration", align: "center", width: 60},
		{name: "add", label: "", width: 44}
	];

	gantt.config.grid_width = 390;
	gantt.config.date_grid = "%F %d";
	gantt.config.scale_height = 60;
	gantt.config.scales = [
		{unit: "day", step: 1, format: "%d %M"},
		{unit: "week", step: 1, format: "Week #%W"}
	];

	gantt.attachEvent("onAfterTaskAdd", function (id, item) {
		updateInfo();
	});
	gantt.attachEvent("onAfterTaskDelete", function (id, item) {
		updateInfo();
	});

	gantt.init("gantt_here");
	gantt.parse(demo_tasks);
	updateInfo();

</script>

</body>
</html>