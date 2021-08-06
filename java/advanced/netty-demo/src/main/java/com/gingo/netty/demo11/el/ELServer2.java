package com.gingo.netty.demo11.el;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ELServer2 {
    public static void main(String[] args) throws InterruptedException {
        DefaultEventLoopGroup normalWorkers = new DefaultEventLoopGroup(2);
        new ServerBootstrap()
                .group(new NioEventLoopGroup(1), new NioEventLoopGroup(2))
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch)  {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                        ch.pipeline().addLast(normalWorkers,"myhandler",
                                new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelRead(ChannelHandlerContext ctx, Object msg) {
                                        ByteBuf byteBuf = msg instanceof ByteBuf ? ((ByteBuf) msg) : null;
                                        if (byteBuf != null) {
                                            byte[] buf = new byte[16];
                                            ByteBuf len = byteBuf.readBytes(buf, 0, byteBuf.readableBytes());
                                            log.debug(new String(buf));
                                        }
                                    }
                                });
                    }
                }).bind(8080).sync();
    }
}
