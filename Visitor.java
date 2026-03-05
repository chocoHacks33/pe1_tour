class Visitor { 
  
  private static int Sid = 1000;
  private final int id;
  private int ticketType;

  public Visitor(int ticketType) {
    this.id = Visitor.Sid;
    this.ticketType = ticketType;
    Visitor.Sid += 1;
  }

  public int getTicketType() {
    return this.ticketType;
  }

  @Override
  public String toString() {
    return "V" + this.id;
  }
}
