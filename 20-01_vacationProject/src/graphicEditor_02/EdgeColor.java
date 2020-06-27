package graphicEditor_02;

import java.awt.Color;

import javax.swing.JColorChooser;

public class EdgeColor {
	private static Color edgeColor;
	
	EdgeColor() {
		EdgeColor.edgeColor = Color.BLACK;
	}
	
	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		EdgeColor.edgeColor = edgeColor;
	}

	public void changeEdgeColor() {
		EdgeColor.edgeColor = JColorChooser.showDialog(null, "Color Selector", edgeColor);
	}
	

}
