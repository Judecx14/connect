package dev.fenix.customer.feature.auth.login.form

import dev.fenix.ui.core.form.FormControl
import dev.fenix.ui.core.form.FormGroup
import dev.fenix.ui.core.form.FormValidators.email
import dev.fenix.ui.core.form.FormValidators.required
import javax.inject.Inject

class LoginFormGroup @Inject constructor() : FormGroup() {

    val email = FormControl(
        initialValue = "",
        validators = listOf(
            required(),
            email()
        ),
        validateOnChange = true
    )

    val password = FormControl(
        initialValue = "",
        validators = listOf(
            required()
        ),
        validateOnChange = true
    )

    override val controls: List<FormControl<*, *>> = listOf(email, password)
}
