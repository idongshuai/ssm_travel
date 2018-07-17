package ds.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 董帅
 */
public class DateUtils {
    /**
    * 把日期转换成字符串
    * @param date
    * @return
    */
    public static String dateToStr(Date date,String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
    }

}
