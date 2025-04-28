class Node{
    int key;int val;
    Node prev;
    Node next;

     public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {

    private int cap;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap=capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next=tail;
        this.tail.prev=head;
    }

    void insertNode(Node node){
     cache.put(node.key,node);
     Node headNext = head.next;
     head.next=node;
     node.next=headNext;
     headNext.prev=node;
     node.prev=head;  
    }

    void deleteNode(Node node){
        cache.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
            insertNode(node);
            return node.val;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            deleteNode(cache.get(key));
        }
        if(cap==cache.size()){
            deleteNode(tail.prev);
        }
        insertNode(new Node(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
