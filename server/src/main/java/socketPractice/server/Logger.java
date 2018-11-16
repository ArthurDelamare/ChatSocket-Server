package socketPractice.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	public static String FILE_NAME = "Log.txt";
	public static String RELATIVE_DIRECTORY_PATH = System.getProperty("user.dir") + "\\";
	public static String FULL_PATH =  Logger.RELATIVE_DIRECTORY_PATH + Logger.FILE_NAME;
	
	public static synchronized void WriteLog(String log) {
		try(FileWriter fw = new FileWriter("Log.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(log);
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	private static boolean FileExist() {
		File file = new File(Logger.FULL_PATH);
		if (file.exists())
			return true;
		return false;
	}
}
