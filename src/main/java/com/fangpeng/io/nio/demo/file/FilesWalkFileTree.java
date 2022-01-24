package com.fangpeng.io.nio.demo.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 遍历文件夹
 * @author 方鹏
 * @date 2022年01月23日 6:37 下午
 */
public class FilesWalkFileTree {

    public static void main(String[] args) throws IOException {
//        Files.delete(Paths.get("/Users/fangpeng/Downloads/netty-demo"));
        Files.walkFileTree(Paths.get("/Users/fangpeng/Downloads/netty-demo"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return super.visitFile(file, attrs);
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return super.postVisitDirectory(dir, exc);
            }
        });
    }

    private static void m2() throws IOException {
        AtomicInteger javaCount = new AtomicInteger();
        Files.walkFileTree(Paths.get("/Users/fangpeng/Downloads/netty-demo"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".java")) {
                    System.out.println(file);
                    javaCount.incrementAndGet();
                }
                return super.visitFile(file, attrs);
            }
        });
        System.out.println("java count:" + javaCount);
    }

    private static void m1() throws IOException {
        AtomicInteger dirCount = new AtomicInteger();
        AtomicInteger fileCount = new AtomicInteger();
        Files.walkFileTree(Paths.get("/Users/fangpeng/Downloads/netty-demo"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("====>"+dir);
                dirCount.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                fileCount.incrementAndGet();
                return super.visitFile(file, attrs);
            }
        });
        System.out.println("dir count:" +dirCount);
        System.out.println("file count:" +fileCount);
    }

}
