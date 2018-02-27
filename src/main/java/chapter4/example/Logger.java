package chapter4.example;

import java.util.function.Supplier;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/23
 * Time: 19:17
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class Logger {

    private boolean debug = true;

    public boolean isDebugEnabled(){
        return debug;
    }

    public void debug(String message){
        if (isDebugEnabled()){
            System.out.println(message);
        }
    }

    public void example(){
        // BEGIN debug_optimised
        Logger logger = new Logger();
        logger.debug("Look at this: " + expensiveOperation());
        // END debug_optimised
    }

    private String expensiveOperation(){
        return "";
    }

    // BEGIN debug_lambda
    public void debug(Supplier<String> message){
        if (isDebugEnabled()){
            debug(message.get());
        }
    }
    // END debug_lambda

    public void exampleWithLambda(){
        // BEGIN debug_optimised_lambda
        Logger logger = new Logger();
        logger.debug(() -> "Look at this: " + expensiveOperation());
        // END debug_optimised_lambda
    }
}
