package com.myfirstapp.sid;
import java.util.Hashtable;


public class DataStore {
	
	public Hashtable<Integer,String> original = new Hashtable<Integer,String>();
	public String labels [][] = new String [30][3];
	public String labels_small [][] = new String [30][3];
	public String labels_digits [][] = new String [15][3];
	
	//Data Set up for sid - alphabets & digits
	public void setValues()
	{		
		/** Input for the voice over **/
				original.put(1, "Eh");		original.put(27, "zero");
				original.put(2, "bee");		original.put(28, "1");
				original.put(3, "C");		original.put(29, "2");
				original.put(4, "D");		original.put(30, "3");
				original.put(5, "E");		original.put(31, "4");
				original.put(6, "F");		original.put(32, "5");
				original.put(7, "G");		original.put(33, "6");
				original.put(8, "H");		original.put(34, "7");
				original.put(9, "I");		original.put(35, "8");
				original.put(10,"J");		original.put(36, "9");		
				original.put(11, "K");	
				original.put(12, "L");	
				original.put(13, "M");	
				original.put(14, "N");	
				original.put(15, "O");	
				original.put(16, "P");	
				original.put(17, "Q");	
				original.put(18, "R");	
				original.put(19, "S");	
				original.put(20, "T");					
				original.put(21, "U");	
				original.put(22, "V");	
				original.put(23, "W");	
				original.put(24, "X");	
				original.put(25, "Y");	
				original.put(26, "Zed");	
				
		/** Input for the image resources **/		
				labels[0][0] = "a1";	labels[12][0] = "m1";	labels[24][0] = "y1";
				labels[0][1] = "a2";	labels[12][1] = "m2";	labels[24][1] = "y2";
				labels[1][0] = "b1";	labels[13][0] = "n1";	labels[25][0] = "z1";
				labels[1][1] = "b2";	labels[13][1] = "n2";	labels[25][1] = "z2";
				labels[2][0] = "c1";	labels[14][0] = "o1";
				labels[2][1] = "c2";	labels[14][1] = "o2";
				labels[3][0] = "d1";	labels[15][0] = "p1";
				labels[3][1] = "d2";	labels[15][1] = "p2";
				labels[4][0] = "e1";	labels[16][0] = "q1";
				labels[4][1] = "e2";	labels[16][1] = "q2";
				labels[5][0] = "f1";	labels[17][0] = "r1";
				labels[5][1] = "f2";	labels[17][1] = "r2";
				labels[6][0] = "g1";	labels[18][0] = "s1";
				labels[6][1] = "g2";	labels[18][1] = "s2";
				labels[7][0] = "h1";	labels[19][0] = "t1";
				labels[7][1] = "h2";	labels[19][1] = "t2";
				labels[8][0] = "i1";	labels[20][0] = "u1";
				labels[8][1] = "i2";	labels[20][1] = "u2";
				labels[9][0] = "j1";	labels[21][0] = "v1";
				labels[9][1] = "j2";	labels[21][1] = "v2";
				labels[10][0] = "k1";	labels[22][0] = "w1";
				labels[10][1] = "k2";	labels[22][1] = "w2";
				labels[11][0] = "l1";	labels[23][0] = "x1";
				labels[11][1] = "l2";	labels[23][1] = "x2";
				
				labels_small[0][0] = "sa1";	labels_small[12][0] = "sm1";	labels_small[24][0] = "sy1";
				labels_small[0][1] = "sa2";	labels_small[12][1] = "sm2";	labels_small[24][1] = "sy2";
				labels_small[1][0] = "sb1";	labels_small[13][0] = "sn1";	labels_small[25][0] = "sz1";
				labels_small[1][1] = "sb2";	labels_small[13][1] = "sn2";	labels_small[25][1] = "sz2";
				labels_small[2][0] = "sc1";	labels_small[14][0] = "so1";
				labels_small[2][1] = "sc2";	labels_small[14][1] = "so2";
				labels_small[3][0] = "sd1";	labels_small[15][0] = "sp1";
				labels_small[3][1] = "sd2";	labels_small[15][1] = "sp2";
				labels_small[4][0] = "se1";	labels_small[16][0] = "sq1";
				labels_small[4][1] = "se2";	labels_small[16][1] = "sq2";
				labels_small[5][0] = "sf1";	labels_small[17][0] = "sr1";
				labels_small[5][1] = "sf2";	labels_small[17][1] = "sr2";
				labels_small[6][0] = "sg1";	labels_small[18][0] = "ss1";
				labels_small[6][1] = "sg2";	labels_small[18][1] = "ss2";
				labels_small[7][0] = "sh1";	labels_small[19][0] = "st1";
				labels_small[7][1] = "sh2";	labels_small[19][1] = "st2";
				labels_small[8][0] = "si1";	labels_small[20][0] = "su1";
				labels_small[8][1] = "si2";	labels_small[20][1] = "su2";
				labels_small[9][0] = "sj1";	labels_small[21][0] = "sv1";
				labels_small[9][1] = "sj2";	labels_small[21][1] = "sv2";
				labels_small[10][0] = "sk1";	labels_small[22][0] = "sw1";
				labels_small[10][1] = "sk2";	labels_small[22][1] = "sw2";
				labels_small[11][0] = "sl1";	labels_small[23][0] = "sx1";
				labels_small[11][1] = "sl2";	labels_small[23][1] = "sx2";
				
				labels_digits[0][0] = "dn0";
				labels_digits[0][1] = "dn0";
				labels_digits[1][0] = "d11";
				labels_digits[1][1] = "d12";
				labels_digits[2][0] = "d21";
				labels_digits[2][1] = "d22";
				labels_digits[3][0] = "d31";
				labels_digits[3][1] = "d32";
				labels_digits[4][0] = "d41";
				labels_digits[4][1] = "d42";
				labels_digits[5][0] = "d51";
				labels_digits[5][1] = "d52";
				labels_digits[6][0] = "d61";
				labels_digits[6][1] = "d62";
				labels_digits[7][0] = "d71";
				labels_digits[7][1] = "d72";
				labels_digits[8][0] = "d81";
				labels_digits[8][1] = "d82";
				labels_digits[9][0] = "d91";
				labels_digits[9][1] = "d92";
				
	}
	

}
