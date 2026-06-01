# web-e2e-automation

Automatización E2E sobre SauceDemo usando Serenity BDD con patrón Screenplay y Cucumber.

## Stack
- Java 17 / Gradle 7.6.4
- Serenity BDD 3.3.4 + Screenplay + Cucumber 7 + JUnit 4
- Sitio: https://www.saucedemo.com

## Capas del patrón Screenplay
- `ui/` — locators como constantes estáticas (Target), agrupados por página
- `tareas/` — Tasks: acciones del actor en términos de negocio
- `preguntas/` — Questions: lo que se verifica después de una acción
- `pasos/` — StepDefinitions: puente entre Gherkin y las Tasks/Questions
- `ejecutores/` — TestRunner JUnit 4

## Idioma
- Código (clases, métodos, variables): inglés, sin tildes
- Comentarios: español, solo donde el contexto no sea obvio
- Features Gherkin: español (# language: es)
- Documentación y README: español

## Buenas prácticas obligatorias
- Una sola responsabilidad por Task y por método
- Locators como constantes estáticas en la capa UI; nunca sueltos en steps o tasks
- Sincronización con WaitUntil de Serenity; Thread.sleep solo para la pausa de ritmo del demo
- Validaciones con actor.should(seeThat(...))
- Las Tasks no conocen Gherkin; los Steps no conocen locators; las capas no se mezclan

## Lo que no debe aparecer en ningún archivo
- Emojis
- Comentarios en cada línea de código
- Frases de plantilla: "aquí implementamos", "este método se encarga de", "a continuación"
- Bloques decorativos de === o ///
- TODOs, código muerto, imports sin usar
- Strings mágicos sueltos (credenciales y URLs van en constantes o serenity.conf)

## Commits
- Mensajes en español, incrementales y descriptivos
- Sin un commit gigante con todo el código junto

## Modo headless
- Demo local (navegador visible): headless.mode = false en serenity.conf
- Codespaces o CI (sin pantalla): pasar -Dheadless.mode=true al ejecutar
