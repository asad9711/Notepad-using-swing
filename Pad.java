import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.awt.event.*;
import java.util.*;
public class Pad implements ActionListener
{
	JFrame f;
	JTabbedPane tb;
	JComponent c1;
	JComponent gen;
	JTextArea a;JScrollPane jsp;
  int counter=1;
	JMenuBar mb;
	JMenu file,search,settings;
	JMenuItem open,New,saveas;
	public Pad()
	{
		f=new JFrame("pane");

		tb=new JTabbedPane();
		c1=makeTextPanel();
		
		//c1.add(a1);
		tb.setTabPlacement(SwingConstants.TOP);
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
		 saveas.addActionListener(this);
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

		f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
			}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==saveas)
			{
				//a.setText("save");
				
				CreateTextField ct=new CreateTextField();
				return;

			}
          gen=makeTextPanel();
          counter++;
          tb.addTab("tab"+counter,gen);
		}

protected JComponent makeTextPanel() 
{
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel();
    filler.setHorizontalAlignment(JLabel.CENTER);
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(filler);panel.setBorder(new TitledBorder(new EtchedBorder()));
    a=new JTextArea(20,20);

   jsp= new JScrollPane(a);
    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


    // panel.add(a);
    panel.add(jsp);
   // setBackgroundAt(counter-1,
                           // Color.red);
    return panel;
}
	public static void main(String s[])
	{
		new Pad();
	}
	//second class to create dialog box
	class CreateTextField implements ActionListener
	{
		JFrame f2;
		JTextField tf;
		JButton b,cancel;JLabel l;
        FileWriter fw;
		public CreateTextField()
		{
			f2=new JFrame("save as");
			tf=new JTextField(10);
            tf.setBounds(150,40,200,30);
			b=new JButton("save");
			b.addActionListener(this);
			b.setBounds(100,300,100,20);
			cancel=new JButton("Cancel");
			cancel.addActionListener(this);
			cancel.setBounds(250,300,100,20);
			l=new JLabel();
			l.setText("Enter file name");
			l.setBounds(5,40,120,20);
			f2.add(l);
			f2.add(tf);
			f2.add(b);f2.add(cancel);
			f2.setSize(400,400);
			f2.setLayout(null);
			f2.setVisible(true);


		}
		public void actionPerformed(ActionEvent ae)
		{
		//	String x=tf.getText();
			if(ae.getSource()==b)
			{
          try{ fw=new FileWriter(tf.getText());
            fw.write(a.getText());
            fw.close();
            f2.setVisible(false);
        }catch(Exception e)
        {
        	System.out.println(e);
        }
		}
		else if(ae.getSource()==cancel)
		 {
			f2.setVisible(false);
		 }
	    }
}
}
