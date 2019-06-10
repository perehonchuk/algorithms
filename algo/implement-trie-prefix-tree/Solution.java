class Trie {
    TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }

    public static class TrieNode {
        public Map<Character, TrieNode> nodes = new HashMap<>();
        public boolean word = false;

        public void insert(String word) {
            if (word.isEmpty()) {
                this.word = true;
            } else {
                TrieNode node = nodes.computeIfAbsent(word.charAt(0), k -> new TrieNode());
                node.insert(word.substring(1));
            }
        }

        public boolean search(String wordToSearch) {
            if (wordToSearch.isEmpty()) {
                return word;
            } else {
                TrieNode node = nodes.get(wordToSearch.charAt(0));
                return node == null ? false : node.search(wordToSearch.substring(1));
            }
        }

        public boolean startsWith(String prefix) {
            if (prefix.isEmpty()) {
                return true;
            } else {
                TrieNode node = nodes.get(prefix.charAt(0));
                return node == null ? false : node.startsWith(prefix.substring(1));
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
