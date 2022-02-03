package src.easy;

public class FindMissingChar {

    public static void main(String[] args) {
        System.out.println(findMissingChar("apple", "aple"));
        System.out.println(findMissingChar("dogs", "dog"));
        System.out.println(findMissingChar("dispatch", "disptch"));
        System.out.println(findMissingChar("zebra", "ebra"));
    }

    public static char findMissingChar(String str1, String str2) {

        int str1Sum = 0;
        int str2Sum = 0;

        for (char c: str1.toCharArray()) {
            str1Sum += c;
        }

        for (char d: str2.toCharArray()) {
            str2Sum += d;
        }

        return (char)(str1Sum-str2Sum);
    }
}