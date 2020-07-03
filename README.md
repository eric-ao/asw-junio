[![Build Status](https://travis-ci.org/eric-ao/asw-junio.svg?branch=master)](https://travis-ci.org/github/eric-ao/asw-junio)
[![codecov](https://codecov.io/gh/eric-ao/asw-junio/branch/master/graphs/badge.svg)](https://codecov.io/gh/eric-ao/asw-junio)

# VIADE_ES4B v2

Proyecto realizado para la evaluación extraordinaria de Junio de 2020.

Grado de Ingeniería Informática de Software por la Universidad de Oviedo.

Autor: Eric Andrés Obaya, UO258623.

## Características de la aplicación y mejoras.

La aplicación nos permite iniciar sesión con nuestra cuenta de SOLID Community, o en caso de no tenerla nos permitirá registrarnos.

Una vez que hemos iniciado sesión satisfactoriamente, podremos hacer varias cosas:
* Modificar nuestro perfil de SOLID Community.
* Crear una nueva ruta o visualizar tanto nuestras rutas como las compartidas por nuestros amigos.
* Ver nuestra lista de amigos y compartir rutas con ellos.
* Acceder a la pestaña de ayuda para más información sobre como utilizar la app.

Las mejoras que he realizado sobre la aplicación general son sobretodo sobre la funcionalidad del mapa.

Anteriormente si queríamos borrar una ruta, no podíamos, teníamos que borrarlas todas. Ahora se puede borrar la ruta que tengamos seleccionada.

Ahora también podemos borrar los puntos que vamos marcando si asi lo queremos.

He añadido también que se puedan añadir imagenes en cualquier punto que seleccionemos, a diferencia de antes que las imagenes se añadían automaticamente en el último punto marcado, independientemente del punto que tuviesemos seleccionado.

Esos son los cambios de funcionalidad más importantes que he hecho, y los que más podía necesitar la aplicación de cara a la usabilidad.

También he hecho muchos cambios menores en cuanto al estilo, el formato de los JSON y el mapa.



## Despliegue de la aplicación en local

Para desplegar la aplicación en local sencillamente tendremos que clonar el repositorio y ejecutar los siguientes comandos:
```javascript
npm install
npm start
```
La aplicación se pondrá a funcionar sobre el puerto 3000, y en caso de que este estuviese ocupado, buscará automáticamente otro libre.
