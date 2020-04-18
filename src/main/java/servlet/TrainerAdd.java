package servlet;

import dao.TrainerDao;
import domain.Trainer;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/add")
public class TrainerAdd extends HttpServlet {

	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Inject
	private TemplateProvider templateProvider;

	@Inject
	private TrainerDao trainerDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Template template = templateProvider.getTemplate(getServletContext(), "add.ftlh");
		Map<String, Object> model = new HashMap<>();

		try {
			template.process(model, response.getWriter());
		} catch (TemplateException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String phoneNumber = request.getParameter("phoneNumber");
		String mail = request.getParameter("mail");

		logger.info("name {}", name);
		logger.info("surname {}", surname);
		logger.info("phoneNumber {}", phoneNumber);
		logger.info("mail {}", mail);

		Trainer trainer = new Trainer();
		trainer.setName(name);
		trainer.setSurname(surname);
		trainer.setPhoneNumber(phoneNumber);
		trainer.setMail(mail);

		logger.info("Adding new trainer");

		trainerDao.add(trainer);

		PrintWriter writer = response.getWriter();
		String responseString = "Name: " + name + " Surname: " + surname + " Phone number: " + phoneNumber + " Mail: " + mail;
		writer.println(responseString);
	}
}
