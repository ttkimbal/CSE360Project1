/**
Description: This class extends JPanel by adding images that change
			 based on JSlider position. Uses threads to animate the images.
CSE 360 Project 1
Completion time: 2 hour
@author Team Effort, Jared Nathenson
@version 1.1
*/

package edu.asu.cse360._03._07;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import javafx.animation.AnimationTimer;

import java.io.*;
import java.net.URL;

public class Companion extends JPanel implements Runnable
{
	// Declaring class variables
	int state, cF = 0; //cF = currentFrame in the animation
	protected ImageIcon[] images;
	protected String mood;
	private Thread th;

    public Companion()
    {
		// Setting up initial state of Companion
        state = 0;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(new JLabel("Team Effort"), c);
        th = new Thread(this); //creates new thread with current class thread as target
        th.start();
    }
    
    public void changeState(int status)
    {
		// Clean panel
    	removeAll();
    	
    	switch (status) {
    	case 1 : mood = "happy"; break;
    	case 2 : mood = "sorry"; break;
    	case 3 : mood = "thinking"; break;
    	case 4 : mood = "worry"; break;
    	}
    	
    	images = new ImageIcon[4]; //Initialize array and load images
    	for(int i = 0; i <= 3; i ++) {
				images[i] = new ImageIcon("resources/" + mood + i + ".png");
    	} 	
}
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	cF++; //Increment current frame in the sequence
    	if(cF > 3) cF = 0; //if at final image, begin again at first image
    	
    	if(images != null)
    		images[cF].paintIcon(this, g, 0, 0);
    }
    
    public void run() {
    	while(Thread.currentThread() == th) //thread is running
    	try {
    		repaint();
    		Thread.sleep(250); //wait 250 milliseconds between each repaint
    	} catch (InterruptedException e) {
    		System.out.println("Something interrupted the animation thread.");
    	}
    }
}