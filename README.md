---
# web-e2e-automation

Automatización E2E de la tienda SauceDemo usando Serenity BDD con patrón Screenplay y Cucumber.

## Tecnologías
- Java 17 / Gradle 7.6.4
- Serenity BDD 3.3.4 + patrón Screenplay
- Cucumber 7 / JUnit 4
- Selenium 4 / WebDriverManager 5.6.3

## Escenarios automatizados
1. Ingreso exitoso con credenciales válidas
2. Ingreso fallido con credenciales incorrectas
3. Ingreso bloqueado para usuario restringido
4. Agregar productos al carrito — Scenario Outline con tabla de datos
5. Eliminar producto y verificar que el carrito queda vacío

## Estructura del proyecto
```

src/test/java/automatizacion/saucedemo/
├── ui/          Locators como constantes estáticas (Target)
├── tareas/      Tasks: acciones del actor en términos de negocio
├── preguntas/   Questions: validaciones sobre el estado del sistema
├── pasos/       StepDefinitions y Hooks
└── ejecutores/  TestRunner JUnit 4

```
## Cómo ejecutar

Requisitos: Java 17, Google Chrome.

```bash
git clone https://github.com/crd10lop/web-e2e-automation.git
cd web-e2e-automation

# Demo local con navegador visible:
./gradlew clean test aggregate --info

# Headless para Codespaces o CI:
./gradlew clean test aggregate --info -Dheadless.mode=true
```

## Reporte
Después de ejecutar, abrir:
```

target/site/serenity/index.html

```
Reporte publicado en: https://crd10lop.github.io/web-e2e-automation/

## Documentación del patrón
Ver [docs/screenplay.md](docs/screenplay.md)
---
