
marcadores = {};
marcadores.lista = [];
marcadores.load = () => {
    let lista = localStorage.getItem("marcadores");
    if (lista != null){
        marcadores.lista = lista;
    }
}

/*
 * Marcador:
 * {
 * nombre: "Diario Jaén"
 * url: "https://www.diariojaen.es"
 * tipo: "atom"
 * }
 * @param (*) marcador
*/
marcadores.save = (marcador) => {
    marcadores.lista.push(marcador);
    localStorage.setItem("marcadores",marcadores.lista)
}