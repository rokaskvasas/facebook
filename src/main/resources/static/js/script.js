function btnActivation(btn,text) {

    let button = document.getElementById(btn);
    if (!document.getElementById(text).value.length) {
        button.disabled = true;
        button.classList.remove("btn-primary");

    } else {
        button.disabled = false;
        button.classList.add("btn-primary");
    }
}
function commentBtnActivation(btn,text) {

    let button = document.getElementById(btn);
    if (!document.getElementById(text).value.length) {
        button.disabled = true;
    } else {
        button.disabled = false;
    }
}

// window.onload=function(){
//     const editmodal = document.querySelector('#editPostModal');
//     editmodal.addEventListener('show.bs.modal', openModule)
// }



// TODO:: modaltext.textcontent doesn't not fills with text..

function openModule(event) {

    alert("yay");
    // Button that triggered the modal

    let button = event.relatedTarget;

    let exampleModal = event.modal;

    // Extract info from data-bs-* attributes

    let recipient = button.getAttribute('data-bs-postId');

    let modalText = exampleModal.querySelector('.editPostText');

    modalText.textContent = recipient;

}
function transferTextToEditModal(from, to, event){

     editCommentModal = document.querySelector('')
    let button = event.relatedTarget

}

function sendCustomHTTPMethod(url,method) {
    var xhttp = new XMLHttpRequest();
    xhttp.open(`${method}`, url, true);
    xhttp.onload = function () {
        let responseURL = xhttp.responseURL;
        console.log("Redirecting to:", responseURL);
        window.location.replace(responseURL);
    };
    xhttp.send();
}