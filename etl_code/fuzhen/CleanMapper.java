
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvMalformedLineException;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.io.StringReader;

public class CleanMapper
        extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        CSVReader reader = new CSVReader(new StringReader(value.toString()));
        try{
            String[] n = reader.readNext();
            if(n != null) {
                int colNumLa = 18;
                int colNumLo = 19;

                if (n.length > colNumLo && n[colNumLa] != null && n[colNumLo] != null)
                    context.write(new Text(n[colNumLa] + "," + n[colNumLo]+",/n"), new Text());
            }
        }catch (CsvMalformedLineException | CsvValidationException e) {
            System.out.println("CsvValidationException ERROR");
        }

    }
}
