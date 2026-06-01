---
# Guion de presentación — Automatización E2E SauceDemo

## Estructura sugerida (10-15 minutos)

### 1. Introducción (1-2 min)
- "Automatizamos la tienda SauceDemo con Serenity BDD y el patrón Screenplay"
- Stack: Java 17, Gradle, Cucumber, JUnit 4
- "Screenplay organiza las pruebas en tres capas: Actor, Tasks y Questions"

### 2. Mostrar la estructura del código (2-3 min)
- Abrir el repositorio en GitHub
- Recorrer las carpetas: ui/, tareas/, preguntas/, pasos/, ejecutores/
- "Las tareas están en términos de negocio: Login, AddProduct, RemoveProduct"
- "Los locators son constantes estáticas en la capa UI, nunca dispersos en el código"
- "Los Steps no conocen locators; las Tasks no conocen Gherkin"

### 3. Mostrar los escenarios Gherkin (1-2 min)
- Abrir gestion_tienda.feature
- Leer el escenario de login exitoso: Dado / Cuando / Entonces
- Mostrar el Esquema del escenario con la tabla de Ejemplos
- "El lenguaje de negocio en español, el código en inglés"

### 4. Demo en vivo (4-5 min)
Opción A - Local:
  ./gradlew clean test aggregate --info
  El Chrome abre, se ven las acciones con pausa entre cada paso.
  "La pausa es intencional para observar cada acción del test"

Opción B - Desde el trabajo (sin PC local):
  1. Reproducir el video de la corrida grabada localmente
  2. Mostrar el reporte en https://crd10lop.github.io/web-e2e-automation/
  3. Mostrar el código en GitHub / Codespace

### 5. Mostrar el reporte Serenity (2-3 min)
- Abrir target/site/serenity/index.html (o el link de Pages)
- Señalar el porcentaje de escenarios en verde
- Entrar a un escenario y mostrar los screenshots paso a paso
- "Cada paso tiene captura de pantalla, esta es la evidencia de la ejecución"

### 6. Cierre (1 min)
- Esquema del escenario con tabla = uso de datos parametrizados (creatividad)
- PauseDemo separado = delay cumple el requisito sin mezclar con la sincronización
- "El proyecto está en GitHub con reporte publicado en Pages"

## Puntos clave si el profesor pregunta
- Screenplay vs Page Objects: mayor separación de capas, menor acoplamiento
- WaitUntil en vez de Thread.sleep: la sincronización no debe depender del tiempo
- PauseDemo separado: el delay del demo es ortogonal a la lógica de sincronización
- WebDriverManager 5.6.3 (no 5.4.1): Chrome 115+ cambió el endpoint de descarga de drivers
- headless.mode = false: para ver la ejecución en el demo; configurable para CI/Codespaces

## Modo fallback desde el trabajo
1. Reporte: https://crd10lop.github.io/web-e2e-automation/
2. Código: https://github.com/crd10lop/web-e2e-automation
3. Codespace: botón Code → Codespaces → New Codespace
4. En el Codespace: ./gradlew clean test aggregate --info -Dheadless.mode=true
---