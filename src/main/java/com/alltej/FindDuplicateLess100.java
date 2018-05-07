package com.alltej;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

/**
 * @author Allan Tejano
 * 5/4/2018
 *
 *
 * Get sum of N integers in array where N does not have duplicate.
 */

@BenchmarkMode( Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class FindDuplicateLess100 {

    @Warmup(iterations = 5)
    @Measurement(iterations = 6)
    @Benchmark
    @Fork(value = 4)
    public long loopWMapMergeAndStreamToSum() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,
                    51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,
                    101};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x = 0; x<arr.length; x++) {
            map.merge( arr[x], 1, ( o, n ) -> o + n );
        }

        int sum  = map.entrySet().stream().filter( e -> e.getValue() == 1 ).mapToInt( Map.Entry::getKey ).sum();
        return sum;
    }

    @Warmup(iterations = 5)
    @Measurement(iterations = 6)
    @Benchmark
    @Fork(value = 4)
    public long  loopWMapMergeAndLoopToSum() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,
                51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,
                101};


        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x = 0; x<arr.length; x++) {
            map.merge( arr[x], 1, ( o, n ) -> o + n );
        }
        int sum = 0;
        for ( Map.Entry<Integer, Integer> e : map.entrySet() ) {
            if (e.getValue() == 1) {
                sum += e.getKey();
            }
        }

        return sum;
    }

    @Warmup(iterations = 5)
    @Measurement(iterations = 6)
    @Benchmark
    @Fork(value = 4)
    public long getSumUsingStream() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,
                51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,
                101};

        List<Integer> list = Arrays.stream( arr ).boxed().collect( toList() );
        Map<Integer, Long> map = list.stream()
                .collect( Collectors.groupingBy( Integer::intValue, Collectors.counting() ) );
        Integer sum = map.entrySet().stream().filter( e -> e.getValue() == 1 ).collect( summingInt( Map.Entry::getKey) );

        return sum;
    }

}
