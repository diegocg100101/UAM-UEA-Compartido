function creaClaveUnidad() {
    let select = document.getElementById("unidad").value;
    let unidades = ["LER", "CUA", "AZC", "XOCH", "IZT"];
    document.getElementById("clavegrupo").value = unidades[select - 1];
}

function creaClaveUEA() {
    let select = document.getElementById("clave_uea").value;
    let random = Math.floor((Math.random() * 100) + 1);
    document.getElementById("clavegrupo").value += select[0] + select[1] ;
}

function ponerVirtual() {
    let check = document.getElementById("virtual");
    let salon = document.getElementById("salon");

    if (check.checked) {
        salon.disabled = true;
        salon.value = 0;
    } else {
        salon.disabled = false;
    }
}
