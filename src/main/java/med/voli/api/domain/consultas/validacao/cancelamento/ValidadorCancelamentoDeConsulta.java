package med.voli.api.domain.consultas.validacao.cancelamento;

import med.voli.api.domain.consultas.dto.cancelamento.*;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsultaDto dados);

}

