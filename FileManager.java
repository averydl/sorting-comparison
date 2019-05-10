import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class FileManager {
	public static File createFile(String name, Integer[] data) {
		File f = new File(name);
                BufferedWriter output;
                try {
                    output = new BufferedWriter((new FileWriter(f)));
                    for(int i = 0; i < data.length; i++) {
                        output.write(data[i] + "\n");
                    }
                    output.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                return f;
	}

        public static Integer[] generateData(int length, boolean sorted) {
            Random rand = new Random();
            Integer[] data = new Integer[length];
            for(int i = 0; i < length; i++) {
                data[i] = rand.nextInt();
            }
            if(sorted) {
                Arrays.sort(data);
            }
            return data;
        }

        public static Integer[] getData(String name) {
            ArrayList<Integer> data = new ArrayList<Integer>();
            File file = new File(name);
            try {
                BufferedReader input = new BufferedReader(new FileReader(file));
                String curLine;
                while((curLine = input.readLine()) != null) {
                    data.add(Integer.parseInt(curLine));
                }
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
            Integer[] arr = new Integer[data.size()];
						for(int i = 0; i < data.size(); i++) {
							arr[i] = data.get(i);
						}
						return arr;
        }
}
