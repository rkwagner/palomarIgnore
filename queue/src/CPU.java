/*
 * This class currently has the correct CPU timing and incrementation.  The next step will be to initialize the System Jobs
 * such that their run time gets decremented and, once that number hits zero, they get removed from the Queue and 
 * the Queue gets exited.
 * Getting everything to print out from there should fall right out.
 */
import java.io.*;
public class CPU {
	ObjectQueue q1 = new ObjectQueue();
	ObjectQueue q2 = new ObjectQueue();
	ObjectQueue q3 = new ObjectQueue();
	ObjectQueue q4 = new ObjectQueue();
	int cpuTime = 0,
		quantum = 0;
	private PrintWriter writer;
	Job job = new Job(writer);
	int jobID = job.jobID();
	int enQue = job.enQue();
	int workTime = 0;
	public CPU(PrintWriter writer)throws IOException{
		this.writer = writer;
	}
	public void doWork(Object queueTop){
		job.cutter((String)queueTop);
		System.out.println(cpuTime + "**" + job.enQue() + "**" + job.workTime());
		if(job.enQue() == cpuTime){
			q1.insert(queueTop);
			workTime = job.workTime();
			queueOne();
		}
		else if(q1.isEmpty() && q2.isEmpty() && q3.isEmpty() && q4.isEmpty())
			{cpuTime++;
			doWork(queueTop);}
		else if(!q1.isEmpty())
			{queueOne();
			doWork(queueTop);}
		else if(!q2.isEmpty())
			{queueTwo();
			doWork(queueTop);}
		else if(!q3.isEmpty())
			{queueThree();
			doWork(queueTop);}
		else if(!q4.isEmpty())
			{queueFour();
			doWork(queueTop);}
	}
	public int getTime(){
		return cpuTime;
	}
	public void queueOne(){
		if(quantum < 2 && workTime > 0)
			{quantum++;
			workTime--;
			cpuTime++;}
		else if(workTime == 0)
			{System.out.println("1:\t" + cpuTime + "\t" + quantum);
			System.out.println(cpuTime + "\tREMOVED:\t" + q1.remove());
			workTime = job.workTime();
			quantum = 0;}
		else
			{q2.insert(q1.remove());
			System.out.println("1:\t" + cpuTime + "\t" + quantum);
			quantum = 0;
			queueTwo();}
	}
	public void queueTwo(){
		if(quantum < 4 && workTime > 0)
			{quantum++;
			workTime--;
			cpuTime++;}
		else if(workTime == 0)
			{System.out.println("2:\t" + cpuTime + "\t" + quantum);
			System.out.println(cpuTime + "\tREMOVED:\t" + q2.remove());
			workTime = job.workTime();
			quantum = 0;}
		else
			{q3.insert(q2.remove());
			System.out.println("2:\t" + cpuTime + "\t" + quantum);
			quantum = 0;
			queueThree();}
	}
	public void queueThree(){
		if(quantum < 8 && workTime > 0)
			{quantum++;
			workTime--;
			cpuTime++;}
		else if(workTime == 0)
			{System.out.println("3:\t" + cpuTime + "\t" + quantum);
			System.out.println(cpuTime + "\tREMOVED:\t" + q3.remove());
			workTime = job.workTime();
			quantum = 0;}
		else
		{q4.insert(q3.remove());
		System.out.println("3:\t" + cpuTime + "\t" + quantum);
		quantum = 0;
		queueFour();}
	}
	public void queueFour(){
		if(quantum < 16 && workTime > 0)
			{quantum++;
			workTime--;
			cpuTime++;}
		else if(workTime == 0)
			{System.out.println("4:\t" + cpuTime + "\t" + quantum);
			System.out.println(cpuTime + "\tREMOVED:\t" + q4.remove());
			quantum = 0;
			workTime = job.workTime();}
		else
		{q4.insert(q4.remove());
		System.out.println("4:\t" + cpuTime + "\t" + quantum);
		System.out.println(workTime);
		System.out.println(q4.query());}
	}
}
