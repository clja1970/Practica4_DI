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

public class VistaPrincipal extends JFrame {

	/**
	 * 
	 */
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	VistaArticulo vistaArticulo = new VistaArticulo();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
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
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Art\u00EDculos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vistaArticulo.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(60, 61, 94, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(" Tickets ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaTickets vistaTickets = new VistaTickets();
				vistaTickets.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setBounds(498, 59, 94, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\clja1\\eclipse-worhspace-2\\Practica2_DI\\Tiendecita_dos.png"));
		lblNewLabel.setBounds(0, 0, 633, 408);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void setRelativeToLcaltion(Object object) {
		// TODO Auto-generated method stub
		
	}
}
