using System;

namespace ConsoleApplicationTask
{
    class Employee
    {
        static int ObjectChecker=10 ;
        static Employee[] e = new Employee[ObjectChecker];
        static float Salary = 1000F;
        static int obejctcounter;
        static int ConstructorCunter;
      
        
        private Employee()
        {
            ConstructorCunter++;
        }
        public static Employee GetObject(int ObjectChecker)
        {
            if (obejctcounter < ObjectChecker && e[obejctcounter] != null)
            {
                obejctcounter++;
                Console.WriteLine(Employee.Salary + " " + obejctcounter + " " + ConstructorCunter);
                return e[obejctcounter];

            }

            else if (e[obejctcounter] == null)
            {
                while (obejctcounter <= ObjectChecker)
                {
                    e[obejctcounter] = new Employee();
                    obejctcounter++;
                }
                obejctcounter = 0;
                    
                Console.WriteLine(Employee.Salary + " " + obejctcounter + " " + ConstructorCunter);
                return e[obejctcounter];
            }
            else
            {
                obejctcounter = 0;
                Console.WriteLine(Employee.Salary + " " + obejctcounter + " " + ConstructorCunter);
                return e[obejctcounter];
            }


        }

        class Program
        {
            public static void Main()
            {
                Console.WriteLine("how many object you want to create");
           int    Number = int.Parse(Console.ReadLine());
                Number = Number - 1;
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


