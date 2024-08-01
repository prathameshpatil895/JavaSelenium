package com.salesforceselenium.in;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testadd(){
        App a1 =  new App();        
        assertEquals( a1.add(4, 8), 12);
        assertEquals( a1.add(0, 8), 8);
        assertEquals( a1.add(-2, 8), 6);
        assertEquals( a1.add(100, 5), 105);
    }

    @Test
    public void testsub(){
        App a1 =  new App();        
        assertEquals( 2, a1.sub(10, 8));
    }


    @Test
    public void testcalc(){
        App a1 =  new App();        
        assertEquals( 6, a1.calc("add", 2   , 4));
        assertEquals( 2, a1.calc("sub", 6   , 4));
        assertEquals( 6, a1.calc("mul", 2   , 3));
        assertEquals( 0, a1.calc("div", 8   , 8));
    }

    @Test
    public void chat(){
        String abcd = "Ja,Ja,,Cool,Mijn,Zoom";
        String[] soln = abcd.split(";");
        System.out.println(soln);
        for (int i=0;i<soln.length;i++){
            System.out.println(i);
            String listitem = soln[i];
            String[] item = listitem.split(",");
            System.out.println(item[0]);
            System.out.println(item[1]);
            System.out.println(item[2]);
            System.out.println(item[3]);
            System.out.println(item[4]);
            System.out.println(item[5]);
        }
    }


}
