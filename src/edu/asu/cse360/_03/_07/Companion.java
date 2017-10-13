/**
Description: This class extends JPanel by adding images that change
			 based on JSlider position. Uses threads to animate the images.
CSE 360 Project 1
Completion time: 3 hours
@author Jared Nathenson, Tristan Kimball
@version 1.2
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
	Lesson lesson;

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
    
    public void changeState(Lesson lesson)
    {
		// Initialize lesson to current lesson
		this.lesson = lesson;

		// Clean panel
    	removeAll();
    	
    	switch (lesson.getAnswer()) {
			case 0: mood = "thinking"; break;
			case 1: mood = "happy"; break;
			case 2: mood = "worry"; break;
    		case 3: mood = "sorry"; break;
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
    	if(cF > 3)
		{
			cF = 0; //if at final image, begin again at first image
		}
    	
    	if(images != null)
    		images[cF].paintIcon(this, g, 0, 0);
    }
    
    public void run() {
    	while(Thread.currentThread() == th) //thread is running
    	try {
			// If lesson isn't null then update the state with current lesson answer status
			if (this.lesson != null)
				changeState(this.lesson);
    		repaint();
    		Thread.sleep(250); //wait 250 milliseconds between each repaint
    	} catch (InterruptedException e) {
    		System.out.println("Something interrupted the animation thread.");
    	}
    }
}