# Documentacion del patron Screenplay

## Actor

El comprador representa a un usuario final de SauceDemo. En terminos de negocio modela quien navega la tienda, se autentica con credenciales, selecciona productos y gestiona el carrito de compras.

## Tasks

| Task | Descripcion de negocio |
|---|---|
| Login | Abre la tienda y autentica al comprador con usuario y contrasena |
| AddProduct | Localiza un producto en el catalogo y lo agrega al carrito |
| RemoveProduct | Localiza un producto en el carrito y lo elimina |
| PauseDemo | Introduce una pausa configurable para que el demo sea observable en pantalla |

## Interactions

Las interactions son las acciones elementales que componen las Tasks:

- Abrir navegador: `Open.url()` navega a la URL base de la tienda
- Ingresar texto: `Enter.theValue().into()` escribe en un campo del formulario
- Hacer clic: `Click.on()` activa un boton o enlace
- Pausar para demo: `Thread.sleep()` encapsulado en `PauseDemo`, solo para ritmo visual

## Questions

| Question | Tipo retorno | Descripcion |
|---|---|---|
| CartItemCount | Question\<Integer\> | Lee el numero del badge del carrito; retorna 0 si el badge no esta presente |
| ErrorMessage | Question\<String\> | Lee el texto del mensaje de error en la pagina de login |

## Escenarios

1. Ingreso exitoso: el comprador accede con credenciales validas y visualiza el catalogo de productos
2. Ingreso fallido: credenciales incorrectas producen el mensaje de error del sistema
3. Ingreso bloqueado: el sistema impide el acceso a un usuario restringido con mensaje especifico
4. Agregar producto al carrito: el badge del carrito refleja la cantidad correcta tras agregar un producto
5. Eliminar producto del carrito: el carrito queda vacio tras eliminar el unico producto

## Comandos de ejecucion

Local con navegador visible:

```
./gradlew clean test aggregate
```

Headless para Codespaces o CI:

```
./gradlew clean test aggregate -Dheadless.mode=true
```

## Datos de prueba

| Identificador | Valor | Uso en escenario |
|---|---|---|
| VALID_USER | standard_user | Ingreso exitoso y agregar/eliminar productos |
| VALID_PASSWORD | secret_sauce | Ingreso exitoso, usuario bloqueado |
| — | usuario_invalido | Ingreso fallido con credenciales incorrectas |
| — | contrasena_incorrecta | Ingreso fallido con credenciales incorrectas |
| — | locked_out_user | Ingreso bloqueado para usuario restringido |
