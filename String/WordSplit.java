public class WordSplit
{
    public static void main(String[] args)
    {
        String str = "Hello World! This is a sample string.";
        // Splitting the string using space as the delimiter
        String[] words = str.split(" ");
        // Printing each word
        for(String word : words)
        System.out.println(word);

        String[] moreWords = str.split("!");
        for(String moreWord : moreWords)
        System.out.println(moreWord);

        //Replace function
        String newStr = str.replace("Hello", "Hi");
        System.out.println(newStr);

    }
}
