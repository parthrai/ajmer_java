

/** Assignment 1 Question 3
 *  COMP 1006/1406 - Fall 2021
 *
 *  Creating a simple console view for some data
 */
public class A1Q3{
    // used to add extra information to plot output of horizontal plot
    public static boolean debug = false;

    public static double efficiency = 0.0;

    public static double ave(double[] data, int index, int width){
        // Helper function that computes the average of
        // 'width' consecutive values in 'data' starting at index 'i'
        // That is, it returns
        //   (data[i] + data[i+1] + ... + data[i+width-1])/width
        // Use as you see fit.

        // Try to catch some bad input cases and crash your
        // program if input was bad.
        // You are NOT required to do this in your methods yet!
        String bad = "Bad input to ave(): ";
        if( data == null ){
            throw new RuntimeException(bad + "data must not be null");
        }else if(index < 0 || index >= data.length){
            throw new RuntimeException(bad + "index i out of range");
        }else if(width == 0 || width >= data.length){
            throw new RuntimeException(bad + "width is invalid");
        }


        // first compute the sum of the width numbers
        double sum = 0.0;
        for(int j=index; j<index+width; j+=1){
            sum += data[j];
        }

        // pre-multiply by 1.0 to ensure we don't have integer division by mistake
        return (1.0*sum)/width;
    }


    public static int[] averageAndScale(double[] data){
        // purpose: creates 20 bins for a bar plot by averaging values together
        //          and then scales the averages so that the max is 20.
        // input: array of floating point numbers
        // output: an array of size 20
        //         all elements are integers between 0 and 20 (inclusive)
        //         all values are scalled averages from the input data


        int size = 20;
        double[] bins = new double[20];

        int width = 0;

        if(data.length % size == 0 ){
          width = data.length;
        }else{
          width = data.length + 1;
        }

        int first = data.length;

        for(int i = 0; i <= first; i++){
          bins[i] = ave(data, i*width, width);
        }

        if(first*width < data.length){
          bins[first] = ave(data, first*width, data.length - first*width);
        }

        biggest = bins[0];

        for(int i=0; i< size; i++){
          if(biggest < bins[i]){
            biggest = bins[i];
          }
        }

        int scale = 20/biggest;




        int[] out = new int[20];  // this will be the output array

        for(int i = 0; i<size; i++){
          out[i] = bins[i]*scale;
        }

        // add your code here to fill in the 'out' array

        return out;
    }
     public static String plotHorizontal(int[] data){
        // this method is provided as example working Java code

        // The StringBuilder class provides a mutable sequence of charcaters.
        // You should use this instead of the String class when you want to
        // build up a string (for example, repeatedly using += on an existing
        // String). Use a StringBuilder for more efficient appending/insterting
        // of characters or strings when building up the sequence and then
        // convert it to a String when done.
        StringBuilder plot = new StringBuilder();

        String hash    = "#";
        String space   = " ";
        String top     = "--+--------------------+\n";
        String newline = "\n";
        String pipe    = "|";

        plot.append(top);
        for(int i=0; i<data.length; i+=1){
            plot.append( String.format("%02d", i+1) + pipe);
            for(int j=0; j<data[i]; j+=1){plot.append(hash);}
            for(int j=data[i]; j<20; j+=1){plot.append(space);}
            plot.append(pipe + (debug?data[i]:"") + newline);
        }
        plot.append(top);

        return plot.toString();
    }

    public static String plotVertical(int[] data){
        // used to build up answer
        StringBuilder plot = new StringBuilder();

        String top = "+--------------------+\n";
        String bottom = "+--------------------+";

        plot.append(top);
        for(int i = 1; i <= 20; i++){
            String str =  "|";

            for(int j = 0; j < 20; j++){
              int temp = 20 - data[j];

              if(i <= temp){
                str = str + " ";
              }else{
                str = str + "#";
              }
            }

            str = str + "|"+ "\n";

          plot.append(str);
        }
        // remove the following line!

        plot.append(bottom);

        plot.append("\n|00000000011111111112|\n");

        plot.append("|12345678901234567890|\n");




        // convert the built up solution into a string and return
        return plot.toString();
    }




    // You are NOT asked to write a program so this following main
    // method is not needed. However, you CAN write code here to help
    // test your methods. Just be sure that whatever you add here does not
    //
    public static void main(String[] args){

      int[] payload = new int[]{4, 11, 20, 20, 17, 5, 19, 6, 18, 1, 1, 10, 13, 1, 0, 6, 11, 0, 3, 1};

      //System.out.println(plotHorizontal(payload));
      System.out.println(plotVertical(payload));


      String res = plotVertical(payload);
      System.out.println(res.length());



    }
}
