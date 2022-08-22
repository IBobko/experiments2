import redis.clients.jedis.Jedis;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 1;
        BigDecimal a1 = new BigDecimal(a);
        BigDecimal a2 = new BigDecimal(b);

        BigDecimal n1 = a1.multiply(a2);

        byte[] f =  a1.multiply(a2).unscaledValue().toByteArray();

        int count = 0;
        for (byte i : f) {
            for (int j = 0; j < 8; j++) {
                int l = ((i>>j))&1;
                count = l + count;
            }
        }


        System.out.println(count);

    }
}
