package num;

import java.util.ArrayList;

/**
 * @ClassName findWords
 * @description:
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 *
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-10-31 21:38
 * @Version 1.0
 **/
public class findWords {



    // 麻烦的做法
    public String[] findWords1(String[] words) {

        ArrayList<String> keywordsList= new ArrayList<>();
        keywordsList.add("qwertyuiop");
        keywordsList.add("asdfghjkl");
        keywordsList.add("zxcvbnm");
        ArrayList<String> res = new ArrayList<>();

        for (String word : words) {
            boolean flag = true;
            int firstNum = 0, otherNum = 0;
            for (int i = 0; i < word.length(); i++) {
                String c = word.substring(i, i + 1).toLowerCase();
                for (int j = 0; j < keywordsList.size(); j++) {
                     if (keywordsList.get(j).contains(c) && i == 0) {
                         firstNum = j + 1;
                         otherNum = j + 1;
                     }else if (keywordsList.get(j).contains(c) && i!= 0){
                         otherNum = j + 1;
                     }
                }
                if (firstNum != otherNum) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    // 简介的做法
    public String[] findWords2(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean isValid = true;
            int idx = rowIdx.charAt(Character.toLowerCase(word.charAt(0)) -'a');
            for (int i = 1; i < word.length(); i++) {
                if (rowIdx.charAt(Character.toLowerCase(word.charAt(i)) -'a') != idx) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
}
