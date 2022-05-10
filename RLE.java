package DAA_CP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class RLE extends JFrame implements ActionListener
{
    JButton encodeBtn, decodeBtn;
    JLabel inputFileSizeLabel,outputFileSizeLabel,compressionRatioLabel;
    Helper helper;
    RLE()
    {
        // Helper Object
        helper = new Helper();

        // UI
        encodeBtn=new JButton("Encode");
        encodeBtn.setBackground(Color.BLACK);
        encodeBtn.setForeground(Color.WHITE);
        encodeBtn.setFont(new Font("Tahoma",Font.PLAIN,20));
        encodeBtn.setBounds(100,350,100,50);
        encodeBtn.addActionListener(this);
        add(encodeBtn);

        decodeBtn = new JButton("Decode");
        decodeBtn.setBackground(Color.BLACK);
        decodeBtn.setForeground(Color.WHITE);
        decodeBtn.setFont(new Font("Tahoma",Font.PLAIN,20));
        decodeBtn.setBounds(300,350,100,50);
        decodeBtn.addActionListener(this);
        add(decodeBtn);

        inputFileSizeLabel = new JLabel();
        inputFileSizeLabel.setFont(new Font("Tahoma",Font.PLAIN,20));
        inputFileSizeLabel.setBounds(100,150,100,50);
        add(inputFileSizeLabel);

        outputFileSizeLabel = new JLabel();
        outputFileSizeLabel.setFont(new Font("Tahoma",Font.PLAIN,20));
        outputFileSizeLabel.setBounds(300,150,100,50);
        add(outputFileSizeLabel);

        compressionRatioLabel = new JLabel();
        compressionRatioLabel.setFont(new Font("Tahoma",Font.PLAIN,20));
        compressionRatioLabel.setBounds(200,250,100,50);
        add(compressionRatioLabel);

        setLayout(null);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Encode"))
        {
            String inputPath = helper.chooseFile(true);
            //System.out.println(path);
            String str = null;
            try {
                str = helper.readFileAsString(inputPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String encoded_str=encode(str);
            System.out.print("\nInput String = "+str);
            System.out.print("\nEncoded String = "+encoded_str);

            String outputPath = helper.chooseFile(false);
            try {
                helper.writeFile(outputPath,encoded_str);
                System.out.println("File Saved Successfully");
                long inputFileSize = helper.calcFileSize(inputPath);
                long outputFileSize = helper.calcFileSize(outputPath);
                float compressionRatio = helper.calculateCompression(inputFileSize,outputFileSize);
                System.out.println("Input File - "+inputFileSize);
                System.out.println("Output File - "+outputFileSize);

                inputFileSizeLabel.setText(Long.toString(inputFileSize));
                outputFileSizeLabel.setText(Long.toString(outputFileSize));
                compressionRatioLabel.setText(Float.toString(compressionRatio));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand().equals("Decode"))
        {
            String inputPath = helper.chooseFile(true);
            //System.out.println(path);
            String str = null;
            try {
                str = helper.readFileAsString(inputPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String encoded_str = decode(str);
            System.out.print("\nInput String = "+str);
            System.out.print("\nDecoded String = "+encoded_str);

            String outputPath = helper.chooseFile(false);
            try {
                helper.writeFile(outputPath,encoded_str);
                System.out.println("File Saved Successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
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
        StringBuilder dest = new StringBuilder();

        for (int i = 1; i < str.length(); i = i + 2) {
            char charAt = str.charAt(i);
            int cnt = str.charAt(i - 1) - '0';
            for (int j = 0; j < cnt; j++) {
                dest.append(charAt);
            }
        }
        return (dest.toString());
    }

//    public static void main(String[] args) throws Exception
//    {
//        new Dashboard().setVisible(true);
//
//        Helper obj=new Helper();
//        //String str = "AAABBBBBBBB  CCCCDDDDD";
//        //String input_file=file_obj.chooseFile();
//        String input_file="D:\\STUDY\\JAVA QUESTIONS\\src\\DAA_CP\\Input.txt";
//        String output_file="D:\\STUDY\\JAVA QUESTIONS\\src\\DAA_CP\\RLE_Output.txt";
//
//        //String str = obj.readFileAsString(input_file);
//        //String encoded_str=encode(str);
//        //System.out.print("\nInput String = "+str);
//        //System.out.print("\nEncoded String = "+encoded_str);
//
//        //obj.writeFile(output_file,encoded_str);
//
//        long input_file_size = obj.calcFileSize(input_file);
//        long output_file_size = obj.calcFileSize(output_file);
//
//        obj.cal_compression(input_file_size,output_file_size);
//    }
}
