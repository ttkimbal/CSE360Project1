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

    public Universe()
    {
        // Setting up JFrame
        frame = new JFrame("GoodTutor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1560, 1080));

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

        // Adding container and sliderPanel to JFrame and finishing setup
        frame.getContentPane().add(container, BorderLayout.CENTER);
        frame.getContentPane().add(sliderPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
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
                tutorPanel.changeState(value);
                assessorPanel.changeState(value);
                companionPanel.changeState(value);

                // Debugging console output
                System.out.println("Slider changed to state " + value + ".");

                // Refresh container and frame
                container.revalidate();
                container.repaint();
                frame.pack();
            }
        }
    }

    public static void main(String[] args)
    {
        // Create the universe
        Universe universe = new Universe();
    }
}