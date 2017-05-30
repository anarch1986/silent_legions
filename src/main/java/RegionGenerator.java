import com.anarch1986.silent_legions.region_generator.Region;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.redirect;

/**
 * Created by tomi on 2017.05.30..
 */
public class RegionGenerator {
    static Map params = new HashMap<>();
    static Region region = new Region();

    public static void main(String[] args) {
        get("/", (req, res) ->
        {
            params.put("terrains", region.getTerrains());
            params.put("terrain", region.terrain);
            params.put("name", region.name);
            return new ThymeleafTemplateEngine().
                    render(new ModelAndView(params, "index"));
        });

        get("/random_terrain", (req, res) ->
        {
            region.terrainGenerator();
            res.redirect("/");
            return new ThymeleafTemplateEngine().
                    render(new ModelAndView(params, "index"));
        });

        get("/terrain/:terr", (req, res) ->
        {
            String choosenTerrain = req.params(":terr");
            region.terrain = choosenTerrain;
            res.redirect("/");
            return new ThymeleafTemplateEngine().
                    render(new ModelAndView(params, "index"));
        });

//        get("/terrain/:terr", (req, res) ->
//        {
//            String choosenTerrain = req.params(":terr");
//            region.terrain= choosenTerrain;
//            res.redirect("/");
//            return new ThymeleafTemplateEngine().
//                    render(new ModelAndView(params, "index"));
//        });
//
//        request.queryParams("first_name")
    }

}
