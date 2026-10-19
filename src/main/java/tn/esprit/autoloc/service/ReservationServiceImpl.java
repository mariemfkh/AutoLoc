package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import tn.esprit.autoloc.entities.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;
import tn.esprit.autoloc.service.ReservationService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional(readOnly = true)
    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation introuvable avec l'id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation update(Long id, Reservation reservation) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation introuvable avec l'id : " + id);
        }
        reservation.setIdReservation(id);
        return reservationRepository.save(reservation);
    }

    @Override
    public void delete(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation introuvable avec l'id : " + id);
        }
        reservationRepository.deleteById(id);
    }
}
