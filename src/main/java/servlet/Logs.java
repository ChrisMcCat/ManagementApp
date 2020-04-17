package servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/logs")
public class Logs extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Inject
	private TemplateProvider templateProvider;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Template template = templateProvider.getTemplate(getServletContext(), "add.ftlh");
		Map<String, Object> model = new HashMap<>();


		try {
			template.process(model, response.getWriter());
		} catch (TemplateException e) {
			logger.error(e.getMessage());
		}
	}
}
