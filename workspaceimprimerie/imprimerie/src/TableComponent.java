import java.awt.Component; 
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class TableComponent extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table,
			Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		//Si la valeur de la cellule est un JButton, on transtype notre valeur
		if (value instanceof JComboBox){
			return (JComboBox) value;
		}
		else
			return this;
	}
}
