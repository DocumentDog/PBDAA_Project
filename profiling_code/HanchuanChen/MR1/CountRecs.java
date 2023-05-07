import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CountRecs {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: WordCount <input path> <output path>");
            System.exit(-1);
        }
	Job job = new Job();
	job.addFileToClassPath(new Path("opencsv.jar"));
        job.setJarByClass(CountRecs.class);
	job.setJobName("Count Recs");
	job.setNumReduceTasks(1);

        job.setMapperClass(CountRecsMapper.class);
        job.setReducerClass(CountRecsReducer.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
	FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
	System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

