import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * Class for the Table Panel Displays all the stats in a table
 * 
 * @author Reece Reinke, KevJeon
 * @version 2018-12-5 Lab 13
 *
 */
public class TablePanel extends JPanel
{

    private MyTable myTable = new MyTable();
    private JTable JTable = new JTable(myTable);

    public TablePanel()
    {
        // constructing
        super(new BorderLayout());

        add(new JScrollPane(JTable));

    }

    /**
     * Class for myTable essential defining my own table here
     * 
     * @author Reece Reinke, KevJeon
     * @version 2018-12-5 Lab 13
     *
     */
    public static class MyTable extends AbstractTableModel
    {

        // Defining initial table columns and row values and Names of columns
        private String[] columnNames = { "Station", "Parameter", "Statistics", "Value", "Reporting Stations", "Date" };
        private Object[][] tableData = { { "", "", "", "", "", "" }, { "", "", "", "", "", "" },
                { "", "", "", "", "", "" }, { "", "", "", "", "", "" }, { "", "", "", "", "", "" }, };

        /**
         * Gets the Row Count
         * 
         * @return tableData.length;
         */
        @Override
        public int getRowCount()
        {
            // TODO Auto-generated method stub
            return tableData.length;
        }

        /**
         * Gets the Coulumn name
         * 
         * @return columnNames[columnIndex];
         */
        public String getColumnName(int columnIndex)
        {
            return columnNames[columnIndex];
        }

        /**
         * 
         * Gets the ColumnCount
         * 
         * @return columnNames.length;
         */
        @Override
        public int getColumnCount()
        {
            // TODO Auto-generated method stub
            return columnNames.length;
        }

        /**
         * Gets value at a location in table
         * 
         * @return tableData[rowIndex][columnIndex];
         * 
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            // TODO Auto-generated method stub
            return tableData[rowIndex][columnIndex];
        }

        /**
         * Sets Value at a location in the table
         * 
         * 
         * 
         */
        public void setValueAt(Object value, int rowIndex, int columnIndex)
        {

            tableData[rowIndex][columnIndex] = value;
            // tells all the listeners of the new value of the cell in the table
            fireTableCellUpdated(rowIndex, columnIndex);
        }

    }

    /**
     * 
     * Gets the created table
     * 
     * @return myTable
     */
    public MyTable getTableModel()
    {
        return myTable;
    }
}
