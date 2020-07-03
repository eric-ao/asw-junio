
import React, { Component } from "react";
import './ayuda.css';

export default class AyudaComponent extends Component {

    render() {
        return (
            <div className="ayuda-Component">
                <h1>Guía de la aplicación</h1>
                <h2>Cómo añadir un nueva ruta</h2>

                <p>Para añadir un nueva ruta el usuario deberá ir a la pestaña mapa, una vez ahi podrá dar un nombre a la ruta y una descripción.
                    Para porder marcar los puntos de la ruta deberá pinchar en el mapa para indicar el primer punto de esta.
                    Para seguir marcando puntos de la ruta el usuario deberá pinchar nuevamente en el mapa creando así puntos intermedios, si el usuario se equivoca,
                    podrá utilizar el botón de Borrar último punto para corregir su error.
                    Una vez seleccionado el primer punto se le abrirá un menú con la posibilidad de asociar imagenes a ese punto como por ejemplo
                    una fuente que se encontrase en el camino. Asocie tantas imagenes como quiera para eso deberá pulsar el botón "Seleccionar archivo".
                    Una vez elegida la la imagen deberá pulsar el boton "Subir foto", y repetir esta acción tantas veces como imagenes quierá asociar a dicho punto.
                    Cuando haya finalizado de añadir imagenes y puntos a la ruta pulsé el botón "Guardar ruta" para guardarla.
                    Una vez guardada le aparecerá la nueva ruta en la pantalla con las rutas que ya tenía el usuario y aquellas que hayan sido compartidas por sus amigos.</p>

                <p>Aquí dejo un pequeño video que muestra cómo crear una ruta con varios puntos y como corregir puntos.</p>

                <div style={{ margin: 30 }}>
                    <video src="/asw-junio/img/NuevaRuta.mp4" controls width="500" height="400" className="video1"></video>
                </div>

                <p>En este otro video se muestra como subir imagenes a un punto cualquiera de la ruta.</p>

                <div style={{ margin: 30 }}>
                    <video src="/asw-junio/img/SubirImagen.mp4" controls width="500" height="400" className="video1"></video>
                </div>


                <h2>Cómo visualizar tus rutas y las compartidas por tus amigos</h2>
                <p>Para visualizar sus rutas o las de sus amigos deberá ir a la pestaña mapa. Donde le aparecerán el nombre y la descripción de sus rutas y las compartidas por sus amigos. Para visualizarla solamente tendrá que pinchar sobre el nombre de aquella ruta que quiera ver. Si quisiese ver las imagenes asociadas a un punto de su ruta deberá pinchar sobre el marcador de dicho punto</p>

                <p>Aquí dejo un pequeño video que muestra cómo visualizar una ruta.</p>

                <div>
                    <video src="/asw-junio/img/VerRutas.mp4" controls width="500" height="400" className="video1"></video>
                </div>

                <h2>Cómo compartir tus rutas con tus amigos</h2>
                <p>Para compartir una ruta deberá ir a la pestaña rutas. Una vez ahi seleccionar la ruta la cual quiere compartir. Una vez seleccionada le aparecerá compartir ruta, pulse y le aparecerá un cuadro de texto indicando que se ha compartido correctamente </p>

                <p>Aquí dejo un pequeño video que muestra cómo compartir una ruta.</p>

                <div>
                    <video src="/asw-junio/img/CompartirRuta.mp4" controls width="500" height="400" className="video1"></video>
                </div>

                <h2>Cómo eliminar tus rutas guardadas</h2>
                <p>Para eliminar las rutas que el usuario tiene guardadas deberá ir a la pestaña mapa, una vez ahi debera dar al botón borrar rutas.</p>

                <p> Aquí esta un pequeño video que muestra cómo eliminar las rutas.</p>

                <div>
                    <video src="/asw-junio/img/EliminarRuta.mp4" controls width="500" height="400" className="video2"></video>
                </div>
            </div>
        );
    }
}