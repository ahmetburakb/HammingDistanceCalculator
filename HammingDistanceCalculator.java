class HammingDistanceCalculator {

    public static void main(String[] args) {
        HammingDistanceCalculator myCalculator = new HammingDistanceCalculator();
        System.out.println(myCalculator.calculate(0,1));
    }

    HammingDistanceCalculator(){
    }

    public int calculate(int firstNum, int secondNum) {
        String[] stringArr = { Integer.toBinaryString(firstNum), Integer.toBinaryString(secondNum) };
        stringArr = makeSameSize(stringArr);
        return countDifferences(stringArr[0], stringArr[1]);
    }


    private static int countDifferences(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static String[] makeSameSize(String[] inputStrings) {

        int maxLen = 0;
        for (String string : inputStrings) {
            if (string.length() > maxLen) {
                maxLen = string.length();
            }
        }

        for (int i = 0; i < inputStrings.length; i++) {
            if (inputStrings[i].length() < maxLen) {
                StringBuilder leadingZeros = new StringBuilder();
                for (int j = 0; j < maxLen - inputStrings[i].length(); j++) {
                    leadingZeros.append("0");
                }
                inputStrings[i] = leadingZeros.toString() + inputStrings[i];
            }
        }

        return inputStrings;
    }
}