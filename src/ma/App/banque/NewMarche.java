package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
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

public class NewMarche {

	private JFrame frame;
	private JTextField marcheText;
	private JTextField idText;
	private JTextField fournisseur1;
	private JTextField fournisseur2;
	private JTextField fournisseur3;

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
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 776, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 776, 44);
		panel.setBackground(SystemColor.desktop);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel_1.setBounds(0, 367, 766, 22);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNomDeMarch = new JLabel("nom de marché :");
		lblNomDeMarch.setBounds(25, 87, 123, 22);
		frame.getContentPane().add(lblNomDeMarch);
		
		JLabel lblIdentifiantDuMarch = new JLabel("identifiant du marché :");
		lblIdentifiantDuMarch.setBounds(25, 174, 179, 22);
		frame.getContentPane().add(lblIdentifiantDuMarch);
		
		marcheText = new JTextField();
		marcheText.setBounds(208, 88, 187, 22);
		frame.getContentPane().add(marcheText);
		marcheText.setColumns(10);
		
		
		idText = new JTextField();
		idText.setBounds(208, 175, 186, 22);
		frame.getContentPane().add(idText);
		idText.setColumns(10);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.desktop);
		panel_2.setBounds(436, 33, 10, 270);
		frame.getContentPane().add(panel_2);
		
		JLabel lblLesFournisseurs = new JLabel("les fournisseurs :");
		lblLesFournisseurs.setBounds(547, 56, 123, 22);
		frame.getContentPane().add(lblLesFournisseurs);
		
		fournisseur1 = new JTextField();
		fournisseur1.setBounds(515, 108, 202, 22);
		frame.getContentPane().add(fournisseur1);
		fournisseur1.setColumns(10);
        
		
		fournisseur2 = new JTextField();
		fournisseur2.setBounds(515, 163, 202, 22);
		frame.getContentPane().add(fournisseur2);
		fournisseur2.setColumns(10);
		
		
		fournisseur3 = new JTextField();
		fournisseur3.setBounds(515, 232, 207, 22);
		frame.getContentPane().add(fournisseur3);
		fournisseur3.setColumns(10);
		
		
		JButton btnInserer = new JButton("inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String marche = marcheText.getText();
				String marketName = marche.replace("'", "''");
				String identifiant = idText.getText();
				String  fournisseur_1 = fournisseur1.getText();
		        String  fourniss1 = fournisseur_1.replace("'", "''");
		        String  fournisseur_2 = fournisseur2.getText();
		        String  fourniss2 = fournisseur_2.replace("'", "''");
		        String  fournisseur_3 = fournisseur3.getText();
		        String  fourniss3 = fournisseur_3.replace("'", "''");
				try
	            {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	                String userName = prop.getProperty("userName");
        			String password = prop.getProperty("password");
        			String url = prop.getProperty("url");
        			
	                Connection con = DriverManager.getConnection(url, userName, password);
	                Statement s1 = con.createStatement();
	                String sql = "insert into fournisseurs values ('"+fourniss1+"','"+identifiant+"','"+marketName+"');";
	                String sql_1 = "insert into fournisseurs values ('"+fourniss2+"','"+identifiant+"','"+marketName+"');";
	                String sql_2 = "insert into fournisseurs values ('"+fourniss3+"','"+identifiant+"','"+marketName+"');";
	                System.out.println(fourniss1);
	                System.out.println(identifiant);
	                System.out.println(marketName);
	                s1.executeUpdate(sql);
	                s1.executeUpdate(sql_1);
	                s1.executeUpdate(sql_2);
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
				frame.setVisible(false);
				Inserted.main(null);
			}
		});
		btnInserer.setForeground(SystemColor.text);
		btnInserer.setBackground(SystemColor.desktop);
		btnInserer.setBounds(556, 315, 114, 25);
		frame.getContentPane().add(btnInserer);
	}
}
