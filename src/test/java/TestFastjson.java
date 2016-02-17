import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengying on 16/2/17.
 * FastJson(最快的json解析jar)
 */
public class TestFastjson {

    public static void main(String[] args) {

        Map map = new HashMap();

        map.put("asd", "lkj");

        String result = JSON.toJSONString(map);

        System.out.println(result);

        Map map2 = (Map) JSON.parse(result);
        System.out.println(map2);


        long now = System.currentTimeMillis();
        Date date = new Date(now);

        String time = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss");

        System.out.println(time);
    }

}
