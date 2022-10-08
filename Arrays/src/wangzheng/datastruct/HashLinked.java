package wangzheng.datastruct;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashLinked {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        method2();
    }

    public static void method1(){
        HashMap<Integer, Integer> m = new LinkedHashMap<>();
        m.put(300, 11);
        m.put(100, 12);
        m.put(500, 23);
        m.put(200, 22);
//        /m.put(300, 62);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }

    public static void method2(){

        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(300, 11);
        m.put(100, 12);
        m.put(500, 23);
        m.put(200, 22);

        m.put(300, 26);
        m.get(500);

        for (Map.Entry e : m.entrySet()) {
            System.out.println(e.getKey());
        }
    }
}
