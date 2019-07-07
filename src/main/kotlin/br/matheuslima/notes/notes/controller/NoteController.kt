package br.matheuslima.notes.notes.controller

import br.matheuslima.notes.notes.model.Note
import br.matheuslima.notes.notes.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("notes")
class NoteController {

    @Autowired
    lateinit var noteRepository: NoteRepository

    @GetMapping
    fun list(): List<Note>{
        return noteRepository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody note: Note):Note{
        return noteRepository.save(note)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id:Long,@RequestBody note: Note):Note{
        if(noteRepository.existsById(id)){
            val safenote = note.copy(id)
            return noteRepository.save(safenote)
        }
        return Note()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long){
        if(noteRepository.existsById(id)){
            noteRepository.deleteById(id)
        }
    }

}