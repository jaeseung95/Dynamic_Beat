 package dynamic_beat;

public class Main {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static final int NOTE_SPEED = 7;//��Ʈ�� �������� �ӵ�, ����Ÿ������ y��ǥ�� 1�ʿ� 700��ŭ �̵�
	public static final int SLEEP_TIME = 10;//sleep 0.001�� ���� 10�̸� 1�ʿ� 100�� ����
	public static final int REACK_TIME = 5;//�����ٿ� �����ϴ� �ð�
	
	public static void main(String[] args) {
		
		new DynamicBeat();
	}

}
