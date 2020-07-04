package imageProcessing_04;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GUITest extends JFrame{

	    // 입력과 출력 배열을 원본 사진과 동일한 256 X 256 크기로 설정합니다.
	    // 각 이미지의 픽셀은 0~255의 값을 가지므로 데이터 형식을 int로 합니다.
	    
	    private int height = 480;
	    private int width = 720;
	    
	    private ImageIcon sampleImage = new ImageIcon(ImageProcessingMain.class.getResource("../images/sampleImage.jpg"));
	    private ImageIcon enlargementImage = new ImageIcon(ImageProcessingMain.class.getResource("../images/enlargement.png"));
	    private ImageIcon reductionImage = new ImageIcon(ImageProcessingMain.class.getResource("../images/reduction.png"));
	    private ImageIcon enlargementSelectedImage = new ImageIcon(ImageProcessingMain.class.getResource("../images/enlargementSelected.png"));
	    private ImageIcon reductionSelectedImage = new ImageIcon(ImageProcessingMain.class.getResource("../images/reductionSelected.png"));
	    private ImageIcon upImage = new ImageIcon(ImageProcessingMain.class.getResource("../images/up.png"));
	    private ImageIcon downImage = new ImageIcon(ImageProcessingMain.class.getResource("../images/down.png"));
	    

	    private JSlider brightSlider = new JSlider(-100, 100);
	    private JSlider saturationSlider = new JSlider(-100, 100);
	    
	    private JButton fileLoadButton = new JButton();
	    private JButton reOriginalButton = new JButton("원본 보이기");
	    private JButton fileSaveButton = new JButton("저장하기");
	    private JButton grayButton =  new JButton("흑백 변환");
	    private JButton upButton = new JButton(enlargementImage);
	    private JButton downButton = new JButton(reductionImage);
	    private JButton btnNewButton = new JButton("\uCC44\uB3C4");
	    private JButton mosaicDownButton = new JButton(downImage);
	    private JButton mosaicUpButton = new JButton(upImage);
	    private JButton synthesizeButton = new JButton("합성하기");
	    private JButton fixButton = new JButton("\uACE0\uC815");
	    
	    private JLabel mosaicLabel = new JLabel("\uBAA8\uC790\uC774\uD06C");
	    private JLabel originalImageLabel = new JLabel();
	    private JLabel brightLabel = new JLabel("\uBC1D\uAE30");
	    private JLabel magnificationLabel = new JLabel("\uBC30\uC728");
	    private JLabel magnificationPercent = new JLabel("100%");
	    private JLabel saturationLabel = new JLabel("\uB300\uBE44");
	    private JLabel mosaicNumLabel = new JLabel("Off");
	    
	    private BufferedImage synthImage;
	    private BufferedImage originalBI;
	    private BufferedImage changeBI;
	    private BufferedImage showBI;
	    
	    private int bright = 0;
	    private int contrast = 0;
	    private int currentMag = 1; // 1 = 100, 2 = 200, 4 = 400
	    
	    private boolean isGray = false;
	    private boolean isEnlarge = false;
	    private boolean isReduce = false;
	    private boolean isSynthesis = false;
	    private boolean isMosaic = false;
	    
	    private Image changeSizeImage;

	    private File synthesisImage = new File("");
	   
	    
	    GUITest() {
	    	setTitle("Image Processing");
			setSize(ImageProcessingMain.SCREEN_WIDTH, ImageProcessingMain.SCREEN_HEIGHT);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			setVisible(true);
			
			makeInterface();
	    }
	    
	    public void makeInterface() {
	    	fileLoadButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	fileLoadButton.setBackground(SystemColor.activeCaptionBorder);
	    	fileLoadButton.setText("파일 로드");
	    	fileLoadButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					fileLoadButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					fileLoadButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					fileLoad();
				}
			});
	    	fileLoadButton.setBounds(50, 560, 110, 35);
	    	fileLoadButton.setVisible(true);
	    	getContentPane().add(fileLoadButton);
	    	originalImageLabel.setFont(new Font("나눔바른고딕", Font.BOLD, 18));
	    	originalImageLabel.setForeground(Color.PINK);
	    	
	    	originalImageLabel.setText("                                                                          \uC0AC\uC9C4\uC744 \uB85C\uB4DC\uD574\uC8FC\uC138\uC694");
	    	originalImageLabel.setBackground(Color.DARK_GRAY);
	    	originalImageLabel.setBounds(50, 50, 720, 480);
	    	getContentPane().add(originalImageLabel);
	    	reOriginalButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	reOriginalButton.setBackground(SystemColor.activeCaption);
	    	
	    	
	    	reOriginalButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					reOriginalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					reOriginalButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					reOriginal();
					
				}
			});
	    	reOriginalButton.setBounds(330, 560, 110, 35);
	    	getContentPane().add(reOriginalButton);
	    	fileSaveButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	fileSaveButton.setBackground(SystemColor.activeCaptionBorder);
	    	
	    	
	    	fileSaveButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					fileSaveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					fileSaveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					fileSave();
				}
			});
	    	fileSaveButton.setBounds(190, 560, 110, 35);
	    	getContentPane().add(fileSaveButton);
	    	grayButton.setBackground(new Color(255, 255, 255));
	    	grayButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	
	    	
	    	grayButton.setBounds(865, 383, 110, 35);
	    	grayButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					grayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					grayButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					if(isGray) {
						isGray = false;
						showBI = deepCopy(changeBI);
						originalImageLabel.setIcon(new ImageIcon(showBI)); //레이블에 이미지 표시
						grayButton.setBackground(new Color(255, 255, 255));
					}else {
						isGray = true;
						changeGray();
						grayButton.setBackground(new Color(200, 200, 200));
					}
					
				}
			});
	    	getContentPane().add(grayButton);
	    	
	    	
	    	brightSlider.setBounds(820, 205, 200, 50);
	    	brightSlider.setMajorTickSpacing(50);
	    	brightSlider.setPaintTicks(true);
	    	brightSlider.setPaintLabels(true);
	    	brightSlider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					bright = brightSlider.getValue();
					System.out.println(bright);
					changeBrightContrast();
					magnificationPercent.setText("100%");
					currentMag = 1;
					isEnlarge = false;
					isReduce = false;
					downButton.setIcon(reductionImage);
					upButton.setIcon(enlargementImage);
				}
	    		
	    	});
	    	getContentPane().add(brightSlider);
	    	brightLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	
	    	
	    	brightLabel.setBounds(820, 180, 57, 15);
	    	getContentPane().add(brightLabel);
	    	
	    	
	    	saturationLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	saturationLabel.setBounds(820, 284, 57, 15);
	    	getContentPane().add(saturationLabel);
	    	
	    	
	    	saturationSlider.setBounds(820, 302, 200, 50);
	    	saturationSlider.setMajorTickSpacing(50);
	    	saturationSlider.setPaintTicks(true);
	    	saturationSlider.setPaintLabels(true);
	    	saturationSlider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					contrast = saturationSlider.getValue();
					changeBrightContrast();
					magnificationPercent.setText("100%");
					currentMag = 1;
					isEnlarge = false;
					isReduce = false;
					downButton.setIcon(reductionImage);
					upButton.setIcon(enlargementImage);
				}	    		
	    	});
	    	getContentPane().add(saturationSlider);
	    	
	    	
	    	downButton.setBounds(985, 50, 35, 35);
	    	downButton.setBorderPainted(false);
	    	downButton.setContentAreaFilled(false);
	    	downButton.setFocusPainted(false);
	    	downButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					downButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					downButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					downButton.setIcon(reductionSelectedImage);
					if(isEnlarge == true) {
						upButton.setIcon(enlargementImage);
					}
					
					if(currentMag == 1) {
						downButton.setIcon(reductionImage);
					}
					else if(currentMag == 2) {
						downButton.setIcon(reductionImage);
						isEnlarge = false;
						isReduce = false;
						currentMag = 1;
						magnificationPercent.setText("100%");
						System.out.println(currentMag);
					}
					else if(currentMag == 4) {
						isEnlarge = false;
						isReduce = true;
						currentMag = 2;
						magnificationPercent.setText("200%");
						System.out.println(currentMag);
					}
				}
			});
	    	getContentPane().add(downButton);
	    	
	    	
	    	upButton.setBounds(940, 50, 35, 35);
	    	upButton.setBorderPainted(false);
	    	upButton.setContentAreaFilled(false);
	    	upButton.setFocusPainted(false);
	    	upButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
//					upButton.setIcon(numButtonEnteredImage);
					upButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
//					upButton.setIcon(numButtonBasicImage);
					upButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					upButton.setIcon(enlargementSelectedImage);
					if(isReduce == true) {
						downButton.setIcon(reductionImage);
					}
					if(currentMag == 1) {
						isEnlarge = true;
						isReduce = false;
						currentMag = 2;
						System.out.println(currentMag);
						magnificationPercent.setText("200%");
					}
					else if(currentMag == 2) {
						isEnlarge = true;
						isReduce = false;
						currentMag = 4;
						System.out.println(currentMag);
						magnificationPercent.setText("400%");
					}
					
				}
			});
	    	getContentPane().add(upButton);
	    	magnificationLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	magnificationLabel.setBounds(820, 50, 35, 21);
	    	
	    	getContentPane().add(magnificationLabel);
	    	magnificationPercent.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
	    	magnificationPercent.setBounds(865, 62, 46, 15);
	    	
	    	getContentPane().add(magnificationPercent);
	    	synthesizeButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	synthesizeButton.setBackground(new Color(65, 105, 225));
	    	
	    	synthesizeButton.setBounds(470, 560, 110, 35);
	    	synthesizeButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					synthesizeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					synthesizeButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					synthesize();
					isSynthesis = true;
				}	
			});
	    	getContentPane().add(synthesizeButton);
	    	
	    	
	    	mosaicLabel.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	mosaicLabel.setBounds(820, 113, 57, 21);
	    	getContentPane().add(mosaicLabel);
	    	
	    	
	    	mosaicUpButton.setBounds(940, 113, 35, 35);
	    	mosaicUpButton.setBorderPainted(false);
	    	mosaicUpButton.setContentAreaFilled(false);
	    	mosaicUpButton.setFocusPainted(false);
	    	mosaicUpButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					mosaicUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					mosaicUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					mosaicNumLabel.setText("On");
					isMosaic = true;
				}	
			});
	    	getContentPane().add(mosaicUpButton);
	    	

	    	mosaicDownButton.setBounds(985, 113, 35, 35);
	    	mosaicDownButton.setBorderPainted(false);
	    	mosaicDownButton.setContentAreaFilled(false);
	    	mosaicDownButton.setFocusPainted(false);
	    	mosaicDownButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					mosaicDownButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					mosaicDownButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					mosaicNumLabel.setText("Off");
					isMosaic = false;
				}	
			});
	    	getContentPane().add(mosaicDownButton);
	    	
	    	
	    	mosaicNumLabel.setFont(new Font("나눔바른고딕", Font.BOLD, 16));
	    	mosaicNumLabel.setBounds(880, 123, 35, 21);
	    	
	    	getContentPane().add(mosaicNumLabel);
	    	fixButton.setFont(new Font("나눔바른고딕", Font.PLAIN, 14));
	    	fixButton.setBackground(new Color(70, 130, 180));
	    	fixButton.setBounds(592, 560, 65, 35);
	    	fixButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					fixButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					fixButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				public void mousePressed(MouseEvent e) {
					isSynthesis = false;
					fixButton.setVisible(false);
					changeBI = deepCopy(showBI);
				}	
			});
	    	getContentPane().add(fixButton);
	    	fixButton.setVisible(false);	  
	    	
	    	getContentPane().addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					

				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					Point moveP = e.getPoint();
					if(moveP.x >= 50 && moveP.x <= 770 && moveP.y >= 50 && moveP.y <= 530) {
						if(currentMag == 1) {
							originalImageLabel.setIcon(new ImageIcon(changeBI));
						}
						if(currentMag == 2) {
							showTwiceEnlargement(moveP);
						}
						else if(currentMag == 4) {
							showFourTimesEnlargement(moveP);
						}
					}
					if(isSynthesis) {
						if(moveP.x < 50 + synthImage.getWidth()/2) moveP.x = 50 + synthImage.getWidth()/2;
						if(moveP.x > 770 - synthImage.getWidth()/2) moveP.x = 770 - synthImage.getWidth()/2;
						if(moveP.y < 50 + synthImage.getHeight()/2) moveP.y = 50 + synthImage.getHeight()/2;
						if(moveP.y > 530 - synthImage.getHeight()/2) moveP.y = 530 - synthImage.getHeight()/2;
						changeSynthesize(moveP);
					}
					if(isMosaic) {
						makeMosaic(moveP);
					}
					
					System.out.println(moveP.x + " / " + moveP.y);
				}
			});
	    
	    	
	    	getContentPane().repaint();
	    	getContentPane().setVisible(true);
	    }
	    
 
	    void fileLoad() {
	    	 JFileChooser fileChooser = new JFileChooser();
	         fileChooser.setDialogTitle("파일 불러오기");
	         fileChooser.setFileFilter(new FileNameExtensionFilter("JPG&GIF Images", "jpg", "gif", "jpeg")); // 파일필터
	         fileChooser.setMultiSelectionEnabled(false);// 다중 선택 불가
	         int returnVal = fileChooser.showOpenDialog(this); // show openDialog 
	         if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
	        	 try{
	        		File sourceimage = new File(fileChooser.getSelectedFile().toString());
	        		
	        		try {   
	        			originalBI = ImageIO.read(sourceimage); //이미지 파일을 읽어와서 BufferedImage 에 넣음
	        			changeSizeImage = originalBI.getScaledInstance(720, 480, Image.SCALE_SMOOTH);
	        			changeBI = deepCopy(originalBI);
	        			showBI = deepCopy(originalBI);
	                    originalImageLabel.setIcon(new ImageIcon(changeSizeImage)); //레이블에 이미지 표시
	        		}
	        		catch(Exception e) {}
//	                loadImage(fileChooser.getSelectedFile().toString());
	             } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	             }
	         }
	    }
	    
	    
	    void fileSave() {
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setDialogTitle("파일 저장");
	        fileChooser.setFileFilter(new FileNameExtensionFilter("JPG&GIF Images", "jpg", "gif", "jpeg")); // 파일필터
	        fileChooser.setMultiSelectionEnabled(false); // 다중 선택 불가
	        int returnVal = fileChooser.showSaveDialog(this); // show saveDialog 
	        if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
	            try {
	            	BufferedImage bufferedImage = new BufferedImage(720, 480, BufferedImage.TYPE_INT_BGR);
	            	changeSizeImage = showBI.getScaledInstance(720, 480, Image.SCALE_SMOOTH);
	            	bufferedImage.createGraphics().drawImage(changeSizeImage, 0, 0, this);
	            	 // 해당경로에 이미지를 저장함.
	            	ImageIO.write(bufferedImage, "jpg", new File(fileChooser.getSelectedFile().toString()));
	            
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
		public void screenDraw(Graphics g) {
			paintComponents(g);
			this.repaint();
		}
		
		public void reOriginal() {
    		try {   
    			saturationSlider.setValue(0);
    			brightSlider.setValue(0);
    			changeBI = deepCopy(originalBI);
    			showBI = deepCopy(originalBI);
    			originalImageLabel.setIcon(new ImageIcon(showBI));
    		}
    		catch(Exception e) {}
    		isGray = false;
		}
		
		public void changeGray() {
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
				Color c = new Color(changeBI.getRGB(j, i));
				int red = (int)(c.getRed() * 0.299);
				int green = (int)(c.getGreen() * 0.587);
				int blue = (int)(c.getBlue() * 0.114);
				Color newColor = new Color(red+green+blue, red+green+blue, red+green+blue);
				showBI.setRGB(j, i, newColor.getRGB());
				}
			}
//			Graphics2D g = (Graphics2D)getGraphics();
//			g.drawImage(changeBI, 0, 0, null);
			originalImageLabel.setIcon(new ImageIcon(showBI)); //레이블에 이미지 표시
		}
		
		public void changeBrightContrast() {
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
			Color c = new Color(changeBI.getRGB(j, i));
			
			int red = c.getRed();
			int green = c.getGreen();
			int blue = c.getBlue();
			
			int adjContrast01 = contrast / 10;
			int adjContrast02 = contrast * 2 / 10;
			int adjContrast03 = contrast * 3 / 10;
			
			if(contrast >= 0) {
				if(red >= 210) red += adjContrast01;
				else if(red >= 169) red += adjContrast02;
				else if(red >= 128) red += adjContrast03;
				else if(red >= 86) red -= adjContrast03;
				else if(red >= 43) red -= adjContrast02;
				else red -= adjContrast01;
				
				if(green >= 210) green += adjContrast01;
				else if(green >= 169) green += adjContrast02;
				else if(green >= 128) green += adjContrast03;
				else if(green >= 86) green -= adjContrast03;
				else if(green >= 43) green -= adjContrast02;
				else green -= adjContrast01;
				
				if(blue >= 210) blue += adjContrast01;
				else if(blue >= 169) blue += adjContrast02;
				else if(blue >= 128) blue += adjContrast03;
				else if(blue >= 86) blue -= adjContrast03;
				else if(blue >= 43) blue -= adjContrast02;
				else blue -= adjContrast01;
			}
			else {
				if(red >= 210) red += adjContrast03;
				else if(red >= 169) red += adjContrast02;
				else if(red >= 128) red += adjContrast01;
				else if(red >= 86) red -= adjContrast01;
				else if(red >= 43) red -= adjContrast02;
				else red -= adjContrast03;
				
				if(green >= 210) green += adjContrast03;
				else if(green >= 169) green += adjContrast02;
				else if(green >= 128) green += adjContrast01;
				else if(green >= 86) green -= adjContrast01;
				else if(green >= 43) green -= adjContrast02;
				else green -= adjContrast03;
				
				if(blue >= 210) blue += adjContrast03;
				else if(blue >= 169) blue += adjContrast02;
				else if(blue >= 128) blue += adjContrast01;
				else if(blue >= 86) blue -= adjContrast01;
				else if(blue >= 43) blue -= adjContrast02;
				else blue -= adjContrast03;
			}
			
			red += bright;
			green += bright;
			blue += bright;

			if(red > 255) red = 255;
			if(green > 255) green = 255;
			if(blue > 255) blue = 255;
			if(red < 0) red = 0;
			if(green < 0) green = 0;
			if(blue < 0) blue = 0;
			Color newColor = new Color(red, green, blue);
			showBI.setRGB(j, i, newColor.getRGB());
			}
		}
		if(isGray) changeGray();
		originalImageLabel.setIcon(new ImageIcon(showBI)); //레이블에 이미지 표시
		}
			
		
		public void synthesize() {
			 JFileChooser fileChooser = new JFileChooser();
	         fileChooser.setDialogTitle("파일 불러오기");
	         fileChooser.setFileFilter(new FileNameExtensionFilter("JPG&GIF Images", "jpg", "gif", "jpeg")); // 파일필터
	         fileChooser.setMultiSelectionEnabled(false);// 다중 선택 불가
	         int returnVal = fileChooser.showOpenDialog(this); // show openDialog 
	         if (returnVal == JFileChooser.APPROVE_OPTION) { // 파일을 선택하였을 때
	        	 try{
	        		 synthesisImage = new File(fileChooser.getSelectedFile().toString());
	        		 synthImage = ImageIO.read(synthesisImage);
	        		 Point point = new Point(410, 290);
	        		 changeSynthesize(point);
	        		}
	        		catch(Exception e) {}
//	                loadImage(fileChooser.getSelectedFile().toString());
	         }
	         fixButton.setVisible(true);
		}
		
		public void changeSynthesize(Point point) {
			try {
				synthImage = ImageIO.read(synthesisImage);
				Color deleteC = new Color(synthImage.getRGB(0, 0));
				showBI = deepCopy(changeBI);
				
				for(int i = 0; i < synthImage.getHeight(); i++) {
					for(int j = 0; j < synthImage.getWidth(); j++) {
					Color c = new Color(synthImage.getRGB(j, i));
						if(!(c.equals(deleteC))) {
							int red = c.getRed();
							int green = c.getGreen();
							int blue = c.getBlue();
							Color newColor = new Color(red, green, blue);
							showBI.setRGB(j + point.x - 50 - synthImage.getWidth()/2, i + point.y - 50 - synthImage.getHeight()/2, newColor.getRGB());
						}
					}
				}
				if(isGray) changeGray();
				
	            originalImageLabel.setIcon(new ImageIcon(showBI)); //레이블에 이미지 표시
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void showTwiceEnlargement(Point point) {
			Point adjPoint = new Point();
			adjPoint.x = (int) point.getX();
			adjPoint.y = (int) point.getY();
			if(point.getX() < 230) adjPoint.x = 230;
			if(point.getX() > 590) adjPoint.x = 590;
			if(point.getY() < 170) adjPoint.y = 170;
			if(point.getY() > 410) adjPoint.y = 410;
			
			System.out.println(adjPoint.x + " / "+ adjPoint.y);
			
			int adjHeight = height / 2;
			int adjWidth = width /2;
			
			for(int i = 0; i < adjHeight; i++) {
				for(int j = 0; j < adjWidth; j++) {
				Color c = new Color(changeBI.getRGB(adjPoint.x - 230 + j, adjPoint.y - 170 + i));
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				
				Color newColor = new Color(red, green, blue);
				showBI.setRGB(2 * j, 2 * i, newColor.getRGB());
				showBI.setRGB(2 * j + 1, 2 * i, newColor.getRGB());
				showBI.setRGB(2 * j, 2 * i + 1, newColor.getRGB());
				showBI.setRGB(2 * j + 1, 2 * i + 1, newColor.getRGB());
				}
			}
			originalImageLabel.setIcon(new ImageIcon(showBI)); //레이블에 이미지 표시
		}
		
		public void showFourTimesEnlargement(Point point) {
			Point adjPoint = new Point();
			adjPoint.x = (int) point.getX();
			adjPoint.y = (int) point.getY();
			if(point.getX() < 140) adjPoint.x = 140;
			if(point.getX() > 680) adjPoint.x = 680;
			if(point.getY() < 110) adjPoint.y = 110;
			if(point.getY() > 470) adjPoint.y = 470;
			
			System.out.println(adjPoint.x + " / "+ adjPoint.y);
			
			int adjHeight = height / 4;
			int adjWidth = width / 4;
			
			for(int i = 0; i < adjHeight; i++) {
				for(int j = 0; j < adjWidth; j++) {
				Color c = new Color(changeBI.getRGB(adjPoint.x - 140 + j, adjPoint.y - 110 + i));
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				
				Color newColor = new Color(red, green, blue);
				showBI.setRGB(4 * j, 4 * i, newColor.getRGB());
				showBI.setRGB(4 * j + 1, 4 * i, newColor.getRGB());
				showBI.setRGB(4 * j + 2, 4 * i, newColor.getRGB());
				showBI.setRGB(4 * j + 3, 4 * i, newColor.getRGB());
				showBI.setRGB(4 * j, 4 * i + 1, newColor.getRGB());
				showBI.setRGB(4 * j + 1, 4 * i + 1, newColor.getRGB());
				showBI.setRGB(4 * j + 2, 4 * i + 1, newColor.getRGB());
				showBI.setRGB(4 * j + 3, 4 * i + 1, newColor.getRGB());
				showBI.setRGB(4 * j, 4 * i + 2, newColor.getRGB());
				showBI.setRGB(4 * j + 1, 4 * i + 2, newColor.getRGB());
				showBI.setRGB(4 * j + 2, 4 * i + 2, newColor.getRGB());
				showBI.setRGB(4 * j + 3, 4 * i + 2, newColor.getRGB());
				showBI.setRGB(4 * j, 4 * i + 3, newColor.getRGB());
				showBI.setRGB(4 * j + 1, 4 * i + 3, newColor.getRGB());
				showBI.setRGB(4 * j + 2, 4 * i + 3, newColor.getRGB());
				showBI.setRGB(4 * j + 3, 4 * i + 3, newColor.getRGB());
				}
			}
			originalImageLabel.setIcon(new ImageIcon(showBI)); //레이블에 이미지 표시
		}
		
		public void makeMosaic(Point point) {
			int adjHeight = 16;
			int adjWidth = 16;
			
			for(int i = 0; i < adjHeight; i++) {
				for(int j = 0; j < adjWidth; j++) {
					int red = 0;
					int green = 0;
					int blue = 0;
					
					for(int a = 0; a < 4; a++) {
						for(int b = 0; b < 4; b++) {
							Color c = new Color(changeBI.getRGB(4 * j + point.x + a - 82, 4 * i + point.y + b - 82));
							red += c.getRed();
							green += c.getGreen();
							blue += c.getBlue();
						}
					}
					
					red /= 16;
					green /= 16;
					blue /= 16;
				
					for(int a = 0; a < 4; a++) {
						for(int b = 0; b < 4; b++) {
							Color c = new Color(red, green, blue);
							showBI.setRGB(4 * j + point.x + a - 82, 4 * i + point.y + b - 82, c.getRGB());
						}
					}
				}
			}
			changeBI = deepCopy(showBI);
			originalImageLabel.setIcon(new ImageIcon(showBI)); //레이블에 이미지 표시
		}
		

		public static BufferedImage deepCopy(BufferedImage bi) {
			ColorModel cm = bi.getColorModel();
			boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
			WritableRaster raster = bi.copyData(bi.getRaster().createCompatibleWritableRaster());
			return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
		}
}

