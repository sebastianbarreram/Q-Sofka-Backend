# Visión General

Aplicación web de preguntas y respuestas donde se evalúan conocimientos teóricos por áreas de conocimientos, además de la recopilación de preguntas que permiten generar un banco alimentado por ciertos coaches.

## Objetivos

- Crear un aplicativo web usando programación reactiva y funcional para la recopilación de preguntas y repuestas; y a su vez calificar automáticamente evaluaciones teóricas. 
- Implementar una arquitectura apropiada utilizando los conceptos aprendidos durante el training que permitan aplicar buenas prácticas de programación.
- Emplear metodologías ágiles SCRUM planificando de forma efectiva la realización y finalización del proyecto.

## Despliegue

 https://qsofkabackend.herokuapp.com
 
 ## Autores

- [@sebastianbarreram](https://github.com/sebastianbarreram)
- [@mmaurogg](https://github.com/mmaurogg)
- [@mateog147](https://github.com/mateog147)
- [@millergallegof](https://github.com/millergallegof)
- [@Juan9507](https://github.com/Juan9507)
- [@duvanleal96](https://github.com/duvanleal96)
- [@felipemarin93](https://github.com/felipemarin93)
- [@OscarGabriel07](https://github.com/OscarGabriel07)

# Proyecto Base Implementando Clean Architecture

## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por último el inicio y configuración de la aplicación.

Lee el artículo [Clean Architecture — Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
genéricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

## Application

Este módulo es el más externo de la arquitectura, es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de use (UseCases) de forma automática, inyectando en éstos instancias concretas de las dependencias declaradas. Además inicia la aplicación (es el único módulo del proyecto donde encontraremos la función “public static void main(String[] args)”.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**
