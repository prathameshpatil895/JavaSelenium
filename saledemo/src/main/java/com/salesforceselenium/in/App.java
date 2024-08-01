package com.salesforceselenium.in;


/**
 * Hello world!
 *
 */
public class App 
{

    

    public int add(int a, int b){
        int c = a+b;
        return c;
    }

    public int sub(int a, int b){
        int c = a-b;
        return c;
    }


    public int calc(String opt, int a, int b){
        String operation =opt;
        int c=0;
        switch (operation) {
            case "add":
                c= a+b;
                break;
            case "sub":
                c= a-b;
                break;
            case "mul":
                c=a*b;
                break;
            default:    
                System.out.println("No valid input. The value of c is "+c);
                break;
        }
        return c;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App a1 = new App();
        int d = a1.add(4,8);
        System.out.println(d);
    }
}
