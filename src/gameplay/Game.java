package gameplay;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.xml.bind.Marshaller.Listener;

import org.omg.CORBA.portable.InputStream;

import auto.autoClickThread;
import auto.updateObjects;
import gameplay.logoSizes.ButtonPosition;
import gameplay.logoSizes.TextSettings;
import gameplay.settings.customPanel;
import gameplay.settings.panelSettings;
import main.GameInfo;
import main.Main;


public class Game extends JFrame implements ActionListener {

	
	//Array von JLabels und JButtons
	public static JLabel[] label = new JLabel[11];
    static JButton[] button = new JButton[21];
     
	//Panels 
    customPanel panel = new customPanel(null);
    customPanel playpanel = new customPanel(null);
    customPanel shopPanel = new customPanel(null);
    customPanel skinPanel = new customPanel(null);
    customPanel settingsPanel = new customPanel(null);
        
	//HTML
	static String html0 = "<html>";
	String html1 = "</html>";
	String red = "<a color=red>";
	String black = "<a color=black>";
	
	//Grï¿½ï¿½e und Hï¿½he der Buttons
	//Fï¿½r die richtige positionierung der Buttons 
    int bheight = 40; 
    int bwidth = 150;
	
    int getWidth;
    int getHeight;
    int i=0;
    
    //File Chooser for Save File
    final JFileChooser fc = new JFileChooser();
    
	//Der festgesetzte Score
	public static double score = 0;

	//Boost Status
	public static int boost = 1;
	
	//Upgrade Base
	static int upgrade = 50;
	static int upgradeMultiplier = 2;
	
	//Upgrade Max
	static int maxupgrade = 30;
	
	//bloon state

	int Framesize;
	
	int scoreShop;

	int checkClose;
	
	int titleLength = 200;
	int titleHeigth = 200;
	
	public static double checkAutoClick = 1.0;
	
	//
	int saveManager;
	
	int hund;
	JFrame frameSettingsOverall;
	
	ImageIcon logo = new ImageIcon("./resources/logo.png");
	ImageIcon logopress = new ImageIcon("./resources/logopress.png");
	
	ImageIcon bloon = new ImageIcon("./resources/bloon.png");
	ImageIcon bloonpressed = new ImageIcon("./resources/bloonpressed.png");

    ImageIcon settings = new ImageIcon("./resources/settings.png");
	ImageIcon play = new ImageIcon("./resources/play.png");
	ImageIcon changelog = new ImageIcon("./resources/changelog.png");
	
	ImageIcon save = new ImageIcon("./resources/save.png");
	ImageIcon load = new ImageIcon("./resources/changelog.png");
      	
    ImageIcon bluebloon = new ImageIcon("./resources/shop/bloon_2_shop.png");
    ImageIcon greenbloon = new ImageIcon("./resources/shop/bloon_3_shop.png");
    ImageIcon orangebloon = new ImageIcon("./resources/shop/bloon_4_shop.png");
    ImageIcon pinkbloon = new ImageIcon("./resources/shop/bloon_5_shop.png");
    ImageIcon shop = new ImageIcon("./resources/shop.png");
    
	int basecost = 150;
	
	int bluebloonstate = 0;
	int bluecost;
	JButton bluebloonbutton = new JButton();
	
	int greenloonstate = 0;
	int greencost;
	JButton greenbloonbutton = new JButton();
	
	int pinkloonstate = 0;
	int pinkcost;
	JButton pinkloonbutton = new JButton();
	
	int orangebloonstate = 0;
	int orangecost;
	JButton orangebloonbutton = new JButton();
	
	
	String name = "Kein Name";
	
	public double scoreMethod() {
		double d = score;
		return d;
	}	
	
	public Game(int returnsize, String gameName, double version, String madeBy) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{

  
 
	panel = new customPanel(ImageIO.read(new File("./resources/bloon.png")));
	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

	//
	
	GameInfo info = new GameInfo();
	


    
		//Fenster Einstellungen
		setTitle(gameName +  " | Version: " + version);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Framesize = returnsize;
	    Framesize = (Framesize + 6)*100;
	    setSize(Framesize,Framesize);	
		
	    getWidth = getWidth();
	    getHeight = getHeight();
	    
	    setLocationRelativeTo(null);
	    
	    int middle = getWidth()/2-(bwidth/2); 
		
		//Layout wird auf null gesetzt
	    add(shopPanel);
	    add(playpanel);
	    add(panel);
	    add(skinPanel);
	    
	    Object allPanels = new panelSettings().settings(panel,playpanel,shopPanel,skinPanel);
	    
	    //Button 0 Ist nur ein Text! Ist ein Button ohne alles!
	    button[0] = new JButton(logo);
	    button[1] = new JButton("Play");
	    button[1].setBackground(Color.black);
	    button[2] = new JButton("Changelog");	
	    button[2].setBackground(Color.black);
	    button[3] = new JButton("Exit");
	    button[3].setBackground(Color.black);
	    button[7] = new JButton(); 
	    button[7].setBackground(Color.black);
	    button[10] = new JButton();
	    button[10].setBackground(Color.black);
        button[11] = new JButton(settings);
	    button[11].setBackground(Color.black);
        button[12] = new JButton("Credits");
	    button[12].setBackground(Color.black);
             
	    
        //Labels werden erstellt  
        label[0] = new JLabel();
        resetScore();
	    label[1] = new JLabel();
	    label[1].setText("<html>"+"<br> <a color=black> USER: "+ "<a color=red>" + name + "</html>");
	    label[2] = new JLabel(html0 + "MISSIONS <br>Coming Soon!" + html1);
	    label[3] = new JLabel(html0 + "" + html1);
	    
	    label[4] = new JLabel(shop);
	    label[4].setBounds(titleLength/5, titleHeigth/5-40, titleLength, getHeight()/5);
	    
	    label[5] = new JLabel("Current Score: "+score);
	    label[5].setBounds(titleLength+titleLength, titleHeigth/5-40, titleLength, getHeight()/5);
	    //SIZES AND SETTINGS OF BUTTONS & LABELS
	    
	    //ALL LOGOS
	    Object homeButton = new TextSettings().logoSize(button[0], getWidth, bwidth, getHeight, bheight, logo);

	    //Home Screen
	    Object homeScreen = new ButtonPosition().homeScreen(getWidth,bwidth,getHeight,bheight,middle,button[1],button[2],button[3],button[7],button[10],button[11],button[12],label[3],save);
	    
	    //Play Screen
	    Object playScreen = new ButtonPosition().playScreen();
	    
        
	    
	    
        //PRESS BUTTON
	    button[4] = new JButton(bloon);
        button[4].setBorderPainted(false); 
	    button[4].setContentAreaFilled(false); 
	    button[4].setFocusPainted(false); 
	    button[4].setRolloverEnabled(true);
	    button[4].setBounds(middle, getHeight()/4, bwidth, bheight*4);
	    button[4].setFocusable(false);
	    button[4].setFocusCycleRoot(false);
	    button[4].setFocusPainted(false);
	   
	    button[5] = new JButton();    
	    resetBoost();
		button[5].setBounds(middle, getHeight()/2+(bwidth/5), bwidth, bheight);
	    button[5].setBackground(Color.black);
	    button[5].setFocusable(false);
	    
	    button[6] = new JButton();    
		button[6].setBounds(middle, getHeight()/2+(bwidth/2), bwidth, bheight);
		button[6].setBackground(Color.black);
		
	    button[8] = new JButton("Bloon Store WIP");    
		button[8].setBounds(middle, getHeight()/2+(bwidth), bwidth, bheight);
		button[8].setBackground(Color.black);
		
	    button[9] = new JButton("Select Skin");    
	    button[9].setBounds(middle, getHeight()/2+(bwidth+bheight), bwidth, bheight);
		button[9].setBackground(Color.black);
		
	    autoClickThread autoClick = new autoClickThread();
	    updateObjects autoUpdate = new updateObjects();
	    autoUpdate.start();
	    autoClick.start();
		Object game = game(button[0],button[1], button[2], button[3], button[4], button[5], button[6], button[7], button[8], button[9], button[10], button[11],button[12], label[0], label[1], label[2],label[3], boost, middle);	
		
		Object updateButtons  = updateUpgradeButtons();
		int setFocus = 0;
		
		do {			
		    button[setFocus].setFocusable(false);
		    button[setFocus].setFocusCycleRoot(false);
		    button[setFocus].setFocusPainted(false);
		    setFocus++;
		}	while(setFocus<13);
		
		setVisible(true);

	}


	private Object calculateUp() {
		System.out.print(checkAutoClick);
		if(checkAutoClick==1) {
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			            	
			            }
			        }, 
			        50
			);
			resetScore();
		}
		return null;
	}
	public Game(int scoreOverall) {
	
	return;
	}

	private String game(
		JButton home, JButton play, JButton changelog, JButton exit, JButton press, JButton upgradeb, JButton upgradem, JButton load, JButton shop,JButton skins, 
		JButton save, JButton settings, JButton credits, JLabel al, JLabel version, JLabel missions, JLabel textHover,
		int middle, int boosting) {
	
		            
		
		getContentPane().add(panel);
		
		middle = getWidth()/2-(bwidth/2);
		
		al.setBounds(middle, getHeight()/6, bwidth, bheight+20);	
		version.setBounds(10, getHeight()-(bheight*2), bwidth, bheight);	
		missions.setBounds(middle*2, getHeight()/6, bwidth, bheight+20);
		missions.setFont(new Font("Sans", Font.BOLD,20));
		
		//JButtons
		panel.add(home);
		panel.add(play);
		panel.add(changelog);
		panel.add(load);
		panel.add(exit);
		panel.add(save);
        panel.add(settings);
        panel.add(credits);
        panel.add(textHover);
        
		//JLabel
		panel.add(version);
		panel.setVisible(true);

		version.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            System.out.print(name);
            name = JOptionPane.showInputDialog("Bitte wählen Sie einen Namen");
			checkName(name);
            label[1].setText("<html>"+"<br> <a color=black> USER: "+ "<a color=red>" + name + "</html>");
            }

        });
		label[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	getContentPane().add(playpanel);
				getContentPane().remove(shopPanel);
				getContentPane().remove(panel);
				shopPanel.setVisible(false);
				playpanel.setVisible(true);
				
				revalidate();
				repaint();
            }

        });
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eventHandler) {
			
				getContentPane().remove(panel);
				getContentPane().add(playpanel);
				playpanel.add(skins);
				playpanel.add(home);
				playpanel.add(shop);
				playpanel.add(press);
				playpanel.add(upgradeb);
				playpanel.add(upgradem);
				playpanel.add(shop);
				playpanel.add(al);
				playpanel.add(version);
				playpanel.add(missions);
				al.setVisible(true);
				playpanel.setVisible(true);
				playpanel.isShowing();
				repaint();
				revalidate();

			}
		});
		press.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int xys = getWidth()/2-(bwidth/2);
				score=score+boost;
				//before
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	//after
				            }
				        }, 
				        50
				);
				resetScore();
			}		
		});

		Object upgradeAutoClick = new Upgrades().autoClick(upgradem);
		Object upgradeBoost = new Upgrades().boost(upgradeb);
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				home.setIcon(logopress);
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				            	home.setIcon(logo);
				            }
				        }, 
				        50
				);
				panel.add(home);
				panel.add(version);
				getContentPane().remove(playpanel);
				add(panel);
				getContentPane().add(panel);
				revalidate();
				panel.repaint();
				playpanel.repaint();
				repaint();
			}					
		});		
		changelog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			

			}					
		});
		
		
		load.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						saveManager=1;
						int SaveManagering = new saveManager().manager(saveManager);
						if(SaveManagering==0) {
						FileInputStream saveFile = new FileInputStream("saveFile.sav");
						ObjectInputStream restore = new ObjectInputStream(saveFile);
						score = (Double) restore.readObject();
						boost = (Integer) restore.readObject();
						name = (String) restore.readObject();						
						bluebloonstate = (Integer) restore.readObject();
						greenloonstate = (Integer) restore.readObject();
						orangebloonstate = (Integer) restore.readObject();
						checkAutoClick = (Double) restore.readObject();
						restore.close();				
						}
					}
				catch(Exception e) {
					
				}
				
				}
			});
			save.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					try {
						saveManager=0;
						int SaveManagering = new saveManager().manager(saveManager);
						if(SaveManagering==0) {
						FileOutputStream saveFile = new FileOutputStream("saveFile.sav");
						ObjectOutputStream saveManager = new ObjectOutputStream(saveFile);
						saveManager.writeObject(score);					
						saveManager.writeObject(boost);
						saveManager.writeObject(name);	 
						saveManager.writeObject(bluebloonstate);
						saveManager.writeObject(greenloonstate);
						saveManager.writeObject(orangebloonstate);
						saveManager.writeObject(checkAutoClick);
						saveManager.close();
						
						}
					}
				catch(Exception e) {
					
				}
				}

			});
		skins.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().add(skinPanel);
				Object skinSelect = new SkinSelect(playpanel,skinPanel,press,bluebloonstate);
		
			}		
			
		});
		shop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().remove(playpanel);
				getContentPane().add(shopPanel);
				shopPanel.setVisible(true);
				revalidate();

				int i=1;

				int scoreOverall = 0;
				
				int checkCloseXY = 0;
					int checkBloonNumber = 0;

					JButton[] button = new JButton[10];


				    label[4].setBounds(titleLength/5, titleHeigth/5-40, titleLength, getHeight()/5);
				    

				    label[5].setBounds(titleLength+titleLength, titleHeigth/5-40, titleLength, getHeight()/5);
				    
				    while(i < 5) {
						button[i] = new JButton("");
						shopPanel.add(button[i]);
						if(i < 4) {
						button[i].setBounds(bwidth*i, titleHeigth/2+50, titleLength/2, getHeight()/5);			
						}else {
						int i2 = 1;
						button[i].setBounds(bwidth*i2, titleHeigth/2+50+(bheight*6), titleLength/2, getHeight()/5);				
						i2++;
						}
						button[i].setBorderPainted(false); 
						button[i].setContentAreaFilled(false); 
						button[i].setFocusPainted(false); 
						button[i].setRolloverEnabled(true);
						button[i].setVerticalTextPosition(SwingConstants.BOTTOM);
						button[i].setHorizontalTextPosition(SwingConstants.CENTER);
						shopPanel.add(label[3]);
						shopPanel.add(label[4]);
						
						if(i==1) {
							button[i].setIcon(bluebloon);
							bluecost = basecost * i;
							button[i].setText("Cost: " + bluecost);	
							bluebloonbutton = button[i];
						}else if(i==2){
							button[i].setIcon(greenbloon);
							greencost = basecost * i;
							button[i].setText("Cost: " + greencost);	
							greenbloonbutton = button[i];
						}else if(i==3) {
							button[i].setIcon(orangebloon);
							orangecost = basecost * i;
							orangebloonbutton = button[i];
							button[i].setText("Cost: " + orangecost);	
						}else if(i==4) {
							button[i].setIcon(pinkbloon);
							pinkcost = basecost * i;
							pinkloonbutton = button[i];
							button[i].setText("Cost: " + pinkcost);	
						}
						i++;
						}
					
					bluebloonbutton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(bluebloonstate==0) {
								String[] sizeselect = {"Ja", "Nein"};
						        int returnsize = JOptionPane.showOptionDialog(null, "Wollen Sie den Blauen Bloon Kaufen?",
						                "Kaufbestï¿½tigung",
						                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect, sizeselect[0]);	
						        if(returnsize==0) {
						        if(score>bluecost) {
						        	bluebloonstate=1;
						        	score=score-bluecost;
						        }else if(score<bluecost) {
						        	JOptionPane.showMessageDialog(null, "Nicht genug Punkte!");
						        }
						    	}
						        }
						        if(bluebloonstate==1) {
									String[] sizeselect1 = {"Ja", "Nein"};
							        int returnsize1 = JOptionPane.showOptionDialog(null, "Wollen Sie den Blauen Bloon aktivieren?",
							                "Auswahl",
							                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect1, sizeselect1[0]);	
							        if(returnsize1==0) {
							        	press.setIcon(bluebloon);
							        }else {
							        	JOptionPane.showMessageDialog(null, "Vorgang abbrechen");
							        }
						        }
						

						
						}			
						
					});
					greenbloonbutton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(greenloonstate==0) {
								String[] sizeselect = {"Ja", "Nein"};
						        int returnsize = JOptionPane.showOptionDialog(null, "Wollen Sie den Grï¿½nen Bloon Kaufen?",
						                "Kaufbestï¿½tigung",
						                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect, sizeselect[0]);	
						        if(returnsize==0) {
						        if(score>greencost) {
						        	greenloonstate=1;
						        	score=score-greencost;
						        }else if(score<greencost) {
						        	JOptionPane.showMessageDialog(null, "Nicht genug Punkte!");
						        }
						    	}
						        }
						        if(greenloonstate==1) {
									String[] sizeselect1 = {"Ja", "Nein"};
							        int returnsize1 = JOptionPane.showOptionDialog(null, "Wollen Sie den Grï¿½nen Bloon aktivieren?",
							                "Auswahl",
							                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect1, sizeselect1[0]);	
							        if(returnsize1==0) {
							        	press.setIcon(greenbloon);
							        }else {
							        	JOptionPane.showMessageDialog(null, "Vorgang abbrechen");
							        }
						        }
						
						}								
					});

					orangebloonbutton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(orangebloonstate==0) {
								String[] sizeselect = {"Ja", "Nein"};
						        int returnsize = JOptionPane.showOptionDialog(null, "Wollen Sie den Orangenen Bloon Kaufen?",
						                "Kaufbestï¿½tigung",
						                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect, sizeselect[0]);	
						        if(returnsize==0) {
						        if(score>orangecost) {
						        	orangebloonstate=1;
						        	score=score-orangecost;
						        }else if(score<orangecost) {
						        	JOptionPane.showMessageDialog(null, "Nicht genug Punkte!");
						        }
						    	}
						        }
						        if(orangebloonstate==1) {
									String[] sizeselect1 = {"Ja", "Nein"};
							        int returnsize1 = JOptionPane.showOptionDialog(null, "Wollen Sie den Orangenen Bloon aktivieren?",
							                "Auswahl",
							                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect1, sizeselect1[0]);	
							        if(returnsize1==0) {
							        	press.setIcon(orangebloon);
							        }else {
							        	JOptionPane.showMessageDialog(null, "Vorgang abbrechen");
							        }
						        }
					
						}		
						
					});
					pinkloonbutton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(pinkloonstate==0) {
								String[] sizeselect = {"Ja", "Nein"};
						        int returnsize = JOptionPane.showOptionDialog(null, "Wollen Sie den Pinken Bloon Kaufen?",
						                "Kaufbestï¿½tigung",
						                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect, sizeselect[0]);	
						        if(returnsize==0) {
						        if(score>pinkcost) {
						        	pinkloonstate=1;
						        	score=score-pinkcost;
						        }else if(score<pinkcost) {
						        	JOptionPane.showMessageDialog(null, "Nicht genug Punkte!");
						        }
						    	}
						        }
						        if(pinkloonstate==1) {
									String[] sizeselect1 = {"Ja", "Nein"};
							        int returnsize1 = JOptionPane.showOptionDialog(null, "Wollen Sie den Pinken Bloon aktivieren?",
							                "Auswahl",
							                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, sizeselect1, sizeselect1[0]);	
							        if(returnsize1==0) {
							        	press.setIcon(pinkbloon);
							        }else {
							        	JOptionPane.showMessageDialog(null, "Vorgang abbrechen");
							        }
						        }
					
						}		
						
					});

			}	
		});

		return black;	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	void resetScore() {
		try {
		   label[0].setText(html0 + "SCORE: " + score + "<br>Derzeitiger Boost: " + boost);
		}catch(Exception e) {
			
		}
		try {
			
			}catch(Exception e) {
				
			}
	}	
	void resetBoost() {
	   	button[5].setText("Upgrade x" + boost + " ("+upgrade*boost+"P)");
	}	

	public static Object updateUpgradeButtons() {
		  double a = Upgrades.autoClickCost*checkAutoClick;
		  label[0].setText(html0 + "SCORE: " + score + "<br>Derzeitiger Boost: " + boost);
		  label[4].setText("Current Score: " +score);
		  button[5].setText("Upgrade x" + boost + " ("+upgrade*boost+"P)");
		  button[6].setText("AutoClicker " + "x"+ (checkAutoClick*2)+" "+"("+a+"P)");
		return null;
	}
	private void checkName(String name) {
		if(name=="null") {
			name="Keine Angabe";			
		}
	}

   }

