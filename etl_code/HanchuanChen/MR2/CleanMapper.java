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
import java.io.IOException;

public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		CSVReader reader = new CSVReader(new StringReader(value.toString()));
		try {
    			String[] n = reader.readNext();
			if (n[27] != null && n[28] != null) {
				context.write(new Text(n[27] + "," + n[28]), new Text());
			}
		} catch (CsvMalformedLineException | CsvValidationException e) {
			System.out.println("An eror occured");
			e.printStackTrace();
		}	
	}
}
