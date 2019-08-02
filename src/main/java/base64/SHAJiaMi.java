package base64;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * SHA1 加密
 */
public class SHAJiaMi {

    /**
     * 生成签证
     * @param map
     * @return
     */
    public static String generateSign(Map<String, Object> map) {
        TreeMap<String,Object> treeMap = new TreeMap<>(map);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object val = entry.getValue();
            builder.append(key).append("=").append(val).append("&");
        }
        // 删除最后一个&
        builder.delete(builder.length()-1, builder.length());
        String base64 = new String(Base64.encodeBase64(builder.toString().getBytes()));
        String sign = DigestUtils.sha1Hex(base64);
        return sign;
    }

    /**
     * 用传过来的 param 按照generateSign 加密方式加密
     * 用新的 sign 和传过来的 sign 比较
     * @param text
     * @return
     */
    public static boolean checkSign(String text) {
        Map map = (Map)JSON.parse(text);
        String sign = generateSign(map);
        return true;
    }

    public static void main(String[] args) {
        Map<String,String> param = new HashMap<>();
        param.put("param1", "param1");
        param.put("param2", "param2");

        long timestamp = System.currentTimeMillis()/1000;
        String appKey = "ad33d1190ff8383b5650097c0b6403868a82bd4c";
        String appSecret = "819901799da9605cb132ca300623b413";

        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("api", "com.souche.shield.service#getUserById");
        reqMap.put("timestamp", timestamp);
        reqMap.put("appKey", appKey);
        reqMap.put("data", JSON.toJSONString(param));
        //SHA1和base64生成签证
        String sign = generateSign(reqMap);
        reqMap.put("sign", sign);
        String reqJson = JSON.toJSONString(reqMap);
        System.out.println(reqJson);
    }

}
