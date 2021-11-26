function btnActivation(){

    let button = document.getElementById("post-button");
    if(!document.getElementById('post-text').value.length){
        button.disabled = true;
        button.classList.remove("btn-primary");    
               
    }else{
        button.disabled = false;
        button.classList.add("btn-primary");
    }           
}   
function editPostActivate(){

    let button = document.getElementById("editPostButton");
    if(!document.getElementById('editPostText').value.length){
        button.disabled = true;
        button.classList.remove("btn-primary");    
               
    }else{
        button.disabled = false;
        button.classList.add("btn-primary");
    }           
}   

// function editPostModal(event){
//     event.preventDefault();
//     document.getElementById('#editPostModal').show().find('.modal-content').load($(this).attr('href'));
//   };