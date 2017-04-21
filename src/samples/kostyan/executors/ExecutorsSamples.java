package samples.kostyan.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 4/5/17.
 */
public class ExecutorsSamples
{
    public static void test1()
    {
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++)
        {
            executorService.execute(ExecutorsSamples::action);
        }
    }

    private static void action()
    {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
