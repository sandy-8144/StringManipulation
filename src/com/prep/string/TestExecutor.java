package com.prep.string;

public class TestExecutor {

	public static void main (String [] args)
	{
		StringBuffer sb = new StringBuffer();
		String s = null;
		sb.append("sandeep");
		sb.append(s);
		System.out.println(sb);
		
	    System.out.println(StringUtil.hasUniqueChars("d0vfgep"));
	    System.out.println(StringUtil.permutationNextGen("abcde", "adceb"));
		System.out.println(StringUtil.compressedString("aaacdefggg"));
		System.out.println(StringUtil.countCompression("aaacdefggg"));
		
	}
}
