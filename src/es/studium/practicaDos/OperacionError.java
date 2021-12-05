package es.studium.practicaDos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacionError extends JDialog {

	/**
	 * 
	 */
	VistaPrincipal objVistaPrincipal = new VistaPrincipal();
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OperacionError dialog = new OperacionError();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OperacionError() {
		setBounds(100, 100, 329, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblOperacinErronea = new JLabel("Operaci\u00F3n Erronea");
			lblOperacinErronea.setForeground(new Color(255, 255, 255));
			lblOperacinErronea.setFont(new Font("Yu Gothic Light", Font.PLAIN, 22));
			lblOperacinErronea.setBounds(73, 59, 173, 36);
			contentPanel.add(lblOperacinErronea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(128, 0, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						objVistaPrincipal.setVisible(true);
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
