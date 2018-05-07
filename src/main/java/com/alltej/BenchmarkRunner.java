package com.alltej;

import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

/**
 * @author Allan Tejano
 * 5/4/2018
 */
public class BenchmarkRunner {

    public static void main( String[] args ) throws RunnerException, IOException {
//        Options opt = new OptionsBuilder()
//                .include(Benchmark.class.getSimpleName())
//                .forks(1)
//                .build();
//        new Runner(opt).run();

        org.openjdk.jmh.Main.main(args);
    }


}
