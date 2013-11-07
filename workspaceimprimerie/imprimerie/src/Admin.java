
import imprimerieDAO.GestionContactRemote;
import imprimerieDAO.ImprimerieStateless;
import java.awt.event.KeyEvent; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.BorderLayout;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import java.awt.Point;

import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.sql.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import jpa.Affecter;
import jpa.Compte;
import jpa.Personnel;
import jpa.Tache;
import jpa.Temporaire;
import jpa.Vague;
import org.jdesktop.swingx.JXDatePicker;


public class Admin {
	private JXDatePicker datepick=null;
	private JXDatePicker datepick1=null;
	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu editMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem cutMenuItem = null;
	private JMenuItem copyMenuItem = null;
	private JMenuItem pasteMenuItem = null;
	private JMenuItem saveMenuItem = null;
	private JDialog aboutDialog = null;
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel enregistrepersonne = null;  //  @jve:decl-index=0:visual-constraint="943,134"
	private JPanel jPanel1 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1nom = null;
	private JPanel jPanelaficeperso = null;  //  @jve:decl-index=0:visual-constraint="452,576"
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JLabel jLabel8 = null;
	private JLabel jLabel9 = null;
	private JLabel jLabel10 = null;
	private JLabel jLabel11 = null;
	private JLabel jLabel12 = null;
	private JLabel jLabel13 = null;
	private JLabel jLabel14 = null;
	private JLabel jLabelmatri = null;
	private JTextField jTextFieldnom = null;
	private JTextField jTextFieldprenom = null;
	private JTextField jTextFielddate = null;
	private JTextField jTextFieldamail = null;
	private JTextField jTextFieldtel = null;
	private JTextField jTextFieldcode = null;
	private JTextField jTextFieldstatu = null;
	private JTextField jTextFieldgrade = null;
	private JComboBox jComboBoxetat = null;
	private JTextField jTextFieldfac = null;
	private JTextField jTextFieldfilier = null;
	private JTextField jTextFieldniv = null;
	private JTextField jTextFieldetate = null;
	private JTextField jTextFieldmatricule = null;
	private JButton jButtonenregistre = null;
	private JLabel jLabel15 = null;
	private JLabel jLabel16 = null;
	private JTextField jTextFieldTACHE = null;
	private JButton jButtonENRETACHE = null;
	private JButton jButtonENREVAGUE = null;
	private JCheckBox jCheckBoxINFISUP = null;
	private JLabel jLabel17 = null;
	private JLabel jLabel18 = null;
	private JTextField jTextFieldINTITULEVAGUE = null;
	private JLabel jLabel19DATEDEBUT = null;
	private JLabel jLabel19DATEFIN = null;
	private JLabel jLabel19 = null;
	private JComboBox jComboBoxETAVAGUE = null;
	private JLabel jLabel20 = null;
	private JLabel jLabel21 = null;
	private JLabel jLabel22 = null;
	private JLabel jLabel23 = null;
	private JLabel jLabel24 = null;
	private JTextField jTextFieldLOGING = null;
	private JTextField jTextFieldPASS = null;
	private JTextField jTextFieldCONFIMPASS = null;
	private JComboBox jComboBoxETACOMPTE = null;
	private JButton jButtonENREGISCOMPTE = null;
	private JCheckBox jCheckBoxCOMPTE = null;
	private JScrollPane jScrollPaneperso = null;
	private static JTable jTableperso = null;
	private JComboBox jComboBoxdepartement = null;
	private JLabel jLabel25 = null;
	private JPanel jPanelAFFECTATION = null;  //  @jve:decl-index=0:visual-constraint="365,572"
	private JLabel jLabel26 = null;
	private JComboBox jComboBoxVAGUE = null;
	private JLabel jLabel27 = null;
	private JComboBox jComboBoxSEX = null;
	private JLabel jLabel28 = null;
	private JScrollPane jScrollPaneAFEC = null;
	private JTable jTableAFECFTE = null;
	private JComboBox jComboBoxdepart = null;
	private JComboBox jComboBoxsex = null;
	private JLabel jLabel29 = null;

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			//
			jTabbedPane.setOpaque(false);
			jTabbedPane.setAutoscrolls(true);
			jTabbedPane.setBackground(Color.white);
			jTabbedPane.addTab("ENREGISTREMENT", getEnregistrepersonne());
			jTabbedPane.addTab("AFFICHE DEPARTEMENT / ET PRESENCE", getJPanelaficeperso());
			jTabbedPane.addTab("TÄCHE", getJPanelAFFECTATION());
			
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes enregistrepersonne	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getEnregistrepersonne() {
		if (enregistrepersonne == null) {
			jLabel29 = new JLabel();
			jLabel29.setBounds(new Rectangle(367, 234, 48, 16));
			jLabel29.setText("sexe");
			jLabel14 = new JLabel();
			jLabel14.setBounds(new Rectangle(80, 305, 38, 16));
			jLabel14.setText("ETAT");
			jLabel13 = new JLabel();
			jLabel13.setBounds(new Rectangle(60, 414, 62, 16));
			jLabel13.setText("ETAT");
			jLabel12 = new JLabel();
			jLabel12.setBounds(new Rectangle(47, 392, 74, 16));
			jLabel12.setText("NIVEAU");
			jLabel11 = new JLabel();
			jLabel11.setBounds(new Rectangle(51, 368, 68, 16));
			jLabel11.setText("FILIERE");
			jLabel10 = new JLabel();
			jLabel10.setBounds(new Rectangle(41, 347, 77, 16));
			jLabel10.setText("FACULTE");
			jLabel9 = new JLabel();
			jLabel9.setBounds(new Rectangle(67, 321, 275, 17));
			jLabel9.setText("INFORMATION COMPLEMMENTAIRE");
			jLabel8 = new JLabel();
			jLabel8.setBounds(new Rectangle(9, 283, 109, 16));
			jLabel8.setText("DEPARTEMENT");
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(56, 257, 61, 16));
			jLabel7.setText("GRADE");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(56, 227, 65, 16));
			jLabel6.setText("STATU");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(59, 195, 58, 16));
			jLabel5.setText("CODE");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(25, 164, 89, 16));
			jLabel4.setText("TELEPHONE");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(59, 133, 53, 16));
			jLabel3.setText("EMAIL");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(1, 108, 117, 16));
			jLabel2.setText("DATE NAISSENCE");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(46, 81, 67, 16));
			jLabel1.setText("PRENOM");
			jLabel1nom = new JLabel();
			jLabel1nom.setBounds(new Rectangle(69, 58, 48, 16));
			jLabel1nom.setText("NOM");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 7, 323, 21));
			jLabel.setText(" ENREGISTREMENT DU PERSONNEL");
			enregistrepersonne = new JPanel();
			enregistrepersonne.setLayout(null);
			enregistrepersonne.add(getJPanel1(), null);
			enregistrepersonne.add(jLabel, null);
			enregistrepersonne.add(jLabel1nom, null);
			enregistrepersonne.add(jLabel1, null);
			enregistrepersonne.add(jLabel2, null);
			enregistrepersonne.add(jLabel3, null);
			enregistrepersonne.add(jLabel4, null);
			enregistrepersonne.add(jLabel5, null);
			enregistrepersonne.add(jLabel6, null);
			enregistrepersonne.add(jLabel7, null);
			enregistrepersonne.add(jLabel8, null);
			enregistrepersonne.add(jLabel9, null);
			enregistrepersonne.add(jLabel10, null);
			enregistrepersonne.add(jLabel11, null);
			enregistrepersonne.add(jLabel12, null);
			enregistrepersonne.add(jLabel13, null);
			enregistrepersonne.add(jLabel14, null);
			enregistrepersonne.add(getJTextFieldnom(), null);
			enregistrepersonne.add(getJTextFieldprenom(), null);
			enregistrepersonne.add(getJTextFielddate(), null);
			enregistrepersonne.add(getJTextFieldamail(), null);
			enregistrepersonne.add(getJTextFieldtel(), null);
			enregistrepersonne.add(getJTextFieldcode(), null);
			enregistrepersonne.add(getJTextFieldstatu(), null);
			enregistrepersonne.add(getJTextFieldgrade(), null);
			enregistrepersonne.add(getJComboBoxetat(), null);
			enregistrepersonne.add(getJTextFieldfac(), null);
			enregistrepersonne.add(getJTextFieldfilier(), null);
			enregistrepersonne.add(getJTextFieldniv(), null);
			enregistrepersonne.add(getJTextFieldetate(), null);
			enregistrepersonne.add(getJButtonenregistre(), null);
			enregistrepersonne.add(getJCheckBoxINFISUP(), null);
			enregistrepersonne.add(getJComboBoxdepart(), null);
			enregistrepersonne.add(getJComboBoxsex(), null);
			enregistrepersonne.add(jLabel29, null);
		}
		return enregistrepersonne;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabelmatri=new JLabel("matricule");
			jLabelmatri.setBounds(new Rectangle(300, 290, 100, 20));
			jLabel24 = new JLabel();
			jLabel24.setBounds(new Rectangle(129, 292, 39, 16));
			jLabel24.setText("ETAT");
			jLabel23 = new JLabel();
			jLabel23.setBounds(new Rectangle(30, 260, 150, 16));
			jLabel23.setText("CONFIRMEZ LE PASS");
			jLabel22 = new JLabel();
			jLabel22.setBounds(new Rectangle(89, 229, 89, 16));
			jLabel22.setText("PASS");
			jLabel21 = new JLabel();
			jLabel21.setBounds(new Rectangle(90, 201, 87, 16));
			jLabel21.setText("LOGIN");
			jLabel20 = new JLabel();
			jLabel20.setBounds(new Rectangle(53, 166, 245, 16));
			jLabel20.setText("CREE UN COMPTE ADMINISTRATEUR");
			jLabel19 = new JLabel();
			jLabel19.setBounds(new Rectangle(345, 97, 37, 16));
			jLabel19.setText("ETAT");
			jLabel19DATEFIN = new JLabel();
			jLabel19DATEFIN.setBounds(new Rectangle(234, 130, 68, 16));
			jLabel19DATEFIN.setText("DATE FIN");
			jLabel19DATEDEBUT = new JLabel();
			jLabel19DATEDEBUT.setBounds(new Rectangle(3, 129, 91, 20));
			jLabel19DATEDEBUT.setText("DATE DEBUT");
			jLabel18 = new JLabel();
			jLabel18.setBounds(new Rectangle(10, 97, 165, 16));
			jLabel18.setText("INTITULE DE LA VAGUE");
			jLabel17 = new JLabel();
			jLabel17.setBounds(new Rectangle(47, 69, 359, 16));
			jLabel17.setText("ENREGISTREMENT D UNE VAGUE");
			jLabel16 = new JLabel();
			jLabel16.setBounds(new Rectangle(1, 41, 174, 16));
			jLabel16.setText("INTITULE DE LA TÄCHE");
			jLabel15 = new JLabel();
			jLabel15.setBounds(new Rectangle(46, 8, 359, 16));
			jLabel15.setText("ENREGISTREMENT D UNE TÄCHE");
			jPanel1 = new JPanel();
			jPanel1.setLayout(null);
			jPanel1.setBackground(Color.lightGray);
			jPanel1.setBounds(new Rectangle(441, 13, 446, 408));
			jPanel1.add(jLabel15, null);
			jPanel1.add(jLabel16, null);
			jPanel1.add(getJTextFieldTACHE(), null);
			jPanel1.add(getJButtonENRETACHE(), null);
			jPanel1.add(getJButtonENREVAGUE() , null);
			jPanel1.add(jLabel17, null);
			jPanel1.add(jLabel18, null);
			jPanel1.add(getJTextFieldINTITULEVAGUE(), null);
			jPanel1.add(jLabel19DATEDEBUT, null);
			jPanel1.add(jLabel19DATEFIN, null);
			jPanel1.add(jLabel19, null);
			jPanel1.add(getJComboBoxETAVAGUE(), null);
			jPanel1.add(jLabel20, null);
			jPanel1.add(jLabel21, null);
			jPanel1.add(jLabel22, null);
			jPanel1.add(jLabel23, null);
			jPanel1.add(jLabel24, null);
			jPanel1.add(jLabelmatri, null);
			jPanel1.add(getJTextFieldLOGING(), null);
			jPanel1.add(getJTextFieldPASS(), null);
			jPanel1.add(getJTextFieldCONFIMPASS(), null);
			jPanel1.add(getJTextFieldmatricule(), null);
			jPanel1.add(getJComboBoxETACOMPTE(), null);
			jPanel1.add(getJButtonENREGISCOMPTE(), null);
			jPanel1.add(getJCheckBoxCOMPTE(), null);//
			jPanel1.add(getDatepick(), null);
			jPanel1.add(getDatepick1(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanelaficeperso	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelaficeperso() {
		if (jPanelaficeperso == null) {
			jLabel27 = new JLabel();
			jLabel27.setBounds(new Rectangle(680, 420, 44, 16));
			jLabel27.setText("SEXE");
			jLabel26 = new JLabel();
			jLabel26.setBounds(new Rectangle(412, 416, 69, 16));
			jLabel26.setText("VAGUE");
			jLabel25 = new JLabel();
			jLabel25.setBounds(new Rectangle(47, 415, 119, 20));
			jLabel25.setText("       Departement");
			jPanelaficeperso = new JPanel();
			jPanelaficeperso.setLayout(null);
			jPanelaficeperso.setSize(new Dimension(8, 2));
			jPanelaficeperso.add(getJScrollPaneperso(), null);
			jPanelaficeperso.add(getJComboBoxdepartement(), null);
			jPanelaficeperso.add(jLabel25, null);
			jPanelaficeperso.add(jLabel26, null);
			jPanelaficeperso.add(getJComboBoxVAGUE(), null);
			jPanelaficeperso.add(jLabel27, null);
			jPanelaficeperso.add(getJComboBoxSEX(), null);
		}
		return jPanelaficeperso;
	}

	/**
	 * This method initializes jTextFieldnom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldnom() {
		if (jTextFieldnom == null) {
			jTextFieldnom = new JTextField();
			jTextFieldnom.setBounds(new Rectangle(121, 56, 225, 20));
		}
		return jTextFieldnom;
	}

	/**
	 * This method initializes jTextFieldprenom	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldprenom() {
		if (jTextFieldprenom == null) {
			jTextFieldprenom = new JTextField();
			jTextFieldprenom.setBounds(new Rectangle(121, 80, 224, 19));
		}
		return jTextFieldprenom;
	}

	/**
	 * This method initializes jTextFielddate	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFielddate() {
		if (jTextFielddate == null) {
			jTextFielddate = new JTextField();
			jTextFielddate.setBounds(new Rectangle(121, 105, 224, 20));
		}
		return jTextFielddate;
	}

	/**
	 * This method initializes jTextFieldamail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldamail() {
		if (jTextFieldamail == null) {
			jTextFieldamail = new JTextField();
			jTextFieldamail.setBounds(new Rectangle(120, 134, 225, 20));
		}
		return jTextFieldamail;
	}

	/**
	 * This method initializes jTextFieldtel	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldtel() {
		if (jTextFieldtel == null) {
			jTextFieldtel = new JTextField();
			jTextFieldtel.setBounds(new Rectangle(121, 165, 224, 20));
		}
		return jTextFieldtel;
	}

	/**
	 * This method initializes jTextFieldcode	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldcode() {
		if (jTextFieldcode == null) {
			jTextFieldcode = new JTextField();
			jTextFieldcode.setBounds(new Rectangle(121, 194, 224, 20));
		}
		return jTextFieldcode;
	}

	/**
	 * This method initializes jTextFieldstatu	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldstatu() {
		if (jTextFieldstatu == null) {
			jTextFieldstatu = new JTextField();
			jTextFieldstatu.setBounds(new Rectangle(120, 226, 224, 20));
		}
		return jTextFieldstatu;
	}

	/**
	 * This method initializes jTextFieldgrade	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldgrade() {
		if (jTextFieldgrade == null) {
			jTextFieldgrade = new JTextField();
			jTextFieldgrade.setBounds(new Rectangle(120, 255, 224, 20));
		}
		return jTextFieldgrade;
	}

	/**
	 * This method initializes jComboBoxetat	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxetat() {
		if (jComboBoxetat == null) {
			Vector<String>v=new Vector<String>();
			v.add("active");v.add("desactive");
			jComboBoxetat = new JComboBox(v);
			jComboBoxetat.setBounds(new Rectangle(124, 306, 55, 14));
		}
		return jComboBoxetat;
	}

	/**
	 * This method initializes jTextFieldfac	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldfac() {
		if (jTextFieldfac == null) {
			jTextFieldfac = new JTextField();
			jTextFieldfac.setBounds(new Rectangle(123, 345, 220, 20));
			jTextFieldfac.setEditable(false);
		}
		return jTextFieldfac;
	}

	/**
	 * This method initializes jTextFieldfilier	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldfilier() {
		if (jTextFieldfilier == null) {
			jTextFieldfilier = new JTextField();
			jTextFieldfilier.setBounds(new Rectangle(122, 368, 221, 17));
			jTextFieldfilier.setEditable(false);
		}
		return jTextFieldfilier;
	}

	/**
	 * This method initializes jTextFieldniv	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldniv() {
		if (jTextFieldniv == null) {
			jTextFieldniv = new JTextField();
			jTextFieldniv.setBounds(new Rectangle(124, 391, 218, 18));
			jTextFieldniv.setEditable(false);
		}
		return jTextFieldniv;
	}

	/**
	 * This method initializes jTextFieldetate	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldetate() {
		if (jTextFieldetate == null) {
			jTextFieldetate = new JTextField();
			jTextFieldetate.setBounds(new Rectangle(123, 413, 111, 20));
			jTextFieldetate.setEditable(false);
		}
		return jTextFieldetate;
	}

	/**
	 * This method initializes jButtonenregistre	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonenregistre() {
		if (jButtonenregistre == null) {
			jButtonenregistre = new JButton();
			jButtonenregistre.setBounds(new Rectangle(293, 413, 137, 21));
			jButtonenregistre.setText("ENREGISTREZ");
			jButtonenregistre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					try { 
					Properties ppt = null;
						Context ctx = null;
						//ImprimerieStateless ref = null;
						GestionContactRemote home = null;
						 ppt = new Properties();
							ppt.put(Context.INITIAL_CONTEXT_FACTORY,
									"org.jnp.interfaces.NamingContextFactory");
							ppt.put(Context.PROVIDER_URL, "localhost:1099");
							ctx = new InitialContext(ppt);
							home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
					Temporaire t=new Temporaire();
					if(getJCheckBoxINFISUP().isSelected()){
					t.setFaculte(getJTextFieldfac().getText());
					t.setFiliere(getJTextFieldfilier().getText());
					t.setNiveau(getJTextFieldetate().getText());
					t.setEtat(getJTextFieldetate().getText());
					
				}
					Personnel p=new Personnel();
					p.setNompersonnel(getJTextFieldnom().getText());
					Date date=new Date(2013,10,12);
					p.setDatenaissance(date);
					p.setEmail(getJTextFieldamail().getText());
					p.setTel(getJTextFieldtel().getText());
					p.setCode(getJTextFieldcode().getText());
					p.setStatut(getJTextFieldstatu().getText());
					p.setGrade(getJTextFieldgrade().getText());
					p.setDepartement(""+getJComboBoxdepartement().getSelectedItem());
					String[]st={"weq"};
					Object [] dae={home.listindx(),p.getNompersonnel(),p.getNompersonnel(),st[0],new Boolean(true)};
					((ZModel)jTableAFECFTE.getModel()).addRow(dae);
						home.ajouterPersonnel(p);t.setIdpersonne(home.listindx());
						if(getJCheckBoxINFISUP().isSelected())
							home.ajouterTemporaire(t);
						JOptionPane.showConfirmDialog(null,"effectuer", "confirmation", JOptionPane.OK_OPTION);
						} catch (NamingException ed) {
						ed.printStackTrace();
						}
				}
			});
		}
		return jButtonenregistre;
	}

	/**
	 * This method initializes jTextFieldTACHE	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTACHE() {
		if (jTextFieldTACHE == null) {
			jTextFieldTACHE = new JTextField();
			jTextFieldTACHE.setBounds(new Rectangle(175, 40, 193, 20));
		}
		return jTextFieldTACHE;
	}

	/**
	 * This method initializes jButtonENRETACHE	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonENRETACHE() {
		if (jButtonENRETACHE == null) {
			jButtonENRETACHE = new JButton();
			jButtonENRETACHE.setBounds(new Rectangle(384, 41, 58, 17));
			jButtonENRETACHE.setText("OK");
			jButtonENRETACHE.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					 Properties ppt = null;
						Context ctx = null;
						ImprimerieStateless ref = null;
						GestionContactRemote home = null;
						
					      try {
					    	  ppt = new Properties();
								ppt.put(Context.INITIAL_CONTEXT_FACTORY,
										"org.jnp.interfaces.NamingContextFactory");
								ppt.put(Context.PROVIDER_URL, "localhost:1099");
								ctx = new InitialContext(ppt);
								home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
								

					         // Ne pas faire l'ajout plusieurs fois, commenter ces lignes apr��s la premi��re ex��cution.
					         Tache t= new Tache();
					         t.setLibele(getJTextFieldTACHE().getText());
					         t.setEtat("active");
					         home.ajouterTache(t);

					         

					      } catch (NamingException es) {
					         es.printStackTrace();
					      }
				
				}
			});
		}
		return jButtonENRETACHE;
	}
	/**
	 * This method initializes jButtonENRETACHE	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonENREVAGUE() {
		if (jButtonENREVAGUE == null) {
			jButtonENREVAGUE  = new JButton();
			jButtonENREVAGUE .setBounds(new Rectangle(384, 150, 58, 17));
			jButtonENREVAGUE .setText("OK");
			jButtonENREVAGUE .addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					 Properties ppt = null;
						Context ctx = null;
						ImprimerieStateless ref = null;
						GestionContactRemote home = null;
						
					      try {
					    	  ppt = new Properties();
								ppt.put(Context.INITIAL_CONTEXT_FACTORY,
										"org.jnp.interfaces.NamingContextFactory");
								ppt.put(Context.PROVIDER_URL, "localhost:1099");
								ctx = new InitialContext(ppt);
								home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
								

					         // Ne pas faire l'ajout plusieurs fois, commenter ces lignes apr��s la premi��re ex��cution.
					         Vague t= new Vague();
					         t.setIntitule(getJTextFieldINTITULEVAGUE().getText());
					         t.setActive("active");
					         Date date=new Date(datepick.getDate().getYear(),datepick.getDate().getMonth(),datepick.getDate().getDay());
					         Date date1=new Date(datepick1.getDate().getYear(),datepick1.getDate().getMonth(),datepick1.getDate().getDay());
					         t.setDatedebut(date);
					         t.setDatefin(date1);
					         home.ajouterVague(t);

					      } catch (NamingException ed) {
					         ed.printStackTrace();
					      }
				}
			});
		}
		return jButtonENREVAGUE ;
	}
	/**
	 * This method initializes jCheckBoxINFISUP	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxINFISUP() {
		if (jCheckBoxINFISUP == null) {
			jCheckBoxINFISUP = new JCheckBox();
			jCheckBoxINFISUP.setBounds(new Rectangle(35, 319, 21, 21));
			jCheckBoxINFISUP.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				if(jCheckBoxINFISUP.isSelected()){
					getJTextFieldfac().setEditable(true);
					getJTextFieldfilier().setEditable(true);
					getJTextFieldniv().setEditable(true);
					getJTextFieldetate().setEditable(true);
					getJTextFieldetate().setEditable(true);
				}else{
					getJTextFieldfac().setEditable(false);
					getJTextFieldfilier().setEditable(false);
					getJTextFieldniv().setEditable(false);
					getJTextFieldetate().setEditable(false);
					getJTextFieldetate().setEditable(false);
				}
				}
			});
		}
		return jCheckBoxINFISUP;
	}

	/**
	 * This method initializes jTextFieldINTITULEVAGUE	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldINTITULEVAGUE() {
		if (jTextFieldINTITULEVAGUE == null) {
			jTextFieldINTITULEVAGUE = new JTextField();
			jTextFieldINTITULEVAGUE.setBounds(new Rectangle(176, 96, 167, 20));
		}
		return jTextFieldINTITULEVAGUE;
	}

	/**
	 * This method initializes jComboBoxETAVAGUE	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxETAVAGUE() {
		if (jComboBoxETAVAGUE == null) {
			jComboBoxETAVAGUE = new JComboBox();
			jComboBoxETAVAGUE.setBounds(new Rectangle(385, 96, 55, 17));
		}
		return jComboBoxETAVAGUE;
	}

	/**
	 * This method initializes jTextFieldLOGING	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLOGING() {
		if (jTextFieldLOGING == null) {
			jTextFieldLOGING = new JTextField();
			jTextFieldLOGING.setBounds(new Rectangle(177, 200, 248, 20));
			jTextFieldLOGING.setEditable(false);
		}
		return jTextFieldLOGING;
	}

	/**
	 * This method initializes jTextFieldPASS	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldPASS() {
		if (jTextFieldPASS == null) {
			jTextFieldPASS = new JTextField();
			jTextFieldPASS.setBounds(new Rectangle(180, 228, 245, 20));
			jTextFieldPASS.setEditable(false);
		}
		return jTextFieldPASS;
	}

	/**
	 * This method initializes jTextFieldCONFIMPASS	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldCONFIMPASS() {
		if (jTextFieldCONFIMPASS == null) {
			jTextFieldCONFIMPASS = new JTextField();
			jTextFieldCONFIMPASS.setBounds(new Rectangle(179, 256, 244, 20));
			jTextFieldCONFIMPASS.setEditable(false);
		}
		return jTextFieldCONFIMPASS;
	}
	/**
	 * This method initializes jTextFieldCONFIMPASS	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldmatricule() {
		if (jTextFieldmatricule == null) {
			jTextFieldmatricule = new JTextField();
			jTextFieldmatricule.setBounds(new Rectangle(379, 290, 44, 20));
			jTextFieldmatricule.setEditable(false);
		}
		return jTextFieldmatricule;
	}
	/**
	 * This method initializes jComboBoxETACOMPTE	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxETACOMPTE() {
		if (jComboBoxETACOMPTE == null) {
			jComboBoxETACOMPTE = new JComboBox();
			jComboBoxETACOMPTE.setBounds(new Rectangle(182, 292, 79, 17));
			jComboBoxETACOMPTE.setEnabled(false);
		}
		return jComboBoxETACOMPTE;
	}

	/**
	 * This method initializes jButtonENREGISCOMPTE	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonENREGISCOMPTE() {
		if (jButtonENREGISCOMPTE == null) {
			jButtonENREGISCOMPTE = new JButton();
			jButtonENREGISCOMPTE.setBounds(new Rectangle(240, 333, 127, 21));
			jButtonENREGISCOMPTE.setText("ENREGISTREZ");
			jButtonENREGISCOMPTE.setEnabled(false);
			jButtonENREGISCOMPTE.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					  Properties ppt = null;
						Context ctx = null;
						ImprimerieStateless ref = null;
						GestionContactRemote home = null;
						
				      try {
				    	  ppt = new Properties();
							ppt.put(Context.INITIAL_CONTEXT_FACTORY,
									"org.jnp.interfaces.NamingContextFactory");
							ppt.put(Context.PROVIDER_URL, "localhost:1099");
							ctx = new InitialContext(ppt);
							home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
							

				         // Ne pas faire l'ajout plusieurs fois, commenter ces lignes apr��s la premi��re ex��cution.
				         Compte t= new Compte();
				         t.setLogin(getJTextFieldLOGING().getText());
				         t.setPassword(getJTextFieldPASS().getText());
				         t.setActive("active");
				         Personnel p=new Personnel();
				         p=home.rechercherPersonnel(getJTextFieldmatricule().getText());
				         t.setIdpersonne(p);
				         if(p!=null){
				        	 home.ajouterCompte(t);
				         }
				         //t.setEtat("actif");
				        // home.ajouterTache(t);

				         

				      } catch (NamingException e1) {
				         e1.printStackTrace();
				      }
				}
			});
		}
		return jButtonENREGISCOMPTE;
	}

	/**
	 * This method initializes jCheckBoxCOMPTE	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBoxCOMPTE() {
		if (jCheckBoxCOMPTE == null) {
			jCheckBoxCOMPTE = new JCheckBox();
			jCheckBoxCOMPTE.setBounds(new Rectangle(22, 164, 21, 21));
			jCheckBoxCOMPTE.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				if(jCheckBoxCOMPTE.isSelected()){
					getJTextFieldLOGING().setEditable(true);
					getJTextFieldPASS().setEditable(true);
					getJTextFieldCONFIMPASS().setEditable(true);
					getJComboBoxETACOMPTE().setEnabled(true);
					getJButtonENREGISCOMPTE().setEnabled(true);
					getJTextFieldmatricule().setEditable(true);
				}else{
					getJTextFieldLOGING().setEditable(false);
					getJTextFieldPASS().setEditable(false);
					getJTextFieldCONFIMPASS().setEditable(false);
					getJComboBoxETACOMPTE().setEnabled(false);
					getJButtonENREGISCOMPTE().setEnabled(false);
					getJTextFieldmatricule().setEditable(false);
				}
				}
			});
		}
		return jCheckBoxCOMPTE;
	}

	/**
	 * This method initializes jScrollPaneperso	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneperso() {
		if (jScrollPaneperso == null) {
			jScrollPaneperso = new JScrollPane();
			jScrollPaneperso.setBounds(new Rectangle(15, 17, 872, 395));
			jScrollPaneperso.setViewportView(getJTableperso());
		}
		return jScrollPaneperso;
	}

	/**
	 * This method initializes jTableperso	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableperso() {
		if (jTableperso == null) {
			//jTableperso = new JTable();
			 //Les données du tableau
			Object[][] data = {
					{"123","Nguefack","Brice",new Boolean(true),new Boolean(true)},
					{"134","Teguia","Marcel",new Boolean(true),new Boolean(true)},
					{"145","Nguegang","Rowlls",new Boolean(true),new Boolean(true)}
			};
		        //Les titres des colonnes
			String  title[] = {"matricule", "nom", "prenom","dedut travail","fin travail"};
			ZModel model = new ZModel(data, title);
			jTableperso = new JTable(model);
			jTableperso .setRowHeight(20);
			System.out.println("la mort du sujet");
			//jTableperso.setDefaultRenderer(Boolean.class, new TableComponent());
			//jTableperso.getColumn("dedut travail").setCellRenderer(new ButtonRenderer()); 
			jTableperso.setDefaultEditor(JComponent.class, new DefaultCellEditor(new JComboBox(new Boolean[]{true,false})));

			System.out.println("la mort du sujet");
		}
		return jTableperso;
	}

	/**
	 * This method initializes jComboBoxdepartement	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxdepartement() {
		if (jComboBoxdepartement == null) {
			jComboBoxdepartement = new JComboBox();
			jComboBoxdepartement.setBounds(new Rectangle(169, 414, 241, 21));
			jComboBoxdepartement.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
					  Properties ppt = null;
						Context ctx = null;
						ImprimerieStateless ref = null;
						GestionContactRemote home = null;
						 try {
					    	  ppt = new Properties();
								ppt.put(Context.INITIAL_CONTEXT_FACTORY,
										"org.jnp.interfaces.NamingContextFactory");
								ppt.put(Context.PROVIDER_URL, "localhost:1099");
								ctx = new InitialContext(ppt);
								home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
								

					         // Ne pas faire l'ajout plusieurs fois, commenter ces lignes apr��s la premi��re ex��cution.
					         Affecter t= new Affecter();
					        // t.set;
					         t.setEtat("actif");
					        // home.ajouterTache(t);

					         

					      } catch (NamingException es) {
					         es.printStackTrace();
					      }
				}
			});
		}
		return jComboBoxdepartement;
	}

	/**
	 * This method initializes jPanelAFFECTATION	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelAFFECTATION() {
		if (jPanelAFFECTATION == null) {
			jLabel28 = new JLabel();
			jLabel28.setBounds(new Rectangle(330, 7, 212, 23));
			jLabel28.setText("AFFECTEZ UNE TÄCHE ");
			jPanelAFFECTATION = new JPanel();
			jPanelAFFECTATION.setLayout(null);
			jPanelAFFECTATION.add(jLabel28, null);
			jPanelAFFECTATION.setBackground(Color.lightGray);
			jPanelAFFECTATION.add(getJScrollPaneAFEC(), null);
		}
		return jPanelAFFECTATION;
	}

	/**
	 * This method initializes jComboBoxVAGUE	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxVAGUE() {
		if (jComboBoxVAGUE == null) {
			jComboBoxVAGUE = new JComboBox();
			jComboBoxVAGUE.setBounds(new Rectangle(487, 416, 191, 21));
			jComboBoxVAGUE.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
					 Properties ppt = null;
						Context ctx = null;
						ImprimerieStateless ref = null;
						GestionContactRemote home = null;
					
				}
			});
		}
		return jComboBoxVAGUE;
	}

	/**
	 * This method initializes jComboBoxSEX	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxSEX() {
		if (jComboBoxSEX == null) {
			jComboBoxSEX = new JComboBox();
			jComboBoxSEX.setBounds(new Rectangle(736, 415, 150, 21));
			jComboBoxSEX.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
				}
			});
		}
		return jComboBoxSEX;
	}

	/**
	 * This method initializes jScrollPaneAFEC	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneAFEC() {
		if (jScrollPaneAFEC == null) {
			jScrollPaneAFEC = new JScrollPane();
			jScrollPaneAFEC.setBounds(new Rectangle(14, 37, 866, 392));
			jScrollPaneAFEC.setViewportView(getJTableAFECFTE());
		}
		return jScrollPaneAFEC;
	}

	/**
	 * This method initializes jTableAFECFTE	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableAFECFTE() {
		if (jTableAFECFTE == null) {
			//jTableperso = new JTable();
			 //Les données du tableau
			 Properties ppt = null;
				Context ctx = null;
				ImprimerieStateless ref = null;
				GestionContactRemote home = null;
				 List<Personnel> liste=null;
				 List<Tache> list=null;
				  try {
			    	  ppt = new Properties();
						ppt.put(Context.INITIAL_CONTEXT_FACTORY,
								"org.jnp.interfaces.NamingContextFactory");
						ppt.put(Context.PROVIDER_URL, "localhost:1099");
						ctx = new InitialContext(ppt);
						home = (GestionContactRemote) ctx.lookup("ImprimerieStateless/remote-Client");
			         // Ne pas faire l'ajout plusieurs fois, commenter ces lignes apr��s la premi��re ex��cution.
			        Personnel t= new Personnel();
			         liste=home.listerGroupe();
			        // list=home.listertache();
			      } catch (NamingException e) {
			         e.printStackTrace();
			      }
			Object[][] data = {};
			
		        //Les titres des colonnes
			String  title[] = {"matricule", "nom", "prenom","tache","active"};
			ZModel model = new ZModel(data, title);
			jTableAFECFTE = new JTable(model);
			
			String[] st={"imprimerie","netoyage","technicient"};
for(int i=0;i<liste.size();i++){
	Object [] date={liste.get(i).getIdpersonne(),liste.get(i).getNompersonnel(),liste.get(i).getNompersonnel(),st[0],new Boolean(true)};
	((ZModel)jTableAFECFTE.getModel()).addRow(date);
}JComboBox combo = new JComboBox(st);
			System.out.println("la mort du sujet");
			jTableAFECFTE.setRowHeight(20);
			jTableAFECFTE.getColumn("tache").setCellEditor(new DefaultCellEditor(combo));
			jTableAFECFTE.getColumn("tache").setCellEditor(new ButtonEditor(new JCheckBox(),true));
			//jTableperso.getColumn("dedut travail").setCellRenderer(new ButtonRenderer()); 
			//jTableAFECFTE.setDefaultEditor(JComponent.class, new DefaultCellEditor(new JComboBox(new String[]{"true","false"})));
;

		}
		return jTableAFECFTE;
	}

	/**
	 * This method initializes jComboBoxdepart	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxdepart() {
		if (jComboBoxdepart == null) {
			Vector<String>v=new Vector<String>();
			v.add("impression");v.add("nétoiyage");
			v.add("technicien");
			jComboBoxdepart = new JComboBox(v);
			jComboBoxdepart.setBounds(new Rectangle(122, 279, 221, 23));
		}
		return jComboBoxdepart;
	}

	/**
	 * This method initializes jComboBoxsex	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBoxsex() {
		if (jComboBoxsex == null) {
			jComboBoxsex = new JComboBox();
			jComboBoxsex.setBounds(new Rectangle(347, 253, 93, 19));
		}
		return jComboBoxsex;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Admin application = new Admin();
				application.getJFrame().setVisible(true);
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	 JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(921, 528);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Application");
			jFrame.setLocationRelativeTo(null);
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText("Edit");
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
		}
		return editMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog	
	 * 	
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("About");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 1.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText("Cut");
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK, true));
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText("Copy");
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return copyMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText("Paste");
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return pasteMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Save");
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return saveMenuItem;
	}

	public JXDatePicker getDatepick() {
        if(datepick==null){
        	datepick=new JXDatePicker();
        	datepick.setBounds(319, 126, 123, 23);
		}
		return datepick;
	}

	public void setDatepick(JXDatePicker datepick) {
		this.datepick = datepick;
	}

	public JXDatePicker getDatepick1() {
		if(datepick1==null){
			datepick1=new JXDatePicker();
			datepick1.setBounds(110, 126, 113, 23);
		}
		return datepick1;
	}

	public void setDatepick1(JXDatePicker datepick1) {
		this.datepick1 = datepick1;
	}
	//CLASSE MODÈLE PERSONNALISÉE
		class ZModel extends AbstractTableModel{

			private Object[][] data;
			private String[] title;
			/**
			 * Constructeur
			 * @param data
			 * @param title
			 */
			public ZModel(Object[][] data, String[] title){
				this.data = data;
				this.title = title;
			}
			
			/**
			* Retourne le titre de la colonne à l'indice spécifé
			*/
			public String getColumnName(int col) {
			  return this.title[col];
			}

			/**
			 * Retourne le nombre de colonnes
			 */
			public int getColumnCount() {
				return this.title.length;
			}
			
			/**
			 * Retourne le nombre de lignes
			 */
			public int getRowCount() {
				return this.data.length;
			}
			
			/**
			 * Retourne la valeur à l'emplacement spécifié
			 */
			public Object getValueAt(int row, int col) {
				return this.data[row][col];
			}
			
			/**
			 * Défini la valeur à l'emplacement spécifié
			 */
			public void setValueAt(Object value, int row, int col) {
				//On interdit la modification sur certaine colonne !
				if(!this.getColumnName(col).equals("Age") && !this.getColumnName(col).equals("Suppression"))
					this.data[row][col] = value;
			}
					
			/**
			* Retourne la classe de la donnée de la colonne
			* @param col
			*/
			public Class getColumnClass(int col){
				//On retourne le type de la cellule à la colonne demandée
				//On se moque de la ligne puisque les données sur chaque ligne sont les mêmes
				//On choisit donc la première ligne
				return this.data[0][col].getClass();
			}

			/**
			 * Retourne vrai si la cellule est éditable : celle-ci sera donc éditable
			 * @return boolean
			 */
			public boolean isCellEditable(int row, int col){
				if(getValueAt(0, col) instanceof JComboBox)
					return false;
				return true; 
			}
			/**
			 * Permet d'ajouter une ligne dans le tableau
			 * @param data
			 */
			public void addRow(Object[] data){
				int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();
				
				Object temp[][] = this.data;
				this.data = new Object[nbRow+1][nbCol];
				
				for(Object[] value : temp)
					this.data[indice++] = value;
				
					
				this.data[indice] = data;
				temp = null;
				//Cette méthode permet d'avertir le tableau que les données ont été modifiées
				//Ce qui permet une mise à jours complète du tableau
				this.fireTableDataChanged();
			}

					
		}
}
