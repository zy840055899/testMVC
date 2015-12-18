import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by zhengying on 15/12/14.
 *
 * 该程序只演示了取值
 */
public class TestRedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);

        System.out.println(jedis.ping());

        // jedis string
        System.out.println(jedis.get("test"));

        // jedis list
        List list = jedis.lrange("nosqls", 0, 10);
        System.out.println(list);


        Set set = jedis.smembers("nosqls2");
        System.out.println(set);

    }

}





