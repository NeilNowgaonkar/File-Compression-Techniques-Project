package DAA_CP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener
{
    JButton RLE_btn, LZ77_btn, LZSS_btn, Huffman_btn;

    Dashboard()
    {
        RLE_btn=new JButton("RLE");
        RLE_btn.setBackground(Color.BLACK);
        RLE_btn.setForeground(Color.WHITE);
        RLE_btn.setFont(new Font("Tahoma",Font.PLAIN,20));
        RLE_btn.setBounds(150,50,200,50);
        RLE_btn.addActionListener(this);
        add(RLE_btn);

        LZ77_btn=new JButton("LZ77");
        LZ77_btn.setBackground(Color.BLACK);
        LZ77_btn.setForeground(Color.WHITE);
        LZ77_btn.setFont(new Font("Tahoma",Font.PLAIN,20));
        LZ77_btn.setBounds(150,120,200,50);
        LZ77_btn.addActionListener(this);
        add(LZ77_btn);

        Huffman_btn=new JButton("Huffman");
        Huffman_btn.setBackground(Color.BLACK);
        Huffman_btn.setForeground(Color.WHITE);
        Huffman_btn.setFont(new Font("Tahoma",Font.PLAIN,20));
        Huffman_btn.setBounds(150,190,200,50);
        Huffman_btn.addActionListener(this);
        add(Huffman_btn);

//        LZSS_btn=new JButton("LZSS");
//        LZSS_btn.setBackground(Color.BLACK);
//        LZSS_btn.setForeground(Color.WHITE);
//        LZSS_btn.setFont(new Font("Tahoma",Font.PLAIN,20));
//        LZSS_btn.setBounds(150,260,200,50);
//        LZSS_btn.addActionListener(this);
//        add(LZSS_btn);

        setLayout(null);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Dashboard().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("RLE"))
        {
            this.setVisible(false);
//            dispose();
//            new RLE();
            new RLE().setVisible(true);
        }
        else if(ae.getActionCommand().equals("LZ77"))
        {
            this.setVisible(false);
            new LZ77().setVisible(true);
        }
        else if(ae.getActionCommand().equals("LZSS"))
        {

        }
        else if(ae.getActionCommand().equals("Huffman"))
        {

        }

    }

}
