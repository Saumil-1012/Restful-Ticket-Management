package de.tum.ise.service;

import de.tum.ise.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final List<Ticket> tickets = new ArrayList<>();
    private long nextId = 1L;

    public List<Ticket> getAllTickets() {
        // TODO 1.2: Return a list containing all stored tickets (a copy, not a reference to internal storage).
        return null;
    }

    public Optional<Ticket> findTicketById(Long ticketId) {
        // TODO 1.1: Iterate through the tickets list to look up the ticket with the given ID and return it wrapped in an Optional.
        return Optional.empty();
    }

    public Ticket saveTicket(Ticket ticket) {
        if (ticket.getId() == null) {
            // TODO 1.1: Handle the creation of a new ticket.
            // Assign the current value of nextId, increment nextId, store the ticket, and return it.

            return null;
        } else {
            // TODO 1.3: Handle the update of an existing ticket.
            // Locate the ticket by its ID, update all its fields, and return it.
            // If no ticket with that ID is found, the update must fail.

            return null;
        }
    }

    public void deleteTicket(Long ticketId) {
        // TODO 1.4: Remove the ticket with the given ID from the list.
    }
}