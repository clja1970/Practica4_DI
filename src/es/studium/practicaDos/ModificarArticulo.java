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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModificarArticulo extends JFrame {

	/**
	 * 
	 */
	Statement statement;
	String sentencia;
	Connection connection;
	
	OperacionCorrecta objOperacionCorrecta = new OperacionCorrecta();
	OperacionError objOperacionError = new OperacionError();


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarArticulo frame = new ModificarArticulo();
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
	public ModificarArticulo() {
		setTitle("Modificaci\u00F3n Articulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 332);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Modificar Art\u00EDculo");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 22));
		lblNewLabel.setBounds(137, 11, 192, 36);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(98, 58, 237, 22);
		contentPane.add(comboBox);
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
			Statement sentencia = connection.createStatement();
			ResultSet resultado = sentencia.executeQuery("select * from articulos");

			comboBox.removeAll();

			while (resultado.next()){
				comboBox.addItem(resultado.getInt("IdArticulo") + " - " + resultado.getString("descripcionArticulo") + " - " +
						resultado.getDouble("precioArticulo") + " - " + resultado.getString("cantidadStockArticulo") );
			}
			connection.close();			

		}catch (SQLException sqle) {
			sqle.getMessage();
		}

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(97, 91, 89, 27);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(234, 91, 95, 28);
		contentPane.add(textField);

		JLabel lblNewLabel_1_1 = new JLabel("Precio");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(97, 142, 89, 27);
		contentPane.add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(234, 141, 95, 28);
		contentPane.add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setFont(new Font("Yu Gothic Light", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(97, 192, 89, 36);
		contentPane.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(234, 186, 95, 28);
		contentPane.add(textField_2);

		textId = new JTextField();

		JButton btnNewButton = new JButton(" Editar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] valor = comboBox.getSelectedItem().toString().split(" - ");

				textId.setText(valor[0]);
				textField.setText(valor[1]);
				textField_1.setText(valor[2]);
				textField_2.setText(valor[3]);

			}
		});
		btnNewButton.setBounds(176, 239, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.setBackground(new Color(152, 251, 152));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
					sentencia = "UPDATE articulos SET descripcionArticulo='"
							+textField.getText()+"', precioArticulo='"
							+textField_1.getText()+"', precioArticulo='"+textField_2.getText()+"' WHERE idArticulo="
							+textId.getText();


					Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					statement.executeUpdate(sentencia);
					
					objOperacionCorrecta.setVisible(true);
					setVisible(false);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					objOperacionError.setVisible(true);
					setVisible(false);
				}

			}
		});
		btnNewButton_1.setBounds(368, 239, 89, 23);
		contentPane.add(btnNewButton_1);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
