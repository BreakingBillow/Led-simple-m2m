var Product = function(staticParam) {
	return new Product.func.init(staticParam);
};

Product.func = Product.prototype = {
	init:function(staticParam) {
		Product.prototype.staticPararm = staticParam;
		return this;
	},
	load: function() {
		var option = Product.prototype.staticPararm;
		var paramData = Product.prototype.getProductParam();
		jQuery(option["gridTable"] ).jqGrid(
				{
				   	url:option["url"],
					datatype: "json",
					postData:paramData,
				   	colNames:option["colNames"],
				   	colModel:[
				   		{	
					   		name:'productName'
						   	,index:'productName'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'productTypeName'
						   	,index:'productTypeName'
						   	,width:100
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'price'
						   	,index:'price'
						   	,width:80	
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'productColorName'
						   	,index:'productColorName'
						   	,width:80	
							,align:"center"
						   	,sortable:false
				   		},				   		
				   		{	
					   		name:'description'
						   	,index:'description'
						   	,width:250
							,align:"center"
						   	,sortable:false
				   		}
				   	],
					jsonReader : 
					{ 
				       root: "productVoList"
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
		$("#btnQueryProduct").click(function(){
			Product.prototype.queryLoad();
		});

		$("#productList").closest(".ui-jqgrid-bdiv").css({ 'overflow-y' : 'scroll' });
	},
	queryLoad:function() {
		var option = Product.prototype.staticPararm;
			
		$(option["gridTable"]).appendPostData(Product.prototype.getProductParam());
		$(option["gridTable"]).trigger("reloadGrid"); 

	},
	getProductParam:function() {
		var data = {
				'productVo.productTypeId' : $("#productTypeList").val()
		};
		
		return data;
		
		
	}
	
};

Product.func.init.prototype = Product.func;

