1. Programming Problems 5
   Sorting
   Use lambda expressions for the implementation of the methods in CustomStringSort.java.
   Problem (CustomStringSort.java).
   In this problem, starting from the code in the named .java file, you will write 
2. lambda expressions that allow for the comparison of pairs of Strings, and then use 
3. them to create customised methods for sorting ArrayLists of Strings. In particular, 
4. you will work with the following interface:
   interface PredicateStringPair
   {
   boolean better( String a, String b );
   }
   In this problem, we will make use of interface Comparator<T> and one of the static 
5. methods Collections.sort; both of these are provided by Java, and you are asked to 
6. look at the Java API documentation for more information on these.
   You are to implement the following methods, as described.
   createComparator( PredicateStringPair pred ) that returns an instance of 
7. Comparator<String>. The returned instance of Comparator<String> should receive 
8. two strings, which we’ll call a and b, and return: a negative value when the better 
9. method of pred returns true on the pair a, b; a positive value when better returns 
10. true on the pair b, a; and, 0 otherwise. (We will only create instances of 
11. PredicateStringPair whose better method never returns true both on a pair a, b of Strings and on its transposition b, a.)
   sortStrings( ArrayList<String> lst, PredicateStringPair pred ) that calls 
12. createComparator on pred to obtain an instance of Comparator<String>, and 
13. then calls the built-in method Collections.sort, passing it both lst and the obtained instance of Comparator<String>.
   sortStringsLonger( ArrayList<String> lst ) that does the following. First, 
14. using a lambda expression, it defines an instance of PredicateStringPair 
15. whose method returns true on a pair of Strings a, b if and only if the length 
16. of a is strictly greater than the length of b. Then, it calls sortStrings on lst 
17. and the created instance of PredicateStringPair.
   sortStringsNumAs( ArrayList<String> lst ) that does the following. First, using a 
18. lambda expression, it defines an instance of PredicateStringPair whose method 
19. returns true on a pair of Strings s1, s2 if and only if the number of occurrences 
20. of the letter a (in either upper or lower case) in s1 is strictly greater than the 
21. number of such occurrences in s2. Then, it calls sortStrings on lst and the created 
22. instance of PredicateStringPair.
   sortStringsDictionary( ArrayList<String> lst ) that does the following. First, using a 
21. lambda expression, it defines an instance of PredicateStringPair whose method returns 
22. true on a pair of Strings s1, s2 if and only if s1 comes before s2 according to 
23. dictionary ordering. Then, it calls sortStrings on lst and the created instance of 
24. PredicateStringPair.