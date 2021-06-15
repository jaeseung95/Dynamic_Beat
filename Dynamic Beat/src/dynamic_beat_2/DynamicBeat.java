package dynamic_beat_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//JFrame GUI�� ����� �� ����
public class DynamicBeat extends JFrame{
	
	private Image screenImage;//���� ���۸� ���� �ڵ�
	private Graphics screenGraphic;
	
	private Image IU;
	
	public DynamicBeat() {
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);//ȭ���� ����� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� ���������
		setVisible(true);//���� ���̰� ����
		
		IU = new ImageIcon(Main.class.getResource("../images/IU.jpg")).getImage();
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//���α׷� ȭ�� ũ��� �����ϰ� ���� ũ�⸦ ����
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);//����â�� ��ũ�� �̹����� �׷���
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(IU, 0, 0, null);
		this.repaint();
	}
}
