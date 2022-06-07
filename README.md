# COW-FARM

## Vista preelimiinar del juego 👀


<img src="[https://github.com/TheDudeThatCode/TheDudeThatCode/blob/master/Assets/Hi.gif](https://github.com/AlejandroP11/Cow-Farm/tree/master/ImgReadme/previsualizarjuego.PNG)" width="10px"> 
<br/>

El juego **Cow-Farm**, es un método de entretenimiento para el público juvenil. En este juego, el usuario dirige un vehículo con el que tiene que evitar atropellar a los diferentes tipos de animales que van apareciendo en el mapa.
<br/>
Según va subiendo el nivel, sube la velocidad y así mismo la dificultad y todo esto queda reflejado en un sistema de puntos donde quedan guardadas nuestras mejores puntuaciones.


## Controles 📋
<br/>

![2](https://github.com/AlejandroP11/Cow-Farm/tree/master/ImgReadme/controles.PNG)

Hemos escogido un sistema de movimiento a través de estas míticas teclas, que nos permiten realizar todos los movimientos necesarios para jugar.
```
W / 🔼 - AVANAZA
A / ◀️ - GIRA A LA IZQUIERDA
S / 🔽 - RETROCEDE
D / ▶️ - GIRA A LA DERECHA
```

### Sistema de Registro y Login 👥
<br/>

![3](https://github.com/AlejandroP11/Cow-Farm/tree/master/ImgReadme/menuregistro.PNG)

![4](https://github.com/AlejandroP11/Cow-Farm/tree/master/ImgReadme/menuiniciosesion.PNG)

Hemos implementado un sistema de registro de usuarios para tener controladas las puntuaciones de los jugadores.
A través de los menús mostrados arriba, nos podremos tanto loguear como registrar. 

Todo esto va conectado a través de una base de datos SQLite la cual guarda los datos de registro y al iniciar sesión comprueba los mismos. También guarda el high score de cada usuario registrado para poder mostrarlo posteriormente en una tabla de puntuaciones.





## Sistema de puntuaciones 🏆
<br/>

![5](https://github.com/AlejandroP11/Cow-Farm/tree/master/ImgReadme/puntuacion.PNG)

El sistema de puntuaciones funciona de la siguiente forma, cuando un usuario pierde, comprueba a través de la id del usuario si ese es si highscore, si no lo es directamente no hace nada, si lo es, intercambia ese valor por el anterior en la base de datos y lo muestra en la tabla de puntuaciones.

Pero claro esto no acaba aquí, para generar más competitividad, la tabla de puntuaciones solo mostrará las 10 mejores de todo el juego.

<br/>

## Menú principal 📑
<br/>

![6](https://github.com/AlejandroP11/Cow-Farm/tree/master/ImgReadme/menuprincipal.PNG)


Este es el mení principal del juego, que aparece tras loguearnos o registrarnos. Tiene 3 funciones, la de jugar, la de elección de skins y la de consultar puntuaciones.

<br/>


## Sistema de elección de skins ️👾
![7](https://github.com/AlejandroP11/Cow-Farm/tree/master/ImgReadme/nuevasskins.PNG)


Este sistema funciona a través de una ventana la cual nos muetra 3 skins de cada, tanto de jugador como de enemigo. Es decir, 3 vehículos y tres animales en este caso, un tractor, un coche y una moto para el jugador y para el enemigo, una vaca, un jabalí y una capibara.

El guardado de skins funciona con la base de datos de la que hablé anteriormente. Cada skin tiene una id, lo que hace el programa es comparar las ids de amabas skins en la base de datos y cambiarlas si fuera neceario.

<br/>


## Construido con 🛠️
<br/>

* [Netbeans](https://netbeans.apache.org/) - Entorno de desarrollo
* [ItelliJ](https://www.jetbrains.com/es-es/idea/) - Entorno de desarrollo
* [SQLite](https://www.sqlite.org/index.html) - Sistema de base de datos
* [Java](https://www.java.com/es/download/help/whatis_java.html) - Lenguaje de programación

<br/>

## Autores ✒️
<br/>

* **Alejandro Pereiro Gavián** - *Desarrollo y Documentación* 
* **David Braga Rodrígues** - *Desarrollo y Documentación* 

También puedes mirar la lista de todos los [contribuyentes](https://github.com/AlejandroP11/Cow-Farm/graphs/contributors) quíenes han participado en este proyecto. 

<br/>

## Licencia 📄
<br/>

® Este proyecto está bajo la Licencia de **Nina Y Damián**, de las mejores licencias del siglo XXI.







---

