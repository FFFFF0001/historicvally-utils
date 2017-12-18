package com.historicvally.utils;

public class ByteLong {

	public static byte[] getByte( long x) { 
		byte[] bb=new byte[8] ;
        bb[ 0] = (byte) (x >> 56); 
        bb[ 1] = (byte) (x >> 48); 
        bb[ 2] = (byte) (x >> 40); 
        bb[ 3] = (byte) (x >> 32); 
        bb[ 4] = (byte) (x >> 24); 
        bb[ 5] = (byte) (x >> 16); 
        bb[ 6] = (byte) (x >> 8); 
        bb[ 7] = (byte) (x >> 0); 
        return bb;
  } 

 public static long getLong(byte[] bb) { 
       return ((((long) bb[ 0] & 0xff) << 56) 
               | (((long) bb[ 1] & 0xff) << 48) 
               | (((long) bb[ 2] & 0xff) << 40) 
               | (((long) bb[ 3] & 0xff) << 32) 
               | (((long) bb[ 4] & 0xff) << 24) 
               | (((long) bb[ 5] & 0xff) << 16) 
               | (((long) bb[ 6] & 0xff) << 8) | (((long) bb[ 7] & 0xff) << 0)); 
  } 
	
	
}
