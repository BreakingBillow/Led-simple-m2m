var Customer = function(staticParam) {
	return new Customer.func.init(staticParam);
};

Customer.func = Customer.prototype = {
	init:function(staticParam) {
		Customer.prototype.staticPararm = staticParam;
		return this;
	},
	load: function() {
		var option = Customer.prototype.staticPararm;
		var paramData = Customer.prototype.getCustomerParam();
		jQuery(option["gridTable"] ).jqGrid(
				{
				   	url:option["url"],
					datatype: "json",
					postData:paramData,
				   	colNames:option["colNames"],
				   	colModel:[
				   		{	
					   		name:'customerId'
						   	,index:'customerId'
						   	,width:80
							,align:"center"
						   	,sortable:false
						   	,hidden: true
				   		},				   	          
				   		{	
					   		name:'customerName'
						   	,index:'customerName'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'customerTypeName'
						   	,index:'customerTypeName'
						   	,width:100
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'companyName'
						   	,index:'companyName'
						   	,width:80	
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'telephone'
						   	,index:'telephone'
						   	,width:80	
							,align:"center"
						   	,sortable:false
				   		},				   		
				   		{	
					   		name:'address'
						   	,index:'address'
						   	,width:150
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'email'
						   	,index:'email'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},
				   		{	
					   		name:'qq'
						   	,index:'qq'
						   	,width:80
							,align:"center"
						   	,sortable:false
				   		},	
				   		{	
					   		name:'acount'
						   	,index:'acount'
						   	,width:180
							,align:"center"
						   	,sortable:false
				   		},				   		
				   	],
					jsonReader : 
					{ 
				       root: "customerVoList"
				       ,repeatitems:false
					},
					width: 1450,
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
		$("#btnQueryCustomer").click(function(){
			Customer.prototype.queryLoad();
		});

		$("#customerList").closest(".ui-jqgrid-bdiv").css({ 'overflow-y' : 'scroll' });
	},
	queryLoad:function() {
		var option = Customer.prototype.staticPararm;
			
		$(option["gridTable"]).appendPostData(Customer.prototype.getCustomerParam());
		$(option["gridTable"]).trigger("reloadGrid"); 

	},
	getCustomerParam:function() {
		var data = {
				'customerVo.customerTypeId' : $("#customerTypeList").val()
		};
		
		return data;
	}
	
};

Customer.func.init.prototype = Customer.func;

