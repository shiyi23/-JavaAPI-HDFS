package hadoopapi;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Shell;

public class HDFSTest {
    public static void main(String[] args){
        try{
            String filename="/home/hello.txt";
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:9000/");

    conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");

        FileSystem fs = FileSystem.get(conf);
        if(fs.exists(new Path(filename))) {
            System.out.println("this file is exits!");
        }else {
            System.out.println("this file is not exits!");
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
