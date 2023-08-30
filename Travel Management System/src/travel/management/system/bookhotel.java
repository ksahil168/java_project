package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class bookhotel extends JFrame {
    
    Choice chotel,cac,cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice, bookpackage,back;
    
  bookhotel(String username){
    this.username = username;
    setBounds(50,200,1100, 600);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel text = new JLabel("Book Hotel");
    text.setBounds(100,10,200,30);
    text.setFont(new Font("TAHOMA", Font.BOLD, 20));
    add(text);
    
    
    JLabel lblusername = new JLabel("Username");
       lblusername.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblusername.setBounds(40,70,100,20);
       add(lblusername);
       
       labelusername = new JLabel();
       lblusername.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       labelusername.setBounds(250,70,200,20);
       add(labelusername);
       //////////////////////////////////////
       
       JLabel lblpackage = new JLabel("Select Hotel");
       lblpackage.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblpackage.setBounds(40,110,150,20);
       add(lblpackage);
       
       chotel = new Choice();
       chotel.setBounds(250,110,200,20);
       add(chotel);
       
       try{
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("Select * from hotel");
           while(rs.next()){
               chotel.add(rs.getString("name"));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
       /////////////////////////////////////////////////////
       JLabel lblpersons = new JLabel("Total person");
       lblpersons.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblpersons.setBounds(40,150,150,25);
       add(lblpersons);
       
       tfpersons = new JTextField("1");
       tfpersons.setBounds(250,150,200,25);
       add(tfpersons);
       ///////////////////////////////////////////////////////
       
       JLabel lbldays = new JLabel("No. of Days");
       lbldays.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lbldays.setBounds(40,190,200,25);
       add(lbldays);
       
       tfdays = new JTextField("1");
       tfdays.setBounds(250,190,200,25);
       add(tfdays);
       /////////////////////////////////////////////////
       
       JLabel lblac = new JLabel("AC/Non-AC");
       lblac.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblac.setBounds(40,230,150,25);
       add(lblac);
       
       cac = new Choice();
       cac.add("AC");
       cac.add("Non-AC");
       cac.setBounds(250,230,200,20);
       add(cac);
       
       ////////////////////////////////////////////
       
       JLabel lblfood = new JLabel("Food Included");
       lblfood.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblfood.setBounds(40,270,150,25);
       add(lblfood);
       
       cfood = new Choice();
       cfood.add("Yes");
       cfood.add("No");
       cfood.setBounds(250,270,200,20);
       add(cfood);
    
       ///////////////////////////////////////////////////
       JLabel lblid = new JLabel("Id");
       lblid.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblid.setBounds(40,310,150,20);
       add(lblid);
       
       labelid = new JLabel();
       labelid.setBounds(250,310,200,25);
       add(labelid);
      //////////////////////////////////////////////////////// 
       JLabel lblnumber = new JLabel("Number");
       lblid.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblnumber.setBounds(40,350,150,25);
       add(lblnumber);
       
       labelnumber = new JLabel();
       labelnumber.setBounds(250,350,150,25);
       add(labelnumber);
       ///////////////////////////////////////////
       
       JLabel lblphone = new JLabel("Phone");
       lblphone.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblphone.setBounds(40,390,150,25);
       add(lblphone);
       
       labelphone = new JLabel();
       labelphone.setBounds(250,390,150,25);
       add(labelphone);
       
       /////////////////////////////////////////////
       
       JLabel lblprice = new JLabel("Total price");
       lblprice.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblprice.setBounds(40,430,150,25);
       add(lblprice);
       
       labelprice = new JLabel();
       labelprice.setBounds(250,430,150,25);
       add(labelprice);
       
       try{
           Conn conn = new Conn();
           String query = "Select * from customer where username = '"+username+"'" ;
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelphone.setText(rs.getString("phone"));
               
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       
       checkprice = new JButton("Check Price");
       checkprice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            try{
                            Conn c = new Conn();
                            ResultSet rs = c.s.executeQuery("Select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                            while(rs.next()){
                                int cost = Integer.parseInt(rs.getString("costperperson"));
                                int food = Integer.parseInt(rs.getString("foodincluded"));
                                int ac = Integer.parseInt(rs.getString("acroom"));
                                
                                int persons = Integer.parseInt(tfpersons.getText());
                                int days = Integer.parseInt(tfdays.getText());
                                 
                                String acselected = cac.getSelectedItem();
                                String foodselected = cfood.getSelectedItem();
                                
                                if(persons * days>0){
                                    int total =0;
                                    total += acselected.equals("AC") ? ac : 0;
                                    total += foodselected.equals("Yes") ? food : 0;
                                    total += cost;
                                    total = total * persons *days;
                                    labelprice.setText("Rs " + total);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Please enter a valid number");
                                }
                            }
                            }catch(Exception c){
                                c.printStackTrace();
                            }
                        }
		});
       checkprice.setBackground(Color.BLACK);
       checkprice.setForeground(Color.WHITE);
       checkprice.setBounds(60,490,120,25);
       add(checkprice);
       
       bookpackage = new JButton("Book Package");
       bookpackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			String s1 = chotel.getSelectedItem(); 
                                
                                String q1 = "insert into bookhotel values('"+username+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"' ,'"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                                setVisible(false);
                            }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                            }
                            
			}
		});
       bookpackage.setBackground(Color.BLACK);
       bookpackage.setForeground(Color.WHITE);
       bookpackage.setBounds(200,490,120,25);
       add(bookpackage);
       
       
       back = new JButton("Back");
       back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		});
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(340,490,120,25);
       add(back);
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
       Image i5 = i4.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel icon2 = new JLabel(i6);
       icon2.setBounds(500,50,600,300);
       add(icon2);
    
    setVisible(true);
  }
  
 
  
 
  public static void main(String[] args){
      new bookhotel("kumar");
  }
    
}
