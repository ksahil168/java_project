package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class BookPackage extends JFrame {
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice, bookpackage,back;
    
  BookPackage(String username){
    this.username = username;
    setBounds(50,200,1100, 500);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel text = new JLabel("Book Package");
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
       JLabel lblpackage = new JLabel("Select Package");
       lblpackage.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblpackage.setBounds(40,110,150,20);
       add(lblpackage);
       
       cpackage = new Choice();
       cpackage.add("Gold Package");
       cpackage.add("Silver Package");
       cpackage.add("Bronze Package");
       cpackage.setBounds(250,110,200,20);
       add(cpackage);
       
       /////////////////////////////////////////////////////
       JLabel lblpersons = new JLabel("Total person");
       lblpersons.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblpersons.setBounds(40,150,150,25);
       add(lblpersons);
       
       tfpersons = new JTextField("1");
       tfpersons.setBounds(250,150,200,25);
       add(tfpersons);
    
       ///////////////////////////////////////////////////
       JLabel lblid = new JLabel("Id");
       lblid.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblid.setBounds(40,190,150,20);
       add(lblid);
       
       labelid = new JLabel();
       labelid.setBounds(250,190,200,25);
       add(labelid);
      //////////////////////////////////////////////////////// 
       JLabel lblnumber = new JLabel("Number");
       lblid.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblnumber.setBounds(40,230,150,25);
       add(lblnumber);
       
       labelnumber = new JLabel();
       labelnumber.setBounds(250,230,150,25);
       add(labelnumber);
       ///////////////////////////////////////////
       
       JLabel lblphone = new JLabel("Phone");
       lblphone.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblphone.setBounds(40,270,150,25);
       add(lblphone);
       
       labelphone = new JLabel();
       labelphone.setBounds(250,270,150,25);
       add(labelphone);
       
       /////////////////////////////////////////////
       
       JLabel lblprice = new JLabel("Total price");
       lblprice.setFont(new Font("TAHOMA", Font.PLAIN, 16));
       lblprice.setBounds(40,310,150,25);
       add(lblprice);
       
       labelprice = new JLabel();
       labelprice.setBounds(250,310,150,25);
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
                            String p = cpackage.getSelectedItem();
                            int cost = 0;
                            if(p.equals("Gold Package")) {
                                cost += 12000;
                            }if(p.equals("Silver Package")){
                                cost += 25000;
                            }else if(p.equals("Bronze Package")){
                                cost += 32000;
                            }
                            
                            int persons = Integer.parseInt(tfpersons.getText());
                            cost*= persons;
                            labelprice.setText("Rs " + cost);
                            
                        }
		});
       checkprice.setBackground(Color.BLACK);
       checkprice.setForeground(Color.WHITE);
       checkprice.setBounds(60,380,120,25);
       add(checkprice);
       
       bookpackage = new JButton("Book Package");
       bookpackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            Conn c = new Conn();
                           
                          
                            try{
	    			String s1 = cpackage.getSelectedItem(); 
                                
                                String q1 = "insert into bookpackage values('"+username+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')";
                                c.s.executeUpdate(q1);
                                
	    			JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                                setVisible(false);
                            }catch(Exception ee){
	    			System.out.println(ee.getMessage());
                            }
                            
			}
		});
       bookpackage.setBackground(Color.BLACK);
       bookpackage.setForeground(Color.WHITE);
       bookpackage.setBounds(200,380,120,25);
       add(bookpackage);
       
       
       back = new JButton("Back");
       back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		});
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(340,380,120,25);
       add(back);
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/Bookpackage.jpg"));
       Image i5 = i4.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel icon2 = new JLabel(i6);
       icon2.setBounds(550,50,500,300);
       add(icon2);
    
    setVisible(true);
  }
  
 
  
 
  public static void main(String[] args){
      new BookPackage("kumar");
  }
    
}
