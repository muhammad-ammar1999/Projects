using System;
namespace ConsoleApplicationTask
{
    class force
    {
        static float g;
        float Mass;

        public float G
        {
            get;
            set;
        }
        static force()
        {
            force.g = 9.8F;
        }

        public float GravitationalForce
        {
            set
            {
                if (value < 0)
                {
                    throw new Exception("mass can not be negitive");
                }
                else
                    this.Mass = value;
            }
            get
            {
                return this.Mass * force.g;

            }

        }

        class Program
        {
            public static void Main()
            {
                force F1 = new force();
                F1.GravitationalForce=100;
                Console.WriteLine(F1.GravitationalForce);
                F1.G = 6.68F;
                Console.WriteLine(F1.G);
            }

        }
    }
}

