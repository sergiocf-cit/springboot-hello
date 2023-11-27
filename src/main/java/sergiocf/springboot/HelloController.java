package sergiocf.springboot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@RestController
public class HelloController {

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s! Version: %s", name, buildVersion);
    }

    @GetMapping("/performance")
    public String performance(@RequestParam(value = "loop") Integer loop) {
        AtomicReference<Double> result = new AtomicReference<>((double) 0);

        IntStream.range(0, loop).forEach(i -> {
            Random random = new Random();
           result.set(Math.tan(result.get() + Math.sqrt(random.nextDouble()) / random.nextDouble()));
        });

        return "Done: " + result.get();
    }
}
