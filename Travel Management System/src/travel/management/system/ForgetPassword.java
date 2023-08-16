
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername, tfname, tfquestion,tfanswer,tfpassword;
    JButton search, retrieve,back;
    
    ForgetPassword(){
    
        
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("icons/forgotpassword.jpg")));        
        Image i2 = i1.getImage().getScaledInstance(210, 210, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,260);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
      //////////////////////////////////////////////////  
        JLabel u1 = new JLabel("Username");
        u1.setBounds(40, 20, 100, 25);
        u1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(u1);
        
        tfusername = new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
       //////////////////////////////////////////////////////////////
        
        JLabel n1 = new JLabel("Name");
        n1.setBounds(40, 60, 100, 25);
        n1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(n1);
        
        tfname = new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        ////////////////////////////////////////////////////////
        
        JLabel q1 = new JLabel("Security Question");
        q1.setBounds(40, 100, 200, 25);
        q1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(q1);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        ////////////////////////////////////////////////////
        
        JLabel a1 = new JLabel("Answer");
        a1.setBounds(40, 140, 200, 25);
        a1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(a1);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(220,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        //////////////////////////////////////////////
        
        JLabel pa1 = new JLabel("Password");
        pa1.setBounds(40, 180, 200, 25);
        pa1.setFont(new Font("Tahoma", Font.BOLD, 14));
        p1.add(pa1);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource()==search)
        {
            try {
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
               ResultSet re = c.s.executeQuery(query);
               while(re.next()){
                   tfname.setText(re.getString("name"));
                   tfquestion.setText(re.getString("security"));
               }
            }catch(Exception e){
            
                e.printStackTrace();
            }
                
            
        }
        else if(ac.getSource()== retrieve)
        {
        try {
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
               ResultSet re = c.s.executeQuery(query);
               while(re.next()){
                   tfpassword.setText(re.getString("password"));
                  
               }
            }catch(Exception e){
            
                e.printStackTrace();
            }    
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new ForgetPassword();
    }
            
}
