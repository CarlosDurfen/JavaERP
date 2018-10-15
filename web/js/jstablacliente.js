
function mandar(boto) {
    var nombre;
    var idcliente;
    //obtain the father td id
    nombre = $(boto).parent().parent().attr("id");
    //obtain the fist child
    idcliente = $("#" + nombre).children(":first").text();
    //calling the servlet using post a sending the data by json
    $.post('Eliminarcliente', {idcliente: idcliente}, function () {
        window.location = "tablaclientes.jsp";
    });



}

function modificar(boton) {
    var iterador = 0;
    var identificador = 1;
    var contador = 1;
    var nombre = new Array(4);
    var pagina = "modificarcliente.html?";
    //loop to introduce the data into the url
    $(boton).parent().parent().find(".fila").each(function () {


        if (contador < 3) {
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

