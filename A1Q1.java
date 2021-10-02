
/** Assignment 1 Question 1
 *  COMP 1006/1406 - Fall 2021
 *
 *  Computing a rolling average of data
 */

import java.util.Arrays;
public class A1Q1{

    public static double[] rollingAverage(double[] data, int width){
        /*  All input arguments must satisfy. We will only use valid
            input arguments when testing your code.

	        data: 0 <= data.length <= Integer.MAX_VALUE
	              for each value in data : -101.0 <= value <= 101.0
	        width: 1 <= width <= Integer.MAX_VALUE
        */

        // this will be your output array
        double[] out = new double[data.length];

        // add your code here!

        // if (width > data.length) {
        //
        //     for(int i = 0; i < data.length; i++) {
        //         out[i] = Double.NaN;
        //     }
        //
        //     return out;
        // }


        for(int i = 0; i < data.length; i++) {
            int result = i - width;

            if((result + 1) < 0) {
                out[i] = Double.NaN;
                continue;
            }

            double sum = 0.00;

            for(int j = i; j > i-width; j--) {
                  sum = sum + data[j];

            }
            out[i] = sum/width;

        }

        return out;
    }

 /*   [1, 2, 4, 9] 3

    index - width = result
    if(result + 1)) < 0) {
        Nan
    }
    else {
        from result + 1
    }
*/

    // You are NOT asked to write a program so this following main
    // method is not needed. However, you CAN write code here to help
    // test your methods. Just be sure that whatever you add here does not
    //
    public static void main(String[] args){

        System.out.println(Arrays.toString(rollingAverage(new double[]{1,2,4}, 1)));
        System.out.println(Arrays.toString(rollingAverage(new double[]{1,2}, 2)));

        System.out.println(Arrays.toString(rollingAverage(new double[]{1,2,4,9}, 3)));

        System.out.println(Arrays.toString(rollingAverage(new double[]{1,2,4}, 4)));




    }
}
