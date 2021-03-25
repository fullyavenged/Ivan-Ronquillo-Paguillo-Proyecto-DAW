# Descripción de la Aplicación
Esta aplicación pretende crear un espacio donde los usuarios puedan buscar distintos animes/mangas y ver sus datos al mismo tiempo que poder crear sus propias listas de los mismos y poder lleavar un seguimiento de los que ha visto, quiere ver, etc.

Usuario no registrado: Podrá buscar un anime/manga y ver información del mismo (Número de episodios, autor, géneros, estudio, etc.)

Usuario registrado: Podrá hacer lo mismo que el usuario sin registrar pero además tendrá su perfil donde podrá hacer su propia lista de mangas/anime. De las entradas añadidas a la lista se podrá modificar la nota, el estado (viendo, pendiente para ver, vista, etc.) yu borrar cualquiera de las entradas de la lista.

Otra cosa que podrá hacer el usuario registrado es añadir un nuevo anime/manga a la base de datos si este no se encontrase al realizar la búsqueda. Una vez añadido estaría disponible para todos los usuarios tanto para ver sus datos como para añadirlo a sus listas.

La base de datos sería realizada por mi para no depender de ninguna API.
# Requisitos de la Aplicación

* Login
* Distintas vistas según el rol del usuario, "registered"/"unregistered"
* Que los usuarios puedan añadir nuevas entradas en la base de datos
* Modificar la nota y el estado de las entradas en las listas
* Eliminar entrdas de la lista

# Tecnologías para el proyecto
Usaré Java como lenguaje de programación junto al framework Spring, con la integración de Hibernate y Thymeleaf para el frontend.

