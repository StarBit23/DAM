
marcadores = {};
marcadores.lista = [];
marcadores.load = () => {
    let lista = JSON.parse(localStorage.getItem("marcadores"));
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
    localStorage.setItem("marcadores", JSON.stringify(marcadores.lista));
};