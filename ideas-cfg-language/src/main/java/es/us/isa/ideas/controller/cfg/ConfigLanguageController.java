package es.us.isa.ideas.controller.cfg;

import es.us.isa.ideas.module.common.AppResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.ideas.util.Util;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Applied Software Engineering Research Group (ISA Group) University of
 * Sevilla, Spain
 *
 * @author Juanlu de la Fuente <jdelafuente@us.es>
 * @version 1.0
 */


@Controller
@RequestMapping("/language")
public class ConfigLanguageController extends BaseLanguageController {

    @RequestMapping(value = "/operation/{id}/execute", method = RequestMethod.POST)
    @ResponseBody
    public AppResponse executeOperation(String id, String content, String fileUri, String auxArg0) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @RequestMapping(value = "/format/{format}/checkLanguage", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public AppResponse checkLanguage(String id, String content, String fileUri) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public AppResponse convertFormat(String currentFormat, String desiredFormat, String fileUri, String content) {
        
        AppResponse appResponse = new AppResponse();
        appResponse.setFileUri(fileUri);
        if (currentFormat.equals("json") && desiredFormat.equals("yaml")) {
            appResponse.setStatus(AppResponse.Status.OK);
            appResponse.setData(Util.convertToYaml(content));
        } else if (currentFormat.equals("yaml") && desiredFormat.equals("json")) {
            appResponse.setStatus(AppResponse.Status.OK);
            appResponse.setData(Util.convertToJson(content));
        }
        return appResponse;
    }

}
