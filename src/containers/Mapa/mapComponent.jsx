import React, { Component } from "react";
import jsonTojsonLD from "./jsonTojsonLD.jsx";
import { Point } from "./Clases.js";

import SolidAuth from "solid-auth-client";
import ldflex from "@solid/query-ldflex";

import { Map, GoogleApiWrapper, Marker, Polyline, InfoWindow } from "google-maps-react";
import ImageComponent from '../Imagen/imagen.component';


export class MapComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            url: false,
            load: false,
            loadCompartidas: false,
            rutas: [{
                locations: [],
                nombre: '',
                descripcion: ''
            }],
            rutasCompartidas: [],
            selectedPoint: null,
            selectedRoute: {
                locations: [],
                nombre: '',
                descripcion: ''
            }
        };

        this.handleMapClick = this.handleMapClick.bind(this);
        this.handleLoad = this.handleLoad.bind(this);
        this.handleSave = this.handleSave.bind(this);
        this.updateLocations = this.updateLocations.bind(this);
        this.handleClear = this.handleClear.bind(this);
    }

    async setUrlFromStorage() {
        if (this.props.webId && !this.state.url) {
            const storageRoot = await ldflex[this.props.webId]["pim:storage"];
            if (storageRoot) {
                const exampleUrl = new URL(
                    "/share/",
                    storageRoot.value
                );
                this.setState(prevState => ({
                    ...prevState,
                    url: exampleUrl
                }));
            }
        }
    }

    //Cargar el json
    handleLoad() {
        this.setUrlFromStorage();
    }

    async recuperarRutasCompartidas() {
        if (this.state.url && !this.state.loadCompartidas) {
            this.setState(prevState => ({
                ...prevState,
                loadCompartidas: true
            }))
            var url = this.state.url.toString().replace('/share','');
            const response = await SolidAuth.fetch(new URL('inbox', url));
            console.log('COMPARTIDAS');
            if (response.ok) {
                const text = await response.text();
                console.log(text);
                const notificaciones = text.match(/<.*>\n/g).map(n => n.replace(/[<>\n]/g,''));
                console.log(notificaciones);
                notificaciones.forEach(async n => {
                    const response = await SolidAuth.fetch(new URL('inbox/'+n, url));
                    const json = await response.json();
                    this.setState(prevState => ({
                        ...prevState,
                        rutasCompartidas: [
                            ...prevState.rutasCompartidas,
                            json
                        ]
                    }))
                    console.log('RUTA ' + n);
                    console.log(json);
                })
            }
            else {
                console.log(response);
            }
        }
    }

    componentDidUpdate(prevProps) {
        this.recuperarRutasCompartidas();
        if (this.state.url && !this.state.load) {

            const doc = SolidAuth.fetch(new URL('rutaEjemplo.json', this.state.url));

            doc.then(async response => {
                if (response.status === 200) {
                    const json = await response.text();

                    const jsonParse = JSON.parse(json);

                    if (jsonParse.rutas) {
                        const lista = jsonParse.rutas.map(ruta => ({
                            ...ruta,
                            locations: ruta.locations.map(
                                eleinterno => ({
                                    lat: eleinterno["schema:latitude"],
                                    lng: eleinterno["schema:longitude"],
                                    images: eleinterno["viade:images"]
                                })
                            )
                        }));
    
                        this.setState(prevState => ({
                            ...prevState,
                            load: true,
                            rutas: lista
                        }));
    
                    }

                } else if (response.status === 404) {
                    console.log("Documento no encontrado");
                    this.setState(prevState => ({
                        ...prevState,
                        load: true
                    }));
                } else {
                    console.log("Error indeterminado");
                    this.setState(prevState => ({
                        ...prevState,
                        load: true
                    }));
                }
            });
        }
        console.log(this.state.locations);
    }

    // Guarda los puntos en el POD
    async updateLocations(rutas) {
        const result = await SolidAuth.fetch(new URL('rutaEjemplo.json', this.state.url), {
            method: "PUT",
            body: JSON.stringify(jsonTojsonLD(rutas, this.state.url)),
            headers: {
                Accept: "application/ld+json"
            }
        });
        console.log(result);
        this.setState(prevState => ({
            ...prevState,
            rutas: rutas
        }));
    }

    async handleClear() {
        await this.updateLocations([{
            locations: [],
            nombre: '',
            descripcion: ''
        }]);
    }

    //Se ejecuta al darle al botón "Guardar ruta"
    async handleSave() {
        let rutas = [...this.state.rutas, {
            locations: [],
            nombre: '',
            descripcion: ''
        }];
        await this.updateLocations(rutas);
    }

    //Añadir los marcadores
    handleMapClick = (ref, map, ev) => {
        const location = ev.latLng;

        const location2 = location + "";
        const listaDivida = location2.split(",");
        const parte1 = listaDivida[0].slice(1, -1);
        const parte2 = listaDivida[1].substring(0, listaDivida[1].length - 1);
        const punto = new Point(parseFloat(parte1), parseFloat(parte2));

        this.setState(prevState => {
            var lastRoute = this.getLastRoute(prevState);
            prevState.rutas[prevState.rutas.length - 1] = {
                ...lastRoute,
                locations: [...lastRoute.locations, punto]
            };

            return {
                ...prevState
            };
        });
        map.panTo(punto);
    };

    getLastRoute(state = undefined) {
        var prevState = state ? state : this.state;
        return prevState.rutas[prevState.rutas.length - 1];
    }

    addImageToSelectedPoint(image) {
        this.setState(prevState => {
            let selectedPoint = this.state.selectedPoint;
            if (selectedPoint) {
                selectedPoint.images = selectedPoint.images ? selectedPoint.images : [];
                selectedPoint.images.push(image);
                return {
                    ...prevState
                };
            }
            else {
                return prevState;
            }
        })
    }

    render() {
        console.log(this.state.rutas);

        let estiloCustom = [{
                featureType: "poi",
                elementType: "all",
                stylers: [
                    {visibility: "off"}
                ],
            }, {
                featureType: "water",
                elementType: "all",
                stylers: [
                    {"saturation": "100"},
                    {"lightness": "-6"}],
        },];

    return (
            <div className="map-container">
                <div class="rutas">
                    <div>{
                        this.state.url ? <>
                                <form>
                                    <label> Nombre:
                                        <input type="text" value={this.getLastRoute().nombre} onChange={(e) => {
                                                let value = e.target.value;
                                                this.setState(prevState => {
                                                    let lastRoute = this.getLastRoute(prevState);
                                                    prevState.rutas[prevState.rutas.length - 1] = {
                                                        ...lastRoute,
                                                        nombre: value
                                                    };
                                                    return {
                                                        ...prevState
                                                    };
                                                })
                                        }}/>
                                        </label>
                                        <label>Descripción:
                                            <input type="text" value={this.getLastRoute().descripcion}
                                                   onChange={(e) => {
                                                       let value = e.target.value;
                                                       this.setState(prevState => {
                                                           let lastRoute = this.getLastRoute(prevState);
                                                           prevState.rutas[prevState.rutas.length - 1] = {
                                                               ...lastRoute,
                                                               descripcion: value
                                                           };
                                                           return {
                                                               ...prevState
                                                           };
                                                       })
                                                   }}/>
                                        </label>
                                    </form>
                                    <button onClick={this.handleSave} className="btn btn-secondary"> Guardar ruta </button>
                                    <button onClick={this.handleClear} className="btn btn-secondary"> Borrar rutas almacenadas </button>
                                    <span>
                            </span>
                                {
                                    this.state.selectedPoint && (
                                        <ImageComponent url={this.state.url}
                                                        addImage={this.addImageToSelectedPoint.bind(this)}/>
                                        )
                                    }
                                </> :
                            <p>Cargando...</p>
                        }
                    </div>
                    {/* MUESTRA LAS RUTAS A LA DERECHA */}
                    <dl>
                        {
                            [...this.state.rutas.slice(0, -1)].map((route, i) => (
                                <React.Fragment key={`route_${i}`}>
                                    <dt>
                                        <a href="/#" onClick={(e) => {
                                            e.preventDefault();
                                            this.setState((prevState) => ({
                                                ...prevState,
                                                selectedRoute: route
                                            }))
                                        }}>
                                            {route.nombre}
                                        </a>
                                    </dt>
                                    <dd>{route.descripcion}</dd>
                                </React.Fragment>
                            ))
                        }
                    </dl>

                </div>
                <Map
                    google={this.props.google}
                    className={"map"}
                    zoom={15}
                    initialCenter={{
                        lat:43.36029,
                        lng:-5.84476
                    }}
                    onReady={this.handleLoad}
                    onClick={this.handleMapClick}
                    fullscreenControl={false}
                    styles={estiloCustom}>

                    {/* LINEA DE RUTAS CREADAS */}
                    <Polyline
                        path={this.state.selectedRoute.locations}
                        options={{
                            strokeColor: "#ffb01f",
                            strokeOpacity: 1,
                            strokeWeight: 2,}}/>
                    {/* LINEA AL CREAR RUTAS */}
                    <Polyline
                        path={this.getLastRoute().locations}
                        options={{
                            strokeColor: "#ea4335",
                            strokeOpacity: 1,
                            strokeWeight: 2,}}/>

                    {this.state.selectedRoute.locations.map((location, i) =>
                        <Marker key={`marker1_${i}`} position={location}
                                onClick={(props, marker) => this.setState(prevState => ({
                                    ...prevState,
                                    selectedPoint: location
                                }))}/>
                    )}
                    {this.getLastRoute().locations.map((location, i) =>
                        <Marker key={`marker1_${i}`} position={location}
                                onClick={(props, marker) => this.setState(prevState => ({
                                    ...prevState,
                                    selectedPoint: location
                                }))}/>
                    )}

                    {/* GLOBO QUE SALE AL PULSAR UN MARCADOR Y QUE CONTIENE LAS IMAGENES */}
                    {
                        <InfoWindow visible={this.state.selectedPoint != null} position={this.state.selectedPoint}>
                            <div>
                                <p>Imágenes</p>{
                                    this.state.selectedPoint && this.state.selectedPoint.images && this.state.selectedPoint.images.map((image, j) => (
                                        <img key={`img_${j}`} src={new URL(image, this.state.url)} alt=""/>
                                    ))
                                }
                            </div>
                        </InfoWindow>
                    }
                </Map>
            </div>
        );
    }
}

export default GoogleApiWrapper({
    //API DE PAGO
    apiKey: "AIzaSyBzv5Utxl-rBk_OW8Jnkooi3FNkL1jGSXM"
    //API GRATUITA
    //apiKey: "AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8"
})(MapComponent);