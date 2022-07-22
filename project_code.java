import java.lang.*;
import java.util.*;

class Student
{
	public int RID;
	public String Name;
	public int Salary;
	
	private static int Generator;

	static		// check book
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
		System.out.println("|"+this.RID + "\t\t|" + this.Name + "\t\t|" + this.Salary+"|");
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

			String tokens[] = Query.toLowerCase().split(" ");

			int QuerySize = tokens.length;

			if(QuerySize == 1)
			{
				if("help".equals(tokens[0]))
				{
					DisplayHelp();
				}
			
				else if("exit".equals(tokens[0]))
				{
					System.out.println("Thank You For Using Customised DBMS");
					break;
				}
			}
			else if(QuerySize == 2)
			{
				if("man".equals(tokens[0]))
				{
					DisplayMan(tokens[1]);
				}
			}
			else if(QuerySize == 4)
			{
				if("select".equals(tokens[0]))
				{
					if("*".equals(tokens[1]))
					{
						DisplayAll();
					}
					else if("max".equals(tokens[1]))
					{
						AggregateMax();
					}
					else if("min".equals(tokens[1]))
					{
						AggregateMin();
					}
					else if("avg".equals(tokens[1]))
					{
						AggregateAverage();
					}
					else if("sum".equals(tokens[1]))
					{
						AggregateSum();
					}
					else if("count".equals(tokens[1]))
					{
						AggregateCount();
					}
				}
			}
			else if(QuerySize == 5)
			{
				// Insert into student Piyush 1000;
				if("insert".equals(tokens[0]))
				{
					InsertData(tokens[3],Integer.parseInt(tokens[4]));
				}
			}
		}
	} 

	// Displays Help
	public void DisplayHelp()
	{
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|This application is used to demonstarte Customised DBMS  |");
		System.out.println("|---------------------------------------------------------|");
		System.out.println("man               : Displays Manuals Of Queries Syntax - man query");
		System.out.println("exit              : Terminates DBMS");
		System.out.println("display_all       : Displays All Data");
		System.out.println("insert            : Inserts Data Into Table");
		System.out.println("display           : display specific from student");
		System.out.println("max               : Displays Maximum Amongst Records");
		System.out.println("min               : Displays Minimum Amongst Records");
		System.out.println("avg               : Displays Average Of Records");
		System.out.println("sum               : Displays Sum Of Records");
		System.out.println("count             : Displays No Of Records In Table");
	}

	public void DisplayMan(String name)
	{
		System.out.println("|---------------------------------------------------------|");
		System.out.println("|                 Manual Customize DBMS                   |");
		System.out.println("|---------------------------------------------------------|");

		if("man".equals(name))
		{
			System.out.println("Description : Displays Manual Of Query");
			System.out.println("Syntax      : man query");
		}
		else if("exit".equals(name))
		{
			System.out.println("Description : Exits From Customize DBMS Console");
			System.out.println("Syntax      : exit");
		}
		else if("insert".equals(name))
		{
			System.out.println("Description : Inserts Data Into Table");
			System.out.println("Syntax      : insert into table_name person_name salary");
		}
		else if("display_all".equals(name))
		{
			System.out.println("Description : Displays All Data From Table");
			System.out.println("Syntax      : select * from student");
		}
		else if("display".equals(name))
		{
			System.out.println("Description : Displays Specific Data From Table");
			System.out.println("Syntax      : select rid/name from student");
		}
		else if("max".equals(name))
		{
			System.out.println("Description : Displays Maximum Record Salary ");
			System.out.println("Syntax      : select max from student");
		}
		else if("min".equals(name))
		{
			System.out.println("Description : Displays Minimum Record Salary ");
			System.out.println("Syntax      : select min from student");
		}
		else if("avg".equals(name))
		{
			System.out.println("Description : Displays Average Of Salary ");
			System.out.println("Syntax      : select avg from student");
		}
		else if("sum".equals(name))
		{
			System.out.println("Description : Displays Sum Of Salary ");
			System.out.println("Syntax      : select sum from student");
		}
		else if("count".equals(name))
		{
			System.out.println("Description : Displays No of Records In Table ");
			System.out.println("Syntax      : select count from student");
		}
	}
	// insert into student name salary
	public void InsertData(String str, int value)
	{
		Student sobj = new Student(str,value);
		lobj.add(sobj);	// student cha data gela ll madhe(student is like structure)
	}

	// Display All 
	public void DisplayAll()
	{
		System.out.println("|RID            |            Name           |     salary          |");
		for(Student sref: lobj)		// student cha object
		{
			sref.DisplayData();
		}
	}

	// Display By RID
	public void DisplaySpecific(int rid)	// display data of given rid
	{
		int count = 0;
		for(Student sref: lobj)		
		{
			count++;
			if(sref.RID == rid)
			{
				sref.DisplayData();
				break;
			}
		}

		if(count == lobj.size())
		{
			System.out.println("Enter Valid RID!!");
		}
	}

	// Display By Name
	public void DisplaySpecific(String name)	// overloaded
	{
		int count = 0;
		for(Student sref: lobj)
		{
			count++;
			if(sref.Name.equals(name))
			{
				sref.DisplayData();
			}
		}

		if(count == lobj.size())
		{
			System.out.println("Enter Valid Name!!");
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
