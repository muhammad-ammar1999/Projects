using System;

namespace ConsoleApplicationTask
{
    class node
    {
        public int value;
        public node left;
        public node right;
        public node(int initial)
        {
            value = initial;
            left = null;
            right = null;
        }
        class BST
        {
            node rootnode;
            public BST()
            {
                rootnode = null;

            }
            public BST(int initial)
            {
                rootnode = new node(initial);

            }
            public void add(int value)
            {
                if (rootnode == null)
                {

                    rootnode = new node(value);

                    return;
                }
                node CurrentNode = rootnode;
                bool added = false;

                do
                {
                    if (CurrentNode.value > value)
                    {
                        if (CurrentNode.left == null)
                        {
                            CurrentNode.left = new node(value);

                            added = true;
                        }
                        else
                            CurrentNode = CurrentNode.left;
                    }

                    if (CurrentNode.value <= value)
                    {
                        if (CurrentNode.right == null)
                        {
                            CurrentNode.right = new node(value);

                            added = true;
                        }
                        else
                            CurrentNode = CurrentNode.right;
                    }
                } while (!added);
            }
            public void Search(int value)
            {
                if (rootnode.value == value)
                {
                    Console.WriteLine("value = {0} found", value);

                    return;
                }
                node CurrentNode = rootnode;
                bool added = false;

                do
                {
                    if (CurrentNode.value > value)
                    {
                        if (CurrentNode.left.value == value)
                        {
                            Console.WriteLine("value = {0} found", value);
                            added = true;

                            return;

                        }
                        else
                            CurrentNode = CurrentNode.left;
                    }

                    if (CurrentNode.value <= value)
                    {
                        if (CurrentNode.right.value == value)
                        {
                            Console.WriteLine("value = {0} found", value);
                            added = true;

                            return;
                        }
                        else
                            CurrentNode = CurrentNode.right;
                    }
                } while (!added);
            }
            public void print(node N, ref string s)
            {
                if (N == null)
                    N = rootnode;
                if (N.left != null)
                {
                    print(N.left, ref s);

                    s = s + N.value.ToString().PadLeft(3);
                }
                else
                    s = s + N.value.ToString().PadLeft(3);
                if (N.right != null)
                    print(N.left, ref s);
            }

            class Program
            {
                public static void Main()
                {
                    string input = "";
                    BST tree = new BST();
                    tree.add(7);
                    tree.add(6);
                    tree.add(4);
                    tree.add(1);
                    tree.add(9);
                    tree.add(15);
                    tree.add(17);
                    tree.add(8);
                    tree.add(12);
                    tree.add(412);
                    tree.add(1111);
                    tree.add(989);
                    tree.add(152);
                    tree.add(171);

                    tree.print(null, ref input);

                    tree.Search(412);
                    tree.Search(7);
                    tree.Search(152);
                }
            }
        }
    }
}



