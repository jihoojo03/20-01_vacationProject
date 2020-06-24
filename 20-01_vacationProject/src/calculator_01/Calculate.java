package calculator_01;

import java.math.*;
import java.text.DecimalFormat;

public class Calculate {
	private String currentEquation;
	private String currentValue;
	private String beforeCurrentValue;
	private double intermediateResult;
	private double calculationResult;
	private boolean intermediateStored;
	private boolean symbolClicked;
	private boolean plusClicked;
	private boolean minusClicked;
	private boolean multipleClicked;
	private boolean divideClicked;
	private boolean equalClicked;
	
	Calculate(){
		currentEquation = "";
		currentValue = "0";
		beforeCurrentValue = "";
		intermediateResult = 0;
		calculationResult = 0;
		intermediateStored = false;
		symbolClicked = false;
		plusClicked = false;
		minusClicked = false;
		multipleClicked = false;
		divideClicked = false;
		equalClicked = false;
	}


	public String getCurrentEquation() {
		return currentEquation;
	}

	public void setCurrentEquation(String currentEquation) {
		this.currentEquation = currentEquation;
	}

	public String getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(String currentValue) {
		this.currentValue = currentValue;
	}
	
	public String getBeforeCurrentValue() {
		return beforeCurrentValue;
	}

	public void setBeforeCurrentValue(String beforeCurrentValue) {
		this.beforeCurrentValue = beforeCurrentValue;
	}

	public double getIntermediateResult() {
		return intermediateResult;
	}

	public void setIntermediateResult(double intermediateResult) {
		this.intermediateResult = intermediateResult;
	}

	public double getCalculationResult() {
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

	public boolean isEqualClicked() {
		return equalClicked;
	}

	public void setEqualClicked(boolean equalClicked) {
		this.equalClicked = equalClicked;
	}
	
	public void plusCurrentEquation(String currentEquation, String symbol) {
		this.currentEquation += " ";
		this.currentEquation += currentEquation;
		this.currentEquation += " ";
		this.currentEquation += symbol;
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

	public String changePlusMinus(String inputNum) {
		if(!inputNum.equals("")) {
			double num = Float.parseFloat(inputNum);
			return fmt(-num);
		}
		else return "";
	}
	
	public String deleteValue() {
		if(!currentValue.equals("0")) {
			return currentValue.substring(0, currentValue.length()-1);
		}
		else return "";
	}
	
	public String deleteEquation() {
		if(!currentEquation.equals("")) {
			return currentValue.substring(0, currentValue.length()-1);
		}
		else return "";
	}
	
	public String calculateAnswer() {
		DecimalFormat fm = new DecimalFormat("#.########");
		
		if(plusClicked) {
			BigDecimal a = BigDecimal.valueOf(intermediateResult);
			BigDecimal b = BigDecimal.valueOf(Float.parseFloat(currentValue));
			BigDecimal c = a.add(b, MathContext.DECIMAL32);
			calculationResult = (c.setScale(12, RoundingMode.HALF_UP)).doubleValue();
			intermediateResult = calculationResult;
			return fm.format(calculationResult);
		}
		else if(minusClicked) {
			BigDecimal a = BigDecimal.valueOf(intermediateResult);
			BigDecimal b = BigDecimal.valueOf(Float.parseFloat(currentValue));
			BigDecimal c = a.subtract(b, MathContext.DECIMAL32);
			calculationResult = (c.setScale(12, RoundingMode.HALF_UP)).doubleValue();
			intermediateResult = calculationResult;
			return fm.format(calculationResult);
		}
		else if(multipleClicked) {
			BigDecimal a = BigDecimal.valueOf(intermediateResult);
			BigDecimal b = BigDecimal.valueOf(Float.parseFloat(currentValue));
			BigDecimal c = a.multiply(b, MathContext.DECIMAL32);
			calculationResult = (c.setScale(12, RoundingMode.HALF_UP)).doubleValue();
			intermediateResult = calculationResult;
			return fm.format(calculationResult);
		}
		else if(divideClicked) {
			BigDecimal a = BigDecimal.valueOf(intermediateResult);
			BigDecimal b = BigDecimal.valueOf(Float.parseFloat(currentValue));
			BigDecimal c = a.divide(b, MathContext.DECIMAL32);
			calculationResult = (c.setScale(12, RoundingMode.HALF_UP)).doubleValue();
			intermediateResult = calculationResult;
			return fm.format(calculationResult);
		}
		else {
			return currentValue;
		}
		
	}
	
	public String lastSymbol() {
		if(plusClicked) return "+";
		else if(minusClicked) return "¡ª";
		else if(multipleClicked) return "¡¿";
		else if(divideClicked) return "¡À";
		else return "";
	}
	

	public String fmt(double d) {
		if(d == (long) d)
			return String.format("%d", (long)d);
		else
			return String.format("%s", d);
	}

}
