import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//initial commitment
public class LeetCode_17_Letter_Combinations_of_a_Phone_Number {
    ArrayList<String> button2Characters = new ArrayList<String>(Arrays.asList("a", "b", "c"));
    ArrayList<String> button3Characters = new ArrayList<String>(Arrays.asList("d", "e", "f"));
    ArrayList<String> button4Characters = new ArrayList<String>(Arrays.asList("g", "h", "i"));
    ArrayList<String> button5Characters = new ArrayList<String>(Arrays.asList("j", "k", "l"));
    ArrayList<String> button6Characters = new ArrayList<String>(Arrays.asList("m", "n", "o"));
    ArrayList<String> button7Characters = new ArrayList<String>(Arrays.asList("p", "q", "r", "s"));
    ArrayList<String> button8Characters = new ArrayList<String>(Arrays.asList("t", "u", "v"));
    ArrayList<String> button9Characters = new ArrayList<String>(Arrays.asList("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {

        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < digits.length(); i++) {
           result = append(result, digits.charAt(i));
        }

        return result;
    }

    public ArrayList<String> append(ArrayList<String> input, Character character) {
        ArrayList<String> charactersToAdd = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        switch(character) {
            case '2':
                charactersToAdd = button2Characters;
                break;
            case '3':
                charactersToAdd = button3Characters;
                break;
            case '4':
                charactersToAdd = button4Characters;
                break;
            case '5':
                charactersToAdd = button5Characters;
                break;
            case '6':
                charactersToAdd = button6Characters;
                break;
            case '7':
                charactersToAdd = button7Characters;
                break;
            case '8':
                charactersToAdd = button8Characters;
                break;
            case '9':
                charactersToAdd = button9Characters;
                break;
        }

        if (input.size() == 0) {
            return charactersToAdd;
        } else {
            for (String s: input) {
                for (String newCharacter: charactersToAdd) {
                    result.add(s.concat(newCharacter));
                }
            }
        }

        return result;
    }
}
