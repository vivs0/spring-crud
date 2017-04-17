    $(document).ready(function(){
       $('div.cancel-btn').hide(); 
    });

    $(document).ready(function(){
		var id = '';
        var cancelBtn;
        var dd='';
        var temp; 
        $('input:submit').hide();
       $('div > div > div').click(function(){

    	   if(id=='')
    	   {
               	temp = new Map();
    	   }
           if(id=='' ||id==$(this).parents('div.row').attr('id'))
           {
               temp.set($(this).prev().attr('id') ,$(this).prev("input").val());
                   
               
               id = $(this).parents('div.row').attr('id');
               $(this).prev("input[disabled]").prop("disabled",function(i,v){
	        	   return !v;
	           }).focus();

	           $('#'+id+' :nth-child(13n)').show();
	           $('#'+id+' :nth-child(12n)').children('input:submit').show();
	           $('#'+id+' :nth-child(12n)').children('button').hide();
               
//	           $('#'+id+' :nth-child(12n)').children('button').html('Update');
//	           $('#'+id+' :nth-child(12n)').children('button').prop('name','Update');
	
	           cancelBtn = $('#'+id+' :nth-child(13n)').children('button').attr('id');
	           $(this).hide();
           }else{
        	   alert("You can only edit one row. Update your current row or cancel");
           }
       });
        
       $(':button.cnc').click(function(){
           $('#'+id).children().each(function(){ //code for searchin enabled elements
               $(this).children('input:text:enabled').each(function(){
                   $(this).val(temp.get($(this).attr('id')) );
                   $(this).prop('disabled',true);
                   $('.wall').show();
               });
           });
           $('#'+id+' :nth-child(12n)').children('button').show();
	       $('#'+id+' :nth-child(12n)').children('input:submit').hide();
           id='';
           temp = null;
           $(this).parents('.cancel-btn').hide(); 
       });
        
        
        $(':button.up').click(function(){
            var arr = {};
            arr.push(temp);
            alert(arr)
        });
    });
