import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Parameter Panel Class
 * 
 * 
 * @author Reece Reinke, KevJeon
 * @version 2018-12-5 Lab 13
 *
 */
public class ParameterPanel extends JPanel
{
    private JCheckBox TAIRBox = new JCheckBox("TAIR");
    private JCheckBox TA9MBox = new JCheckBox("TA9M");
    private JCheckBox SRADBox = new JCheckBox("SRAD");
    private JCheckBox WSPDBox = new JCheckBox("WSPD");
    private JCheckBox PRESBox = new JCheckBox("PRES");

    /**
     * Constructor for Parameter Panel
     * 
     */
    public ParameterPanel()
    {
        // constructing layout for panel
        TitledBorder titleBorder = new TitledBorder("Parameter");
        GridLayout ParamaterLayout = new GridLayout(0, 1);
        // setting the layout based of of parameterLayout
        setLayout(ParamaterLayout);
        setBorder(titleBorder);

        add(TAIRBox);
        add(TA9MBox);
        add(SRADBox);
        add(WSPDBox);
        add(PRESBox);
        // nested actionListener
        TAIRBox.addActionListener(new ActionListener()
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

        TA9MBox.addActionListener(new ActionListener()
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

        SRADBox.addActionListener(new ActionListener()
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

        WSPDBox.addActionListener(new ActionListener()
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

        PRESBox.addActionListener(new ActionListener()
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
     * Tells if Tair has been Selected
     * 
     * @return TAIRBox.isSelected()
     */
    public boolean TAIRSelected()
    {
        return TAIRBox.isSelected();
    }

    /**
     * Tells if TA9M has been Selected
     * 
     * @return TA9MBox.isSelected()
     */
    public boolean TA9MSelected()
    {
        return TA9MBox.isSelected();
    }

    /**
     * Tells if SRAD has been Selected
     * 
     * @return SRADBox.isSelected()
     */
    public boolean SRADSelected()
    {
        return SRADBox.isSelected();
    }

    /**
     * Tells if WSPD has been Selected
     * 
     * @return WSPDBox.isSelected()
     */
    public boolean WSPDSelected()
    {
        return WSPDBox.isSelected();
    }

    /**
     * Tells if PRES has been Selected
     * 
     * @return PRESBox.isSelected()
     */
    public boolean PRESSelected()
    {
        return PRESBox.isSelected();
    }

}
