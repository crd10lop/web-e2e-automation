package automatizacion.saucedemo.pasos;

import automatizacion.saucedemo.Constants;
import automatizacion.saucedemo.preguntas.CartItemCount;
import automatizacion.saucedemo.preguntas.ErrorMessage;
import automatizacion.saucedemo.tareas.AddProduct;
import automatizacion.saucedemo.tareas.Login;
import automatizacion.saucedemo.tareas.RemoveProduct;
import automatizacion.saucedemo.ui.InventoryPage;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {
    private Actor buyer;

    @Dado("que el comprador quiere acceder a la tienda")
    public void buyerWantsToAccessTheStore() {
        buyer = OnStage.theActorCalled("el comprador");
    }

    @Dado("que el comprador esta autenticado en la tienda")
    public void buyerIsAuthenticatedInTheStore() {
        buyer = OnStage.theActorCalled("el comprador");
        buyer.attemptsTo(Login.withCredentials(Constants.VALID_USER, Constants.VALID_PASSWORD));
    }

    @Cuando("ingresa con usuario {string} y contrasena {string}")
    public void logInWithCredentials(String username, String password) {
        buyer.attemptsTo(Login.withCredentials(username, password));
    }

    @Entonces("visualiza el catalogo de productos")
    public void seesTheProductCatalog() {
        buyer.should(seeThat(Text.of(InventoryPage.PAGE_TITLE), equalTo("Products")));
    }

    @Entonces("el sistema muestra el mensaje de error {string}")
    public void systemShowsErrorMessage(String expectedMessage) {
        buyer.should(seeThat(ErrorMessage.displayed(), containsString(expectedMessage)));
    }

    @Cuando("agrega el producto {string} al carrito")
    public void addsProductToCart(String product) {
        buyer.attemptsTo(AddProduct.withName(product));
    }

    @Entonces("el contador del carrito muestra {int}")
    public void cartCounterShows(int expectedCount) {
        buyer.should(seeThat(CartItemCount.current(), equalTo(expectedCount)));
    }

    @Y("tiene el producto {string} en el carrito")
    public void hasProductInCart(String product) {
        buyer.attemptsTo(AddProduct.withName(product));
    }

    @Cuando("elimina el producto {string} del carrito")
    public void removesProductFromCart(String product) {
        buyer.attemptsTo(RemoveProduct.withName(product));
    }

    @Entonces("el carrito queda sin productos")
    public void cartHasNoProducts() {
        buyer.should(seeThat(CartItemCount.current(), equalTo(0)));
    }
}
