package com.gingo.netty.demo11;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group =  new NioEventLoopGroup();
        ChannelFuture channelFuture = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                .connect("127.0.0.1", 8080);

//        channelFuture
//                .sync()
//                .channel()
//                .writeAndFlush(new Date() + "hello world");

//        channelFuture.addListener((ChannelFutureListener) future -> {
//            future.channel().writeAndFlush(new Date() + "hello world");
//        });

        Channel channel = channelFuture.sync().channel();
        new Thread(
                () -> {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        String line = scanner.nextLine();
                        if ("q".equals(line)) {
                            channel.close();
                            break;
                        }
                        channel.writeAndFlush(line);
                    }
                },"input"
        ).start();


        ChannelFuture closeFuture = channel.closeFuture();
        closeFuture.addListener((ChannelFutureListener) future -> group.shutdownGracefully());

    }
}
