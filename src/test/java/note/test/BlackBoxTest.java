package note.test;

import note.controller.NoteController;
import note.exception.ClasaException;
import note.model.Nota;
import note.utils.Constants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BlackBoxTest {
    private NoteController ctrl;

    @Before
    public void init(){
        ctrl = new NoteController();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void test1() throws ClasaException {
        expectedEx.expect(ClasaException.class);
        expectedEx.expectMessage(Constants.invalidNrmatricol);
        Nota nota = new Nota(10.1, "Istorie", 5);
        ctrl.addNota(nota);
    }

    @Test
    public void test2() throws ClasaException {
        Nota nota = new Nota(2, "Istorie", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());
    }


}