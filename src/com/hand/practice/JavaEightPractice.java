package com.hand.practice;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhongLingYun
 * @Title: JavaEightPractice
 * @Description: TODO
 * @date 2018/11/209:24
 */
public class JavaEightPractice {
    public static void main(String[] args) {
        // 交易员
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "BeiJin");
        // 交易
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        // 找出2011年发生的所有交易，并按交易额排序（从低到高）
        /*transactions.stream().filter(transaction -> transaction.getYear()==2011).
                // 排序使用comparing比较
                sorted(comparing(Transaction::getValue)).distinct().forEach(System.out::println);*/
        // 交易员都在哪些不同的城市工作过？
        /*transactions.stream().
                // map进行收集作用
                map(transaction -> transaction
                        .getTrader().getCity())
                .distinct().forEach(System.out::println);*/

        // 查找所有来自于剑桥的交易员，并按姓名排序
       /* transactions.stream().filter(transaction -> transaction.getTrader()getCity().equals("Cambridge"))
                .map(transaction -> transaction.getTrader())
                .distinct().sorted(comparing(trader -> trader.getName()))
                .forEach(System.out::println);*/

       // 返回所有交易员的姓名字符串，按字母顺序排序
      /*  transactions.stream().
                map(transaction -> transaction.getTrader().getName())
                .distinct().sorted().forEach(System.out::println);*/

      // 有没有交易员是在米兰工作的？
        /*System.out.println(transactions.stream()
                // nayMatch判断流里面是否存在某个值
                .anyMatch(transaction -> transaction.getTrader()
                        .getCity().equals("Mi")));*/

        // 打印生活在剑桥的交易员的所有交易额
       /* Long x=transactions.stream().
                filter(transaction -> transaction.getTrader()
                        .equals("Cambridge")).map(transaction -> transaction.getValue()).count();*/

       //  把米兰工作的员工城市设置为 hangzhou
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Milan")).forEach(transaction -> transaction.getTrader().setCity("hangzhou"));
        transactions.stream().forEach(System.out::println);
    }
}
