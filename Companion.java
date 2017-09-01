import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Companion extends JPanel
{
    int state;

    public Companion()
    {
        state = 0;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(new JLabel("Jia Gu"), c);
    }

    public void changeState(int state2)
    {

    }
}