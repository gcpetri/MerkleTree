/***********************************************
** File:    FileIO.java
** Project: CSCE 314 Project, Fall 2020
** Author:  Nicholas Saldana & Gregory Petri
** Date:    11/21/2020
** Section: 501
** E-mail:  nsaldana@tamu.edu & gcpetri@tamu.edu
**
**   This file contains the FileIO class that can
**  read and write to files.
************************************************/

package MerkleTree;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileIO {
    
    public void ReadFileContent(MTree<Content> mt, String inputFile) {
        try {
            File file = new File(inputFile);
            Scanner scnr = new Scanner(file);
            String fromW;
            String toW;
            double amount;
            while (scnr.hasNextLine()) {
                fromW = scnr.nextLine();
                toW = scnr.nextLine();
                amount = Double.parseDouble(scnr.nextLine());
                if(fromW.equals("Transfer")) {
                	Transfer t = new Transfer(toW, amount);
                	mt.addLeaf(t);
                }
                else {
                	Transaction t = new Transaction(fromW, toW, amount);
                    mt.addLeaf(t);
                }
                
                if (scnr.hasNextLine())
                	scnr.nextLine();
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error with the input file occurred.");
            e.printStackTrace();
        }
    }
    // append transactions to a file
    public void WriteFileContent(Content t, String outputFile, Boolean WriteNewLine) {
    	
    	FileWriter fileWriter;
    	try {
    		fileWriter = new FileWriter(outputFile, true);
    		fileWriter.write(t.toString());
        	if (WriteNewLine)
        		fileWriter.write('\n');
        	System.out.println("Output file created: " + outputFile);
		} catch (IOException e) {
			System.out.println("An error with the output file occurred.");
			e.printStackTrace();
		}	
    }
    
}