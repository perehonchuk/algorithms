class WordDictionary {
    Node root = new Node();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        root.addWord(word);
    }
    
    public boolean search(String word) {
        return root.search(word);
    }

    public static class Node {
        Map<Character, Node> nodes = new HashMap<>();
        boolean isWord = false;

        public void addWord(String word) {
            if (word.isEmpty()) {
                isWord = true;
            } else {
                Node node = nodes.computeIfAbsent(word.charAt(0), k -> new Node());
                node.addWord(word.substring(1));
            }
        }
        
        public boolean search(String word) {
            if (word.isEmpty()) {
                return isWord;
            } else {
                char c = word.charAt(0);
                if (c == '.') {
                    for (Node node: nodes.values()) {
                        if (node.search(word.substring(1))) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    Node node = nodes.get(c);
                    return node == null? false : node.search(word.substring(1));
                }
            }
        }
    }
}

