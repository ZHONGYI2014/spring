package util;

import java.text.SimpleDateFormat;

public class TimeUtil {

    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        Long longDate = 1543968000000L;
        convertToFormatTime(longDate);
    }

    public static void convertToFormatTime(Long longDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        String currentTime = simpleDateFormat.format(longDate);
        System.out.println(currentTime);
    }

}
