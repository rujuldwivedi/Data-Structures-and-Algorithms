public class KarpRabin
{
  public static final int PRIME = 101;
  public static double calculateHash(String str)
  {
    double hash = 0;
    for(int i=0; i < str.length(); i++)
    hash += str.charAt(i) * Math.pow(PRIME, i);
    return hash;
  }
  public static double updateHash(double prevHash, char oldChar, char newChar, int patternLength)
  {
    double newHash = (prevHash - oldChar) / PRIME;
    newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
    return newHash;
  }
  public static void search(String text, String pattern)
  {
    int patternLength = pattern.length();
    double patternHash = calculateHash(pattern);
    double textHash = calculateHash(text.substring(0, patternLength));
    for(int i=0; i<= text.length() - patternLength; i++)
    {
      if(textHash == patternHash)
      {
        if(text.substring(i, i+patternLength).equals(pattern))
        System.out.println("Word found at index " + i);
      }
      if (i < text.length() - patternLength)
      textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
    }
  }
  public static void main(String[] args)
  {
    String text = "ABCCDDAEFG";
    String pattern = "CDD";
    search(text, pattern);
  }
}