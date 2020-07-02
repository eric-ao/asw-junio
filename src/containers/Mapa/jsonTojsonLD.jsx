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
    const fecha = new Date();
    let fecha_formateada = fecha.getDate() + "-" + (fecha.getMonth() + 1) + "-" + fecha.getFullYear() + " " + fecha.getHours() + ":" + fecha.getMinutes() + ":" + fecha.getSeconds();
    return {
        author: autor,
        lastModified: fecha_formateada,
        rutas: ruta
    };
}