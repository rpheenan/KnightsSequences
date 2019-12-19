//Ryan Heenan
import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	//Initialize maps: keys are symbol on keypad, Array is all possible next moves (knight constraint)
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
     
    //Array of all possible start values
    char start[] = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','1','2','3'};

    //Length of sequence
    int length = 10;

    //Find final result
    int total = 0;
    for(int i = 0; i < start.length; i++)
        {
        total += knightSequences(keyPadMap, length-1, start[i]);
        }
    System.out.println("Total sequence number = " + total);
  }

//Function to begin Calculations
public static int knightSequences(Map<Character, List<Character>> map, int length, Character key)
    {
    int count = 0;
    int vowels = 0;
    //Find out if sequence begins with a vowel
    if(key == 'A' || key == 'E' || key == 'I' || key == 'O')
    {
        vowels = 1;
    }
    //Call Recursive functon
    count = knightSequences(key, map, length, vowels);
    return count;
  }

//Recursive Function
 public static int knightSequences(Character val, Map<Character, List<Character>> map, int length, int vowels) {
    //Sequence with length of 0
    if (length == 0) 
    {
      return 0;
    }
    
    //End sequence if over two vowels are in it
    if (vowels > 2)
    {
        return 0;
    }
    
    //Calculate end of sequence and whether or not it is valid
    int count = 0;
    if (length == 1)
    {
        //If vowels are not near max of 2, return all possible sequences
        if (vowels != 2)
        {
            return map.get(val).size();
        }
        else
        {
            //This checks special case where 3rd vowel is last character in sequence and does not count these sequences
            for(int i = 0; i < map.get(val).size(); i++)
            {
                if(map.get(val).get(i) != 'A' && map.get(val).get(i) != 'E' && map.get(val).get(i) != 'I' && map.get(val).get(i) != 'O')
                {
                    count += 1;
                }
            }
        return count;
        }
    }
    int sum = 0;
    
    //Loop through Next possible characters in sequence
    for (Character next : map.get(val)) 
        {
            //Check for vowel
            if(next == 'A' || next == 'E' || next == 'I' || next == 'O')
            {
                sum += knightSequences(next, map, length - 1, vowels + 1);
            }
            else
            {
                sum += knightSequences(next, map, length - 1, vowels); 
            }
        }
    //Return final answer
    return sum;
  }
}
