import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class CohortController {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        staticFileLocation("/public");

        Cohort cohort = new Cohort(20);

        get("/random", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            model.put("student", cohort.getRandomStudent());
            model.put("template", "random.vtl");

            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/pair", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            model.put("student1", cohort.getStudentPair().get(0));
            model.put("student2", cohort.getStudentPair().get(1));
            model.put("template", "pair.vtl");

            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);

        get("/group/:num", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            int num = Integer.parseInt(req.params(":num"));
            model.put("students", cohort.getNumStudents(num));
            model.put("template", "randomNum.vtl");

            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);


    }

}
