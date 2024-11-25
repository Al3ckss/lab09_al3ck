package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent; 
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "SimpleGUI";
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JFrame frame = new JFrame(TITLE);
    
    public SimpleGUI(final Controller controller){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JTextArea textarea = new JTextArea();
        JButton button1 = new JButton("Save");
        
        panel.add(textarea, BorderLayout.CENTER);
        panel.add(button1, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //HANDLERS
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e){
                try {
                    String text = textarea.getText();
                    controller.saveStringToFile(text);
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(frame, "Errore durante il salvataggio: " + exc.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        new SimpleGUI(controller);
    }
}



/*    //Metodo display preso dall'esercizio 91-BadIOGUI
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    } 
*/