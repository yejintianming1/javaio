package nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferDemo {

    @Test
    public void test1() {
        Buffer buffer = ByteBuffer.allocate(10);
        System.out.println("Capacity:"+buffer.capacity());
        System.out.println("limit:"+buffer.limit());
        System.out.println("Position:"+buffer.position());
        System.out.println("Mark:"+buffer.mark());
        System.out.println("Remaining:"+ buffer.remaining());
        System.out.println("-----------------------------------");
        buffer.limit(6);
        System.out.println("limit:"+ buffer.limit());
        System.out.println("Position:"+buffer.position());
        System.out.println("mark:"+ buffer.mark());
        System.out.println("Remaining:"+buffer.remaining());
        System.out.println("-----------------------------------");
        buffer.position(2);
        System.out.println("Position:"+buffer.position());
        System.out.println("Remaining:"+buffer.remaining());
        System.out.println("-----------------------------------");
        System.out.println(buffer);
    }

    @Test
    public void test2() {
        String content = "你好！java Non-Blocking I/O.";
        CharBuffer buffer = CharBuffer.allocate(50);
        //将字符串内容写入buffer
        for (int i = 0; i < content.length(); i++) {
            buffer.put(content.charAt(i));
        }
        System.out.println("Position:"+buffer.position()+"__limit:"+buffer.limit());
        System.out.println("----------");
        //反转buffer,准备读取buffer内容
        buffer.flip();
        System.out.println("反转后：Position:"+buffer.position()+"__limit:"+buffer.limit());
        System.out.println("----------");

        //读取buffer中的数据
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("Position:"+buffer.position()+"__limit:"+buffer.limit());
        System.out.println("----------");
        //倒回到读取之前，准备再次读取
        buffer.rewind();
        System.out.println("倒回后：Position:"+buffer.position()+"__limit:"+buffer.limit());
        System.out.println("----------");

        //读取buffer中的数据
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("Position:"+buffer.position()+"__limit:"+buffer.limit());
        System.out.println("----------");

        //清空buffer,复位position,buffer可以再次复用
        buffer.clear();
        System.out.println("Position:"+buffer.position()+"__limit:"+buffer.limit());
        buffer.put('你').put('好').put('!');
        System.out.println("Position:"+buffer.position()+"__limit:"+buffer.limit());
//        buffer.flip();
        //读取buffer中的数据
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
            System.out.println("Position:"+buffer.position()+"__limit:"+buffer.limit());
        }
        System.out.println("Position:"+buffer.position()+"__limit:"+buffer.limit());
        System.out.println("----------");

    }
}
