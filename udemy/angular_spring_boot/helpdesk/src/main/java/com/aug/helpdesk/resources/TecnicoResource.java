package com.aug.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aug.helpdesk.domain.Tecnico;
import com.aug.helpdesk.domain.dtos.TecnicoDTO;
import com.aug.helpdesk.services.TecnicoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        Tecnico tecnico = tecnicoService.findById(id);
        return ResponseEntity.ok().body(new TecnicoDTO(tecnico));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        List<Tecnico> list = tecnicoService.findAll();
        List<TecnicoDTO> listDto = list.stream().map(obj -> new TecnicoDTO(obj))
            .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping()
    public ResponseEntity<TecnicoDTO> save(@Valid @RequestBody TecnicoDTO tec) {        
        Tecnico tecnico = tecnicoService.save(tec);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}").buildAndExpand(tecnico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    

}
