class VisitorQueue extends Queue<Visitor> implements Comparable<VisitorQueue> {
  
  private int id;
  private final int sizeOf;
  public VisitorQueue(int id, int sizeOf) {
    super(sizeOf);
    this.id = id;
    this.sizeOf = sizeOf;
  }
  
  @Override
  public boolean enq(Visitor v) {
    if (v.getTicketType() == this.id) {
      return super.enq(v); 
    }
    return false;
  }
  
  @Override
  public int compareTo(VisitorQueue q) {
    if (q.isEmpty() && !super.isEmpty()) {
      return 1;
    } else if (!q.isEmpty() && super.isEmpty()) {
      return -1;
    } else if (!q.isEmpty() && !super.isEmpty()) {
      return -1;
    }

    if (q.id < this.id) {
      return 1;
    } else if (q.id > this.id) {
      return -1;
    } 

    if (super.length() < q.length()) {
      return -1;
    } else if (q.length() < super.length()) {
      return 1;
    } else {
      return -1;
    }

  }

  @Override
  public String toString() {
    return "Q" + this.id + " " + super.toString();
  }

}
