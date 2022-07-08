//package com.company;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Rn2020023 extends RecursiveTask<Integer> {
    volatile int n,k;
    int thread;
    int ans;
    static int threshold = 32;

    Rn2020023(int n,int k,int thread,int ans){
        this.n = n;
        this.k = k;
        this.thread = thread;
        this.ans = ans;
    }

    private int PasTri(int n,int k){
        if(n==0 || k==0 || n==k){
            return 1;
        }
        int l = PasTri(n-1,k-1);
        int r = PasTri(n-1,k);
        return l+r;
    }

    @Override
    public synchronized Integer compute(){

        if(n<threshold) return PasTri(n,k);

        if(n==0 || k==0 || n==k){
            return 1;
        }
        R2020023 l = new R2020023(this.n-1,this.k-1,thread,ans);
        R2020023 r = new R2020023(this.n-1,k,thread,ans);
        l.fork();
        r.compute();
        l.join();
        return l.ans+r.ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int threads = sc.nextInt();
        if(args.length > 0) { //Check if the user wants to specify a row count other than 10
            try {
                threads = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
        ForkJoinPool pool = new ForkJoinPool(threads);
        R2020023 task = new R2020023(30,10,threads,1);
        pool.invoke(task);
        int res = task.ans;
        System.out.println(res);
    }
}
