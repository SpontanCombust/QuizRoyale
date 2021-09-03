package cedro_celuch.quizroyale;

import javafx.concurrent.Task;

public class Sleeper {
    
    public Sleeper( long millis, Runnable task ) {
        
        Task<Void> sleeper = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                Thread.sleep(millis);
                return null;
            }
            
            @Override
            protected void succeeded() {
                task.run();
            }
        };

        new Thread( sleeper ).start();
    }
}
