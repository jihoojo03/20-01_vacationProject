package graphicEditor_02;

import java.awt.Font;

public class Bold {
	private Font font;
	private int boldSize;
	
	Bold(){
		font = new Font("�����ٸ�����", Font.PLAIN, 20);
		boldSize = 6;
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
		if(boldSize >= 24) boldSize = 2;
		else boldSize += 2;
	}
	
	public void showFont() {
		if(boldSize <= 8) font = new Font("�����ٸ�����", Font.PLAIN, 16);
		else if(boldSize <= 16) font = new Font("�����ٸ�����", Font.PLAIN, 20);
		else font = new Font("�����ٸ�����", Font.BOLD, 23);
	}
	
}
