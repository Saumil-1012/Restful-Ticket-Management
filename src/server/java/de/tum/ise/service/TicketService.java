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
        // 1.2: return a COPY, not the internal list
        return new ArrayList<>(tickets);
    }

    public Optional<Ticket> findTicketById(Long ticketId) {
        // 1.1: iterate and wrap in Optional
        for (Ticket t : tickets) {
            if (t.getId().equals(ticketId)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public Ticket saveTicket(Ticket ticket) {
        if (ticket.getId() == null) {
            // 1.1: create -> assign sequential ID, store, return
            ticket.setId(nextId++);
            tickets.add(ticket);
            return ticket;
        } else {
            // 1.3: update -> find existing, copy all fields; null if it does not exist
            Optional<Ticket> existing = findTicketById(ticket.getId());
            if (existing.isEmpty()) {
                return null;
            }
            Ticket stored = existing.get();
            stored.setTitle(ticket.getTitle());
            stored.setDescription(ticket.getDescription());
            stored.setPriority(ticket.getPriority());
            stored.setStatus(ticket.getStatus());
            return stored;
        }
    }

    public void deleteTicket(Long ticketId) {
        // 1.4: remove by ID
        tickets.removeIf(t -> t.getId().equals(ticketId));
    }
}
