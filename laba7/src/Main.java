import java.io.File;
import java.util.Scanner;
import java.util.concurrent.*;
import static java.lang.Thread.sleep;

public class Main
{
    public static void main(String[] args) throws InterruptedException {
       entarance entarance = new entarance();
       exit exit = new exit();
       newthread newthread = new newthread();

       File dir = new File("file.txt");
       dir.delete();

       Thread enttread = new Thread(entarance);
       Thread exttread = new Thread(exit);
       Thread thirdthread = new Thread(newthread);
       System.out.println("Да начнется работа с потоками");
       enttread.start();
       exttread.start();
       thirdthread.start();

       System.out.println("Введите количество столов в ресторане");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Semaphore sem = new Semaphore(num*2);
        new Thread(new restaraunt( sem, "Посетитель №1")).start();
        new Thread(new restaraunt( sem, "Посетитель №2")).start();
        new Thread(new  restaraunt( sem, "Посетитель №3")).start();
        new Thread(new  restaraunt( sem, "Посетитель №4")).start();

    }
}