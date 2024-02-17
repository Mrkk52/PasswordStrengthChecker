package passwordstrengthchecker;

/**
 *
 * @author Kinkar
 */

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PasswordStrengthChecker extends JFrame{
 
   
    JTextField input;
    JLabel title,number,resultLabel;
    JButton button,cancle,clear;
    Border border;
    
    public void checkPasswordStrength(){
        getContentPane().setBackground(new Color(255, 255, 240));
        setTitle("Password Strength Checker");
        setLayout(null);
        setSize(600,500);
        setLocation(150,20);
        setVisible(true);
        
        //===== Tittle =========================================================
        
        title = new JLabel("Password Strength Checker");
        title.setBounds(100,20,400,40);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        add(title);
        
        //========= Select any one==============================================
        
        number = new JLabel("Enter Password : ");;
        number.setFont(new Font("Arial", Font.BOLD, 15));
        number.setBounds(70,100,150,30);
        number.setFont(new Font("Arial", Font.BOLD, 15));        
        number.setForeground(Color.blue);
        number.setBackground(Color.white);
        add(number);
        
        
        input = new JTextField();
        input.setBounds(205, 100, 300,30);
        input.setBorder(border);
        input.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        input.setOpaque(false);
        input.setFont(new Font("Arial", Font.BOLD, 18));        
        add(input);
        
        
        //======================================================================
        
        //====================Check============================================
        
        button = new JButton("Check");
        button.setBounds(100,400,80,30);
        button.setBackground(Color.black);
        button.setBorder(border);
        button.setFont(new Font("Sans-sarif", Font.BOLD, 17));                
        button.setForeground(Color.white);
        add(button);
        
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkStrength();
            }
        });
        
        //====================Cancel============================================
        
        cancle = new JButton("Cancel");
        cancle.setBounds(400,400,80,30);
        cancle.setBackground(Color.black);
        cancle.setFont(new Font("Sans-sarif", Font.BOLD, 17));        
        cancle.setBorder(border);
        cancle.setForeground(Color.white);
        add(cancle);
        
        cancle.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                setVisible(false);
            }
        });
        
        //====================Clear============================================
        
        clear = new JButton("Clear");
        clear.setBounds(250,400,80,30);
        clear.setBackground(Color.black);
        clear.setBorder(border);
        clear.setFont(new Font("Sans-sarif", Font.BOLD, 17));        
        clear.setForeground(Color.white);
        add(clear);
        
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               resultLabel.setText("");
               input.setText("");
            }
        });
        //===================Result=============================================
        
        resultLabel = new JLabel();
        resultLabel.setBounds(35,200,500,30);
        resultLabel.setBackground(Color.cyan);
        resultLabel.setForeground(Color.magenta);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(resultLabel);
    }
    private void checkStrength() {
            String password = input.getText();
            int length = input.getText().length();
            
        try{
            if (length > 0) {
                boolean hasUppercase = !password.equals(password.toLowerCase());
                boolean hasLowercase = !password.equals(password.toUpperCase());
                boolean hasDigit = password.matches(".*\\d.*");
                boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

                if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
                    resultLabel.setText("\""+input.getText() + "\" Password is Strong");
                } else if (length >= 6 && (hasUppercase || hasLowercase) && (hasDigit || hasSpecialChar)) {
                    resultLabel.setText("\""+input.getText() + "\" Password is Moderate");
                } else {
                    resultLabel.setText("\""+input.getText() + "\" Password is Week");
                }
            }
            else{
                resultLabel.setText("Please Enter Password");
            }
        }catch(NumberFormatException e){
            resultLabel.setText("Please Enter Password");
        }
    }
    public static void main(String[] args) {
        PasswordStrengthChecker obj = new PasswordStrengthChecker();
        obj.checkPasswordStrength();
    }
}
