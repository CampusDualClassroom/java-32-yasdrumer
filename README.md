# Ejercicio 32 - Escritura de ficheros
## Descripción del ejercicio
Este ejercicio consiste en crear un método que nos permita escribir en un fichero las cadenas de texto que introduzca 
el usuario por consola.  
### Objetivos
* Modificar el método ``generateStringToSave(String string)`` para que permita, en función de si recibe una cadena de texto o un nulo, devolver dicha cadena o llamar al método ``generateUserInputToSave()`` para generar la cadena de texto y devolverla, respectivamente.
* Modificar el método ``printToFile(String string)`` para que escriba en el fichero `src/main/resources/data.txt` la cadena que se le pasa por parámetro.
* Modificar el método ``main()`` para conseguir la funcionalidad descrita en la descripción.
### Requisitos
* No se pueden modificar en absoluto las clases de test.
### Test

```
  mvn test
```