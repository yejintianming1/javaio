package aio.echo;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncEchoServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;

    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncEchoServerHandler(int port) {
        this.port = port;
        try {
            //获取AsynchronousServerSocketChannel对象
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            //绑定服务端口
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doAccept() {
        //接收客户端连接
        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
