package net.javaguides.ems_backend.entity;

import jakarta.persistence.*; // Utilisez javax.persistence si Jakarta n'est pas utilisé
import java.time.LocalDate;

@Entity
@Table(name = "Residents") // Nom de la table dans la base de données
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrément
    private Long idResident;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false) // Association avec la table des utilisateurs
    private User user; // Classe User qui représente la table "Users"

    @ManyToOne
    @JoinColumn(name = "id_room", nullable = false) // Association avec la table des chambres
    private Room room; // Classe Room qui représente la table "Rooms"

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    // Getters et Setters
    public Long getIdResident() {
        return idResident;
    }

    public void setIdResident(Long idResident) {
        this.idResident = idResident;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    // Constructeurs
    public Resident() {}

    public Resident(User user, Room room, LocalDate enrollmentDate, Boolean isActive) {
        this.user = user;
        this.room = room;
        this.enrollmentDate = enrollmentDate;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "idResident=" + idResident +
                ", user=" + user +
                ", room=" + room +
                ", enrollmentDate=" + enrollmentDate +
                ", isActive=" + isActive +
                '}';
    }
}
