package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NewMarche {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewMarche window = new NewMarche();
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
	public NewMarche() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 775, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 775, 56);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInsererLeNom = new JLabel("Veuillez inserer le nom de marche !!");
		lblInsererLeNom.setForeground(SystemColor.text);
		lblInsererLeNom.setFont(new Font("FreeSans", Font.ITALIC, 16));
		lblInsererLeNom.setBounds(220, 12, 308, 32);
		panel.add(lblInsererLeNom);
		
		
		JLabel lblLeNomDe = new JLabel("le nom de marche :");
		lblLeNomDe.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblLeNomDe.setBounds(86, 101, 177, 29);
		frame.getContentPane().add(lblLeNomDe);
		
		JButton btnInserer = new JButton("inserer");

		btnInserer.setForeground(SystemColor.text);
		btnInserer.setBackground(SystemColor.desktop);
		btnInserer.setBounds(294, 440, 191, 38);
		frame.getContentPane().add(btnInserer);
		
		JLabel lblLesFournisseur = new JLabel("les fournisseurs :");
		lblLesFournisseur.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 14));
		lblLesFournisseur.setBounds(402, 102, 138, 29);
		frame.getContentPane().add(lblLesFournisseur);
		
		textField = new JTextField();
		textField.setBounds(392, 159, 225, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		String f = textField.getText();
		String fournisseur = f.replace("'", "''");
		
		textField_1 = new JTextField();
		textField_1.setBounds(392, 211, 225, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		String f_1 = textField_1.getText();
		String fournisseur_1 = f.replace("'", "''");
		
		textField_2 = new JTextField();
		textField_2.setBounds(392, 271, 225, 29);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		String f_2 = textField_2.getText();
		String fournisseur_2 = f.replace("'", "''");
		
		textField_3 = new JTextField();
		textField_3.setBounds(392, 321, 225, 29);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		String f_3 = textField_3.getText();
		String fournisseur_3 = f.replace("'", "''");
		
		textField_4 = new JTextField();
		textField_4.setBounds(26, 142, 292, 63);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel_1.setBounds(0, 505, 775, 38);
		frame.getContentPane().add(panel_1);
		String marche = textField_4.getText();
		String name = marche.replace("'", "''");
		
		
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
	            {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	                String userName = "sa";
	                String password = "jocker@1995";
	                String url = "jdbc:sqlserver://192.168.0.10:1433"+";databaseName=BanqueApp";
	                Connection con = DriverManager.getConnection(url, userName, password);
	                Statement s1 = con.createStatement();	                
	                String sql = "insert into fournisseurs values('"+name+"','"+fournisseur+"');";
	                String sql_1 = "insert into fournisseurs values('"+name+"','"+fournisseur_1+"');";
	                String sql_2 = "insert into fournisseurs values('"+name+"','"+fournisseur_2+"');";
	                String sql_3 = "insert into fournisseurs values('"+name+"','"+fournisseur_3+"');";
	                s1.executeUpdate(sql_3);
	                s1.executeUpdate(sql_2);
	                s1.executeUpdate(sql_1);
	                s1.executeUpdate(sql);
	                frame.setVisible(false);
	                Inserted.main(null);
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
			}
		});
	}
}
