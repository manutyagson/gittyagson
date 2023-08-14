package com.path.holidayairways.controller;

import java.net.InetAddress;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.path.holidayairways.dto.FlightDto;
import com.path.holidayairways.entity.ConcessionType;
import com.path.holidayairways.entity.FlightAdmin;
import com.path.holidayairways.entity.FlightDesc;
import com.path.holidayairways.entity.FlightDetails;
import com.path.holidayairways.entity.FlightEconomy;
import com.path.holidayairways.entity.FlightMaster;
import com.path.holidayairways.entity.RegisterAs;
import com.path.holidayairways.repo.FlightEconomyRepository;
import com.path.holidayairways.repo.RegisterAsRepository;
import com.path.holidayairways.service.ConcessionTypeService;
import com.path.holidayairways.service.FlightAdminService;
import com.path.holidayairways.service.FlightDescService;
import com.path.holidayairways.service.FlightDetailsService;
import com.path.holidayairways.service.FlightMasterService;
import com.path.holidayairways.serviceImpl.EmailService;

/**
 * 
 * 			@author Manu Tyagi
 * 
 *         This is the flight admin controller code
 * 
 *         demonstrates the flight admin controlling of flights
 *         
 *         The {@value} annotation is used to read message from properties file
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	private static String url = "admin/loginAdmin";
	private static String loginAdmin = url;

	@Autowired
	private RegisterAsRepository registerAsRepository;

	@Autowired
	private FlightEconomyRepository flightEconomyRepository;

	@Autowired
	private ConcessionTypeService concessionTypeService;

	@Autowired
	private FlightAdminService flightAdminService;

	@Autowired
	private FlightMasterService flightMasterService;

	@Autowired
	private FlightDescService flightDescService;

	@Autowired
	private FlightDetailsService flightDetailsService;

	@Autowired
	private EmailService emailService;

	// Messages are being read from application.properties file and set into variables
	@Value("${holiday-airways.admin.loginFail}")
	private String loginFail;

	@Value("${holiday-airways.admin.registration}")
	private String registration;

	@Value("${holiday-airways.admin.logout}")
	private String logout;

	@Value("${holiday-airways.admin.flightMasterMessage}")
	private String flightMasterDetails;

	@Value("${holiday-airways.admin.flightDescMessage}")
	private String flightDescDetails;

	@Value("${holiday-airways.admin.flightDetailsMessage}")
	private String flightDetailsMessage;

	@Value("${holiday-airways.admin.forgotPasswordMessage}")
	private String forgotPassword;
	
	@Value("${holiday-airways.admin.registrationSuccessfull}")
	private String success;
	
	@Value("${holiday-airways.admin.setFrom}")
	private String setFrom;
	
    /**
     * Declaring variable for sessionLogOut
     */
	
	@Value("${holiday-airways.admin.sessionLogoutMessage}")
	private String sessionLogOut;
	
	@Value("${holiday-airways.admin.updateAdmin}")
	private String updateAdmin;
	
	

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/registerAdmin")
	public String adminRegister(Model model) {

		List<RegisterAs> registerAsList = registerAsRepository.findAll();

		model.addAttribute("registerAsList", registerAsList);
		model.addAttribute("registerAs", new RegisterAs());
		model.addAttribute("adminUser", new FlightAdmin());
		
		return "admin/adminRegistration";

	}

	/**
	 * 
	 * @param flightAdmin
	 * @param model
	 * @return
	 * @throws UnknownHostException
	 */

	@PostMapping("/registerFlightAdmin")
	public String registerAdmin(@ModelAttribute("adminUser") FlightAdmin flightAdmin, Model model,RegisterAs registerAs)
			throws UnknownHostException {

		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		flightAdmin.setIpAddress(ipAddress);
		
		flightAdmin.setCreatedBy(registerAs.getRegisterAs());
	
		flightAdminService.saveFlightAdmin(flightAdmin);

		SimpleMailMessage emailMessage = new SimpleMailMessage();
		emailMessage.setTo(flightAdmin.getEmailAddress());

		emailMessage.setSubject(success);
		emailMessage.setFrom(setFrom);
		emailMessage.setText("EmailId:"+flightAdmin.getEmailAddress()+"Password"+flightAdmin.getPassword());
		emailService.sendMail(emailMessage);
		
		model.addAttribute("registration", registration);
		return "admin/adminRegistration";

	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String getLogin() {
		return loginAdmin;

	}

	/**
	 * 
	 * @param emailAddress
	 * @param password
	 * @param model
	 * @return
	 */

	@PostMapping("/adminDashboard")
	public String loginPage(@RequestParam("emailAddress") String emailAddress,
			@RequestParam("password") String password, Model model) {

		if (emailAddress != null && password != null) {
			FlightAdmin flightAdmin = flightAdminService.findByEmailAddressAndPassword(emailAddress, password);

			if (flightAdmin != null) {

				if (flightAdmin.getEmailAddress().equalsIgnoreCase(emailAddress)
						&& flightAdmin.getPassword().equalsIgnoreCase(password)) {

					String firstName = flightAdmin.getFirstName().toUpperCase();
					String role = flightAdmin.getRegisterAs();

					model.addAttribute("firstName", firstName);
					model.addAttribute("role", role);
				}

			}

			else {
				model.addAttribute("loginFail", loginFail);
				return loginAdmin;
			}

		}
		return "admin/adminDashboard";

	}

	/**
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping("/logout")
	public String logoutPage(Model model) {

		model.addAttribute("logout", logout);
		return "admin/loginAdmin";

	}

	@GetMapping("/flight-addition")
	public String displayFlightMaster(Model model) {

		model.addAttribute("flightMaster", new FlightMaster());
		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();

		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();
		model.addAttribute("firstName", firstName);

		return "admin/flight_addition_screen1";

	}

	/**
	 * 
	 * @param flightMaster
	 * @param flDesc
	 * @return
	 */
	@PostMapping("/flight-addition")
	public String addFlightMaster(@ModelAttribute("flightMaster") FlightMaster flightMaster, Model model) {

		flightMasterService.saveFlightMaster(flightMaster);
		model.addAttribute("flightMasterDetails",  flightMasterDetails);
		return "redirect:/flight-addition";

	}

	/**
	 * 
	 * @param model
	 * @param flightNo
	 * @param flightEconomy
	 * @return
	 */
	@GetMapping("/flight-desc")
	public String displayFlightDesc(Model model, String flightNo, String flightEconomy) {

		List<String> flightNoList = flightMasterService.findByFlightNo(flightNo);
		List<String> economyList = flightEconomyRepository.findEconomyList(flightEconomy);
		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();
		
		//retrieving firstName from the Flight Admin Service
		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();

		model.addAttribute("economyList", economyList);
		model.addAttribute("economy", new FlightEconomy());
		model.addAttribute("flightDesc", new FlightDesc());
		model.addAttribute("flightNoList", flightNoList);
		model.addAttribute("flightNo", new FlightMaster());
		model.addAttribute("firstName", firstName);
		

		return "admin/flight_addition_screen2";
	}

	/**
	 * 
	 * @param flightDesc
	 * @return
	 */

	@PostMapping("/flight-desc")
	public String addFlightDesc(@ModelAttribute("flightDesc") FlightDesc flightDesc,Model model) {

		flightDescService.saveFlightDesc(flightDesc);
		model.addAttribute("flightDescDetails", flightDescDetails);

		return "admin/flight_addition_screen2";

	}

	/**
	 * 
	 * @param model
	 * @param flightNo
	 * @return
	 */
	@GetMapping("/flight-details")
	public String getFlightDetails(Model model, String flightNo) {

		List<String> flightNoList = flightMasterService.findByFlightNo(flightNo);
		List<FlightAdmin> findByRegisterAs = flightAdminService.findByRegisterAs();
		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();

		String registerAs = findByRegisterAs.get(0).getRegisterAs();
		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();

		model.addAttribute("flightDetails", new FlightDetails());
		model.addAttribute("flightNoList", flightNoList);
		model.addAttribute("flightNo", new FlightMaster());
		model.addAttribute("registerAs", registerAs);
		model.addAttribute("firstName", firstName);

		return "admin/flight_addition_screen3";

	}

	@PostMapping("/flight-details")
	public String addFlightDetails(@ModelAttribute("flightDetails") FlightDetails flightDetails,Model model) {

		flightDetailsService.saveFlightDetails(flightDetails);
		model.addAttribute("flightDetailsMessage", flightDetailsMessage);
		return "admin/flight_addition_screen3";

	}

	/**
	 * 
	 * @param flightNo
	 * @param model
	 * @param category
	 * @param details
	 * @return
	 */

	@GetMapping("/flight_modification")
	public String displayFlightModification(String flightNo, Model model, String category, String details) {

		List<String> flightNoList = flightMasterService.findByFlightNo(flightNo);
		List<String> flightCategoryList = flightDescService.findByFlightCategory(category);
		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();
		List<String> flightDetailsList = flightDetailsService.findByFlightDetails(details);

		List<FlightAdmin> findByRegisterAs = flightAdminService.findByRegisterAs();

		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();
		String registerAs = findByRegisterAs.get(0).getRegisterAs();

		model.addAttribute("flightNoList", flightNoList);
		model.addAttribute("flightNo", new FlightMaster());
		model.addAttribute("flightCategoryList", flightCategoryList);
		model.addAttribute("flightCategory", new FlightDesc());
		model.addAttribute("firstName", firstName);

		model.addAttribute("registerAs", registerAs);

		model.addAttribute("flightDetailsList", flightDetailsList);
		model.addAttribute("flightDetails", new FlightDetails());

		return "admin/flight_modification";

	}

	/**
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping("/view-flights")
	public String viewFlightDetails(Model model) {

		List<FlightDto> detailsFromTables = flightMasterService.getAllFlightDetailsFromAllTables();
		model.addAttribute("flightsList", detailsFromTables);

		return "admin/view-flights";

	}
	
	
	@GetMapping("/update-flight")
	public String displayUpdateFlightDetails(Model model) {
		return "admin/updateFlight";
		
	}

	/**
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping("/flight-deletion")
	public String displayFlightDeletion(Model model,String flightNo) {

		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();
		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();
		List<String> flightNoList = flightMasterService.findByFlightNo(flightNo);

		model.addAttribute("firstName", firstName);
		model.addAttribute("flightNoList", flightNoList);
		model.addAttribute("flightNo", new FlightMaster());
		

		return "admin/flight_deletion";

	}

	/*
	 * Declare a method for Flight Deletion
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@GetMapping("/forgot-Password")
	public String displayForgotPasswordPage() {
		return "admin/forgotPassword";

	}

	/**
	 * 
	 * @param model
	 * @param flightAdmin
	 * @return
	 */

	@GetMapping("/adminHomePage")
	public String displayAdminHomePage(Model model, FlightAdmin flightAdmin) {

		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();
		List<FlightAdmin> findByLastName = flightAdminService.findByLastName();
		List<FlightAdmin> findByEmailAddress = flightAdminService.findByEmailAddress();
		List<FlightAdmin> findByRegisterAs = flightAdminService.findByRegisterAs();

		String firstName = findByFirstName.get(0).getFirstName();
		String lastName = findByLastName.get(0).getLastName();
		String emailAddress = findByEmailAddress.get(0).getEmailAddress();
		String registerAs = findByRegisterAs.get(0).getRegisterAs();

		model.addAttribute("firstName", firstName.toUpperCase());
		model.addAttribute("lastName", lastName.toUpperCase());
		model.addAttribute("emailAddress", emailAddress);
		model.addAttribute("registerAs", registerAs);

		return "admin/adminHome";

	}
	
	@GetMapping("/update-dashboard")
	public String displayUpdateDasboard(Model model,FlightAdmin flightAdmin) {
		
		return "admin/EditDashboard";
		
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/flight-cancellation")
	public String displayCancellation(Model model) {

		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();

		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();

		List<FlightAdmin> registerAs = flightAdminService.findByRegisterAs();
		String role = registerAs.get(0).getRegisterAs();
		model.addAttribute("firstName", firstName);
		model.addAttribute("registerAs", role);

		return "admin/Cancellation";

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/flight-cancellation-master")
	public String displayCancellationMaster(Model model) {

		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();

		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();
		model.addAttribute("firstName", firstName);

		return "admin/Cancellation_Master";

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/flight-concession-master")
	public String displayConcessionMaster(Model model) {

		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();
		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();
		model.addAttribute("firstName", firstName);

		List<ConcessionType> listOfConcessionType = concessionTypeService.getListOfConcessionType();
		model.addAttribute("concessionTypeList", listOfConcessionType);
		model.addAttribute("concessionType", new ConcessionType());

		return "admin/Concession_Master";

	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/flight-reservation-view")
	public String displayReservationView(Model model) {

		List<FlightAdmin> findByFirstName = flightAdminService.findByFirstName();
		String firstName = findByFirstName.get(0).getFirstName().toUpperCase();

		model.addAttribute("firstName", firstName);

		return "admin/Reservation_View";

	}

}