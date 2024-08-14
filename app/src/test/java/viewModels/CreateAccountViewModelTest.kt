package viewModels


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.extension.ExtendWith


class CreateAccountViewModelTest {
	@Test
	fun `updatePassword should update the password when valid`() {
		// Arrange
		val viewModel = CreateAccountViewModel()

		// Act
		viewModel.updatePassword("ValidPassword123")

		// Assert
		assertEquals("ValidPassword123", viewModel.passwordTextField.value)
	}

	@Test
	fun `updatePassword should not update when password is empty`() {
		// Arrange
		val viewModel = CreateAccountViewModel()

		// Act
		viewModel.updatePassword("")

		// Assert
		assertEquals("", viewModel.passwordTextField.value)
	}
}