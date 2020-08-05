/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testimonial;

import Features.Features;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import soft58.*;
import Help.*;
import Homepage.*;
import Members.Members;
import Profile.Profile;
//import Profile.Profile;
import Tutorials.Tutorials;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Testimonial implements ActionListener
{
   JFrame f1=new JFrame();
   Container con=f1.getContentPane();
   JPanel jp1,jp2;
   JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
   ImageIcon img=new ImageIcon("icons8-customer-64.png");
   ImageIcon imgqw=new ImageIcon("logo1.png");
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
   JPopupMenu pop1;
   JTextArea jt1,jt2,jt3,jt4;
   Font fo1,fo2,fo3,fo4;
   String em;
public void testimonial(String email)
{
    em=email;
    fo1=new Font("Times New Roman", Font.BOLD, 22);
    fo2=new Font("Tahoma", Font.PLAIN, 14);
    fo3=new Font("Tahom",Font.PLAIN, 10);
    fo4=new Font("Tahoma", Font.PLAIN, 18);
    
    jp1=new JPanel();
    jp1.setBounds(10, 6, 250, 550);
    jp1.setBackground(new Color(4, 71, 169));
    f1.add(jp1);
    
    jp2=new JPanel();
    jp2.setBounds(1, 1, 248, 80);
    jp2.setBackground(Color.WHITE);
    jp1.add(jp2);
    
    //l7=new JLabel(img);
    //l7.setBounds(40, 20, 40, 40);
    //jp2.add(l7);
    
    
    
    
       try
    {
     Class.forName("com.mysql.jdbc.Driver");
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");
     Statement st=conn.createStatement();
     String str="select * from information where Email='"+em+"'";
     PreparedStatement ps=conn.prepareStatement(str);
     ResultSet rs=ps.executeQuery();
     if(rs.next()) 
           {
    byte[] imagedata = rs.getBytes(11) ;
    Image img10 = Toolkit.getDefaultToolkit().createImage(imagedata);
    ImageIcon icon=new ImageIcon(img10);
    
    b3=new JButton();
    b3.setBounds(10, 10, 80, 60);
    ImageIcon img9=new ImageIcon(icon.getImage().getScaledInstance(b3.getWidth(), b3.getHeight(), Image.SCALE_SMOOTH));
    //b3.setFont(fo4);
    //b3.setBorderPainted(false);
    b3.setIcon(img9);
    //b3.setBackground(new Color(4, 71, 169));
    //b3.setBorder(null);
    //b3.setContentAreaFilled(false);
    //b3.setForeground(Color.BLUE);
    //b3.setDefaultCapable(false);
    jp2.add(b3);
    b3.addActionListener(this);
    
    b3=new JButton("Profile");
    b3.setBounds(70, 25, 100, 30);
    b3.setFont(fo4);
    b3.setBorderPainted(false);
    //b3.setBackground(new Color(4, 71, 169));
    b3.setBorder(null);
    b3.setContentAreaFilled(false);
    b3.setForeground(Color.BLUE);
    b3.setDefaultCapable(false);
    jp2.add(b3);
    b3.addActionListener(this);
           }
    else
     {
    b3=new JButton(img);
    b3.setBounds(10, 1, 80, 80);
    b3.setFont(fo4);
    b3.setBorderPainted(false);
    //b3.setBackground(new Color(4, 71, 169));
    b3.setBorder(null);
    b3.setContentAreaFilled(false);
    b3.setForeground(Color.BLUE);
    b3.setDefaultCapable(false);
    jp2.add(b3);
    b3.addActionListener(this);
    
    b3=new JButton("Profile");
    b3.setBounds(70, 25, 100, 30);
    b3.setFont(fo4);
    b3.setBorderPainted(false);
    //b3.setBackground(new Color(4, 71, 169));
    b3.setBorder(null);
    b3.setContentAreaFilled(false);
    b3.setForeground(Color.BLUE);
    b3.setDefaultCapable(false);
    jp2.add(b3);
    b3.addActionListener(this);
     }
    } 
     catch(Exception ef)
    {
        System.out.println(ef);
    }
    
    
    b1=new JButton("Home");
    b1.setBounds(30, 100, 100, 30);
    b1.setBorderPainted(false);
    b1.setBackground(new Color(4, 71, 169));
    b1.setBorder(null);
    b1.setHorizontalAlignment(SwingConstants.LEFT);
    b1.setContentAreaFilled(false);
    b1.setFont(fo4);
    b1.setForeground(Color.WHITE);
    b1.setDefaultCapable(false);
    jp1.add(b1);
    b1.addActionListener(this);
    
    b2=new JButton("Members");
    b2.setBounds(30, 150, 100, 30);
    b2.setFont(fo4);
    b2.setHorizontalAlignment(SwingConstants.LEFT);
    b2.setBorderPainted(false);
    b2.setBackground(new Color(4, 71, 169));
    b2.setBorder(null);
    b2.setContentAreaFilled(false);
    b2.setForeground(Color.WHITE);
    b2.setDefaultCapable(false);
    jp1.add(b2);
    b2.addActionListener(this);
    
    b4=new JButton("Features");
    b4.setBounds(30, 200, 100, 30);
    b4.setFont(fo4);
    b4.setBorderPainted(false);
    b4.setBackground(new Color(4, 71, 169));
    b4.setHorizontalAlignment(SwingConstants.LEFT);
    b4.setBorder(null);
    b4.setContentAreaFilled(false);
    b4.setForeground(Color.WHITE);
    b4.setDefaultCapable(false);
    jp1.add(b4);
    b4.addActionListener(this);
    
    b5=new JButton("Tutorials");
    b5.setBounds(30, 250, 100, 30);
    b5.setFont(fo4);
    b5.setBorderPainted(false);
    b5.setBackground(new Color(4, 71, 169));
    b5.setBorder(null);
    b5.setContentAreaFilled(false);
    b5.setForeground(Color.WHITE);
    b5.setDefaultCapable(false);
    b5.setHorizontalAlignment(SwingConstants.LEFT);
    jp1.add(b5);
    b5.addActionListener(this);
    
    b6=new JButton("Testimonials");
    b6.setBounds(30, 300, 100, 30);
    b6.setFont(fo4);
    b6.setBorderPainted(false);
    b6.setBackground(new Color(4, 71, 169));
    b6.setBorder(null);
    b6.setContentAreaFilled(false);
    b6.setForeground(Color.WHITE);
    b6.setDefaultCapable(false);
    b6.setHorizontalAlignment(SwingConstants.LEFT);
    jp1.add(b6);
    //b6.addActionListener(this);
    
    b7=new JButton("Help");
    b7.setBounds(30, 350, 100, 30);
    b7.setFont(fo4);
    b7.setBorderPainted(false);
    b7.setBackground(new Color(4, 71, 169));
    b7.setBorder(null);
    b7.setContentAreaFilled(false);
    b7.setForeground(Color.WHITE);
    b7.setDefaultCapable(false);
    b7.setHorizontalAlignment(SwingConstants.LEFT);
    jp1.add(b7);
    b7.addActionListener(this);
    
    b8=new JButton("Log Out");
    b8.setBounds(30, 400, 100, 30);
    b8.setFont(fo4);
    b8.setBorderPainted(false);
    b8.setBackground(new Color(4, 71, 169));
    b8.setBorder(null);
    b8.setContentAreaFilled(false);
    b8.setForeground(Color.WHITE);
    b8.setDefaultCapable(false);
    b8.setHorizontalAlignment(SwingConstants.LEFT);
    jp1.add(b8);
    b8.addActionListener(this);
    
    l6=new JLabel("Testimonials:");
    l6.setBounds(300,18, 200, 30);
    l6.setFont(fo1);
    f1.add(l6);
    
    l1=new JLabel("Deepak");
    l1.setBounds(300,50, 100, 30);
    l1.setFont(fo4);
    f1.add(l1);
    
    jt1=new JTextArea("'Hi I am Deepak from Rourkela, I am a student of HOB since 2010. My \nHOB journey was so amazing. HOB has highly qualified teachers. They \nhave friendly nature. Right Now I am working with Dell as a Top service \nEngineer. Thank you HOB.'");
    jt1.setBounds(300, 80, 450, 80);
    jt1.setBackground(new Color(249,249,249));
    jt1.setFont(fo2);
    jt1.setBorder(null);
    jt1.setEditable(false);
    f1.add(jt1);
    
    l2=new JLabel("Monis");
    l2.setBounds(300,152, 100, 30);
    l2.setFont(fo4);
    f1.add(l2);
    
    jt2=new JTextArea("'Hi I am Monis from Delhi, I am a student of HOB since 2010. My \nHOB journey was so amazing. HOB has highly qualified teachers. They \nhave friendly nature. Right Now I am working with Dell as a Top service \nEngineer. Thank you HOB.'");
    jt2.setBounds(300, 180, 450, 80);
    jt2.setBackground(new Color(249,249,249));
    jt2.setFont(fo2);
    jt2.setBorder(null);
    jt2.setEditable(false);
    f1.add(jt2);
    
    l4=new JLabel("Ishor Kyee");
    l4.setBounds(300,260, 100, 30);
    l4.setFont(fo4);
    f1.add(l4);
    
    jt3=new JTextArea("'Hi I am Ishor from Nepal, I am a student of HOB since 2010. My \nHOB journey was so amazing. HOB has highly qualified teachers. They \nhave friendly nature. Right Now I am working with Dell as a Top service \nEngineer. Thank you HOB.'");
    jt3.setBounds(300, 290, 450, 80);
    jt3.setBackground(new Color(249,249,249));
    jt3.setFont(fo2);
    jt3.setBorder(null);
    jt3.setEditable(false);
    f1.add(jt3);
    
    l5=new JLabel("Subroto Chakarboty");
    l5.setBounds(300,370, 200, 30);
    l5.setFont(fo4);
    f1.add(l5);
    
    jt4=new JTextArea("'Hi I am Subroto from Andaman, I am a student of HOB since 2010. My \nHOB journey was so amazing. HOB has highly qualified teachers. They \nhave friendly nature. Right Now I am working with Dell as a Top service \nEngineer. Thank you HOB.'");
    jt4.setBounds(300, 400, 450, 80);
    jt4.setBackground(new Color(249,249,249));
    jt4.setFont(fo2);
    jt4.setBorder(null);
    jt4.setEditable(false);
    f1.add(jt4);
    
    l3=new JLabel("© Copyright All Right Reserved.");
    l3.setBounds(430, 535, 200, 20);
    l3.setForeground(Color.BLACK);
    l3.setFont(fo3);
    f1.add(l3);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    f1.setTitle("Testimonial");
    f1.setIconImage(imgqw.getImage());
    f1.setSize(800, 600);
    f1.setLocation(400, 300);
    f1.setLocation(400,180);
    f1.setLayout(null);
    jp1.setLayout(null);
    jp2.setLayout(null);
    con.setBackground(new Color(249,249,249));
    f1.setResizable(false);
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
   
public void actionPerformed(ActionEvent e)
{
    if (e.getSource()==b1)
    {
        f1.setVisible(false);
        Homepage ob=new Homepage();
        ob.homepage(em);
    }
    
    else if(e.getSource()==b8)
    {
        f1.setVisible(false);
        Soft58 ob=new Soft58();
        ob.login();
    }
    else if(e.getSource()==b7)
    {
        f1.setVisible(false);
        Help ob=new Help();
        ob.help(em);
    }
    
    
    else if(e.getSource()==b2)
    {
        f1.setVisible(false);
        Members ob=new Members();
        ob.members(em);
    }
    else if(e.getSource()==b4)
    {
        f1.setVisible(false);
        Features ob=new Features();
        ob.features(em);
    }
    else if(e.getSource()==b5)
    {
        f1.setVisible(false);
        Tutorials ob=new Tutorials();
        ob.tutorials(em);
    }
    else 
    {
        //f1.setVisible(false);
        Profile ob=new Profile();
        ob.profiepage(em);
    }
}
   

}
