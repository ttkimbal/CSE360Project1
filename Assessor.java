import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class Assessor extends JPanel/* implements ActionListener*/
{
    int state;

    public Assessor()
    {
        state = 0;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        add(new JLabel("Zhenyu Bao"), c);
    }

    public void changeState(int state2)
    {

    }
}