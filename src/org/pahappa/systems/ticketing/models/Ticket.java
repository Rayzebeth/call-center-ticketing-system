package org.pahappa.systems.ticketing.models;

import org.pahappa.systems.ticketing.constants.TicketCategory;
import org.pahappa.systems.ticketing.constants.TicketStatus;

/**
 * A ticket refers to a unit of work or a request that is submitted
 * by a user or customer to seek assistance, report an issue, or request a service.
 * It serves as a record or a container that captures all the relevant information
 * related to the user's request or issue.
 */
public class Ticket {
    public TicketStatus status;
    public String tktNumber = null;
    public String customerID;
    public String contact;
    public String issueDesc;
    public String tktPriority;
    public TicketCategory tktCategory;

    public Ticket(String tktNumber, String customerID, String contact, TicketCategory tktCategory , String issueDesc, String tktPriority, TicketStatus status){
        this.tktNumber = tktNumber;
        this.customerID = customerID;
        this.contact = contact;
        this.issueDesc = issueDesc;
        this.tktPriority = tktPriority;
        this.status = status;
        this.tktCategory = tktCategory;
    }
}
