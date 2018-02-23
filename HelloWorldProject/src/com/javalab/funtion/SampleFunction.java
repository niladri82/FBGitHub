package com.javalab.funtion;

public class SampleFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fibbonacci f1 = new Fibbonacci();
		System.out.print(" "+ f1.FibboSeries(5));
	}

}

class Fibbonacci {
	
	int FibboSeries(int count){
		int n1=0,n2=1,n3=0,i,max=count; 	
		for(i=0;i<max;++i) 
		 {    
		  n3=n1+n2;    
 		  System.out.print(" "+n3);    
		  n1=n2;    
		  n2=n3;    
		 } 
	
 	return n3+n1;	
	}
	
}