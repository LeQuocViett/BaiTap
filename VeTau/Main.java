package VeTau;

public class Main {
    public static void main(String[] args) {
        TicketStore store = new TicketStore();

        TicketAgent agent = new TicketAgent(store);
        Passenger passenger = new Passenger(store);

        agent.start();
        passenger.start();
    }
}
