/**
 * This program is made to view images
 * But for my purposes, to understand how the methods work with java
 * Things to work on: The pictures aren't fixed so I need to get it working
 */

import java.awt.*;
import java.io.*;
import javax.swing.*;



public class ImageViewer 
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
/**
 * The above was made to create a the, assumming, GUI of the app
 */
class ImageViewerFrame extends JFrame
{
    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT =400;

    public ImageViewerFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //use a label to display the images
        label = new JLabel();
        add(label);

        /**
         * This is very important to know. This is the file chooser that
         * you will most likely use if you ever want to insert files in it
         *  
         */
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        //set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Open");
        menu.add(openItem);

        openItem.addActionListener(event ->{
            //Show file chooser dialog
            int result= chooser.showOpenDialog(null);

            //if file slected, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION)
            {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
    /**
     * We will now create a button to called Exit to close the program */    
    JMenuItem exitItem =new JMenuItem("Exit");
    menu.add(exitItem);
    exitItem.addActionListener(event -> System.exit(0));
    }
}
