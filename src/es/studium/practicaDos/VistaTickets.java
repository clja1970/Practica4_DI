package es.studium.practicaDos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class VistaTickets extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	AltaTicket altaTicket = new AltaTicket();
	ConsultaTickets consultaTickets = new ConsultaTickets ();
	VistaPrincipal vistaPrincipal = new VistaPrincipal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaTickets frame = new VistaTickets();
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
	public VistaTickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 241, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Altas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaTicket.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(63, 48, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Consultas");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				consultaTickets.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(63, 117, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaPrincipal.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\volver.png"));
		btnNewButton_2.setBounds(124, 212, 57, 33);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\Tickets.png"));
		lblNewLabel.setBounds(0, 0, 231, 257);
		contentPane.add(lblNewLabel);

		setLocationRelativeTo(null);
		setResizable(false);
	}

}
