
//添加选项卡
function addTab(title,url){
	
	if ($('#center-tabs').tabs('exists', title)){
	
 		$('#center-tabs').tabs('select', title);
	} else {
	
	var contxt='<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>';
	 $('#center-tabs').tabs('add',{    
	    title:title, 
	    content:contxt,
	    closable:true,
	   
	 });  

	}
}