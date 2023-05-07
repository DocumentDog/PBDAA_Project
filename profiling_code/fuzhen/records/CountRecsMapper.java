
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.io.StringReader;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.exceptions.CsvMalformedLineException;

public class CountRecsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        CSVReader reader = new CSVReader(new StringReader(value.toString()));
        try{
            String[] n = reader.readNext();
            if(n != null) {
                context.write(new Text("Records Num = "), new IntWritable(1));
            }
        }catch (CsvMalformedLineException | CsvValidationException e) {
            System.out.println("CsvValidationException ERROR");
        }
    }


}
