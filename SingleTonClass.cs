using System;

namespace ConsoleApplicationTask
{ 
   public class employee
    {
        static float gravity;
       static int counter;
       private employee(int id)
        {
            employee.gravity = 9.8F;
            employee.counter= id;

        }
  public  static float getgravity()
        {
            if (employee.counter == 0)
            {
                employee E1 = new employee(0);
                Console.WriteLine(employee.gravity );
                counter++;
                return employee.gravity;
                

            }
            else
            {
                Console.WriteLine(employee.gravity  +" " + counter);
               
                return employee.gravity;
               
            }

        }

    }
        class Program
        {
            public static void Main()
            {
                employee.getgravity();

                employee.getgravity();
                employee.getgravity();
                employee.getgravity();

            }

        }
    }

