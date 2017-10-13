/**
Description: Runs the program, manages and organizes content JPanels.
CSE 360 Project 1
Completion time: 5 hours
@author Tristan Kimball
@version 1.0
*/

package edu.asu.cse360._03._07;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Universe extends JFrame
{
    // Declaring class variables
    JFrame frame;
    JSlider slider;
    JPanel sliderPanel, container, authorPanel;
    Tutor tutorPanel;
    Assessor assessorPanel;
    Companion companionPanel;
    
    String[] L1choices = {"Gizmo", "Fang", "Bolt", "Reptar"};
    String[] L2choices = {"ASU", "U of A", "NAU", "GCU"};
    String[] L3choices = {"Blue", "Red", "White", "Black"};
 
    
	String[] L1hints = {"Eliminate wrong answer: The answer is not Bolt.", "Helpful tip: He is a famous movie character you dont want to get wet!"};
	String[] L2hints = {"Helpful Tip: Their colors are Maroon and Gold!"};
	String[] L3hints = {"Identify right answer: Red is a color on the United States flag", "Eliminate wrong answer: Black is not on the United States flag"};
	String[] L4hints = {"Helpful Tip: There literally isn't a wrong answer"};
	
	String[] L1answers = {"right", "wrong", "wrong", "wrong"};
	String[] L2answers = {"right", "wrong", "wrong", "wrong"};
	String[] L3answers = {"right", "right", "right", "wrong"};
    String[] L4answers = {"blue", "red", "green", "yellow", "orange", "purple", "indigo", "violet", "cyan", "turqouise", "white", "black"};
	Lesson lesson;
	
	Lesson L1 = new Lesson(
			"P1.html",
			"button",
			"What is my dogs name?",
			3,
			L1choices,
			L1hints,
			L1answers
			);
	Lesson L2 = new Lesson(
			"P2.html",
			"dropdown",
			"Which college are we completing this class for?",
			3,
			L2choices,
			L2hints,
			L2answers
			);
	Lesson L3 = new Lesson(
			"P3.html",
			"checkbox",
			"Select all colors on the United States Flag",
			3,
			L3choices,
			L3hints,
			L3answers
			);
	Lesson L4 = new Lesson(
			"P4.html",
			"jtextfield",
			"What is your favorite color?",
			1,
			null,
			L4hints,
			L4answers
			);

    public Universe()
    {
        // Setting up Universe
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1560,1080);

        // Setting up JSlider
        slider = new JSlider(JSlider.HORIZONTAL, 1, 4, 1);
        SliderListener sL = new SliderListener();
        slider.addChangeListener(sL);

        // Setting up JPanel for JSlider for layout
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new BorderLayout());
        sliderPanel.add(slider, BorderLayout.CENTER);

        // Setting up content JPanels
        tutorPanel = new Tutor();
        assessorPanel = new Assessor();
        companionPanel = new Companion();

        // Creating JPanels to display author names for initial state
        GridBagConstraints c = new GridBagConstraints();
        authorPanel = new JPanel(new GridBagLayout());
        authorPanel.add(new JLabel("Tristan Kimball"), c);

        // Setting up container JPanel for layout
        container = new JPanel();
        container.setLayout(new GridLayout(2,2, 20, 20));

        // Adding initial JPanel to container for organization
        container.add(companionPanel);
        container.add(tutorPanel);
        container.add(assessorPanel);
        container.add(authorPanel);
 

        // Adding container and sliderPanel to Universe and finishing setup
        add(container, BorderLayout.CENTER);
        add(sliderPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public class SliderListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            JSlider src = (JSlider)e.getSource();
       
            if (container.getComponentCount() > 3)
                container.remove(authorPanel);

            // If the slider is not moving
            if (!src.getValueIsAdjusting())
            {
                // Notify panels of state change
                int value = src.getValue();
                switch(value) {
                	case 1 : lesson = L1;
                			    break;
                	case 2 : lesson = L2;
                				break;
                	case 3 : lesson = L3;
                				break;
                	case 4 : lesson = L4;
                				break;
                	default:
                				break;
                }
        
                tutorPanel.changeState(lesson);
                assessorPanel.changeState(lesson);
                companionPanel.changeState(lesson);

                // Debugging console output
                System.out.println("Slider changed to state " + value + ".");

                // Refresh container and frame
                container.revalidate();
                container.repaint();
            }
        }
    }

    public static void main(String[] args)
    {
        // Create the universe
        Universe universe = new Universe();
    }
}