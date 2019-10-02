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
                rootnode =new node( initial);

            }
            public void add(int value)
            {
                if (rootnode== null)
                {
                    
                    rootnode =  new node(value);
                 
                    return;
                }
                node CurrentNode = rootnode;
                bool added = false;

                do
                {
                    if (value<CurrentNode.value)
                    {
                        if (CurrentNode.left == null)
                        {
                            CurrentNode.left= new node(value);
                             
                            added = true;
                        }
                        else
                            CurrentNode = CurrentNode.left;
                    }

                    if (value >= CurrentNode.value)
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
            class Program
            {
                public static void Main()
                {
                    BST tree = new BST();
                    tree.add(7);
                    tree.add(6);
                    tree.add(4);
                    tree.add(1);
                    tree.add(9);
                    tree.add(15);
                    tree.add(17);
                }
            } 
        }
    }
}



