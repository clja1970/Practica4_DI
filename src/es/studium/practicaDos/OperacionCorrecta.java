package es.studium.practicaDos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacionCorrecta extends JDialog {

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
			OperacionCorrecta dialog = new OperacionCorrecta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OperacionCorrecta() {
		setTitle("Operaci\u00F3n correcta");
		setBounds(100, 100, 344, 204);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Operaci\u00F3n OK");
			lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 22));
			lblNewLabel.setBounds(100, 54, 131, 36);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 128, 0));
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
