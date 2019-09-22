using System;

namespace ConsoleApplicationTask
{
    class Employee
    {
        static Employee e1 = null;
        static float salary = 1000F;
        static int counter;
        static int number = 0;
        private Employee(int id)
        {
            Employee.counter = id;
            number++;
        }
        public static Employee getsalary()
        {
            if (Employee.counter == 0 && e1 == null)
            {
                Employee E1 = new Employee(0);
                Console.WriteLine(Employee.salary + " " + counter + " " + number);
                counter++;
                return e1;
            }
            else
            {
                Console.WriteLine(Employee.salary + " " + counter + " " + number);
                return e1;
            }


        }
        class Program
        {
            public static void Main()
            {
                Employee.getsalary();
                Employee.getsalary();
                Employee.getsalary();
                Employee.getsalary();

            }

        }
    }
}

