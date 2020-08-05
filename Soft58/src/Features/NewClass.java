/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Features;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import java.awt.Button;
import java.awt.Color;
import soft58.*;
import Help.*;
import Homepage.Homepage;
import Testimonial.*;
import Members.*;
import Profile.Profile;
//import Profile.Profile;
import Tutorials.Tutorials;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class NewClass implements ActionListener
{
   //JFrame f1=new JFrame();
JPanel jp1;
JLabel l1;
static JTable table;
String[] columnNames = {"Course ID", "Course Name", "Duration"};
JScrollPane scroll;
JFrame f1 = new JFrame("Database Search Result");
Container con=f1.getContentPane();
DefaultTableModel model = new DefaultTableModel();
String Cid = "";
String Cname = "";
String Duration = "";
JButton b1,b2;
int id;
public void course(int x)
{
 id=x;
 
 jp1=new JPanel();   
 jp1.setBounds(0, 0, 600, 400);
 jp1.setBackground(new Color(232, 234, 143));
 f1.add(jp1);
 
 l1=new JLabel("Course Contents");
 l1.setBounds(10, 20, 100, 30);
 jp1.add(l1);
 
 b1=new JButton("Join");
 b1.setBounds(280, 700, 100, 30);
 jp1.add(b1);
 b1.addActionListener(this);

 model.setColumnIdentifiers(columnNames);
table = new JTable();
table.setModel(model);
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
scroll = new JScrollPane(table);
scroll.setBounds(50, 50, 400, 100);
scroll.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scroll.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
 
 try
 {
   Class.forName("com.mysql.jdbc.Driver");
   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");  
   Statement st=conn.createStatement();
   String str="select * from Course where ID='"+id+"'";
   PreparedStatement ps=conn.prepareStatement(str);
   ResultSet rs=ps.executeQuery();
   int i = 0;
   while (rs.next()) 
   {
   Cid = rs.getString(1);
   Cname = rs.getString(2);
   Duration = rs.getString(3);
   model.addRow(new Object[]{Cid, Cname, Duration});
   i++;
   }

    if (i < 1) 
    {
        JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
    }
    

  } 
 catch (Exception ea) 
 {
        JOptionPane.showMessageDialog(null, ea);
 }
    jp1.add(scroll);
//f1.add(scroll);
f1.setVisible(true);
f1.setSize(600, 700);
f1.setLocation(400, 100);
con.setBackground(new Color(232, 234, 143));
f1.setResizable(false);
}  
public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==b1)
 {
     JoinForm ob=new JoinForm();
     ob.join();
 }
}
 
}

