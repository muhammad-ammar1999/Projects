using System;

namespace ConsoleApplicationTask
{
    class program
    {
        public static void Main()
        {
            int FirstNumber=0, Sum = 0,SecondNumber = 1;
            Console.WriteLine("inter your range for FS");
            int Range = int.Parse(Console.ReadLine());
                  Console.Write("{0},   ", Sum);
            for (int i = 0; i < Range; i++)
            {
                FirstNumber = SecondNumber;
                SecondNumber = Sum;

                Sum = FirstNumber + SecondNumber;  
                Console.Write("{0},    ", Sum);
            }
        }
    }
}