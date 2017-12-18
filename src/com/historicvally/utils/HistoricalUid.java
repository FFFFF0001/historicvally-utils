package com.historicvally.utils;


import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Historical valley  E-mail:sslkiss7@gmail.com
 * @version 1.0
 * @date Create Time：2017/12/9 12:09
 * @parameter
 * @return
 * @since 
 */

public class HistoricalUid {

    private static AtomicInteger atomic = new AtomicInteger(0);

    /**根据用户自定义的应用前缀获取唯一的一个字节数组。*/
    public  static  byte []  getbytes(String prefix) throws UnsupportedEncodingException {
         String prefixS=prefix+"%";
         if(prefix.substring(prefix.length()-1,prefix.length()).equals("%")){
             prefixS=prefixS+"%";
         };

            byte[] prefixbytes=  prefixS.getBytes("UTF-8");
            byte []  newBytes=	new byte[12+prefixbytes.length  ];
            System.arraycopy(prefixbytes,0,newBytes,0,prefixbytes.length);
            System.arraycopy(ByteLong.getByte(System.currentTimeMillis()),0,newBytes,prefixbytes.length,
                    8);
            System.arraycopy(ByteInt.intToBytes(atomic.incrementAndGet()),0,newBytes,prefixbytes.length+8,
                    4);
         //应用标识+时间+递增i   4字节标识，8字节时间，4字节递增i   16字节

         return newBytes;

 }

    public  static  String getBase64Strng(String prefix) throws UnsupportedEncodingException {
             byte[]  b=getbytes(  prefix);
             return  Base64.getEncoder().encodeToString(b);
    }


    public  static  byte []  getbytes(byte[] prefix) throws UnsupportedEncodingException {
        byte [] prefixbytes=null;
        if(prefix[prefix.length-1]==37){
            prefixbytes=new byte[prefix.length+2];
            System.arraycopy(prefix,0,prefixbytes,0,prefix.length);
            prefixbytes[prefix.length]=37;
            prefixbytes[prefix.length+1]=37;
        }else{
            prefixbytes=new byte[prefix.length+1];
            System.arraycopy(prefix,0,prefixbytes,0,prefix.length);
            prefixbytes[prefix.length]=37;
        }

        byte []  newBytes=	new byte[12+prefixbytes.length  ];
        System.arraycopy(prefixbytes,0,newBytes,0,prefixbytes.length);
        System.arraycopy(ByteLong.getByte(System.currentTimeMillis()),0,newBytes,prefixbytes.length,
                8);
        System.arraycopy(ByteInt.intToBytes(atomic.incrementAndGet()),0,newBytes,prefixbytes.length+8,
                4);
        return newBytes;

    }

    /**根据用户自定义的应用前缀获取唯一的一个Base64字符串。*/
    public  static  String getBase64String(byte[] prefix) throws UnsupportedEncodingException {
        byte[]  b=getbytes(  prefix);
        return  Base64.getEncoder().encodeToString(b);
    }




}
