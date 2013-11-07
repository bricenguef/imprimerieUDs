import imprimerieDAO.GestionContactRemote;
import imprimerieDAO.ImprimerieStateless;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Properties;

import javax.naming.Context;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import antlr.collections.impl.Vector;

public class ButtonEditor extends DefaultCellEditor {
	  
	protected JButton button;
	protected JComboBox combo;
	private boolean   isPushed;
	private ButtonListener bListener = new ButtonListener();
	private combolistener CListener = new combolistener();
	 Properties ppt = null;
		Context ctx = null;
		ImprimerieStateless ref = null;
		GestionContactRemote home = null;
	/**
	 * Constructeur avec une checkBox
	 * @param checkBox
	 * @param count
	 */
	public ButtonEditor(JCheckBox checkBox) {
		//Par d?faut, ce type d'objet travaille avec un JCheckBox
		super(checkBox);
	    //On cr?e ? nouveau notre bouton
		button = new JButton();
	    button.setOpaque(true);
	    //On lui attribue un listener
	    button.addActionListener(bListener);
	}
	public ButtonEditor(JCheckBox checkBox,boolean s) {
		//Par d?faut, ce type d'objet travaille avec un JCheckBox
		super(checkBox);
	    //On cr?e ? nouveau notre bouton
		combo = new JComboBox();
	    combo.setOpaque(true);
	    //On lui attribue un listener
	    combo.addItemListener(CListener);
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
	                   boolean isSelected, int row, int column) { 
		//On d?finit le num?ro de ligne ? notre listener
		CListener.setRow(row);
		//Idem pour le num?ro de colonne
		CListener.setColumn(column);
		//On passe aussi le tableau pour des actions potentielles
		CListener.setTable(table);
		String[] st={"imprimerie","netoyage","technicient"};
		//On r?affecte le libell? au bouton
		combo = new JComboBox();
		for(int i=0;i<st.length;i++){
		combo.addItem(st[i]);
		}
		System.out.print(value);
		//On renvoie le bouton
	    return combo;
	}
	
	/**
	 * Notre listener pour le bouton
	 * @author CHerby
	 *
	 */
	class ButtonListener implements ActionListener{
		  
		  private int column, row;
		  private JTable table;
		  private int nbre = 0;
		  
		  public void setColumn(int col){this.column = col;}
		  public void setRow(int row){this.row = row;}
		  public void setTable(JTable table){this.table = table;}
		  
		  public void actionPerformed(ActionEvent event) {
			//On affiche un Zoli message mais vous pourriez faire les traitements que vous voulez
			System.out.println("coucou du bouton : " + ((JButton)event.getSource()).getText() );
			//On affecte un nouveau libell? ? une cellule de la ligne
			table.setValueAt("New Value " + (++nbre), this.row, (this.column -1));
		  }
	  }
	  class combolistener implements ItemListener{
		  
		  private int column, row;
		  private JTable table;
		  private int nbre = 0;
		  
		  public void setColumn(int col){this.column = col;}
		  public void setRow(int row){this.row = row;}
		  public void setTable(JTable table){this.table = table;}
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
						//On affiche un Zoli message mais vous pourriez faire les traitements que vous voulez
						System.out.println("coucou du bouton : " + ((JComboBox)e.getSource()).getSelectedItem() );
						//On affecte un nouveau libell? ? une cellule de la ligne
						table.setValueAt("New Value " + (++nbre), this.row, (this.column -1));
						
						
						
						
		}
		  
	  }
	}