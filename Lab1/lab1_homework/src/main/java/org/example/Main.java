package org.example;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if (args.length < 3) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }
        int a = Integer.parseInt(args[0]) ;
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        StringBuilder sb = new StringBuilder();
        for( int i=a ; i<=b ;i++){
            int temp = i;
            while(temp > 9)
            {
                int j =0;
                while(temp > 0)
                {
                    j = j + (temp % 10) * (temp % 10);
                    temp = temp/10;
                }
                temp = j;
            }
            if(temp == k)
            {
                sb.append(i);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString().trim());
        long endTime = System.nanoTime();
        long execTime = (endTime - startTime)  ;
        System.out.println("Running time of application is " + execTime + " nano seconds");
    }
}