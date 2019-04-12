package hdfsclient;

import java.io.*;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;


import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IOUtils;





public class FileCopyFromLocal {
    public static void main(String[] args) throws IOException{
        String source = "E:/Huang/ComputerApplying/BigDataDevelopment/poem";
        String destination = "hdfs://master:9000/home/hsy/poem2";
        InputStream in = new BufferedInputStream(new FileInputStream(source));
        Configuration conf = new Configuration();

        FileSystem fs = FileSystem.get(URI.create(destination), conf);

        OutputStream out = fs.create(new Path(destination));
        IOUtils.copyBytes(in, out, 4096, true);

    }
}
