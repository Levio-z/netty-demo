package cn.itcast.nio.c2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
//        System.out.println(ByteBuffer.allocate(16).getClass());
//        System.out.println(ByteBuffer.allocateDirect(16).getClass());
//        /*
//        class java.nio.HeapByteBuffer    - java 堆内存，读写效率较低，受到 GC 的影响
//        class java.nio.DirectByteBuffer  - 直接内存，读写效率高（少一次拷贝），不会受 GC 影响，分配的效率低
//         */
//        ByteBuffer allocate = ByteBuffer.allocate(10);
//        allocate.put(new byte[]{0x62, 0x63, 0x64});
//
//        allocate.flip();
//        while (allocate.hasRemaining()){
//            System.out.println(allocate.get());
//        }
//        allocate.rewind();
//        while (allocate.hasRemaining()){
//            System.out.println(allocate.get());
//        }
        ByteBuffer buffer = ByteBuffer.allocateDirect(1);

        try (FileChannel channel2 = new FileOutputStream("Data.txt").getChannel()) {
            try (FileChannel channel = new FileInputStream("Data.txt").getChannel()) {

                int read = channel.read(buffer);
                System.out.println(read);
                buffer.flip();
                int write = channel2.write(buffer);
                System.out.println("write"+write);
                buffer.clear();
//            }
            } catch (IOException e) {

            }
        } catch (IOException e) {
        }

    }
}
