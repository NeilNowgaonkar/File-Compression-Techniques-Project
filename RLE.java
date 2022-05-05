package DAA_CP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class RLE
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

    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void writeFile(String fileName, String str) throws IOException
    {
        Path path = Paths.get(fileName);
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

    }

    public static long printFileSizeNIO(String fileName) {

        Path path = Paths.get(fileName);
        long bytes=0;
        try {

            // size of a file (in bytes)
            bytes = Files.size(path);
            System.out.println(String.format("\n%,d bytes", bytes));
            System.out.println(String.format("%,d kilobytes", bytes / 1024));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    public static void main(String[] args) throws Exception {
        //String str = "AAABBBBBBBB  CCCCDDDDD";
        //        String str = "AAAABBBBBBBBBBBBBBBBBBB  CCCCDDDDDDDDDDD";
        String input_file="D:\\STUDY\\JAVA QUESTIONS\\src\\DAA_CP\\Input.txt";
        String output_file="D:\\STUDY\\JAVA QUESTIONS\\src\\DAA_CP\\RLE_Output.txt";

        String str = readFileAsString(input_file);
        String enocded_str=encode(str);
        System.out.print("\nInput String = "+str);
        System.out.print("\nEncoded String = "+enocded_str);
        writeFile(output_file,enocded_str);
        long input_file_size = printFileSizeNIO(input_file);
        long output_file_size = printFileSizeNIO(output_file);


        float compression_percentage = (1 - (output_file_size/(float)input_file_size))*100;

        System.out.println("\nCompression Percentage = "+compression_percentage+" % ");

        System.out.println("\n\n");
    }
}
