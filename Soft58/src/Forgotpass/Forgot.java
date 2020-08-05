/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forgotpass;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.StyledEditorKit;
import soft58.*;

public class Forgot implements ActionListener
{
    JFrame f1=new JFrame();
    Container con=f1.getContentPane();
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l9;
    JTextField tf1,tf2,tf3,tf4,tf5;
    Font fo1,fo2,fo3,fo4;
    JButton b1,b2,b3;
    JPasswordField psf1,psf2,psf3;
    String s1,s2,s3;
    ImageIcon img=new ImageIcon("logo1.png");
    ImageIcon img1=new ImageIcon("icons8-user-32.png");
    ImageIcon img2=new ImageIcon("icons8-password-32.png");
    ImageIcon img3=new ImageIcon("icons8-new-post-32.png");
    JPanel jp1=new JPanel();
    JPanel jp2=new JPanel();
    char[] p1=new char[20];
   public void forgot2()
    {
        fo1=new Font("Comic Sans Ms", Font.BOLD, 30);
        fo2=new Font("Times New Roman", Font.BOLD, 14);
        fo3=new Font("Times New Roman", Font.PLAIN, 13);
        
        jp1.setBounds(0, 0, 350, 300);
        //jp1.setBackground(Color.BLUE);
        jp1.setLayout(null);
        f1.add(jp1);
        
        l9=new JLabel(img);
        l9.setBounds(0, 0, 350, 300);
        //l9.setBackground(Color.BLUE);
        l9.setFont(fo1);
        jp1.add(l9);
        
        l1=new JLabel("Details");
        f1.add(l1);
        l1.setBounds(480, 40, 200, 45);
        l1.setForeground(new Color(70, 5, 114));
        l1.setFont(fo1);
        
        
        
        l2=new JLabel(img1);
        f1.add(l2);
        l2.setBounds(380, 100, 100, 30);
        l2.setForeground(new Color(70, 5, 114));
        l2.setFont(fo2);
        
        
        
        tf1=new JTextField();
        tf1.setBounds(460, 100, 150, 30);
        tf1.setFont(fo2);
        tf1.setBackground(new Color(249, 145, 255));
        tf1.setForeground(Color.BLACK);
        tf1.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        f1.add(tf1);
        
        
        l3=new JLabel(img3);
        l3.setBounds(380, 140, 100, 30);
        l3.setForeground(new Color(70, 5, 114));
        l3.setFont(fo2);
        f1.add(l3);
        
        tf3=new JTextField();
        tf3.setBounds(460, 140, 150, 30);
        tf3.setFont(fo2);
        tf3.setBackground(new Color(249, 145, 255));
        tf3.setForeground(Color.BLACK);
        f1.add(tf3);
        tf3.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        l4=new JLabel(img2);
        l4.setBounds(380, 180, 100, 30);
        l4.setForeground(new Color(70, 5, 114));
        l4.setFont(fo2);
        f1.add(l4);
        
        psf1=new JPasswordField();
        psf1.setBounds(460, 180, 150, 30);
        psf1.setFont(fo2);
        psf1.setBackground(new Color(249, 145, 255));
        psf1.setForeground(Color.BLACK);
        f1.add(psf1);
        psf1.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        b1=new JButton("Submit");
        b1.setBounds(530, 220, 80, 25);
        b1.setBorder(null);
        b1.setDefaultCapable(false);
        //b1.setVisible(true);
        f1.add(b1);
        b1.addActionListener(this);
        
        f1.setSize(700, 300);
        f1.setLocation(400, 300);
        f1.setLayout(null); 
        con.setBackground(new Color(181, 51, 133));
        //f1.setBackground(Color.yellow);
        f1.setUndecorated(true);
        //f1.setResizable(false);
        f1.setVisible(true);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        s1=tf1.getText();
        s2=tf3.getText();
        s3 = new String(psf1.getPassword());
        try{
            if(s1.length()==0)
            {
            throw new ArithmeticException("Enter Login Id");
            }  
            
            String Email_Pattern="^[a-zA-Z0-9'.:\']{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
            Pattern pattern=Pattern.compile(Email_Pattern);
            Matcher regexMatcher=pattern.matcher(tf3.getText());
            if(!regexMatcher.matches())
            {
               throw new ArithmeticException("Invalid Email");
            }
            
            if(s3.length()<8)
            {
               throw new ArithmeticException("Password should be 8 digit");
            }
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");
            String sql="SELECT * FROM registered_member where Login_ID='"+s1+"' and Email='"+s2+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
       if(rs.next()) 
           {
           Statement st=con.createStatement();
           String str="update registered_member set password='"+s3+"' where email='"+s2+"'";
           st.executeUpdate(str);;
           JOptionPane.showMessageDialog(null,"Password Changed Successfully");
           f1.setVisible(false);
           Soft58 so=new Soft58();
           so.login();
           }
       else
          {
          JOptionPane.showMessageDialog(null,"Please Enter Correct Details");
          }
       rs.close();
       ps.close();
       con.close();
        }
      catch(Exception ex)
        {
        JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
}

