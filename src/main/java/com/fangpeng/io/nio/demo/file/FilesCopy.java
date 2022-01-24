package com.fangpeng.io.nio.demo.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author 方鹏
 * @date 2022年01月23日 6:36 下午
 */
public class FilesCopy {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String source = "D:\\Snipaste-1.16.2-x64";
        String target = "D:\\Snipaste-1.16.2-x64aaa";

        Files.walk(Paths.get(source)).forEach(path -> {
            try {
                String targetName = path.toString().replace(source, target);
                // 是目录
                if (Files.isDirectory(path)) {
                    Files.createDirectory(Paths.get(targetName));
                }
                // 是普通文件
                else if (Files.isRegularFile(path)) {
                    Files.copy(path, Paths.get(targetName));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
