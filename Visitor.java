class Visitor {

  private static int counter = 1000;
  private int ticketType;
  private int id;

  public Visitor(int ticketType) {
    this.id = this.counter;
    this.ticketType = ticketType;
    this.counter += 1;
  }
  
  public int getTicketType() {
    return this.ticketType;
  }

  @Override
  public String toString() {
    return "V" + (this.id); 
  } 
}
