package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Authentification {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification window = new Authentification();
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
	public Authentification() {
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
		frame.setBounds(100, 100, 662, 295);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 218, 265);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/ma.gbp.pocketbank.jpg"));
		label.setBounds(47, 13, 120, 114);
		panel.add(label);
		
		JLabel lblVeuillezInsererVos = new JLabel("Gestionnaire des marchés");
		lblVeuillezInsererVos.setFont(new Font("Manjari Bold", Font.BOLD, 14));
		lblVeuillezInsererVos.setForeground(new Color(255, 255, 255));
		lblVeuillezInsererVos.setBounds(24, 160, 194, 67);
		panel.add(lblVeuillezInsererVos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 13));
		panel_1.setBounds(222, 0, 440, 265);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblVeuillezInsererVos_1 = new JLabel("Veuillez inserer vos données SVP!");
		lblVeuillezInsererVos_1.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 18));
		lblVeuillezInsererVos_1.setBounds(70, 35, 299, 15);
		panel_1.add(lblVeuillezInsererVos_1);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(35, 103, 66, 15);
		panel_1.add(lblNom);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe:");
		lblMotDePasse.setBounds(35, 162, 100, 15);
		panel_1.add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setBounds(173, 94, 206, 33);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 146, 206, 33);
		panel_1.add(passwordField);
		
		JLabel lblNomOuMot = new JLabel("'Nom' ou  'Mot de passe' erroné !!");
		lblNomOuMot.setVisible(false);
		lblNomOuMot.setForeground(new Color(255, 0, 0));
		lblNomOuMot.setBounds(113, 189, 239, 15);
		panel_1.add(lblNomOuMot);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
	            {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	                String userName = prop.getProperty("userName");
        			String password = prop.getProperty("password");
        			String url = prop.getProperty("url");
        			
	                Connection con = DriverManager.getConnection(url, userName, password);
	                Statement s1 = con.createStatement();
	               
	                String name = textField.getText();
	                @SuppressWarnings("deprecation")
	                String passwd = passwordField.getText();
	                
	 	                ResultSet rs = s1.executeQuery("SELECT * FROM Authentification where name='"+name+"' and passwd='"+passwd+"';");
	  	                if(rs.next()) {
	  	                frame.setVisible(false);
	  	                Market.main(null);
	                    }else{
	                    	lblNomOuMot.setVisible(true); 
	                    }
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(SystemColor.desktop);
		btnLogin.setBounds(255, 216, 114, 25);
		panel_1.add(btnLogin);
		
		JButton btnRessayer = new JButton("ressayer");
		btnRessayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNomOuMot.setVisible(false);
				textField.setText(null);
				passwordField.setText(null);
				textField.setEditable(true);
				passwordField.setEditable(true);
			}
		});
		btnRessayer.setForeground(new Color(255, 255, 255));
		btnRessayer.setBackground(SystemColor.desktop);
		btnRessayer.setBounds(88, 216, 114, 25);
		panel_1.add(btnRessayer);
	}
}
