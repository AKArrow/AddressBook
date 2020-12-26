import java.awt.*;
import java.awt.print.*;
import javax.swing.*;  
import java.awt.event.*;
import java.io.*;
import java.util.*;
class Address extends Frame implements ActionListener,MenuContainer
{  
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField t2,t3,t4,t5,t6,t7,t8;
	TextArea t1;
	Button b1,b2,b3,b4,b5,b6,b7;
	MenuItem i1,i2,i3,i4,i5,i6,i7;
	Frame f1;
	String fin="",str="";;
	String fname,lname,address,city,state,zip,pno;
	ArrayList<Address> al = new ArrayList<Address>();
	Address(String fname,String lname,String address,String city,String state,String zip,String pno)
	{
		this.fname=fname;
		this.lname=lname;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.pno=pno;
	}
	Address()
	{
		MenuBar mb=new MenuBar();
		Menu menu=new Menu("File");
		i1=new MenuItem("New");  
        i2=new MenuItem("Open");  
        i3=new MenuItem("Close");  
        i4=new MenuItem("Save");  
        i5=new MenuItem("Save As");
		i6=new MenuItem("Print");
		i7=new MenuItem("Quit");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		menu.add(i4);
		menu.add(i5);
		menu.add(i6);
		menu.add(i7);
		mb.add(menu);
		t1 = new TextArea();
		t1.setBounds(25,50,500,300);
		add(t1);
		b1=new Button("Add");  
		b1.setBounds(30,350,80,30);
		add(b1);
		b1.addActionListener(this);
		b2=new Button("Edit");  
		b2.setBounds(130,350,80,30);
		add(b2);
		b2.addActionListener(this);
		b3=new Button("Delete");  
		b3.setBounds(230,350,80,30);
		add(b3);
		b3.addActionListener(this);
		b4=new Button("Sort By Name");  
		b4.setBounds(330,350,80,30);
		add(b4);
		b4.addActionListener(this);
		b5=new Button("Sort By Zip");  
		b5.setBounds(430,350,80,30);
		add(b5);
		b5.addActionListener(this);
		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		i7.addActionListener(this);
		setMenuBar(mb);
		setSize(550,400);  
		setLayout(null); 
		setVisible(true);  
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==i1)
		{
			t1.setText("");
		}
		else if(e.getSource()==i2)
		{
			try
			{
				String s1="";
				JFileChooser file = new JFileChooser();
				file.setMultiSelectionEnabled(true);
				file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				file.setFileHidingEnabled(false);
				if(file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					File f = file.getSelectedFile();
					Scanner sc = new Scanner(f);
					while(sc.hasNextLine())
					{
						s1 =s1+sc.nextLine()+"\n";
					}
					t1.setText(s1);
					fin=file.getSelectedFile().getAbsolutePath();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==i3)
		{
			t1.setText("");
		}
		else if(e.getSource()==i4)
		{
			try
			{
				String s2=t1.getText();
				File f = new File(fin);
				if(f.createNewFile())
				{
					String fn = JOptionPane.showInputDialog("Enter File Name");
					FileWriter fw = new FileWriter(""+f);
					fw.write(""+s2);
					fw.close();
				}
				else
				{
					FileWriter fw = new FileWriter(""+f);
					fw.write(""+s2);
					fw.close();
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==i5)
		{
			try
			{
				String s2=t1.getText();
				JFileChooser j = new JFileChooser();
				int r = j.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION)
				{
					File f = new File(j.getSelectedFile().getAbsolutePath());
					FileWriter fw = new FileWriter(""+f);
					fw.write(""+s2);
					fw.close();	
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==i6)
		{
			PrinterJob pjob = PrinterJob.getPrinterJob();
			PageFormat pf = pjob.defaultPage();
			pjob.setPrintable(null, pf);
			if (pjob.printDialog())
			{
				try
				{
					pjob.print();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
		else if(e.getSource()==i7)
		{
			System.exit(0);
		}
		else if(e.getSource()==b1)
		{
			f1 = new Frame();
			l1 = new Label("Enter First Name");
			l1.setBounds(50,50,100,30);
			f1.add(l1);
			t2 = new TextField();
			t2.setBounds(200,50,100,30);
			f1.add(t2);
			l2 = new Label("Enter Last Name");
			l2.setBounds(50,100,100,30);
			f1.add(l2);
			t3 = new TextField();
			t3.setBounds(200,100,100,30);
			f1.add(t3);
			l3 = new Label("Enter Address");
			l3.setBounds(50,150,100,30);
			f1.add(l3);
			t4 = new TextField();
			t4.setBounds(200,150,100,30);
			f1.add(t4);
			l4 = new Label("Enter City");
			l4.setBounds(50,200,100,30);
			f1.add(l4);
			t5 = new TextField();
			t5.setBounds(200,200,100,30);
			f1.add(t5);
			l5 = new Label("Enter State");
			l5.setBounds(50,250,100,30);
			f1.add(l5);
			t6 = new TextField();
			t6.setBounds(200,250,100,30);
			f1.add(t6);
			l6 = new Label("Enter Zip");
			l6.setBounds(50,300,100,30);
			f1.add(l6);
			t7 = new TextField();
			t7.setBounds(200,300,100,30);
			f1.add(t7);
			l7 = new Label("Enter Phone No");
			l7.setBounds(50,350,100,30);
			f1.add(l7);
			t8 = new TextField();
			t8.setBounds(200,350,100,30);
			f1.add(t8);
			b6 = new Button("Add");
			b6.setBounds(50,400,100,30);
			f1.add(b6);
			b6.addActionListener(this);
			b7 = new Button("Display");
			b7.setBounds(200,400,100,30);
			f1.add(b7);
			b7.addActionListener(this);
			f1.setSize(550,450);  
			f1.setLayout(null); 
			f1.setVisible(true);
		}
		else if(e.getSource()==b6)
		{
			fname=t2.getText();
			lname=t3.getText();
			address=t4.getText();
			city=t5.getText();
			state=t6.getText();
			zip=t7.getText();
			pno=t8.getText();
			Address ad = new Address(fname,lname,address,city,state,zip,pno);
			al.add(ad);
			Iterator it = al.iterator();
			String temp="";
			while(it.hasNext())
			{
				String s2="";
				Address ads = (Address)it.next();
				s2=s2+ads.fname+" "+ads.lname+" "+ads.address+" "+ads.city+" "+ads.state+" "+ads.zip+" "+ads.pno+"\n";
				temp=temp+s2;
			}
			str=temp;
		}
		else if(e.getSource()==b7)
		{
			t1.setText(str);
		}
	}
	public static void main(String args[])
	{  
		new Address();
	}
}  