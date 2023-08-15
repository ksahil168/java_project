
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

        
public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField tu1,pn1,tn1,tfanswer,an1;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD,14));
        l1.setBounds(50,20,125,25);
        p1.add(l1);
        
        tu1 = new JTextField();
        tu1.setBounds(190,20,190,25);
        tu1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tu1);
        
        /////////////////////////////////////////////////////
        
        JLabel ln1 = new JLabel("Name");
        ln1.setFont(new Font("Tahoma", Font.BOLD,14));
        ln1.setBounds(50,60,125,25);
        p1.add(ln1);
        
        tn1 = new JTextField();
        tn1.setBounds(190,60,190,25);
        tn1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tn1);
        
        /////////////////////////////////////////////////////
        
        JLabel pa1 = new JLabel("Password");
        pa1.setFont(new Font("Tahoma", Font.BOLD,14));
        pa1.setBounds(50,100,125,25);
        p1.add(pa1);
        
        pn1 = new JTextField();
        pn1.setBounds(190,100,190,25);
        pn1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(pn1);
        
        ///////////////////////////////////////////////////////
        
        JLabel security1 = new JLabel("Security Question");
        security1.setFont(new Font("Tahoma", Font.BOLD,14));
        security1.setBounds(50,140,125,25);
        p1.add(security1);
        
        security = new Choice();
        security.add("Fav Character from the Boys");
        security.add("Fav Marvel superhero");
        security.add("Your Lucky number");
        security.add("Your Childhood superhero");
        security.setBounds(190,140,180,25);
        p1.add(security);  
        
        //////////////////////////////////////////////////
        
         JLabel a1 = new JLabel("Answer");
        a1.setFont(new Font("Tahoma", Font.BOLD,14));
        a1.setBounds(50,180,125,25);
        p1.add(a1);
        
        an1 = new JTextField();
        an1.setBounds(190,180,190,25);
        an1.setBorder(BorderFactory.createEmptyBorder());
        p1.add(an1);
        
        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("TAHOMA", Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        ////////////////////////////////////////////////////
        
        back = new JButton("Back");
	back.addActionListener(this);
	back.setFont(new Font("TAHOMA", Font.BOLD,14));
	back.setBounds(250,250,100,30);
	back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
	p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(("icons/signup.png")));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ac){
        if(ac.getSource() == create){
           String username =  tu1.getText();
           String name =  tn1.getText();
           String password =  pn1.getText();
           String question =  security.getSelectedItem();
           String answer =  an1.getText();
            
           String query = "Insert into account values('"+username+"','"+name+"', '"+password+"', '"+question+"', '"+answer+"' )";
           try{
               Conn c = new Conn();
               c.s.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Account Created Successfully");
               setVisible(false);
               new Login();
               
           }catch(Exception e){
               e.printStackTrace();
           }
        }
        else if(ac.getSource() == back){
           this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Signup();
    }

    
}
