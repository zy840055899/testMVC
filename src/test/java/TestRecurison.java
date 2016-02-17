/**
 * Created by zhengying on 16/1/21.
 */
public class TestRecurison {
    public static void main(String[] args) {
        System.out.println(getSum(100));
    }

    public static int getSum(int a) {
        if (a == 1) {
            return a;
        }
        return a + getSum(a - 1);
    }
}
