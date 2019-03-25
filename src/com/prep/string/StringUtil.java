package com.prep.string;

import java.util.Arrays;

public final class StringUtil {

	private StringUtil() {
		
	}
	public static boolean hasUniqueChars(String input)
	{
		if(input==null || input.isEmpty())
			throw new IllegalStateException("input is null");
		boolean [] temp = new boolean [256];
		for(int i =0; i<input.length();i++)
		{
			int c = input.charAt(i);
			if(temp[c]==true)
				return false;
			temp[c]=true;
						
		}
		return true;
	}
	
	/**
	 * This method checks if one string is a permutation of other.
	 * This is case sensitive. if {@code s1} is god and {@code s2} is God
	 * then method should return false. 
	 * Method should also not ignore white spaces. e.g. if {@code s1} is "God    "
	 * and {@code s2} is "   dog" then method should return false
	 * 
	 * 
	 * 
	 * 
	 * @param s1  first string parameter
	 * @param s2  second string parameter
	 * @return
	 */
	// First approach. More clean but less efficient.
	public static boolean permutation(String s1, String s2) {
		
		if(s1.length()!=s2.length())
			return false;
		
		return sort(s1).equals(sort(s2));
		
	}
	
	
// Second approach.
	/**
	 * 
	 * only deals with ASCII char set 
	 * 
	 * @param s1
	 * @param s2
	 * @return true if s1 is permutation of s2
	 * @throws NullPointerException if either s1 or s2 is null.
	 */
public static boolean permutationNextGen(String s1, String s2)
{
	if(s1==null || s2==null)
		throw new NullPointerException("input is null.");
	
	if(s1.length()!=s2.length())
		return false;
	int [] temp = new int[256];
	for(char c : s1.toCharArray())	
		temp[c]++;

	for(char c: s2.toCharArray())
		if(--temp[c] < 0)
			return false;
	/*for(int i: temp)
		if(i <0)
			return false;*/
	return true;
	
	
	
	
}
	private static String sort(String s)
	{
		char [] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}
	
	
	public static String compressedString(String input )
	{
		
		if(input==null || input.isEmpty())
			return input;
		
		int count=1;
		char prev = input.charAt(0);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<input.length();i++)
		{
			char c = input.charAt(i);
			if(c==prev)
			{
				count++;
				
			}else {
				sb.append(prev).append(count);
				prev=c;
				count=1;
				
			}
		}
		
		return sb.append(prev).append(count).toString();
		
		
	}
	
	
	public static int countCompression(String input) {
		
		if(input==null || input.isEmpty())
			return 0;
		int count=1;
		char prev = input.charAt(0);
		int size=0;
		
		for(int i =1; i<input.length(); i++)
		{
			char c = input.charAt(i);
			if(c== prev)
			{
				count++;
			}else {
				
				size= size+1+String.valueOf(count).length();
				prev=c;
				 count=1;
			}
			
		}
		
		size= size+1+String.valueOf(count).length();
		return size;
		
	}
}
