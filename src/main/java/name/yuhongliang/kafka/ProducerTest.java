package name.yuhongliang.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerTest {

    private KafkaProducer producer = null;
    //    private BlockingQueue<KafkaProducerRecord> messageQueue;//消息队列
    static final int queueSize = 5000;//队列的 大小
    private Thread worker;
    private boolean running = true;

    public ProducerTest() {
        this.createProducer();

    }

    public  void send(String message) {
        ProducerRecord record = new ProducerRecord("at","key1",message);
        producer.send(record);
        System.out.println("send message " + message);
    }

    private void createProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "172.20.98.31:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "1");//0 do npt wait;1 only wait leader;-1/all means wait all nodes
        producer = new KafkaProducer<String, String>(properties);

    }

    public void close () {
        if (producer != null) {
            producer.close();
        }
    }

    public static void main(String[] args) {
        ProducerTest producerTest = new ProducerTest();
        producerTest.send("haha");
        producerTest.close();
        System.out.println("close");
    }

}
