package viewModels

 import io.mockk.mockk
 import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
 import androidx.lifecycle.Observer
import data.User
 class LogInViewModelTest {

	@Test
	fun `updatePassword() should update the password live data`() {

 		val user = mockk<User>()

 		val viewModel = LogInViewMode(user)

 		val observer = mockk<Observer<String>>(relaxed = true)
		viewModel.passwordTextField.observeForever(observer)

 		viewModel.updatePassword("newPassword")

 		assertEquals("newPassword", viewModel.passwordTextField.value)
	}

	@Test
	fun `updateEmail() should update the email live data`() {

		// Create the mock User
		val user = mockk<User>()

		// Create the system under test
		val viewModel = LogInViewMode(user)

		// Collect the emitted live data for later verification
		val observer = mockk<Observer<String>>(relaxed = true)
		viewModel.emailTextField.observeForever(observer)

		// Execute the function under test
		viewModel.updateEmail("newEmail@example.com")

		// Assert that the LiveData was updated correctly
		assertEquals("newEmail@example.com", viewModel.emailTextField.value)
	}

	@Test
	fun `validateEntries() should return true when all fields are valid`() {

 		val user = mockk<User>()

 		val viewModel = LogInViewMode(user)

 		viewModel.updateEmail("valid@example.com")
		viewModel.updatePassword("validPassword")

 		val isValid = viewModel.validateEntries()

 		assertTrue(isValid)
		assertFalse(viewModel.isEmailError.value ?: true)
		assertFalse(viewModel.isPasswordError.value ?: true)
	}

	@Test
	fun `validateEntries() should return false when any field is invalid`() {

 		val user = mockk<User>()

 		val viewModel = LogInViewMode(user)

 		viewModel.updateEmail("")
		viewModel.updatePassword("")

 		val isValid = viewModel.validateEntries()

 		assertFalse(isValid)
		assertTrue(viewModel.isEmailError.value ?: false)
		assertTrue(viewModel.isPasswordError.value ?: false)
	}

	@Test
	fun `clearTextFields() should reset all text fields to empty`() {


		val user = mockk<User>()

		val viewModel = LogInViewMode(user)


		viewModel.updateEmail("john@example.com")
		viewModel.updatePassword("password123")


		viewModel.clearTextFields()

 		assertEquals("", viewModel.emailTextField.value)
		assertEquals("", viewModel.passwordTextField.value)
	}
}
