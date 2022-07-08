package formation.hopital.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import formation.hopital.Context;
import formation.hopital.dao.IDAOPatient;
import formation.hopital.model.Civilite;
import formation.hopital.model.Patient;

@WebServlet("/patient") // ETAPE 1 : Réception de la Request par le Controller
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IDAOPatient daoPatient = Context.getInstance().getDaoPatient();

	public PatientController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode") != null ? request.getParameter("mode") : "list";

		if (mode.equals("list")) {

			list(request, response);

		} else if (mode.equals("add")) {

			add(request, response);

		} else if (mode.equals("edit")) {

			edit(request, response);

		} else if (mode.equals("save")) {

			save(request, response);

		} else if (mode.equals("cancel")) {

			cancel(request, response);

		} else if (mode.equals("remove")) {

			remove(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ETAPE 2 : récupérer les données
		List<Patient> patients = daoPatient.findAll();

		// ETAPE 3 : renseigner le Model
		request.setAttribute("mesPatients", patients);

		// ETAPE 4 : Forward vers la View (JSP) en passant le Model
		request.getRequestDispatcher("/WEB-INF/views/patient/list.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/patient/form.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));

		Patient patient = daoPatient.findById(id);

		request.setAttribute("monPatient", patient);

		request.getRequestDispatcher("/WEB-INF/views/patient/form.jsp").forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = request.getParameter("id") != null && !request.getParameter("id").isBlank()
				? Integer.valueOf(request.getParameter("id"))
				: 0;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Civilite civ = request.getParameter("civ") != null && !request.getParameter("civ").isBlank()
				? Civilite.valueOf(request.getParameter("civ"))
				: null;

		if (id > 0) {
			Patient patient = daoPatient.findById(id);
			patient.setNom(nom);
			patient.setPrenom(prenom);
			patient.setCiv(civ);

			daoPatient.update(patient);
		} else {
			Patient patient = new Patient();

			patient.setNom(nom);
			patient.setPrenom(prenom);
			patient.setCiv(civ);

			daoPatient.insert(patient);
		}

		response.sendRedirect("patient");
	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/patient?mode=list").forward(request, response);

	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));

		Patient patient = daoPatient.findById(id);

		if (patient != null) {
			daoPatient.delete(patient);
		}
		
		response.sendRedirect("patient");
	}

}
