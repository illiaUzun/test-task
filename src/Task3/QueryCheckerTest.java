package Task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryCheckerTest {

    @Test
    void isNormalized() {
        QueryChecker queryChecker = new QueryChecker("g{fsdfg}s");

        assertEquals(true, queryChecker.isNormalized());

        queryChecker.setQuery("g{f(sd)fg}s");
        assertEquals(true, queryChecker.isNormalized());

        queryChecker.setQuery("{g{fsdfg}s");
        assertEquals(false, queryChecker.isNormalized());

        queryChecker.setQuery("{{[cc(c)ggg]}ssss}");
        assertEquals(true, queryChecker.isNormalized());

        queryChecker.setQuery("{{[cc(c)ggg]}ssss}{");
        assertEquals(false, queryChecker.isNormalized());

    }
}