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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class ConsultaTickets extends JFrame {

	VistaPrincipal objVistaPrincipal = new VistaPrincipal();
	private JPanel contentPane;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaTickets frame = new ConsultaTickets();
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
	public ConsultaTickets() {
		setTitle("ConsultaTickets");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecciona ticket");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		lblNewLabel.setBounds(117, 34, 127, 20);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();

		comboBox.setBounds(264, 30, 96, 22);
		contentPane.add(comboBox);
		{
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
				Statement sentencia = connection.createStatement();
				ResultSet resultado = sentencia.executeQuery("select * from tickets");

				comboBox.removeAll();

				while (resultado.next()){
					comboBox.addItem(resultado.getInt("IdTicket"));
				}

				connection.close();			

			}catch (SQLException sqle) {
				sqle.getMessage();
			}

			textArea.setBounds(137, 84, 228, 130);





			contentPane.add(textArea);



			JLabel lblNewLabel_1 = new JLabel("Ariculos a Mostrar");
			lblNewLabel_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(15, 141, 112, 24);
			contentPane.add(lblNewLabel_1);



			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\volver.png"));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					objVistaPrincipal.setVisible(true);
					setVisible(false);
				}
			});
			btnNewButton.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
			btnNewButton.setBounds(353, 225, 57, 33);
			contentPane.add(btnNewButton);
		}

		JButton btnNewButton_1 = new JButton("Consulta");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiendecita_dos","root", "Studium2020;");
					Statement sentencia = connection.createStatement();
					ResultSet resultado = sentencia.executeQuery("select * from articulos where idTicketsFK =" + comboBox.getSelectedItem());

					textArea.setText("");
					while (resultado.next()) {

						textArea.append(resultado.getString("descripcionArticulo") + "\t" + (resultado.getString("precioArticulo") + "       " +(resultado.getString("cantidadStockArticulo")) + "\t    " + (resultado.getString("idTicketsFK"))) + "\n");
					}
					
				}catch (SQLException sqle) {
					System.out.println("Error de SQL " + sqle);
				}
			}
		});
		btnNewButton_1.setBounds(21, 85, 89, 23);
		contentPane.add(btnNewButton_1);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
