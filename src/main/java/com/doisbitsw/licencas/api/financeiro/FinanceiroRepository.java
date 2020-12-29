package com.doisbitsw.licencas.api.financeiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {


    @Query(value = "SELECT fin.*, mento.nome as nomedor\n" +
            " FROM financeiro fin\n" +
            "INNER JOIN empreendimento mento ON mento.id = fin.empreendimento\n" +
            "WHERE fin.code_processo = :codeProcesso", nativeQuery = true)
    List<Financeiro> findByCodeProcesso(String codeProcesso);

}
