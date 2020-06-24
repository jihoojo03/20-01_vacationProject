package calculator_01;

import java.util.ArrayList;

public class Container {
	private ArrayList<String> equationList;
	private ArrayList<String> answerList;
	private int size;
	
	Container(){
		equationList = new ArrayList<String>(5);
		answerList = new ArrayList<String>(5);
		size = 0;
	}
	
	public ArrayList<String> getEquationList() {
		return equationList;
	}
	public void setEquationList(ArrayList<String> equationList) {
		this.equationList = equationList;
	}
	public ArrayList<String> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(ArrayList<String> answerList) {
		this.answerList = answerList;
	}
	
	public void saveEquationList(String equation) {
		equationList.add(equation);
		size++;
	}
	public void saveAnswerList(String answer) {
		answerList.add(answer);
	}
	public int getListSize() {
		return size;
	}
	
	public int getStartNum() {
		if(size <= 5) return 0;
		else return (size - 5);
	}
	
	public String getWholeListToNum(int num) {
		String containText = new String();
		containText = "<html><body>" + equationList.get(num) + "<br>" + answerList.get(num) + "</body></html>";
		return containText;
	}
	
	public String getEquationListToNum(int num) {
		return equationList.get(num);
	}
	
	public String getAnswerListToNum(int num) {
		return answerList.get(num);
	}
	
	public void clearList() {
		equationList.clear();
		answerList.clear();
		size = 0;
	}
	
}
