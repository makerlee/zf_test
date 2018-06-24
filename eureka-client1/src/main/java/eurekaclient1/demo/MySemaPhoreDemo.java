package eurekaclient1.demo;

import java.util.concurrent.Semaphore;

/**
 * Created by mrjyn on 2018/4/7.
 * 假若一个工厂有5台机器，但是有8个工人，
 * 一台机器同时只能被一个工人使用，只有使用完了，
 * 其他工人才能继续使用。那么我们就可以通过Semaphore来实现
 */
public class MySemaPhoreDemo {
    public static void main(String[] args) throws InterruptedException {
        int n = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i=0;i<n;i++){
            new Worker(i,semaphore).start();
        }
    }
    private static class Worker extends Thread{
        private Semaphore semaphore;
        int num;
        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一台机器生产");
                Thread.sleep(3000);
                System.out.println("工人"+this.num+"释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
