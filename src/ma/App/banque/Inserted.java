package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inserted {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserted window = new Inserted();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inserted() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.setResizable(false);
		frame.setBounds(100, 100, 303, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFactureAjout = new JLabel("Ajouté !!");
		lblFactureAjout.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		lblFactureAjout.setForeground(SystemColor.text);
		lblFactureAjout.setBounds(113, 48, 180, 56);
		frame.getContentPane().add(lblFactureAjout);
		
		JButton btnNewButton = new JButton("close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(SystemColor.scrollbar);
		btnNewButton.setBounds(91, 139, 114, 25);
		frame.getContentPane().add(btnNewButton);
	}

}
