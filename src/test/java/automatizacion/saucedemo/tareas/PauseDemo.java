package automatizacion.saucedemo.tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

public class PauseDemo implements Performable {
    private final int milliseconds;

    private PauseDemo(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public static PauseDemo of(int milliseconds) {
        return new PauseDemo(milliseconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
