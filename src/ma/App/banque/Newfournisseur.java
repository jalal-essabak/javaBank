package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Newfournisseur {

	private JFrame frame;
	private JTextField txtIdmarche;
	private JTextField txtNomfournisseur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newfournisseur window = new Newfournisseur();
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
	public Newfournisseur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		InputStream inputStream ;
 		Properties prop = new Properties();
 		String propFileName = "config.properties";
 		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 		try {
 			prop.load(inputStream);
 		} catch (IOException e1) {
 			e1.printStackTrace();
 		}
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 450, 89);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInsererLeNom = new JLabel("inserer le nom du fournisseur");
		lblInsererLeNom.setForeground(SystemColor.text);
		lblInsererLeNom.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 16));
		lblInsererLeNom.setBounds(98, 24, 284, 36);
		panel.add(lblInsererLeNom);
		
		JLabel lblIdmarch = new JLabel("id_marché :");
		lblIdmarch.setBounds(32, 141, 133, 32);
		frame.getContentPane().add(lblIdmarch);
		
		txtIdmarche = new JTextField();
		txtIdmarche.setBounds(183, 142, 224, 32);
		frame.getContentPane().add(txtIdmarche);
		txtIdmarche.setColumns(10);
		
		JLabel lblNomDeFournisseur = new JLabel("nom de fournisseur:");
		lblNomDeFournisseur.setBounds(32, 207, 147, 24);
		frame.getContentPane().add(lblNomDeFournisseur);
		
		txtNomfournisseur = new JTextField();
		txtNomfournisseur.setBounds(183, 196, 228, 35);
		frame.getContentPane().add(txtNomfournisseur);
		txtNomfournisseur.setColumns(10);
		
		JButton btnAjouter = new JButton("ajouter ");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
	            {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                                    
	        		String userName = prop.getProperty("userName");
        			String password = prop.getProperty("password");
        			String url = prop.getProperty("url");
        			
	                Connection con = DriverManager.getConnection(url, userName, password);
	                Statement s1 = con.createStatement();
	                
	                //fields of the form
	                
	                String fournisseur = txtNomfournisseur.getText();
	                String fournisseur1=fournisseur.replace("'", "''");
	                String id = txtIdmarche.getText();
	               
	                String sql = "insert into fournisseurs (nom,serie) values('"+fournisseur1+"','"+id+"');";
	                
	                //execute the request
	                
	                s1.executeUpdate(sql);
	                	               
	                frame.setVisible(false);
	                Inserted.main(null);
	                Newfournisseur.main(null);
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
			}
			
		});
		btnAjouter.setBackground(SystemColor.desktop);
		btnAjouter.setForeground(SystemColor.text);
		btnAjouter.setBounds(133, 264, 170, 35);
		frame.getContentPane().add(btnAjouter);
		frame.setBounds(100, 100, 450, 387);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
