package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    JLabel titleLabel;

    public AppFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(700, 400);
        getContentPane().setBackground(Color.gray);

        titleLabel = new JLabel("Developed by Anil Dongare");
        titleLabel.setBounds(150, 300, 400, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.green);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.PINK);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        titleLabel.setToolTipText("This is a custom label");

        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(250, 130, 200, 30);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(250, 230, 200, 30);
        decompressButton.addActionListener(this);

        add(titleLabel);
        add(compressButton);
        add(decompressButton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    decompressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
