package cn.edu.ctgu;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author NiuQun
 * @date 2021/11/20
 */
public class JedisTest {
    @Test
    public void testJedis() {
        // 1.明确是哪一款数据库并加载驱动：已经明确是redis，就不需要再加载驱动了
        // 2.创建数据库之间的连接：连接redis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 3.操作数据库：操作redis,jedis中对应的方法名与redis完全相同
        // jedis.set("name", "itheima");
        System.out.println(jedis.get("name"));
        jedis.lpush("list1", "a", "b", "1", "2");


        // 4.关闭连接：关闭与redis之间的连接
        jedis.close();
    }

}
