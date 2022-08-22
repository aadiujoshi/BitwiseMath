public class BitwiseMath
{
    public static void main(String args[]){
        System.out.println(add(1, 1));
    }

    public static int add(int a, int b){
        // System.out.println(Integer.toBinaryString(a) + "  " + Integer.toBinaryString(b));

        byte carry = 0;
        int f = 0;
        for(int mask = 1; mask <= ((a > b) ? a : b); mask <<= 1){
            byte a1 = (byte)((mask & a));
            byte a2 = (byte)((mask & b));

            // System.out.println(Integer.toBinaryString(a1) + "   " + Integer.toBinaryString(a2));

            while(a1 > 0b1) a1 >>= 1;
            while(a2 > 0b1) a2 >>= 1;
            
            // System.out.println(Integer.toBinaryString(a1) + "   " + Integer.toBinaryString(a2));

            // System.out.println(a1 + "  " + a2);

            //add binary no carry
            byte n = (byte)((a1 | a2) << (a1 & a2));

            // System.out.println(n);

            //carry
            n = (byte)((carry << ~(a1 & a2)) | n);

            // System.out.println(n);

            //calculate carry
            carry = (byte)(a1 & a2);

            //add to final
            System.out.println(n | mask);

            f = (f | (n | (mask)));
        }

        return f;
    }
}