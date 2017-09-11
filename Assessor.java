import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

import java.io.*;

public class Assessor extends JFrame implements ActionListener{	
	int state;
	JFrame frame = new JFrame("Assessor");
	JPanel jp1, jp2, jp3, jp4, dia;
    JLabel Question1, Question2, Question3, Question4, label;
    JButton Op1JB, Op2JB, Op3JB;
    JComboBox JCB;
    JCheckBox Op1CB, Op2CB, Op3CB;
    JDialog jDialog1 = new JDialog(frame, "Dialog", true);
    JTextArea QuestionsText = new JTextArea(5,20); 
	
    public void Assessor(int state) {
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.FlowLayout());
	    frame.setSize(300, 250); 
	    
    	jp1 = new JPanel();							// to create 4 JPanels 
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        
        Question1 = new JLabel("Question1");					// to set 4 questions and label by Label text
        Question2 = new JLabel("Question2");
        Question3 = new JLabel("Question3");
        Question4 = new JLabel("Question4");
        
        String[] Options = {"TOM", "BOB", "HAM"};			// 3 options by JComBox for question1
        JCB =  new JComboBox(Options);
        
        Op1CB = new JCheckBox("11");					// 3 options by CheakBox for question2
        Op2CB = new JCheckBox("22");
        Op3CB = new JCheckBox("33");
        
        Op1JB = new JButton("A");					// 3 options by JButton for question3
        Op2JB = new JButton("B");
        Op3JB = new JButton("C");
        
        Op1JB.addActionListener(this);
        Op2JB.addActionListener(this);
        Op3JB.addActionListener(this);

      //------------------------------------------------------------------------------
        if(state == 1) {
        	GridLayout layout1 = new GridLayout(4,1);	// set up jp1
        	jp1.setLayout(layout1);
        	jp1.add(Question1);
        	jp1.add(JCB);
        	frame.add(jp1);
        }
        else if(state == 2) {
        GridLayout layout2 = new GridLayout(4,1);	// set up jp2
        	jp2.setLayout(layout2);
        	jp2.add(Question2);
        	jp2.add(Op1CB);
        	jp2.add(Op2CB);
        	jp2.add(Op3CB);
        	frame.add(jp2);
        }
        else if(state == 3) {
        	GridLayout layout3 = new GridLayout(4,1);	// set up jp3
        	jp3.setLayout(layout3);
        	jp3.add(Question3);
        	jp3.add(Op1JB);
        	jp3.add(Op2JB);
        	jp3.add(Op3JB);
        	frame.add(jp3);
        }
        else if(state == 4) {
        	GridLayout layout4 = new GridLayout(2,1);	// set up jp4
        	jp4.setLayout(layout4);
        	jp4.add(Question4);
        	jp4.add(QuestionsText);
        	frame.add(jp4);
        }
        else if(state == 0) {
        	frame.setLayout(new GridLayout(2,1));
            GridBagConstraints c = new GridBagConstraints();
            frame.add(new JLabel("Zhenyu Bao"), c);
        }
    }
        
    public void show() {
        frame.setVisible(true);
    }
 
    public void changeState(int state) {
    	if(state == 0) {
    		Assessor(0);
    	}
    	if(state == 1) {
    		Assessor(1);
    	}
    	if(state == 2) {
    		Assessor(2);
    	}
    	if(state == 3) {
    		Assessor(3);
    	}
    	if(state == 4) {
    		Assessor(4);
    	}
    }


    /* listener for Jbutton */
    public void actionPerformed(ActionEvent e){
         if(e.getActionCommand().equals("A")){
        	 WrongDialog Jb1 = new WrongDialog(this);
         }
         else if(e.getActionCommand().equals("B")){
        	 WrongDialog Jb2 = new WrongDialog(this);
         }
         else if(e.getActionCommand().equals("C")){
        	 RightDialog Jb3 = new RightDialog(this);
         }         
    }
    
    /* Listener FOR right chose*/
    class RightDialog implements ActionListener{
         JDialog jDialog1=null; 						//create new null dialog
         RightDialog(JFrame jFrame){
            jDialog1=new JDialog(jFrame,"Dialog",true);	//set dialog
         
            JButton jButton1=new JButton("close");
            jButton1.addActionListener(this);
            
            GridLayout layout5 = new GridLayout(2,1);	//
            jDialog1.setLayout(layout5);
            jDialog1.add(new JLabel("This anwer is right~"));
            jDialog1.add(jButton1);
    
            jDialog1.setSize(80,80);					//set size
            jDialog1.setLocation(450,450);
            jDialog1.setVisible(true);
          }
    
          public void actionPerformed(ActionEvent e){
             if(e.getActionCommand().equals("close")){
                jDialog1.dispose();
             }
          }
       }

    class WrongDialog implements ActionListener{
        JDialog jDialog1=null; 						//create new null dialog
        WrongDialog(JFrame jFrame){
           jDialog1=new JDialog(jFrame,"Dialog",true);	//set dialog
        
           JButton jButton1=new JButton("close");
           jButton1.addActionListener(this);
           
           GridLayout layout5 = new GridLayout(2,1);	//
           jDialog1.setLayout(layout5);
           jDialog1.add(new JLabel("Sorry, it's wrong"));
           jDialog1.add(jButton1);
   
           jDialog1.setSize(80,80);					//set size
           jDialog1.setLocation(450,450);
           jDialog1.setVisible(true);
         }
   
         public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("close")){
               jDialog1.dispose();
            }
         }
    }
}
