 package dynamic_beat;

public class Main {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 7;//노트가 떨어지는 속도, 슬립타임으로 y좌표는 1초에 700만큼 이동
	public static final int SLEEP_TIME = 10;//sleep 0.001초 기준 10이면 1초에 100번 실행
	public static final int REACK_TIME = 5;//판정바에 도달하는 시간
	
	public static void main(String[] args) {
		
		new DynamicBeat();
	}

}
