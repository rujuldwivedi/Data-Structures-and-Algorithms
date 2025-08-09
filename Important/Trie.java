package Important;

class TrieNode
{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
}

class Trie
{
    private TrieNode root = new TrieNode();

    public void insert(String word)
    {
        TrieNode node = root;

        for (char ch : word.toCharArray())
        {
            int idx = ch - 'a';

            if(node.children[idx] == null)
            node.children[idx] = new TrieNode();

            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word)
    {
        TrieNode node = root;

        for(char ch : word.toCharArray())
        {
            int idx = ch - 'a';

            if(node.children[idx] == null)
            return false;

            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix)
    {
        TrieNode node = root;

        for(char ch : prefix.toCharArray())
        {
            int idx = ch - 'a';

            if(node.children[idx] == null)
            return false;

            
            node = node.children[idx];
        }
        return true;
    }
}
