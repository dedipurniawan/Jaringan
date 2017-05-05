package Tugas.Thread;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Treat extends Thread {
 	public void run() {
            long startTime = System.nanoTime();
            String sourceFile1Path = "D:\\DOCUMENT\\Semester 6\\Pemrograman Jaringan\\File\\percobaan 5\\file1-5.log";
            String sourceFile2Path = "D:\\DOCUMENT\\Semester 6\\Pemrograman Jaringan\\File\\percobaan 5\\file2-5.log";
            String sourceFile3Path = "D:\\DOCUMENT\\Semester 6\\Pemrograman Jaringan\\File\\percobaan 5\\file3-5.log";
 
            String mergedFilePath = "D:\\filegabung.txt";
 
            File[] files = new File[3];
            files[0] = new File(sourceFile1Path);
            files[1] = new File(sourceFile2Path);
            files[2] = new File(sourceFile3Path);
 
            File mergedFile = new File(mergedFilePath);
                
 
            mergeFiles(files, mergedFile);
            long endTime = System.nanoTime();
            System.out.println("Time: "+(endTime - startTime) + " ns"); 
	}
        
	public static void mergeFiles(File[] files, File mergedFile) {
 
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
 
		for (File f : files) {
			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
 
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
        
        public static void main(String[] args){
            
            Thread jalanthread = new Thread(new Treat());
            jalanthread.start();
            
        }
}
