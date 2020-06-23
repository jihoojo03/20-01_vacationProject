package calculator_01;

public class Calculate {
	private String currentValue;
	private float intermediateResult;
	private float calculationResult;
	private boolean intermediateStored;
	private boolean symbolClicked;
	private boolean plusClicked;
	private boolean minusClicked;
	private boolean multipleClicked;
	private boolean divideClicked;
	private boolean dotClicked;
	
	Calculate(){
		currentValue = "";
		intermediateResult = 0;
		calculationResult = 0;
		intermediateStored = false;
		symbolClicked = false;
		plusClicked = false;
		minusClicked = false;
		multipleClicked = false;
		divideClicked = false;
		dotClicked = false;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	
	public float getIntermediateResult() {
		return intermediateResult;
	}

	public void setIntermediateResult(float intermediateResult) {
		this.intermediateResult = intermediateResult;
	}

	public float getCalculationResult() {
		return calculationResult;
	}

	public void setCalculationResult(int calculationResult) {
		this.calculationResult = calculationResult;
	}
	
	public boolean isIntermediateStored() {
		return intermediateStored;
	}

	public void setIntermediateStored(boolean intermediateStored) {
		this.intermediateStored = intermediateStored;
	}

	public boolean isSymbolClicked() {
		return symbolClicked;
	}
	
	public void setSymbolClicked(boolean symbolClicked) {
		this.symbolClicked = symbolClicked;
	}
	
	public boolean isPlusClicked() {
		return plusClicked;
	}

	public void setPlusClicked(boolean plusClicked) {
		this.plusClicked = plusClicked;
	}

	public boolean isMinusClicked() {
		return minusClicked;
	}

	public void setMinusClicked(boolean minusClicked) {
		this.minusClicked = minusClicked;
	}

	public boolean isMultipleClicked() {
		return multipleClicked;
	}

	public void setMultipleClicked(boolean multipleClicked) {
		this.multipleClicked = multipleClicked;
	}

	public boolean isDivideClicked() {
		return divideClicked;
	}

	public void setDivideClicked(boolean divideClicked) {
		this.divideClicked = divideClicked;
	}

	public boolean isDotClicked() {
		return dotClicked;
	}

	public void setDotClicked(boolean dotClicked) {
		this.dotClicked = dotClicked;
	}

	public void plusCurrentValue(String currentValue) {
		if(symbolClicked) {
			setCurrentValue(currentValue);
			symbolClicked = false;
		}
		else {
			if(this.currentValue.equals("0") && currentValue.equals(".")) this.currentValue += currentValue;
			else if(this.currentValue.equals("0")) setCurrentValue(currentValue);
			else this.currentValue += currentValue;
		}
	}

	public String changePlusMinus() {
		if(!currentValue.equals("")) {
			float num = Float.parseFloat(currentValue);
			num = (-num);
			return Float.toString(num);
		}
		else return "";
	}
	
	public String deleteValue() {
		if(!currentValue.equals("")) {
			return currentValue.substring(0, currentValue.length()-1);
		}
		else return "";
	}
	
	public String calculateAnswer() {
		if(plusClicked) {
			calculationResult = intermediateResult + Float.parseFloat(currentValue);
			intermediateResult = calculationResult;
			return fmt(calculationResult);
		}
		else if(minusClicked) {
			calculationResult = intermediateResult - Float.parseFloat(currentValue);
			intermediateResult = calculationResult;
			return fmt(calculationResult);
		}
		else if(multipleClicked) {
			calculationResult = intermediateResult * Float.parseFloat(currentValue);
			intermediateResult = calculationResult;
			return fmt(calculationResult);
		}
		else if(divideClicked) {
			calculationResult = intermediateResult / Float.parseFloat(currentValue);
			intermediateResult = calculationResult;
			return fmt(calculationResult);
		}
		else {
			return currentValue;
		}
		
	}
	
	public static String fmt(float d) {
		if(d == (long) d)
			return String.format("%d", (long)d);
		else
			return String.format("%s", d);
	}

}
