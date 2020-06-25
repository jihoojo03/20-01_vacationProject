package graphicEditor_02;

import java.awt.Font;

public class Bold {
	private Font font;
	private int boldSize;
	
	Bold(){
		font = new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20);
		boldSize = 10;
	}
	
	public Font getFont() {
		return font;
	}


	public void setFont(Font font) {
		this.font = font;
	}


	public int getBoldSize() {
		return boldSize;
	}

	public void setBoldSize(int boldSize) {
		this.boldSize = boldSize;
	}

	public void changeBoldSize() {
		if(boldSize >= 30) boldSize = 2;
		else boldSize += 2;
	}
	
	public void showFont() {
		if(boldSize <= 10) font = new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 16);
		else if(boldSize <= 20) font = new Font("³ª´®¹Ù¸¥°íµñ", Font.PLAIN, 20);
		else font = new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 23);
	}
	
}
