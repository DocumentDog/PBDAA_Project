import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.*; 
import java.util.*;
import java.io.FileReader;  
//import com.opencsv.CSVReader;  
public class CleanMapper
extends Mapper<LongWritable, Text, Text, IntWritable> { 
//private static final int MISSING = 9999;
@Override


public void map(LongWritable key, Text value, Context context) 
throws IOException, InterruptedException {
	String[] p = value.toString().split(","); 
	
	
    //only check starting stations. I want to preserve the header all unique values 
	if(p.length==15 && p[5]!="NULL" && p[6]!="NULL"){//remove all station that are null. 
		String result=p[5]+","+p[6];
		context.write(new Text(result), new IntWritable(1));


	}
	
 //for ( HashMap.Entry<String, Integer> entry : count.entrySet()) {
            
    //  }

}

}



// import java.io.IOException;
// import org.apache.hadoop.io.IntWritable;
// import org.apache.hadoop.io.LongWritable;
// import org.apache.hadoop.io.Text;
// import org.apache.hadoop.mapreduce.Mapper;
// public class MaxTemperatureMapper
// extends Mapper<LongWritable, Text, Text, IntWritable> { 
// private static final int MISSING = 9999;
// @Override
// public void map(LongWritable key, Text value, Context context) 
// throws IOException, InterruptedException {
// String line = value.toString(); 
// String year = line.substring(15, 19); 
// int airTemperature;
// if (line.charAt(87) == '+') { // parseInt doesn't like leading plus signs 
// airTemperature = Integer.parseInt(line.substring(88, 92));
// } else {
// airTemperature = Integer.parseInt(line.substring(87, 92)); 
// }
// String quality = line.substring(92, 93);
// if (airTemperature != MISSING && quality.matches("[01459]")) { 
// context.write(new Text(year), new IntWritable(airTemperature));
// }
// }
// }