package ma.App.banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;



public class Market {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	
	//private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Market window = new Market();
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
	public Market() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		//suppliers table 
		
		String []column_1= {"Fournisseurs"};
		String [][]donne= new String [3000][1];

		//bills table 
		
		String []column= {"N°facture","contrat","Date de facture","Periode","Objet","totalTTC","Type","Date de remise"};
		String [][]data=new String[3000][8];

		//clauses
		
		String [] clause_column = {"fournisseur","N° facture","clause_commande","clause_installation"};
		String [][]clauses = new String [3000][4];
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 873, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 876, 497);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		layeredPane.add(panel, "name_9285060989797");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.desktop);
		panel_1.setBounds(0, 0, 876, 241);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		layeredPane.add(panel_3, "name_9285077886425");
		panel_3.setLayout(null);
		
		JLabel lblLeNom = new JLabel("!! le nom inseré n'exist pas !!");
		lblLeNom.setVisible(false);
		lblLeNom.setForeground(new Color(255, 0, 0));
		lblLeNom.setBounds(309, 191, 212, 25);
		panel_1.add(lblLeNom);
		
		
		textField = new JTextField();
		textField.setBounds(131, 144, 391, 34);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("search");
		btnNewButton.setBorder(UIManager.getBorder("RadioButton.border"));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(SystemColor.activeCaptionText);
		btnNewButton.setBounds(548, 148, 124, 25);
		panel_1.add(btnNewButton);
		
		
		JLabel lblEntrerLeNom = new JLabel("entrer le nom du marché");
		lblEntrerLeNom.setForeground(SystemColor.text);
		lblEntrerLeNom.setBackground(SystemColor.text);
		lblEntrerLeNom.setBounds(283, 47, 262, 15);
		panel_1.add(lblEntrerLeNom);
		lblEntrerLeNom.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		
		JLabel lblPourObtenirLes = new JLabel("pour obtenir les information nessecaires !!");
		lblPourObtenirLes.setForeground(SystemColor.text);
		lblPourObtenirLes.setBounds(211, 88, 394, 15);
		panel_1.add(lblPourObtenirLes);
		lblPourObtenirLes.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		
		JButton btnReessayer = new JButton("reessayer");
		btnReessayer.setForeground(Color.WHITE);
		btnReessayer.setBackground(Color.BLACK);
		btnReessayer.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnReessayer.setBounds(684, 148, 124, 25);
		panel_1.add(btnReessayer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 239, 876, 258);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images/ma.gbp.pocketbank.jpg"));
		label.setBounds(128, 25, 145, 187);
		panel_2.add(label);
		
		JLabel lblAppuiyezSurajouter = new JLabel("Appuiyez sur \"Ajouter\"");
		lblAppuiyezSurajouter.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		lblAppuiyezSurajouter.setBounds(306, 86, 230, 31);
		panel_2.add(lblAppuiyezSurajouter);
		
		JLabel lblPourAjouterUn = new JLabel("pour ajouter un marché!!");
		lblPourAjouterUn.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		lblPourAjouterUn.setBounds(306, 129, 248, 23);
		panel_2.add(lblPourAjouterUn);
		
		JButton btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setBorder(UIManager.getBorder("RadioButton.border"));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.desktop);
		btnNewButton_1.setFont(new Font("FreeSans", Font.BOLD, 16));
		btnNewButton_1.setBounds(597, 100, 127, 37);
		panel_2.add(btnNewButton_1);
		
			
		JPanel panel_4 = new JPanel();
		panel_4.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		panel_4.setForeground(new Color(255, 255, 255));
		panel_4.setBackground(SystemColor.desktop);
		panel_4.setBounds(0, 0, 217, 497);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMarch = new JLabel("Fournisseurs");
		lblMarch.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		lblMarch.setForeground(new Color(255, 255, 255));
		lblMarch.setBounds(24, 149, 143, 15);
		panel_4.add(lblMarch);
		
		JLabel lblFactures = new JLabel("Factures");
		lblFactures.setForeground(new Color(255, 255, 255));
		lblFactures.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		lblFactures.setBounds(24, 202, 100, 15);
		panel_4.add(lblFactures);
		
		JLabel lblClauses = new JLabel("Clauses");
		
		lblClauses.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		lblClauses.setForeground(new Color(255, 255, 255));
		lblClauses.setBounds(24, 251, 100, 15);
		panel_4.add(lblClauses);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setBounds(24, 426, 66, 15);
		panel_4.add(lblHome);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("images/ma.gbp.pocketbank.jpg"));
		label_4.setBounds(37, 12, 168, 107);
		panel_4.add(label_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("images/icons8-horizontal-line-40.png"));
		label_3.setBounds(34, 175, 66, 15);
		panel_4.add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("images/icons8-horizontal-line-40.png"));
		label_5.setBounds(34, 229, 66, 15);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("images/icons8-horizontal-line-40.png"));
		label_6.setBounds(34, 399, 66, 15);
		panel_4.add(label_6);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBackground(Color.WHITE);
		layeredPane_1.setBounds(210, 0, 676, 497);
		panel_3.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		layeredPane_1.add(panel_5, "name_15305378430074");
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		layeredPane_1.add(panel_6, "name_15305399309583");
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(49, 81, 573, 314);
		panel_6.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(290, 27, 327, 447);
		panel_5.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(12, 12, 303, 423);
		panel_8.add(scrollPane_1);
				
		JLabel lblNewLabel = new JLabel("les fournisseurs assoccieés");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(28, 109, 244, 37);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("à ce marché");
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(38, 161, 198, 21);
		panel_5.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("ajouter fournisseur");
		btnNewButton_2.setBackground(SystemColor.desktop);
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBounds(28, 392, 244, 25);
		panel_5.add(btnNewButton_2);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(178, 34, 34));
		panel_12.setBounds(0, 476, 664, 21);
		panel_5.add(panel_12);
				
		JLabel lblLesFacturesRelie = new JLabel("Les factures \n");
		lblLesFacturesRelie.setBounds(243, 24, 191, 45);
		lblLesFacturesRelie.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 16));
		lblLesFacturesRelie.setForeground(SystemColor.desktop);
		panel_6.add(lblLesFacturesRelie);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 12, 549, 290);
		panel_7.add(scrollPane);
		
		JButton btnAjouterFacture = new JButton("ajouter facture");
		btnAjouterFacture.setForeground(SystemColor.text);
		btnAjouterFacture.setBackground(SystemColor.desktop);
		btnAjouterFacture.setBounds(419, 435, 175, 25);
		panel_6.add(btnAjouterFacture);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		layeredPane_1.add(panel_9, "name_1654222781034");
		panel_9.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(51, 82, 577, 279);
		panel_9.add(scrollPane_2);
		
		JButton btnAjouter = new JButton("ajouter");
		btnAjouter.setForeground(SystemColor.text);
		btnAjouter.setBackground(SystemColor.desktop);
		btnAjouter.setBounds(499, 373, 129, 39);
		panel_9.add(btnAjouter);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(178, 34, 34));
		panel_10.setBounds(0, 475, 664, 22);
		panel_9.add(panel_10);
		
		JLabel lblLesClausesAssocies = new JLabel("les clauses associes à ce marché");
		lblLesClausesAssocies.setForeground(SystemColor.desktop);
		lblLesClausesAssocies.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 16));
		lblLesClausesAssocies.setBounds(183, 28, 303, 25);
		panel_9.add(lblLesClausesAssocies);
				
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(178, 34, 34));
		panel_11.setBounds(0, 475, 664, 22);
		panel_6.add(panel_11);
		
		//methods
		 
		//button search
		btnNewButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						//panel.setVisible(false);
						textField.setEditable(false);
						try {
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

					        String userName = "sa";
					        String password = "jocker@1995";
					        String url = "jdbc:sqlserver://192.168.0.10:1433"+";databaseName=BanqueApp";
					        Connection con = DriverManager.getConnection(url, userName, password);
					        Statement s1 = con.createStatement();			        
					        String name = textField.getText();
					        String marche =name.replace("'", "''");
							String sql = "select nom from fournisseurs where serie='"+marche+"';";
							ResultSet rs =  s1.executeQuery(sql);
							int j=0;
								while(rs.next()) {								
										donne[j][0]=rs.getString(1);
										j++;
								}
								panel.setVisible(false);
								panel_3.setVisible(true);
							}catch(Exception e) {
								e.printStackTrace();
							}						
					}
				});
			
		table_1 = new JTable(donne,column_1);
		scrollPane_1.setViewportView(table_1);
		
		//button retry
		btnReessayer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						textField.setText("");
						textField.setEditable(true);
						lblLeNom.setVisible(false);
					}
				});
		
		//button add market
		btnNewButton_1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
					NewMarche.main(null);
					}
				});
		
		//lblMarche listener
		lblMarch.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						panel_5.setVisible(true);
						panel_6.setVisible(false);
						panel_9.setVisible(false);
						
					}
				});
		//lblFacture
				lblFactures.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						try {					
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					        String userName = "sa";
					        String password = "jocker@1995";
					        String url = "jdbc:sqlserver://192.168.0.10:1433"+";databaseName=BanqueApp";
					        Connection con = DriverManager.getConnection(url, userName, password);
					        Statement s1 = con.createStatement();
					        String name = textField.getText();
					        String identifiant=name.replace("'","''");
							String sql = "select * from factures where identifiant='"+identifiant+"';";
							ResultSet rs =  s1.executeQuery(sql);
							int i = 0;
							while(rs.next()){
		                             data[i][0]=rs.getString(2);
		                             data[i][1]=rs.getString(3);
		                             data[i][2]=rs.getString(4);
		                             data[i][3]=rs.getString(5);
		                             data[i][4]=rs.getString(6);
		                             data[i][5]=rs.getString(7);
		                             data[i][6]=rs.getString(8);
		                             data[i][7]=rs.getString(9);
		                             i++;
							}
							panel_9.setVisible(false);
							panel_5.setVisible(false);
							panel_6.setVisible(true);
							
							}catch(Exception c) {
								c.printStackTrace();
								lblLeNom.setVisible(true);
							}				
					}
						
				});
				
				table = new JTable(data,column);
				scrollPane.setViewportView(table);
				
				//button add bill
				btnAjouterFacture.addActionListener(new ActionListener() {
				        			public void actionPerformed(ActionEvent arg0) {
				        				Facture.main(null);
				        			};
						});
				
				//lblClauses
				lblClauses.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								try
					            {
					                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

					                String userName = "sa";
					                String password = "jocker@1995";
					                String url = "jdbc:sqlserver://192.168.0.10:1433"+";databaseName=BanqueApp";
					                Connection con = DriverManager.getConnection(url, userName, password);
					                Statement s1 = con.createStatement();
					                String marche = textField.getText();
					                String name = marche.replace("'", "''");
					                String sql = "select nomP,No_facture,clause_initial,clause_final from factures where identifiant='"+name+"'";
					                ResultSet rs = s1.executeQuery(sql);
					                int i=0;
					                while(rs.next()) {
					                	clauses[i][0]=rs.getString(1);
					                	clauses[i][1]=rs.getString(2);
					                	clauses[i][2]=rs.getString(3);
					                	clauses[i][3]=rs.getString(4);
					                	i++;
					                }
					                panel_5.setVisible(false);
					                panel_6.setVisible(false);
									panel_9.setVisible(true);
					         
					            } catch (Exception a)
					            {
					                a.printStackTrace();
					            }				
							}
							
						});
				
				table_2 = new JTable(clauses,clause_column);
				scrollPane_2.setViewportView(table_2);
				
				//button add a clause
				btnAjouter.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								frame.setVisible(false);
								Clause.main(null);
							}
						});
				//lblHome
				lblHome.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								Market.main(null);
							}
						});
		
				
	}
}
