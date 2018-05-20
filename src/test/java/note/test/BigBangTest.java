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

public class BigBangTest {
    private NoteController ctrl;

    @Before
    public void init(){
        ctrl = new NoteController();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void unitTestFirstRequest() throws ClasaException {
        //A
        Nota nota = new Nota(1, "Desen", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());
    }

    @Test
    public void unitTestSecondRequest() throws ClasaException {
        //B
        Elev e1 = new Elev(1, "ElevA");
        Elev e2 = new Elev(2, "ElevB");
        ctrl.addElev(e1);
        ctrl.addElev(e2);
        Nota n1 = new Nota(1,"Materie1", 10);
        Nota n2 = new Nota(1,"Materie1", 7);
        Nota n3 = new Nota(1,"Materie2", 10);
        Nota n4 = new Nota(1,"Materie2", 10);
        Nota n5 = new Nota(2,"Materie2", 4);
        Nota n6 = new Nota(2,"Materie2", 3);
        Nota n7 = new Nota(2,"Materie2", 6);
        Nota n8 = new Nota(2,"Materie1", 7);
        ctrl.addNota(n1);
        ctrl.addNota(n2);
        ctrl.addNota(n3);
        ctrl.addNota(n4);
        ctrl.addNota(n5);
        ctrl.addNota(n6);
        ctrl.addNota(n7);
        ctrl.addNota(n8);
        ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
        ctrl.afiseazaClasa();
        List<Medie> rezultate = ctrl.calculeazaMedii();
        assertEquals(rezultate.size(),2);
    }

    @Test
    public void unitTestThirdRequest()  throws ClasaException {
        //C
        Elev e1 = new Elev(1, "ElevA");
        Elev e2 = new Elev(2, "ElevB");
        ctrl.addElev(e1);
        ctrl.addElev(e2);
        Nota n1 = new Nota(1,"Materie1", 10);
        Nota n2 = new Nota(1,"Materie1", 7);
        Nota n3 = new Nota(1,"Materie2", 10);
        Nota n4 = new Nota(1,"Materie2", 10);
        Nota n5 = new Nota(2,"Materie2", 4);
        Nota n6 = new Nota(2,"Materie2", 5);
        Nota n7 = new Nota(2,"Materie2", 3);
        Nota n8 = new Nota(2,"Materie1", 7);
        ctrl.addNota(n1);
        ctrl.addNota(n2);
        ctrl.addNota(n3);
        ctrl.addNota(n4);
        ctrl.addNota(n5);
        ctrl.addNota(n6);
        ctrl.addNota(n7);
        ctrl.addNota(n8);
        ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
        List<Corigent> corigenti = ctrl.getCorigenti();
        assertEquals(corigenti.size(),1);
    }

    @Test
    public void integrationTest() throws ClasaException {
        //P->B->A->C

        //cerinta i
        Elev e1 = new Elev(1, "Elev");
        ctrl.addElev(e1);
        Nota nota = new Nota(1, "Matematica", 10);
        ctrl.addNota(nota);
        assertEquals(1, ctrl.getNote().size());

        //cerinta ii
        ctrl.creeazaClasa(ctrl.getElevi(), ctrl.getNote());
        List<Medie> rezultate = ctrl.calculeazaMedii();
        assertEquals(1, rezultate.size());

        //cerinta iii
        List<Corigent> corigenti = ctrl.getCorigenti();
        assertEquals(corigenti.size(),0);
    }
}