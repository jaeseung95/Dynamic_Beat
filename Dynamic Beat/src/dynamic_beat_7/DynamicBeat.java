package dynamic_beat_7;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//JFrame GUI�� ����� �� ����
public class DynamicBeat extends JFrame{
	
	private Image screenImage;//���� ���۸� ���� �ڵ�
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/left.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/right.png"));
	private ImageIcon easyImage = new ImageIcon(Main.class.getResource("../images/easy.png"));
	private ImageIcon easy1Image = new ImageIcon(Main.class.getResource("../images/easy1.png"));
	private ImageIcon hardImage = new ImageIcon(Main.class.getResource("../images/hard.png"));
	private ImageIcon hard1Image = new ImageIcon(Main.class.getResource("../images/hard1.png"));
	

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton= new JButton(exitButtonBasicImage);
	private JButton startButton= new JButton(startButtonBasicImage);
	private JButton quitButton= new JButton(quitButtonBasicImage);
	private JButton rightButton= new JButton(rightButtonBasicImage);
	private JButton leftButton= new JButton(leftButtonBasicImage);
	private JButton easyButton= new JButton(easyImage);
	private JButton hardButton= new JButton(hardImage);
	
	private int mouseX, mouseY;//���콺�� x �� y ��ǥ�� �ǹ�
	
	private boolean isMainScreen = false;//boolean�� true �� false�� ��ȯ��Ų��.
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;
	
	public DynamicBeat() {
		setUndecorated(true);//������ Ÿ��Ʋ�� ���ֱ�
		setTitle("Dynamic Beat");//JFrame Ÿ��Ʋ�� �̸�
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//JFrame ������ ũ��
		setResizable(false);//JFrame ������ ũ�⸦ ����ڰ� ������ �� ������ ����  true����, false�Ұ���
		setLocationRelativeTo(null);//�������� ��ġ�� ������Ʈ�� ���� ������� ��ġ�� ����, �Ű������� null���� ������ ȭ���� ����� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� ���������
		setVisible(true);//�������� ȭ�鿡 ��Ÿ���� �Ѵ�(�⺻�����δ� ������ ����)
		setBackground(new Color(0, 0, 0, 0));//������ Į�� ����(red(0~255), green(0~255), blue(0~255), alpha(0~255): ����)
		setLayout(null);
		
		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		trackList.add(new Track("title1.png", "game1.png", "game1.png", "Rollercoaster.mp3", "Rollercoaster.mp3"));
		trackList.add(new Track("title2.png", "game2.png", "game2.png", "rollin.mp3", "rollin.mp3"));
		trackList.add(new Track("title3.png", "game3.png", "game3.png", "Wanna.mp3", "Wanna.mp3"));

		exitButton.setBounds(1215, 0, 61, 30);//(x:x��ǥ, y:y��ǥ, w:����ũ��, h:����ũ��)
		exitButton.setBorderPainted(false);// ��ư �׵θ� ����
		exitButton.setContentAreaFilled(false);//��ư ���� ��� ǥ�� ����
		exitButton.setFocusPainted(false);//��Ŀ�� ǥ�� ����
		exitButton.addMouseListener(new MouseAdapter() {//MouseListener ���콺 �Է��� �����ϴ� ������
			/* void setCursor(cursor.Type)�޼ҵ�
			 * HAND_CURSOR, WAUT_XOURSOR, TEXT_CURSOR ���� �ִ�
			 */
			@Override
			/*�������̵� ���� Ŭ������ ���ǵ� �޼ҵ��� �̸�, ��ȯ��, �Ű����� ������� ������ ������ �޼ҵ带
			 * ����Ŭ�������� �ٽ� ����, ���� Ŭ������ �ش� �޼ҵ尡 ���� Ŭ������ �޼ҵ带 ���������(����������, ����������)���̴�.
			 */
			public void mouseEntered(MouseEvent e) {//mouseEntered: ���콺�� ������Ʈ ���� ������ ���ö� �߻�
				exitButton.setIcon(exitButtonEnteredImage);//��ư ���� �ٲ�
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));//���콺�� �ո������ �ٲ�
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//mouseExited: ���콺�� �ش� ������Ʈ ���� ������ ������ �߻�
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));//�⺻ ���콺
			}
			
			@Override 
			public void mousePressed(MouseEvent e) {//mousePressed: ���콺 ��ư�� ������ �߻�
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(40, 200, 300, 200);//ctrl + shift + f �ڵ����� �ڵ� ����
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				introMusic.close();
				selectTrack(0);
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				easyButton.setVisible(true);
				hardButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		quitButton.setBounds(40, 400, 300, 200);//ctrl + shift + f �ڵ����� �ڵ� ����
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);//ctrl + shift + f �ڵ����� �ڵ� ����
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);//ctrl + shift + f �ڵ����� �ڵ� ����
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);//ctrl + shift + f �ڵ����� �ڵ� ����
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easy1Image);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);//ctrl + shift + f �ڵ����� �ڵ� ����
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hard1Image);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override 
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//���α׷� ȭ�� ũ��� �����ϰ� ���� ũ�⸦ ����
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);//����â�� ��ũ�� �̹����� �׷���
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen)
		{
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g);
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() -1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() -1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
	}
}
