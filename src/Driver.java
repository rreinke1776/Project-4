import javax.swing.SwingUtilities;
import javax.swing.JFrame;


/**
 * 
 * Driver Class for Project
 * 
 * @author Reece Reinke, KevJeon
 * @version 2018-12-25 Lab 13
 *
 */



public class Driver
{

    public static void main(String[] args)
    {
        //All New Driver Class
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new MesonetFrame();
            }

        });
    }

}
