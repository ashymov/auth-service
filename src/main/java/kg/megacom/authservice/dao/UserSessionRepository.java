package kg.megacom.authservice.dao;

import kg.megacom.authservice.models.UserSessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSessions,Long> {
}
