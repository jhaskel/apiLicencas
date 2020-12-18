package com.doisbitsw.licencas.api.empreendedor;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpreendedorService {

    @Autowired

    private EmpreendedorRepository rep;
    public List<EmpreendedorDTO> getEmpreendedorr() {
        List<EmpreendedorDTO> list = rep.findAll().stream().map(EmpreendedorDTO::create).collect(Collectors.toList());
        return list;
    }

    public EmpreendedorDTO getEmpreendedorById(Long id) {
        Optional<Empreendedor> empreendedor = rep.findById(id);
        return empreendedor.map(EmpreendedorDTO::create).orElseThrow(() -> new ObjectNotFoundException("Empreendedor não encontrado"));
    }

    

    public EmpreendedorDTO insert(Empreendedor empreendedor) {
        Assert.isNull(empreendedor.getId(),"Não foi possível inserir o registro");
        return EmpreendedorDTO.create(rep.save(empreendedor));
    }

    public EmpreendedorDTO update(Empreendedor empreendedor, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o empreendedor no banco de dados
        Optional<Empreendedor> optional = rep.findById(id);
        if(optional.isPresent()) {
            Empreendedor db = optional.get();
            // Copiar as propriedades
            db.setNome(empreendedor.getNome());
            db.setBairro(empreendedor.getBairro());
            System.out.println("Empreendedor id " + db.getId());

            // Atualiza o empreendedor
            rep.save(db);

            return EmpreendedorDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
