/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Map<Character, List<Character>> keyPadMap = new HashMap<>();
		keyPadMap.put('A', Arrays.asList('L', 'H'));
        keyPadMap.put('B', Arrays.asList('K', 'M', 'I'));
        keyPadMap.put('C', Arrays.asList('F', 'N', 'L', 'J'));
        keyPadMap.put('D', Arrays.asList('M', 'O', 'G'));
        keyPadMap.put('E', Arrays.asList('H', 'N'));
        keyPadMap.put('F', Arrays.asList('C', 'M', '1'));
        keyPadMap.put('G', Arrays.asList('D', 'N', '2'));
        keyPadMap.put('H', Arrays.asList('A', 'E', 'K', 'O', '1', '3'));
        keyPadMap.put('I', Arrays.asList('B', 'L', '2'));
        keyPadMap.put('J', Arrays.asList('C', 'M', '3'));
        keyPadMap.put('K', Arrays.asList('B', 'H', '2'));
        keyPadMap.put('L', Arrays.asList('A', 'C', 'I', '3'));
        keyPadMap.put('M', Arrays.asList('B', 'D', 'F', 'J'));
        keyPadMap.put('N', Arrays.asList('C', 'E', 'G', '1'));
        keyPadMap.put('O', Arrays.asList('D', 'H', '2'));
        keyPadMap.put('1', Arrays.asList('F', 'H', 'N'));
        keyPadMap.put('2', Arrays.asList('K', 'G', 'I', 'O'));
        keyPadMap.put('3', Arrays.asList('L', 'H', 'J'));

    char start = 'A';

    int length = 4;
    int count = getCountCombi(keyPadMap, length-1, start);
    System.out.println("Total combi: " + count);

  }
  
 public static int getCountCombi(Map<Character, List<Character>> map, int length, Character key) {

    int count = 0;
    int vowels = 0;
    if ( key == 'A' || key == 'I' || key == 'E' || key == 'U')
    {
        vowels = 1;
    }
    count = findCombinations(key, map, length, vowels);

    return count;
  }

 public static int findCombinations(Character val, Map<Character, List<Character>> map, int length, int vowels) {

    if (length == 0) {
      return 0;
    }

    if (length == 1){
        return map.get(val).size();
    }
    
    int sum = 0;
    
    //if (map.containsKey(val)) {
      for (Character next : map.get(val)) {
        //sum += map.get(next).size();
        if (next == 'A' || next == 'I' || next == 'E' || next == 'U')
        {
            vowels += 1;
        }
        System.out.println(vowels);
        if (next != 'A' && next != 'I' && next != 'E' && next == 'U' && vowels >=2 )
        {
            sum += findCombinations(next, map, length - 1, vowels);
        }
        else 
        {
            //sum += findCombinations(next, map, length - 1, vowels);
        }
      }
    //}
    return sum;
  }
    
}
