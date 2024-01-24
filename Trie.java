class Trie extends TrieNode
{
    public static  TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void insert(String word)
    {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar))
            node.put(currentChar, new TrieNode());
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    public static  TrieNode searchPrefix(String word)
    {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++)
        {
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar))
            node = node.get(currentChar);
            else
            return null;
        }
        return node;
    }
    public boolean search(String word)
    {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    public boolean startsWith(String prefix)
    {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    public static void main(String[] args)
    {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}
