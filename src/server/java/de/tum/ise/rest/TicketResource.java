package de.tum.ise.rest;

import de.tum.ise.model.Ticket;
import de.tum.ise.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketResource {

    private final TicketService ticketService;

    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // 2.1 POST /tickets -> 200 OK, or 400 if the body already has an ID
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        if (ticket.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticketService.saveTicket(ticket));
    }

    // 2.2 GET /tickets/{ticketId} -> 200 OK or 404 Not Found
    @GetMapping("{ticketId}")
    public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") Long ticketId) {
        return ticketService.findTicketById(ticketId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2.3 GET /tickets -> always 200 OK
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    // 2.4 PUT /tickets/{ticketId} -> 200 OK, 400 if IDs differ, 404 if not found
    @PutMapping("{ticketId}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("ticketId") Long ticketId,
                                               @RequestBody Ticket ticket) {
        if (!ticketId.equals(ticket.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Ticket updated = ticketService.saveTicket(ticket);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // 2.5 DELETE /tickets/{ticketId} -> always 204 No Content
    @DeleteMapping("{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.noContent().build();
    }
}
