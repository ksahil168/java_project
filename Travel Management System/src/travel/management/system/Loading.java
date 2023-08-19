
package travel.management.system;
import javax.swing.*;
import java.awt.*;


public class Loading extends JFrame implements Runnable{
    Thread t;
    int s;
    String username;
    private JPanel contentPane;
    private JProgressBar progressBar;
    
 public void run(){
        try{
            for(int i = 1; i<=101; i++){
                int max = progressBar.getMaximum();
                int value = progressBar.getValue();
                
                if(value < max){ 
                    progressBar.setValue(progressBar.getValue() + 1);
                }else{
                    setVisible(false);
                    new dashboard(username);
                }
                Thread.sleep(30);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    Loading(String username){
     
     this.username = username;
     t = new Thread(this);
     
     
    setBounds(600, 300, 600, 400);
    contentPane = new JPanel();
    contentPane.setBackground(new Color(51,204, 255));
    setContentPane(contentPane);
    contentPane.setLayout(null);
     
     JLabel text = new JLabel("Travel and Tourism Application");
     text.setBounds(50, 20,600,40);
     text.setForeground(Color.BLUE);
     text.setFont(new Font("Railway", Font.BOLD, 35));
     add(text);
     
     
      progressBar = new JProgressBar();
      progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
      progressBar.setStringPainted(true);
      progressBar.setBounds(130, 135, 300, 25);
      add(progressBar);
     
     JLabel loading = new JLabel("Loading, please wait...");
     loading.setBounds(200, 165, 150, 20);
     loading.setForeground(Color.RED);
     loading.setFont(new Font("Railway", Font.BOLD, 13));
     add(loading);
     
     JLabel username1 = new JLabel("Welcome " + username);
     username1.setBounds(20, 310,400,40);
     username1.setForeground(Color.RED);
     username1.setFont(new Font("Railway", Font.BOLD, 16));
     add(username1);
     
     t.start();
     setVisible(true);
    }
    public static void main(String[] args){
        new Loading("").setVisible(true);;
    }
}
