package com.doisbitsw.licencas.api.empreendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/empreendedor1")

public class EmpreendedorController {
    @Autowired
    private EmpreendedorService service;


    @GetMapping()
    public ResponseEntity get() {
        List<EmpreendedorDTO> carros = service.getEmpreendedorr();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        EmpreendedorDTO carro = service.getEmpreendedorById(id);

        return ResponseEntity.ok(carro);
    }

    @PostMapping

    public ResponseEntity post(@RequestBody Empreendedor empreendedor) {

        EmpreendedorDTO c = service.insert(empreendedor);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Empreendedor empreendedor) {

        empreendedor.setId(id);

        EmpreendedorDTO c = service.update(empreendedor, id);

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
