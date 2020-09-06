package sudokusolver.domain;

import org.junit.Before;
import org.junit.Test;
import sudokusolver.domain.gamelogic.Sudoku;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SudokuTest {
    Sudoku sudoku;

    @Before
    public void before() {
        sudoku = new Sudoku(new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        });
    }
    

    @Test
    public void testLegalMove() {
        boolean legal = sudoku.legalMove(4, 4, 5);
        assertThat(legal, is(true));
    }

    @Test
    public void testLegalMove2() {
        boolean legal = sudoku.legalMove(4, 4, 3);
        assertThat(legal, is(false));
    }

    @Test
    public void testHorizontalMove() {
        boolean legal = sudoku.legalMove(3, 2, 3);
        assertThat(legal, is(false));
    }

    @Test
    public void testVerticalMove() {
        boolean legal = sudoku.legalMove(0, 3, 1);
        assertThat(legal, is(false));
    }

    @Test
    public void testSmallSquare() {
        boolean legal = sudoku.legalMove(7, 7, 2);
        assertThat(legal, is(false));
    }

    @Test
    public void setNode() {
        sudoku.setNode(2, 2, 3);
        assertThat(sudoku.getNode(2, 2), is(3));
    }
}