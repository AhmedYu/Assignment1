package viewModels
import data.User
import io.mockk.mockk
import androidx.lifecycle.Observer
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

 class CreateAccountViewModelTest {

	private lateinit var viewModel: CreateAccountViewModel
	private lateinit var user: User

	@BeforeEach
	fun setUp() {
		user = mockk(relaxed = true)
		viewModel = CreateAccountViewModel(user)
	}

	@Test
	fun `updatePassword() should update the password live data`() {
		val observer = mockk<Observer<String>>(relaxed = true)
		viewModel.passwordTextField.observeForever(observer)

		viewModel.updatePassword("newPassword")

		assertEquals("newPassword", viewModel.passwordTextField.value)
	}

	@Test
	fun `updateEmail() should update the email live data`() {
		val observer = mockk<Observer<String>>(relaxed = true)
		viewModel.emailTextField.observeForever(observer)

		viewModel.updateEmail("newEmail@example.com")

		assertEquals("newEmail@example.com", viewModel.emailTextField.value)
	}

	@Test
	fun `updateNameTextFieldValue() should update the name live data`() {
		val observer = mockk<Observer<String>>(relaxed = true)
		viewModel.nameTextFieldValue.observeForever(observer)

		viewModel.updateNameTextFieldValue("newName")

		assertEquals("newName", viewModel.nameTextFieldValue.value)
	}

	@Test
	fun `validateEntries() should return true when all fields are valid`() {
		viewModel.updateNameTextFieldValue("Valid Name")
		viewModel.updateEmail("valid@example.com")
		viewModel.updatePassword("validPassword")

		val isValid = viewModel.validateEntries()

		assertTrue(isValid)
		assertFalse(viewModel.isNameError.value!!)
		assertFalse(viewModel.isEmailError.value!!)
		assertFalse(viewModel.isPasswordError.value!!)
	}

	@Test
	fun `validateEntries() should return false when any field is invalid`() {
		viewModel.updateNameTextFieldValue("")
		viewModel.updateEmail("")
		viewModel.updatePassword("")

		val isValid = viewModel.validateEntries()

		assertFalse(isValid)
		assertTrue(viewModel.isNameError.value!!)
		assertTrue(viewModel.isEmailError.value!!)
		assertTrue(viewModel.isPasswordError.value!!)
	}

	@Test
	fun `resetErrors() should clear all error live data`() {
		viewModel.isNameError.value = true
		viewModel.isEmailError.value = true
		viewModel.isPasswordError.value = true

		viewModel.resetErrors()

		assertFalse(viewModel.isNameError.value!!)
		assertFalse(viewModel.isEmailError.value!!)
		assertFalse(viewModel.isPasswordError.value!!)
	}

	@Test
	fun `clearTextFields() should reset all text fields to empty`() {
		viewModel.updateNameTextFieldValue("John Doe")
		viewModel.updateEmail("john@example.com")
		viewModel.updatePassword("password123")

		viewModel.clearTextFields()

		assertEquals("", viewModel.nameTextFieldValue.value)
		assertEquals("", viewModel.emailTextField.value)
		assertEquals("", viewModel.passwordTextField.value)
	}
}
