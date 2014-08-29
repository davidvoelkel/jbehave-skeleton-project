

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TaschenRechnerStepDefinitions {

	private Taschenrechner taschenrechner = new Taschenrechner();
	
	@Given("die Zahlen $ersteZahl und $zweiteZahl sind eingegeben")
	public void zahlenEingeben(int ersteZahl, int zweiteZahl) {
		taschenrechner.setErsteZahl(ersteZahl);
		taschenrechner.setZweiteZahl(zweiteZahl);
	}
	
	@When("die Operation '$operation' betaetigt wird")
	public void operation(String operation) {
		taschenrechner.setOperation(operation);
	}

	@Then("ist das Ergebnis $ergebnis")
	public void ergebnis(int ergebnis) {
		assertThat(taschenrechner.berechne(), is(equalTo(ergebnis)));
	}
	
}