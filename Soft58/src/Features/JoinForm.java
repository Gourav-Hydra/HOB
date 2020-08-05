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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class JoinForm implements ActionListener
{
    JFrame f1=new JFrame();
    JPanel jp1;
    Container con=f1.getContentPane();
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField tf1,tf2,tf3,tf4;
    JButton b1,b2,b3;
    ImageIcon imgqw=new ImageIcon("logo1.png");
    Font fo1,fo2,fo3,fo4;
    String s1,s2,s3,s4;
    public void join()
    {
    fo1=new Font("Times New Roman", Font.BOLD, 30);
    fo2=new Font("Tahoma", Font.PLAIN, 12);
    fo3=new Font("Tahom",Font.BOLD, 17);
    fo4=new Font("Tahoma", Font.PLAIN, 18);
    
        
    jp1=new JPanel();
    jp1.setBounds(100, 80, 600, 400);
    jp1.setBackground(new Color(152,245,141));
    f1.add(jp1);
    
    l1=new JLabel("Add on");
    l1.setBounds(260, 10, 100, 40);
    l1.setForeground(Color.black);
    l1.setFont(fo1);
    jp1.add(l1);
    
    l2=new JLabel("_______");
    l2.setBounds(255, 15, 105, 40);
    l2.setForeground(Color.black);
    l2.setFont(fo1);
    jp1.add(l2);
    
    l3=new JLabel("Email:");
    l3.setBounds(100, 80, 100, 30);
    l3.setFont(fo3);
    jp1.add(l3);
    
    tf1=new JTextField();
    tf1.setBounds(155, 81, 300, 30);
    tf1.setBorder(null);
    tf1.setBackground(new Color(152,245,141));
    jp1.add(tf1);
    
    l4=new JLabel("Course:");
    l4.setBounds(100, 150, 150, 30);
    l4.setFont(fo3);
    jp1.add(l4);
    
    tf2=new JTextField();
    tf2.setBounds(170, 151, 300, 30);
    tf2.setBorder(null);
    tf2.setBackground(new Color(152,245,141));
    jp1.add(tf2);
    
    b1=new JButton("Send Request");
    b1.setBounds(230, 260,150, 40);
    b1.setBackground(Color.green);
    jp1.add(b1);
    
    b1.addActionListener(this);
    
            
        
        
    f1.setTitle("HOB Join");
    f1.setIconImage(imgqw.getImage());
    f1.setSize(800, 600);
    f1.setLocation(400, 100);
    f1.setLayout(null);
    jp1.setLayout(null);
    //jp2.setLayout(null);
    con.setBackground(new Color(49,48,90));
    f1.setResizable(false);
    f1.setVisible(true);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        
    }
    
    
public void actionPerformed(ActionEvent e)
{
   s1=tf1.getText();
   s2=tf2.getText();  
   
   if(e.getSource()==b1)
    {
        
        try
        {
        String Email_Pattern="^[a-zA-Z0-9'.:\']{1,20}@[a-zA-Z0-9]{1,20}.[a-zA-Z]{2,3}$";
        Pattern pattern=Pattern.compile(Email_Pattern);
        Matcher regexMatcher=pattern.matcher(tf1.getText());
        if(!regexMatcher.matches())
        {
           throw new ArithmeticException("Invalid Email");
        }
          
        
        else if(s2.length()==0)
          {
              throw new ArithmeticException("Enter course");
          }
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house of beats","root","");
        Statement st=conn.createStatement();
        String str="insert into add_ON(Email,Course)values('"+s1+"','"+s2+"')";
        st.executeUpdate(str);
        JOptionPane.showMessageDialog(null,"Success");
        f1.setVisible(false);
        
        
        }
        catch(Exception ex)
        {
         JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
    }
}
    

}
