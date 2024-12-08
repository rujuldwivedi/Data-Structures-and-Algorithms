public class Trie
{

    /*
     * Here we'll do the following:
     * 1. Implement the Trie data structure
     * 2. Implement the insert, search and delete operations on a Trie
     * 3. Implement the auto-complete feature using a Trie
     * 4. Implement the longest common prefix using a Trie
     * 5. Implement the word search problem using a Trie
     * 6. Implement the replace words problem using a Trie
     * 7. Implement the word break problem using a Trie
     * 8. Implement the alien dictionary problem using a Trie
     * 9. Implement the longest word in dictionary problem using a Trie
     * 10. Implement the word ladder problem using a Trie
     */

     /*
        * The Trie data structure is a tree-like data structure that is used to store a dynamic set of strings.
        * The Trie data structure is used to store strings in such a way that the strings can be searched in O(L) time complexity, where L is the length of the string.
        * The Trie data structure is used to implement the auto-complete feature, the longest common prefix, the word search problem,
        * the replace words problem, the word break problem, the alien dictionary problem, the longest word in dictionary problem, and the word ladder problem.
      */

     Trie[] children;
     boolean isEndOfWord;

     Trie()
     {
         children = new Trie[26];
         isEndOfWord = false;
     }

        public void insert(String word)
        {
            Trie curr = this;
            for(char c : word.toCharArray())
            {
                if(curr.children[c-'a'] == null)
                {
                    curr.children[c-'a'] = new Trie();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String word)
        {
            Trie curr = this;
            for(char c : word.toCharArray())
            {
                if(curr.children[c-'a'] == null)
                {
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            return curr.isEndOfWord;
        }

        public boolean startsWith(String prefix)
        {
            Trie curr = this;
            for(char c : prefix.toCharArray())
            {
                if(curr.children[c-'a'] == null)
                {
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            return true;
        }

        public void delete(String word)
        {
            delete(this, word, 0);
        }

        public boolean delete(Trie root, String word, int index)
        {
            if(index == word.length())
            {
                if(!root.isEndOfWord)
                {
                    return false;
                }
                root.isEndOfWord = false;
                return isEmpty(root);
            }

            char c = word.charAt(index);
            if(root.children[c-'a'] == null)
            {
                return false;
            }

            boolean shouldDeleteCurrentNode = delete(root.children[c-'a'], word, index+1);

            if(shouldDeleteCurrentNode)
            {
                root.children[c-'a'] = null;
                return isEmpty(root);
            }

            return false;
        }

        public boolean isEmpty(Trie root)
        {
            for(Trie child : root.children)
            {
                if(child != null)
                {
                    return false;
                }
            }
            return true;
        }

        /*
        * Function to implement the auto-complete feature using a Trie

        public List<String> autoComplete(String prefix)
        {
            List<String> result = new ArrayList<>();
            Trie curr = this;
            for(char c : prefix.toCharArray())
            {
                if(curr.children[c-'a'] == null)
                {
                    return result;
                }
                curr = curr.children[c-'a'];
            }
            dfs(curr, prefix, result);
            return result;
        }

        public void dfs(Trie root, String prefix, List<String> result)
        {
            if(root.isEndOfWord)
            {
                result.add(prefix);
            }

            for(int i=0; i<26; i++)
            {
                if(root.children[i] != null)
                {
                    dfs(root.children[i], prefix+(char)(i+'a'), result);
                }
            }
        }

        */

        /* 
        * Function to implement the longest common prefix using a Trie

        public String longestCommonPrefix(String[] words)
        {
            Trie root = new Trie();
            for(String word : words)
            {
                root.insert(word);
            }

            StringBuilder sb = new StringBuilder();
            Trie curr = root;
            while(true)
            {
                int count = 0;
                int index = -1;
                for(int i=0; i<26; i++)
                {
                    if(curr.children[i] != null)
                    {
                        count++;
                        index = i;
                    }
                }
                if(count != 1)
                {
                    break;
                }
                sb.append((char)(index+'a'));
                curr = curr.children[index];
            }

            return sb.toString();
        }

        */

        /* 
        * Function to implement the word search problem using a Trie

        public boolean wordSearch(char[][] board, String word)
        {
            Trie root = new Trie();
            root.insert(word);
            for(int i=0; i<board.length; i++)
            {
                for(int j=0; j<board[0].length; j++)
                {
                    if(dfs(board, i, j, root, 0))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean dfs(char[][] board, int i, int j, Trie root, int index)
        {
            if(index == root.children.length)
            {
                return true;
            }

            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#')
            {
                return false;
            }

            char c = board[i][j];
            if(root.children[c-'a'] == null)
            {
                return false;
            }

            board[i][j] = '#';
            boolean found = dfs(board, i+1, j, root.children[c-'a'], index+1) ||
                           dfs(board, i-1, j, root.children[c-'a'], index+1) ||
                           dfs(board, i, j+1, root.children[c-'a'], index+1) ||
                           dfs(board, i, j-1, root.children[c-'a'], index+1);
            board[i][j] = c;

            return found;
        }

        */

        /* 
        * Function to implement the replace words problem using a Trie

        public String replaceWords(List<String> dictionary, String sentence)
        {
            Trie root = new Trie();
            for(String word : dictionary)
            {
                root.insert(word);
            }

            StringBuilder sb = new StringBuilder();
            String[] words = sentence.split(" ");
            for(String word : words)
            {
                sb.append(getRoot(root, word));
                sb.append(" ");
            }

            return sb.toString().trim();
        }

        public String getRoot(Trie root, String word)
        {
            Trie curr = root;
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray())
            {
                if(curr.children[c-'a'] == null || curr.isEndOfWord)
                {
                    break;
                }
                sb.append(c);
                curr = curr.children[c-'a'];
            }
            return sb.toString();
        }

        */

        /* 
         * Function to implement the word break problem using a Trie
        
        public boolean wordBreak(String s, List<String> wordDict)
        {
            Trie root = new Trie();
            for(String word : wordDict)
            {
                root.insert(word);
            }

            int n = s.length();
            boolean[] dp = new boolean[n+1];
            dp[0] = true;

            for(int i=1; i<=n; i++)
            {
                for(int j=0; j<i; j++)
                {
                    if(dp[j] && root.search(s.substring(j, i)))
                    {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }

        */

        /* 
        * Function to implement the alien dictionary problem using a Trie

        public String alienOrder(String[] words)
        {
            Trie root = new Trie();
            for(String word : words)
            {
                root.insert(word);
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++)
            {
                if(root.children[i] != null)
                {
                    sb.append((char)(i+'a'));
                }
            }

            return sb.toString();
        }

        */

        /* 
         *Function to implement the longest word in dictionary problem using a Trie

        public String longestWord(String[] words)
        {
            Trie root = new Trie();
            for(String word : words)
            {
                root.insert(word);
            }

            String result = "";
            for(String word : words)
            {
                if(word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0))
                {
                    if(isValid(root, word))
                    {
                        result = word;
                    }
                }
            }

            return result;
        }

        public boolean isValid(Trie root, String word)
        {
            Trie curr = root;
            for(char c : word.toCharArray())
            {
                if(!curr.children[c-'a'].isEndOfWord)
                {
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            return true;
        }

        */

        /* 
         * Function to implement the word ladder problem using a Trie
        
        public int ladderLength(String beginWord, String endWord, List<String> wordList)
        {
            Trie root = new Trie();
            for(String word : wordList)
            {
                root.insert(word);
            }

            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int level = 1;

            while(!queue.isEmpty())
            {
                int size = queue.size();
                for(int i=0; i<size; i++)
                {
                    String currentWord = queue.poll();
                    char[] currentWordArray = currentWord.toCharArray();
                    for(int j=0; j<currentWordArray.length; j++)
                    {
                        char originalChar = currentWordArray[j];
                        for(char c='a'; c<='z'; c++)
                        {
                            currentWordArray[j] = c;
                            String newWord = new String(currentWordArray);
                            if(root.search(newWord))
                            {
                                if(newWord.equals(endWord))
                                {
                                    return level+1;
                                }
                                queue.add(newWord);
                                root.delete(newWord);
                            }
                        }
                        currentWordArray[j] = originalChar;
                    }
                }
                level++;
            }

            return 0;
        }

        */

    public static void main(String[] args)
    {
        Trie root = new Trie();
        root.insert("hello");
        root.insert("world");
        root.insert("hell");
        root.insert("cat");
        root.insert("dog");
        root.insert("hellcat");
        root.insert("hellboy");
        root.insert("hellboyworld");
        System.out.println(root.search("hello"));
        System.out.println(root.search("hell"));
        System.out.println(root.search("world"));
        System.out.println(root.search("cat"));
        System.out.println(root.search("dog"));
        System.out.println(root.search("hellcat"));
        System.out.println(root.search("hellboy"));
        System.out.println(root.search("hellboyworld"));

        root.delete("hellboyworld");
        System.out.println(root.search("hellboyworld"));

        /*
         * ------------------------------------------------------
         */

        /*
        List<String> result = root.autoComplete("hell");
        for(String s : result)
        {
            System.out.println(s);
        }
        */

        /*
         * ------------------------------------------------------
         */

        /*
        String[] words = {"hello", "hell", "world", "cat", "dog", "hellcat", "hellboy", "hellboyworld"};
        System.out.println(root.longestCommonPrefix(words));

        char[][] board = {{'h', 'e', 'l', 'l', 'o'},
                          {'w', 'o', 'r', 'l', 'd'},
                          {'c', 'a', 't', 'd', 'o'},
                          {'g', 'h', 'e', 'l', 'l'}};

        System.out.println(root.wordSearch(board, "hello"));
        */

        /*
         * ------------------------------------------------------
         */

        /*
         List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        dictionary.add("fat");
        dictionary.add("mat");
        dictionary.add("sat");
        dictionary.add("pat");
        */

        /*
         * ------------------------------------------------------
         */

        /*
        System.out.println(root.replaceWords(dictionary, "the cattle was rattled by the battery"));

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(root.wordBreak("leetcode", wordDict));
        */

        /*
         * ------------------------------------------------------
         */
        
         /*
        String[] alienWords = {"hello", "hell", "world", "cat", "dog", "hellcat", "hellboy", "hellboyworld"};

        System.out.println(root.alienOrder(alienWords));
        */

        /*
         * ------------------------------------------------------
         */

        /*
        String[] wordsDict = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        System.out.println(root.longestWord(wordsDict));
        */

        /*
         * ------------------------------------------------------
         */

         /*
        List<String> wordLadder = new ArrayList<>();
        wordLadder.add("hot");
        wordLadder.add("dot");
        wordLadder.add("dog");
        wordLadder.add("lot");
        wordLadder.add("log");
        wordLadder.add("cog");

        System.out.println(root.ladderLength("hit", "cog", wordLadder));
        */

    }
}