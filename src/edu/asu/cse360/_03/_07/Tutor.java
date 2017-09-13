/**
Description: This class extends JPanel by loading HTML files that
			 change based on JSlider position.
CSE 360 Project 1
Completion time: 2 hours
@author Jared Nathenson
@version 1.0
*/

package edu.asu.cse360._03._07;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Tutor extends JPanel
{
	// Declaring class variables
    int state;
    JEditorPane eP;
    
    public Tutor()
    {
		// Setting up initial state of Tutor
        state = 0;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(new JLabel("Jared Nathenson"), c);

		// Setting up editor pane for HTML
		eP = new JEditorPane();
        eP.setEditorKit(new HTMLEditorKit());
    }

    public void changeState(int status)
    {
		// Clean panel
    	removeAll();

		// Create file name
    	String filename = "resources/P" + status + ".html";

    	FileReader r = null;
		try {
			r = new FileReader(filename);
			// If the file exists
			if(r != null) {
				try {
					eP.read(r, filename);	
					
				}
				// Check to see if the file can be read (all characters are valid)
				catch (IOException | NullPointerException e) { 
					System.out.println("The webpage " + filename + " was found but cannot be displayed.");	
				}		    	
		    }
		}
		// Check to see if the file exists
		catch (FileNotFoundException e ) { 
			System.out.println("The webpage " + filename + " could not be loaded.");
			eP.setText("The webpage could not be displayed");
		}

		// Add EditorPane to Tutor
		add(eP);
    }
}