/**
 * 
 */
package yelp.dataset.json2csv.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.jsontocsv.parser.JsonFlattener;
import com.jsontocsv.writer.CSVWriter;

/**
 * @author Rahul
 *
 */
public class Json2CSVYelpDataset {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File file = new File("D:/DevelopmentProjects/YelpProject/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.json");
		System.out.println(file.getAbsolutePath());
		
		String line=null;
		BufferedReader in = new BufferedReader(new FileReader(file));
		JsonFlattener parser = new JsonFlattener();
        CSVWriter writer = new CSVWriter();
        String fileName = "D:/DevelopmentProjects/YelpProject/yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review"
        		+ ".csv";
        
        BufferedWriter writer1 = null;
        writer1 = new BufferedWriter(new FileWriter(fileName));
        boolean header = true;
        Set<String> headers = null;
        int count = 0;
		while((line = in.readLine())!= null){
			System.out.println("Count = " + count);
			System.out.println(line);
			String line1 = line;
			
			List<Map<String, String>> flatJson = parser.parseJson(line1);
	      if(header){
	    	  headers =   writer.collectHeader(flatJson, fileName);
		      writer1.write(StringUtils.join(headers.toArray(), ",") + "\n");
		      header = false;
	      }
	       String output =  writer.getRow(flatJson, fileName, headers);
	       output = output.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "")  + "\n";
	       System.out.println(output);
	       writer1.write(output);
	       writer1.flush();
	       count++;
		}
		writer1.close();
	}

}
