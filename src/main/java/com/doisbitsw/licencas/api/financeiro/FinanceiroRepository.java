package com.doisbitsw.licencas.api.financeiro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {


    @Query(value = "SELECT fin.*, dor.nome as nome,dor.cpf,dor.celular,mento.logradouro,mento.numero,mento.bairro, pro.iscertidao,\n" +
            "pro.caracterizacao,pro.quantidade, pro.atividade, fas.nome as nomefas\n" +
            " FROM financeiro fin\n" +
            "INNER JOIN processo pro ON pro.code = fin.code_processo  \n" +
            "INNER JOIN empreendimento mento ON mento.id = fin.empreendimento\n" +
            "INNER JOIN empreendedor dor ON dor.id = mento.empreendedor\n" +
            "INNER JOIN fases fas ON fas.id = pro.fase\n" +
            "WHERE fin.code_processo = :codeProcesso", nativeQuery = true)
    List<Financeiro> findByCodeProcesso(String codeProcesso);

}
