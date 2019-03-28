package util;

import java.text.SimpleDateFormat;

public class TimeUtil {

    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String convertToFormatTime(Long longDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        return simpleDateFormat.format(longDate);
    }

    /**
     * 获取当前时间
     * @return 转换成字符串格式
     */
    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        return simpleDateFormat.format(System.currentTimeMillis());
    }


}
