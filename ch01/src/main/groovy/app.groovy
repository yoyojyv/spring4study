import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by yoyojyv on 3/17/15.
 */
@Controller
class MyApp {

    // run
    // $ spring run ch01/src/main/groovy/app.groovy

    @RequestMapping('/')
    @ResponseBody
    String message() {
        return '<h1>Hello World</h1>'
    }

}
