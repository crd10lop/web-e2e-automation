package automatizacion.saucedemo.tareas;

import automatizacion.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProduct implements Task {
    private final String productName;

    private AddProduct(String productName) {
        this.productName = productName;
    }

    public static AddProduct withName(String productName) {
        return new AddProduct(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(InventoryPage.addToCartButton(productName), isVisible()).forNoMoreThan(10).seconds(),
            PauseDemo.of(500),
            Click.on(InventoryPage.addToCartButton(productName)),
            PauseDemo.of(800)
        );
    }
}
