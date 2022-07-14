import java.lang.*;
import java.util.*;

class Student
{
	public int RID;
	public String Name;
	public int Salary;
	
	private static int Generator;

	static		// check google
	{
		Generator = 0;
	}

	public Student(String str, int value)
	{
		this.RID = ++Generator;
		this.Name = str;
		this.Salary = value;
	}
	
	public void DisplayData()
	{
		System.out.println(this.RID + "\t" + this.Name + "\t" + this.Salary);
	}
}

class DBMS
{
	public LinkedList <Student> lobj;	// fakt reference create kela

	public DBMS()
	{
		lobj = new LinkedList<>();	// object initialised
	}

	// Initialising Msg
	public void StartDBMS()
	{
		Scanner scanobj = new Scanner(System.in);

		System.out.println("Customised DBMS Started Succesfully....");

		String Query = "";

		while(true)
		{
			System.out.print("Customised DBMS Console >");

			Query = scanobj.nextLine();

			String tokens[] = Query.split(" ");

			int QuerySize = tokens.length;

			if(QuerySize == 1)
			{
				if("Help".equals(tokens[0]))
				{
					System.out.println("This application is used to demonstarte Customised DBMS");
					System.out.println("Exit : Terminate DBMS");
					System.out.println("Display All Data : select * from student");
					System.out.println("Insert Data : Insert into student Name Salary");
					System.out.println("Display Data : Display student from student");
				}
			
				else if("Exit".equals(tokens[0]))
				{
					System.out.println("Thank You For Using Customised DBMS");
					break;
				}
			}
			else if(QuerySize == 2)
			{
				
			}
			else if(QuerySize == 4)
			{
				if("select".equals(tokens[0]))
				{
					if("*".equals(tokens[1]))
					{
						DisplayAll();
					}
				}
			}
			else if(QuerySize == 5)
			{
				// Insert into student Piyush 1000;
				if("Insert".equals(tokens[0]))
				{
					InsertData(tokens[3],Integer.parseInt(tokens[4]));
				}
			}
		}
	} 

	// Insert Data In Data
	public void InsertData(String str, int value)
	{
		Student sobj = new Student(str,value);
		lobj.add(sobj);	// student cha data gela ll madhe(student is like structure)
	}

	// Display All 
	public void DisplayAll()
	{
		for(Student sref: lobj)		// student cha object
		{
			sref.DisplayData();
		}
	}

	// Display By RID
	public void DisplaySpecific(int rid)	// display data of given rid
	{
		for(Student sref: lobj)		
		{
			if(sref.RID == rid)
			{
				sref.DisplayData();
				break;
			}
		}
	}

	// Display By Name
	public void DisplaySpecific(String name)	// overloaded
	{
		for(Student sref: lobj)
		{
			if(sref.Name.equals(name))
			{
				sref.DisplayData();
			}
		}
	}

	// Delete By RID
	public void DeleteSpecific(int rid)
	{
		int index = 0;

		for(Student sref: lobj)
		{
			if(sref.RID == rid)
			{
				lobj.remove(index);
				break;
			}
			
			index++;
		}
	}

	// Overloaded Delete By Name
	public void DeleteSpecific(String name)
	{
		int index = 0;	
		
		for(Student sref: lobj)
		{
			if(sref.Name.equals(name))
			{
				lobj.remove(index);
				break;
			}
		
			index++;
		}
	}

	// Aggregate Max Operator
	public void AggregateMax()
	{
		int iMax = 0;
		Student temp = null;

		for(Student sref : lobj)		// sref ha refrence ahe Student Chya LL madhla
		{
			if(sref.Salary > iMax)
			{
				iMax = sref.Salary;
				temp = sref;
			}
		}
		
		System.out.println("Information Of Student Having Maximum Salary : ");
		temp.DisplayData();
	}

	// Display Min
	public void AggregateMin()
	{
		int iMin = (lobj.getFirst()).Salary;	// using inbuilt method
		Student temp = lobj.getFirst();	// jr first min salary asel tr lagel tyacha ref karan if madhe janarach nahi kdhi

		for(Student sref : lobj)
		{
			if(sref.Salary < iMin)
			{
				iMin = sref.Salary;
				temp = sref;
			}
		}
		
		System.out.println("Information Of Student Having Minimum Salary : ");
		temp.DisplayData();
	}

	// Display Sum
	public void AggregateSum()
	{
		long iSum = 0;

		for(Student sref : lobj)
		{
			iSum = iSum + sref.Salary;
		}
		
		System.out.println("Summation Of Salaries : "+ iSum);
	}

	// Display Average
	public void AggregateAverage()
	{
		long iSum = 0;

		for(Student sref : lobj)
		{
			iSum = iSum + sref.Salary;
		}
		
		System.out.println("Average Of Salary Is : "+ iSum/(lobj.size()));
	}

	// Display Count
	public void AggregateCount()
	{
		System.out.println("Count Is : "+ (lobj.size()));
	}
}

class project_code
{
	public static void main(String arg[])
	{
		DBMS dobj = new DBMS();
		dobj.StartDBMS();	

		/*dobj.InsertData("Piyush", 1000);
		dobj.InsertData("Mahesh",4000);
		dobj.InsertData("Shivam", 3000);
		dobj.InsertData("Raghunath", 2000);
		dobj.InsertData("Suryavanshi", 5000);
		dobj.InsertData("Pranav", 6000);
		
		dobj.DisplayAll();

		//dobj.DisplaySpecific(4);
		//dobj.DisplaySpecific("Shivam");

		//dobj.DeleteSpecific(3);
		//dobj.DeleteSpecific("Raghunath");
		//dobj.DisplayAll();

		// Aggregate Functions --

		dobj.AggregateMax();
		dobj.AggregateMin();
		dobj.AggregateSum();
		dobj.AggregateAverage();
		dobj.AggregateCount();*/
	}
}