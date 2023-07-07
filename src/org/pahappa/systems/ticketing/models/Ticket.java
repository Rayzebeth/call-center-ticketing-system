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
    private TicketStatus status;
    private String tktNumber = null;
    private String customerID;
    private String contact;
    private String issueDesc;
    private String tktPriority;
    private TicketCategory tktCategory;



    public String getTktPriority() {
        return tktPriority;
    }

    public void setTktPriority(String tktPriority) {
        this.tktPriority = tktPriority;
    }

    public TicketCategory getTktCategory() {
        return tktCategory;
    }

    public void setTktCategory(TicketCategory tktCategory) {
        this.tktCategory = tktCategory;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getTktNumber() {
        return tktNumber;
    }

    public void setTktNumber(String tktNumber) {
        this.tktNumber = tktNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getIssueDesc() {
        return issueDesc;
    }

    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }
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
