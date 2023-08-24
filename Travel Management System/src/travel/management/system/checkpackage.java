
package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class checkpackage extends JFrame {
    
    checkpackage(){
        setBounds(450,200,900,600);
        
        String[] package1 = {"Gold Package",   "6 Days and 7 Nights",   "Airport Assistant",   "Half Day city Tour",         "Half Day Tour",                "Daily Buffet",      "Full day 1 island tour", "English Guide",    "Book package",     "Summer special",   "Rs 12000/-",  "package1.jpg"};
        String[] package2 = {"Silver Package", "5 Days and 6 Nights",   "Toll free Tickets",   "Meet and Greet at Airport",  "Welcome Drinks on arrival",    "Night safari",      "Cruise with dinner",     "English Guide",      "Book now",         "Winter special",   "Rs 24000/-",  "package2.jpg" };
        String[] package3 = {"Bronze Package", "4 Days and 5 Nights",   "Return Airfare",      "Free Club",                  "hard drinks availble",         "Daily buffet",      "BBQ Dinner",             "English Guide",     "Book now",         "Winter special",   "Rs 32000/-",  "package3.jpg" };
        
        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1 = createpackage(package1);
        tab.addTab("Package 1", null, p1);
        
        JPanel p2 = createpackage(package2);
        tab.addTab("Package 2", null, p2);
        
        JPanel p3 = createpackage(package3);
        tab.addTab("Package 3", null, p3);
        
        add(tab);
        
        setVisible(true);
    }
    
    public JPanel createpackage(String [] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("TAHOME", Font.BOLD, 30 ));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(60,430,300,30);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(80,480,300,30);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l10);
        
        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(500,480,300,30);
        l11.setForeground(Color.CYAN);
        l11.setFont(new Font("TAHOME", Font.BOLD, 20 ));
        p1.add(l11);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(350,20,500,300);
        p1.add(icon);
        
        return p1;
    }
    
    public static void main(String[] args){
    new checkpackage();

}
 }

