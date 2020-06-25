package graphicEditor_02;

import java.awt.Color;

import javax.swing.JColorChooser;

public class FillColor {
	private Color fillColor;
	
	FillColor() {
		this.fillColor = Color.BLACK;
	}
	
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public void changeFillColor() {
		this.fillColor = JColorChooser.showDialog(null, "Color Selector", fillColor);
	}

}
