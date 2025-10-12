# Lenguaje de Programación II

## Autor
**Jose Carlos Chino Nina**

## Laboratorio 04: Cálculo de Integrales por el Método del Trapecio (con Hilos)

**URL:**  
No aplica (problema de práctica de clase)

---

### 📘 Descripción del problema

En este laboratorio se implementa el **método del trapecio** para calcular de forma aproximada la integral definida de una función constante.  
El programa está diseñado en **Java** y utiliza **hilos (threads)** para dividir el trabajo de cálculo entre varios núcleos del procesador, aprovechando al máximo los recursos del sistema.

El usuario ingresa los límites de integración, el número de subintervalos y el valor constante de la función a integrar.

---

### 🧮 Input

El programa solicita:

1. El valor constante de la función \( f(x) = c \).  
2. El límite inferior (**a**) de la integral.  
3. El límite superior (**b**) de la integral.  
4. El número de subintervalos (**n**).

---

### 🧾 Output

El resultado aproximado de la integral definida, calculado con el método del trapecio.

---

### 💻 Ejemplo de ejecución

 

  ```text
  === MÉTODO DEL TRAPECIO BÁSICO CON HILOS ===
Ingrese el valor constante f(x) = 2
Ingrese el límite inferior (a): 0
Ingrese el límite superior (b): 5
Ingrese el número de subintervalos (n): 1000
Usando 16 hilos...

Resultado aproximado de la integral: 10.000000

---

### ⚙️ Tecnología Utilizada

- **Visual Studio Code**
- **JDK (Java Development Kit)**
- **Git**
- **GitHub**

---

### 🚀 ¿Qué cosas resaltantes aprendí en este laboratorio?

- He aprendido a **implementar el método del trapecio** en Java para aproximar integrales definidas.  
- He practicado el uso de **hilos (threads)** para dividir el trabajo computacional.  
- He comprendido cómo mejorar el rendimiento de un programa mediante **paralelismo**.  
- He reforzado el uso de la clase **Scanner** para la lectura de datos desde consola.  
- He gestionado el código en un repositorio **Git** de forma local y remota.

---