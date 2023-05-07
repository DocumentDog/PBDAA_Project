import java.io.IOException;
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
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.exceptions.CsvMalformedLineException;
import java.io.StringReader;


public class CountRecsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        CSVReader reader = new CSVReader(new StringReader(value.toString()));
        try {
            String[] n = reader.readNext();
	    for (int i = 0; i < n.length; i++) {
		    if (n[i] != null) {
            		context.write(new Text("number of records:"), new IntWritable(1));
		    }
	    }
        } catch (CsvMalformedLineException | CsvValidationException e) {
            System.out.println("An eror occured");
            e.printStackTrace();
        }
    }
}
