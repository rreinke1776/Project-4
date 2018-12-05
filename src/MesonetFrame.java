import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * 
 * Mesonet JFrame Class This is where all the magic happens and we throw it all
 * the panels/ components together.
 * 
 * @author Reece Reinke, KevJeon
 * @version 2018-12-5 Lab 13
 *
 */
public class MesonetFrame extends JFrame
{
    // All the parts of the JFrame
    private StatisticsPanel statPanel;
    private TablePanel tablePanel;
    private FileMenuBar menuBar;
    private ParameterPanel paramMenu;
    private bottomBar bottomBar;
    // Instance to call mapData
    private MapData mapData = new MapData(0, 0, 0, 0, 0, "Foo");
    protected MapData data;

    /**
     * 
     * File Menu Bar, takes car of the file selection and exit in file menu.
     * 
     * @author Reece Reinke, KevJeon
     * @version 2018-12-5 Lab 13
     *
     */
    class FileMenuBar extends JMenuBar
    {
        // All the parts of our Menu
        private JMenu menu;
        private JMenuItem menu1;
        private JMenuItem menu2;
        private JFileChooser fileChooser;
        private int returnValue;
        private File file;

        /**
         * fILE MENU bAR CONSTRUCTOR
         * 
         */
        public FileMenuBar()
        {
            menu = new JMenu("File");
            add(menu);
            // creating elements
            menu1 = new JMenuItem("Open Data File");
            menu2 = new JMenuItem("Exit");
            // adding elements
            menu.add(menu1);
            menu.add(menu2);
            // nested action performed
            menu1.addActionListener(new ActionListener()
            {
                /**
                 * Action PErformed method in nested anon action listener Creates file name and
                 * mapData instance
                 * 
                 */
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    String fileName = "";
                    // creating the file chooser and directory to find files in
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(
                            new java.io.File("C:\\Users\\reece\\eclipse-workspace\\Project-4\\data"));

                    returnValue = fileChooser.showOpenDialog(null);
                    // if ok or true was clicked on
                    if (returnValue == JFileChooser.APPROVE_OPTION)
                    {
                        file = fileChooser.getSelectedFile();
                        // creating mapdata instance that we will be using
                        data = new MapData(mapData.seperateDate(file.getName())[0],
                                (mapData.seperateDate(file.getName())[1] - 1), mapData.seperateDate(file.getName())[2],
                                mapData.seperateDate(file.getName())[3], mapData.seperateDate(file.getName())[4],
                                "test");
                        fileName = "data/".concat(file.getName());
                        // setting file name
                        data.setFileName(fileName);
                        try
                        {
                            data.parseFile();
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            });

            menu2.addActionListener(new ActionListener()
            {
                /**
                 * Action PErformed method in nested anon action Exits Program
                 * 
                 */
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    // Exits program
                    System.exit(0);

                }
            });

        }
    }

    /**
     * 
     * Bottom Bar Class calculates stats or exits program
     * 
     * @author Reece Reinke, KevJeon
     * @version 2018-12-5 Lab 13
     *
     */
    class bottomBar extends JPanel
    {
        // buttons for our bar
        private JButton calculate;
        private JButton exit;

        /**
         * Bottom Bar constructor
         * 
         */
        public bottomBar()
        {
            calculate = new JButton("Calculate");
            exit = new JButton("Exit");
            // added buttons to bar
            add(calculate);
            add(exit);

            calculate.addActionListener(new ActionListener()
            {
                /**
                 * Determines what stats goes into Jtable
                 * 
                 */
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    // Filtering for what measurment was selected
                    if (paramMenu.TAIRSelected())
                    {
                        // Filtering for stat type
                        if (statPanel.MAXSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "TAIR").getStid()), 0, 0);
                            tablePanel.getTableModel().setValueAt("TAIR", 0, 1);
                            tablePanel.getTableModel().setValueAt("MAXIMUM", 0, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "TAIR").getValue()), 0, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "TAIR").getNumberOfReportingStations(), 0, 4);
                            // TODO Found it
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "TAIR").getUTCDateTimeString(), 0, 5);

                        }

                        // Filtering for stat type
                        if (statPanel.AVGSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "TAIR").getStid()), 0, 0);
                            tablePanel.getTableModel().setValueAt("TAIR", 0, 1);
                            tablePanel.getTableModel().setValueAt("AVERAGE", 0, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "TAIR").getValue()), 0, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "TAIR").getNumberOfReportingStations(), 0, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "TAIR").getUTCDateTimeString(), 0, 5);

                        }
                        // Filtering for stat type
                        if (statPanel.MINSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "TAIR").getStid()), 0, 0);
                            tablePanel.getTableModel().setValueAt("TAIR", 0, 1);
                            tablePanel.getTableModel().setValueAt("MINIMUM", 0, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "TAIR").getValue()), 0, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "TAIR").getNumberOfReportingStations(), 0, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "TAIR").getUTCDateTimeString(), 0, 5);

                        }

                    } else
                    {
                        // Clearing table row when not in use

                        tablePanel.getTableModel().setValueAt("", 0, 0);
                        tablePanel.getTableModel().setValueAt("", 0, 1);
                        tablePanel.getTableModel().setValueAt("", 0, 2);
                        tablePanel.getTableModel().setValueAt("", 0, 3);
                        tablePanel.getTableModel().setValueAt("", 0, 4);
                        tablePanel.getTableModel().setValueAt("", 0, 5);
                    }
                    // Filtering for what measurement was selected
                    if (paramMenu.TA9MSelected())
                    {
                        // Filtering for stat type
                        if (statPanel.MAXSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "TA9M").getStid()), 1, 0);
                            tablePanel.getTableModel().setValueAt("TA9M", 1, 1);
                            tablePanel.getTableModel().setValueAt("MAXIMUM", 1, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "TA9M").getValue()), 1, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "TA9M").getNumberOfReportingStations(), 1, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "TA9M").getUTCDateTimeString(), 1, 5);
                        }
                        // Filtering for stat type
                        if (statPanel.AVGSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "TA9M").getStid()), 1, 0);
                            tablePanel.getTableModel().setValueAt("TA9M", 1, 1);
                            tablePanel.getTableModel().setValueAt("AVERAGE", 1, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "TA9M").getValue()), 1, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "TA9M").getNumberOfReportingStations(), 1, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "TA9M").getUTCDateTimeString(), 1, 5);

                        }
                        // Filtering for stat type
                        if (statPanel.MINSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "TA9M").getStid()), 1, 0);
                            tablePanel.getTableModel().setValueAt("TA9M", 1, 1);
                            tablePanel.getTableModel().setValueAt("MINIMUM", 1, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "TA9M").getValue()), 1, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "TA9M").getNumberOfReportingStations(), 1, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "TA9M").getUTCDateTimeString(), 1, 5);

                        }

                    } else
                    {
                        // Clearing table row when not in use
                        tablePanel.getTableModel().setValueAt("", 1, 0);
                        tablePanel.getTableModel().setValueAt("", 1, 1);
                        tablePanel.getTableModel().setValueAt("", 1, 2);
                        tablePanel.getTableModel().setValueAt("", 1, 3);
                        tablePanel.getTableModel().setValueAt("", 1, 4);
                        tablePanel.getTableModel().setValueAt("", 1, 5);
                    }

                    // Filtering for what measurement was selected
                    if (paramMenu.SRADSelected())
                    {
                        // Filtering for stat type
                        if (statPanel.MAXSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "SRAD").getStid()), 2, 0);
                            tablePanel.getTableModel().setValueAt("SRAD", 2, 1);
                            tablePanel.getTableModel().setValueAt("MAXIMUM", 2, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "SRAD").getValue()), 2, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "SRAD").getNumberOfReportingStations(), 2, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "SRAD").getUTCDateTimeString(), 2, 5);
                        }
                        // Filtering for stat type
                        if (statPanel.AVGSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "SRAD").getStid()), 2, 0);
                            tablePanel.getTableModel().setValueAt("SRAD", 2, 1);
                            tablePanel.getTableModel().setValueAt("AVERAGE", 2, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "SRAD").getValue()), 2, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "SRAD").getNumberOfReportingStations(), 2, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "SRAD").getUTCDateTimeString(), 2, 5);

                        }
                        // Filtering for stat type
                        if (statPanel.MINSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "SRAD").getStid()), 2, 0);
                            tablePanel.getTableModel().setValueAt("SRAD", 2, 1);
                            tablePanel.getTableModel().setValueAt("MINIMUM", 2, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "SRAD").getValue()), 2, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "SRAD").getNumberOfReportingStations(), 2, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "SRAD").getUTCDateTimeString(), 2, 5);

                        }

                    } else
                    {
                        // Clearing table row when not in use
                        tablePanel.getTableModel().setValueAt("", 2, 0);
                        tablePanel.getTableModel().setValueAt("", 2, 1);
                        tablePanel.getTableModel().setValueAt("", 2, 2);
                        tablePanel.getTableModel().setValueAt("", 2, 3);
                        tablePanel.getTableModel().setValueAt("", 2, 4);
                        tablePanel.getTableModel().setValueAt("", 2, 5);
                    }
                    // Filtering for what measurement was selected
                    if (paramMenu.WSPDSelected())
                    {
                        // Filtering for stat type
                        if (statPanel.MAXSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "WSPD").getStid()), 3, 0);
                            tablePanel.getTableModel().setValueAt("WSPD", 3, 1);
                            tablePanel.getTableModel().setValueAt("MAXIMUM", 3, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "WSPD").getValue()), 3, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "WSPD").getNumberOfReportingStations(), 3, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "WSPD").getUTCDateTimeString(), 3, 5);
                        }
                        // Filtering for stat type
                        if (statPanel.AVGSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "WSPD").getStid()), 3, 0);
                            tablePanel.getTableModel().setValueAt("WSPD", 3, 1);
                            tablePanel.getTableModel().setValueAt("AVERAGE", 3, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "WSPD").getValue()), 3, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "WSPD").getNumberOfReportingStations(), 3, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "WSPD").getUTCDateTimeString(), 3, 5);

                        }
                        // Filtering for stat type
                        if (statPanel.MINSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "WSPD").getStid()), 3, 0);
                            tablePanel.getTableModel().setValueAt("WSPD", 3, 1);
                            tablePanel.getTableModel().setValueAt("MINIMUM", 3, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "WSPD").getValue()), 3, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "WSPD").getNumberOfReportingStations(), 3, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "WSPD").getUTCDateTimeString(), 3, 5);

                        }
                    } else
                    {
                        // Clearing table row when not in use
                        tablePanel.getTableModel().setValueAt("", 3, 0);
                        tablePanel.getTableModel().setValueAt("", 3, 1);
                        tablePanel.getTableModel().setValueAt("", 3, 2);
                        tablePanel.getTableModel().setValueAt("", 3, 3);
                        tablePanel.getTableModel().setValueAt("", 3, 4);
                        tablePanel.getTableModel().setValueAt("", 3, 5);
                    }
                    // Filtering for what measurement was selected
                    if (paramMenu.PRESSelected())
                    {
                        // Filtering for stat type
                        if (statPanel.MAXSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "PRES").getStid()), 4, 0);
                            tablePanel.getTableModel().setValueAt("PRES", 4, 1);
                            tablePanel.getTableModel().setValueAt("MAXIMUM", 4, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MAXIMUM, "PRES").getValue()), 4, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "PRES").getNumberOfReportingStations(), 4, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MAXIMUM, "PRES").getUTCDateTimeString(), 4, 5);
                        }
                        // Filtering for stat type
                        if (statPanel.AVGSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "PRES").getStid()), 4, 0);
                            tablePanel.getTableModel().setValueAt("PRES", 4, 1);
                            tablePanel.getTableModel().setValueAt("AVERAGE", 4, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.AVERAGE, "PRES").getValue()), 4, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "PRES").getNumberOfReportingStations(), 4, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.AVERAGE, "PRES").getUTCDateTimeString(), 4, 5);

                        }
                        // Filtering for stat type
                        if (statPanel.MINSelected())
                        {
                            // Acquiring stats for table and assigning locations for stats
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "PRES").getStid()), 4, 0);
                            tablePanel.getTableModel().setValueAt("PRES", 4, 1);
                            tablePanel.getTableModel().setValueAt("MINIMUM", 4, 2);
                            tablePanel.getTableModel()
                                    .setValueAt((data.getStatistics(StatsType.MINIMUM, "PRES").getValue()), 4, 3);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "PRES").getNumberOfReportingStations(), 4, 4);
                            tablePanel.getTableModel().setValueAt(
                                    data.getStatistics(StatsType.MINIMUM, "PRES").getUTCDateTimeString(), 4, 5);

                        }
                    } else
                    {
                        // Clearing table row when not in use
                        tablePanel.getTableModel().setValueAt("", 4, 0);
                        tablePanel.getTableModel().setValueAt("", 4, 1);
                        tablePanel.getTableModel().setValueAt("", 4, 2);
                        tablePanel.getTableModel().setValueAt("", 4, 3);
                        tablePanel.getTableModel().setValueAt("", 4, 4);
                        tablePanel.getTableModel().setValueAt("", 4, 5);
                    }
                }
            });

            exit.addActionListener(new ActionListener()
            {
                /**
                 * Exits Program from Bar Menu
                 * 
                 */
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    // exits program
                    System.exit(0);

                }
            });

        }

    }

    /**
     * Mesonet Frame Constructor
     * 
     */
    public MesonetFrame()
    {
        super("Mesonet");
        setLayout(new BorderLayout());
        // creating parts of JFrame
        tablePanel = new TablePanel();
        statPanel = new StatisticsPanel();
        menuBar = new FileMenuBar();
        paramMenu = new ParameterPanel();
        bottomBar = new bottomBar();
        // adding all the parts together
        add(menuBar, BorderLayout.NORTH);
        add(paramMenu, BorderLayout.WEST);
        add(statPanel, BorderLayout.EAST);
        add(tablePanel, BorderLayout.CENTER);
        add(bottomBar, BorderLayout.SOUTH);
        // window size
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Window is visible
        setVisible(true);

    }
}
