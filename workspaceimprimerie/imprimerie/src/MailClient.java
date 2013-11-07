
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParsePosition;
import java.util.Properties;

	public class MailClient extends JFrame  implements ActionListener
	{
		public JPanel pan_mess1;
		public JLabel lab_emetteur,lab_recepteur,lab_objet,lab_type,lab_message;
		public JTextField txt_emetteur,txt_recepteur,txt_objet,txt_type,txt_message;
		public JButton but_envoi,but_annuler,but_effacer;
		String from,to,subject,message;
		private Font font;

		public MailClient(){
			super("Envoie de message");
			font=new Font ("Cambria",Font.BOLD,13);
			pan_mess1 = new JPanel();
			lab_emetteur = new JLabel("Emetteur");
			lab_emetteur.setFont(font);
			lab_recepteur = new JLabel("Recepteur");
			lab_recepteur.setFont(font);
			lab_objet = new JLabel("Objet:");
			lab_objet.setFont(font);
			lab_type = new JLabel("Envoyer a un groupe:");
			lab_type.setFont(font);
			lab_message = new JLabel("Message:");
			lab_message.setFont(font);
		
			
			txt_emetteur = new JTextField();
			txt_recepteur = new JTextField();
			txt_objet = new JTextField();
			txt_message = new JTextField();
			but_envoi= new JButton("Envoyer");
		    but_envoi.setFont(new Font ("Cambria",Font.BOLD,13));
			but_annuler= new JButton("Annuler");
		    but_annuler.setFont(new Font ("Cambria",Font.BOLD,13));
			but_effacer= new JButton("Effacer");
		    but_annuler.setFont(new Font ("Cambria",Font.BOLD,13));
			
		    pan_mess1.setLayout(null);
		    pan_mess1.setBackground(new Color(255,255,255));
		    
		    pan_mess1.add(lab_emetteur);
		    pan_mess1.add(lab_recepteur);
		    pan_mess1.add(lab_objet);
		    pan_mess1.add(lab_type);
		    pan_mess1.add(lab_message);
		    
		    pan_mess1.add(txt_emetteur);
		    pan_mess1.add(txt_recepteur);
		    pan_mess1.add(txt_objet);
		    pan_mess1.add(txt_message);
		    pan_mess1.add(but_envoi);
		    pan_mess1.add(but_effacer);
		    pan_mess1.add(but_annuler);
		    
		    lab_emetteur.setBounds(40, 40, 200, 25);
			lab_recepteur.setBounds(40, 70, 200, 25);
			lab_objet.setBounds(40, 100, 200, 25);
			lab_type.setBounds(40,130 , 200, 25);
		    lab_message.setBounds(40, 160, 200, 18);

		    txt_emetteur.setBounds(200, 40, 200, 25);
		    txt_recepteur.setBounds(200, 70, 200, 25);
		    txt_objet.setBounds(200, 100, 300, 25);
		    //txt_type.setBounds(300, 100, 100, 18);
		    txt_message.setBounds(200, 160, 300, 100);
		    
		    but_envoi.setBounds(100, 300, 100, 25);
		    but_annuler.setBounds(220, 300, 100, 25);
		    but_effacer.setBounds(340, 300, 100, 25);
		    
		    this.getContentPane().add(pan_mess1);
		    this.setVisible(true);
		    this.setSize(622, 400);
		    this.setLocation(200,145);
		    this.setResizable(false);
		    
		    but_envoi.addActionListener(this);
		    but_annuler.addActionListener(this);
		    but_effacer.addActionListener(this);
		    
		}
		
		public void actionPerformed(ActionEvent e) {
			Object source= e.getSource();
			
			if( source == but_envoi){
					try {
						from=this.txt_emetteur.getText();
						to=this.txt_recepteur.getText();
						subject=this.txt_objet.getText();
						message=this.txt_message.getText();
						this.sendMail(from,to,subject,message);
						JOptionPane.showMessageDialog(null," Message envoye a "+to, "Message d'alerte", JOptionPane.WARNING_MESSAGE);
						
					} catch (Exception e1) {
						 JOptionPane.showMessageDialog(null," veillez Rempli toutes les informations", "Message d'alerte", JOptionPane.WARNING_MESSAGE);

					}
					
				}
			
				if( source == but_effacer){
						try {
							txt_emetteur.setText("");
							txt_recepteur.setText("");
							txt_objet.setText("");
							//txt_type.setText("");
							txt_message.setText("");
							
						}catch (RuntimeException e1) {
							 System.out.println(e1);

						}
				}				
				if( source == but_annuler){
			    
			
			}

		}
        	
        
		public void sendMail(String from, String to,
				String subject, String messageBody) throws MessagingException, AddressException
				{
			// Setup mail server
			//pop.mail.yahoo.com
			String host = "smtp.mail.yahoo.com";
			String username = "brice_nguefack@yahoo.fr";
			String password = "lalala25";
			Properties props = new Properties();
			
			//props.put("mail.smtps.auth", "true");

			// Get a mail session
			
Session session = Session.getDefaultInstance(props, null);

	// Define a new mail message
	MimeMessage message = new MimeMessage(session);
	message.setFrom(new InternetAddress(from));
	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	message.setSubject(subject);
	
	message.setText(messageBody);

	// Send the message
		Transport t = session.getTransport("smtps");
		try {
			t.connect(host, username, password);
			t.sendMessage(message, message.getAllRecipients());
		} finally {
			t.close();
		}

	}

		public static void main(String[] args)
		{
			try
			{
				
				MailClient client = new MailClient();
				/*String from="brice_nguefack@yahoo.fr";
				String to = "brice_nguefack@yahoo.fr";
				String subject="Test of printing room";
				String message="I'm testing. Do you see this?";*/

				//client.sendMail(from,to,subject,message);
			}
			catch(Exception e)
			{
				e.printStackTrace(System.out);
			}

		}
	}