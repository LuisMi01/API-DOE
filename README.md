# Proyecto PDE noviembre de Luis Miguel Urbez

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

