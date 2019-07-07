package br.matheuslima.notes.notes.repository

import br.matheuslima.notes.notes.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note,Long>{

    fun findByTitle(title:String): Note
}