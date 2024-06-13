[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/PK07u-72)
# Ingeniería de Sistemas - Trabajo práctico "Funciones"

## Introducción

Actualmente se encuentra trabajando en la empresa "EduKids". Como su nombre lo indica, esta empresa se dedica a realizar
software educativo para niños. Dentro de la empresa, usted trabaja en un proyecto de enseñanza matemática. El mismo
busca plantear problemas matemáticos a los alumnos.

Como primer paso del proyecto se decide trabajar en un motor matemático simple, que permita plantear funciones y
resolverlas. Dichas funciones soportarán ciertas operaciones utilizadas durante el proceso educativo, suma, resta,
multiplicación, division, potencia, raíz (solo cuadrada, por el momento) y módulo. A su vez, deberá soportar la mayor
cantidad de números reales posibles.

Las funciones podrán estar compuestas tanto por números y operaciones, así como por variables. Las variables estarán
identificadas por una letra o una palabra. Esto permitirá que los profesores puedan cargar funciones parameterizables,
así como poder plantear problemas en los que los alumnos deban reemplazar dichas variables.

Como parte de ese proyecto será necesario poder imprimir las ecuaciones guardadas en el motor, debido a que esto
permitirá que tanto el que las diseña como los alumnos puedan visualizarlas.

En el futuro, aquellos que diseñen los problemas contarán con un mecanismo que permitirá agregar las funciones al motor
escribiendo las mismas, pero considerando que la intención actual es obtener un prototipo lo más rápido posible por
ahora dicha funcionalidad solo podrá hacerse programáticamente.

La interfaz que verán tanto como los alumnos como los profesores solicitará los valores de todas las variables en la
función, por lo tanto es necesario contar con un mecanismo para obtener todas las variables basándose en una función.

## Consignas

1. Realice un diagrama de clases, describiendo la solución al problema.
2. Implemente la solución descripta, en el paquete `edu.austral.ingsis.math`.
3. Implemente los tests descriptos en el paquete `edu.austral.ingsis.math`.

## Notas

- Los diagramas deben estar en una carpeta `diagrams` en el root del proyecto.
- Los diagramas deben estar en formato PDF
- Los diagramas deben estar en archivos separados con nombres que permitan identificarlos.
- Las clases de test que contiene este repositorio describen casos como funciones escritas en una notación moderna. Su
  objetivo es describir el caso a probar, recuerde que no debe parsear ninguna sintaxis, sino generar su modelo
  programáticamente. 

