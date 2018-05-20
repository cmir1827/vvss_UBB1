package note.repository;

import java.util.List;

//import utils.ClasaException;

import note.exception.ClasaException;
import note.model.Nota;

public interface NoteRepository {
	
	public void addNota(Nota nota) throws ClasaException;// throws ClasaException;
	public List<Nota> getNote(); 
	public void readNote(String fisier);
	
}
