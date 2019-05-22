package nio.block.echo;

import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    //执行服务端业务逻辑线程池
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        try {

            //新建服务端serverSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //如果serverSocketChannel创建成功
            if (serverSocketChannel.isOpen()) {
                //设置为阻塞模式
                serverSocketChannel.configureBlocking(true);
                //设置网络传输参数
//                serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF,)
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
