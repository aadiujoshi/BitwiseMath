public class BitwiseMath
{
    public static void main(String args[]){
        System.out.println("answer   " + add(111111, 1111));
    }

    public static int add(int a, int b){
        int carry = 0;
        int f = 0;
        for(int mask = 1; mask <= ((a > b) ? a : b); mask <<= 1){
            int a1 = (int)((mask & a));
            int a2 = (int)((mask & b));

            //reduce to 1 and 0
            while(a1 > 1) a1 >>= 1;
            while(a2 > 1) a2 >>= 1;
            
            //add binary no carry
            int n = (int)((a1 | a2) << (a1 & a2));

            //carry
            n = (int)((carry << (~(a1 & a2)) & 1) | n);

            //match place value
            while(n < (mask << (a1 & a2)) && n != 0){ n <<= 1; }

            //merge with final
            f |= n; 

            //calculate next carry
            carry = (int)(a1 & a2);
        }

        return f;
    }
}
