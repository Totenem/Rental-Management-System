import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class returnn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_rentidchecker;
    private JTable table_datashow;

    // Provide your database URL, username, and password
    private String url = "jdbc:mysql://127.0.0.1:3307/surge_management";
    private String username = "root";
    private String password = "";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    returnn frame = new returnn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public returnn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 722, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(131, 192, 193));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("RETURN A CAR");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblNewLabel.setBounds(269, 11, 141, 40);
        contentPane.add(lblNewLabel);

        JLabel lblrentid_return = new JLabel("Enter rentID:");
        lblrentid_return.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblrentid_return.setBounds(136, 55, 100, 30);
        contentPane.add(lblrentid_return);

        textField_rentidchecker = new JTextField();
        textField_rentidchecker.setBounds(227, 62, 224, 20);
        contentPane.add(textField_rentidchecker);
        textField_rentidchecker.setColumns(10);

        table_datashow = new JTable();
        table_datashow.setBounds(10, 96, 686, 113);
        contentPane.add(table_datashow);

        JButton btnConfirm = new JButton("Confirm Return");
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmReturn();
            }
        });
        btnConfirm.setBounds(242, 227, 196, 23);
        contentPane.add(btnConfirm);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchRentData();
            }
        });
        btnNewButton.setBounds(461, 61, 89, 23);
        contentPane.add(btnNewButton);
        
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		dispose();
        		main.main(null);
        		
        	}
        });
        panel.setBackground(new Color(255, 0, 0));
        panel.setBounds(10, 11, 59, 40);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("<<<");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 11, 46, 14);
        panel.add(lblNewLabel_1);
    }

    private void searchRentData() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String rentID = textField_rentidchecker.getText();
            String query = "SELECT * FROM surge_inventory WHERE rentID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, rentID);

            ResultSet rs = pstmt.executeQuery();

            // Create a DefaultTableModel with column names
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

            // Set the model to the JTable
            table_datashow.setModel(model);

            rs.close();
            pstmt.close();
            connection.close();
            
            System.out.println("Data retrieved successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void confirmReturn() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String rentID = textField_rentidchecker.getText();
            String deleteQuery = "DELETE FROM surge_inventory WHERE rentID = ?";
            PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
            pstmt.setString(1, rentID);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(returnn.this, "Data Deleted Sucessfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Close the current frame and open the main frame
                dispose();
                main.main(null);
                // Optionally: Clear the table after successful deletion
                ((DefaultTableModel) table_datashow.getModel()).setRowCount(0);
            } else {
                System.out.println("No rows deleted. Check rentID.");
            }

            pstmt.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Search completed."); // Add this line for debugging
    }
}
