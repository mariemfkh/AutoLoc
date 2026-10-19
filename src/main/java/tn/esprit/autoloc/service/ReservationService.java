package tn.esprit.autoloc.service;

import tn.esprit.autoloc.entities.Reservation;
import java.util.List;

public interface ReservationService {

    Reservation create(Reservation reservation);

    Reservation getById(Long id);

    List<Reservation> getAll();

    Reservation update(Long id, Reservation reservation);

    void delete(Long id);
}
