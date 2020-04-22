package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// @SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {

//        SpringApplication.run(DemoApplication.class, args);
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        int count = 200000;
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(count));
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(list.size());
    }

}
