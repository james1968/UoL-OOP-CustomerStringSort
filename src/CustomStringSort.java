import java.util.*;

interface PredicateStringPair
{
    boolean better(String a, String b );
}

public class CustomStringSort{

    Comparator<String> str;

    public static Comparator<String> createComparator(PredicateStringPair pred)
    {
        pred = (String a, String b) -> {
            if (a.compareTo(b) < 0) {
                return true;
            } else if (b.compareTo(a) > 0) {
                return false;
            }
            return true;
        };
        PredicateStringPair finalPred = pred;
        Comparator<String> str = (String a, String b) -> {
            if (finalPred.better(a, b)) {
                return 1;
            } else if (!finalPred.better(a, b)){
                return -1;
            } else {
                return 0;
            }
        };
        return str;
    }

    public static void sortStrings( ArrayList<String> lst, PredicateStringPair pred )
    {
        Comparator<String> str;
        str = createComparator(pred);
        Collections.sort(lst, str);
    }

    public static void sortStringsLonger( ArrayList<String> lst )
    {
        PredicateStringPair pred = (String a, String b) -> {
            if (a.length() > b.length()) {
                return true;
            }
            return false;
        };
        sortStrings(lst, pred);
    }

    public static void sortStringsNumAs( ArrayList<String> lst )
    {
        PredicateStringPair pred1 = (String a, String b) -> {
            a = a.toLowerCase();
            b = b.toLowerCase();
            int counta = 0;
            int countb = 0;
            char c = 'a';
            for(int i=0; i < a.length(); i++)
            {    if(a.charAt(i) == c)
                counta++;
            }
            for(int j=0; j < b.length(); j++)
            {    if(b.charAt(j) == c)
                countb++;
            }
            if (counta > countb) {
                return true;
            } else {
                return false;
            }
        };
        sortStrings(lst, pred1);
    }

    public static void sortStringsDictionary( ArrayList<String> lst )
    {
        PredicateStringPair pred = (String a, String b) -> {
            if (a.compareTo(b) < 0) {
                return true;
            } else if (b.compareTo(a) > 0){
                return false;
            }
            return true;
        };
        sortStrings(lst, pred);
    }

    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<String>();

        fruits.add("Strawberry");
        fruits.add("strawberries");
        fruits.add("Kiwi");
        fruits.add("kiwis");
        fruits.add("Banana");
        fruits.add("bananas");

        System.out.println( fruits );
        sortStringsLonger( fruits );
        System.out.println("Longer");
        System.out.println( fruits );

        sortStringsNumAs( fruits );
        System.out.println("SortStringsNums");
        System.out.println( fruits );

        fruits.add( "@plum" );
        fruits.add( "@kumquat" );
        fruits.add( "banana" );
        fruits.add( "3 oranges" );
        fruits.add( "9 oranges" );
        fruits.add( "33 oranges" );
        System.out.println( fruits );
        sortStringsDictionary( fruits );
        System.out.println("Dictionary");
        System.out.println( fruits );
    }
}
