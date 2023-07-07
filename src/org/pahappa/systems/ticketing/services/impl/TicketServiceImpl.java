package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;

public class TicketServiceImpl implements TicketService {

    List<Ticket> tkt = new ArrayList<Ticket>();
    @Override
    public void createTicket(Ticket ticket) {
        SecureRandom rand = new SecureRandom();
        int upper = 1000;
        String random = ((Integer)rand.nextInt(upper)).toString();
        ticket.setTktNumber(random);
        tkt.add(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
        return null;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {

    }

    @Override
    public void deleteTicket(int index) {

    }
}
