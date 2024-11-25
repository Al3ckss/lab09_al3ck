package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public final class SimpleGUIWithFileChooser {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JFrame frame = new JFrame("SimpleGUIWithFileChooser");

    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel panel2 = new JPanel(new BorderLayout());

        final JTextArea textarea = new JTextArea(controller.getPath());
        final JTextField filepath = new JTextField(controller.getPath());
        filepath.setEditable(false);

        final JButton saveButton = new JButton("Save");
        final JButton browseButton = new JButton("Browse...");
        final JFileChooser fileChooser = new JFileChooser();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.saveStringToFile(textarea.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "An error occurred", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                fileChooser.setSelectedFile(controller.getFile());
                final int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = fileChooser.getSelectedFile();
                    controller.setFileAsCurrent(selectedFile);
                    filepath.setText(selectedFile.getPath());
                } else if (result == JFileChooser.CANCEL_OPTION) {
                
                } else {
                    JOptionPane.showMessageDialog(frame, "An error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel2.add(filepath, BorderLayout.CENTER);
        panel2.add(browseButton, BorderLayout.EAST);
        panel.add(panel2, BorderLayout.NORTH);
        panel.add(textarea, BorderLayout.CENTER);
        panel.add(saveButton, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        final Controller controller = new Controller();
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(controller);
        gui.display();
    }
}
