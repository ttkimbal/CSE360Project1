import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Tutor extends JPanel
{
    int state;

    public Tutor()
    {
        state = 0;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(new JLabel("Jared Nathenson"), c);
    }

    public void changeState(int state2)
    {

    }
}