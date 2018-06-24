package eurekaclient1.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by mrjyn on 2018/4/7.
 */
public class MyCyclicBarrierDemo2 {
    public static void main(String[] args) throws InterruptedException {
        int n = 4;
        CyclicBarrier barrier = new CyclicBarrier(n, new Runnable() {
            @Override
            public void run() {
                System.out.println("调用await()方法后就进入barrier状态。所有线程达到barrier状态后执行此操作了。。。"+Thread.currentThread().getName());
            }
        });
        for (int i=0;i<n;i++){
            new MyWriter(barrier).start();
            Thread.sleep(2000);
        }
    }
    private static class MyWriter extends Thread{
        private CyclicBarrier barrier;
        public MyWriter(CyclicBarrier barrier){
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据");
                Thread.sleep(2000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入完毕，等待其他线程写入");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕");
        }
    }

}
