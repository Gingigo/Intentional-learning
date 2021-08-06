package com.gingo.netty.demo11.bf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static io.netty.util.internal.StringUtil.NEWLINE;

@Slf4j
public class ByteBufTest1 {
    public static void main(String[] args) {
        // 池化的直接内存 ByteBuf
        ByteBuf buf = ByteBufAllocator.DEFAULT.buffer(10);
        // 池化的堆内存 ByteBuf
        ByteBuf buf1 = ByteBufAllocator.DEFAULT.heapBuffer(10);
        log.info("{}", buf);
        log.info("{}",buf1);

        // write 是会移动写指针的 ， set 不会写移动指针
        buf.writeBytes(new byte[]{1, 2, 3, 4});
        // Int 占用四位
        buf.writeInt(5);
        buf.writeInt(6);
        log(buf);
        // read 会移动读指针 ，get 不会移动读指针
        log.info("{}",buf.readByte());
        log.info("{}",buf.readByte());
        log.info("{}",buf.readByte());
        log.info("{}",buf.readByte());
        log(buf);
        log.info("{}",buf.getByte(0));

        buf.markReaderIndex();
        log.info("{}", buf.readByte());
        log(buf);
        buf.resetReaderIndex();
        log(buf);

    }
    private static void log(ByteBuf buffer) {
        int length = buffer.readableBytes();
        int rows = length / 16 + (length % 15 == 0 ? 0 : 1) + 4;
        StringBuilder buf = new StringBuilder(rows * 80 * 2)
                .append("read index:").append(buffer.readerIndex())
                .append(" write index:").append(buffer.writerIndex())
                .append(" capacity:").append(buffer.capacity())
                .append(NEWLINE);
        appendPrettyHexDump(buf, buffer);
        System.out.println(buf.toString());
    }
}
