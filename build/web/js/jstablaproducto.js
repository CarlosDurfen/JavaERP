/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function mandar(boto) {
    var nombre;
    var idproducto;
    //obtain the father td id
    nombre = $(boto).parent().parent().attr("id");
    //obtain the fist child
    idproducto = $("#" + nombre).children(":first").text();
    //calling the servlet using post a sending the data by json
    $.post('EliminarProducto', {idproducto: idproducto}, function () {
        window.location = "productos.jsp";
    });



}

function modificar(boton) {
    var iterador = 0;
    var identificador = 1;
    var contador = 1;
    var nombre = new Array(4);
    var pagina = "modificarproducto.html?";

    //loop to introduce the data into the url
    $(boton).parent().parent().find(".fila").each(function () {


        if (contador < 4) {
            pagina += "var" + identificador + "=" + this.innerHTML.trim() + "&";
            alert(pagina);
            iterador++;
            identificador++;
            contador++;
        }else{
            pagina += "var" + identificador + "=" + escape(this.innerHTML.trim());
            alert(pagina);
            iterador++;
            identificador++;
            window.location = pagina;
        }

    });
    





}
