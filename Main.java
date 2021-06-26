import java.util.Scanner;

public class Main implements Runnable {
    public static int amount = 0;

    private volatile boolean runner = true;
  
    public static void main(String[] args) {
      Main m = new Main();
      Thread t = new Thread(m);
      t.start();
      System.out.println("Press enter to pause!");
      Scanner sc = new Scanner(System.in);
      sc.nextLine();
      m.kill();


    }
    public void run() {
        while(runner){
            System.out.println("Futok");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
      
    }

    public void kill(){
        this.runner = false;
        System.out.println("Stop!");
    }
  }