/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;
//import Features.Features;
import Homepage.Homepage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Profile implements ActionListener
{
   JFrame f1=new JFrame();
   Container cont=f1.getContentPane();
   JPanel jp1;
   JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,imb1;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,im1,n1,n2,n3,n4,n5,n6,n7;
   ImageIcon img=new ImageIcon("icons8-customer-64.png");
   ImageIcon img1=new ImageIcon("icons8-back-arrow-16.png");
   ImageIcon imgqw=new ImageIcon("logo1.png");
   JPopupMenu pop1;
   JTextArea jt1;
   Font fo1,fo2,fo3,fo4;
   String em,s1;
   
public void profiepage(String email)
        
{
    em=email;
  try
    {
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");
     Statement st=con.createStatement();
     String str="select * from information where Email='"+em+"'";
     PreparedStatement ps=con.prepareStatement(str);
     ResultSet rs=ps.executeQuery();
       if(rs.next()) 
           {
    
    
    fo1=new Font("Times New Roman", Font.BOLD, 22);
    fo2=new Font("Tahoma", Font.PLAIN, 12);
    fo3=new Font("Tahom",Font.BOLD, 17);
    fo4=new Font("Tahoma", Font.PLAIN, 18);
    
    jp1=new JPanel();
    jp1.setBounds(270, 120, 500, 500);
    jp1.setBackground(Color.WHITE);
    f1.add(jp1);
    
   
    
    imb1=new JButton(img1);
    imb1.setBounds(10, 10, 35, 35);
    imb1.setBorderPainted(false);
    imb1.setContentAreaFilled(false);
    imb1.setBorder(null);
    imb1.setDefaultCapable(false);
    imb1.setBackground(Color.WHITE);
    jp1.add(imb1);
    imb1.addActionListener(this);
    
     byte[] imagedata = rs.getBytes(11) ;
    Image img10 = Toolkit.getDefaultToolkit().createImage(imagedata);
    ImageIcon icon=new ImageIcon(img10);
    
    l1=new JLabel(img);
    l1.setBounds(100, 50, 80, 80);
    ImageIcon img9=new ImageIcon(icon.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH));
    l1.setIcon(img9);
    jp1.add(l1);
    
    l2=new JLabel("____________________________________________");
    l2.setBounds(50, 120, 400, 20);
    l2.setFont(fo3);
    jp1.add(l2);
    
    l1=new JLabel("Name:");
    l1.setBounds(100, 150, 80, 80);
    jp1.add(l1);
    
    l1=new JLabel("Email:");
    l1.setBounds(100, 180, 80, 80);
    jp1.add(l1);
    
    l9=new JLabel(em);
    l9.setBounds(200, 180, 200, 80);
    jp1.add(l9);
    
    l1=new JLabel("Mobile:");
    l1.setBounds(100, 210, 80, 80);
    jp1.add(l1);
    
    l1=new JLabel("Student Code:");
    l1.setBounds(100, 240, 80, 80);
    jp1.add(l1);
    
    l1=new JLabel("Course:");
    l1.setBounds(100, 270, 80, 80);
    jp1.add(l1);
    
    l4=new JLabel(rs.getString(1));             //title name
    l4.setBounds(200, 75, 100, 30);
    jp1.add(l4);
    
    n1=new JLabel(rs.getString(1));
    n1.setBounds(200, 150, 200, 80);            //Name
    jp1.add(n1);
    
    n2=new JLabel(rs.getString(6));
    n2.setBounds(200, 210, 200, 80);            //mobile
    jp1.add(n2);
    
    n3=new JLabel(rs.getString(2));
    n3.setBounds(200, 240, 200, 80);            //Student Code
    jp1.add(n3);
    
    n4=new JLabel(rs.getString(3));
    n4.setBounds(200, 270, 200, 80);            //Course
    jp1.add(n4);
    b1=new JButton("Edit Profile");
    b1.setBounds(350, 400, 100, 30);
    b1.setFocusPainted(false);
    b1.setBackground(Color.orange);
    //b1.setBackground(new Color(26, 26, 255));
    //b1.setForeground(Color.white);
    //b1.setBorderPainted(false);
    //b1.setContentAreaFilled(false);
    jp1.add(b1);
    b1.addActionListener(this);

    l3=new JLabel("© Copyright All Right Reserved.");
    l3.setBounds(430, 700, 200, 20);
    l3.setForeground(Color.white);
    l3.setFont(fo2);
    f1.add(l3);
    
    
    f1.setTitle("Profile Page");
    f1.setIconImage(imgqw.getImage());
    f1.setSize(1024, 768);
    f1.setLocation(300, 50);
    f1.setLayout(null);
    jp1.setLayout(null);
    cont.setBackground(new Color(26,26,255));
    f1.setResizable(false);
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
           
           }
       else
          {
     fo1=new Font("Times New Roman", Font.BOLD, 22);
    fo2=new Font("Tahoma", Font.PLAIN, 12);
    fo3=new Font("Tahom",Font.BOLD, 17);
    fo4=new Font("Tahoma", Font.PLAIN, 18);
    
    jp1=new JPanel();
    jp1.setBounds(270, 120, 500, 500);
    jp1.setBackground(Color.WHITE);
    f1.add(jp1);
    
    imb1=new JButton(img1);
    imb1.setBounds(10, 10, 35, 35);
    imb1.setBorderPainted(false);
    imb1.setContentAreaFilled(false);
    imb1.setBorder(null);
    imb1.setDefaultCapable(false);
    imb1.setBackground(Color.WHITE);
    jp1.add(imb1);
    imb1.addActionListener(this);
    
    l1=new JLabel(img);
    l1.setBounds(100, 50, 80, 80);
    jp1.add(l1);
    
    l2=new JLabel("____________________________________________");
    l2.setBounds(50, 120, 400, 20);
    l2.setFont(fo3);
    jp1.add(l2);
    
    l1=new JLabel("Name:");
    l1.setBounds(100, 150, 80, 80);
    jp1.add(l1);
    
    l1=new JLabel("Email:");
    l1.setBounds(100, 180, 80, 80);
    jp1.add(l1);
    
    l9=new JLabel(em);
    l9.setBounds(200, 180, 200, 80);
    jp1.add(l9);
    
    l1=new JLabel("Mobile:");
    l1.setBounds(100, 210, 80, 80);
    jp1.add(l1);
    
    l1=new JLabel("Student Code:");
    l1.setBounds(100, 240, 80, 80);
    jp1.add(l1);
    
    l1=new JLabel("Course:");
    l1.setBounds(100, 270, 80, 80);
    jp1.add(l1);
    
    l4=new JLabel();             //title name
    l4.setBounds(200, 75, 100, 30);
    jp1.add(l4);
    
    n1=new JLabel();
    n1.setBounds(200, 150, 200, 80);            //Name
    jp1.add(n1);
    
    n2=new JLabel();
    n2.setBounds(200, 210, 200, 80);            //mobile
    jp1.add(n2);
    
    n3=new JLabel();
    n3.setBounds(200, 240, 200, 80);            //Student Code
    jp1.add(n3);
    
    n4=new JLabel();
    n4.setBounds(200, 270, 200, 80);            //Course
    jp1.add(n4);
    b1=new JButton("Edit Profile");
    b1.setBounds(350, 400, 100, 30);
    b1.setFocusPainted(false);
    b1.setBackground(Color.orange);
    //b1.setBackground(new Color(26, 26, 255));
    //b1.setForeground(Color.white);
    //b1.setBorderPainted(false);
    //b1.setContentAreaFilled(false);
    jp1.add(b1);
    b1.addActionListener(this);

    l3=new JLabel("© Copyright All Right Reserved.");
    l3.setBounds(430, 700, 200, 20);
    l3.setForeground(Color.white);
    l3.setFont(fo2);
    f1.add(l3);
    
    
    f1.setTitle("Profile");
    f1.setIconImage(imgqw.getImage());
    f1.setSize(1024, 768);
    f1.setLocation(300, 50);
    f1.setLayout(null);
    jp1.setLayout(null);
    cont.setBackground(new Color(26,26,255));
    f1.setResizable(false);
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
       rs.close();
       ps.close();
       con.close();
        }
     
     
    
    catch(Exception ea)
    {
      JOptionPane.showInternalMessageDialog(cont, ea);
    }
    

}

public void actionPerformed(ActionEvent e)
{
  
   
   if(e.getSource()==b1)
   {
       f1.setVisible(false);
       EditProfile ob=new EditProfile();
       ob.editprofile(em);
   }
   else 
   {
       f1.setVisible(false);
   }
   
}
   
   

}
