/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sign;

/**
 *
 * @author beatking
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.LineBorder;
import soft58.*;
public class sign implements ActionListener
{
    JFrame f9=new JFrame();
    Container con=f9.getContentPane();
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l9;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JPasswordField psf1;
    Font fo1,fo2,fo3,fo4;
    char [] p1=new char[20];
    //Image bg1=Toolkit.getDefaultToolkit().createImage("C:\\Users\\beatking\\Desktop\\Project 1\\login Page\\logo4.png");
    JButton b1,b2,b3;
    ImageIcon img=new ImageIcon("logo1.png");
    ImageIcon img1=new ImageIcon("icons8-user-32.png");
    ImageIcon img2=new ImageIcon("icons8-password-32.png");
    ImageIcon img3=new ImageIcon("icons8-new-post-32.png");
    JPanel jp1=new JPanel();
    String s1,s2,s3,s4,s5;

    public void signup() 
    {
        //f9.setContentPane(new JLabel(new ImageIcon("C:\\Users\\beatking\\Desktop\\Project 1\\login Page\\logo4.png")));
        //jp1.setBounds(50, 50, 300, 200);
        //jp1.setBackground(Color.red);
        // f1.add(jp1);
        fo1=new Font("Comic Sans Ms", Font.BOLD, 30);
        fo2=new Font("Times New Roman", Font.BOLD, 14);
        
        jp1.setBounds(0, 0, 350, 300);
        //jp1.setBackground(Color.BLUE);
        jp1.setLayout(null);
        f9.add(jp1);
        
        l9=new JLabel(img);
        l9.setBounds(0, 0, 350, 300);
        //l9.setBackground(Color.BLUE);
        l9.setFont(fo1);
        jp1.add(l9);
        
        l1=new JLabel("Sign Up");
        l1.setBounds(480, 40, 200, 45);
        l1.setForeground(new Color(70, 5, 114));
        l1.setFont(fo1);
        f9.add(l1);
        
        
        l2=new JLabel(img1);
        l2.setBounds(380, 100, 100, 30);
        //l2.setForeground(new Color(70, 5, 114));
        l2.setFont(fo2);
        f9.add(l2);
        
        
        tf1=new JTextField();
        tf1.setBounds(460, 100, 150, 30);
        tf1.setFont(fo2);
        tf1.setBackground(new Color(249, 145, 255));
        tf1.setForeground(Color.BLACK);
        f9.add(tf1);
        tf1.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        l3=new JLabel(img2);
        l3.setBounds(380, 140, 100, 30);
        //l3.setForeground(new Color(70, 5, 114));
        l3.setFont(fo2);
        f9.add(l3);
        
        psf1=new JPasswordField();
        psf1.setBounds(460, 140, 150, 30);
        psf1.setFont(fo2);
        psf1.setBackground(new Color(249, 145, 255));
        psf1.setForeground(Color.BLACK);
        f9.add(psf1);
        psf1.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        l4=new JLabel(img3);
        l4.setBounds(380, 180, 100, 30);
        l4.setForeground(new Color(70, 5, 114));
        l4.setFont(fo2);
        f9.add(l4);
        
        tf3=new JTextField();
        tf3.setBounds(460, 180, 150, 30);
        tf3.setFont(fo2);
        tf3.setBackground(new Color(249, 145, 255));
        tf3.setForeground(Color.BLACK);
        f9.add(tf3);
        tf3.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        b1=new JButton("Sign Up");
        b1.setBounds(530, 220, 80, 25);
        b1.setBorder(null);
        b1.setDefaultCapable(false);
        //b1.setVisible(true);
        f9.add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("already have an account!!Login here");
        b2.setBounds(365, 250, 300, 30);
        b2.setBorderPainted(false);
        b2.setBackground(new Color(181, 51, 133));
        b2.setForeground(new Color(70, 5, 114));
        b2.setBorder(null);
        b2.setContentAreaFilled(false);
        b2.setDefaultCapable(false);
        //b1.setVisible(true);
        f9.add(b2);
        b2.addActionListener(this);
        
        
        /*l5=new JLabel("already have an account!!Login here");
        l5.setBounds(433, 260, 250, 30);
        l5.setForeground(new Color(70, 5, 114));
        l5.setFont(fo3);
        f9.add(l5);*/
        
        
        f9.setSize(700, 300);
        f9.setLocation(400, 300);
        f9.setLayout(null); 
        con.setBackground(new Color(181, 51, 133));
        //f1.setBackground(Color.yellow);
        f9.setUndecorated(true);
        //f1.setResizable(false);
        f9.setVisible(true);
        f9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  public void actionPerformed(ActionEvent e)
    {
    if (e.getSource()==b1)
    {
        s1=tf1.getText();
        //p1=psf1.getPassword();
        s2=tf3.getText();
        s3 = new String(psf1.getPassword());
        
        
        
        try
        {
         if(s1.length()==0)
        {
            throw new ArithmeticException("Enter Login Id");
        }   
            
            
        if(s3.length()<8)
        {
            throw new ArithmeticException("Password should be 8 digit");
        }
            
        String Email_Pattern="^[a-zA-Z0-9'.:\']{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        Pattern pattern=Pattern.compile(Email_Pattern);
        Matcher regexMatcher=pattern.matcher(tf3.getText());
        if(!regexMatcher.matches())
        {
           throw new ArithmeticException("Invalid Email");
        }
        
        
        
            
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");
        Statement st=conn.createStatement();
        String sql="SELECT * FROM registered_member where Login_ID='"+s1+"' or Email='"+s2+"'";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
       if(rs.next())
       {
          throw new ArithmeticException("Login Id or Email already Exists"); 
       }
        String str="insert into registered_member(Login_ID,Password,Email)values('"+s1+"','"+s3+"','"+s2+"')";
        st.executeUpdate(str);
        JOptionPane.showMessageDialog(null,"SignedUp Successfully!");
        f9.setVisible(false);
        Soft58 ob=new Soft58();
        ob.login();
        }
        catch(Exception ea)
        { 
        JOptionPane.showMessageDialog(null,ea.getMessage());
        } 
    }
    else
    {
        Soft58 ob=new Soft58();
        ob.login();
    }
    
}
}
