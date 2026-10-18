package dev.fenix.customer.feature.auth.signup.form

import dev.fenix.ui.core.form.FormControl
import dev.fenix.ui.core.form.FormGroup
import dev.fenix.ui.core.form.FormValidators.email
import dev.fenix.ui.core.form.FormValidators.minLength
import dev.fenix.ui.core.form.FormValidators.required
import javax.inject.Inject

class SignUpFormGroup @Inject constructor() : FormGroup() {

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
            required(),
            minLength(6)
        ),
        validateOnChange = true
    )

    override val controls: List<FormControl<*, *>> = listOf(email, password)
}
