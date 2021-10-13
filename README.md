# Connect4

El objetivo de la práctica es la aplicación de los contenidos teóricos presentados en la asignatura: diseño, diseño modular y diseño orientado a objetos
Para ello, se desarrollará el juego [Conecta4](https://www.youtube.com/watch?v=JBSbiilzg9U&t=28s), de la misma forma en que se presentaron los ejemplos del juego [TicTacToe](https://github.com/USantaTecla-project-ticTacToe)

![](Connect_4_Board_and_Box.jpg)
![](Connect_Four.gif)

## Analisis y Diseño

La práctica se ha ido haciendo en fases, según íbamos viendo los conceptos en las differentes clases teóricas

### Fase 1: Modelo de dominio

Creando algunas de las clases del Modelo de Dominio y añadiendo lógica de negocio directamente en ellas para resolver el problema, funciona pero no es parece muy mantenible por nadie en un futuro o por mi mismo en un futuro cercano. En este versión tengo el jugador IA que juega solo, para testear mas fácil.
Algunas mejoras basadas en las revisiones del código de compañeros durante las clases: Una clase _main_ limpiaq ue solo ejecuta, constructores sin parametros innecesarios, etc 

### Fase 2: Add Views

Añadimos una primera capa de separación: modelos y vistas, empieza a coger forma, dejamos los modelos "limpios" y movemos la lógica de negocio a las Vistas, en el proceso limpiamos alguna clase que ha perdido _significado_ (Turno)

### Fase 3: Add Controllers

Añadimos controladores, clases que manajan la lógica de negocio y hacen de intermediario entre vista y modelo.

    Model --- Controller --- View

Me es mucho mas cómodo este paradigma, pues llevo muchos años usando MVC de Spring (Struts también) para casi todo en mi trabajo. 

### 4: Add Visitor pattern for Controllers, AI Player
Por último añadimos el Visitor (double dispatching) para evitar el abuso de _instanceOf_ y separar el algoritmo del juego en si de los objectos en los que opera. También introduzco de nuevo el jugador IA, que había dejado de funcionar en versiones previas, para testear mas rápido y como ejemplo de polimorfismo. También añado otra version del algoritmo para comprar el ganador que recibe el color de la ficha (en lugar de comprobar todo el tablero), me gustaría mejorarlo y meter la comprobación de la línea en un bucle en lugar de varios i+1, i+2 etc

A nivel de testing he añadido unos unit tests usando [ArchUnit](https://www.archunit.org/), para validar que las capas de la arquitectura son correctas: Views no ven a los Modelos, Views solo usan Controllers, todas las Views estan en el paquete Views, etc 
Muy util para trabajar en equipos grandes y que todos hablemos el mismo _idioma_ de diseño.

Me ha gustado mucho ir viendo en clase y personalmente como evoluacionaba la aplicación, funcionando en cada fase pero siendo mejorada a nivel diseño, mantenibilidad y legibilidad. Hoy en día reviso más código del que escribo y es útil ver el proceso desde el inicio.
