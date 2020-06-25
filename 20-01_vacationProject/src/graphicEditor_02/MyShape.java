package graphicEditor_02;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.image.*;

class MyShape {
	Shape shape;
	
	int x0, y0;			// translation
	boolean selected;   // true whin this image is selected

	Color color;  		// RGB color
	
	MyShape(int x, int y) {
		x0 = x;
		y0 = y;
		selected = false;
	}
}