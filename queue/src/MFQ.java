import java.io.*;
import java.util.Scanner;
public class MFQ extends Driver{
	private PrintWriter writer;
	ObjectQueue que = new ObjectQueue();
	CPU cpu = new CPU(writer);
	Scanner read = new Scanner(new File("input.txt"));
	Job job = new Job(writer, read);
	public MFQ(PrintWriter writer)throws IOException{
		this.writer = writer;}
	public void getJobs()throws IOException{
		Job job = new Job(writer, read);
		if(!read.hasNextLine()){}
		else{
			job.job(read);
			que.insert(job.jobList());	//Inserts jobList() which is cast up to an Object.  This is the Queue that houses all jobs,
										//confirmed by my outStats() method.
		getJobs();}}					//Recursive call.
	public void outputHeader(){
		System.out.println(" Add\tProcess\tWork\nTime:\t  ID:\tTime:");}
	public void runSimulation()throws IOException{
		if(!que.isEmpty())
		{cpu.doWork(que.remove());
		System.out.println(cpu.getTime());
		if(!que.isEmpty())
			System.out.println(que.query());
		else;
		runSimulation();}
	}
	
	public void outStats(){
		/*if(!que.isEmpty())
			{System.out.println(que.query());
			writer.println(que.remove());
			outStats();}*/}}
