package local_data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataFileHandler {
	
	public static final String fileName = "localData.csv";
	
	
	public static ArrayList<Register> loadDataFromExternalFile() throws Exception {
    	
    	ArrayList<Register> registers = new ArrayList<Register>();
    	BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
    	
    	String row;
    	while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            registers.add(new Register(data));
        }
    	
    	csvReader.close();
    	return registers;
    }
    
    
    public static void createDataFile() throws IOException {	
    	try {
	    	FileWriter csvWriter = new FileWriter(fileName);
	
	    	csvWriter.append("FullName");
	    	csvWriter.append(",");
	    	csvWriter.append("CPF");
	    	csvWriter.append(",");
	    	csvWriter.append("Gender");
	    	csvWriter.append(",");
	    	csvWriter.append("Status");
	    	csvWriter.append(",");
	    	csvWriter.append("Group");
	    	csvWriter.append(",");
	    	csvWriter.append("Birth");
	    	csvWriter.append(",");
	    	csvWriter.append("MothersName");
		    csvWriter.append("\n");
	
	    	csvWriter.flush();
	    	csvWriter.close();
    	
    	} catch(Exception e) {
    		throw new IOException("Unable to create data file");
    	}
    }
    

    public static void saveToExternalFile(String[] data) throws IOException {

    	FileWriter csvWriter = new FileWriter(fileName, true);

	    csvWriter.append(String.join(",", data));
	    csvWriter.append("\n");

    	csvWriter.flush();
    	csvWriter.close();
    }
    
}
