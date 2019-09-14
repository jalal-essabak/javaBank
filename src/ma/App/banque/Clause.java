package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.awt.Color;

public class Clause {

	private JFrame frame;
	private JTextField txtNfournisseur;
	private JTextField txtClauseInitial;
	private JTextField txtClauseFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clause window = new Clause();
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
	public Clause() {
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
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 525, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 525, 75);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblInsererLesChamps = new JLabel("inserer les champs nessecaires");
		lblInsererLesChamps.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblInsererLesChamps.setForeground(SystemColor.text);
		lblInsererLesChamps.setBounds(122, 28, 310, 35);
		panel.add(lblInsererLesChamps);
		
		JLabel lblNomDeFournisseur = new JLabel("N° facture :");
		lblNomDeFournisseur.setBounds(45, 125, 158, 24);
		frame.getContentPane().add(lblNomDeFournisseur);
		
		JLabel lblClauseInitial = new JLabel("clause initial :");
		lblClauseInitial.setBounds(45, 199, 158, 24);
		frame.getContentPane().add(lblClauseInitial);
		
		JLabel lblClauseFinal = new JLabel("clause final :");
		lblClauseFinal.setBounds(45, 278, 158, 24);
		frame.getContentPane().add(lblClauseFinal);
		
		txtNfournisseur = new JTextField();
		txtNfournisseur.setBounds(221, 117, 234, 37);
		frame.getContentPane().add(txtNfournisseur);
		txtNfournisseur.setColumns(10);
		
		txtClauseInitial = new JTextField();
		txtClauseInitial.setBounds(221, 193, 234, 37);
		frame.getContentPane().add(txtClauseInitial);
		txtClauseInitial.setColumns(10);
		
		txtClauseFinal = new JTextField();
		txtClauseFinal.setBounds(221, 268, 234, 34);
		frame.getContentPane().add(txtClauseFinal);
		txtClauseFinal.setColumns(10);
		
		JButton btnInserer = new JButton("inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtNfournisseur.getText();
				String init = txtClauseInitial.getText();
				String fin  = txtClauseFinal.getText();				
				try
	            {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                
	                String userName = prop.getProperty("userName");
        			String password = prop.getProperty("password");
        			String url = prop.getProperty("url");

	                Connection con = DriverManager.getConnection(url, userName, password);
	                Statement s1 = con.createStatement();
	                String sql = "update factures set clause_initial='"+init+"'"+" where No_facture='"+name+"'; ";
	                String sql_1 = "update factures set clause_final='"+fin+"'"+" where No_facture='"+name+"'; ";
	                s1.executeUpdate(sql);
	                s1.executeUpdate(sql_1);
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
				frame.setVisible(false);
				Clause.main(null);
				Inserted.main(null);				
			}
		});
		btnInserer.setForeground(SystemColor.text);
		btnInserer.setBackground(SystemColor.desktop);
		btnInserer.setBounds(155, 370, 187, 46);
		frame.getContentPane().add(btnInserer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel_1.setBounds(0, 506, 525, 22);
		frame.getContentPane().add(panel_1);
	}
}
