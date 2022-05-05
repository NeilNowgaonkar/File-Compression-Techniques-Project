package DAA_CP;

public class RLE_Decoding
{

    public static void main(String[] args)
    {
        String src = "w149a3d1e1x6";
        StringBuilder dest = new StringBuilder();

        for (int i = 0; i < src.length() - 1; i = i + 2) {
            char charAt = src.charAt(i);
            int cnt = src.charAt(i + 1) - '0';
            for (int j = 0; j < cnt; j++) {
                dest.append(charAt);
            }
        }
        System.out.println(dest.toString());
    }
}
