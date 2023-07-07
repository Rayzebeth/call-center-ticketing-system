package org.pahappa.systems.ticketing.services.impl;

import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.services.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.security.SecureRandom;

public class TicketServiceImpl implements TicketService {

    List<Ticket> tkt = new ArrayList<>(); 
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
        return tkt;
    }

    @Override
    public List<Ticket> getTicketsOfStatus(TicketStatus ticketStatus) {
        List<Ticket> tktStatus = new ArrayList<>();
        for(Ticket ticket: tkt ){
            if(ticket.getStatus().equals(ticketStatus)){
                tktStatus.add(ticket);
            }
        }
        return tktStatus;
    }

    @Override
    public void updateTicket(Ticket updatedTicket) {
        System.out.println("**Update Status** ");
        Scanner sc2 = new Scanner(System.in);
        TicketStatus statusUpdate = null;

            for(TicketStatus tickStat1: TicketStatus.values()){
                System.out.println(tickStat1.ordinal() +" "+ tickStat1.name());
            }  
            System.out.println("Enter new status: ");
            int input2 = sc2.nextInt(); 
            switch(input2){
                case 0:{
                    statusUpdate = TicketStatus.OPEN;
                    break;
                }
                case 1:{
                    statusUpdate = TicketStatus.INPROGRESS;
                    break;
                }
                case 2:{
                    statusUpdate = TicketStatus.RESOLVED;
                    break;
                }
                default:{
                    System.out.println("Enter valid option ");
                    break;
                }
            }
            updatedTicket.setStatus(statusUpdate);
            System.out.println("TICKETNO: " + updatedTicket.getTktNumber());
            System.out.println("AGENTID: "+updatedTicket.getAgentID());
            System.out.println("CUSTOMERID: "+updatedTicket.getCustomerID());
            System.out.println("CONTACT: "+updatedTicket.getContact());
            System.out.println("ISSUE: "+updatedTicket.getIssueDesc());
            System.out.println("TICKETCATEGORY: "+updatedTicket.getTktCategory());
            System.out.println("PRIORITY: "+updatedTicket.getTktPriority());
            System.out.println("STATUS: "+updatedTicket.getStatus());
            System.out.println("\n");
            
    }

    @Override
    public void deleteTicket(int index) {

    }
}
