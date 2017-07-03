/* 
 * Assignment: Some silly Matrix Rotator     *
 * Programmer: Baran Topal                   *
 * File name: Matrix.java 	                 *
 *                                           *      
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 *	                                                                                         *
 *  LICENSE: This source file is subject to have the protection of GNU General               *
 *	Public License. You can distribute the code freely but storing this license information. *
 *	Contact Baran Topal if you have any questions. barantopal@barantopal.com                 *
 *	                                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *  
 */

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;


public class Matrix {

	private static Scanner input;

	public static void rotate(int A[][], int degree) {
		int[][] tmp;
		tmp = new int[100][100];
		int row, column;
		switch (degree) {
		case 0:
			row = 0;
			column = 0;
			while (row < 100) {
				while (column < 100) {
					System.out.print(A[row][column++] + " ");
				}
				row++;
				System.out.print("\n");
			}
			break;

		case 90:
			row = 0;
			column = 0;
			while (row < 100) {
				while (column < 100) {
					tmp[row][column] = A[column][100 - row - 1];
					column++;
				}
				row++;
				column = 0;
			}

			row = 0;
			column = 0;
			while (row < 100) {
				while (column < 100) {
					System.out.print(tmp[row][column++] + " ");
				}
				row++;
				column = 0;
				System.out.print("\n");
			}

			break;

		case 180:
			row = 0;
			column = 0;
			while (row < 100) {
				while (column < 100) {
					tmp[row][column] = A[100 - row - 1][100 - column - 1];
					column++;
				}
				row++;
				column = 0;
			}
			row = 0;
			column = 0;

			while (row < 100) {
				while (column < 100) {
					System.out.print(tmp[row][column] + " ");
					column++;
				}
				row++;
				column = 0;
				System.out.print("\n");
			}
			break;

		case 270:
			row = 0;
			column = 0;
			while (row < 100) {
				while (column < 100) {
					tmp[row][column] = A[100 - column - 1][row];
					column++;

				}
				column = 0;
				row++;
			}
			row = 0;
			column = 0;
			while (row < 100) {
				while (column < 100) {

					System.out.print(tmp[row][column++] + " ");
				}
				row++;
				column = 0;
				System.out.print("\n");
			}
			break;
		}

	}

	public static void writeToFile(File file) {
		
		int[][]a = new int [100][100];			

		Writer output = null;
		try 
		{			
			output = new BufferedWriter(new FileWriter(file));

			for (int i = 0; i < 100; i++) 
			{
				for (int j = 0; j < 100; j++) 
				{
					a[i][j] = (int)(Math.random() * 100);	
					output.write(a[i][j]);
				}
			}			
		} 
		catch (Exception ex) 
		{
			System.out.println("There is an I/O problem while writing to the file");
		} finally
		{
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/* You can use this basic randomizer to populate data

	public static void writeToFile(File file)
	{
		try 
		{

			Writer output = null;
			output = new BufferedWriter(new FileWriter(file));
			Random r = new Random();

			for (int i = 0; i < 10000; i++) 

				output.write(r.nextInt(100) + " ");

		} catch (Exception ex) 
		{
			System.out.println("There is an I/O problem while writing to the file");
		}
	}
	 */

	public static void readFromFile(File file, int [][]A)
	{
		int row, column;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			for (row = 0; row < 100; row++)
			{
				for (column = 0; column < 100; column++)
				{
					A[row][column] = (int) dis.read();
				}
			}

		} catch (Exception ex) {
			System.out.println("There is an I/O problem while reading from the file");
		}
	}

	public static void main(String[] args) {
		int[][] A = new int[100][100];
		int degree;
		File file = new File("C:\\matrix.txt");

		writeToFile(file);
		readFromFile(file, A);

		input = new Scanner(System.in);

		System.out.print("Enter the value in degrees: ");

		degree = input.nextInt();
		rotate(A, degree);
	}
}
