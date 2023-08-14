package med.voli.api.domain.usuario.repository;

import med.voli.api.domain.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsusarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
