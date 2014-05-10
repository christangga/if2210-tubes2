package upperscoreswing;

import javax.swing.table.AbstractTableModel;
import UpperScore.*;
import javax.swing.event.TableModelListener;

public class TableData extends AbstractTableModel{
    private final String[] columnNames = {"Barcode","Nama","Quantity","Price"};
    private Object[][] data;
    
    public TableData()
    {
        data = new Object[1][4];
        data[0][0] = "";
        data[0][1] = "";
        data[0][2] = new Integer(0);
        data[0][3] = new Integer(0);
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if(col==2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    public void RefreshTable(Belanja belanja)
    {
        int currentRow = getRowCount();
        data = new Object[belanja.getshoppingList().size()][4];
        
        for(int i=0;i<belanja.getshoppingList().size();i++)
        {
            setValueAt(belanja.getshoppingList().get(i).getBarcode().getId(),i,0);
            setValueAt(belanja.getshoppingList().get(i).getNama(),i,1);
            setValueAt(belanja.getshoppingList().get(i).getQuantity(),i,2);
            setValueAt(belanja.getshoppingList().get(i).getHarga()*belanja.getshoppingList().get(i).getQuantity(),i,3);
        }
        setValueAt("",getRowCount()-1,0);
        setValueAt("",getRowCount()-1,1);
        setValueAt(0,getRowCount()-1,2);
        setValueAt(0,getRowCount()-1,3);
        fireTableRowsInserted(1, currentRow+1);
    }
}
