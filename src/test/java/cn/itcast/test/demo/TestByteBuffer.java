package cn.itcast.test.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        // 1.输入输出流
        try(FileChannel fileChannel =new FileInputStream("Data.txt").getChannel()){
            // 准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            // 从channel读取数据,向缓冲区写入
            // 向缓冲区写入
            while ( fileChannel.read(buffer)==-1){

                // 打印buffer
                // 切换到buffer的读模式
                buffer.flip();
//                read = fileChannel.read(buffer);
                // 检查是否有剩余的数据
                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.println((char)b);
                    log.debug("实际字节{}",(char)b);
                }
                //切换为写模式
                buffer.clear();
            }

        }catch (Exception e){

        }
    }
}
