package threadPrograms;

import java.lang.*;

public class SleepDemo implements Runnable
{
    Thread t;
    public void run()
    {
        for (int i = 0; i < 4; i++)
        {
            System.out.println(Thread.currentThread().getName()
                                                   + "  " + i);
            try
            {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            }
 
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
 
    public static void main(String[] args) throws Exception
    {
    	SleepDemo sd = new SleepDemo();
        Thread t = new Thread(sd);
        t.start();
        
        Thread t2 = new Thread(sd);
        t2.start();
        
        /*Thread t = new Thread(new SleepDemo());
        //t.setName("Test-11");
        t.start();
        t.setName("Test-1");
        
        Thread t2 = new Thread(new SleepDemo());
        t2.start();*/
        
        /*Thread t = new Thread(new SleepDemo());
        t.start();
        
        Thread t2 = new Thread(new SleepDemo());
        t2.start();*/
    }
}
