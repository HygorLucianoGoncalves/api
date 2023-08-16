package med.voli.api.domain.consultas.repository;

import med.voli.api.domain.consultas.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
