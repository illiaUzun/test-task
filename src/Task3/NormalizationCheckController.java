package Task3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Controller with two methods that have the same response body
 * and perform the same validation - returning the Object of QueryChecker class
 * in JSON format
 *
 * to create new Query and validate it - just enter url localhost:8080/isnormalized?query=yourquery
 * with GET or POST method
 *
 * for example
 * GET http://localhost:8080/isnormalized?query={g{fsdfg}s}
 * POST http://localhost:8080/isnormalized?query={g{fsdfg}s}
 *
 */

@Controller
public class NormalizationCheckController {

    @GetMapping(path = "/isnormalized")
    @ResponseBody
    public QueryChecker getNormalized(@RequestParam String query) {
        return new QueryChecker(query);
    }

    @PostMapping("/isnormalized")
    @ResponseBody
    public QueryChecker postNormalized(@RequestParam String query) {
        return new QueryChecker(query);
    }

}
