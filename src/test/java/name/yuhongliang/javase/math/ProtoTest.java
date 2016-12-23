package name.yuhongliang.javase.math;

/**
 * Created by andy on 16-9-27.
 */
public class ProtoTest {
    public static void main(String[] args) {
        Proto proto = new Proto();
        try {
            Proto cloneObject = (Proto) proto.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
