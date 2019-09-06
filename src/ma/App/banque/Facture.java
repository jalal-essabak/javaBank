package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Facture {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private JTextField No_facture;
	private JTextField Date_facture;
	private JTextField periode;
	private JTextField Total;
	private JTextField type;
	private JTextField Date_remise;
	private JTextField NomFournisseur;
	private JTextField idmarche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facture window = new Facture();
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
	public Facture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 990, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 990, 57);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVeuillezRemplirLes = new JLabel("Veuillez remplir les champs nessecaires ");
		lblVeuillezRemplirLes.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 14));
		lblVeuillezRemplirLes.setForeground(SystemColor.text);
		lblVeuillezRemplirLes.setBounds(340, 12, 402, 33);
		panel.add(lblVeuillezRemplirLes);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel_1.setBounds(0, 526, 834, 22);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("N° facture :");
		lblNewLabel.setBounds(45, 69, 94, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("contrat :");
		lblNewLabel_1.setBounds(45, 122, 66, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date de facture :");
		lblNewLabel_2.setBounds(45, 171, 122, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("periode :");
		lblNewLabel_3.setBounds(45, 227, 66, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Objet :");
		lblNewLabel_4.setBounds(45, 282, 66, 22);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Total TTC :");
		lblNewLabel_5.setBounds(45, 344, 77, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Type (comptabilite/immobilisé) :");
		lblNewLabel_6.setBounds(45, 400, 233, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date de remise :");
		lblNewLabel_7.setBounds(45, 455, 122, 22);
		frame.getContentPane().add(lblNewLabel_7);
		
		No_facture = new JTextField();
		No_facture.setBounds(195, 69, 286, 22);
		frame.getContentPane().add(No_facture);
		No_facture.setColumns(10);
		
		JTextArea contrates = new JTextArea();
		contrates.setBounds(195, 110, 286, 45);
		frame.getContentPane().add(contrates);
		
		Date_facture = new JTextField();
		Date_facture.setBounds(195, 171, 286, 22);
		frame.getContentPane().add(Date_facture);
		Date_facture.setColumns(10);
		
		periode = new JTextField();
		periode.setBounds(195, 227, 286, 24);
		frame.getContentPane().add(periode);
		periode.setColumns(10);
		
		JTextArea objet = new JTextArea();
		objet.setBounds(195, 273, 286, 45);
		frame.getContentPane().add(objet);
		
		Total = new JTextField();
		Total.setBounds(195, 346, 286, 22);
		frame.getContentPane().add(Total);
		Total.setColumns(10);
		
		type = new JTextField();
		type.setBounds(293, 393, 188, 22);
		frame.getContentPane().add(type);
		type.setColumns(10);
		
		Date_remise = new JTextField();
		Date_remise.setBounds(197, 456, 284, 22);
		frame.getContentPane().add(Date_remise);
		Date_remise.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
	            {
	                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	                String userName = "sa";
	                String password = "jocker@1995";
	                String url = "jdbc:sqlserver://192.168.0.10:1433"+";databaseName=BanqueApp";
	                Connection con = DriverManager.getConnection(url, userName, password);
	                Statement s1 = con.createStatement();
	                
	                //fields of the form
	                
	                String Nfournisseur = NomFournisseur.getText();
	                String nFacture = No_facture.getText();
	                String Contrat_1 = contrates.getText();
	                String Contrat = Contrat_1.replace("'", "''");
	                String Dfacture = Date_facture.getText();
	                String Periode_1 = periode.getText();
	                String Periode = Periode_1.replace("'","''");
	                String Object_1 = objet.getText();
	                String Object = Object_1.replace("'","''");
	                String TTC = Total.getText();
	                String Type = type.getText();
	                String Dremis = Date_remise.getText();
	                String id_marche = idmarche.getText();
	                String sql = "insert into factures(nomP,No_facture,contrat,date_de_fact,periode,Objet,Total_TTC,type_C_I,date_de_remise,identifiant)values('"
	                		+Nfournisseur+"','"+nFacture+"','"+Contrat+"','"+Dfacture+"','"+Periode+"','"
	                		+Object+"','"+TTC+"','"+Type+"','"+Dremis+"','"+id_marche+"');";
	                
	                //execute the request
	                
	                s1.executeUpdate(sql);
	                
	                /*NomFournisseur.setEditable(false);
	                No_facture.setEditable(false);
	                contrat.setEditable(false);
	                Date_facture.setEditable(false);
	                periode.setEditable(false);
	                objet.setEditable(false);
	                Total.setEditable(false);
	                type.setEditable(false);
	                Date_remise.setEditable(false);*/
	                frame.setVisible(false);
	                Inserted.main(null);
	            } catch (Exception e)
	            {
	                e.printStackTrace();
	            }
			}
		});
		btnAjouter.setForeground(SystemColor.text);
		btnAjouter.setBackground(SystemColor.desktop);
		btnAjouter.setBounds(661, 210, 147, 57);
		frame.getContentPane().add(btnAjouter);
		
		JLabel lblFournisseur = new JLabel("Nom de fournisseur");
		lblFournisseur.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 14));
		lblFournisseur.setBounds(509, 122, 248, 31);
		frame.getContentPane().add(lblFournisseur);
		
		NomFournisseur = new JTextField();
		NomFournisseur.setBounds(706, 111, 256, 36);
		frame.getContentPane().add(NomFournisseur);
		NomFournisseur.setColumns(10);
		
		JLabel lblIdentifiantDuMarche = new JLabel("identifiant du marche:");
		lblIdentifiantDuMarche.setBounds(499, 69, 182, 22);
		frame.getContentPane().add(lblIdentifiantDuMarche);
		
		idmarche = new JTextField();
		idmarche.setBounds(706, 69, 256, 31);
		frame.getContentPane().add(idmarche);
		idmarche.setColumns(10);
	}
}
