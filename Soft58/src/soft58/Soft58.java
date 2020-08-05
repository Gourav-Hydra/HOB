/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft58;
import Forgotpass.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.LineBorder;
import sign.*;
import Homepage.*;
import Tutorials.Tutorials;



public class Soft58 implements ActionListener{
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
    JPanel jp1=new JPanel();
    char[] p1=new char[20];
    private Object Forgotpass;
    public void login()
    {
        //con.setBackground(new Color(255, 255, 255));
        
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
        
        l1=new JLabel("Login");
        l1.setBounds(480, 40, 200, 45);
        l1.setForeground(new Color(70, 5, 114));
        l1.setFont(fo1);
        f1.add(l1);
        
        
        l2=new JLabel(img1);
        l2.setBounds(380, 100, 100, 30);
        //l2.setForeground(new Color(70, 5, 114));
        l2.setFont(fo2);
        f1.add(l2);
        
        
        tf1=new JTextField();
        tf1.setBounds(460, 100, 150, 30);
        tf1.setFont(fo2);
        tf1.setBackground(new Color(249, 145, 255));
        tf1.setForeground(Color.BLACK);
        f1.add(tf1);
        tf1.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        l3=new JLabel(img2);
        l3.setBounds(380, 140, 100, 30);
        //l3.setForeground(new Color(70, 5, 114));
        l3.setFont(fo2);
        f1.add(l3);
        
        psf1=new JPasswordField();
        psf1.setBounds(460, 140, 150, 30);
        psf1.setFont(fo2);
        psf1.setBackground(new Color(249, 145, 255));
        psf1.setForeground(Color.BLACK);
        f1.add(psf1);
        psf1.setBorder(new LineBorder(new Color(245, 245, 245), 3));
        
        
        b1=new JButton("Login");
        b1.setBounds(530, 180, 80, 25);
        b1.setBorder(null);
        b1.setDefaultCapable(true);
        //b1.setVisible(true);
        f1.add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Forgot Password");
        b2.setBounds(488, 210, 150, 30);
        b2.setBorderPainted(false);
        b2.setBackground(new Color(181, 51, 133));
        b2.setForeground(new Color(70, 5, 114));
        b2.setContentAreaFilled(false);
        b2.setBorder(null);
        b2.setDefaultCapable(false);
        //b1.setVisible(true);
        f1.add(b2);
        b2.addActionListener(this);
        
        
        b3=new JButton("Don't have an account!!Create a new one");
        b3.setBounds(365, 250, 300, 30);
        b3.setBorderPainted(false);
        b3.setBackground(new Color(181, 51, 133));
        b3.setForeground(new Color(70, 5, 114));
        b3.setBorder(null);
        b3.setContentAreaFilled(false);
        b3.setDefaultCapable(false);
        //b1.setVisible(true);
        f1.add(b3);
        b3.addActionListener(this);
                        
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
    if (e.getSource()==b1)
    {
        s1=tf1.getText();
        s3 = new String(psf1.getPassword());
        try{
            if(s1.length()==0)
            {
            throw new ArithmeticException("Enter Login Id");
            }
            if(s3.length()==0)
            {
            throw new ArithmeticException("Enter Password");
            }
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");
            String sql="SELECT * FROM registered_member where Login_ID='"+s1+"' and Password='"+s3+"'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
       if(rs.next()) 
           {
           JOptionPane.showMessageDialog(null,"Login Successfully!");
           f1.setVisible(false);
           Homepage ob=new Homepage();
           String email=rs.getString(3);
           ob.homepage(email);
           
           }
       else
          {
          JOptionPane.showMessageDialog(null,"Enter Correct user id & password");
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
    else if(e.getSource()==b3)
    {
        
        
        sign ob=new sign();
        ob.signup();
    }
    else 
    {
      Forgot fp=new Forgot();
      fp.forgot2();
      f1.setVisible(false);
    }
    }
    


    public static void main(String[] args) 
    {
      
       Soft58 ob=new Soft58();
       ob.login();
    }
    
}
