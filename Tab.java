import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


import java.io.*;


import java.awt.event.*;

import java.util.*;
public class Tab implements ActionListener
{
	JFrame f;
	JTabbedPane tb;
	JComponent c1;
	JComponent gen;
	JTextArea a;
  int counter=1;
	JMenuBar mb;
	JMenu file,search,settings;
	JMenuItem open,New,saveas;
	public Tab()
	{
		f=new JFrame("pane");

		tb=new JTabbedPane();
		c1=makeTextPanel();
		
		//c1.add(a1);
		tb.addTab("tab1",c1);
		//c2=makeTextPanel();
		//a2=new JTextArea(20,20);
		//c2.add(a2);
		//tb.addTab("tab2",c2);

       mb=new JMenuBar();
       file=new JMenu("file");
		search=new JMenu("search");
	     settings=new JMenu("settings");
		 open=new JMenuItem("open");
		 New=new JMenuItem("new");
		 New.addActionListener(this);
		 saveas=new JMenuItem("Save as");
		 file.add(saveas);
		 file.add(open);
		 file.add(New);
	
		file.setMnemonic(KeyEvent.VK_F);
		search.setMnemonic(KeyEvent.VK_S);
		settings.setMnemonic(KeyEvent.VK_T);
		
		mb.add(file);
		mb.add(search);
		mb.add(settings);
		f.setJMenuBar(mb);

		f.add(tb);

		f.setSize(600,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
			}
		public void actionPerformed(ActionEvent e)
		{
          gen=makeTextPanel();
          counter++;
          tb.addTab("tab"+counter,gen);


		}

	protected JComponent makeTextPanel() {
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel();
    filler.setHorizontalAlignment(JLabel.CENTER);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(filler);
    a=new JTextArea(20,20);
    panel.add(a);
    return panel;
}
	public static void main(String s[])
	{
		new Tab();
	}
}
