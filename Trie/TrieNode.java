class TrieNode
    {
        public static  TrieNode[] links;
        public static  final int R = 26;
        public static  boolean isEnd;
        public TrieNode()
        {
            links = new TrieNode[R];
        }
        public boolean containsKey(char ch)
        {
            return links[ch - 'a'] != null;
        }
        public TrieNode get(char ch)
        {
            return links[ch - 'a'];
        }
        public void put(char ch, TrieNode node)
        {
            links[ch - 'a'] = node;
        }   
        public void setEnd()
        {
            isEnd = true;
        }
        public boolean isEnd()
        {
            return isEnd;
        }
        public static void main(String[] args)
        {
            TrieNode obj = new TrieNode();
            obj.put('r', new TrieNode());
            obj.put('s', new TrieNode());
            System.out.println(obj.containsKey('r'));
            System.out.println(obj.containsKey('s'));
        }
    }