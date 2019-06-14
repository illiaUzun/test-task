package Task3;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QueryCheckerTest {

    @BeforeAll
    void init(){
        DemoApplication.main(new String[]{});
    }
    //Test {g{fsdfg}s} query with GET method
    @Test
    void isNormalizedGET() throws JSONException, IOException {
        String url = "http://localhost:8080/isnormalized?query={g{fsdfg}s}";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        JSONObject myResponse = new JSONObject(response.toString());
        in.close();

        assertEquals("true", myResponse.getString("normalized"));

    }

    //Test {g{fs([efefefwefwef<<dwedw>dw>d]f)g}} query with GET method
    @Test
    void isNormalizedPOST() throws JSONException, IOException {
        String url = "http://localhost:8080/isnormalized?query={g{fs([efefefwefwef<<dwedw>dw>d]f)g}}";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("POST");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        JSONObject myResponse = new JSONObject(response.toString());
        in.close();

        assertEquals("true", myResponse.getString("normalized"));

    }

    @Test
    void isNormalizedStack1() {
        QueryChecker queryChecker = new QueryChecker("g{f(sd)fg}s");
        assertEquals(true, queryChecker.checkNormalizationStack());
    }

    @Test
    void isNormalizedStack2() {
        QueryChecker queryChecker = new QueryChecker("{g{fsdfg}s");
        assertEquals(false, queryChecker.checkNormalizationStack());

    }

    @Test
    void isNormalizedStack3() {
        QueryChecker queryChecker = new QueryChecker("{{[cc(c)ggg]}ssss}");
        assertEquals(true, queryChecker.checkNormalizationStack());

    }

    @Test
    void isNormalizedStack4() {
        QueryChecker queryChecker = new QueryChecker("{{[cc(c)ggg]}ssss}{");
        assertEquals(false, queryChecker.checkNormalizationStack());
    }

    @Test
    void isNormalizedDeque1() {
        QueryChecker queryChecker = new QueryChecker("g{f(sd)fg}s");
        assertEquals(true, queryChecker.checkNormalizationDeque());
    }

    @Test
    void isNormalizedDeque2() {
        QueryChecker queryChecker = new QueryChecker("{g{fsdfg}s");
        assertEquals(false, queryChecker.checkNormalizationDeque());

    }

    @Test
    void isNormalizedDeque3() {
        QueryChecker queryChecker = new QueryChecker("{{[cc(c)ggg]}ssss}");
        assertEquals(true, queryChecker.checkNormalizationDeque());

    }

    @Test
    void isNormalizedDeque4() {
        QueryChecker queryChecker = new QueryChecker("{{[cc(c)ggg]}ssss}{");
        assertEquals(false, queryChecker.checkNormalizationDeque());
    }
}