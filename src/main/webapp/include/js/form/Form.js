var Form = function(staticParam) {
	return new Form.func.init(staticParam);
};

Form.func = Form.prototype = {
	init:function(staticParam) {
		Form.prototype.staticPararm = staticParam;
		return this;
	},
	load: function() {
		var option = Form.prototype.staticPararm;
		//var paramData = Form.prototype.getProductParam();
		var paramData = {};
		jQuery(option["gridTable"] ).jqGrid(
				{
				   	url:option["url"],
					datatype: "json",
					postData:paramData,
				   	colNames:option["colNames"],
				   	colModel:[
				   		{	
					   		name:'formId'
						   	,index:'formId'
						   	,width:80
							,align:"center"
						   	,sortable:false
						   	,hidden: true
				   		},
				   		{	
					   		name:'formTypeName'
						   	,index:'formTypeName'
						   	,width:100
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'customerName'
						   	,index:'customerName'
						   	,width:80	
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'formDate'
						   	,index:'formDate'
						   	,width:120	
							,align:"center"
						   	,sortable:false
				   		},				   		
				   		{	
					   		name:'total'
						   	,index:'total'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		}
				   	],
					jsonReader : 
					{ 
				       root: "formVoList"
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
		$("#btnQueryForm").click(function(){
			Form.prototype.queryLoad();
		});

		$("#formList").closest(".ui-jqgrid-bdiv").css({ 'overflow-y' : 'scroll' });
	},
	setAddFormEnv: function() {
		$("#productTypeList").change(function(){
			Form.prototype.loadProductList();
		});
		$("#productList").change(function(){
			Form.prototype.loadProduct();
		});
		$("#productQuantity").change(function() {
			Form.prototype.calculateCost();
		});		
		$("#formTypeList").change(function() {
			Form.prototype.loadCustomerList();
		});
		
		$("#btnAddSaleForm").click(function(){
			Form.prototype.addSaleForm();
		});
		
	},
	loadProductList: function() {		
		var findProductListUrl = "../product/listJson.action";
		
		$.ajax( {
			type : "get",
			url : findProductListUrl,
			async : true,
			data : {'productVo.productTypeId': $("#productTypeList").val() },
			dataType : "json",
			success : function(msg) {
				$("#productList").get(0).options.length = 1;
		    	for(var i =0; i < msg.productVoList.length; i++) {
		    		$("#productList").append($("<option value=\"" + msg.productVoList[i].productId + "\">" + msg.productVoList[i].productName + "</option>" ));
		    	}
			}
		});	
		
	},
	loadProduct:function() {
		var findProductUrl = "../product/findJson.action";
		
		$.ajax( {
			type : "get",
			url : findProductUrl,
			async : true,
			data : {'productVo.productId': $("#productList").val() },
			dataType : "json",
			success : function(msg) {
				$("#productPrice").val(msg.productVo.price);
			}
		});			
	},
	loadCustomerList: function() {
		var findCustomerListUrl = "../customer/listJson4Form.action";
		
		$.ajax( {
			type : "get",
			url : findCustomerListUrl,
			async : true,
			data : {'formVo.formTypeName': $("#formTypeList").find('option:selected').text()},
			dataType : "json",
			success : function(msg) {
				$("#customerList").get(0).options.length = 1;
		    	for(var i =0; i < msg.customerVoList.length; i++) {
		    		$("#customerList").append($("<option value=\"" + msg.customerVoList[i].customerId + "\">" + msg.customerVoList[i].customerName + "</option>" ));
		    	}
			}
		});			
	},
	calculateCost: function() {
		var cost;
		var price = $("#productPrice").val();
		var quantity = $("#productQuantity").val();
		
		if(quantity != "") {
			cost = price * quantity;
			$("#productCost").val(cost);
		} else {
			$("#productCost").val("");
		}
		
	},
	addSaleForm: function() {
		var option = Form.prototype.staticPararm;
		var addSaleFormUrl = "../form/addJson.action";
		
		var formDetailVoList = [];
		var theIds = $(option["gridTable"]).jqGrid("getDataIDs");
		
		for(var i = 0; i < theIds.length; i++){
			var theRowData = $(option["gridTable"]).jqGrid("getRowData", theIds[i]);
			var object = {
				'"productId"' : theRowData['productId'],
				'"quantity"' : theRowData['quantity'],
				'"total"' : theRowData['cost']
			};
			formDetailVoList.push(object);
		}
				
		var formData = {
			'formVo.total': $("#formTotalPrice").val(),
			'formVo.customerId': $("#customerList").val(),
			'formVo.formTypeId': $("#formTypeList").val(),
			'formVo.formTypeName': $("#formTypeList option:selected").text(),   // hard code here
			'formVo.formDetailVoList': formDetailVoList
		};			
			
		$.ajax( {
			type : "post",
			url : addSaleFormUrl,
			async : true,
			data : formData,
			dataType : "json",
			success : function(msg) {
				
			}
		});	
	},
	queryLoad:function() {
		var option = Form.prototype.staticPararm;
			
		$(option["gridTable"]).appendPostData(Form.prototype.getProductParam());
		$(option["gridTable"]).trigger("reloadGrid"); 

	},
	getProductParam:function() {
		var data = {
				'formVo.formTypeId' : $("#formTypeList").val()
		};
		
		return data;
	}
	
};

Form.func.init.prototype = Form.func;

