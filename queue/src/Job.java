import java.io.*;
import java.util.Scanner;
public class Job {
	private Scanner read = new Scanner(new File("input.txt"));
	String s = read.nextLine();
	String[] st = s.split("\\s+");
	public Job(PrintWriter write)throws IOException{
	}
	public Job(PrintWriter write, Scanner read) throws IOException{
		this.read = read;}
	public void formatS(){
		if(s.startsWith(" "))
				s = s.replaceFirst(" ", "");
		else;
	}
	public void job(Scanner read)throws IOException{
			s = read.nextLine();
			formatS();
			st = s.split("\\s+");}
	public Object jobList(){
		return enQue() + "\t " + jobID() + "\t " + workTime();
		}
	public void cutter(String queue){
		st = queue.split("\\s+");
	}
	public int enQue(){
		return Integer.parseInt(String.valueOf(st[0]));	
	}
	public int jobID(){
		return Integer.parseInt(String.valueOf(st[1]));}
	public int workTime(){
		return Integer.parseInt(String.valueOf(st[2]));}}
