package DAA_CP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Huffman extends JFrame {
    private JPanel huffmanPanel;
    private JLabel huffmanLabel;
    private JLabel outputFileSizeLabel;
    private JLabel compressionRatioLabel;
    private JTextField outputFileSizeTextField;
    private JTextField compressionRatioTextField;
    private JButton encodeButton;
    private JButton decodeButton;
    private JLabel inputFileSizeLabel;
    private JTextField inputFileSizeTextField;

    Huffman() {
        setLayout(null);
        setContentPane(huffmanPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputFileSizeLabel.setVisible(false);
        outputFileSizeLabel.setVisible(false);
        compressionRatioLabel.setVisible(false);
        inputFileSizeTextField.setVisible(false);
        outputFileSizeTextField.setVisible(false);
        compressionRatioTextField.setVisible(false);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });

        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
    }
}
