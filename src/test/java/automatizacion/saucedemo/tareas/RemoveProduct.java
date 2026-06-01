package automatizacion.saucedemo.tareas;

import automatizacion.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RemoveProduct implements Task {
    private final String productName;

    private RemoveProduct(String productName) {
        this.productName = productName;
    }

    public static RemoveProduct withName(String productName) {
        return new RemoveProduct(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(InventoryPage.removeFromCartButton(productName), isVisible()).forNoMoreThan(10).seconds(),
            PauseDemo.of(500),
            Click.on(InventoryPage.removeFromCartButton(productName)),
            PauseDemo.of(800)
        );
    }
}
