# Proyecto PDE noviembre de Luis Miguel Urbez
## Explicacion del trabajo realizado
En el desarrollo de esta aplicación en Android Studio, me propuse crear una plataforma que consumiera datos de la API de CoinGecko, la cual seleccioné después de una exhaustiva investigación debido a su idoneidad para el tipo de aplicación que estaba diseñando.<br>
<br>
El proceso comenzó con la creación de un esquema inicial en la plataforma Lucidhart, la cual resultó ser una herramienta invaluable durante todo el proyecto. La capacidad de tener un boceto en línea en todo momento, permitiéndome realizar cambios sobre la marcha, demostró ser extremadamente útil. Inicialmente, el esquema mostraba datos básicos de estilo y las clases principales que formarían la base de mi aplicación. Con el tiempo, como es de esperar, el esquema se expandió y se volvió más detallado con los aspectos específicos de la aplicación.<br>
<br>
La API de CoinGecko proporciona una plataforma que permite realizar llamadas y obtener respuestas según la información solicitada en esa llamada. Aunque ofrece una amplia variedad de información, las llamadas no son siempre tan cómodas, ya que se requiere la aplicación de diversos filtros para obtener la información deseada. Esto resulta en un aumento significativo en el tamaño de las clases en la aplicación, así como en su número. La API es responsive, ya que se actualiza constantemente con nuevos datos y mejoras de rendimiento, y cuenta con la ventaja de permitir llamadas ilimitadas, a pesar de ser una API gratuita (con la única restricción de realizar una llamada cada 30 segundos).<br>
<br>
Inicialmente, enfrenté dificultades al trabajar con la API, ya que la manipulación de las respuestas no era óptima y no siempre obtenía los resultados deseados. Sin embargo, mediante la implementación constante de nuevas clases y una lógica mejorada en el proyecto, logré hacer que el manejo de este tipo de respuestas fuera más manejable y eficiente.<br>
<br>
Continuando con la implementación de esta aplicación de criptomonedas, se utilizaron diversas tecnologías clave que contribuyen a su funcionalidad y experiencia del usuario:

<br>1. API y Retrofit
<br>
Para la conexión a la API de CoinGecko, se optó por la eficiente biblioteca Retrofit. Esta herramienta simplifica la interacción con la API, gestionando las solicitudes y respuestas de manera eficaz. Además, Gson fue fundamental para deserializar las respuestas JSON de la API, permitiendo un manejo sencillo de los datos.
<br>
<br>2. Almacenamiento con SQLite
Con el objetivo de proporcionar una experiencia personalizada, se implementó una base de datos SQLite. Esta base de datos almacena los elementos favoritos del usuario, permitiéndole guardar o eliminar elementos según sus preferencias.<br>
<br>
3. Interfaz y RecyclerView<br>
La interfaz de usuario se diseñó para mostrar una lista de elementos mediante un RecyclerView. Cada elemento de la lista presenta un resumen y una imagen asociada, proporcionando una experiencia visual atractiva y fácil de usar.
<br>
<br>4. Uso de Glide<br>
Glide, una biblioteca de carga y visualización de imágenes eficiente, se integró para cargar y mostrar las imágenes de los elementos en el RecyclerView. Esto garantiza una carga rápida y una presentación visual fluida.
<br>
br>5. Detalles del elemento<br>
Al hacer clic en un elemento de la lista, se implementó un Intent para abrir una nueva actividad que muestra el contenido completo del elemento mediante un WebView. Esta característica permite una exploración más detallada de cada elemento.<br>
br>
6. Feedback y Toast<br>
La interacción con el usuario se mejoró mediante el uso de mensajes Toast, proporcionando información instantánea sobre la acción realizada, como guardar o eliminar un elemento de la lista de favoritos.
<br>
7. Interacción con Spinner<br>
Se incluyó un Spinner en la parte superior de la aplicación para permitir al usuario filtrar elementos por categoría. Esta funcionalidad ofrece una forma intuitiva de explorar y personalizar la visualización de datos.
<br>
8. OnClickListener<br>
Se implementó OnClickListener en cada elemento del RecyclerView para detectar clics y abrir el detalle del elemento. Además, se aplicó OnClickListener en los botones o íconos de favoritos, facilitando la gestión de la lista de elementos favoritos.<br>
br>
9. Preferencias del Usuario con DataStore<br>
Para mejorar la experiencia personalizada, se utilizó DataStore para almacenar preferencias del usuario, como la última categoría seleccionada en el Spinner o el modo oscuro/claro de la aplicación. Esto asegura que la aplicación se adapte a las preferencias individuales de cada usuario.<br>
<br>
Este enfoque integral en el desarrollo proporciona una aplicación robusta, intuitiva y altamente personalizable para los entusiastas de las criptomonedas. 
br>
<br>
## Aplicación de consumo de API Descripción del Proyecto:
### Desarrollar una aplicación que permita al usuario visualizar una elementos consumidos de una API de tu elección y, al hacer clic en una de ellas, mostrar el detalle de ese elemento en un WebView .
** Especificaciones: 1. API y Retrofit: **
Utiliza Retrofit para conectarte a la API.
Usa Gson para deserializar las respuestas JSON de la API. 2. Almacenamiento con SQLite:
Crea una base de datos SQLite para almacenar los elementos favoritos del usuario.
Proporciona una opción para que el usuario guarde o elimine elementos de sus favoritos.
3. Interfaz y RecyclerView:
Muestra una lista de elementos usando un RecyclerView .
Cada elemento de la lista debe mostrar un resumen del elemento y una imagen asociada.
4. Uso de Glide:
Utiliza Glide para cargar y mostrar las imágenes de los elementos en el
RecyclerView .
5. Detalles del elemento:
Proyecto PDE noviembre 1
Al hacer clic en un elemento de la lista, usa un Intent para abrir una nueva actividad que muestre el contenido completo del elemento usando un
WebView .
6. Feedback y Toast:
Usa mensajes Toast para informar al usuario cuando un elemento se guarda o se elimina de favoritos.
7. Interacción con Spinner:
Proporciona un Spinner en la parte superior de la aplicación que permita al
usuario filtrar elementos por categoría.
8. OnClickListener:
Implementa OnClickListener en cada elemento del RecyclerView para detectar clics y abrir el detalle del elemento.
Implementa OnClickListener en los botones o íconos de favoritos para guardar o eliminar elementos.
9. Preferencias del Usuario con DataStore:
Usa DataStore para almacenar preferencias del usuario, como la última categoría seleccionada en el Spinner o el modo oscuro/claro de la aplicación.
10. Extras:
Añade una opción para compartir el elemento. Usa Intent para compartir el
enlace del elemento en otras aplicaciones.
Sugerencias:
Comienza diseñando la arquitectura de la aplicación y la estructura de las bases de datos.
Haz un mockup o boceto de la interfaz para tener una idea clara de cómo se verá y funcionará la aplicación.
Divide el desarrollo en etapas. Por ejemplo, primero trabaja en la conexión con la API y la deserialización, luego en la interfaz y el RecyclerView , y así sucesivamente.
           Proyecto PDE noviembre 2

Entrega
Debes entregar el proyecto de la App y un vídeo en el que se vea tu código y tu
cara explicando tu proyecto, paso por paso.
Cuelga el vídeo en el OneDrive de tu cuenta de email de la UAX, y compártelo
conmigo - luisgasa@uax.es -
Formato de entrega:
Proyecto de Android Studio exportado en zip Archivo de texto (.txt) con link al vídeo

