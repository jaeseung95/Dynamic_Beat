package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//JFrame GUI를 사용할 수 있음
public class DynamicBeat extends JFrame{
	
	private Image screenImage;//더블 버퍼를 위한 코드
	private Graphics screenGraphic;
	
	private Image IU;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);//화면을 가운데로 맞춰줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료시켜줌
		setVisible(true);//눈에 보이게 해줌
		
		IU = new ImageIcon(Main.class.getResource("../images/IU.jpg")).getImage();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//프로그램 화면 크기와 동일하게 사진 크기를 맞춤
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);//게임창에 스크린 이미지가 그려짐
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(IU, 0, 0, null);
		this.repaint();
	}
}
