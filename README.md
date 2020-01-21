## Microservicio calculadora

### Introducción
- Proyecto maven **Spring Boot** en su versión 2.2.3.RELEASE. Creado con Spring initializer en el IDE IntelliJ IDEA
- Se han añadido los siguientes módulos: **Spring Boot DevTools**, **Spring Web**, **Spring Boot Actuator**
- También se han añadido las librerías de **Swagger**
- Y por último, el **Tracer** proporcionado, se ha añadido mediante el comando:

mvn install:install-file -Dfile=C:\temporal\tracer\tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar
 
### Estructura
#### Controlador

- Localizado en el paquete: **com.ejercicio.calculadora.web.controller.CalculadoraController**
- Es de tipo **RestController**, y se accede a través del path: **"/api/v1/calculadora"**, definido en una clase **Constantes**.
- Acceso a los microservicios **suma** y **resta** de la calculadora. Los paths de los microservicios son **"/suma/"** y **"/resta/"** respectivamente, y también están definidos en **Constantes**.
- Cada microservicio ejecuta métodos de un **Service**, que son los que ejecutan la lógica de negocio, en este caso sumas y restas.
- En cada microservicio se validan las **PathVariables**. En este caso los operandos no pueden tener más de 10 dígitos en la parte entera y 5 en la decimal.
- En cada microservicio se definen etiquetas **swagger** para tener un acceso más amigable a través de una página html.

#### Servicio

- Interface localizado en el paquete: **com.ejercicio.calculadora.service.CalculadoraService**
- Implementación localizada en el paquete: **com.ejercicio.calculadora.service.impl.CalculadoraServiceImpl**
- Está compuesto de dos métodos: **suma** y **resta**.
- Cada método llama a un método privado único, que realiza la operación correspondiente dependiente del valor de la enumeración **Operacion**. De momento solo contiene los valores **SUMA** y **RESTA**, pero en un futuro se puede ampliar para que se realicen más operaciones.
- El **Tracer** proporcionado se utiliza en el cálculo de cada operación, sacando la misma información obtenida en la respuesta http del microservicio.
- El cálculo de las operaciones se formatean mediante un método estático de una clase **StringUtils**.   

#### Tests

- Se utiliza **JUnit 5**, ya incorporado en la versión de **Spring Boot**
- Se han creado 2 tipos de Tests: uno para probar el **Service** (**CalculadoraServiceTest**) y otro para probar el **Controller** (**CalculadoraControllerTest**).
- CalculadoraServiceTest: contiene 2 tests, uno para suma y otro para resta. Para evaluar los resultados se utilizan **Assertions**.
- CalculadoraControllerTest: contiene 2 tests, uno para suma y otro para resta. En este caso se utiliza Mockito para simular la conexión con el servidor, y la llamada al Service.  