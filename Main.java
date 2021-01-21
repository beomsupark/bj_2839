import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Main

        {
			public static char[][] temp_list= new char[8][8];
			public static void main(String[] args)
			{
				BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
				String[] a;
				for(int i=0;i<8;i++)
				{
					for(int j=0;j<8;j++)
					{
						if(i%2==0)
						{
						if(((8*i)+j)%2==0)
						{
							temp_list[i][j]= 'B';
						}
						else
						{
							temp_list[i][j]= 'W';
						}
						}
						else
						{
							if(((8*i)+j)%2==0)
							{
								temp_list[i][j]= 'W';
							}
							else
							{
								temp_list[i][j]= 'B';
							}
						}
						//System.out.print(temp_list[i][j]);
					}
					//System.out.println();
				}
				try {
					a = bf.readLine().split(" ");
					int y = Integer.parseInt(a[0]);
					int x = Integer.parseInt(a[1]);
					char[][] list = new char[y][x];	
					for(int i=0;i<y;i++)
					{
						String temp_a = bf.readLine();
						char[] temp = temp_a.toCharArray();
						for(int j=0;j<x;j++)
						{
							list[i][j]= temp[j];
						}
					}
					int min = Integer.MAX_VALUE;
					for(int i=0;i<y-7;i++)
					{
						for(int j=0;j<x-7;j++)
						{
							int num = check(list,i,j);
							if(min>num)
							{
								min=num;
							}
						}
					}
					System.out.println(min);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			public static int check(char[][] list, int y,int x)
			{
				int num=0;
				for(int i=0;i<8;i++)
				{
					for(int j=0;j<8;j++)
					{
						if(temp_list[i][j]!=list[y+i][x+j])
						{
							num++;
						}
					}
				}
				//System.out.println(num);
				if(num>32)
				{
					num=64-num;
				}
				//System.out.println(num);
				return num;
			}
        }