package DAA_CP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper
{
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

    public static long calcFileSize(String fileName)
    {

        Path path = Paths.get(fileName);
        long bytes=0;
        try {

            // size of a file (in bytes)
            bytes = Files.size(path);
            //System.out.printf("\n%,d bytes%n", bytes);
            //System.out.printf("%,d kilobytes%n", bytes / 1024);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return bytes;
    }

    public static void cal_compression(long input_file_size,long output_file_size)
    {
        float compression_percentage = (1 - (output_file_size/(float)input_file_size))*100;
        System.out.println("\nCompression Percentage = "+compression_percentage+" % ");

    }



}
