package com.sp;

import java.util.ArrayList;

/**
 * You are given a string S consisting of letters 'a' and/or 'b'. A block is a
 * consecutive fragment of S composed of the same letters and surrounded by
 * different letters or string endings. For example, S = "abbabbaaa" has five
 * blocks: "a", "bb", "a", "bb" and "aaa". NI function solution(s); that, given
 * a string S of length N, returns the minimum number of additional letters
 * needed to obtain a string containing blocks of equal lengths. Examples: 1.
 * Given S = "babaa", the function should return 3. There are four blocks: "b",
 * "a", "b", "aa". One letter each should be added to the first, second and
 * third blocks, therefore obtaining a string "bbaabbaa", in which every block
 * is of equal length. 2. Given S="bbbab", the function should return 4. Two
 * letters each should be added to the second and third blocks, therefore
 * obtaining a string "bbbaaabbb", in which every block is of equal length. 3.
 * Given S = "bbbaaabbb", the function should return 0. All blocks are already
 * of equal lengths. Write an efficient algorithm for the following assumptions:
 * Test Output • Nis an integer within the range [1..40,000); • string S
 * consists only of the characters "a" and/or "b". 
 * 
 * @author Shyam
 *
 */
public class MaximumNumberOfAdditionLetterRequired {

	public static void main(String[] args) {
		String s = "bbbaaabbb";
		String s1 = "bbbab";
		String s2 = "babaa";
		
		solution(s);
		solution(s1);
		solution(s2);
	}

	static int solution(String S) {
		int n = S.length();
		int countA=0, countB=0;
		int maxA=0, maxB=0;
		int highestCount=0;
		int result=0;
		ArrayList<CharAndCount> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			if(S.charAt(i) == 'b') {
				if(countA != 0) {
					list.add(new CharAndCount(countA, 'a'));
				}
				countA=0;
				
			}else {
				countA++;
				maxA=Math.max(maxA, countA);
				if(i ==(n-1)) {
					list.add(new CharAndCount(countA, 'a'));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if(S.charAt(i) == 'a') {
				if(countB != 0) {
					list.add(new CharAndCount(countB, 'b'));
				}
				countB=0;
				
			}else {
				countB++;
				maxB=Math.max(maxB, countB);
				if(i ==(n-1)) {
					list.add(new CharAndCount(countB, 'b'));
				}
			}
		}
		
		System.out.println("list: "+list);
		
		if(maxA>=maxB) {
			highestCount=maxA;
		}else {
			highestCount=maxB;
		}
		System.out.println("highestCount: "+highestCount);

		for (CharAndCount charAndCount : list) {
			int chCount=charAndCount.getCount();
			if(chCount != highestCount){
				result+=(highestCount-chCount);
			}
		}
		System.out.println("result:"+result);
		return result;
	}

}
class CharAndCount{
	int count;
	char ch;
	
	public CharAndCount(int count, char ch) {
		this.count= count;
		this.ch=ch;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	@Override
	public String toString() {
		return "CharAndCount [count=" + count + ", ch=" + ch + "]";
	}
	
	
}
