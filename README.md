# **Gestión de Coches del Concesionario**

## **Contexto**

Un concesionario de automóviles desea desarrollar un sistema para gestionar los vehículos que comercializa. Actualmente, venden tres tipos principales de coches: **Sedán, SUV y Deportivo**, cada uno con características y finalidades distintas.

## 👀 **Objetivo**

Implementa una aplicación en **Java** que permita **registrar distintos tipos de coches** y **consultar su información detallada**.

No es necesario utilizar una base de datos ni implementar una interfaz interactiva por consola. El objetivo es centrarse en un **diseño orientado a objetos**, aplicando correctamente conceptos como **encapsulación**, **abstracción**, **herencia**, **polimorfismo**, uso adecuado de tipos de datos y empleo de **streams** cuando resulte apropiado.

El funcionamiento del sistema puede demostrarse desde el método `main()` o mediante **pruebas unitarias** que validen la lógica implementada.

---

## **Requisitos del Sistema**

### 📌 1 - **Registro de coches**

El sistema debe permitir **registrar** diferentes tipos de coches con los siguientes atributos generales:

- **Marca** (por ejemplo, Toyota, BMW, Ford).
- **Modelo** del coche.
- **Tipo de combustible**: gasolina, diésel o eléctrico.
- **Año de fabricación**.

**Cada tipo de coche debe tener atributos adicionales específicos que lo caractericen:**

| **Tipo de Coche** | **Atributos Específicos** |
| --- | --- |
| **Sedán** | Capacidad del maletero (litros). |
| **SUV** | Tipo de tracción (4x2, 4x4). |
| **Deportivo** | Velocidad máxima (km/h). |

---

### 📌 2 - Descripción del coche

Cada tipo de coche debe implementar su propia descripción o propósito principal de uso.

Debe definirse un **método que genere una descripción atractiva y personalizada**, utilizando los atributos del coche para resaltar sus puntos fuertes. Por ejemplo:

- 🚗 **Sedán**
    
    “Con su espacioso maletero de `X` litros y un diseño pensado para el confort, el `marca modelo` es el compañero ideal para viajes familiares y trayectos diarios con estilo.”
    
- 🚙 **SUV**
    
    “El `marca modelo`, con tracción `4x2`/`4x4`, es un SUV que no teme salir del asfalto. Perfecto para aventuras al aire libre, terrenos difíciles y escapadas de fin de semana con potencia y seguridad.”
    
- 🏎️ **Deportivo**
    
    “Diseñado para quienes viven la carretera intensamente: el `marca modelo` alcanza una velocidad máxima de `X km/h`, combinando elegancia y rendimiento en cada curva.”
    

> 💡 Las descripciones deben generarse dinámicamente a partir de los atributos del objeto: marca, modelo, año, tipo de combustible y el atributo específico del tipo de coche.
> 

---

### 📌 3 - Consultas y reportes

De los coches registrados, el sistema debe permitir realizar las siguientes consultas sobre los mismos:

1. **Listar todos los coches registrados**, para mostrar su información relevante.
2. **Filtrar los coches fabricados después de un año específico**, proporcionado como parámetro.
3. **Filtrar los coches por tipo y combustible**, devolviendo únicamente aquellos que coincidan con:
    - Un **tipo de coche** concreto (Sedán, SUV o Deportivo).
    - Un **tipo de combustible** concreto (gasolina, diésel o eléctrico).
    

💡 Demuestra tus conocimientos en streams de Java cuando resulte adecuado.

---

### 📌 4 - Vehículos exportables

Algunos vehículos están disponibles para la venta internacional y requieren un proceso de exportación especial. Los coches **deportivos** de este concesionario son unos de ellos.

Para generar el documento de la exportación usaremos una clase como:

```java
public class ExportReportPrinter {
    public void printReport(Exportable exportable) {
        System.out.println("Documento de exportación generado:");
        System.out.println(exportable.getExportInfo());
    }
}
```

Los vehículos exportables deben proporcionar la información necesaria para que `ExportReportPrinter` pueda generar el documento de exportación.

- **Haz que nuestros coches deportivos sean compatibles para la exportación.**

💡 Recuerda que otros vehículos como motocicletas y camiones probablemente también deberán ser compatibles con la exportación.# Concesionario-De-Coches
