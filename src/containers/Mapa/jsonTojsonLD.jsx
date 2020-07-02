export default function jsonTojsonLD(rutasSC, userName) {

    //Obtiene los puntos marcados del mapa y los parsea.
    const ruta = rutasSC.map(ruta => ({
        ...ruta,
        locations: ruta.locations.map(eleinterno => ({
            "latitud": eleinterno.lat,
            "longitud": eleinterno.lng,
            "archivos": eleinterno.images ? eleinterno.images : []
        })),
    }));

    //Obtiene la dirección de solid del autor.
    const userNameAUX = userName + "";
    const nombreDeUsuarioDividido = userNameAUX.split("/");
    const autor = nombreDeUsuarioDividido[0] + "//" + nombreDeUsuarioDividido[2] + "/profile/carde#me";
    //Obtiene la fecha
    const fecha = new Date().toDateString();

    return {
        author: autor,
        date: fecha,
        rutas: ruta
    };
}