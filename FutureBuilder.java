import java.util.*;
import java.io.*;
public class FutureBuilder {
    public static void main(String args[])throws IOException
    {
        FutureBuilder.display_menu();
    }
    static String input()throws IOException
    {
        InputStreamReader read= new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(read);
        String input=br.readLine();
        return input;
    }
    static void display_menu()throws IOException
    {
        System.out.println("Welcome to FutureBuilder:");
        System.out.println("\t1) Enter the Application\n\t2)Exit the Application\n");
        int choice=Integer.parseInt(FutureBuilder.input());
        if(choice==1)
        {
            FutureBuilder.selection_mode();
        }
        else if(choice==2)
        {
            System.out.println("Thank you for using FutureBuilder! Application session terminated successfully");
        }
        else
        {
            System.out.println("You have enterted an incorrect choice !! Please select a correct choice from 1 or 2\n");
            FutureBuilder.display_menu();
        }
    }
    static void selection_mode()throws IOException
    {
        System.out.println("Choose the mode you want to enter in:-");
        System.out.println("\t1) Enter as Student mode\n\t2) Enter as Company mode");
        System.out.println("\t3) Enter as Placement Cell Mode\n\t4) Return to Main Application");
        int choice=Integer.parseInt(FutureBuilder.input());
        switch(choice)
        {
            case 1:
            Student_Query.display_menu();
            break;
            case 2:
            Company_Query.display_menu();
            break;
            case 3:
            IIITDPlacementCell.display_menu();
            break;
            case 4:
            FutureBuilder.display_menu();
            break;
            default:
            System.out.println("You have selected an incorrect choice!!Please select the correct choice from the selection menu \n");
            FutureBuilder.selection_mode();
        }
    }
}
class Student_Query
{
    static ArrayList<Student> students_list = new ArrayList<Student>();
    static void display_menu()throws IOException
    {
        int no_of_students,choice;
        String name,branch;
        int roll_no;
        float cgpa;
        System.out.println("Choose the Student Query to perform-\n\t1) Enter as a Student(Give Student Name, and Roll No.)\n\t2) Add students\n\t3) Back");
        choice=Integer.parseInt(FutureBuilder.input());
        if (choice==1)
        {
            System.out.println("Enter the student name and Roll No!");
            name=FutureBuilder.input();
            roll_no=Integer.parseInt(FutureBuilder.input());
            for(int i=0;i<students_list.size();i++)
            {
                if (students_list.get(i).roll_number==roll_no)
                {
                    students_list.get(i).display_menu();
                    break;
                }
            }
        }
        else if(choice==2)
        {
            System.out.println("Enter the number of students to be added");
            no_of_students=Integer.parseInt(FutureBuilder.input());
            for(int i=0;i<no_of_students;i++)
            {
                System.out.println("Please fill out the following details for Name, Roll No, CGPA and Branch for Student "+(i+1));
                name=FutureBuilder.input();
                roll_no=Integer.parseInt(FutureBuilder.input());
                cgpa=Float.parseFloat(FutureBuilder.input());
                branch=FutureBuilder.input();
                students_list.add(new Student(name,roll_no,cgpa,branch));
            }
            System.out.println("All new Students have been added");
            Student_Query.display_menu();   
        }
        else if(choice==3)
        {
            FutureBuilder.selection_mode();
        }
        else
        {
            System.out.println("You have entered an incorrect choice !! Please enter the correct choice");
            Student_Query.display_menu();
        }
    }
}
class Company_Query
{
    static ArrayList<Company> company_list = new ArrayList<Company>();
    static void display_menu()throws IOException
    {
        int choice;
        String name,role;
        int package_lpa;
        float cgpa_criteria;
        System.out.println("Choose the Company Query to perform-\n\t1) Add Company and Details\n\t2) Choose Company\n\t3) Get Available Companies\n\t4) Back");
        choice=Integer.parseInt(FutureBuilder.input());
        if (choice==1)
        {
            System.out.println("Enter the Company Details as Name, Role offerred, Package(in lpa) and minimum cgpa requirement");
            name=FutureBuilder.input();
            role=FutureBuilder.input();
            package_lpa=Integer.parseInt(FutureBuilder.input());
            cgpa_criteria=Float.parseFloat(FutureBuilder.input());
            company_list.add(new Company(name, role, package_lpa, cgpa_criteria));
            System.out.println("All new Companies have been added");
            Company_Query.display_menu();
        }
        else if (choice==2)
        {
            System.out.println("Enter the Company Name :");
            name=FutureBuilder.input();
            for(int i=0;i<company_list.size();i++)
            {
                if (company_list.get(i).name.toUpperCase()==name.toUpperCase())
                {
                    company_list.get(i).display_menu();
                    break;
                }
            }
        }
        else if (choice==3)
        {
            System.out.println("All Available Companies are :");
            for(int i=0;i<company_list.size();i++)
            {
                System.out.println((i+1)+") Name: "+company_list.get(i).name+"\n\tRole: "+company_list.get(i).role+"\n\tPackage: "+company_list.get(i).package_lpa+"\n\t CGPA Required: "+company_list.get(i).cgpa_criteria);
            }
            Company_Query.display_menu();
        }
        else if (choice==4)
        {
            FutureBuilder.selection_mode();
        }
        else
        {
            System.out.println("You have given an incorrect input !! Please select the correct choice");
            Company_Query.display_menu();
        }
    }
}
class Student 
{
    String name,branch,status;
    int roll_number,choice;
    float cgpa;
    int current_held_package,previous_held_package;
    Company current_offer,previous_offer;
    Student(String name, int roll_number, float cgpa, String branch)
    {
        this.name=name;
        this.roll_number=roll_number;
        this.cgpa=cgpa;
        this.branch=branch;
        this.current_held_package=0;
        this.previous_held_package=0;
        this.status="not-applied";
    }
    void display_menu()throws IOException
    {
        int choice;
        String name_of_company;
        System.out.println("Welcome "+this.name+"!!\n\t1) Register for Placement Drive \n\t2) Register for Company\n\t3) Get All available companies\n\t4) Get Current Status\n\t5) Update CGPA\n\t6) Accept offer\n\t7) Reject Offer\n\t8) Back");
        choice=Integer.parseInt(FutureBuilder.input());
        switch(choice)
        {
            case 1:
            this.Register_For_Placement_Drive();
            this.display_menu();
            break;
            case 2:
            System.out.println("Enter the name of the company");
            name_of_company=FutureBuilder.input();
            for(int i=0;i<Company_Query.company_list.size();i++)
            {
                if(Company_Query.company_list.get(i).name.toUpperCase()==name_of_company.toUpperCase())
                {
                    this.Register_For_Company((Company_Query.company_list.get(i)));
                }
            }
            this.display_menu();
            break;
            case 3:
            this.Get_All_available_Companies();
            this.display_menu();
            break;
            case 4:
            this.Get_current_status();
            this.display_menu();
            break;
            case 5:
            float new_cgpa;
            System.out.println("Enter the new CGPA");
            new_cgpa=Float.parseFloat(FutureBuilder.input());
            this.Update_CGPA(new_cgpa);
            this.display_menu();
            break;
            case 6:
            this.Accept_Offer();
            break;
            case 7:
            this.Reject_Offer();
            break;
            case 8:
            Student_Query.display_menu();
            break;
            default:
            System.out.println("You have entered and incorrect choice !! Please select the correct choice");
            this.display_menu();
        }
    }
    void Register_For_Placement_Drive()
    {
        IIITDPlacementCell.Student_Registrations.add(this);
        System.out.println("Registered for the Placement Drive");
    }
    void Register_For_Company(Company company)
    {
        company.applied_students.add(this);
        this.status="applied";
        System.out.println("Registered for the Company !!");
        company.application_process();
    }
    void Get_All_available_Companies()
    {
        System.out.println("List of all available companies");
        for(int i=0;i<Company_Query.company_list.size();i++)
        {
            if(this.cgpa>=Company_Query.company_list.get(i).cgpa_criteria && Company_Query.company_list.get(i).package_lpa>=3*this.current_held_package)
            {
                System.out.println(Company_Query.company_list.get(i).name);
            }
        }
    }
    void Get_current_status()
    {
        System.out.println("The current status of the student is : "+this.status);
        if(this.status=="offered")
        {
            System.out.println("Current offer : "+this.current_offer.name);
        }
    }
    void Update_CGPA(float new_cgpa)
    {
        this.cgpa=new_cgpa;
        System.out.println("CGPA Updated!!");
    }
    void Accept_Offer()
    {
        this.status="placed";
        current_offer.selected_students.add(this);
        current_offer.applied_students.remove(this);
    }
    void Reject_Offer()
    {
        if (this.status=="offered"){this.status="applied";}
        this.current_held_package=this.previous_held_package;
        current_offer.applied_students.remove(this);
        if (this.current_held_package!=0){this.current_offer=this.previous_offer;}
        int counter=0;
        for(int i=0;i<Company_Query.company_list.size();i++)
        {
            for(int j=0;j<Company_Query.company_list.get(i).applied_students.size();j++)
            {
                if(Company_Query.company_list.get(i).applied_students.get(j)==this)
                {
                    counter=1;
                    break;
                }
            }
        }
        if(counter==0 && this.status=="applied")
        {
            this.status="blocked";
        }
    }
}
class Company 
{
    String name,role,open_time,end_time;
    int package_lpa,choice;
    float cgpa_criteria;
    ArrayList<Student> applied_students = new ArrayList<Student>();
    ArrayList<Student> selected_students = new ArrayList<Student>();
    Company(String name, String role, int package_lpa, float cgpa_criteria)
    {
        this.name=name;
        this.role=role;
        this.package_lpa=package_lpa;
        this.cgpa_criteria=cgpa_criteria;
    }
    void display_menu()throws IOException
    {
        System.out.println("Welcome "+this.name+"\n\t1) Update Role\n\t2) Update Package\n\t3) Update CGPA criteria\n\t4) Register To Institute Drive\n\t5) Back");
        choice=Integer.parseInt(FutureBuilder.input());
        switch (choice)
        {
            case 1:
            System.out.println("Enter the role to be updated with :");
            String role=FutureBuilder.input();
            this.Update_Role(role);
            this.display_menu();
            break;
            case 2:
            System.out.println("Enter the package in lpa to be updated with :");
            int package_in_lpa=Integer.parseInt(FutureBuilder.input());
            this.Update_Package(package_in_lpa);
            this.display_menu();
            break;
            case 3:
            System.out.println("Enter the CGPA Criteria to be updated with :");
            float new_cgpa_criteria=Float.parseFloat(FutureBuilder.input());
            this.Update_CGPA_Criteria(new_cgpa_criteria);
            this.display_menu();
            break;
            case 4:
            this.Register_To_Institute_Drive();
            this.display_menu();
            break;
            case 5:
            Company_Query.display_menu();
            break;
            default:
            System.out.println("You have entered an incorrect input!! Please enter the correct input");
            this.display_menu();
        }
    }
    void Update_Role(String role)
    {
        this.role=role;
        System.out.println("Role Updated !!");
    }
    void Update_Package(int package_in_lpa)
    {
        this.package_lpa=package_in_lpa;
        System.out.println("Package Updated !!");
    }
    void Update_CGPA_Criteria(float new_cgpa_criteria)
    {
        this.cgpa_criteria=new_cgpa_criteria;
        System.out.println("CGPA Criteria Updated !!");
    }
    void Register_To_Institute_Drive()
    {
        IIITDPlacementCell.Company_Registrations.add(this);
        System.out.println("Company Registered !!");
    }
    void application_process()
    {
        for(int i=0;i<=this.applied_students.size();i++)
        {
            if(this.applied_students.get(i).status=="applied" || this.applied_students.get(i).status=="offered")
            {
               if(this.applied_students.get(i).cgpa>=this.cgpa_criteria && this.applied_students.get(i).current_held_package*3<=this.package_lpa)
               {
                    this.applied_students.get(i).previous_offer=this.applied_students.get(i).current_offer;
                    this.applied_students.get(i).current_offer=this;
                    this.applied_students.get(i).previous_held_package= this.applied_students.get(i).current_held_package;
                    this.applied_students.get(i).current_held_package=this.package_lpa;
                    this.applied_students.get(i).status="offered";
               }
            }
            else if(applied_students.get(i).status=="blocked" || applied_students.get(i).status=="placed")
            {
                applied_students.remove(applied_students.get(i));
                IIITDPlacementCell.Student_Registrations.remove(applied_students.get(i));
            }
        }
    }
}
class IIITDPlacementCell
{
    static String open_time_student,close_time_student,open_time_company,close_time_company;
    static int choice;
    static ArrayList<Company> Company_Registrations = new ArrayList<Company>();
    static ArrayList<Student> Student_Registrations = new ArrayList<Student>();
    static void display_menu()throws IOException
    {
        System.out.println("Welcome to IIITD Placement Cell\n\t1)Open Student Registrations\n\t2)Open Company Registrations\n\t3)Get Number of Student Registrations\n\t4) Get number of Company Registrations\n\t5) Get number of Offered/Unoffered/Bloacked Students\n\t6) Get Student Details\n\t7) Get Company Details\n\t8) Get Average Package\n\t9) Get Company Process Results\n\t10) Back");
        choice=Integer.parseInt(FutureBuilder.input());
        String name;
        int roll_no;
        switch(choice)
        {
            case 1:
            IIITDPlacementCell.Open_Student_Registrations();
            IIITDPlacementCell.display_menu(); 
            break;
            case 2:
            IIITDPlacementCell.Open_Company_Registrations();
            IIITDPlacementCell.display_menu(); 
            break;
            case 3:
            IIITDPlacementCell.Get_number_of_Student_Registrations();
            IIITDPlacementCell.display_menu(); 
            break;
            case 4:
            IIITDPlacementCell.Get_number_of_Company_Registrations();
            IIITDPlacementCell.display_menu(); 
            break;
            case 5:
            for(int i=0;i<Company_Registrations.size();i++)
            {
                Company_Registrations.get(i).application_process();
            }
            IIITDPlacementCell.Get_number_of_OfferedUnofferedBlockedStudents();
            IIITDPlacementCell.display_menu(); 
            break;
            case 6:
            for(int i=0;i<Company_Registrations.size();i++)
            {
                Company_Registrations.get(i).application_process();
            }
            System.out.println("Enter the name and Roll Number of the student");
            name=FutureBuilder.input();
            roll_no=Integer.parseInt(FutureBuilder.input());
            for(int i=0;i<Student_Registrations.size();i++)
            {
                if(Student_Registrations.get(i).roll_number==roll_no)
                {
                    IIITDPlacementCell.Get_Student_Details(Student_Registrations.get(i));
                }
            }

            IIITDPlacementCell.display_menu(); 
            break;
            case 7:
            for(int i=0;i<Company_Registrations.size();i++)
            {
                Company_Registrations.get(i).application_process();
            }
            System.out.println("Enter the name of the company");
            name=FutureBuilder.input();
            for(int i=0;i<Company_Registrations.size();i++)
            {
                if(Company_Registrations.get(i).name.toUpperCase()==name.toUpperCase())
                {
                    IIITDPlacementCell.Get_Company_Details(Company_Registrations.get(i));
                }
            }
            IIITDPlacementCell.display_menu(); 
            break;
            case 8:
            for(int i=0;i<Company_Registrations.size();i++)
            {
                Company_Registrations.get(i).application_process();
            }
            IIITDPlacementCell.Get_Average_Package();
            IIITDPlacementCell.display_menu(); 
            break;
            case 9:
            for(int i=0;i<Company_Registrations.size();i++)
            {
                Company_Registrations.get(i).application_process();
            }
            System.out.println("Enter the Company name :");
            name=FutureBuilder.input();
            for(int i=0;i<Company_Registrations.size();i++)
            {
                if(Company_Registrations.get(i).name.toUpperCase()==name.toUpperCase())
                {
                    IIITDPlacementCell.Get_Company_Process_Results(Company_Registrations.get(i));
                }
            }
            IIITDPlacementCell.display_menu(); 
            break;
            case 10:
            FutureBuilder.selection_mode();
            break;
            default:
            System.out.println("Invalid option !! Please select the correct option from 1-10");
            IIITDPlacementCell.display_menu();            
        }
    }
    static void Open_Student_Registrations()throws IOException
    {
        System.out.println("Fill in the details:-\n\t1) Set the Opening time for Student registrations\n\t2)Set the Closing time for Student registrations");
        open_time_student=FutureBuilder.input();
        close_time_student=FutureBuilder.input();
        System.out.println("Student Registration Opened");

    }
    static void Open_Company_Registrations()throws IOException
    {
        System.out.println("Fill in the details:-\n\t1) Set the Opening time for company registrations\n\t2)Set the Closing time for company registrations");
        open_time_company=FutureBuilder.input();
        close_time_company=FutureBuilder.input();
        System.out.println("Company Registration Opened");

    }
    static void Get_number_of_Student_Registrations()
    {
        System.out.println("Number of Students Registered ="+Student_Registrations.size());
    }
    static void Get_number_of_Company_Registrations()
    {
        System.out.println("Number of Company Registered ="+Company_Registrations.size());
    }
    static void Get_number_of_OfferedUnofferedBlockedStudents()
    {
        int no_of_offered_students=0, no_of_unoffered_students=0, no_of_blocked_students=0;
        for(int i=0;i<Student_Registrations.size();i++)
        {
            if(Student_Registrations.get(i).status=="blocked")
            {
                no_of_blocked_students++;
            }
            else if(Student_Registrations.get(i).status=="offered")
            {
                no_of_offered_students++;
            }
            else if(Student_Registrations.get(i).status=="applied")
            {
                no_of_unoffered_students++;
            }
        }
        System.out.println("No of offered students="+no_of_offered_students+"\nNo of Unoffered students="+no_of_unoffered_students+"\nNo of Blocked students="+no_of_blocked_students);
    }
    static void Get_Student_Details(Student student)
    {
        System.out.println("Name : "+student.name+"\nRoll Number : "+student.roll_number+"\nCGPA : "+student.cgpa+"\nBranch : "+student.branch+"\n");
    }
    static void Get_Company_Details(Company company)
    {
        System.out.println("Comapany Name : "+company.name+"\nRole Offered : "+company.role+"\nPackage(in LPA) : "+company.package_lpa+"\nCGPA requirement : "+company.cgpa_criteria+"\n");
    }
    static void Get_Average_Package()
    {
        int sum=0,no_of_students=0;
        float average;
        for(int i=0;i<Company_Registrations.size();i++)
        {
            sum+=Company_Registrations.get(i).package_lpa*Company_Registrations.get(i).selected_students.size();
            no_of_students+=Company_Registrations.get(i).selected_students.size();
        }
        average=sum/no_of_students;
        System.out.println("The average package is "+average);

    }
    static void Get_Company_Process_Results(Company company)
    {
        System.out.println("List of selected Students :");
        for(int i =0;i<company.selected_students.size();i++)
        {
            System.out.println("\t"+(i+1)+". "+company.selected_students.get(i));
        }
    }
}