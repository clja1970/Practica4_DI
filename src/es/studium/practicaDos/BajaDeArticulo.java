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
import javax.swing.border.EmptyBorder;

public class BajaDeArticulo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Statement statement;
	String sentencia;
	Connection connection;

	OperacionCorrecta objOperacionCorrecta = new OperacionCorrecta();
	OperacionError objOperacionError = new OperacionError();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaDeArticulo frame = new BajaDeArticulo();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BajaDeArticulo() {
		setTitle("Eliminar Art\u00EDculo");
		setBackground(new Color(178, 34, 34));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(53, 54, 254, 32);
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

		JLabel lblNewLabel = new JLabel("Art\u00EDculo a Eliminar");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 22));
		lblNewLabel.setBounds(98, 11, 209, 32);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnNewButton)) {

					try {

						connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
						String [] elegirId = ((String) comboBox.getSelectedItem()).split(" - ");
						sentencia = "DELETE FROM articulos WHERE idArticulo = " + elegirId[0];


						statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
						statement.executeUpdate(sentencia);

						connection.close();

						objOperacionCorrecta.setVisible(true);
						setVisible(false);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						objOperacionError.setVisible(true);
						setVisible(false);
					}

				}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic Light", Font.PLAIN, 15));
		btnNewButton.setBounds(196, 205, 111, 39);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
