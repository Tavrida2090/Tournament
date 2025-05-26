package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test

    public void testWhenSecondPlayerWin() {
        Player Petya = new Player(123, "Петя", 120);
        Player Vasya = new Player(1241354, "Вася", 100);
        Game game = new Game();
        game.register(Petya);
        game.register(Vasya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player Vasya = new Player(1, "Вася", 120);
        Player Petya = new Player(2, "Петя", 100);
        Game game = new Game();
        game.register(Vasya);
        game.register(Petya);
        int actual = game.round("Вася", "Петя");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenStrengthsEqual() {
        Player Vasya = new Player(1, "Вася", 100);
        Player Petya = new Player(2, "Петя", 100);
        Game game = new Game();
        game.register(Vasya);
        game.register(Petya);
        int actual = game.round("Вася", "Петя");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player Vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(Vasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Жора", "Вася")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player Vasya = new Player(1, "Вася", 100);
        Game game = new Game();

        game.register(Vasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Жора")
        );
    }
}

