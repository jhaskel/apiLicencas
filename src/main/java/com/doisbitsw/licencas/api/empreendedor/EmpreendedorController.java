package com.doisbitsw.licencas.api.empreendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empreendedor")

public class EmpreendedorController {
    @Autowired
    private EmpreendedorService service;

    @GetMapping()
    public ResponseEntity get() {
        List<EmpreendedorDTO> contato = service.getEmpreendedorr();
        return ResponseEntity.ok(contato);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Empreendedor pontuacao) {

        EmpreendedorDTO c = service.insert(pontuacao);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{empreendedor}")
    public ResponseEntity put(@PathVariable("empreendedor") Long empreendedor, @RequestBody Empreendedor pontuacao) {

        pontuacao.setId(empreendedor);

        EmpreendedorDTO c = service.update(pontuacao, empreendedor);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
