import junit.framework.TestCase;
import org.uispec4j.Button;
import org.uispec4j.Trigger;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.pitt.flashcard.Security;
import edu.pitt.flashcard.User;

public class stepDefinitions extends UISpecTestCase {

	

	@Given("^the user enters a registered name:Li$")
	public void the_user_enters_a_registered_name_Li() throws Throwable {
		String login = "Li";
	}

	@Given("^a unmatched password$")
	public void a_unmatched_password() throws Throwable {
		Integer password = 123;
	}

	@When("^the user clicks the login button$")
	public void the_user_clicks_the_login_button() throws Throwable {
		Security security = new Security();
		User user = new User("Li", "123");
		TestCase.assertEquals(security.validateLogin("Li", "123"), user);
	}

	@Then("^the user will receive the pop up message ‘User did not exist’$")
	public void the_user_will_receive_the_pop_up_message_User_did_not_exist()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Log In");

		window.getTextBox("User Name").setText("Li");
		window.getTextBox("Password").setText("123");

		WindowInterceptor.init(window.getButton("Log In").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog.containsLabel("User did not exist"));
						return dialog.getButton("OK").triggerClick();
					}
				}).run();
	}

	@Given("^the user enters unregistered user name: Don$")
	public void the_user_enters_unregistered_user_name_Don() throws Throwable {
		String login = "Don";
	}

	@Given("^the password$")
	public void the_password() throws Throwable {
		String password = "1231";
	}

	@When("^the user clicks the login button$")
	public void the_user_clicks_the_login_button2() throws Throwable {
		Security security = new Security();
		User user = new User("Don", "1231");
		TestCase.assertEquals(security.validateLogin("Don", "1231"), user);
	}

	@Then("^the user will receive the pop up message ‘User did not exist’$")
	public void the_user_will_receive_the_pop_up_message_User_did_not_exist2()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Log In");

		window.getTextBox("User Name").setText("Don");
		window.getTextBox("Password").setText("1231");

		WindowInterceptor.init(window.getButton("Log In").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog.containsLabel("User did not exist"));
						return dialog.getButton("OK").triggerClick();
					}
				}).run();
	}

	@Given("^the use enters both correct user name and password \\(for example: user name: Li password: (\\d+)\\)$")
	public void the_use_enters_both_correct_user_name_and_password_for_example_user_name_Li_password_(
			int arg1) throws Throwable {
		String login = "Li";
		String password = "1231";
	}

	@When("^user clicks login$")
	public void user_clicks_login() throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Log In");

		window.getTextBox("User Name").setText("Li");
		window.getTextBox("Password").setText("1231");

		WindowInterceptor.init(window.getButton("Log In").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertEquals(dialog.getLabel(),
								"Flash Karten for Beginners");
						return null;
					}

				}).run();
	}

	@Then("^the user can see the welcome window$")
	public void the_user_can_see_the_welcome_window() throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Log In");

		window.getTextBox("User Name").setText("Li");
		window.getTextBox("Password").setText("1231");

		WindowInterceptor.init(window.getButton("Log In").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertEquals(dialog.getLabel(),
								"Flash Karten for Beginners");
						return null;
					}

				}).run();
	}

	@Given("^the user only enters user name or password$")
	public void the_user_only_enters_user_name_or_password() throws Throwable {
		String userName = "li";
	}

	@Then("^the window will pops up ‘you must enter login name and password’$")
	public void the_window_will_pops_up_you_must_enter_login_name_and_password()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Log In");

		window.getTextBox("User Name").setText("li");

		WindowInterceptor.init(window.getButton("Log In").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog
								.containsLabel("You must enter login name and password."));
						return dialog.getButton("OK").triggerClick();
					}
				}).run();
	}

	@Given("^the user enters the German word$")
	public void the_user_enters_the_German_word() throws Throwable {
		String germanWord = "Regierung";
	}

	@Given("^the user enters an English translation$")
	public void the_user_enters_an_English_translation() throws Throwable {
		String translation = "government";
	}

	@When("^the user clicks ‘Create’$")
	public void the_user_clicks_Create1() throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Create");

		WindowInterceptor.init(window.getButton("Create").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						return null;
					}
				}).run();

	}

	@Then("^the flash card will be created and stored in the database$")
	public void the_flash_card_will_be_created_and_stored_in_the_database()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Create");

		WindowInterceptor.init(window.getButton("Create").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						return null;
					}
				}).run();
	}

	@Given("^the user does not enter any English translation$")
	public void the_user_does_not_enter_any_English_translation()
			throws Throwable {
		String german = "Regierung";
		String translation = "";
	}

	@Then("^the user will receive the a pop-up message ‘You must enter an English translation’$")
	public void the_user_will_receive_the_a_pop_up_message_You_must_enter_an_English_translation()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Create");

		window.getTextBox("Enter Word").setText("Regierung");
		window.getTextBox("Enter Translation").setText("");

		WindowInterceptor.init(window.getButton("Create").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog
								.containsLabel("You must enter the translation"));
						return dialog.getButton("OK").triggerClick();
					}
				}).run();

	}

	@Given("^the user enters the translation$")
	public void the_user_enters_the_translation() throws Throwable {
		String translation = "government";
	}

	@Given("^the leaves the German word blank$")
	public void the_leaves_the_German_word_blank() throws Throwable {
		String german = "";
	}

	@When("^the user clicks 'Create'$")
	public void the_user_clicks_Create() throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Create");

		WindowInterceptor.init(window.getButton("Create").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						return null;
					}
				}).run();
	}

	@Then("^the user will receive the popup message 'You must enter a German word'$")
	public void the_user_will_receive_the_popup_message_You_must_enter_a_German_word()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Create");

		WindowInterceptor.init(window.getButton("Create").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog
								.containsLabel("You must enter a german word!"));
						return dialog.getButton("OK").triggerClick();
					}
				}).run();

	}

	@Given("^the user enters the button new word$")
	public void the_user_enters_the_button_new_word() throws Throwable {

	}

	@Then("^the user will see there is a German word in the Quiz screen$")
	public void the_user_will_see_there_is_a_German_word_in_the_Quiz_screen()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("New Word");

		WindowInterceptor.init(window.getButton("New Word").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog.getTextBox() != null);
						return dialog.getButton("OK").triggerClick();
					}
				}).run();

	}

	@Given("^a German word in the Quiz screen window$")
	public void a_German_word_in_the_Quiz_screen_window() throws Throwable {
		String word = "Regierung";
	}

	@When("^the user clicks ‘Check Answer’$")
	public void the_user_clicks_Check_Answer() throws Throwable {

	}

	@Then("^another window will pop up and say ‘you are correct’$")
	public void another_window_will_pop_up_and_say_you_are_correct()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Check Answer");

		WindowInterceptor.init(window.getButton("Check Answer").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						return null;
					}
				}).run();

	}

	@When("^the user clicks ‘Next’$")
	public void the_user_clicks_Next() throws Throwable {

	}

	@When("^the user clicks ‘New word’$")
	public void the_user_clicks_New_word() throws Throwable {

	}

	@Then("^the next German word will appear on the screen$")
	public void the_next_German_word_will_appear_on_the_screen()
			throws Throwable {
		Window window = getMainWindow();
		Button LoginButton = window.getButton("Next");

		WindowInterceptor.init(window.getButton("Next").triggerClick())
				.process(new WindowHandler() {
					public Trigger process(Window dialog) {
						assertTrue(dialog.containsLabel("Enter Translation"));
						return dialog.getButton("New Word").triggerClick();
					}
				}).run();
	}
}
