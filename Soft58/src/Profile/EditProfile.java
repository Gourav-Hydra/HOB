/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;
import Features.Features;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Profile.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditProfile implements ActionListener
{
   JFrame f1=new JFrame();
   Container con=f1.getContentPane();
   JPanel jp1;
   ImageIcon img5,img6,img9;
   JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,imb1;
   JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21;
   JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
   JTextArea jt1,jt2;
   JCheckBox cb1,cb2;
   ImageIcon img=new ImageIcon("icons8-customer-64.png");
   ImageIcon img1=new ImageIcon("icons8-back-arrow-16.png");
   ImageIcon imgqw=new ImageIcon("logo1.png");
   JPopupMenu pop1;
   Font fo1,fo2,fo3,fo4; 
   String em,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
   String filename=null;
   byte[] person_image=null;
   File f;

public void editprofile(String email)
{
    em=email;
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
           
             
    fo1=new Font("Times New Roman", Font.BOLD, 22);
    fo2=new Font("Tahoma", Font.PLAIN, 12);
    fo3=new Font("Tahom",Font.PLAIN, 17);
    fo4=new Font("Tahoma", Font.PLAIN, 18);
    
    jp1=new JPanel();
    jp1.setBounds(112, 70, 800, 600);
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
    
    l1=new JLabel("Name:*");
    l1.setBounds(80, 100, 80, 30);
    l1.setFont(fo4);
    jp1.add(l1);
    
             tf1=new JTextField(rs.getString(1));
             tf1.setBounds(150, 100, 330, 30);
             tf1.setBorder(null);
             tf1.setFont(fo3);
             jp1.add(tf1);
    
    l1=new JLabel("_______________________________________________");
    l1.setBounds(150, 104, 330, 30);
    l1.setForeground(Color.black);
    l1.setFont(fo1);
    jp1.add(l1);
    
    l2=new JLabel("Student Code:");
    l2.setBounds(80, 140, 120, 30);
    l2.setFont(fo4);
    jp1.add(l2);
    
    l3=new JLabel(rs.getString(2));
             l3.setBounds(200, 140, 200, 30);
             l3.setForeground(Color.black);
             l3.setFont(fo3);
             jp1.add(l3);
    
    l2=new JLabel("Course:");
    l2.setBounds(320, 140, 120, 30);
    l2.setFont(fo4);
    jp1.add(l2);
    
    l4=new JLabel(rs.getString(3));
             l4.setBounds(390, 140, 200, 30);
             l4.setForeground(Color.black);
             l4.setFont(fo3);
             jp1.add(l4);
    
    l5=new JLabel("Address:*");
    l5.setBounds(80, 180, 150, 30);
    l5.setFont(fo4);
    jp1.add(l5);
    
    tf2=new JTextField(rs.getString(4));
             tf2.setBounds(170, 180, 330, 30);
             tf2.setBorder(null);
             tf2.setFont(fo3);
             jp1.add(tf2);
    
    l6=new JLabel("_______________________________________________");
    l6.setBounds(170, 184, 310, 30);
    l6.setForeground(Color.black);
    l6.setFont(fo1);
    jp1.add(l6);
    
    l7=new JLabel("Email:*");
    l7.setBounds(80, 225, 150, 30);
    l7.setFont(fo4);
    jp1.add(l7);
    
    tf3=new JTextField(em);
    tf3.setBounds(170, 225, 330, 30);
    tf3.setBorder(null);
    tf3.setFont(fo3);
    jp1.add(tf3);
    
    l8=new JLabel("_______________________________________________");
    l8.setBounds(170, 229, 310, 30);
    l8.setForeground(Color.black);
    l8.setFont(fo1);
    jp1.add(l8);
    
    l9=new JLabel("Mobile:*");
    l9.setBounds(80, 270, 100, 30);
    l9.setFont(fo4);
    jp1.add(l9);
    
    tf4=new JTextField(rs.getString(6));
             tf4.setBounds(170, 270, 200, 30);
             tf4.setBorder(null);
             tf4.setFont(fo3);
             jp1.add(tf4);
    
    l10=new JLabel("_____________________");
    l10.setBounds(170, 278, 200, 30);
    l10.setForeground(Color.black);
    l10.setFont(fo3);
    jp1.add(l10);
    
    l11=new JLabel("Aadhar No:*");
    l11.setBounds(380, 270, 100, 30);
    l11.setFont(fo4);
    jp1.add(l11);
    
    tf5=new JTextField(rs.getString(7));
             tf5.setBounds(500, 270, 200, 30);
             tf5.setBorder(null);
             tf5.setFont(fo3);
             jp1.add(tf5);
    
    l12=new JLabel("__________________________________");
    l12.setBounds(500, 278, 200, 30);
    l12.setForeground(Color.black);
    l12.setFont(fo3);
    jp1.add(l12);
    
    l13=new JLabel("State:");
    l13.setBounds(80, 320, 100, 30);
    l13.setFont(fo4);
    jp1.add(l13);
    
    tf6=new JTextField(rs.getString(8));
             tf6.setBounds(170, 320, 200, 30);
             tf6.setBorder(null);
             tf6.setFont(fo3);
             jp1.add(tf6);
    
    l14=new JLabel("_____________________1");
    l14.setBounds(170, 326, 200, 30);
    l14.setForeground(Color.black);
    l14.setFont(fo3);
    jp1.add(l14);
    
    l15=new JLabel("     City:");
    l15.setBounds(380, 320, 100, 30);
    l15.setFont(fo4);
    jp1.add(l15);
    
    tf7=new JTextField(rs.getString(9));
             tf7.setBounds(500, 320, 200, 30);
             tf7.setBorder(null);
             tf7.setFont(fo3);
             jp1.add(tf7);
    
    l16=new JLabel("__________________________________");
    l16.setBounds(500, 326, 200, 30);
    l16.setForeground(Color.black);
    l16.setFont(fo3);
    jp1.add(l16);
    
    l17=new JLabel("Pin:*");
    l17.setBounds(80, 370, 100, 30);
    l17.setFont(fo4);
    jp1.add(l17);
    
    tf8=new JTextField(rs.getString(10));
             tf8.setBounds(170, 370, 200, 30);
             tf8.setBorder(null);
             tf8.setFont(fo3);
             jp1.add(tf8);
    
    l18=new JLabel("_____________________");
    l18.setBounds(170, 376, 200, 30);
    l18.setForeground(Color.black);
    l18.setFont(fo3);
    jp1.add(l18);
    
    b1=new JButton("Upload");
    b1.setBounds(570, 230, 120, 30);
    jp1.add(b1);
    b1.addActionListener(this);
    
    //img6=new ImageIcon(rs.getString(11));
   // byte[] imagedata = rs.getBytes(rs.getString("")) ;
     //       Image img = Toolkit.getDefaultToolkit().createImage(imagedata);
       //     ImageIcon icon =new ImageIcon(img);
         //   l20 = new JLabel(icon) ;
    byte[] imagedata = rs.getBytes(11) ;
    Image img10 = Toolkit.getDefaultToolkit().createImage(imagedata);
    ImageIcon icon=new ImageIcon(img10);
            
            
            
    l20=new JLabel();
    l20.setBounds(555, 70, 150, 150);
    img9=new ImageIcon(icon.getImage().getScaledInstance(l20.getWidth(), l20.getHeight(), Image.SCALE_SMOOTH));
    l20.setIcon(img9);
    l20.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.lightGray));
    jp1.add(l20);
      
    b2=new JButton("Update Profile");
    b2.setBounds(350, 500, 120, 30);
    b2.setBackground(Color.GREEN);
    b2.setForeground(Color.black);
    jp1.add(b2);
    b2.addActionListener(this);
    
    l19=new JLabel("© Copyright All Right Reserved.");
    l19.setBounds(430, 700, 200, 20);
    l19.setForeground(Color.white);
    l19.setFont(fo2);
    f1.add(l19);
    
        
    f1.setTitle("Edit Profile");
    f1.setIconImage(imgqw.getImage());
    f1.setSize(1024, 768);
    f1.setLocation(300, 50);
    f1.setLayout(null);
    jp1.setLayout(null);
    con.setBackground(new Color(26,26,255));
    f1.setResizable(false);
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
             
     }
     else
     {
    fo1=new Font("Times New Roman", Font.BOLD, 22);
    fo2=new Font("Tahoma", Font.PLAIN, 12);
    fo3=new Font("Tahom",Font.PLAIN, 17);
    fo4=new Font("Tahoma", Font.PLAIN, 18);
    
    jp1=new JPanel();
    jp1.setBounds(112, 70, 800, 600);
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
    
    l1=new JLabel("Name:*");
    l1.setBounds(80, 100, 80, 30);
    l1.setFont(fo4);
    jp1.add(l1);
    
             tf1=new JTextField();
             tf1.setBounds(150, 100, 330, 30);
             tf1.setBorder(null);
             tf1.setFont(fo3);
             jp1.add(tf1);
    
    l1=new JLabel("_______________________________________________");
    l1.setBounds(150, 104, 330, 30);
    l1.setForeground(Color.black);
    l1.setFont(fo1);
    jp1.add(l1);
    
    l2=new JLabel("Student Code:");
    l2.setBounds(80, 140, 120, 30);
    l2.setFont(fo4);
    jp1.add(l2);
    
    l3=new JLabel();
             l3.setBounds(200, 140, 200, 30);
             l3.setForeground(Color.black);
             l3.setFont(fo3);
             jp1.add(l3);
    
    l2=new JLabel("Course:");
    l2.setBounds(320, 140, 120, 30);
    l2.setFont(fo4);
    jp1.add(l2);
    
    l4=new JLabel();
             l4.setBounds(390, 140, 200, 30);
             l4.setForeground(Color.black);
             l4.setFont(fo3);
             jp1.add(l4);
    
    l5=new JLabel("Address:*");
    l5.setBounds(80, 180, 150, 30);
    l5.setFont(fo4);
    jp1.add(l5);
    
    tf2=new JTextField();
             tf2.setBounds(170, 180, 330, 30);
             tf2.setBorder(null);
             tf2.setFont(fo3);
             jp1.add(tf2);
    
    l6=new JLabel("_______________________________________________");
    l6.setBounds(170, 184, 310, 30);
    l6.setForeground(Color.black);
    l6.setFont(fo1);
    jp1.add(l6);
    
    l7=new JLabel("Email:*");
    l7.setBounds(80, 225, 150, 30);
    l7.setFont(fo4);
    jp1.add(l7);
    
    tf3=new JTextField(em);
    tf3.setBounds(170, 225, 330, 30);
    tf3.setBorder(null);
    tf3.setFont(fo3);
    jp1.add(tf3);
    
    l8=new JLabel("_______________________________________________");
    l8.setBounds(170, 229, 310, 30);
    l8.setForeground(Color.black);
    l8.setFont(fo1);
    jp1.add(l8);
    
    l9=new JLabel("Mobile:*");
    l9.setBounds(80, 270, 100, 30);
    l9.setFont(fo4);
    jp1.add(l9);
    
    tf4=new JTextField();
             tf4.setBounds(170, 270, 200, 30);
             tf4.setBorder(null);
             tf4.setFont(fo3);
             jp1.add(tf4);
    
    l10=new JLabel("_____________________");
    l10.setBounds(170, 278, 200, 30);
    l10.setForeground(Color.black);
    l10.setFont(fo3);
    jp1.add(l10);
    
    l11=new JLabel("Aadhar No:*");
    l11.setBounds(380, 270, 100, 30);
    l11.setFont(fo4);
    jp1.add(l11);
    
    tf5=new JTextField();
             tf5.setBounds(500, 270, 200, 30);
             tf5.setBorder(null);
             tf5.setFont(fo3);
             jp1.add(tf5);
    
    l12=new JLabel("__________________________________");
    l12.setBounds(500, 278, 200, 30);
    l12.setForeground(Color.black);
    l12.setFont(fo3);
    jp1.add(l12);
    
    l13=new JLabel("State:");
    l13.setBounds(80, 320, 100, 30);
    l13.setFont(fo4);
    jp1.add(l13);
    
    tf6=new JTextField();
             tf6.setBounds(170, 320, 200, 30);
             tf6.setBorder(null);
             tf6.setFont(fo3);
             jp1.add(tf6);
    
    l14=new JLabel("_____________________1");
    l14.setBounds(170, 326, 200, 30);
    l14.setForeground(Color.black);
    l14.setFont(fo3);
    jp1.add(l14);
    
    l15=new JLabel("     City:");
    l15.setBounds(380, 320, 100, 30);
    l15.setFont(fo4);
    jp1.add(l15);
    
    tf7=new JTextField();
             tf7.setBounds(500, 320, 200, 30);
             tf7.setBorder(null);
             tf7.setFont(fo3);
             jp1.add(tf7);
    
    l16=new JLabel("__________________________________");
    l16.setBounds(500, 326, 200, 30);
    l16.setForeground(Color.black);
    l16.setFont(fo3);
    jp1.add(l16);
    
    l17=new JLabel("Pin:*");
    l17.setBounds(80, 370, 100, 30);
    l17.setFont(fo4);
    jp1.add(l17);
    
    tf8=new JTextField();
             tf8.setBounds(170, 370, 200, 30);
             tf8.setBorder(null);
             tf8.setFont(fo3);
             jp1.add(tf8);
    
    l18=new JLabel("_____________________1");
    l18.setBounds(170, 376, 200, 30);
    l18.setForeground(Color.black);
    l18.setFont(fo3);
    jp1.add(l18);
    
    b1=new JButton("Upload");
    b1.setBounds(570, 230, 120, 30);
    jp1.add(b1);
    b1.addActionListener(this);
    
    l20=new JLabel("          Upload Photo");
    l20.setBounds(555, 70, 150, 150);
    l20.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.lightGray));
    jp1.add(l20);
      
    b2=new JButton("Update Profile");
    b2.setBounds(350, 500, 120, 30);
    b2.setBackground(Color.GREEN);
    b2.setForeground(Color.black);
    jp1.add(b2);
    b2.addActionListener(this);
    
    l19=new JLabel("© Copyright All Right Reserved.");
    l19.setBounds(430, 700, 200, 20);
    l19.setForeground(Color.white);
    l19.setFont(fo2);
    f1.add(l19);
    
        
    f1.setTitle("Edit Profile");
    f1.setIconImage(imgqw.getImage());
    f1.setSize(1024, 768);
    f1.setLocation(300, 50);
    f1.setLayout(null);
    jp1.setLayout(null);
    con.setBackground(new Color(26,26,255));
    f1.setResizable(false);
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
     }
    }
    catch(Exception ef)
    {
        System.out.println(ef);
    }
    
    
    
}

public void actionPerformed(ActionEvent e)
{
   if(e.getSource()==b1)
     {
       JFileChooser fc1=new JFileChooser();
       fc1.showOpenDialog(null);
       f=fc1.getSelectedFile();
       filename=f.getAbsolutePath();
       img5=new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(l20.getWidth(), l20.getHeight(), Image.SCALE_SMOOTH));
       l20.setIcon(img5);
     } 
    
    
    
    
   else if(e.getSource()==b2)
    {
     s1=tf1.getText();          //name
     s2=tf2.getText();          //Address
     //s3=tf3.getText();          //Email
     s4=tf4.getText();          //Mobile
     s5=tf5.getText();          //Aadhar
     s6=tf6.getText();          //State
     s7=tf7.getText();          //City
     s8=tf8.getText();          //Pin
     //s9=tf9.getText();          //
     s11="";
     s12="";
     
     
     
     try
     {
     Class.forName("com.mysql.jdbc.Driver");
     Connection cont=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");
     Statement st=cont.createStatement();
     String str2="select * from information where Email='"+em+"'";
     PreparedStatement ps=cont.prepareStatement(str2);
     ResultSet rs=ps.executeQuery();
     if(rs.next())
     {
     FileInputStream fis1=new FileInputStream(f);
     PreparedStatement ps2=cont.prepareStatement("update Information set Name=?,Address=?,Mobile=?,Aadhar=?,State=?,City=?,Pin=?,Picture=? where Email='"+em+"'");
     ps2.setString(1, s1);
     ps2.setString(2, s2);
     ps2.setString(3, s4);
     ps2.setString(4, s5);
     ps2.setString(5, s6);
     ps2.setString(6, s7);
     ps2.setString(7, s8);
     ps2.setBinaryStream(8, fis1,(int)(f.length()));
     ps2.executeUpdate();
     JOptionPane.showMessageDialog(null,"Updated Successfully!");
     }
     else
     {
     FileInputStream fis=new FileInputStream(f);
     PreparedStatement ps1=cont.prepareStatement("insert into Information(Name,Student_Code,Course,Address,Email,Mobile,Aadhar,State,City,Pin,Picture)values(?,?,?,?,?,?,?,?,?,?,?)");
     ps1.setString(1,s1);
     ps1.setString(2,s11);
     ps1.setString(3,s12);
     ps1.setString(4,s2);
     ps1.setString(5,em);
     ps1.setString(6,s4);
     ps1.setString(7,s5);
     ps1.setString(8,s6);
     ps1.setString(9,s7);
     ps1.setString(10,s8);
     ps1.setBinaryStream(11, fis,(int)(f.length()));
     ps1.executeUpdate();
     JOptionPane.showMessageDialog(null,"Updated Successfully!");
     }
     }
     catch(Exception ex)
     {
         System.out.println(ex);
     }
     
    }
 else
   {
       Profile ob=new Profile();
       ob.profiepage(em);
       f1.setVisible(false);
   }
}
   
  
   
}
