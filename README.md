Dog Breeds App 🐶

Dog Breeds App es una aplicación móvil desarrollada en Kotlin que muestra una lista de razas de perros y permite al usuario seleccionar una raza para ver imágenes asociadas. Utiliza una arquitectura limpia (Clean Architecture) y principios SOLID para lograr un código mantenible, escalable y fácil de testear.

Características

	•	Lista de razas de perros disponibles usando la API pública de Dog CEO.
	•	Muestra imágenes asociadas a una raza seleccionada.
	•	Manejador de errores cuando la conexión a Internet no está disponible.
	•	Diseño simple y funcional utilizando Jetpack Compose.

Tecnologías Usadas

	•	Kotlin: Lenguaje principal de la aplicación.
	•	Jetpack Compose: Para la interfaz de usuario declarativa.
	•	Hilt: Para inyección de dependencias.
	•	Retrofit: Para la comunicación con la API.
	•	Coroutines y Flow: Para manejo de concurrencia y flujo de datos.
	•	JUnit y Mockito: Para pruebas unitarias.
	•	SOLID y Clean Architecture: Para una arquitectura robusta y mantenible.

Arquitectura del Proyecto

Este proyecto sigue una estructura de Clean Architecture con tres capas principales:

	1.	Capa de Presentación (Presentation Layer): Contiene la interfaz de usuario de la aplicación, gestionada mediante Jetpack Compose. Aquí se encuentran los ViewModels, que interactúan con los casos de uso en la capa de dominio para obtener y procesar los datos.
	2.	Capa de Dominio (Domain Layer): Contiene la lógica empresarial y los casos de uso (Use Cases). Cada caso de uso representa una acción específica, como obtener la lista de razas de perros o las imágenes de una raza en particular.
	3.	Capa de Datos (Data Layer): Administra la comunicación con la API y otras fuentes de datos. Contiene los repositorios y modelos de datos, además de las implementaciones para manejar la red y gestionar los datos de manera eficiente.

Aplicación de los Principios SOLID

La aplicación utiliza los principios SOLID de la siguiente manera:

	1.	Single Responsibility Principle (SRP): Cada clase y función en el proyecto tiene una única responsabilidad. Por ejemplo, el DogBreedsViewModel es responsable solo de manejar la lógica de la interfaz para las razas de perros, mientras que el DogBreedsImagesUseCase maneja la obtención de las imágenes de cada raza.
	2.	Open/Closed Principle (OCP): Las clases están abiertas para extensión, pero cerradas para modificación. Las interfaces como Repository permiten extender las implementaciones del repositorio sin modificar las interfaces originales.
	3.	Liskov Substitution Principle (LSP): Las implementaciones de las interfaces cumplen con este principio, permitiendo que las dependencias inyectadas puedan ser reemplazadas por mocks durante las pruebas sin afectar el funcionamiento de la aplicación.
	4.	Interface Segregation Principle (ISP): Las interfaces se mantienen específicas y enfocadas, como DogBreedsRepository y DogImagesRepository, en lugar de una única interfaz de repositorio genérica.
	5.	Dependency Inversion Principle (DIP): La aplicación depende de abstracciones en lugar de implementaciones concretas. Hilt se utiliza para la inyección de dependencias, permitiendo que el código de la capa de presentación dependa de interfaces en la capa de dominio.

app/src/main/java/com/github/comismoy/pruebatecnicawomandroid/
│
├── data                       # Capa de datos
│   ├── core                   # Utilidades comunes para la capa de datos
│   ├── mappers                # Conversores entre modelos de datos y de dominio
│   ├── model                  # Modelos de datos
│   ├── remote                 # Conexiones a la API
│   └── repository             # Implementaciones de repositorios
│
├── domain                     # Capa de dominio
│   ├── model                  # Modelos de dominio
│   ├── repository             # Interfaces de repositorios
│   └── usecase                # Casos de uso de la aplicación
│
├── ui                         # Capa de presentación
│   ├── core                   # Utilidades y navegación
│   │   ├── navigation         # Configuración de navegación
│   │   └── utils              # Utilidades como constantes de UI
│   ├── home                   # Pantalla de inicio con lista de razas
│   ├── details                # Pantalla de detalles con imágenes de cada raza
│   └── theme                  # Definiciones de temas para la interfaz de usuario
│
├── App.kt                     # Clase de aplicación principal
└── MainActivity.kt            # Actividad principal

Cómo Ejecutar el Proyecto

Prerrequisitos

	•	Android Studio Bumblebee o superior.
	•	Kotlin 1.9.0 o superior.

Instalación

   1. Clona el repositorio:
      git clone https://github.com/tuusuario/dog-breeds-app.git
   2. Abre el proyecto en Android Studio.
   3. Sincroniza el proyecto para descargar las dependencias.
   4. Ejecuta la aplicación en un emulador o dispositivo físico con Android 5.0 (API nivel 21) o superior.

Pruebas Unitarias

El proyecto incluye pruebas unitarias usando JUnit y Mockito para asegurar que los ViewModels y UseCases funcionen correctamente. Las pruebas están ubicadas en el directorio app/src/test/java/com/github/comismoy/pruebatecnicawomandroid/.

Ejecuta las pruebas desde Android Studio usando la opción de Run All Tests o mediante la línea de comandos con el siguiente comando:
./gradlew test

Contribuciones

Las contribuciones son bienvenidas. Para contribuir, realiza un fork del repositorio y crea una solicitud de extracción con tus cambios.
