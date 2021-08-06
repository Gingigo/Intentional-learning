package com.gingo.chat.server.handler;

import com.gingo.chat.message.ChatRequestMessage;
import com.gingo.chat.message.ChatResponseMessage;
import com.gingo.chat.server.session.SessionFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/*
    单聊 handler
 */
@ChannelHandler.Sharable
public class ChatRequestMessageHandler extends SimpleChannelInboundHandler<ChatRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ChatRequestMessage msg) throws Exception {
        String to = msg.getTo();
        Channel channel = SessionFactory.getSession().getChannel(to);
        // 在线
        if (channel != null) {
            // 这里写到 “to” 的客户端
            channel.writeAndFlush(new ChatResponseMessage(msg.getFrom(), msg.getContent()));
        } else {
            // 不在线 这写到 “from” 的客户端
            ctx.writeAndFlush(new ChatResponseMessage(false, "对方不在线！"));
        }
    }
}
