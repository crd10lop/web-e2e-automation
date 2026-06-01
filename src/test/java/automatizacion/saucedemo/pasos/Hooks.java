package automatizacion.saucedemo.pasos;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actors.OnStage;

public class Hooks {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }
}
