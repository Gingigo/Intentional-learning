package com.gingo.netty.demo11;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class HelloServer {
    public static void main(String[] args) {
//        new ServerBootstrap()
//                .group(new NioEventLoopGroup()) // 1
//                .channel(NioServerSocketChannel.class) // 2
//                .childHandler(new ChannelInitializer<NioSocketChannel>() { // 3
//                    protected void initChannel(NioSocketChannel ch) {
//                        ch.pipeline().addLast(new StringDecoder()); // 5
//                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() { // 6
//                            @Override
//                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
//                                System.out.println(msg);
//                            }
//                        });
//                    }
//                })
//                .bind(8080); // 4
        String[] arr={"1","2","3"};
        List list = Arrays.asList(arr);
        arr[1]="4";
        try {
            list.add("5");
        }catch (Exception e){
            e.printStackTrace();
        }

        log.info("{},{}",arr,list);
    }
}
