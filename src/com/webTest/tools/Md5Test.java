package com.webTest.tools;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component("md5Test")
public class Md5Test {
  
  public String toMD5(String plainText) {
	  StringBuffer buf=new StringBuffer("");
   try {
    //����ʵ��ָ��ժҪ�㷨�� MessageDigest ����
    MessageDigest md = MessageDigest.getInstance("MD5"); 
    //ʹ��ָ�����ֽ��������ժҪ��
    md.update(plainText.getBytes());
    //ͨ��ִ���������֮������ղ�����ɹ�ϣ���㡣
    byte b[] = md.digest();
    //���ɾ����md5���뵽buf����
    int i;
    for (int offset = 0; offset < b.length; offset++) {
     i = b[offset];
     if (i < 0)
      i += 256;
     if (i < 16)
      buf.append("0");
     buf.append(Integer.toHexString(i));
    }
    //System.out.println("32λ: " + buf.toString());// 32λ�ļ���
    //System.out.println("16λ: " + buf.toString().substring(8, 24));// 16λ�ļ��ܣ���ʵ����32λ���ܺ�Ľ�ȡ
    
   } 
   catch (Exception e) {
    e.printStackTrace();
   }
   return buf.toString();
  }
  
  public static void main(String agrs[]) {
    new Md5Test().toMD5("1234");//����LXD
  }
}