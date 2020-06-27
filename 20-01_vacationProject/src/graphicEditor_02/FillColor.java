package graphicEditor_02;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JColorChooser;

public class FillColor {
	private static boolean isFill;
	private static String onOff;
	private static Font font;
	private static Color fillColor;
	
	FillColor() {
		FillColor.isFill = false;
		FillColor.onOff = "Off";
		FillColor.font = new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 18);
		FillColor.fillColor = Color.WHITE;
	}
	
	public static Color getFillColor() {
		return fillColor;
	}



	public static void setFillColor(Color fillColor) {
		FillColor.fillColor = fillColor;
	}



	public static boolean isFill() {
		return isFill;
	}

	public static void setFill(boolean isFill) {
		FillColor.isFill = isFill;
	}
	
	
	public static Font getFont() {
		return font;
	}

	public static void setFont(Font font) {
		FillColor.font = font;
	}
	

	public static String getOnOff() {
		return onOff;
	}

	public static void setOnOff(String onOff) {
		FillColor.onOff = onOff;
	}
	
	public static void changeOnOff() {
		if(onOff.equals("Off")) onOff = "On";
		else onOff = "Off";
	}

	public static void changeIsFill(){
		if(isFill) isFill = false;
		else isFill = true;
	}
	
	public static void changeFillColor() {
		FillColor.fillColor = JColorChooser.showDialog(null, "Color Selector", fillColor);
	}
	
	
	
	
	

}
