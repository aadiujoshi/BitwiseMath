public class BitwiseMath
{
    public static void main(String args[]){
        // System.out.println("answer   " + add((int)(Math.pow(2, 16)), (int)(Math.pow(2, 10))));
        int a = 3;
        int b = 3;
        System.out.println("answer = " + add2(a, b));
        System.out.println("correct answer = " + (a + b));
        // System.out.println("answer = " + mult(a, b));
        // System.out.println("correct answer = " + (a * b));
    }

    public static int add2(int a, int b){
        int f = 0;
        int carry = 0;
        int mask;
        for(mask = 1; mask <= ((a > b) ? a : b); mask <<= 1){
            int a1 = (int)((mask & a));
            int a2 = (int)((mask & b));

            //reduce to 1 and 0
            while(a1 > 1) a1 >>= 1;
            while(a2 > 1) a2 >>= 1;

            //add binary with carry
            int x = ((a1 | a2) << (a1 & a2)) | (carry << (a1 & a2));
            int tempx = x;
            x &= 1;
//            System.out.println(x);
            while(x <= (mask >> 1) && x != 0) x <<= 1;
            System.out.println(x);

            f |= x;
//            System.out.println(Integer.toBinaryString(tempx));
            carry = tempx >> 1;
        }
        System.out.println("carry " + carry);
        //FIX THIS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        while(carry <= (mask >> 1) && carry != 0){
//            System.out.println(carry);
            carry <<= 1;
        }
        f |= carry;

        return f;
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

            System.out.println(a1 + "  " + a2 + "  " + n);

            //merge with final
            f |= n;

            //calculate next carry
            carry = (int)(a1 & a2);
        }

        return f;
    }

    public static int mult(int a, int b){

        int f = 0;
        for(int iter = 0; iter < b; iter = add(iter, 1)){
            f = add(f, a);
            System.out.println(f);
        }

        return f;
    }
}
