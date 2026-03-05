class VisitorCentre {
  
  public static final int EXPRESS = 2;
  public static final int REGULAR = 1;
  public static final int WALKIN = 0;
  private Seq<VisitorQueue> queues;
  private int NC;
  private int C;


  public VisitorCentre(int NC, int C) {
    VisitorQueue express = new VisitorQueue(NC, VisitorCentre.EXPRESS);
    VisitorQueue regular = new VisitorQueue(NC, VisitorCentre.REGULAR);
    VisitorQueue walkIns = new VisitorQueue(NC, VisitorCentre.WALKIN);

    this.queues = new Seq<>(3);
    this.queues.set(0, express);
    this.queues.set(1, regular);
    this.queues.set(2, walkIns);
    this.NC = NC;
    this.C = C;
    
  }

  public VisitorCentre welcome(Visitor v) {
    if (v.getTicketType() == EXPRESS) {
      if (!this.queues.get(0).isFull()) {
        this.queues.get(0).enq(v);
      }
    } else if (v.getTicketType() == REGULAR) {
      if (!this.queues.get(1).isFull()) {
        this.queues.get(1).enq(v);
      }
    } else {
      if (!this.queues.get(2).isFull()) {
        this.queues.get(2).enq(v);
      }
    }
    return this;
  }

  public Visitor admitToAttraction() throws AttractionFullException {

    if (this.queues.get(0).length() + this.queues.get(1).length() + this.queues.get(2).length() >= this.C) {
      throw new AttractionFullException(this.C);
    }

    if (!this.queues.get(0).isEmpty()) {
      return this.queues.get(0).deq();
    } else if (!this.queues.get(1).isEmpty()) {
      return this.queues.get(1).deq();
    } else {
      return this.queues.get(2).deq();
    }
  }

  @Override
  public String toString() {
    return "VC: " + this.queues.toString();
  }
  
}
