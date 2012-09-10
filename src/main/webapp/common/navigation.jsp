<jsp:include page="/common/include.jsp" flush="true" />
<script>
jQuery(document).ready(function(){
	$( "#accordion" ).accordion();
						
});

</script>

<div id="accordion" style="width: 350px; font-size: 12px;" >
    <h3><a href="#">Form</a></h3>
    <div>
    	<ul>
    		<li>List Form </li>
    		<li>Add Form</li>
    	</ul>
	</div>
    <h3><a href="#">Customer</a></h3>
    <div>
    	<ul>
    		<li>List Customer</li>
    		<li>Add Customer</li>
    	</ul>    
	</div>
	<h3><a href="#">Product</a></h3>
    <div>
    	<ul>
    		<li>List Product</li>
    		<li>Add Product</li>
    	</ul>    
	</div>
	<h3><a href="#">Category</a></h3>
    <div>
    	<ul>
    		<li>List Category</li>
    		<li>Add Category</li>
    	</ul>    
	</div>	
	<h3><a href="#">Store</a></h3>
    <div>
    	<ul>
    		<li>List Store</li>
    	</ul>    
	</div>		
</div>