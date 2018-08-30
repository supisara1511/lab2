import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    @Test
    public void createOXOject() {
        OX ox = new OX();
        assertEquals("  0 1 2\n0 - - -\n1 - - -\n2 - - -",ox.getTableToString());
        assertEquals('X',ox.currentPlayer);
        assertEquals(0,ox.scoreX);
        assertEquals(0,ox.scoreO);
        assertEquals(0,ox.scoreD);
    }

    @Test
    public void put() {
        OX ox = new OX();
        ox.put(1,1);
        assertEquals("  0 1 2\n0 - - -\n1 - X -\n2 - - -",ox.getTableToString());

        ox.put(2,1);
        assertEquals("  0 1 2\n0 - - -\n1 - X X\n2 - - -",ox.getTableToString());

        ox.put(0,0);
        assertEquals("  0 1 2\n0 X - -\n1 - X X\n2 - - -",ox.getTableToString());

        ox.swcitchPlayer();
        ox.put(0,2);
        assertEquals("  0 1 2\n0 X - -\n1 - X X\n2 O - -",ox.getTableToString());

        assertEquals(false,ox.put(0,2));

        //assertEquals(false,o,ox.put(0,3));


    }

    @Test
    public void switchPlayer() {
        OX ox = new OX();
        ox.swcitchPlayer();
        assertEquals('O',ox.currentPlayer);

        ox.swcitchPlayer();
        assertEquals('X',ox.currentPlayer);
    }


    @Test
    public void checkWin1() {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(1,0);
        ox.put(2,0);
        assertEquals("  0 1 2\n0 X X X\n1 - - -\n2 - - -",ox.getTableToString());
        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,0));
        assertEquals(true,ox.checkWin(2,0));

    }

    @Test
    public void checkWin2() {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        assertEquals("  0 1 2\n0 X - -\n1 X - -\n2 - - -",ox.getTableToString());
        assertEquals(false,ox.checkWin(0,0));
        assertEquals(false,ox.checkWin(0,1));

    }

    @Test
    public void checkWin3() {
        OX ox = new OX();
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertEquals("  0 1 2\n0 - X -\n1 - X -\n2 - X -",ox.getTableToString());
        assertEquals(true,ox.checkWin(1,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(1,2));

    }

    @Test
    public void checkWin4() {
        OX ox = new OX();
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertEquals("  0 1 2\n0 X - -\n1 - X -\n2 - - X",ox.getTableToString());
        assertEquals(true,ox.checkWin(0,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(2,2));

    }

    @Test
    public void checkWin5() {
        OX ox = new OX();
        ox.put(2,0);
        ox.put(1,1);
        ox.put(0,2);
        assertEquals("  0 1 2\n0 - - X\n1 - X -\n2 X - -",ox.getTableToString());
        assertEquals(true,ox.checkWin(2,0));
        assertEquals(true,ox.checkWin(1,1));
        assertEquals(true,ox.checkWin(0,2));

    }

    @Test
    public void checkDraw(){
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertEquals(true,ox.isDraw());


    }
}