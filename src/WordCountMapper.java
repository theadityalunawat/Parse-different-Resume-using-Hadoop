import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, Text> 
{
	private Text word = new Text();
	private final static LongWritable one = new LongWritable(1);
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		HashMap<String, Integer> hm= new HashMap<String, Integer>();
		String[] list = new String[200];
		list[1] ="Email: ";
		list[2] = "Phone No: ";
		list[3] = "Alternate Phone: ";
		list[4] = "Years of Exp: ";
		list[5] = "Under_grad degree: ";
		list[6] = "Uder_grad University: ";
		list[7] = "Under_grad_passing_year: ";
		list[8] = "Post_grad_degree: ";
		list[9] = "Post_grad_universoty: ";
		list[10] = "Post_grad_passing_year: ";
		list[11] = "Location: ";
		list[12] = "Project 1: ";
		list[13] = "Project 2: ";
		list[14] = "Start_date: ";
		list[15] = "End Date: ";
		list[16] = "Role/Responsibility: ";
		list[17] = "Environment: ";
		list[18] = "Description: ";
		list[19] = "Awards: ";
		list[20] = "Project 1";
		list[21] = "Project 2";
		list[22] = "cgpa: ";
		list[23] = "Alternate Phone :";
		list[24] = "Projet2: ";
		list[25] = "Under_grad_degree: ";
		list[26] = "Under_grad_University: ";
		list[27] = "Cgpa: ";
		list[28] = "Award: ";
		list[29] = "Under_grad_degree:";
		list[30] = "Award: ";
		list[31]="Uder_grad_University:";
		list[32] = "CGPA: ";

		String project = "";
		String line = value.toString();
		
		String newS = line.replaceAll("(\\r|\\n|\\r\\n)", "");
		line.replace("\\r|\\n", "");
		String f = "";
		for(int i=1;i<=32;i++){
			newS = newS.replaceAll(list[i],",");
		}
		newS=newS.replaceAll(" ,", ",");
		newS= newS.trim();
		newS=newS.replaceAll("Name: ","");
		System.out.println(newS);
		context.write(new Text(""), new Text(newS));
	}
}
