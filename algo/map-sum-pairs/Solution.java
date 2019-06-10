class MapSum {
    Node root = new Node();
    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
        root.insert(key, val);
    }
    
    public int sum(String prefix) {
        return root.sum(prefix);
    }

    public static class Node {
        public Map<Character, Node> nodes = new HashMap<>();
        public int count = 0;
        boolean word = false;

        public Integer insert(String key, int val) {
            if (!key.isEmpty()) {
                Node node = nodes.computeIfAbsent(key.charAt(0), k -> new Node());
                Integer old = node.insert(key.substring(1), val);
                count = old == null ? count + val: count - old + val;
                return old;
            } else {
                if (word) {
                    int old = count;
                    count = val;
                    return old;
                } else {
                    word = true;
                    count += val;
                    return null;
                }
            }
        }
        
        public int sum(String prefix) {
            if (prefix.isEmpty()) {
                return count;
            }
            Node node = nodes.get(prefix.charAt(0));
            return node == null? 0 : node.sum(prefix.substring(1));
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
