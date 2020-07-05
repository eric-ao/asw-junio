import React, {Component} from "react";
import jsonTojsonLD from "./jsonTojsonLD.jsx";
import {Point} from "./Clases.js";
import SolidAuth from "solid-auth-client";
import ldflex from "@solid/query-ldflex";
import {GoogleApiWrapper, InfoWindow, Map, Marker, Polyline} from "google-maps-react";
import ImageComponent from '../Imagen/imagen.component';
import './mapComponent.css';
import {estiloCustomDia} from './mapComponent.style';
import Dropdown from 'react-dropdown'
import 'react-dropdown/style.css'

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
                descripcion: '',
                categoria: ''
            }],
            rutasCompartidas: [],
            selectedPoint: null,
            selectedRoute: {
                locations: [],
                nombre: '',
                descripcion: '',
                categoria: ''
            },
            modo: estiloCustomDia,
            busqueda: '',
            rutasBuscadas: [],
            hayBusquedaPorTexto: false,
            hayBusquedaPorCategoria: false,
            hayBusqueda: false,
            categoriaBuscada: ''
        };

        this.handleMapClick = this.handleMapClick.bind(this);
        this.handleLoad = this.handleLoad.bind(this);
        this.handleSave = this.handleSave.bind(this);
        this.updateLocations = this.updateLocations.bind(this);
        this.handleClear = this.handleClear.bind(this);
        this.handleDelete = this.handleDelete.bind(this);
        this.deletePoint = this.deletePoint.bind(this);
        this.nueva = this.nueva.bind(this);

        this.handleChangeName = this.handleChangeName.bind(this);
        this.handleChangeCategory = this.handleChangeCategory.bind(this);
        this.handleChangeDescription = this.handleChangeDescription.bind(this);

        this.handleSearchText = this.handleSearchText.bind(this);
        this.handleSearchCategory = this.handleSearchCategory.bind(this);
        this.handleSearch = this.handleSearch.bind(this);
    }

    componentDidUpdate(prevProps) {
        //RECUPERA LA RUTAS COMPARTIDAS.
        this.recuperarRutasCompartidas().then();

        //RECUPERA MIS RUTAS.
        if (this.state.url && !this.state.load) {
            const doc = SolidAuth.fetch(new URL('rutas.json', this.state.url));
            doc.then(async response => {
                if (response.status === 200) {
                    const json = await response.text();
                    const jsonParse = JSON.parse(json);

                    if (jsonParse.rutas) {
                        const lista = jsonParse.rutas.map(ruta => ({
                            ...ruta,
                            locations: ruta.locations.map(
                                eleinterno => ({
                                    lat: eleinterno["latitud"],
                                    lng: eleinterno["longitud"],
                                    images: eleinterno["archivos"]
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
    }
    async recuperarRutasCompartidas() {
        if (this.state.url && !this.state.loadCompartidas) {
            this.setState(prevState => ({
                ...prevState,
                loadCompartidas: true
            }));
            let url = this.state.url.toString().replace('/asw', '');
            const response = await SolidAuth.fetch(new URL('inbox', url));
            if (response.ok) {
                const text = await response.text();
                let aux = text.match(/<.*>\n/g);
                if (aux !== null) {
                    const notificaciones = text.match(/<.*>\n/g).map(n => n.replace(/[<>\n]/g, ''));
                    for (const n of notificaciones) {
                        const response = await SolidAuth.fetch(new URL('inbox/' + n, url));
                        const json = await response.json();
                        this.setState(prevState => ({
                            ...prevState,
                            rutasCompartidas: [
                                ...prevState.rutasCompartidas,
                                json
                            ]
                        }));
                    }
                }
            }
        }
    }
    async setUrlFromStorage() {
        if (this.props.webId && !this.state.url) {
            const storageRoot = await ldflex[this.props.webId]["pim:storage"];
            if (storageRoot) {
                const urlRutas = new URL(
                    "/asw/rutas",
                    storageRoot.value
                );
                this.setState(prevState => ({
                    ...prevState,
                    url: urlRutas
                }));
            }
        }
    }
    handleLoad() {
        this.setUrlFromStorage();
    }


    // Guarda los puntos en el POD
    async updateLocations(rutas) {
        await SolidAuth.fetch(new URL('rutas.json', this.state.url), {
            method: "PUT",
            body: JSON.stringify(jsonTojsonLD(rutas, this.state.url)),
            headers: {
                Accept: "application/ld+json"
            }
        });
        this.setState(prevState => ({
            ...prevState,
            rutas: rutas
        }));
    }


    //BORRA TODAS LAS RUTAS DEL USUARIO.
    async handleClear() {
        this.setState(prevState => {

            if(this.state.rutas.length > 0) {
                for (let i = 0; i < this.state.rutas.length; i++) {
                    if(this.state.rutas[i].locations === this.state.selectedRoute.locations) {
                        this.state.selectedRoute = [{
                            locations: [],
                            nombre: '',
                            descripcion: '',
                            categoria: ''
                        }];
                    }
                }
            }

            this.updateLocations([{
                locations: [],
                nombre: '',
                descripcion: '',
                categoria: ''
            }]);
            return {
                ...prevState
            };
        });
    }
    //BORRA LA RUTA SELECCIONADA.
    async handleDelete() {
        let rutas;
        this.setState(prevState => {
            let aux = prevState.rutas;
            prevState.rutas = [];
            for(let i=0; i<aux.length; i++) {
                if(this.state.selectedRoute !== aux[i])
                    prevState.rutas.push(aux[i]);
                else {
                    this.state.selectedRoute = [{
                        locations: [],
                        nombre: '',
                        descripcion: '',
                        categoria: ''
                    }];
                }
            }

            rutas = prevState.rutas;

            this.updateLocations(rutas);
            return {
                ...prevState
            };
        });
    }
    //SE EJECUTA AL DARLE AL BOTON DE GUARDAR RUTA.
    async handleSave() {
        console.log(this.getLastRoute().nombre);
        if(this.getLastRoute().nombre.trim() !== "" && this.getLastRoute().nombre !== undefined){
            if(this.getLastRoute().descripcion.trim() !== "" && this.getLastRoute().descripcion !== undefined) {
                if(this.getLastRoute().categoria !== "" && this.getLastRoute().categoria !== undefined) {
                    let rutas = [...this.state.rutas, {
                        locations: [],
                        nombre: '',
                        descripcion: '',
                        categoria: ''
                    }];
                    await this.updateLocations(rutas);
                }
                else {
                    alert ("Categoría no seleccionada")
                }
            }
            else {
                alert("Descripción vacía")
            }
        }
        else {
            alert("Nombre vacío")
        }
    }
    //BORRA EL ÚLTIMO PUNTO MARCADO (antes de guardar).
    async deletePoint() {
        await this.setState(prevState => {
            this.getLastRoute(prevState).locations.pop();
            this.updateLocations(prevState.rutas);
            return {
                ...prevState
            };
        });
    }
    //PREPARA EL MAPA PARA CREAR UNA RUTA DE CERO.
    async nueva() {
        this.state.selectedRoute = [{
            locations: [],
            nombre: '',
            descripcion: '',
            categoria: ''
        }];

        this.state.rutas.pop();
        let rutas = [...this.state.rutas, {
            locations: [],
            nombre: '',
            descripcion: '',
            categoria: ''
        }];
        await this.updateLocations(rutas);
    }


    // RESPONDE AL EVENTO DE HACER CLICK EN EL MAPA.
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
    };
    // DEVUELVE LA ULTIMA RUTA.
    getLastRoute(state = undefined) {
        let prevState = state ? state : this.state;
        return prevState.rutas[prevState.rutas.length - 1];
    }
    // AÑADE UNA IMAGEN AL PUNTO SELECCIONADO.
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


    // CAMBIOS EN EL FORMULARIO DE NUEVA RUTA.
    async handleChangeName(e) {
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
    }
    async handleChangeDescription(e) {
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
    }
    async handleChangeCategory(e) {
        let value = e.value;
        this.setState(prevState => {
            let lastRoute = this.getLastRoute(prevState);
            prevState.rutas[prevState.rutas.length - 1] = {
                ...lastRoute,
                categoria: value
            };
            return {
                ...prevState
            };
        });
    }

    // CAMBIOS EN EL FORMULARIO DE BUSQUEDA.
    async handleSearchCategory(e) {
        let value = e.value;
        this.setState(prevState => {
            prevState.categoriaBuscada =  value;
            prevState.hayBusquedaPorCategoria = value.toLowerCase() !== "cualquiera";
            return {
                ...prevState
            };
        });
    }
    async handleSearchText(e) {
        let value = e.target.value;
        this.setState(prevState => {
            prevState.busqueda = value;
            prevState.hayBusquedaPorTexto = value.trim().length !== 0;
            return {
                ...prevState
            };
        });
    }
    async handleSearch() {
        this.setState(prevState => {
            if(prevState.hayBusquedaPorTexto && !prevState.hayBusquedaPorCategoria) {
                prevState.hayBusqueda = true;
                let rutasAux = [];

                if (prevState.rutasCompartidas.length > 0) {
                    for (let i = 0; i < prevState.rutasCompartidas.length; i++) {
                        if (prevState.rutasCompartidas[i].nombre.toLowerCase().includes(prevState.busqueda.toLowerCase())) {
                            rutasAux.push(prevState.rutasCompartidas[i])
                        }
                    }
                }

                let rutasAux2 = prevState.rutas.slice(0, -1);
                if (rutasAux2.length > 0) {
                    for (let i = 0; i < rutasAux2.length; i++) {
                        if (rutasAux2[i].nombre.toLowerCase().includes(prevState.busqueda.toLowerCase()))
                            rutasAux.push(rutasAux2[i])
                    }
                }

                prevState.rutasBuscadas = rutasAux;
                return {
                    ...prevState
                };
            }
            else if (prevState.hayBusquedaPorCategoria && !prevState.hayBusquedaPorTexto) {
                prevState.hayBusqueda = true;
                let rutasAux = [];

                if (prevState.rutasCompartidas.length > 0) {
                    for (let i = 0; i < prevState.rutasCompartidas.length; i++) {
                        try {
                            if (prevState.rutasCompartidas[i].categoria.toLowerCase().includes(prevState.categoriaBuscada.toLowerCase())) {
                                rutasAux.push(prevState.rutasCompartidas[i])
                            }
                        } catch (TypeError) {
                            console.log("Ruta compartida sin categoría")
                        }
                    }
                }

                if (prevState.rutas.length > 0) {
                    for (let i = 0; i < prevState.rutas.length; i++) {
                        try {
                            if (prevState.rutas[i].categoria.toLowerCase().includes(prevState.categoriaBuscada.toLowerCase())) {
                                rutasAux.push(prevState.rutas[i])
                            }
                        } catch (TypeError) {
                            console.log("Ruta propia sin categoría")
                        }
                    }
                }

                prevState.rutasBuscadas = rutasAux;
                return {
                    ...prevState
                };
            }
            else if (prevState.hayBusquedaPorTexto && prevState.hayBusquedaPorCategoria) {
                prevState.hayBusqueda = true;
                let rutasAux = [];

                if (prevState.rutasCompartidas.length > 0) {
                    for (let i = 0; i < prevState.rutasCompartidas.length; i++) {
                        if (prevState.rutasCompartidas[i].nombre.toLowerCase().includes(prevState.busqueda.toLowerCase())) {
                            rutasAux.push(prevState.rutasCompartidas[i])
                        }
                    }
                }

                let rutasAux2 = prevState.rutas.slice(0, -1);
                if (rutasAux2.length > 0) {
                    for (let i = 0; i < rutasAux2.length; i++) {
                        if (rutasAux2[i].nombre.toLowerCase().includes(prevState.busqueda.toLowerCase()))
                            rutasAux.push(rutasAux2[i])
                    }
                }

                let rutasAux3 = [];
                if (rutasAux.length > 0) {
                    for (let i = 0; i < rutasAux.length; i++) {
                        try {
                            if (rutasAux[i].categoria.toLowerCase().includes(prevState.categoriaBuscada.toLowerCase())) {
                                rutasAux3.push(rutasAux[i])
                            }
                        } catch (TypeError) {
                            console.log("Ruta compartida sin categoría")
                        }
                    }
                }
                prevState.rutasBuscadas = rutasAux3;
                return {
                    ...prevState
                };
            }
            else {
                prevState.hayBusqueda = false;
                return {
                    ...prevState
                };
            }
        });
    }

    render() {
        let categories = ["Montaña", "Playa", "Ciudad"];
        let categoriesBusqueda = ["Cualquiera", "Montaña", "Playa", "Ciudad"];

        let fragment;

        //MUESTRA TODAS LAS RUTAS SI NO SE HA REALIZADO NINGUNA BUSQUEDA
        if(!this.state.hayBusqueda) {
            fragment = [...this.state.rutas.slice(0, -1), ...this.state.rutasCompartidas].map((route, i) => (
                <React.Fragment key={`route_${i}`}>
                    <dt >
                        <button className="botonRuta" onClick={(e) => {
                            e.preventDefault();
                            if(this.state.selectedRoute !== route) {
                                this.setState((prevState) => ({
                                    ...prevState,
                                    selectedRoute: route
                                }))
                            }
                            else {
                                this.setState((prevState) => ({
                                    ...prevState,
                                    selectedRoute: [{
                                        locations: [],
                                        nombre: '',
                                        descripcion: '',
                                        categoria: ''
                                    }]
                                }));
                            }
                        }}>
                            {route.nombre}
                        </button>
                    </dt>
                    {
                        this.state.selectedRoute === route ?
                            <p className="desc">{route.descripcion}</p> : null
                    }
                </React.Fragment>));
        }
        //MUESTRA SOLO LAS RUTAS RESULTADO DE LA BUSQUEDA.
        else {
            fragment = this.state.rutasBuscadas.map((route, i) => (
                <React.Fragment key={`route_${i}`} className="lista">
                    <dt >
                        <button className="botonRuta" onClick={(e) => {
                            e.preventDefault();
                            if(this.state.selectedRoute !== route) {
                                this.setState((prevState) => ({
                                    ...prevState,
                                    selectedRoute: route
                                }))
                            }
                            else {
                                this.setState((prevState) => ({
                                    ...prevState,
                                    selectedRoute: [{
                                        locations: [],
                                        nombre: '',
                                        descripcion: '',
                                        categoria: ''
                                    }]
                                }));
                            }
                        }}>
                            {route.nombre}
                        </button>
                    </dt>
                    {
                        this.state.selectedRoute === route ?
                            <p className="desc">{route.descripcion}</p> : null
                    }
                </React.Fragment>
            ))
        }

        let creatingRoutePolyline =
            <Polyline
                path={this.getLastRoute().locations}
                options={{
                    strokeColor: "#ea4335",
                    strokeOpacity: 1,
                    strokeWeight: 2,}}
            />;


        return (
            <div className="map-container">
                <div className="parteSuperior">
                    {/* PARTE SUPERIOR DE LA PÁGINA DE MAPA */}
                    <div className="rutas">
                        {/* FORMULARIO PARA CREAR NUEVA RUTA */}
                        <div>{
                            this.state.url ? <>
                                    <form className="form">
                                        <label className="etiqueta"> Nombre:
                                            <input type="text" value={this.getLastRoute().nombre} onChange={this.handleChangeName}/>
                                        </label>
                                        <label className="etiqueta">Descripción:
                                            <input type="text" value={this.getLastRoute().descripcion} onChange={this.handleChangeDescription}/>
                                        </label>
                                        <label className="etiqueta"> Categoría:
                                            <Dropdown options={categories} onChange={this.handleChangeCategory} value={this.getLastRoute().categoria} placeholder="Seleccione una..."/>
                                        </label>
                                    </form>
                                </> : <p>Cargando...</p>
                        } </div>
                        {/* FORMULARIO PARA CREAR NUEVA RUTA */}



                        {/* MUESTRA LAS RUTAS A LA DERECHA */}
                        <dl>
                            <label className="etiqueta">Buscar</label>
                            <div >
                                <input className="elemB1" type="text" value={this.state.busqueda} onChange={this.handleSearchText}/>
                                <Dropdown  options={categoriesBusqueda} onChange={this.handleSearchCategory} value={this.state.categoriaBuscada} placeholder="Seleccione una..."/>
                                <button className="botonB" onClick={this.handleSearch}> Buscar </button>
                            </div>
                            <div className="lista">{fragment}</div>


                        </dl>
                        {/* MUESTRA LAS RUTAS A LA DERECHA */}
                    </div>
                    {/* PARTE SUPERIOR DE LA PÁGINA DE MAPA */}



                    {/* PARTE INTERMEDIA DE LA PÁGINA DE MAPA */}
                    <div className="botones">
                        <button onClick={this.nueva} className="boton"> Nueva</button>
                        {
                            this.getLastRoute().locations.length > 0 ?
                                <button onClick={this.deletePoint} className="boton"> Borrar último punto</button> : null
                        }
                        {
                            this.getLastRoute().locations.length > 0 ?
                            <button onClick={this.handleSave} className="boton"> Guardar ruta </button> : null
                        }
                        {
                            this.state.selectedRoute.locations !== undefined && this.state.selectedRoute.locations.length !== 0 ?
                            <button onClick={this.handleDelete} className="boton"> Borrar ruta</button> : null
                        }
                        <button onClick={this.handleClear} className="boton"> Borrar todas mis rutas</button>
                    </div>
                    {/* PARTE INTERMEDIA DE LA PÁGINA DE MAPA */}
                </div>

                {/* PARTE DEL MAPA */}
                <div className="mapa">
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
                        styles={this.state.modo}>

                        {/* LINEAS Y PUNTOS AL CREAR RUTAS */}
                        {creatingRoutePolyline}
                        {this.getLastRoute().locations.map((location, i) =>
                            <Marker key={`marker1_${i}`} position={location}
                                    onClick={(props, marker) => this.setState(prevState => ({
                                        ...prevState,
                                        selectedPoint: location
                                    }))}/>
                        )}
                        {/* LINEAS Y PUNTOS AL CREAR RUTAS */}



                        {/* MUESTRA LOS MARCADORES Y LA LINEA AL SELECCIONAR UNA RUTA, SI NO HAY RUTA SELECCIONADA, NO HACE NADA */}
                        {
                            this.state.selectedRoute.locations !== undefined ?
                                <Polyline
                                    path={this.state.selectedRoute.locations}
                                    options={{
                                        strokeColor: "#ffb01f",
                                        strokeOpacity: 1,
                                        strokeWeight: 2,
                                    }}/>
                                : null
                        }
                        {
                            this.state.selectedRoute.locations !== undefined ?
                            this.state.selectedRoute.locations.map((location, i) =>
                                <Marker key={`marker1_${i}`} position={location}
                                        onClick={(props, marker) => this.setState(prevState => ({
                                            ...prevState,
                                            selectedPoint: location
                                        }))}/>)
                                : null

                        }
                        {/* MUESTRA LOS MARCADORES Y LA LINEA AL SELECCIONAR UNA RUTA, SI NO HAY RUTA SELECCIONADA, NO HACE NADA */}



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
                        {/* GLOBO QUE SALE AL PULSAR UN MARCADOR Y QUE CONTIENE LAS IMAGENES */}



                        {/* POSIBILIDAD DE AÑADIR IMAGENES A LOS PUNTOS */}
                        {
                            this.state.selectedPoint && (<ImageComponent url={this.state.url} addImage={this.addImageToSelectedPoint.bind(this)}/>)
                        }
                        {/* POSIBILIDAD DE AÑADIR IMAGENES A LOS PUNTOS */}
                    </Map>
                </div>
                {/* PARTE DEL MAPA */}
            </div>
        );
    }
}

export default GoogleApiWrapper({
    //API DEVELOPER
    apiKey: "AIzaSyBzv5Utxl-rBk_OW8Jnkooi3FNkL1jGSXM"
    //API GRATUITA
    //apiKey: "AIzaSyDwZUjR7_j6100CdDHxmCvi_Hi7Z681wS8"
})(MapComponent);