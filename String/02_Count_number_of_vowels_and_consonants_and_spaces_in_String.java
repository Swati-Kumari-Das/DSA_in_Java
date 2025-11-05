/*
Count number of vowels, consonants, spaces in String
Problem Statement: Given a string, write a program to count the number of vowels, consonants, and spaces in that string.

Examples:

Example 1:
Input: string str = "Take u forward is Awesome"
Output: 
Vowels: 10
Consonants: 11
White spaces: 4

Example 2:
Input: string str = "India won the cricket match"
Output:
Vowels: 8
Consonants: 15
White spaces: 4
*/

public class CountCharacters {

    static void solve(String str, int n) {
        int count_v = 0;
        int count_c = 0;
        int count_s = 0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count_v++;
                System.out.print(ch + " ");
            }
            else if (ch != ' ') { 
                count_c++;
            }

            if (ch == ' ') {
                count_s++;
            }
        }
        
        System.out.println("\n");
        System.out.println("Vowels: " + count_v);
        System.out.println("Consonents: " + count_c);
        System.out.println("Spaces: " + count_s);
    }

    public static void main(String[] args) {
        String str = "India won the cricket match";
        solve(str, str.length());

        System.out.println("-----------------------");

        String str2 = "Nineteen twenty five";
        solve(str2, str2.length());
    }
}
