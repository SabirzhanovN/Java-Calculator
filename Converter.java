import java.util.TreeMap;

public class Converter {

    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }

    public boolean isRoman(String number) {
        return romanKeyMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number){
        String roman = "";
        int arabianKey;

        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman = roman + arabianKeyMap.get(arabianKey);
            number = number - arabianKey;
        } while (number != 0);

        return roman;
    }

    public int romanToInt(String number){
        int res = 0;

        for (int i = 0; i < number.length(); i++){
            int s1 = romanKeyMap.get(number.charAt(i));

            if (i + 1 < number.length()) {
                int s2 = romanKeyMap.get(number.charAt(i + 1));

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }

        return res;
    }
}
