package br.matheuslima.notes.notes.controller

import br.matheuslima.notes.notes.model.Note
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController {

    @GetMapping
    fun list(): List<Note>{
        return listOf(Note("Leitura","Livro de Spring Boot"),
                Note("Pesquisa","Ambiente com Docker"))
    }

    @PostMapping
    fun add(@RequestBody note: Note):Note{
        return note
    }


}