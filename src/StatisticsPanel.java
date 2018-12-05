import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 * Statitics Panel Class For selecting which stat you want to display
 * 
 * @author Reece Reinke, KevJeon
 * @version 2018-12-5 Lab 13
 *
 */
public class StatisticsPanel extends JPanel
{
    private ButtonGroup group0;

    private JRadioButton MINButton = new JRadioButton("MINIMUM", true);
    private JRadioButton AVGButton = new JRadioButton("AVERAGE");
    private JRadioButton MAXButton = new JRadioButton("MAXIMUM");

    /**
     * Constructor for Stats Panel
     * 
     */
    public StatisticsPanel()
    {
        // creating layout
        GridLayout layout = new GridLayout(0, 1);
        TitledBorder border = new TitledBorder("Statistics");

        setLayout(layout);

        setBorder(border);
        add(MINButton);
        add(AVGButton);
        add(MAXButton);
        // adding buttons to group
        group0 = new ButtonGroup();
        group0.add(MAXButton);
        group0.add(AVGButton);
        group0.add(MINButton);

        MAXButton.addActionListener(new ActionListener()
        {
            /**
             * Does nothing just here for listening purposes
             * 
             */
            @Override
            public void actionPerformed(ActionEvent evt)
            {

            }
        });

        MINButton.addActionListener(new ActionListener()
        {
            /**
             * Does nothing just here for listening purposes
             * 
             */
            @Override
            public void actionPerformed(ActionEvent evt)
            {

            }
        });

        AVGButton.addActionListener(new ActionListener()
        {
            /**
             * Does nothing just here for listening purposes
             * 
             */
            @Override
            public void actionPerformed(ActionEvent evt)
            {

            }
        });

    }

    /**
     * Tells if MAX has been Selected
     * 
     * @return MAXButton.isSelected()
     */
    public boolean MAXSelected()
    {
        return MAXButton.isSelected();
    }

    /**
     * Tells if MIN has been Selected
     * 
     * @return MINButton.isSelected()
     */
    public boolean MINSelected()
    {
        return MINButton.isSelected();
    }

    /**
     * Tells if AVG has been Selected
     * 
     * @return AVGButton.isSelected()
     */
    public boolean AVGSelected()
    {
        return AVGButton.isSelected();
    }
}
