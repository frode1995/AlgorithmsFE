package others;

import java.util.Scanner;

/**
 * @Author: frode
 * @Date:2018/8/5 9:10
 * @Description:   next()方法读取到空白符就结束；nextLine()读取到回车结束也就是“\r”.
 */
public class TestScanner {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println(sc1.nextLine());//花好 月圆
        System.out.println(sc1.next());//花好


    }


}
