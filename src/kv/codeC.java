package kv;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName codeC
 * @description:
 * TinyURL是一种URL简化服务， 比如：当你输入一个URLhttps://leetcode.com/problems/design-tinyurl时，它将返回一个简化的URLhttp://tinyurl.com/4e9iAk.
 *
 * 要求：设计一个 TinyURL 的加密encode和解密decode的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/encode-and-decode-tinyurl
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: mzy
 * @create: 2021-11-29 22:53
 * @Version 1.0
 **/
public class codeC {

    Map<Integer, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/"+ longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/","")));
    }
}
