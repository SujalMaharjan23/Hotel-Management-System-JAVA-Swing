package summerproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author SUJAL
 */
public class aaaddcustomer extends JFrame implements ActionListener
{
    JTextField tname,tcontact,tcountry,temail,tdeposit,tnationality,tpostal;
    JLabel tcheckin, tcheckintime, tphoto, l;
    JRadioButton male,female;
    JComboBox cmb;
    Choice croom;
    JButton submit, back, pbutton;
    Connection c2;
    PreparedStatement state, state1, state2;
    String s;
    public aaaddcustomer()
    {
        
        getContentPane().setBackground(Color.WHITE);
                
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(150,20,300,25);
        text.setFont(new Font("Stencil",Font.BOLD,25));
        text.setForeground(Color.BLUE);
        
        JLabel name = new JLabel("Name");
        name.setBounds(20,60,45,20);
        tname = new JTextField(50);
        tname.setBounds(120,60,120,20);
        
        
        JLabel contact = new JLabel("Contact");
        contact.setBounds(20,100,45,20);
        tcontact = new JTextField(50);
        tcontact.setBounds(120,100,120,20);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(20,140,45,20);
        
        male = new JRadioButton("Male",true);
        male.setBounds(120,140,55,20);
        male.setBackground(Color.white);
        
	female = new JRadioButton("Female",true);
        female.setBounds(180,140,100,20);
        female.setBackground(Color.white);
        
	ButtonGroup bg = new ButtonGroup();
	bg.add(male);
	bg.add(female); 
        
        JLabel id = new JLabel("ID");
        id.setBounds(20,180,45,20);
        String ids[] ={"","Citizenship","License","VoterCard","Passport"};
        cmb = new JComboBox(ids);
	cmb.setBounds(120,180,120,20);
        cmb.setBackground(Color.white);
        cmb.addActionListener(new IdAction());
        
        JLabel country = new JLabel("Arrival From");
        country.setBounds(20,220,70,20);
        tcountry = new JTextField(50);
        tcountry.setBounds(120,220,120,20);
        
        JLabel nationality = new JLabel("Nationality");
        nationality.setBounds(20,260,70,20);
        tnationality = new JTextField(50);
        tnationality.setBounds(120,260,120,20);
        
        JLabel postal = new JLabel("Postal Address");
        postal.setBounds(20,300,90,20);
        tpostal = new JTextField(50);
        tpostal.setBounds(120,300,120,20);
        
        JLabel email = new JLabel("Email");
        email.setBounds(20,340,45,20);
        temail = new JTextField(50);
        temail.setBounds(120,340,120,20);
        
        JLabel roomno = new JLabel("Room");
        roomno.setBounds(20,380,45,20);

        croom = new Choice();
        croom.setBounds(120,380,120,20);
        try
        {
            C con = new C();
            String sql = "SELECT * FROM rooms where availability = 'Available'";
            ResultSet rs = con.state.executeQuery(sql);
            while(rs.next()) 
            {
                croom.add(rs.getString("roomnumber"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
              
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(20,420,45,20);
        tdeposit = new JTextField(50);
        tdeposit.setBounds(120,420,120,20);
        
        JLabel checkin = new JLabel("Check-in-Date");
        checkin.setBounds(20,460,100,20);
        
        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/YYYY");
        
        tcheckin = new JLabel("" + sd.format(date));
        tcheckin.setBounds(120,460,120,20);
        
        JLabel checkintime = new JLabel("Check-in-Time");
        checkintime.setBounds(20,500,100,20);
        SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
        
        tcheckintime = new JLabel("" + sdt.format(date));
        tcheckintime.setBounds(120,500,120,20);
        
        tphoto = new JLabel("");
        tphoto.setBounds(120,540,120,20);
        
        pbutton = new JButton("Upload ID");
        pbutton.setBounds(20,540,88,20);
        pbutton.setBackground(Color.DARK_GRAY);
        pbutton.setForeground(Color.WHITE);
        pbutton.addActionListener(new uploadAction());

        back = new JButton("BACK");
        back.setBounds(20,580,90,30);        
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
         
        submit = new JButton("ADD");
        submit.setBounds(120,580,120,30);        
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i1 = i.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        l = new JLabel(i2);
        l.setBounds(280,120,350,350);
        add(l);
        
        add(text);
        add(name);
        add(tname);
        add(contact);
        add(tcontact);
        add(gender);
        add(male);
        add(female);
        add(id);
        add(cmb);
        add(country);
        add(tcountry);
        add(nationality);
        add(tnationality);
        add(postal);
        add(tpostal);
        add(email);
        add(temail);
        add(roomno);
        add(croom);
        add(deposit);
        add(tdeposit);
        add(checkin);
        add(tcheckin);
        add(checkintime);
        add(tcheckintime);
        add(pbutton);
        add(tphoto);
        add(back);
        add(submit);
        
        setLayout(null);
        setSize(650,660);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new aaaddcustomer();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String dname = tname.getText();
        String dcontact = tcontact.getText();
        String dgender = null;
        if(male.isSelected())
        {
            dgender = "Male";
        }
        else if(female.isSelected())
        {
            dgender = "Female";
        }
        String did = (String) cmb.getSelectedItem();
        String dcountry = tcountry.getText();
        String dnationality = tnationality.getText();
        String dpostal = tpostal.getText();
        String demail = temail.getText();
        String droom = croom.getSelectedItem();
        String ddeposit = tdeposit.getText();
        String dtime = tcheckin.getText();
        String ddate = tcheckintime.getText();
        
        if(ae.getSource()==submit)
        {
            if(validation()==true)
            {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                c2 = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root","");
                state = c2.prepareStatement("insert into customerdatabase (`name`, `contact`, `gender`, `id`, `arrival_from`, `nationality`, `postal_address`, `email`, `room`, `deposit`, `time`, `date`, `photo`)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                state1 = c2.prepareStatement("update rooms set availability = 'occupied' where roomnumber = ?");
                state2 = c2.prepareStatement("insert into data (`name`, `contact`, `gender`, `id`, `country`, `email`) values(?,?,?,?,?,?)");
                InputStream is = new FileInputStream(new File(s));
                state.setString(1,dname);
                state.setString(2,dcontact);
                state.setString(3,dgender);
                state.setString(4,did);
                state.setString(5,dcountry);
                state.setString(6,dnationality);
                state.setString(7,dpostal);
                state.setString(8,demail);
                state.setString(9,droom);
                state.setString(10,ddeposit);
                state.setString(11,dtime);
                state.setString(12,ddate);
                state.setBlob(13,is);
                state.executeUpdate();
                
                
                state1.setString(1,droom);
                state1.executeUpdate();
                
                state2.setString(1,dname);
                state2.setString(2,dcontact);
                state2.setString(3,dgender);
                state2.setString(4, did);
                state2.setString(5, dcountry);
                state2.setString(6, demail);
                state2.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Customer added successfully!!!");
                int b = JOptionPane.showConfirmDialog(null, "Do you want to print the guest register card?", "Print?", JOptionPane.YES_NO_OPTION);
                if(b==0)
                {
                    scrollprint p = new scrollprint();
                    p.setVisible(true);
                    setVisible(false);
                }
                else
                {
                    setVisible(false);
                    new reception();
                }
                c2.close();
                
            }
            catch(Exception e) 
            {
                System.out.print(e);
            }
            }
        }
        if(ae.getSource()==back)
        {
            setVisible(false);
            new admin();
        }
    }

    
    class uploadAction implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e2) 
        {
            if(e2.getSource()==pbutton)
            {
                JFileChooser filechooser = new JFileChooser();
                filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE","jpg","jpeg","png","gif");
                filechooser.addChoosableFileFilter(filter);
                int result = filechooser.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION)
                {
                    File selectedfile = filechooser.getSelectedFile();
                    String path = selectedfile.getAbsolutePath();
                    l.setIcon(ResizeImage(path));
                    s= path;
                    tphoto.setText(s);
                }
            }
        }
        
    }
    
    public ImageIcon ResizeImage(String imgpath)
    {
        ImageIcon myimg = new ImageIcon(imgpath);
        Image imge = myimg.getImage();
        Image newimage = imge.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newimage);
        return image;
    }
    
    class IdAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent aae) 
        {
                int i = JOptionPane.showConfirmDialog(null,"Do you want to scan?","Scanner",JOptionPane.YES_NO_OPTION);
                if(i== 0)
                {
                    try 
                    {
                        // Open printer settings
                        // Runtime.getRuntime().exec("control printers");

                        // Open scanner settings
                         Runtime.getRuntime().exec("control /name Microsoft.ScannersAndCameras");
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
        }      
    }
    
    
    public boolean validation()
    {
        if(tname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter name.");
            tname.requestFocus();
            return false;
        }
        if(tcontact.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter contact number.");
            tcontact.requestFocus();
            return false;
        }
        if(tcountry.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter your country.");
            tcountry.requestFocus();
            return false;
        }
        if(croom.getSelectedItem()==null)
        {
            JOptionPane.showMessageDialog(this, "Room number is not allocated.");
            return false;
        }
        if(tphoto.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Upload ID.");
            pbutton.setForeground(Color.red);
            pbutton.requestFocus();
            return false;
        }
        return true;
    }
}
