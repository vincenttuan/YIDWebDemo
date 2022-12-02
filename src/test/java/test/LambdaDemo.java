package test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class LambdaDemo {
    public static void main(String[] args) {
        int[] scores = {100, 40, 87, 60};
        // 請將 scores 依序印出 (傳統 Java)
        for(int score : scores) {
            System.out.println(score);
        }
        
        // Modern Java（Java 8 （含）以後支援）
        Arrays.stream(scores).forEach(score -> System.out.println(score));
        Arrays.stream(scores).forEach(System.out::println);
        
        // 計算總分/平均 = ?
        /*
        int sum = 0;
        int count = 0;
        for(int score : scores) {
            if(score >= 60) {
                sum += score;
                count++;
            }
        }
        double avg = (double)sum / count;
        System.out.println(avg);
        */
        
        double avg = Arrays.stream(scores)
                           .filter(score -> score >= 60)
                           .average()
                           .getAsDouble();
        System.out.println(avg);
        
        IntSummaryStatistics stat = Arrays.stream(scores).summaryStatistics();
        System.out.println(stat.getAverage());
        System.out.println(stat.getSum());
        System.out.println(stat.getMax());
        System.out.println(stat.getMin());
        System.out.println(stat);
    }
}
