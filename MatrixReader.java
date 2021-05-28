package com.company;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// Erika, gitlab test
public class MatrixReader {
    public SparseMatrix read(String file){
        try {
            File matrixFile = new File(file);
            Scanner readFile = new Scanner(matrixFile);

            int numberRows = Integer.parseInt(readFile.next());
            int numberColumns = Integer.parseInt(readFile.next());
            SparseMatrix sparseMatrix = new SparseMatrix(numberRows,numberColumns);

            int rowCounter = 1;

            while(readFile.hasNextLine()){
                String [] spaceArray = readFile.nextLine().split(" ");

                for(int i = 0; i < spaceArray.length; i++){
                    String [] commaArray = spaceArray[i].split(",");

                    if(commaArray[0].equals("") || commaArray[commaArray.length-1].equals("")){
                        break;
                    }

                    int column = Integer.parseInt(commaArray[0]);
                    int value = Integer.parseInt(commaArray[commaArray.length-1]);

                    sparseMatrix.insert(rowCounter, column, value);

                    rowCounter++;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found. ");
        }

        return null;
    }
}


