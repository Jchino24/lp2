# Laboratorio 04: Cálculo de Integrales por el Método del Trapecio (con Hilos)

**Curso:** Lenguaje de Programación II  
**Autor:** Jose Carlos Chino Nina  
**URL:** No aplica (problema de práctica de clase)

---

## Descripción del problema

En este laboratorio se implementa el método del trapecio para calcular de forma aproximada la integral definida de una función matemática.

El programa está desarrollado en Java y utiliza hilos (threads) para dividir el trabajo de cálculo entre varios núcleos del procesador, mejorando el rendimiento y aprovechando el paralelismo del sistema.

A diferencia de la versión inicial (que integraba solo funciones constantes), esta versión permite ingresar cualquier función algebraica, por ejemplo:

2xx + 5
3*x + 2
Math.sin(x)

---

## Entrada (Input)

El programa solicita los siguientes datos al usuario:

1. Función `f(x)` (por defecto: `2*x*x + 5`)
2. Límite inferior (a)
3. Límite superior (b)
4. Número de subintervalos (n)
5. (Opcional) Cantidad de decimales para el resultado final

---

## Salida (Output)

El programa muestra:

- Los valores parciales calculados por los hilos (sub-áreas representadas entre corchetes `[ ... ]`)
- El resultado aproximado de la integral definida
- El número de trapecios utilizados
- Un mensaje final indicando el área ideal encontrada

---

## Ejemplo de ejecución

=== MÉTODO DEL TRAPECIO CON HILOS ===

Ingrese función (ej. 2xx + 5): 2xx + 5

Límite inferior (a): 2

Límite superior (b): 10

Número de subintervalos (n): 100

Usando 8 hilos...

[250.00][300.00][320.00][350.00]...[400.00]

Se encontró el área ideal con 100 trapecios a 2 decimales = 713.55

Gracias.

---

## Tecnología Utilizada

- Java (JDK 17+)
- Multithreading (Thread API)
- ScriptEngine (evaluación dinámica de funciones)
- Visual Studio Code
- Git / GitHub

---

## Aprendizajes Clave

Durante este laboratorio se logró:

- Implementar el método del trapecio para aproximar integrales definidas.  
- Utilizar hilos (threads) para paralelizar el proceso de integración.  
- Comprender el uso del ScriptEngine de Java para evaluar expresiones algebraicas en tiempo de ejecución.  
- Optimizar el desempeño del cálculo usando varios núcleos del CPU.  
- Mejorar la salida del programa con un formato numérico controlado y legible.  
- Reforzar la práctica con herramientas de control de versiones como Git y GitHub.

---
