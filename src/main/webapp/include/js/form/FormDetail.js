var FormDetail = function(staticParam) {
	return new FormDetail.func.init(staticParam);
};

FormDetail.func = FormDetail.prototype = {
	init:function(staticParam) {
		FormDetail.prototype.staticPararm = staticParam;
		FormDetail.prototype.rowCount = 1;
		return this;
	},
	loadList: function() {
		var option = FormDetail.prototype.staticPararm;
		var paramData = FormDetail.prototype.getFormDetailParam();
		jQuery(option["gridTable"] ).jqGrid(
				{
				   	url:option["url"],
					datatype: "json",
					postData:paramData,
				   	colNames:option["colNames"],
				   	colModel:[
				   		{	
					   		name:'productId'
						   	,index:'ProductId'
						   	,width:80
							,align:"center"
						   	,sortable:false
						   	,hidden:true
				   		},				   	          
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
					   		name:'quantity'
						   	,index:'quantity'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'cost'
						   	,index:'cost'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'operate'
						   	,index:'operate'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		}				   		
				   	],
					jsonReader : 
					{ 
				       root: "formDetailVoList"
				       ,repeatitems:false
					},
					width: 850,
				   	rowNum:50,
				   	height: 300,
				    sortorder: "desc",
				    viewrecords: true,
				    rowList:[10,20,30],
				    pager: option["pageDiv"] ,
				    caption:"Add Sale Form",
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
	load: function() {
		var option = FormDetail.prototype.staticPararm;
		//var paramData = FormDetail.prototype.getFormDetailParam();
		jQuery(option["gridTable"] ).jqGrid(
				{
				   	datatype: "local",
					//postData:paramData,
				   	colNames:option["colNames"],
				   	colModel:[
				   		{	
					   		name:'productId'
						   	,index:'ProductId'
						   	,width:80
							,align:"center"
						   	,sortable:false
						   	,hidden:true
				   		},				   	          
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
					   		name:'quantity'
						   	,index:'quantity'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'cost'
						   	,index:'cost'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'operate'
						   	,index:'operate'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		}				   		
				   	],
					jsonReader : 
					{ 
				       root: "formDetailVoList"
				       ,repeatitems:false
					},
					width: 850,
				   	rowNum:50,
				   	height: 300,
				    sortorder: "desc",
				    viewrecords: true,
				    rowList:[10,20,30],
				    pager: option["pageDiv"] ,
				    caption:"Add Sale Form",
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
		
		$("#btnAddProduct").click(function(){
			FormDetail.prototype.addFormDetailRow();
		});
	
		$("#formDetailList").closest(".ui-jqgrid-bdiv").css({ 'overflow-y' : 'scroll' });
	},
	addFormDetailRow : function() {		
		var btnDelete = "<input style='height:22px;width:50px;' type='button' value='Delete' " + "onclick=\"deleteFormDetailRow('"+ FormDetail.prototype.rowCount +"');\"  />"; ;
		var dataRow = {
				productId: $("#productList").val(),
				productName: $("#productList  option:selected").text(),
				productTypeName: $("#productTypeList  option:selected").text(),
				price:$("#productPrice").val(),
				quantity:$("#productQuantity").val(),
				cost:$("#productCost").val(),
				operate:btnDelete
				
		};
		var option = FormDetail.prototype.staticPararm;
		$(option["gridTable"]).jqGrid('addRowData',FormDetail.prototype.rowCount, dataRow);
		
		FormDetail.prototype.rowCount++;
		
		$("#addProductFormTable")[0].reset();
		calculateTotalPrice();

	},	
	queryLoad:function() {
//		var option = FormDetail.prototype.staticPararm; 
//			
//		$(option["gridTable"]).appendPostData(Product.prototype.getFormDetailParam());
//		$(option["gridTable"]).trigger("reloadGrid"); 

	},
	getFormDetailParam:function() {
		var data = {
				'productVo.productTypeId' : $("#productTypeList").val()
		};
		
		return data;
	}
	
};

FormDetail.func.init.prototype = FormDetail.func;

