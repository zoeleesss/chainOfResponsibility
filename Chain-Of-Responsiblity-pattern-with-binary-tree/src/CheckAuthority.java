/**
 * Created by sss on 25/12/2017.
 */

import java.io.*;

import request.*;
import binaryTree.*;


class CheckAuthority {

    public static void main(String[] args) {
        BinaryTree temp=new BinaryTree();

        temp.init();

        try {
            while (true) {
                System.out.println("Enter the amount to check who should approve your expenditure.");
                System.out.print(">");
                double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());

                temp.getHead().processRequest(new PurchaseRequest(d, "General"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
}