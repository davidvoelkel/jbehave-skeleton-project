
public class Taschenrechner {

	private int ersteZahl;
	private int zweiteZahl;
	private String operation;

	public void setErsteZahl(int ersteZahl) {
		this.ersteZahl = ersteZahl;
	}

	public void setZweiteZahl(int zweiteZahl) {
		this.zweiteZahl = zweiteZahl;
	}

	public int berechne() {
		return istAddition() ? ersteZahl + zweiteZahl : ersteZahl - zweiteZahl;
	}

	private boolean istAddition() {
		return "+".equalsIgnoreCase(operation);
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
