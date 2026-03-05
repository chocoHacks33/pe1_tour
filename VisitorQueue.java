class VisitorQueue<T> extends Queue<T> implements Comparable<VisitorQueue<T>> {
  
  private int id;
  private int sizeOf;

  public VisitorQueue(int id, int sizeOf) {
    
    super(sizeOf);
    this.sizeOf = sizeOf;
    this.id = id;
  }

  @Override
  public boolean enq(T e) {
    if (e.getTicketType() == this.id) {
      return super.enq(e);
    }
    return false;
  }

  @Override
  public int compareTo(VisitorQueue<T> q) {
    if (q.isEmpty() && super.isEmpty()) {
      return -1;
    } else if (q.isEmpty()) {
      return 1;
    } else if (super.isEmpty()) {
      return -1;
    }

    if (this.id < q.id) {
      return -1;
    } else if (q.id < this.id) {
      return 1;
    }
    
    if (this.sizeOf < q.sizeOf) {
      return -1;
    } else if (q.sizeOf < this.sizeOf) {
      return 1;
    }

    return 1;
  }
  @Override
  public String toString() {
    return "Q" + this.id + " " + super.toString();   
  }


}
