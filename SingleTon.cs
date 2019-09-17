using System;

namespace ConsoleApplicationTask
{
    class gravity 
    {
        public static float _Gravity ;
        static gravity()
        {
            gravity._Gravity = 9.8F;

        }
        static float print (float g)
    {
        return g;
    }

    }
    class Program
    {
      public static void Main()
        {
            Console.WriteLine("value of g = {0}",gravity._Gravity); 

        }
       
    }
}
     

