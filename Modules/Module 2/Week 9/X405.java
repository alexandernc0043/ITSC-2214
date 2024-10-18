public Link iterateOverList(Link p, Link q){
    while (q.next != null) {
        q = q.next;
    }
    return q;
}
