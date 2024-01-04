/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summerproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author SUJAL
 */
public class C 
{
    Connection con;
    Statement state;
    public C()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root","");
            state = con.createStatement();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) 
    {
        new C();
    }

    void close() {
        try {
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
