package es.studium.practicaDos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaArticulo extends JFrame {

	/**
	 * 
	 */
	VistaPrincipal objVistaPrincipal = new VistaPrincipal();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaArticulo frame = new ConsultaArticulo();
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
	public ConsultaArticulo() {
		setTitle("Consultar Art\u00EDculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Consulta de art\u00EDculo");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 22));
		lblNewLabel.setBounds(117, 11, 199, 38);
		contentPane.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(90, 120, 255, 90);
		contentPane.add(textArea);
		textArea.setText("Descripción\t" + "Precio " + "Cantidad " + " idTicketsFK" + "\n\n");

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(89, 60, 255, 35);
		contentPane.add(comboBox);
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
			Statement sentencia = connection.createStatement();
			ResultSet resultado = sentencia.executeQuery("select * from articulos");
			

			while (resultado.next()) {
				comboBox.addItem(resultado.getString("descripcionArticulo") + " - " + (resultado.getString("precioArticulo") + " - " +(resultado.getString("cantidadStockArticulo"))+ " - " +(resultado.getString("idTicketsFK"))));
				textArea.append(resultado.getString("descripcionArticulo") + "\t" + (resultado.getString("precioArticulo") + "       " +(resultado.getString("cantidadStockArticulo")) + "\t    " + (resultado.getString("idTicketsFK"))) + "\n");
			}
		}catch (SQLException sqle) {
			System.out.println("Error de SQL " + sqle);
		}
		





		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btnNewButton)){
					
					setVisible(false);
					objVistaPrincipal.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
