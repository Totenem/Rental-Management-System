import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class update extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_rentID;
    private JTextField textField_NewName;
    private JTextField textField_NewAge;
    private JTextField textField_NewAddress;
    private JTextField textField_ReturnDate;
    private JTextField textField_NewDays;

    // JDBC URL, username, and password
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3307/surge_management";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    update frame = new update();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public update() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 387);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(120, 192, 193));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_Back = new JPanel();
        panel_Back.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		dispose();
        		main.main(null);
        		
        	}
        });
        panel_Back.setLayout(null);
        panel_Back.setBackground(Color.RED);
        panel_Back.setBounds(10, 11, 69, 40);
        contentPane.add(panel_Back);

        JLabel lblNewLabel = new JLabel(" <<<");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblNewLabel.setBounds(10, 11, 49, 14);
        panel_Back.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("UPDATE DETAILS");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblNewLabel_1.setBounds(140, 23, 145, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblRentID = new JLabel("Enter ID:");
        lblRentID.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblRentID.setBounds(77, 74, 46, 14);
        contentPane.add(lblRentID);

        textField_rentID = new JTextField();
        textField_rentID.setBounds(128, 71, 179, 20);
        contentPane.add(textField_rentID);
        textField_rentID.setColumns(10);

        JLabel lblNewName = new JLabel("Enter New Name:");
        lblNewName.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblNewName.setBounds(33, 144, 92, 14);
        contentPane.add(lblNewName);

        textField_NewName = new JTextField();
        textField_NewName.setEditable(false);
        textField_NewName.setBounds(128, 141, 179, 20);
        contentPane.add(textField_NewName);
        textField_NewName.setColumns(10);

        JLabel lblNewAge = new JLabel("Enter New Age:");
        lblNewAge.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblNewAge.setBounds(33, 172, 92, 14);
        contentPane.add(lblNewAge);

        textField_NewAge = new JTextField();
        textField_NewAge.setEditable(false);
        textField_NewAge.setColumns(10);
        textField_NewAge.setBounds(128, 169, 179, 20);
        contentPane.add(textField_NewAge);

        JLabel lblNewAddress = new JLabel("Enter New Address:");
        lblNewAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblNewAddress.setBounds(16, 200, 107, 14);
        contentPane.add(lblNewAddress);

        textField_NewAddress = new JTextField();
        textField_NewAddress.setEditable(false);
        textField_NewAddress.setColumns(10);
        textField_NewAddress.setBounds(128, 197, 179, 20);
        contentPane.add(textField_NewAddress);

        textField_ReturnDate = new JTextField();
        textField_ReturnDate.setEditable(false);
        textField_ReturnDate.setColumns(10);
        textField_ReturnDate.setBounds(128, 226, 179, 20);
        contentPane.add(textField_ReturnDate);

        JLabel lblNewReturnDate = new JLabel("Enter New Return:");
        lblNewReturnDate.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblNewReturnDate.setBounds(21, 228, 102, 14);
        contentPane.add(lblNewReturnDate);

        JLabel lblNewDays = new JLabel("Enter New Day:");
        lblNewDays.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblNewDays.setBounds(31, 260, 83, 14);
        contentPane.add(lblNewDays);

        textField_NewDays = new JTextField();
        textField_NewDays.setEditable(false);
        textField_NewDays.setColumns(10);
        textField_NewDays.setBounds(128, 257, 179, 20);
        contentPane.add(textField_NewDays);

        JButton btnsearch = new JButton("Search");
        btnsearch.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        btnsearch.setBounds(319, 70, 89, 23);
        contentPane.add(btnsearch);

        JButton btnConfim = new JButton("Confirm Info");
        btnConfim.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        btnConfim.setBounds(167, 288, 102, 23);
        contentPane.add(btnConfim);

        btnsearch.addActionListener(e -> handleSearch());
        btnConfim.addActionListener(e -> handleConfirmation());
    }

    private void handleSearch() {
        try {
            // Get rentID from the text field
            String rentID = textField_rentID.getText();

            // Open a connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Execute a query to check if the rentID exists in the database
            String query = "SELECT * FROM surge_inventory WHERE rentID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rentID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Rent ID found
                System.out.println("Rent ID found!");
                // Retrieve and display other information if needed
                textField_NewName.setText(resultSet.getString("renter_name"));
                textField_NewAge.setText(resultSet.getString("renter_age"));
                textField_NewAddress.setText(resultSet.getString("renter_address"));
                textField_ReturnDate.setText(resultSet.getString("date_return"));
                textField_NewDays.setText(resultSet.getString("days"));

                // Make the text fields editable
                textField_NewName.setEditable(true);
                textField_NewAge.setEditable(true);
                textField_NewAddress.setEditable(true);
                textField_ReturnDate.setEditable(true);
                textField_NewDays.setEditable(true);
            } else {
                // Rent ID not found
                System.out.println("Rent ID not found.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Dont touch
            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    private void handleConfirmation() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Get data from text fields
            String rentID = textField_rentID.getText();
            String newName = textField_NewName.getText();
            String newAge = textField_NewAge.getText();
            String newAddress = textField_NewAddress.getText();
            String returnDate = textField_ReturnDate.getText();
            String newDaysStr = textField_NewDays.getText();

            // Convert newDays to int 
            int updatedDays = Integer.parseInt(newDaysStr);

            // Open a connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Calculate the new total price based on the car type and updated days
            double totalPrice = calculateTotalPrice(rentID, updatedDays); 

            // Execute a query to update the database with new data
            String updateQuery = "UPDATE surge_inventory SET renter_name=?, renter_age=?, renter_address=?, "
                    + "date_return=?, days=?, price_total=? WHERE rentID=?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newAge);
            preparedStatement.setString(3, newAddress);
            preparedStatement.setString(4, returnDate);
            preparedStatement.setInt(5, updatedDays);
            preparedStatement.setDouble(6, totalPrice);
            preparedStatement.setString(7, rentID);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Update successful
                System.out.println("Data updated successfully!");
            } else {
                // Update failed
                System.out.println("Failed to update data.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // just dont touch
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private double calculateTotalPrice(String rentID, int updatedDays) {
        double totalPrice = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Open a connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Execute a query to get the car type for the given rentID
            String query = "SELECT car_type FROM surge_inventory WHERE rentID=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rentID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                String carType = resultSet.getString("car_type");

                // Set the corresponding price based on the car type
                double pricePerDay = 0;
                switch (carType) {
                    case "Kia Telluride":
                        pricePerDay = 150;
                        break;
                    case "Audi A3":
                        pricePerDay = 150;
                        break;
                    case "Honda HRV":
                    	pricePerDay = 90;
                    	break;
                    case "Kia EV6":
                    	pricePerDay = 100;
                    	break;
                    case "2023 Hellcat SRT":
                    	pricePerDay = 1900;
                    	break;
                    case "Mclaren 720s":
                    	pricePerDay = 1450;
                    	break;
                    case "2021 Porche 911":
                    	pricePerDay = 1780;
                    	break;
                    case "Toyota Corolla":
                    	pricePerDay = 30;
                    	break;
                    case "BMW M3":
                    	pricePerDay = 220;
                    	break;
                    	
                    default:
                        // Handle unknown car types if needed
                        break;
                }

                // Calculate the total price
                totalPrice = pricePerDay * updatedDays;
            } else {
                // Rent ID not found
                System.out.println("Rent ID not found while calculating total price.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Just dont touch
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return totalPrice;
    }

    private double calculateTotalPrice() {
        try {
            // Get rentID from the text field
            String rentID = textField_rentID.getText();

            // Open a connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Execute a query to get the car type for the given rentID
            String query = "SELECT car_type FROM surge_inventory WHERE rentID=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rentID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Car type found
                String carType = resultSet.getString("car_type");

                // Get the updated days from the text field
                int updatedDays = Integer.parseInt(textField_NewDays.getText());

                // Set the corresponding price based on the car type
                double pricePerDay = 0;
                switch (carType) {
                    case "Kia Telluride":
                        pricePerDay = 150;
                        break;
                    case "Audi A3":
                        pricePerDay = 150;
                        break;
                    

                    default:
                        // just to be safe hehe
                        break;
                }

                // Calculate the total price
                return pricePerDay * updatedDays;
            } else {
                // Rent ID not found, handle accordingly
                System.out.println("Rent ID not found while calculating total price.");
                return 0; 
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0; // Return 0 
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}