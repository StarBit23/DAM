//FUNCION PARA OCULTAR TODOS LOS ELEMENTOS DE UNA CLASE
function hideAll() {
    document.querySelectorAll(".panel").forEach((elemento) => {
        //elemento.style.visibility = "hidden";
        elemento.style.display = "none";
    });
};

onload = () => {

    hideAll();

    document.querySelectorAll('[id^="menu_"]').forEach((elemento) => {
    let ident = elemento.getAttribute('id');
    let panelName = ident.replace("menu_","");
    console.log(elemento);
    elemento.addEventListener("click", (event) => {
        hideAll();
        document.getElementById(panelName).style.visibility = 'block';
    });
    });
}