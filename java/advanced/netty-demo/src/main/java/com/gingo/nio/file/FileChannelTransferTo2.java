package com.gingo.nio.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 零拷贝大文件
 */
public class FileChannelTransferTo2 {

    public static void main(String[] args) {
        try (FileChannel from = new FileInputStream("data.txt").getChannel();
             FileChannel to = new FileOutputStream("to.txt").getChannel()) {
            long size = from.size();
            for (long left = size; left > 0; ) {
                System.out.println("position:" + (size - left) + " left:" + left);
                left -= from.transferTo(size - left, 0, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
