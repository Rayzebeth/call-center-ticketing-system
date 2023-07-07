package org.pahappa.systems.ticketing.views;

import org.pahappa.systems.ticketing.services.TicketService;
import org.pahappa.systems.ticketing.services.impl.TicketServiceImpl;
import org.pahappa.systems.ticketing.models.Ticket;
import org.pahappa.systems.ticketing.constants.TicketStatus;
import org.pahappa.systems.ticketing.constants.TicketCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketView implements BaseTicketView {

    private final TicketService ticketService;
    private final Scanner scanner;

    public TicketView() {
        this.ticketService = new TicketServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        System.out.println("********* Call Center Ticket System *********\n\n");
        boolean running = true;
        while (running) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create Ticket");
            System.out.println("2. Get All Tickets");
            System.out.println("3. Get Tickets of Status");
            System.out.println("4. Update Ticket");
            System.out.println("5. Delete Ticket");
            System.out.println("6. Exit");
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            
            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    getAllTickets();
                    break;
                case 3:
                    getTicketsOfStatus();
                    break;
                case 4:
                    updateTicket();
                    break;
                case 5:
                    deleteTicket();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    @Override
    public void createTicket(){
        Scanner sc = new Scanner(System.in);
            System.out.println("******ENTER ALL INFORMATION CORRECTLY***");
            System.out.print("Enter AgentID :");
            String agntID = sc.nextLine();
            System.out.print("Enter Customer ID :");
            String id = sc.nextLine();
            System.out.print("Enter Customer Contact :");
            String contact = sc.nextLine();

            System.out.print("Enter Issue :");
            String issue = sc.nextLine();

            System.out.println("\n**Enter Ticket Category**");
            for (TicketCategory cat : TicketCategory.values()) {
                System.out.println(cat.ordinal() +" "+ cat.name());
            }
            TicketCategory tcat = null;
            for(;;){
                System.out.println("Choose Category: ");
                int category = sc.nextInt();
                if(category==0){
                    tcat = TicketCategory.COMPLAINT;
                }else if(category==1){
                    tcat = TicketCategory.INQUIRY;
                }else{
                System.out.println("Invalid input");
                continue;
                }
                break;
            }
            
            System.out.println("\n**Choose Priority Level**");
            System.out.println("1. LOW");
            System.out.println("2. MID");
            System.out.println("3. HIGH");
            int priority = sc.nextInt();

            System.out.println("\n**Enter Ticket Category**");
            for (TicketStatus sta : TicketStatus.values()) {
                System.out.println(sta.ordinal() +" "+ sta.name());
            }
            TicketStatus stat = null;
            for(;;){
                System.out.println("Choose Status: ");
                int state = sc.nextInt();
                if(state==0){
                stat = TicketStatus.OPEN;
                }else if(state==1){
                stat = TicketStatus.INPROGRESS;
                }else if(state==2){
                stat = TicketStatus.RESOLVED;
                }else{
                System.out.println("Invalid input");
                continue;
                }
                break;
            }
            String prior=null;
            switch(priority) {
                case 1: {
                    prior = "LOW";
                    break;
                }
                case 2: {
                    prior = "MID";
                    break;
                }
                case 3: {
                    prior = "HIGH"; 
                    break;
                }
                default :{
                    System.out.println("Enter correct option");
                    break;
                }
            }
            
            
            Ticket ticket = new Ticket(null,id,contact,tcat,issue,prior,stat,agntID);
            //System.out.println(ticket.customerID + " "+ ticket.contact +" "+tcat+" "+issue+" "+prior+" "+stat);
            ticketService.createTicket(ticket);
            
        
    }

    @Override
    public void getAllTickets() {
        List<Ticket> tktlist = ticketService.getAllTickets();
        for(Ticket ticket1: tktlist){
            System.out.println("TICKETNO: " + ticket1.getTktNumber());
            System.out.println("AGENTID: "+ticket1.getAgentID());
            System.out.println("CUSTOMERID: "+ticket1.getCustomerID());
            System.out.println("CONTACT: "+ticket1.getContact());
            System.out.println("ISSUE: "+ticket1.getIssueDesc());
            System.out.println("TICKETCATEGORY: "+ticket1.getTktCategory());
            System.out.println("PRIORITY: "+ticket1.getTktPriority());
            System.out.println("STATUS: "+ticket1.getStatus());
            System.out.println("\n");
        }
        
    }

    @Override
    public void getTicketsOfStatus() {
        for(TicketStatus status1 : TicketStatus.values()){
            System.out.println(status1.ordinal() + " " + status1.name());
        }
        TicketStatus stat1;
        Scanner sc1 = new Scanner(System.in);
        for(;;){
            System.out.println("Choose Status: ");
            int state1 = sc1.nextInt();
            if(state1==0){
            stat1 = TicketStatus.OPEN;
            }else if(state1==1){
            stat1 = TicketStatus.INPROGRESS;
            }else if(state1==2){
            stat1 = TicketStatus.RESOLVED;
            }else{
            System.out.println("Invalid input");
            continue;
            }
            break;
        }
        List<Ticket> tktOfStatus = new ArrayList<>();
        tktOfStatus = ticketService.getTicketsOfStatus(stat1);
        for(Ticket ticOfStatus: tktOfStatus){
            System.out.println("TICKETNO: " + ticOfStatus.getTktNumber());
            System.out.println("AGENTID: "+ticOfStatus.getAgentID());
            System.out.println("CUSTOMERID: "+ticOfStatus.getCustomerID());
            System.out.println("CONTACT: "+ticOfStatus.getContact());
            System.out.println("ISSUE: "+ticOfStatus.getIssueDesc());
            System.out.println("TICKETCATEGORY: "+ticOfStatus.getTktCategory());
            System.out.println("PRIORITY: "+ticOfStatus.getTktPriority());
            System.out.println("STATUS: "+ticOfStatus.getStatus());
            System.out.println("\n");
        }

    }

    @Override
    public void updateTicket() {
        System.out.println("Enter Number of Ticket to Update: ");
        Scanner sc2 = new Scanner(System.in);
        String input = sc2.nextLine();

        List<Ticket> ticketUpdate = ticketService.getAllTickets();
        for(Ticket uticket:ticketUpdate){
            if(input.equals(uticket.getTktNumber())){
                System.out.println("TICKETNO: " + uticket.getTktNumber());
                System.out.println("AGENTID: "+uticket.getAgentID());
                System.out.println("CUSTOMERID: "+uticket.getCustomerID());
                System.out.println("CONTACT: "+uticket.getContact());
                System.out.println("ISSUE: "+uticket.getIssueDesc());
                System.out.println("TICKETCATEGORY: "+uticket.getTktCategory());
                System.out.println("PRIORITY: "+uticket.getTktPriority());
                System.out.println("STATUS: "+uticket.getStatus());
                System.out.println("\n");

                ticketService.updateTicket(uticket);
            }
        }
    }

    @Override
    public void deleteTicket() {
    
    }
}
