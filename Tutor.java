import java.awt.*;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

import java.io.*;

public class Tutor extends JPanel
{
    int state;
    JLabel name  = new JLabel("Jared Nathenson");
    JEditorPane ep = new JEditorPane();
    

    public Tutor()
    {
        state = 0; //default state to display author's name
        //basic layout for each element in universe.java
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(name, c); //initalizing the pane to display the authors name
        ep.setEditorKit(new HTMLEditorKit()); //Setting the editor Pane to HTML
 
    }

    public void changeState(int status)
    {
    	remove(name); //if slider is at any state remove authors name
    	String filename = "resources/P" + status + ".html"; //creating file name
    	FileReader r = null;
		try {
			r = new FileReader(filename);
			if(r != null) { //If the file exists
				try {
					ep.read(r, filename);	
				} catch (IOException | NullPointerException e) { //checking to see if the file can be read (all characters are valid)
					System.out.println("The webpage " + filename + " was found but there is an issue with displaying it.");	
				}		    	
		    }
		} catch (FileNotFoundException e ) { //checking to see if the file exists
			System.out.println("The webpage " + filename + " could not be loaded.");
			ep.setText("The webpage could not be displayed");
		}
		add(ep); //adding the editorpane to the panel in Universe.java
    }
}