package upperscoreswing;

import javax.swing.table.AbstractTableModel;
import UpperScore.*;

// Kelas untuk pengisian tabel pada layar UpperScoreShop
public class TableData extends AbstractTableModel{
    private final String[] columnNames = {"Barcode","Nama","Quantity","Price"};
    private Object[][] data;
    private final Class[] types = new Class [] {java.lang.String.class, 
                                                java.lang.String.class, 
                                                java.lang.Integer.class, 
                                                java.lang.Integer.class};
    
    // Constructor, mengisi nilai awal tabel yaitu kosong, kosong, 0, 0
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
            return false;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    
    // Membuat isi tabel menjadi yang terupdate
    public void RefreshTable(Belanja belanja)
    {
        int currentRow = getRowCount();
        data = new Object[belanja.getshoppingList().size()+1][4];
        
        for(int i=0;i<belanja.getshoppingList().size();i++)
        {
            setValueAt(belanja.getshoppingList().get(i).getBarcode().getId(),i,0);
            setValueAt(belanja.getshoppingList().get(i).getNama(),i,1);
            setValueAt(belanja.getshoppingList().get(i).getQuantity(),i,2);
            setValueAt(belanja.getshoppingList().get(i).getHarga()*belanja.getshoppingList().get(i).getQuantity(),i,3);
        }
        setValueAt("",belanja.getshoppingList().size(),0);
        setValueAt("",belanja.getshoppingList().size(),1);
        setValueAt(0,belanja.getshoppingList().size(),2);
        setValueAt(0,belanja.getshoppingList().size(),3);
        fireTableRowsInserted(1, currentRow+1);
    }
}
