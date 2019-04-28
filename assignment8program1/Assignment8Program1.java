/*
 * By:     Matthew Fischer
 * Date:   04/05/2019
 */
package assignment8program1;


public class Assignment8Program1 {

    

    public static void main(String[] args) {
        // task 1: create a tree
        Tree testTree = new Tree();

        // task 2: add node
        testTree.addNode(7);
        testTree.addNode(5);
        testTree.addNode(3);
        testTree.addNode(1);
        testTree.addNode(9);
        testTree.addNode(11);
        testTree.addNode(2);
        testTree.addNode(4);

        // task 3: display in order traversal of nodes
        System.out.print("Display order: ");
        testTree.displayInOrder();
        System.out.println("\nThe number of Nodes in this tree is: " 
                + testTree.displayCount());
        System.out.println("Number of single parent nodes is : " 
                + testTree.displayParents());
    }
}
/*
----------- Build 1 ----------------
run:
Display order: 123457911
The number of Nodes in this tree is: 8
Number of single parent nodes is : 3
BUILD SUCCESSFUL (total time: 0 seconds)
------------------------------------------
*/
