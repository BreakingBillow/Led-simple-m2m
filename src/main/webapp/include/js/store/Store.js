var Store = function(staticParam) {
	return new Store.func.init(staticParam);
};

Store.func = Store.prototype = {
	init:function(staticParam) {
		Store.prototype.staticPararm = staticParam;
		return this;
	},
	load: function() {
		var option = Store.prototype.staticPararm;
		var paramData = Store.prototype.getStoreParam();
		jQuery(option["gridTable"] ).jqGrid(
				{
				   	url:option["url"],
					datatype: "json",
					postData:paramData,
				   	colNames:option["colNames"],
				   	colModel:[
				   		{	
					   		name:'productId'
						   	,index:'productId'
						   	,width:80
							,align:"center"
						   	,sortable:false
						   	,hidden: true
				   		},		
				   		{	
					   		name:'productVo.productTypeName'
						   	,index:'productVo.productTypeName'
						   	,width:120
							,align:"center"
						   	,sortable:false
				   		},				   		
				   		{	
					   		name:'productVo.productName'
						   	,index:'productVo.productName'
						   	,width:120
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'productVo.price'
						   	,index:'productVo.price'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},					   		
				   		{	
					   		name:'quantity'
						   	,index:'quantity'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},	
				   		{	
					   		name:'value'
						   	,index:'value'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		}					   		
				   	],
					jsonReader : 
					{ 
				       root: "storeVoList"
				       ,repeatitems:false
					},
					width: 850,
				   	rowNum:50,
				   	height: 300,
				   	loadonce: false,
				    viewrecords: false,
				    pager: option["pageDiv"] ,
					gridComplete: function(){
						
					}
				});
				jQuery(option["gridTable"]).jqGrid('navGrid', option["pageDiv"], {
					refresh : false,
					edit : false,
					add : false,
					del : false,
					search : false
				});
	},
	setEnv:function() {
		$("#btnQueryStore").click(function(){
			Store.prototype.queryLoad();
		});

		$("#storeList").closest(".ui-jqgrid-bdiv").css({ 'overflow-y' : 'scroll' });
	},
	queryLoad:function() {
		var option = Store.prototype.staticPararm;
			
		$(option["gridTable"]).appendPostData(Store.prototype.getStoreParam());
		$(option["gridTable"]).trigger("reloadGrid"); 

	},
	getStoreParam:function() {
		var data = {
				'storeVo.storeTypeId' : $("#storeTypeList").val()
		};
		
		return data;
	}
	
};

Store.func.init.prototype = Store.func;

