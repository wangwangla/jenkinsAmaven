package kw.test.controller.metric;

import io.jboot.Jboot;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

/**
 * auther   kangwang
 */

@RequestMapping("/metric")
public class MetricController extends JbootController {
    public void metric(){
        Jboot.me().getMetric().counter("metric").inc();
        renderText("my action");
    }
}
