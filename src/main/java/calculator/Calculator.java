package calculator;

public class Calculator {

	private int firstNumber;
	private int secondNumber;
	private String operation;

	public void setFirstNumber(int ersteZahl) {
		this.firstNumber = ersteZahl;
	}

	public void setSecondNumber(int zweiteZahl) {
		this.secondNumber = zweiteZahl;
	}

	public int calculate() {
		return isAddition() ? firstNumber + secondNumber : firstNumber - secondNumber;
	}

	private boolean isAddition() {
		return "+".equalsIgnoreCase(operation);
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
