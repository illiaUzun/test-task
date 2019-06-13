package Task3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class NormalizationCheckController {

    @GetMapping(path = "/isnormalized", produces = "application/json")
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
