import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.URL;

public class Companion extends JPanel
{
    int state;
    private BufferedImage img;
    private String path;

    public Companion()
    {
        state = 0;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(new JLabel("Team Effort"), c);
    }

    public void changeState(int status)
    {
    	removeAll();
    	switch (status) {
    	case 1: path = "resources/happy.png";
    			break;
    	case 2: path = "resources/sorry.png";
    			break;
    	case 3: path = "resources/thinking.png";
    			break;
    	case 4: path = "resources/worry.png";
    			break;
    	}
    	
    	try {
    		img = ImageIO.read(new File(path));
    	} catch (IOException e) {
    		System.out.println("The image " + path + " could not be loaded.");
    	}
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	if(img != null) {
    		g.drawImage(img, (this.getWidth())/4, (this.getWidth())/8, null);
    	}
    }
    
}