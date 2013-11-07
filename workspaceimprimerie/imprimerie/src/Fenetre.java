import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.rmi.Naming;
//import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Fenetre extends JFrame /* implements ActionListener*/{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame maFenetre;
	public JTabbedPane onglets, onglet_personnel, onglet_tache, onglet_vague;
	public JPanel pan_imprimerie, pan_personnel, pan_tache, pan_vague,pan_fiche_hebdo, pan_affichage, pan_propos, pan_pers_recru, pan_pers_modi,pan_pers_affiche,pan_tache_enreg,pan_tache_affecter,pan_vague_enreg,pan_vague_lister,pan_vague_salaire;
	public JLabel lab_pers_cathe,lab_pers_nom, lab_pers_prenom,lab_pers_naiss,lab_pers_email,lab_pers_tel,lab_pers_statu,lab_pers_grade,lab_pers_depart,lab_pers_fac,lab_pers_fil,lab_pers_niv,lab_pers_note,lab_pers_etat;
	public JTextField txt_pers_nom, txt_pers_prenom, txt_pers_naiss, txt_pers_email, txt_pers_tel, txt_pers_fac, txt_pers_fil, txt_pers_note;
	public JButton butban,butquit;
	private Font font,fon_perso,fon_tache;
	public  JFileChooser fileChooser = new JFileChooser("cas/");
	
	
	//definition des constructeurs

public Fenetre(String nom){
		
		super (nom);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(fileChooser);
		} catch (final Exception e) {
		}
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	font = new Font("Cambria",Font.ITALIC,13);
	fon_perso = new Font("Cambria",Font.ITALIC,13);
	fon_tache = new Font("Cambria",Font.ITALIC,13);
	//creation                                 des                                            pannaux
	pan_imprimerie = new JPanel();
	pan_personnel = new JPanel();
	pan_tache = new JPanel();
	pan_vague = new JPanel();
	pan_fiche_hebdo =new JPanel();
	pan_affichage = new JPanel(); 
	pan_propos = new JPanel();
	
	//                  pannaux de personnel
	pan_pers_recru = new JPanel();
	pan_pers_modi = new JPanel(); 
	pan_pers_affiche = new JPanel();
	
	pan_tache_enreg = new JPanel();
	pan_tache_affecter = new JPanel();
	
	pan_vague_enreg = new JPanel();
	pan_vague_lister = new JPanel();
	pan_vague_salaire = new JPanel();
	
	//creation des buttons
	butban = new JButton(new ImageIcon("images/ancien.JPG"));
    butban.setBounds(0, 0,840 , 112);
    butban.setBorderPainted(false);
    
    butquit = new JButton();
    butquit.setFont(new Font ("Cambria",Font.ITALIC,13));
    butquit.setText("Quitter");
    butquit.setBounds(700, 530,95 ,25);
    butquit.setBorderPainted(true);
    butquit.setMnemonic('q');
    butquit.setCursor(new Cursor(12));
    
    //creation des labels
    lab_pers_cathe = new JLabel("Cathegorie du personnel:");
    lab_pers_cathe.setFont(new Font ("Cambria",Font.BOLD,14));
    lab_pers_cathe.setBounds(40, 40, 210, 18);
    
    lab_pers_nom = new JLabel("Nom du personnel:");
    lab_pers_nom.setFont(new Font ("Cambria",Font.BOLD,14));
    lab_pers_nom .setBounds(40, 65, 200, 18);
    
    lab_pers_prenom = new JLabel("Prenom du personnel:");
    lab_pers_prenom.setFont(new Font ("Cambria",Font.BOLD,14));
    lab_pers_prenom.setBounds(40, 90, 200, 18);
    
    lab_pers_naiss = new JLabel("Date de naissance:");
    lab_pers_naiss.setFont(new Font ("Cambria",Font.BOLD,14));
    lab_pers_naiss.setBounds(40, 115, 200, 18);
    
    lab_pers_email = new JLabel("Email:");
    lab_pers_email.setFont(new Font ("Cambria",Font.BOLD,14));
    lab_pers_email.setBounds(40, 140, 200, 18);
    
    lab_pers_tel = new JLabel("Numero de telephone:");
    lab_pers_tel.setFont(new Font ("Cambria",Font.BOLD,14));
    lab_pers_tel.setBounds(40, 165, 200, 18);
    
    lab_pers_statu = new JLabel("Statut:");
    lab_pers_statu.setFont(new Font ("Cambria",Font.BOLD,14));
    lab_pers_statu.setBounds(40, 190, 200, 18);
    
    lab_pers_grade = new JLabel("Grade du personnel:");
    lab_pers_depart = new JLabel("Departement du personnel:");
    //si le personnel est etudiant
    lab_pers_fac = new JLabel("Faculte de l'etudiant:");
    lab_pers_fil = new JLabel("Filiere de l'etudiant:");
    lab_pers_niv = new JLabel("Niveau de l'etudiant:");
    lab_pers_note = new JLabel("Note de l'etudiant:");
    lab_pers_etat = new JLabel("Etat de l'etudiant:");
    
    //				Creation des jtexfield				/////////////
    txt_pers_nom= new JTextField();
    txt_pers_nom.setBounds(280, 65, 250, 25);
    
    txt_pers_prenom= new JTextField();
    txt_pers_prenom.setBounds(280, 90, 250, 25);
    
    txt_pers_naiss = new JTextField();
    txt_pers_prenom.setBounds(280, 205, 250, 25);
    
    txt_pers_email= new JTextField();
    txt_pers_email.setBounds(280, 140, 250, 25);
    
    txt_pers_tel= new JTextField();
    txt_pers_tel.setBounds(280, 165, 250, 25);
    
    txt_pers_fac= new JTextField();
    
    txt_pers_fil= new JTextField();
    
    txt_pers_note= new JTextField();
    
    //           Disposition des pannaux				/////////////
    
    pan_pers_recru.setLayout(null);
    
    pan_imprimerie.setLayout(null);
    pan_imprimerie.setBackground(new Color(255,255,255));
    
    pan_personnel.setLayout(null);
    pan_personnel.setBackground(new Color(255,255,255));
        
    pan_tache.setLayout(null);
    pan_tache.setBackground(new Color(255,255,255));
    

    pan_vague.setLayout(null);
    pan_vague.setBackground(new Color(255,255,255));
    
	//                                                        initialisation des onglets
    
    onglets = new JTabbedPane();
    onglets.addTab("Personnel", pan_personnel);
    onglets.addTab("Tache", pan_tache);
    onglets.addTab("Vague", pan_vague);
    onglets.addTab("Fiche hebdomadaire", pan_fiche_hebdo);
    onglets.addTab("Affichage", pan_affichage);
    onglets.addTab("A propos", pan_propos);
    
    onglets.setBounds(7, 110, 800, 400);
    onglets.setOpaque(false);
    onglets.setAutoscrolls(true);
    onglets.setFont(font);
    onglets.setBackground(Color.white);
    this.setSize(822, 600);
    
    onglet_personnel= new JTabbedPane();
    onglet_personnel.addTab("Recrutement", pan_pers_recru);
    onglet_personnel.addTab("Modifier un personnel",  pan_pers_modi);
    onglet_personnel.addTab("Afficher un personnel", pan_pers_affiche);
    
    onglet_personnel.setBounds(1, 2, 795, 397);
    onglet_personnel.setOpaque(false);
    onglet_personnel.setAutoscrolls(true);
    onglet_personnel.setFont(font);
    onglet_personnel.setBackground(Color.blue);
    this.setSize(822, 600);
    
    onglet_tache= new JTabbedPane();
    onglet_tache.addTab("Nouvelle tache", pan_tache_enreg);
    onglet_tache.addTab("Affecter tache", pan_tache_affecter);
    
    onglet_tache.setBounds(1, 2, 795, 397);
    onglet_tache.setOpaque(false);
    onglet_tache.setAutoscrolls(true);
    onglet_tache.setFont(font);
    onglet_tache.setBackground(Color.blue);
    this.setSize(822, 600);
    
    onglet_vague= new JTabbedPane();
    onglet_vague.addTab("Nouvelle vague", pan_vague_enreg);
    onglet_vague.addTab("Lister personnel", pan_vague_lister);
    onglet_vague.addTab("Afficher salaire", pan_vague_salaire);
    
    onglet_vague.setBounds(1, 2, 795, 397);
    onglet_vague.setOpaque(false);
    onglet_vague.setAutoscrolls(true);
    onglet_vague.setFont(font);
    onglet_vague.setBackground(Color.blue);
    this.setSize(822, 600);
    
    
    //                                               ajout des elements aux pannaux
    
    pan_personnel.add(onglet_personnel);
    
    pan_pers_recru.add(lab_pers_cathe);
    
    pan_pers_recru.add(lab_pers_nom);
    
    pan_pers_recru.add(lab_pers_prenom);
    
    pan_pers_recru.add(lab_pers_naiss);
    
    pan_pers_recru.add(lab_pers_email);
    
    pan_pers_recru.add(lab_pers_tel);
    
    pan_pers_recru.add(lab_pers_statu);
    
    pan_pers_recru.add(lab_pers_grade);
    
    pan_pers_recru.add(lab_pers_depart);
    
    pan_pers_recru.add(lab_pers_fac);
    
    pan_pers_recru.add(lab_pers_fil);
    
    pan_pers_recru.add(lab_pers_niv);
    
    pan_pers_recru.add(lab_pers_note);
    
    pan_pers_recru.add(lab_pers_etat);
    
    pan_pers_recru.add(txt_pers_nom);
    pan_pers_recru.add(txt_pers_prenom);
    pan_pers_recru.add(txt_pers_naiss);
    pan_pers_recru.add(txt_pers_email);
    pan_pers_recru.add(txt_pers_tel);
    //pan_pers_recru.add(txt_pers_);
    
    
    
    pan_tache.add(onglet_tache);
    pan_vague.add(onglet_vague);
    pan_imprimerie.add(onglets);
    pan_imprimerie.add(butban);
    pan_imprimerie.add(butquit);
    this.getContentPane().add(pan_imprimerie);
    this.setVisible(true);
    this.setLocation(250,145);
    this.setResizable(false);
    
}
	
	
	public static void main(String[] args) {
		try{
			
			   
		    	
			Fenetre fen=new Fenetre("Imprimerie : Administrateur");
			
		}
		catch(Exception e){ System.out.println("erreur d'interface "+e);}
	}
	
	

}
