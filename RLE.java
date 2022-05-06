package DAA_CP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class RLE extends JFrame implements ActionListener
{
    // Perform Run–length encoding (RLE) data compression algorithm
    // on string `str`
    public static String encode(String str)
    {
        // stores output string
        String encoding = "";

        // base case
        if (str == null) {
            return encoding;
        }

        int count;

        for (int i = 0; i < str.length(); i++)
        {
            // count occurrences of character at index `i`
            count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))
            {
                count++;
                i++;
            }

            // append current character and its count to the result
            encoding += String.valueOf(count) + str.charAt(i);
        }

        

        return encoding;
    }

    public static String decode(String str)
    {
        String src = "3A8B2 4C5D4";
        StringBuilder dest = new StringBuilder();

        for (int i = 1; i < src.length(); i = i + 2) {
            char charAt = src.charAt(i);
            int cnt = src.charAt(i - 1) - '0';
            for (int j = 0; j < cnt; j++) {
                dest.append(charAt);
            }
        }
        return (dest.toString());
    }

    public static void main(String[] args) throws Exception
    {
        new Dashboard().setVisible(true);

        Helper obj=new Helper();
        FileChooser file_obj=new FileChooser();
        //String str = "AAABBBBBBBB  CCCCDDDDD";
        //String input_file=file_obj.chooseFile();
        String input_file="D:\\STUDY\\JAVA QUESTIONS\\src\\DAA_CP\\Input.txt";
        String output_file="D:\\STUDY\\JAVA QUESTIONS\\src\\DAA_CP\\RLE_Output.txt";

        //String str = obj.readFileAsString(input_file);
        //String encoded_str=encode(str);
        //System.out.print("\nInput String = "+str);
        //System.out.print("\nEncoded String = "+encoded_str);

        //obj.writeFile(output_file,encoded_str);

        long input_file_size = obj.calcFileSize(input_file);
        long output_file_size = obj.calcFileSize(output_file);

        obj.cal_compression(input_file_size,output_file_size);
        file_obj.file_chosen();

    }

    JButton encode_btn, decode_btn;

    RLE()
    {

        encode_btn=new JButton("Encode");
        encode_btn.setBackground(Color.BLACK);
        encode_btn.setForeground(Color.WHITE);
        encode_btn.setFont(new Font("Tahoma",Font.PLAIN,20));
        encode_btn.setBounds(150,50,200,50);
        encode_btn.addActionListener(this);
        add(encode_btn);

        decode_btn=new JButton("Decode");
        decode_btn.setBackground(Color.BLACK);
        decode_btn.setForeground(Color.WHITE);
        decode_btn.setFont(new Font("Tahoma",Font.PLAIN,20));
        decode_btn.setBounds(150,150,200,50);
        decode_btn.addActionListener(this);
        add(decode_btn);

        setLayout(null);
        setBounds(500,100,500,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Encode"))
        {
            Helper obj=new Helper();
            String path = obj.choose_file();
            //System.out.println(path);
            String str = null;
            try {
                str = obj.readFileAsString(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String encoded_str=encode(str);
            System.out.print("\nInput String = "+str);
            System.out.print("\nEncoded String = "+encoded_str);
        }
        else if(ae.getActionCommand().equals("Decode"))
        {

        }
    }
}
