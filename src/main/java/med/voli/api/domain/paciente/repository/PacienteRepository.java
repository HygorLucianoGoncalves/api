package med.voli.api.domain.paciente.repository;

import med.voli.api.domain.paciente.entity.Paciente;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
@Query("select p.ativo from Paciente p where p.id =:id")
    Boolean findAtivoById(Long idPaciente);
    
}
