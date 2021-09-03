package other;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 【考试第二题-题目】
 *  数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *  输入描述:
 *  先输入键值对的个数, 然后输入成对的index和value值，以空格隔开
 *  输出描述:
 *  输出合并后的键值对（多行）
 *
 * 【解题思路】
 *  该题需要对相同索引的数值进行合并，并且需要按索引排序，因此可以使用TreeMap来存储输入的索引数值对
 *  索引对应map中的key，数值对应map中的value;TreeMap在每次插入新键值对会根据键排序，默认是按键升序排序，刚好符合要求
 *
 * @author yong
 * @date 2021/9/3 14:17
 */
public class mergeKeyInMap {

    public static void main(String[] args) {

        // 用于控制台读取
        Scanner in = new Scanner(System.in);
        // 存储索引数值
        SortedMap<String, Integer> map = new TreeMap<>();
        // 1、先读取有多少个键值对
        int n = in.nextInt();
        // 2、循环读取键值对，并进行键值对合并操作
        for (int i = 0; i < n; i++) {
            String key = in.next();
            int value = in.nextInt();
            // 3、键值对合并操作
            mergeKey(key, value, map);
        }
        // 4、按要求输出键值对
        outputMap(map);
    }


    /**
     * 将索引数值存储于map中，并对相同索引的进行数值合并操作
     * @param key 索引
     * @param value 数值
     * @param map 存储索引数值的map
     * @author yong
     * @date 2021/9/3 15:26
     * @return void
     */
    private static void mergeKey(String key, int value, SortedMap<String, Integer> map) {
        // 若已经有相同的key，说明需要进行同索引数值合并操作
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + value);
        }else {
            map.put(key, value);
        }
    }

    /**
     * 按题目要求将map的键值对分行输出到控制台
     * @param map 需要进行输出的map
     * @author yong
     * @date 2021/9/3 15:25
     * @return void
     */
    private static void outputMap(Map<String, Integer> map) {
        System.out.println("合并后的键值对：");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() );
        }
    }
}
