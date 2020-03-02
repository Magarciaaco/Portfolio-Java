
import java.util.Random;

public class BigO {

    // Constant time: O(1)
    // No matter how big arr is, running time will never grow
    // beyond 1 instruction.
    public static int a_constant(int[] arr) {
        int size = arr.length;
        if(size > 0) {
            arr[0] = (arr[0] + 1) % 10;
        }
        return 1;
    }

    // Logarithmic time: O(logn)
    // When arr increases in size, it needs to double
    // in size before executing an additional loop.
    // (i = i+i has the same effect as i = i*2
    // when the initial value of i = 1)
    public static int b_logn(int[] arr) {
        int c = 0;
        for(int i = 1; i < arr.length + 1; i = i+i) {
            arr[i-1] = (arr[i-1] + 1) % 10;
            c++;
        }
        return c;
    }

    // Hyperlogarithmic time: O(logloglogn)
    // The holy grail.
    // To have one more loop, the size of the array
    // needs to be exponentiated by itself
    // (next_size = size ^ size)
    // NOTE: This method ignores the time it takes
    // to compute i^i ( which is O(nlogn) ).
    public static int c_comp3logn(int[] arr) {
        int c = 0;
        for(int i = 2; i < arr.length + 2; i = pow(i,i)) {
            arr[i-2] = (arr[i-2] + 1) % 10;
            c++;
        }
        return c;
    }

    // Polylogarithmic time: O((logn)^3)
    // In many ways it is similar to Logarithmic time
    // (they require the same increase in size to change
    // the total number of loops), but with worse 
    // total performance (the number of loops is not
    // increased by 1, but by a cubic proportion of
    // the previous number of loops).
    public static int d_logncubed(int[] arr) {
        int c = 0;
        for(int i = 1; i < arr.length+1; i = i * 2) {
            for(int j = 1; j < arr.length+1; j = j * 2) {
                for(int k = 1; k < arr.length+1; k = k * 2) {
                    int ind = (i+j+k-3) % arr.length;
                    arr[ind] = (arr[ind] + 1) % 10;
                    c++;
                }
            }
        }
        return c;
    }

    // N-logarithmic: O(nlogn)
    // The size of the array needs to increase by a little
    // more than 1 (log(arr.length + 1)) to change
    // the number of loops by 1.
    public static int e_nlogn(int[] arr) {
        int c = 0;
        for(int i = 0; i < arr.length; i = i + 1) {
            for(int j = 1; j < arr.length+1; j = j * 2) {
                int ind = (i+j-1) % arr.length;
                arr[ind] = (arr[ind] + 1) % 10;
                c++;
            }
        }
        return c;
    }

    // Linear: O(n)
    // The increase in size is proportional
    // to the increase in number of loops.
    // In this case, it's 1:1, but
    // it's possible to have loops that are
    // 1:2, or 2:1.
    // To do that, you need to change
    // i = i + 1, so instead of 1 it's something else.
    public static int f_n(int[] arr) {
        int c = 0;
        for(int i = 0; i < arr.length; i = i + 1) {
            arr[i % arr.length] = (arr[i % arr.length] + 1) % 10;
            c++;
        }
        return c;
    }

    // Polynomial: O(n^5)
    // When the size of the array increases by 1,
    // the number of loops increases by a
    // degree 5 polynomial.
    // For this method, I use a helper
    // that creates nested loops through recursion.
    public static int g_n_pow_5(int[] arr) {
        return helper_pow(arr, 5);
    }

    // Recursive helper method.
    // It creates x nested loops.
    public static int helper_pow(int[] arr, int x) {
        int counter = 0;
        if(x > 0) {
            for(int i = 0; i < arr.length; i = i + 1) {
                counter += helper_pow(arr, x - 1);
            }
        } else {
            counter = 1;
        }
        return counter;
    }

    // Exponential: O(4^n)
    // An increase of size 1, quadruples the number of loops.
    // I use a recursive helper method to quadruple
    // the number of calls depending on the length of arr.
    public static int h_4_pow_n(int[] arr) {
        return helper_h(arr, arr.length);
    }

    // Helper method for exponential.
    // depth is a measure of recursion depth.
    // The method runs 4^depth times.
    public static int helper_h(int[] arr, int depth) {
        int counter = 0;
        if(depth > 0) {
            for(int i = 0; i < 4; i++) {
                counter += helper_h(arr, depth - 1);
            }
        } else {
            return 1;
        }
        return counter;
    }

    // Factorial: O(n!)
    // When the size of the array increases by 1,
    // the number of loops increases by the previous
    // number of loops, times the new array size. 
    public static int i_n_factorial(int[] arr) {
        int counter = 0;
        if(arr.length == 0) {
            return 1;
        } else {
            int[] sub_arr = new int[arr.length-1];
            for(int i = 0; i < arr.length; i++) {
                counter += i_n_factorial(sub_arr);
            }
        }
        return counter;
    }

    // Hyperpolynomial: O(n^n)
    // Like polynomial + exp, but worse.
    // An increase of size by 1, increases
    // the number of loops by an exponential
    // order of magnitude.
    // It uses the same method for 
    // O(n^5), but the second parameter
    // is the length of the array. Yikes!
    public static int j_n_pow_n(int[] arr) {
        return helper_pow(arr, arr.length);
    }

    // Extra credit: Running time is not a function of n.
    // The simplest non-function possible:
    // Entirely random.
    // Other options include:
    //  - Based on the current time (similar to random)
    //  - Based on input (user or sensor)
    public static int extra(int[] arr) {
        Random rng = new Random();
        int random_number = rng.nextInt();
        int counter = 0;
        while(random_number != 0) {
            int i = random_number % arr.length;
            i = (i>=0 ? i : i + arr.length);
            arr[i] = arr[i]+1 % 10;
            random_number = rng.nextInt();
        }
        return counter;
    }

    public static void main(String[] args) {
        //
        for(int base = 1; base < 32; base *= 2) {
            int[] arr = new int[base];

            System.out.printf("Array size: %d%n", arr.length);
            System.out.println("----------------");
            // O(1)
            System.out.printf("O(1):            %d%n", a_constant(arr));
            // O(logn)
            System.out.printf("O(logn):         %d%n", b_logn(arr));
            // O(logloglogn)
            try{
                System.out.printf("O(logloglogn):   %d%n",
                    c_comp3logn(arr));
            } catch(Exception e) {
                System.out.printf("O(logloglogn):   ERROR%n");
            }
            // O((logn)^3)
            System.out.printf("O((logn)^3):     %d%n",
                d_logncubed(arr));
            // O(nlogn)
            System.out.printf("O(nlogn):        %d%n", e_nlogn(arr));
            // O(n)
            System.out.printf("O(n):            %d%n", f_n(arr));
            // O(n^5)
            System.out.printf("O(n^5):          %d%n", g_n_pow_5(arr));
            // O(4^n)
            System.out.printf("O(4^n):          %d%n", h_4_pow_n(arr));
            // O(n!)
            System.out.printf("O(n!):           %d%n",
                i_n_factorial(arr));
            // O(n^n)
            System.out.printf("O(n^n):          %d%n", j_n_pow_n(arr));
            // O(???)
            //System.out.printf("O(???):          %d%n", extra(arr));
            // NOTE: Don't run extra(), it might take waaaaaay too long!
            System.out.println("----------------");
            System.out.println("----------------");
        }

        
    }

    // Just in case you want to print the array, as a nice square.
    public static void printArray(int[] arr, int linesize) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
            if(i % linesize == linesize-1) {
                System.out.println();
            }
        }
    }


    // Helper method.
    // Computer power of integers in logn time!
    public static int pow(int x, int n) {
        int y = 1;

        while(n > 0) {
            if(n % 2 == 1) {
                y = x * y;
            }
            x *= x;
            n = n / 2;
        }

        return y;
    }
}