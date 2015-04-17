package jumper1.pkg1;

public class Background {
	
	private int bgX, bgY;
        public int bgdx;
	
	public Background(int x, int y){
		bgX = x;
		bgY = y;
		bgdx = 0;
	}
	
	public void update() {
		bgX += bgdx;

		if (bgX <= -2000){
			bgX += 4000;
		}
	}

	public int getBgX() {
		return bgX;
	}

	public int getBgY() {
		return bgY;
	}
	
}
