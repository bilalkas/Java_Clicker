package main;

import java.awt.Image;
import java.awt.SplashScreen;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import gameplay.Game;
import gameplay.settings.panelSettings;

public class Main {

	double version;
	static String getvalue = "";
	static String getname = "";
	int value;
	int checkStart = 0;

	public Main() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, IOException {

		List<Image> icons = new ArrayList<Image>();
		icons.add(getImage("../resources/cookie.png"));
		icons.add(getImage("../resources/cookie.png"));

		if (checkStart == 0) {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			if (1 == -1) {
				JOptionPane.showMessageDialog(null,
						"<html>Keine Eingabe! Gr��enverh�ltnis wurde auf <a color=red>600<a color=black>x<a color=red>600 <a color=black>gesetzt!</html>");
			}

			System.out.println("correct");

			checkStart = 1;
			JFrame frame;
			// Game Informationen
			String madeBy = new GameInfo().madeBy();
			String gameName = new GameInfo().gameName();
			double version = new GameInfo().version();

			frame = new Game(1, gameName, version, madeBy);

			frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./resources/cookie.png"));
		} else {
			System.out.print("Programm wurde bereits gestartet");
		}
	}

	private Image getImage(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, IOException {

		Object a = new Main();

	}

}
