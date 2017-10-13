/**
Description: This class extends JPanel and implements ActionListener
			 by adding different question types that change based
			 on JSlider position.
CSE 360 Project 1
Completion time: 5 hours
@author Zhenyu Bao
@version 1.0
*/

package edu.asu.cse360._03._07;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class Assessor extends JPanel implements ActionListener
{	
	// Declaring class variables
	int state;
    JButton button1, button2, button3, button4, submit, hint;
    JComboBox<String> comboBox;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    JTextField textField;
	JPanel panel;
	GridBagConstraints c;
	String ans1 = "wrong", ans2 = "wrong", ans3 = "wrong", ans4 = "wrong";
	String[] answers, choices, hints;
	Lesson lesson = null;
	JLabel attemptsLabel;

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
        
    public void changeState(Lesson lesson)
	{
		this.lesson = lesson;
		// Clean panels
    	removeAll();
    	panel.removeAll();
    	setLayout(new BorderLayout());
    	
    	submit = new JButton("Submit");
    	hint = new JButton("Hint");
    	answers = lesson.getAnswers();
    	choices = lesson.getChoices();
    	hints = lesson.getHints();
    	
    	if (lesson.getTypeA() == "button")
		{
    		c.fill = GridBagConstraints.VERTICAL;
			c.weightx = 1;
			c.gridx = 0;
			c.insets = new Insets(0,50,50,0);

			// Initialize button 1 and add to panel
			button1 = new JButton(choices[0]);
			c.gridy = 1;
			panel.add(button1, c);
			button1.addActionListener(this);

			// Initialize button 2 and add to panel
			button2 = new JButton(choices[1]);
			c.gridy = 2;
			panel.add(button2, c);
			button2.addActionListener(this);

			// Initialize button 3 and add to panel
			button3 = new JButton(choices[2]);
			c.gridy = 3;
			panel.add(button3, c);
			button3.addActionListener(this);
			
			// Initialize button 4 and add to panel
			button4 = new JButton(choices[3]);
			c.gridy = 4;
			panel.add(button4, c);
			button4.addActionListener(this);
			
			// Add hint button to panel
			c.gridy = 5;
			panel.add(hint, c);
			hint.addActionListener(this);
			
			// Initialize attemptsLabel and add label to panel
			attemptsLabel = new JLabel("Remaining Attempts: " + (lesson.getAttempts() - lesson.getNumAttempts()));
			add(attemptsLabel, BorderLayout.SOUTH);

			// Add question label and panel to Assessor
			add(new JLabel(lesson.getQuestion()), BorderLayout.NORTH);
			add(panel, BorderLayout.CENTER);
    		
    	}
		else if (lesson.getTypeA() == "dropdown")
		{
    		c.fill = GridBagConstraints.VERTICAL;
			c.weightx = 1;
			c.gridx = 0;
			c.insets = new Insets(0,50,50,0);
			
            comboBox =  new JComboBox<String>(choices);
            c.gridy = 1;
            panel.add(comboBox, c);
			comboBox.addActionListener(this);
			
			c.gridy = 2;
			panel.add(hint, c);
            hint.addActionListener(this);

			// Initialize attemptsLabel and add label to panel
			attemptsLabel = new JLabel("Remaining Attempts: " + (lesson.getAttempts() - lesson.getNumAttempts()));
			add(attemptsLabel, BorderLayout.SOUTH);

			// Add question label and panel to Assessor
        	add(new JLabel(lesson.getQuestion()), BorderLayout.NORTH);
        	add(panel, BorderLayout.CENTER);
    	}
		else if (lesson.getTypeA() == "checkbox")
		{
			// Set GridBagConstraints for correct format
			c.fill = GridBagConstraints.VERTICAL;
			c.weightx = 1;
			c.gridx = 0;
			c.insets = new Insets(0,50,50,0);

			// Initialize check box 1 and add to panel
    		checkBox1 = new JCheckBox(choices[0]);
    		c.gridy = 1;
    		panel.add(checkBox1, c);
			checkBox1.addActionListener(this);

			// Initialize check box 2 and add to panel
    		checkBox2 = new JCheckBox(choices[1]);
    		c.gridy = 2;
    		panel.add(checkBox2, c);
			checkBox2.addActionListener(this);

			// Initialize check box 3 and add to panel
    		checkBox3 = new JCheckBox(choices[2]);
    		c.gridy = 3;
    		panel.add(checkBox3, c);
			checkBox3.addActionListener(this);
			
			checkBox4 = new JCheckBox(choices[3]);
    		c.gridy = 4;
    		panel.add(checkBox4, c);
			checkBox4.addActionListener(this);
			
			c.gridy = 5;
			panel.add(hint, c);
            hint.addActionListener(this);
            
            c.gridy = 6;
            panel.add(submit, c);
            submit.addActionListener(this);

			// Initialize attemptsLabel and add label to panel
			attemptsLabel = new JLabel("Remaining Attempts: " + (lesson.getAttempts() - lesson.getNumAttempts()));
			add(attemptsLabel, BorderLayout.SOUTH);

			// Add question label and panel to Asesssor
            add(new JLabel(lesson.getQuestion()), BorderLayout.NORTH);
            add(panel, BorderLayout.CENTER);
    	}
		else if (lesson.getTypeA() == "jtextfield")
		{
			// Set GridBagConstraints for correct format
			c.weightx = 1;
    		c.gridx = 1;
    		c.gridy = 1;
    		c.fill = GridBagConstraints.HORIZONTAL;
    		c.insets = new Insets(0,50,50,0);

			// Initialize text field and add to panel
    		textField  = new JTextField(100);
    		textField.addActionListener(this);
    		panel.add(textField, c);
    		
    		c.gridy = 2;
    		c.gridx = 1;
    		panel.add(hint, c);
            hint.addActionListener(this);

            c.gridy = 3;
            panel.add(new JLabel("Press Enter to submit your answer. Be careful, once enter is pressed all answers are final."), c);
            submit.addActionListener(this);
            
			// Initialize attemptsLabel and add label to panel
			attemptsLabel = new JLabel("Remaining Attempts: " + (lesson.getAttempts() - lesson.getNumAttempts()));
			add(attemptsLabel, BorderLayout.SOUTH);

			// Add question label and panel to Assessor
    		add(new JLabel(lesson.getQuestion()), BorderLayout.NORTH);
    		add(panel, BorderLayout.CENTER);
    	}
    }

    // Action listener implementation
    public void actionPerformed(ActionEvent e)
	{
    	// Button events
    	if (e.getSource() == button1)
    		checkAnswers("right","wrong","wrong","wrong");
    	else if (e.getSource() == button2)
    		checkAnswers("wrong","right","wrong","wrong");
    	else if (e.getSource() == button3)
    		checkAnswers("wrong","wrong","right","wrong");
    	else if (e.getSource() == button4)
    		checkAnswers("wrong","wrong","wrong","right");
    	
    	// Checkbox events
    	else if (e.getSource() == submit)
		{
    		checkCheckBox(checkBox1.isSelected(), checkBox2.isSelected(), checkBox3.isSelected(),checkBox4.isSelected());
    	}

		// Combo box event
    	else if (e.getSource() == comboBox)
		{
			Object item = comboBox.getSelectedItem();
			checkComboBox(item.toString());
		}

		// Text field event
    	else if (e.getSource() == textField)
		{
			checkTextField(textField.getText());
		}
    	
    	else if (e.getSource() == hint)
		{
    		displayHint(hints);
    	}
	}
    
	public void displayHint(String[] temp)
	{
		String hint = null;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != null) {
				hint = hints[i];
				temp[i] = null;
				break;
			}
		}
		if (hint == null)
		{
			JOptionPane.showMessageDialog(this, "Sorry, you are out of hints.");
			this.lesson.setAnswer(3);
		}
		else
			JOptionPane.showMessageDialog(this, hint);
	}
    
	public void checkCheckBox(boolean a, boolean b, boolean c, boolean d)
	{
		String a1 = "wrong", a2 = "wrong", a3 = "wrong", a4 = "wrong";
		if (a)
			a1 = "right";
		if (b)
			a2 = "right";
		if (c)
			a3 = "right";
		if (d)
			a4 = "right";
		
		checkAnswers(a1,a2,a3,a4);
	}
    
	public void checkComboBox(String a)
	{
		if (this.lesson.getNumAttempts() < this.lesson.getAttempts())
		{
			this.lesson.setNumAttempts(this.lesson.getNumAttempts() + 1);
			boolean cor = false;
			if (a == choices[0] && answers[0] == "right")
				cor = true;
			else if (a == choices[1] && answers[1] == "right")
				cor = true;
			else if (a == choices[2] && answers[2] == "right")
				cor = true;
			else if (a == choices[3] && answers[3] == "right")
				cor = true;
			
			if (cor)
			{
				JOptionPane.showMessageDialog(this, "You chose the correct answer!");
				this.lesson.setAnswer(1);
				attemptsLabel.setText("Answered Correctly.");
				this.lesson.setNumAttempts(this.lesson.getNumAttempts() - 1);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please try again.");
				this.lesson.setAnswer(2);
				attemptsLabel.setText("Remaining Attempts: " + (lesson.getAttempts() - lesson.getNumAttempts()));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Sorry you are out of attempts.");
			this.lesson.setAnswer(3);
		}
	}
    
	public void checkAnswers(String a, String b, String c, String d)
	{
		if (this.lesson.getNumAttempts() < this.lesson.getAttempts())
		{
			this.lesson.setNumAttempts(this.lesson.getNumAttempts() + 1);
			boolean cor = false;
			if (a == answers[0] && b == answers[1] && c == answers[2] && d == answers[3])
				cor = true;
			
			if (cor)
			{
				JOptionPane.showMessageDialog(this, "You chose the correct answer!");
				this.lesson.setAnswer(1);
				attemptsLabel.setText("Answered Correctly.");
				this.lesson.setNumAttempts(this.lesson.getNumAttempts() - 1);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please try again.");
				this.lesson.setAnswer(2);
				attemptsLabel.setText("Remaining Attempts: " + (lesson.getAttempts() - lesson.getNumAttempts()));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Sorry you are out of attempts.");
			this.lesson.setAnswer(3);
		}
	}

	public void checkTextField(String text)
	{
		if (this.lesson.getNumAttempts() < this.lesson.getAttempts())
		{
			this.lesson.setNumAttempts(this.lesson.getNumAttempts() + 1);
			boolean cor = false;

			for (int i = 0; i < this.lesson.getAnswers().length; i++)
			{
				if (this.lesson.getAnswers()[i].equals(text))
					cor = true;
			}

			if (cor)
			{
				JOptionPane.showMessageDialog(this, "You entered the correct answer!");
				this.lesson.setAnswer(1);
				attemptsLabel.setText("Answered Correctly.");
				this.lesson.setNumAttempts(this.lesson.getNumAttempts() - 1);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please try again.");
				this.lesson.setAnswer(2);
				attemptsLabel.setText("Remaining Attempts: " + (lesson.getAttempts() - lesson.getNumAttempts()));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Sorry you are out of attempts.");
			this.lesson.setAnswer(3);
		}
	}
}