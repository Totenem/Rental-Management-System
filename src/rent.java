import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class rent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_rentername;
	private JTextField textField_renterage;
	private JLabel lblrenter_address;
	private JTextField textField_renteraddress;
	private JLabel lblcar_categories;
	private JRadioButton rdbtnLuxuryCar;
	private JRadioButton rdbtnSedan;
	private final ButtonGroup buttonGroup_typeofcars = new ButtonGroup();
	private JLabel lbldate_rented;
	private JTextField textField_daterented;
	private JTextField textField_returndate;
	private JLabel lblcarname1;
	private JLabel lblcar_price1;
	private JLabel lblcarname2;
	private JLabel lblcar_price2;
	private JRadioButton rdbtnHondahrv;
	private JLabel lblcarname3;
	private JLabel lblcar_price3;
	private JRadioButton rdbtnKiaev6;
    private JRadioButton rdbtnTelluride;
    private final ButtonGroup buttonGroup_SUV = new ButtonGroup();
    private JRadioButton rdbtnhellcat;
    private JRadioButton rdbtmclaren;
    private JRadioButton rdbtporche911;
    private final ButtonGroup buttonGroup_Luxurycars = new ButtonGroup();
    private JRadioButton rdbtnbmwm3;
    private JRadioButton rdbtntoyotacorolla;
    private JRadioButton rdbtnaudia3;
    private final ButtonGroup buttonGroup_sedans = new ButtonGroup();
    private JTextField textField_rentID;
    private JTextField textField_days;
    private final ButtonGroup buttonGroup_cars = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rent frame = new rent();
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
	public rent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(131,192,193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("         RENT / BORROW");
		lblHeader.setBounds(99, 11, 281, 40);
		lblHeader.setForeground(new Color(255, 255, 255));
		lblHeader.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		contentPane.add(lblHeader);
		
		JLabel lblrenter_name = new JLabel("Renter's Name: ");
		lblrenter_name.setBounds(10, 100, 83, 14);
		lblrenter_name.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblrenter_name.setForeground(new Color(0, 0, 0));
		contentPane.add(lblrenter_name);
		
		textField_rentername = new JTextField();
		textField_rentername.setBounds(99, 97, 261, 20);
		contentPane.add(textField_rentername);
		textField_rentername.setColumns(10);
		
		JLabel lblrenter_age = new JLabel("Renter's Age: ");
		lblrenter_age.setBounds(10, 125, 83, 14);
		lblrenter_age.setForeground(new Color(0, 0, 0));
		lblrenter_age.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		contentPane.add(lblrenter_age);
		
		textField_renterage = new JTextField();
		textField_renterage.setBounds(99, 122, 261, 20);
		textField_renterage.setColumns(10);
		contentPane.add(textField_renterage);
		
		lblrenter_address = new JLabel("Renter's Address: ");
		lblrenter_address.setBounds(10, 150, 95, 14);
		lblrenter_address.setForeground(new Color(0, 0, 0));
		lblrenter_address.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		contentPane.add(lblrenter_address);
		
		textField_renteraddress = new JTextField();
		textField_renteraddress.setBounds(99, 147, 261, 20);
		contentPane.add(textField_renteraddress);
		textField_renteraddress.setColumns(10);
		
		lblcar_categories = new JLabel("~~TYPE OF CAR~~");
		lblcar_categories.setBounds(109, 171, 130, 31);
		lblcar_categories.setForeground(Color.WHITE);
		lblcar_categories.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(lblcar_categories);
		
		//image magic( object images, resized aswell to my liking
		
        Image imgTelluride = new ImageIcon(this.getClass().getResource("/Kia-Telluride.jpg")).getImage();
        Image resizedImgTelluride = imgTelluride.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        Image imgHondahrv = new ImageIcon(this.getClass().getResource("/honda-hrv.jpg")).getImage();
        Image resizedImgHondahrv = imgHondahrv.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        Image imgKiaev6 = new ImageIcon(this.getClass().getResource("/kia-ev6.jpg")).getImage();
        Image resizedImgKiaev6 = imgKiaev6.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        Image imgHellcat = new ImageIcon(this.getClass().getResource("/hellcat.png")).getImage();
        Image resizedImgHellcat = imgHellcat.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        Image imgMclaren = new ImageIcon(this.getClass().getResource("/mclaren.jpg")).getImage();
        Image resizedImgMclaren = imgMclaren.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        Image imgPorche911 = new ImageIcon(this.getClass().getResource("/porche911.jpg")).getImage();
        Image resizedImgPorche911 = imgPorche911.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        Image imgAudia3 = new ImageIcon(this.getClass().getResource("/audia3.jpg")).getImage();
        Image resizedImgAudia3 = imgAudia3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        Image imgBmwm3 = new ImageIcon(this.getClass().getResource("/bmwm3.jpg")).getImage();
        Image resizedImgBmwm3 = imgBmwm3.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
        Image imgcorolla = new ImageIcon(this.getClass().getResource("/corolla.jpg")).getImage();
        Image resizedImgCorolla = imgcorolla.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        
		JLabel lblcaricon1 = new JLabel("");
		lblcaricon1.setBounds(403, 28, 95, 91);
		contentPane.add(lblcaricon1);
		
		JLabel lblcaricon2 = new JLabel("");
		lblcaricon2.setBounds(403, 130, 95, 70);
		contentPane.add(lblcaricon2);
		
		JLabel lblcaricon3 = new JLabel("");
		lblcaricon3.setBounds(403, 208, 95, 70);
		contentPane.add(lblcaricon3);
		
		JRadioButton rdbtnSUV = new JRadioButton("SUV");
		rdbtnSUV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //when clicked this actins happen
				//it hides the other buttons
				rdbtnhellcat.setVisible(false);
				rdbtmclaren.setVisible(false);
				rdbtporche911.setVisible(false);
	            rdbtnaudia3.setVisible(false);
	            rdbtnbmwm3.setVisible(false);
				rdbtntoyotacorolla.setVisible(false);
				
				//setting the name price and what to car id to send in the database
				   lblcaricon1.setIcon(new ImageIcon(resizedImgTelluride));
				   lblcarname1.setText("Kia Telluride");
	               lblcar_price1.setText("150$/day");
	               rdbtnTelluride.setVisible(true);

	               lblcaricon2.setIcon(new ImageIcon(resizedImgHondahrv));
	               lblcarname2.setText("Honda HRV");
	               lblcar_price2.setText("90$/day");
	               rdbtnHondahrv.setVisible(true);

	               lblcaricon3.setIcon(new ImageIcon(resizedImgKiaev6));
	               lblcarname3.setText("Kia EV6");
	               lblcar_price3.setText("100$/day");
	               rdbtnKiaev6.setVisible(true);
				
			}
		});
		rdbtnSUV.setBounds(59, 195, 53, 23);
		buttonGroup_typeofcars.add(rdbtnSUV);
		rdbtnSUV.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		rdbtnSUV.setBackground(new Color(131,192,193));
		contentPane.add(rdbtnSUV);
		
		rdbtnLuxuryCar = new JRadioButton("LUXURY CAR");
		rdbtnLuxuryCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//when clicked this actins happen
				
	            rdbtnaudia3.setVisible(false);
	            rdbtnbmwm3.setVisible(false);
				rdbtntoyotacorolla.setVisible(false);
				rdbtnTelluride.setVisible(false);
				rdbtnHondahrv.setVisible(false);
				rdbtnKiaev6.setVisible(false);
				
				   lblcaricon1.setIcon(new ImageIcon(resizedImgHellcat));
				   lblcarname1.setText("2023 Hellcat SRT");
	               lblcar_price1.setText("1900$/day");
	               rdbtnhellcat.setVisible(true);
	               
	               lblcaricon2.setIcon(new ImageIcon(resizedImgMclaren));
	               lblcarname2.setText("McLaren 720S");
	               lblcar_price2.setText("1450$/day");
	               rdbtmclaren.setVisible(true);
	               
	               lblcaricon3.setIcon(new ImageIcon(resizedImgPorche911));
	               lblcarname3.setText("2021 Porche 911");
	               lblcar_price3.setText("1780$/day");
	               rdbtporche911.setVisible(true);
				
			}
		});
		rdbtnLuxuryCar.setBounds(121, 195, 95, 23);
		buttonGroup_typeofcars.add(rdbtnLuxuryCar);
		rdbtnLuxuryCar.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		rdbtnLuxuryCar.setBackground(new Color(131,192,193));
		contentPane.add(rdbtnLuxuryCar);
		
		rdbtnSedan = new JRadioButton("SEDAN");
		rdbtnSedan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnTelluride.setVisible(false);
				rdbtnHondahrv.setVisible(false);
				rdbtnKiaev6.setVisible(false);
				rdbtnhellcat.setVisible(false);
				rdbtmclaren.setVisible(false);
				rdbtporche911.setVisible(false);
				
				   lblcaricon1.setIcon(new ImageIcon(resizedImgCorolla));
				   lblcarname1.setText("Toyota Corolla");
	               lblcar_price1.setText("30$/day");
	               rdbtntoyotacorolla.setVisible(true);
	               
	               lblcaricon2.setIcon(new ImageIcon(resizedImgBmwm3));
	               lblcarname2.setText("BMW M3");
	               lblcar_price2.setText("220$/day");
	               rdbtnbmwm3.setVisible(true);
	               
	               lblcaricon3.setIcon(new ImageIcon(resizedImgAudia3));
	               lblcarname3.setText("Audi A3");
	               lblcar_price3.setText("150$/day");
	               rdbtnaudia3.setVisible(true);
				
			}
		});
		rdbtnSedan.setBounds(218, 195, 57, 23);
		buttonGroup_typeofcars.add(rdbtnSedan);
		rdbtnSedan.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		rdbtnSedan.setBackground(new Color(131,192,193));
		contentPane.add(rdbtnSedan);
		
		lbldate_rented = new JLabel("Date Rented: ");
		lbldate_rented.setBounds(10, 239, 75, 14);
		lbldate_rented.setForeground(Color.BLACK);
		lbldate_rented.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		contentPane.add(lbldate_rented);
		
		textField_daterented = new JTextField();
		textField_daterented.setBounds(80, 233, 114, 20);
		contentPane.add(textField_daterented);
		textField_daterented.setColumns(10);
		
		JLabel lbldate_return = new JLabel("Return Date: ");
		lbldate_return.setBounds(10, 270, 75, 14);
		lbldate_return.setForeground(Color.BLACK);
		lbldate_return.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		contentPane.add(lbldate_return);
		
		textField_returndate = new JTextField();
		textField_returndate.setBounds(80, 264, 114, 20);
		textField_returndate.setColumns(10);
		contentPane.add(textField_returndate);
		
		
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Load the MySQL JDBC driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Establish a connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/surge_management", "root", "");

                    // Prepare the SQL statement
                    String sql = "INSERT INTO surge_inventory (rentID, renter_name, renter_age, renter_address, car_type, date_rented, date_return, days, price_total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(sql);

                    // Set parameters for the statement
                    pstmt.setString(1, textField_rentID.getText());
                    pstmt.setString(2, textField_rentername.getText());
                    pstmt.setInt(3, Integer.parseInt(textField_renterage.getText()));
                    pstmt.setString(4, textField_renteraddress.getText());

                    // Determine the selected car type based on radio buttons
                    String carType = "";
                    double pricePerDay = 0;

                    if (rdbtnTelluride.isSelected()) {
                        carType = "Kia Telluride";
                        pricePerDay = 150;
                    } else if (rdbtnHondahrv.isSelected()) {
                        carType = "Honda HRV";
                        pricePerDay = 90;
                    } else if (rdbtnKiaev6.isSelected()) {
                        carType = "Kia EV6";
                        pricePerDay = 100;
                    } else if (rdbtnhellcat.isSelected()) {
                        carType = "2023 Hellcat SRT";
                        pricePerDay = 1900;
                    } else if (rdbtmclaren.isSelected()) {
                        carType = "McLaren 720S";
                        pricePerDay = 1450;
                    } else if (rdbtporche911.isSelected()) {
                        carType = "2021 Porche 911";
                        pricePerDay = 1780;
                    } else if (rdbtnbmwm3.isSelected()) {
                        carType = "BMW M3";
                        pricePerDay = 220;
                    } else if (rdbtntoyotacorolla.isSelected()) {
                        carType = "Toyota Corolla";
                        pricePerDay = 30;
                    } else if (rdbtnaudia3.isSelected()) {
                        carType = "Audi A3";
                        pricePerDay = 150;
                    }

                    pstmt.setString(5, carType);
                    pstmt.setString(6, textField_daterented.getText());
                    pstmt.setString(7, textField_returndate.getText());
                    pstmt.setInt(8, Integer.parseInt(textField_days.getText()));

                    // Calculate total price
                    double totalPrice = pricePerDay * Double.parseDouble(textField_days.getText());
                    pstmt.setDouble(9, totalPrice);

                    // Execute the SQL statement
                    pstmt.executeUpdate();

                    // Close the resources
                    pstmt.close();
                    con.close();

                    // Inform the user about the successful insertion
                    JOptionPane.showMessageDialog(rent.this, "Data inserted successfully into the database!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Close the current frame and open the main frame
                    dispose();
                    main.main(null);
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnSubmit.setBounds(131, 295, 120, 31);
        contentPane.add(btnSubmit);
		

        
		lblcarname1 = new JLabel(" ");
		lblcarname1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblcarname1.setBounds(508, 38, 169, 14);
		contentPane.add(lblcarname1);
		
		lblcar_price1 = new JLabel(" ");
		lblcar_price1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblcar_price1.setBounds(508, 63, 64, 14);
		contentPane.add(lblcar_price1);
		
		rdbtnTelluride  = new JRadioButton("I WANT THIS");
		buttonGroup_cars.add(rdbtnTelluride);
		rdbtnTelluride.setBackground(new Color(131,192,193));
		rdbtnTelluride.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		rdbtnTelluride.setBounds(504, 80, 109, 23);
		rdbtnTelluride.setVisible(false);
		contentPane.add(rdbtnTelluride);
		


        
		lblcarname2 = new JLabel("");
		lblcarname2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblcarname2.setBounds(508, 130, 114, 14);
		contentPane.add(lblcarname2);
		
		lblcar_price2 = new JLabel("");
		lblcar_price2.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblcar_price2.setBounds(508, 155, 64, 14);
		contentPane.add(lblcar_price2);
		
		rdbtnHondahrv = new JRadioButton("I WANT THIS");
		buttonGroup_cars.add(rdbtnHondahrv);
		rdbtnHondahrv.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		rdbtnHondahrv.setBackground(new Color(131, 192, 193));
		rdbtnHondahrv.setBounds(504, 172, 109, 23);
		rdbtnHondahrv.setVisible(false); 
		contentPane.add(rdbtnHondahrv);
		


        
        lblcarname3 = new JLabel(" ");
        lblcarname3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        lblcarname3.setBounds(508, 213, 114, 14);
        contentPane.add(lblcarname3);
        
        lblcar_price3 = new JLabel("");
        lblcar_price3.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblcar_price3.setBounds(508, 238, 64, 14);
        contentPane.add(lblcar_price3);
        
        rdbtnKiaev6 = new JRadioButton("I WANT THIS");
        buttonGroup_cars.add(rdbtnKiaev6);
        rdbtnKiaev6.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        rdbtnKiaev6.setBackground(new Color(131, 192, 193));
        rdbtnKiaev6.setBounds(504, 255, 109, 23);
        rdbtnKiaev6.setVisible(false);
        contentPane.add(rdbtnKiaev6);
        
        rdbtnhellcat = new JRadioButton("I WANT THIS");
        buttonGroup_cars.add(rdbtnhellcat);
        rdbtnhellcat.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        rdbtnhellcat.setBackground(new Color(131, 192, 193));
        rdbtnhellcat.setBounds(518, 80, 109, 23);
        rdbtnhellcat.setVisible(false);
        contentPane.add(rdbtnhellcat);
        
        rdbtmclaren = new JRadioButton("I WANT THIS");
        buttonGroup_cars.add(rdbtmclaren);
        rdbtmclaren.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        rdbtmclaren.setBackground(new Color(131, 192, 193));
        rdbtmclaren.setBounds(513, 166, 109, 23);
        rdbtmclaren.setVisible(false);
        contentPane.add(rdbtmclaren);
        
        rdbtporche911 = new JRadioButton("I WANT THIS");
        buttonGroup_cars.add(rdbtporche911);
        rdbtporche911.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        rdbtporche911.setBackground(new Color(131, 192, 193));
        rdbtporche911.setBounds(518, 255, 109, 23);
        rdbtporche911.setVisible(false);
        contentPane.add(rdbtporche911);
        
        rdbtnbmwm3 = new JRadioButton("I WANT THIS");
        buttonGroup_cars.add(rdbtnbmwm3);
        rdbtnbmwm3.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        rdbtnbmwm3.setBackground(new Color(131, 192, 193));
        rdbtnbmwm3.setBounds(518, 76, 109, 23);
        rdbtnbmwm3.setVisible(false);
        contentPane.add(rdbtnbmwm3);
        
        rdbtntoyotacorolla = new JRadioButton("I WANT THIS");
        buttonGroup_cars.add(rdbtntoyotacorolla);
        rdbtntoyotacorolla.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        rdbtntoyotacorolla.setBackground(new Color(131, 192, 193));
        rdbtntoyotacorolla.setBounds(513, 166, 109, 23);
        rdbtntoyotacorolla.setVisible(false);
        contentPane.add(rdbtntoyotacorolla);
        
        rdbtnaudia3 = new JRadioButton("I WANT THIS");
        buttonGroup_cars.add(rdbtnaudia3);
        rdbtnaudia3.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        rdbtnaudia3.setBackground(new Color(131, 192, 193));
        rdbtnaudia3.setBounds(513, 255, 109, 23);
        rdbtnaudia3.setVisible(false);
        contentPane.add(rdbtnaudia3);
        
        JLabel lblrentID = new JLabel("Rent ID:");
        lblrentID.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblrentID.setBounds(10, 75, 75, 14);
        contentPane.add(lblrentID);
        
        textField_rentID = new JTextField();
        textField_rentID.setBounds(99, 69, 261, 20);
        contentPane.add(textField_rentID);
        textField_rentID.setColumns(10);
        
        JPanel panel_Back = new JPanel();
        panel_Back.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		dispose();
        		main.main(null);
        		
        	}
        });
        panel_Back.setBackground(new Color(255, 0, 0));
        panel_Back.setBounds(10, 11, 69, 40);
        contentPane.add(panel_Back);
        panel_Back.setLayout(null);
        
        JLabel lblNewLabel = new JLabel(" <<<");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
        lblNewLabel.setBounds(10, 11, 49, 14);
        panel_Back.add(lblNewLabel);
        
        JLabel lblDays = new JLabel("Days:");
        lblDays.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        lblDays.setBounds(205, 239, 34, 14);
        contentPane.add(lblDays);
        
        textField_days = new JTextField();
        textField_days.setBounds(235, 236, 86, 20);
        contentPane.add(textField_days);
        textField_days.setColumns(10);

		

	}
}
