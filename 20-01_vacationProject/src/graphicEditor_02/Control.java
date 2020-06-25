package graphicEditor_02;

public class Control {
	private int currentStatus;
	
//	MakeLine makeLine = new MakeLine();
	
	Control(){
		currentStatus = GraphicEditorMain.DEFAULT;
	}

	public int getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(int currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public void changeCurrentStatus(int num) {
		if(num != currentStatus) {
			if(num == GraphicEditorMain.DEFAULT) {
				
			}
			else if(num == GraphicEditorMain.LINE) {
				new MakeLine();
			}
			else if(num == GraphicEditorMain.SQUARE) {
				new MakeSquare();
			}
		}
	}
	
	
}
