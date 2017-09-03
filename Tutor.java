import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.HTMLEditorKit;

import java.io.*;

public class Tutor extends JPanel
{
    int state;
    JLabel name  = new JLabel("Jared Nathenson");
    JEditorPane ep = new JEditorPane();
    

    public Tutor()
    {
        state = 0;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(name, c);
        ep.setEditorKit(new HTMLEditorKit());
 
    }

    public void changeState(int status)
    {
    	remove(name);
    	String filename = "P" + status + ".html";
    	FileReader r = null;
		try {
			r = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			ep.read(r, filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	add(ep); 	
    }
}
