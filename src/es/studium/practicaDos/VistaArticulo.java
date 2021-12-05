package es.studium.practicaDos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaArticulo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaArticulo frame = new VistaArticulo();
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
	public VistaArticulo() {
		setTitle("Articulos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton(" Altas ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaArticulo altaArticulo = new AltaArticulo();
				altaArticulo.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(27, 31, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" Bajas");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BajaDeArticulo bajaDeArticulo = new BajaDeArticulo();
				bajaDeArticulo.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 99, 71));
		btnNewButton_1.setBounds(147, 31, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton(" Modificaci\u00F3n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarArticulo modificarArticulo = new ModificarArticulo();
				modificarArticulo.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setBounds(27, 102, 98, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton(" Consulta");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaArticulo consultaArticulo = new ConsultaArticulo();
				consultaArticulo.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setBackground(new Color(192, 192, 192));
		btnNewButton_1_2.setBounds(145, 102, 89, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrincipal vistaPrincipal = new VistaPrincipal();
				vistaPrincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\volver.png"));
		btnNewButton_2.setBounds(166, 143, 57, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(60, 179, 113));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\Articulos.png"));
		lblNewLabel.setBounds(0, 0, 270, 206);
		contentPane.add(lblNewLabel);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
