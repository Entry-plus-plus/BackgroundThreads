package MT;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BackgroundThreads {
    public static void main(String[] args) throws InterruptedException {
        Runnable DB = new Runnable(){
            public void run(){
                int i = 0;
                try{
                    FileWriter goodbye = new FileWriter("background1.txt");
                    for (i = 0; i < 10; i++){
                        goodbye.write("Goodbye World\n");
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                    goodbye.write("Ran " + i + " times");
                    goodbye.close();
                } catch (IOException | InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        new Thread(DB).start();
        loop();
    }
    public static void loop() throws InterruptedException {
        int i = 0;
        for (i = 0; i < 10; i++){
            System.out.println("Hello World");
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println("Ran " + i + " times");
    }
}
