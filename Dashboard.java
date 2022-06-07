package DAA_CP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame
{
    JButton RLE_btn, LZ77_btn, LZSS_btn, Huffman_btn;
    private JPanel dashboardPanel;
    private JLabel fileCompressionLabel;
    private JButton rleButton;
    private JButton lz77Button;
    private JButton huffmanButton;

    Dashboard()
    {
        setLayout(null);
        setContentPane(dashboardPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        rleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RLE();
            }
        });

        lz77Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LZ77();
            }
        });

        huffmanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new Huffman();
            }
        });
    }

    public static void main(String[] args)
    {
        new Dashboard();
    }
}
