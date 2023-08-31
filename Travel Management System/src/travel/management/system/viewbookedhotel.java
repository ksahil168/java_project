package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class viewbookedhotel extends JFrame  {
    
    JButton back;
    
    viewbookedhotel(String username){
       setBounds(400,200,1000,600);
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel text = new JLabel("View Booked Hotel Details");
       text.setFont((new Font("TAHOMA", Font.BOLD, 20)));
       text.setBounds(60,0,300,30);
       add(text);
       
       
       JLabel lblusername = new JLabel("Username");
       lblusername.setBounds(30,50,150,25);
       add(lblusername);
       
       JLabel labelusername = new JLabel();
       labelusername.setBounds(220,50,150,25);
       add(labelusername);
       
       JLabel lblid = new JLabel("Hotel Name");
       lblid.setBounds(30,90,150,25);
       add(lblid);
       
       JLabel labelpackage = new JLabel();
       labelpackage.setBounds(220,90,150,25);
       add(labelpackage);
       /////////////////////////////////////////////////////
       JLabel lblnumber = new JLabel("Total Persons");
       lblnumber.setBounds(30,130,150,25);
       add(lblnumber);
       
       JLabel labelpersons = new JLabel();
       labelpersons.setBounds(220,130,150,25);
       add(labelpersons);
       
       /////////////////////////////////////////////
       JLabel lbldays = new JLabel("Total Days");
       lbldays.setBounds(30,170,150,25);
       add(lbldays);
       
       JLabel labeldays = new JLabel();
       labeldays.setBounds(220,170,150,25);
       add(labeldays);
       /////////////////////////////////////////////////
       JLabel lblac = new JLabel("AC/Non-AC");
       lblac.setBounds(30,210,150,25);
       add(lblac);
       
       JLabel labelac = new JLabel();
       labelac.setBounds(220,210,150,25);
       add(labelac);
       ////////////////////////////////////////////////
       JLabel lblfood = new JLabel("Food Included");
       lblfood.setBounds(30,250,150,25);
       add(lblfood);
       
       JLabel labelfood = new JLabel();
       labelfood.setBounds(220,250,150,25);
       add(labelfood);
       ///////////////////////////////////////////////////
       
       JLabel lblname = new JLabel("id");
       lblname.setBounds(30,290,150,25);
       add(lblname);
       
       JLabel labelid = new JLabel();
       labelid.setBounds(220,290,150,25);
       add(labelid);
      
       //////////////////////////////////////////////////////// 
      
       JLabel lblgender = new JLabel("Number");
       lblgender.setBounds(30,330,150,25);
       add(lblgender);
       
       JLabel labelnumber = new JLabel();
       labelnumber.setBounds(220,330,150,25);
       add(labelnumber);
      
      /////////////////////////////////////////////////////////// 
       
      JLabel lblcountry = new JLabel("Phone");
       lblcountry.setBounds(30,370,150,25);
       add(lblcountry);
       
       JLabel labelphone = new JLabel();
       labelphone.setBounds(220,370,150,25);
       add(labelphone);
      
       //////////////////////////////////////////////////////
       
       JLabel lblcost = new JLabel("Total Cost");
       lblcost.setBounds(30,410,150,25);
        add(lblcost);
       
       JLabel labelcost = new JLabel();
       labelcost.setBounds(220,410,150,25);
       add(labelcost);
       
       /////////////////////////////////////////////////
       
       
       back = new JButton("Back");
       back.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent e) {
	     setVisible(false);
		}
	});
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(130,460,100,25);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
       Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel icon = new JLabel(i3);
       icon.setBounds(450,20,500,400);
       add(icon);
       
     
       
       try{
           Conn conn = new Conn();
           String query = "Select * from bookhotel where username = '"+username+"'" ;
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelpackage.setText(rs.getString("name"));
               labelcost.setText(rs.getString("Price"));
               labelphone.setText(rs.getString("phone"));
               labelpersons.setText(rs.getString("persons"));
               labelfood.setText(rs.getString("food"));
               labeldays.setText(rs.getString("days"));
               labelac.setText(rs.getString("ac"));
              
               
           }
       }catch(Exception e){
           
       }
       
       setVisible(true);
    }
    

    
    public static void main(String[] args){
        new viewbookedhotel("kumar");
    }
}
