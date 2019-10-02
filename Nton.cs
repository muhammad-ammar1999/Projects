using System;

namespace ConsoleApplicationTask
{
    class Employee
    {
        static int ObjectChecker;
        static Employee[] list = new Employee[ObjectChecker];
        static float Salary = 1000F;
        static int obejctcounter;
        static int ConstructorCounter;
      
        
        private Employee()
        {
            ConstructorCounter++;
        }
        public static Employee GetObject(int ObjectChecker)
        {
            if (obejctcounter < ObjectChecker && list[obejctcounter] != null)
            {
                obejctcounter++;
                Console.WriteLine(Employee.Salary + " " + obejctcounter + " " + ConstructorCounter);
                return list[obejctcounter];

            }

            else if (list[obejctcounter] == null)
            {
                while (obejctcounter <= ObjectChecker)
                {
                    list[obejctcounter] = new Employee();
                    obejctcounter++;
                }
                obejctcounter = 0;
                    
                Console.WriteLine(Employee.Salary + " " + obejctcounter + " " + ConstructorCounter);
                return list[obejctcounter];
            }
            else
            {
                obejctcounter = 0;
                Console.WriteLine(Employee.Salary + " " + obejctcounter + " " + ConstructorCounter);
                return list[obejctcounter];
            }


        }

        class Program
        {
            public static void Main()
            {
                Console.WriteLine("how many object you want to create");
           int    Number = int.Parse(Console.ReadLine());
                Number = Number - 1;
                ObjectChecker = Number;
                Employee.GetObject(Number);
                Employee.GetObject(Number);
                Employee.GetObject(Number);
                Employee.GetObject(Number);
                Employee.GetObject(Number);
                Employee.GetObject(Number);
                Employee.GetObject(Number);
               Employee.GetObject(Number);

               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);

               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);

               Employee.GetObject(Number);
               Employee.GetObject(Number);
               Employee.GetObject(Number);

            }
        }
    }
}


