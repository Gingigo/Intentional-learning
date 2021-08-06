package com.gingo.nio.file;

import com.gingo.nio.bytebuffer.TestByteBuffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileTransferTo {
    public static void main(String[] args) {
        String from = FileTransferTo.class.getResource("data.txt").getPath();
        String to = "to.txt";

        try(
                FileChannel fromChannel = new FileInputStream(from).getChannel();
                FileChannel toChannel = new FileOutputStream(to).getChannel();
        ){
            fromChannel.transferTo(0,fromChannel.size(),toChannel);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
