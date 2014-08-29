package calculator;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CalculatorStepDefinitions {

	private Calculator calculator = new Calculator();
	
	@Given("the numbers $firstNumber and $secondNumber")
	public void numbers(int firstNumber, int secondNumber) {
		calculator.setFirstNumber(firstNumber);
		calculator.setSecondNumber(secondNumber);
	}
	
	@When("the operation '$operation' is selected")
	public void operation(String operation) {
		calculator.setOperation(operation);
	}

	@Then("the result is $ergebnis")
	public void result(int result) {
		assertThat(calculator.calculate(), is(equalTo(result)));
	}
	
}