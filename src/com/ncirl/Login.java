package com.ncirl;
import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
public class Login extends JFrame
{
    /****
     * @author Austin Dowdall
     * 06/02/2017
     *
     */

    //declaring our GUI components
    // JLabel l_name,l_pass;
    // JTextField t_name;
    // JPasswordField t_pass;
    // JButton button;
    Container c;


    JLabel l_name = new JLabel("Username");
    JLabel l_pass = new JLabel("Password");
    JTextField t_name=new JTextField(20);
    JPasswordField t_pass=new JPasswordField(20);
    JButton button=new JButton("Login");

    Font font = new Font("Courier",Font.BOLD, 28);
    //l_name.setFont(font);


    //frame.add(label);
    //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //frame.pack();
    //frame.setVisible(true);



    //a inner class to handling ActionEvents
    handler handle;

    //a separate class for processing database connection and authentication
    User db;

    Login()
    {
        super("Login form");

        c=getContentPane();
        c.setLayout(new FlowLayout());

        //calling class for connecting to database
        db=new User();
        handle =new handler();

        //swing GUI components
        //       l_name=new JLabel("Username");
        //     l_pass=new JLabel("Password");
        //    t_name=new JTextField(20);
        //    t_pass=new JPasswordField(20);
        //    button=new JButton("Login");

        //adding actionlistener to the button
        button.addActionListener(handle);

        //add to container
        c.add(l_name);
        c.add(t_name);
        c.add(l_pass);
        c.add(t_pass);
        c.add(button);
        //visual
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();


    }
    public static void main(String args[])
    {
        Login sample=new Login();
    }

    //an inner class .You can also write as a separate class
    class handler implements ActionListener
    {
        //must implement method
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
            //checks if the button clicked
            if(ae.getSource()==button)
            {
                char[] temp_pwd=t_pass.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:"+t_name.getText()+","+pwd);

                //The entered Username and password are sent via "checkLogin()" which return boolean
                if(db.checkLogin(t_name.getText(), pwd))
                {
                    //a pop-up box
                    JOptionPane.showMessageDialog(null, "Login successfull","Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    //a pop-up box
                    JOptionPane.showMessageDialog(null, "Username or Password Incorrect","Login Error!",
                            JOptionPane.ERROR_MESSAGE);
                }
            }//if
        }//method

    }//inner class
}//class