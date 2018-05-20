package note.test;

import note.controller.NoteController;
import note.exception.ClasaException;
import note.model.Corigent;
import note.model.Elev;
import note.model.Medie;
import note.model.Nota;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class TopDownTest {
    private NoteController ctrl;

    @Before
    public void init(){
        ctrl = new NoteController();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void unitTestFirstRequest() throws ClasaException {
        Nota nota = new Nota(1, "Desen", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());
    }

    @Test
    public void integrationSecondRequest() throws ClasaException {
        //cerinta i
        expectedEx.expect(ClasaException.class);
         Nota nota = new Nota(1, "Desena", 10);
         ctrl.addNota(nota);

        //cerinta ii
        expectedEx.expect(ClasaException.class);
        //ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
        List<Medie> rezultate = ctrl.calculeazaMedii();
        assertEquals(1, rezultate.size());
    }

    @Test
    public void integrationThirdRequest() throws ClasaException {
        //cerinta i
        expectedEx.expect(ClasaException.class);
        Nota nota = new Nota(1, "Istorie", 10);
        ctrl.addNota(nota);

        //cetinta ii
        expectedEx.expect(ClasaException.class);
        //ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
        List<Medie> rezultate = ctrl.calculeazaMedii();

        //cerinta iii
        expectedEx.expect(ClasaException.class);
        List<Corigent> corigenti = ctrl.getCorigenti();
        assertEquals(corigenti.size(),0);
    }
}