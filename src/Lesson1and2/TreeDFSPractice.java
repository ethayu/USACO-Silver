package Lesson1and2;
import java.util.*;

public class TreeDFSPractice {

    static class Node {
        Node left, right;
        int value;
        Node(int a) {value = a;}

        int getDepth() {
            int l = 0, r = 0;
            if (left != null) l = left.getDepth();
            if (right != null) r = left.getDepth();
            return 1 + Math.max(l, r);
        }

        boolean hasSum(int sum) {
            if (left != null) {
                if (left.hasSum(sum - value)) return true;
            }
            if (right != null) {
                if (right.hasSum(sum - value)) return true;
            }
            return value == sum;
        }

        boolean dfs(int num) {
            System.out.println(value);
            boolean leftb = false, rightb = false;
            if (num == value) return true;
            if (left != null) {
                leftb = left.dfs(num);
            }
            if (right != null) {
                rightb = right.dfs(num);
            }
            return (leftb || rightb);
        }
    }

    public static void main (String[] args) {

        Node n1 = new Node(5);
        Node n2 = new Node(4);
        Node n3 = new Node(8);
        Node n4 = new Node(11);
        Node n5 = new Node(13);
        Node n6 = new Node(4);
        Node n7 = new Node(7);
        Node n8 = new Node(2);
        Node n9 = new Node(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;

        System.out.println(n1.hasSum(30));

    }

}
