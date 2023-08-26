
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener{
    String username;
    JButton bookpackages,addPersonalDetails,viewpersonaldetails,checkpackages ,updatepersonaldetails;
    dashboard(String username){
        this.username = username;
   //     setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 30));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("TAHOMA",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,70));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatepersonaldetails = new JButton("Update Personal Details");
        updatepersonaldetails.setBounds(0,50,300,50);
        updatepersonaldetails.setBackground(new Color(0,0,102));
        updatepersonaldetails.setForeground(Color.WHITE);
        updatepersonaldetails.setFont(new Font("TAHOMA",Font.PLAIN,20));
        updatepersonaldetails.setMargin(new Insets(0,0,0,40));
        updatepersonaldetails.addActionListener(this);
        p2.add(updatepersonaldetails);
        
        viewpersonaldetails = new JButton("View Details");
        viewpersonaldetails.setBounds(0,100,300,50);
        viewpersonaldetails.setBackground(new Color(0,0,102));
        viewpersonaldetails.setForeground(Color.WHITE);
        viewpersonaldetails.setFont(new Font("TAHOMA",Font.PLAIN,20));
        viewpersonaldetails.setMargin(new Insets(0,0,0,140));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);
        
        JButton deletepersonaldetails = new JButton("Delete Personal Details");
        deletepersonaldetails.setBounds(0,150,300,50);
        deletepersonaldetails.setBackground(new Color(0,0,102));
        deletepersonaldetails.setForeground(Color.WHITE);
        deletepersonaldetails.setFont(new Font("TAHOMA",Font.PLAIN,20));
        deletepersonaldetails.setMargin(new Insets(0,0,0,50));
        p2.add(deletepersonaldetails);
        
        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("TAHOMA",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackages = new JButton("Book Packages");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.WHITE);
        bookpackages.setFont(new Font("TAHOMA",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,120));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        
        JButton viewpackages = new JButton("View Packages");
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.WHITE);
        viewpackages.setFont(new Font("TAHOMA",Font.PLAIN,20));
        viewpackages.setMargin(new Insets(0,0,0,120));
        p2.add(viewpackages);
        
        JButton viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("TAHOMA",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,145));
        p2.add(viewhotels);
        
        JButton bookhotels = new JButton("Book Hotels");
        bookhotels.setBounds(0,400,300,50);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.WHITE);
        bookhotels.setFont(new Font("TAHOMA",Font.PLAIN,20));
        bookhotels.setMargin(new Insets(0,0,0,145));
        p2.add(bookhotels);
        
        JButton viewbookedhotels = new JButton("View Booked Hotels");
        viewbookedhotels.setBounds(0,450,300,50);
        viewbookedhotels.setBackground(new Color(0,0,102));
        viewbookedhotels.setForeground(Color.WHITE);
        viewbookedhotels.setFont(new Font("TAHOMA",Font.PLAIN,20));
        viewbookedhotels.setMargin(new Insets(0,0,0,75));
        p2.add(viewbookedhotels);
        
        JButton destination = new JButton("Destination");
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("TAHOMA",Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,155));
        p2.add(destination);
        
        JButton payments = new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("TAHOMA",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,165));
        p2.add(payments);
        
        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("TAHOMA",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,165));
        p2.add(calculator);
        
        JButton notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("TAHOMA",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,175));
        p2.add(notepad);
        
        JButton about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("TAHOMA",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,195));
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text = new JLabel ("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway", Font.PLAIN, 55));
        image.add(text);
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonalDetails){
            new addcustomer(username);
        }else if(ae.getSource()== viewpersonaldetails){
            new ViewCustomer(username);
        }else if(ae.getSource()== updatepersonaldetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()== checkpackages){
            new checkpackage();
        }else if(ae.getSource()== bookpackages){
            new BookPackage(username);
    }
    }
public static void main(String[] args){
    new dashboard("");
}    
}
