# language: es
Caracteristica: Gestion de compras en SauceDemo
  Como comprador
  Quiero gestionar mis productos en el carrito
  Para completar mis compras correctamente

  Escenario: Ingreso exitoso con credenciales validas
    Dado que el comprador quiere acceder a la tienda
    Cuando ingresa con usuario "standard_user" y contrasena "secret_sauce"
    Entonces visualiza el catalogo de productos

  Escenario: Ingreso fallido con credenciales incorrectas
    Dado que el comprador quiere acceder a la tienda
    Cuando ingresa con usuario "usuario_invalido" y contrasena "contrasena_incorrecta"
    Entonces el sistema muestra el mensaje de error "Username and password do not match any user in this service"

  Escenario: Ingreso bloqueado para usuario restringido
    Dado que el comprador quiere acceder a la tienda
    Cuando ingresa con usuario "locked_out_user" y contrasena "secret_sauce"
    Entonces el sistema muestra el mensaje de error "Sorry, this user has been locked out."

  Esquema del escenario: El comprador agrega un producto al carrito
    Dado que el comprador esta autenticado en la tienda
    Cuando agrega el producto "<producto>" al carrito
    Entonces el contador del carrito muestra <cantidad>

    Ejemplos:
      | producto              | cantidad |
      | Sauce Labs Backpack   | 1        |
      | Sauce Labs Bike Light | 1        |

  Escenario: El comprador elimina un producto del carrito
    Dado que el comprador esta autenticado en la tienda
    Y tiene el producto "Sauce Labs Backpack" en el carrito
    Cuando elimina el producto "Sauce Labs Backpack" del carrito
    Entonces el carrito queda sin productos
