package de.tum.ise.rest;

import de.tum.ise.service.TicketService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketResource {

    private final TicketService ticketService;

    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // TODO: Implement the 5 required REST endpoints here.

    // TODO 2.1: POST /tickets: Create a new ticket.
    // TODO 2.2: GET /tickets/{ticketId}: Get a single ticket by its ID.
    // TODO 2.3: GET /tickets: Get all tickets.
    // TODO 2.4: PUT /tickets/{ticketId}: Update an existing ticket.
    // TODO 2.5: DELETE /tickets/{ticketId}: Delete a ticket.
}