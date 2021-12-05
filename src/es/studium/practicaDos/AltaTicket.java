package es.studium.practicaDos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class AltaTicket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OperacionCorrecta objOperacionCorrecta = new OperacionCorrecta();
	OperacionError objOperacionError = new OperacionError();
	VistaPrincipal vistaPrincipal = new VistaPrincipal();

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaTicket frame = new AltaTicket();
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
	public AltaTicket() {
		setTitle("Alta de Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 239);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnNewButton)){

					try {

						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
						if (((textField.getText().length()) != 0) && ((textField_1.getText().length()) !=0) && ((textField_2.getText().length()) !=0)) {
							Statement sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							sentencia.executeUpdate ("INSERT INTO tickets VALUES (null, '" + textField_2.getText() + "', '" + Integer.parseInt(textField.getText()) + "', '" + Double.parseDouble(textField_1.getText()) + "')");
							//Visible el dialogo llamando al objeto creado del dialogo OperacionCorrecta
							objOperacionCorrecta.setVisible(true);
							setVisible(false);
							connection.close();

						}
						//objOperacionCorrecta.setVisible(true);
						//Segunda condición para mostrar el error, todo esto despues del manejo de la BBDD
					}catch (SQLException f) {
						f.getMessage();
						objOperacionError.setVisible(true);
						setVisible(false);
					}
				}
			}
		});
		btnNewButton.setBounds(243, 17, 88, 33);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(162, 81, 59, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(68, 80, 54, 24);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 152, 59, 20);
		contentPane.add(textField_1);

		JLabel lblNewLabel_1 = new JLabel("Total");
		lblNewLabel_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(103, 153, 54, 24);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Fecha");
		lblNewLabel_2.setBounds(68, 115, 46, 14);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(162, 112, 59, 20);
		contentPane.add(textField_2);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaPrincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\volver.png"));
		btnNewButton_1.setBounds(255, 154, 57, 33);
		contentPane.add(btnNewButton_1);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
