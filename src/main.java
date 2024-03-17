import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

// Import necessary packages for SQL
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

public class main {

    private JFrame frame;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    main window = new main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(131, 192, 193));
        frame.setBounds(100, 100, 878, 423);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                rent rt = new rent();
                rt.setVisible(true);
            }
        });
        panel.setBackground(new Color(105, 98, 173));
        panel.setForeground(new Color(0, 0, 0));
        panel.setBounds(10, 84, 217, 55);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(10, 0, 50, 50);
        panel.add(lblNewLabel);

        // image magic section
        Image img = new ImageIcon(this.getClass().getResource("/car.png")).getImage();
        int width = 50; // Set your desired width
        int height = 50; // Set your desired height
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        lblNewLabel.setIcon(new ImageIcon(resizedImg));

        JLabel lblcar_text = new JLabel(" RENT / BORROW");
        lblcar_text.setForeground(new Color(255, 255, 255));
        lblcar_text.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblcar_text.setBounds(69, 0, 148, 55);
        panel.add(lblcar_text);

        JPanel panel_return = new JPanel();
        panel_return.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
                frame.dispose();
                returnn ru = new returnn();
                ru.setVisible(true);
        		
        	}
        });
        panel_return.setForeground(Color.BLACK);
        panel_return.setBackground(new Color(105, 98, 173));
        panel_return.setBounds(10, 150, 217, 55);
        frame.getContentPane().add(panel_return);
        panel_return.setLayout(null);

        JLabel lblreturn = new JLabel("");
        lblreturn.setBounds(10, 0, 50, 50);
        panel_return.add(lblreturn);
        Image img1 = new ImageIcon(this.getClass().getResource("/return.png")).getImage();
        Image resizedImg1 = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        lblreturn.setIcon(new ImageIcon(resizedImg1));

        JLabel lblreturn_text = new JLabel("        RETURN");
        lblreturn_text.setForeground(Color.WHITE);
        lblreturn_text.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblreturn_text.setBounds(70, 0, 148, 55);
        panel_return.add(lblreturn_text);

        JPanel panel_update = new JPanel();
        panel_update.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		frame.dispose();
                update up = new update();
                up.setVisible(true);
        		
        	}
        });
        panel_update.setForeground(Color.BLACK);
        panel_update.setBackground(new Color(105, 98, 173));
        panel_update.setBounds(10, 216, 217, 55);
        frame.getContentPane().add(panel_update);
        panel_update.setLayout(null);

        JLabel lblupdate = new JLabel("");
        lblupdate.setBounds(10, 0, 50, 50);
        panel_update.add(lblupdate);
        Image img2 = new ImageIcon(this.getClass().getResource("/import.png")).getImage();
        Image resizedImg2 = img2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        lblupdate.setIcon(new ImageIcon(resizedImg2));

        JLabel lblupdate_text = new JLabel("        UPDATE");
        lblupdate_text.setForeground(Color.WHITE);
        lblupdate_text.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblupdate_text.setBounds(69, 0, 148, 55);
        panel_update.add(lblupdate_text);

        JPanel panel_status = new JPanel();
        panel_status.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fetchDataForStatusCheck();
            }
        });
        panel_status.setForeground(Color.BLACK);
        panel_status.setBackground(new Color(105, 98, 173));
        panel_status.setBounds(10, 282, 217, 55);
        frame.getContentPane().add(panel_status);
        panel_status.setLayout(null);

        JLabel lblstatus = new JLabel("");
        lblstatus.setBounds(10, 0, 50, 50);
        panel_status.add(lblstatus);
        Image img3 = new ImageIcon(this.getClass().getResource("/status (1).png")).getImage();
        Image resizedImg3 = img3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        lblstatus.setIcon(new ImageIcon(resizedImg3));

        JLabel lblstatus_text = new JLabel("  STATUS CHECK");
        lblstatus_text.setForeground(Color.WHITE);
        lblstatus_text.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblstatus_text.setBounds(70, 0, 148, 55);
        panel_status.add(lblstatus_text);

        JLabel lblupperlogo = new JLabel(" ");
        lblupperlogo.setBounds(199, 0, 391, 85);
        frame.getContentPane().add(lblupperlogo);
        Image img4 = new ImageIcon(this.getClass().getResource("/UPPER LOGO.png")).getImage();
        Image resizedImg4 = img4.getScaledInstance(400, 300, Image.SCALE_SMOOTH);

        lblupperlogo.setIcon(new ImageIcon(resizedImg4));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(237, 84, 600, 273);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setBounds(237, 84, 600, 273);
        frame.getContentPane().add(table);
    }

    private void fetchDataForStatusCheck() {
        // Implement your database fetching logic here
        // Modify the SQL query based on your database structure
        // Use PreparedStatement to prevent SQL injection vulnerabilities

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/surge_management", "root", "");
            String query = "SELECT * FROM surge_inventory";
            PreparedStatement pstmt = con.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            // Define the table model with column names
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Rent ID");
            model.addColumn("Renter Name");
            model.addColumn("Renter Age");
            model.addColumn("Renter Address");
            model.addColumn("Car Type");
            model.addColumn("Date Rented");
            model.addColumn("Date Return");
            model.addColumn("Days");
            model.addColumn("Price Total");
            

            // Add column names as the first row
            model.addRow(new Object[]{"Rent ID", "Renter Name", "Renter Age", "Renter Address", "Car Type", "Date Rented", "Date Return","Days", "Price Total" });

            while (rs.next()) {
                // Add data to the table
            	 // Add data to the table model
                model.addRow(new Object[]{
                		rs.getInt("rentID"),
                        rs.getString("renter_name"),
                        rs.getInt("renter_age"),
                        rs.getString("renter_address"),
                        rs.getString("car_type"),
                        rs.getString("date_rented"),
                        rs.getString("date_return"),
                        rs.getInt("days"),
                        rs.getInt("price_total")
                });
            }

            // Set the table model to the JTable
            table.setModel(model);

            // Close resources
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
    }
}
