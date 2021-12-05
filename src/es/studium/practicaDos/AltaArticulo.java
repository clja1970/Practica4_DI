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

public class AltaArticulo extends JFrame {

	/**
	 * 
	 */
	OperacionCorrecta objOperacionCorrecta = new OperacionCorrecta();
	OperacionError objOperacionError = new OperacionError();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaArticulo frame = new AltaArticulo();
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
	public AltaArticulo() {
		setTitle("Alta de Articulo");
		setBackground(new Color(0, 128, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 314);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
		lblNewLabel.setBounds(40, 38, 89, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(40, 76, 89, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setFont(new Font("Yu Gothic Light", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(40, 126, 89, 36);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(177, 42, 95, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(177, 81, 95, 28);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(177, 120, 95, 28);
		contentPane.add(textField_2);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\volver.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(231, 212, 57, 33);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("n\u00BA Ticket");
		lblNewLabel_3.setFont(new Font("Yu Gothic Light", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(40, 173, 89, 36);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 167, 68, 28);
		contentPane.add(textField_3);
		btnNewButton.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnNewButton)){

					try {

						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
						if (((textField.getText().length()) != 0) && ((textField_1.getText().length()) !=0) && ((textField_2.getText().length()) !=0)) {
							Statement sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							sentencia.executeUpdate ("INSERT INTO articulos VALUES (null, '" + textField.getText() + "', '" + textField_1.getText() + "' , '" + textField_2.getText() + "' , '" + textField_3.getText() + "')");
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
		setLocationRelativeTo(null);
		setResizable(false);
	}
}



