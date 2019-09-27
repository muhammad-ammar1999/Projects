using System;

namespace ConsoleApplicationTask
{
    class employee
    {
        public string Name;
        public string Qualification;
        public virtual void EmployeeDetails()
        {
            Console.Write(" employee class details  ");
            Console.WriteLine(Name + " " + Qualification );
            Console.WriteLine();
        }

    }
    class FullTime : employee
    {
        public int salary;
        public override  void EmployeeDetails()
        {
            Console.Write(" FullTime employee class details  ");
            Console.WriteLine(Name + " " + Qualification + " " + salary);
            Console.WriteLine();
        }
    }
    class PartTime : employee
    {
        public  int HourlyRate;
        public override void EmployeeDetails()
        {
            Console.Write(" partTime employee class details   ");
            Console.WriteLine(Name + " " + Qualification + " " + HourlyRate);
        }
    }
    class Program
    {
        public static void Main()
        {
            employee FTE = new FullTime();
           //FTE.salary = 1000000;
            FTE.Name = "Ammar";
            FTE.Qualification = "Masters";

            FTE.EmployeeDetails();

            employee PTE = new PartTime();
            //PTE.HourlyRate = 1000;
            PTE.Name = "Ahmed";
            PTE.Qualification = "Intermidiate";

            PTE.EmployeeDetails();
        }

    }
}

