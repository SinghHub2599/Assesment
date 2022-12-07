package com.ATDevServices.Student2;
import java.util.Scanner;
public class StudentApp 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	StudentDAO stdo=new StudentDAO();
    	while(true)
    	{
    		System.out.println("1.Create"+"\n"+ "2.delete"+"\n"+"3.Update"+"\n"+"4.Read");
    		int choice=sc.nextInt();
    		switch (choice) {
			case 1:
				stdo.insertStudent();
				break;
			case 2:
				stdo.deleteStudent();
				break;
			case 3:
				stdo.updateStudent();;
				break;
			case 4:
				stdo.readStudent();;
				break;
			default:
				System.out.println("Your have Enter wrong Choice");
				break;
			}
    	}
    }
}
