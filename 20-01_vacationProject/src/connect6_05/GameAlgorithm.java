package connect6_05;

public class GameAlgorithm {
	private int amount;			// ÃÑ µ¹°¹¼ö
	private int currentTurn;	// 0 : Èæ, 1 : ¹é
	private int stone[][];		// -1 : default, 0 : Èæ, 1 : ¹é, 2 : Áß¸³µ¹, 3 : º®
			
	GameAlgorithm(){
		amount = 0;
		currentTurn = 0;

		stone = new int[21][21];
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 21; j++) {
				stone[i][j] = -1;
			}
		}
		for(int i = 0; i < 21; i++) {
			stone[i][0] = 3;
			stone[0][i] = 3;
			stone[i][20] = 3;
			stone[20][i] = 3;
		}
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}

	public int[][] getStone() {
		return stone;
	}
	
	public void setStone(int x, int y, int stone) {
		System.out.println(stone);
		this.stone[x][y] = stone;
	}
	
	public boolean isStone(int x, int y) {
		if(this.stone[x][y] == -1) return false;
		else return true;
	}
	
	public void launch() {
		amount++;
		if(amount % 4 == 0 || amount % 4 == 1) {
			currentTurn = 0;
		}
		else if(amount % 4 == 2 || amount % 4 == 3) {
			currentTurn = 1;
		}
	}
	
	public int win(int x, int y) {
		int highWin = 1;
		
		if(stone[x - 1][y] == currentTurn) {		// 1¹ø
			if(stone[x + 1][y] == currentTurn) {
				highWin = winCount(x - 1, y, 1) + winCount(x + 1, y, 5) + 1;
			}
			else {
				highWin = winCount(x - 1, y, 1) + 1;
			}
		}
		if(stone[x][y - 1] == currentTurn) {		// 2¹ø
			if(stone[x][y + 1] == currentTurn) {
				if(winCount(x, y - 1, 2) + winCount(x, y + 1, 6) + 1 > highWin)
					highWin = winCount(x, y - 1, 2) + winCount(x, y + 1, 6) + 1;
			}
			else {
				if(winCount(x, y - 1, 2) + 1 > highWin)
					highWin = winCount(x, y - 1, 2) + 1;
			}	
		}
		if(stone[x - 1][y - 1] == currentTurn) {	// 3¹ø
			if(stone[x + 1][y + 1] == currentTurn) {
				if(winCount(x - 1, y - 1, 3) + winCount(x + 1, y + 1, 7) + 1 > highWin)
					highWin = winCount(x - 1, y - 1, 3) + winCount(x + 1, y + 1, 7) + 1;
			}
			else {
				if(winCount(x - 1, y - 1, 3) + 1 > highWin)
					highWin = winCount(x - 1, y - 1, 3) + 1;
			}	
		}
		if(stone[x - 1][y + 1] == currentTurn) {	// 4¹ø
			if(stone[x + 1][y - 1] == currentTurn) {
				if(winCount(x - 1, y - 1, 3) + winCount(x + 1, y + 1, 7) + 1 > highWin)
					highWin = winCount(x - 1, y + 1, 4) + winCount(x + 1, y - 1, 8) + 1;
			}
			else {
				if(winCount(x - 1, y - 1, 3) + 1 > highWin)
					highWin = winCount(x - 1, y + 1, 4) + 1;
			}	
		}
		if(stone[x + 1][y] == currentTurn) {		// 5¹ø
			if(stone[x - 1][y] == currentTurn) {
				if(winCount(x + 1, y, 5) + winCount(x - 1, y, 1) + 1 > highWin)
					highWin = winCount(x + 1, y, 5) + winCount(x - 1, y, 1) + 1;
			}
			else {
				if(winCount(x + 1, y, 5) + 1 > highWin)
					highWin = winCount(x + 1, y, 5) + 1;
			}	
		}
		if(stone[x][y + 1] == currentTurn) {		// 6¹ø
			if(stone[x][y - 1] == currentTurn) {
				if(winCount(x, y + 1, 6) + winCount(x, y - 1, 2) + 1 > highWin)
					highWin = winCount(x, y + 1, 6) + winCount(x, y - 1, 2) + 1;
			}
			else {
				if(winCount(x, y + 1, 6) + 1 > highWin)
					highWin = winCount(x, y + 1, 6) + 1;
			}	
		}
		if(stone[x + 1][y + 1] == currentTurn) {	// 7¹ø
			if(stone[x - 1][y - 1] == currentTurn) {
				if(winCount(x + 1, y + 1, 7) + winCount(x - 1, y - 1, 3) + 1 > highWin)
					highWin = winCount(x + 1, y + 1, 7) + winCount(x - 1, y - 1, 3) + 1;
			}
			else {
				if(winCount(x + 1, y + 1, 7) + 1 > highWin)
					highWin = winCount(x + 1, y + 1, 7) + 1;
			}	

		}
		if(stone[x + 1][y - 1] == currentTurn){		// 8¹ø
			if(stone[x - 1][y + 1] == currentTurn) {
				if(winCount(x + 1, y - 1, 8) + winCount(x - 1, y + 1, 4) + 1 > highWin)
					highWin = winCount(x + 1, y - 1, 8) + winCount(x - 1, y + 1, 4) + 1;
			}
			else {
				if(winCount(x + 1, y - 1, 8) + 1 > highWin)
					highWin = winCount(x + 1, y - 1, 8) + 1;
			}	
		}
		return highWin;	
	}
	
	public int winCount(int x, int y, int direction) {
		if(direction == 1) {
			if(stone[x - 1][y] != currentTurn) return 1;
			else return winCount(x - 1, y, 1) + 1;
		}else if(direction == 2) {
			if(stone[x][y - 1] != currentTurn) return 1;
			else return winCount(x, y - 1, 2) + 1;
		}else if(direction == 3) {
			if(stone[x - 1][y - 1] != currentTurn) return 1;
			else return winCount(x - 1, y - 1, 3) + 1;
		}
		else if(direction == 4) {
			if(stone[x - 1][y + 1] != currentTurn) return 1;
			else return winCount(x - 1, y + 1, 4) + 1;
		}
		else if(direction == 5) {
			if(stone[x + 1][y] != currentTurn) return 1;
			else return winCount(x + 1, y, 5) + 1;
		}
		else if(direction == 6) {
			if(stone[x][y + 1] != currentTurn) return 1;
			else return winCount(x, y + 1, 6) + 1;
		}
		else if(direction == 7) {
			if(stone[x + 1][y + 1] != currentTurn) return 1;
			else return winCount(x + 1, y + 1, 7) + 1;
		}
		else if(direction == 8) {
			if(stone[x + 1][y - 1] != currentTurn) return 1;
			else return winCount(x + 1, y - 1, 8) + 1;
		}
		else return 300;
	}
}
