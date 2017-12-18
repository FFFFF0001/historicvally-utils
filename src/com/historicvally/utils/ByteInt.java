package com.historicvally.utils;

public class ByteInt {

	public static int bytesToInt(byte[] b) {
	       int value= 0;
	       for (int i = 0; i < 4; i++) {
	           int shift= (4 - 1 - i) * 8;
	           value +=(b[i] & 0x000000FF) << shift;
	       }
	       return value;
	 }
	
	public static byte[] intToBytes(int num) {	         
		   byte[] b = new byte[4];
		   for (int i = 0; i < 4; i++) {
		    b[i] = (byte) (num >>> (24 - i * 8));
		   }
		   return b;
		}
	
	
}
