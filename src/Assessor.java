/**
Description: This class extends JPanel and implements ActionListener
			 by adding different question types that change based
			 on JSlider position.
CSE 360 Project 1
Completion time: 5 hours
@author Zhenyu Bao
@version 1.0
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.io.*;

public class Assessor extends JPanel implements ActionListener
{	
	// Declaring class variables
	int state;
    JButton button1, button2, button3;
    JComboBox comboBox;
    JCheckBox checkBox1, checkBox2, checkBox3;
    JTextField textField;
	JPanel panel;
	GridBagConstraints c;
	
    public Assessor()
	{
		// Setting up initial state of Assessor
		state = 0;
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		add(new JLabel("Zhenyu Bao"), c);

		// Initializing general use panel for organization
		panel = new JPanel(new GridBagLayout());
    }
        
    public void changeState(int state)
	{
		// Clean panels
    	removeAll();
    	panel.removeAll();
    	setLayout(new BorderLayout());

    	if(state == 1)
		{
			// Initialize combo box and add to panel
    		String[] options = {"Option 1", "Option 2", "Option 3"};
            comboBox =  new JComboBox(options);
            panel.add(comboBox, c);
			comboBox.addActionListener(this);

			// Add question label and panel to Assessor
        	add(new JLabel("Question 1"), BorderLayout.NORTH);
        	add(panel, BorderLayout.CENTER);
        }

    	if(state == 2)
		{
			// Set GridBagConstraints for correct format
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 0;

			// Initialize check box 1 and add to panel
    		checkBox1 = new JCheckBox("Option 1");
    		c.gridy = 1;
    		panel.add(checkBox1, c);
			checkBox1.addActionListener(this);

			// Initialize check box 2 and add to panel
    		checkBox2 = new JCheckBox("Option 2");
    		c.gridy = 2;
    		panel.add(checkBox2, c);
			checkBox2.addActionListener(this);

			// Initialize check box 3 and add to panel
    		checkBox3 = new JCheckBox("Option 3");
    		c.gridy = 3;
    		panel.add(checkBox3, c);
			checkBox3.addActionListener(this);

			// Add question label and panel to Asesssor
            add(new JLabel("Question 2"), BorderLayout.NORTH);
            add(panel, BorderLayout.CENTER);
    	}

    	if(state == 3)
		{
			// Set GridBagConstraints for correct format
			c.fill = GridBagConstraints.VERTICAL;
			c.gridx = 0;

			// Initialize button 1 and add to panel
    		button1 = new JButton("Option 1");
    		c.gridy = 1;
    		panel.add(button1, c);
			button1.addActionListener(this);

			// Initialize button 2 and add to panel
    		button2 = new JButton("Option 2");
    		c.gridy = 2;
    		panel.add(button2, c);
			button2.addActionListener(this);

			// Initialize button 3 and add to panel
    		button3 = new JButton("Option 3");
    		c.gridy = 3;
    		panel.add(button3, c);
            button3.addActionListener(this);
            
			// Add question label and panel to Assessor
            add(new JLabel("Question 3"), BorderLayout.NORTH);
            add(panel, BorderLayout.CENTER);
    	}

    	if(state == 4)
		{
			// Set GridBagConstraints for correct format
			c.weightx = 1;
    		c.gridx = 1;
    		c.fill = GridBagConstraints.HORIZONTAL;
    		c.insets = new Insets(0,50,50,0);

			// Initialize text field and add to panel
    		textField  = new JTextField(100);
    		textField.addActionListener(this);
    		panel.add(textField, c);

			// Add question label and panel to Assessor
    		add(new JLabel("Question 4"), BorderLayout.NORTH);
    		add(panel, BorderLayout.CENTER);
    	}
    }

    // Action listener implementation
    public void actionPerformed(ActionEvent e)
	{
		// Button events
    	if(e.getSource() == button1)
    		JOptionPane.showMessageDialog(this, "Button 1 was pressed.");
    	else if(e.getSource() == button2)
        	JOptionPane.showMessageDialog(this, "Button 2 was pressed.");
    	else if(e.getSource() == button3)
        	JOptionPane.showMessageDialog(this, "Button 3 was pressed.");

		// Checkbox events
    	else if(e.getSource() == checkBox1)
        	JOptionPane.showMessageDialog(this, "Check box 1 was pressed.");
    	else if(e.getSource() == checkBox2)
        	JOptionPane.showMessageDialog(this, "Check box 2 was pressed.");
    	else if(e.getSource() == checkBox3)
        	JOptionPane.showMessageDialog(this, "Check box 3 was pressed.");

		// Combo box event
    	else if(e.getSource() == comboBox)
		{
			item = comboBox.getSelectedItem();
			JOptionPane.showMessageDialog(this, item + " was selected.");
		}

		// Text field event
    	else if(e.getSource() == textField)
        	JOptionPane.showMessageDialog(this, "Text was entered.");
    }
}