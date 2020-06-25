package graphicEditor_02;

import java.awt.Color;

import javax.swing.JColorChooser;

public class EdgeColor {
	private Color edgeColor;
	
	EdgeColor() {
		this.edgeColor = Color.BLACK;
	}
	
	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public void changeEdgeColor() {
		this.edgeColor = JColorChooser.showDialog(null, "Color Selector", edgeColor);
	}
	

}
