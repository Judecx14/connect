package dev.fenix.customer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import dev.fenix.customer.feature.auth.login.LoginScreen
import dev.fenix.customer.feature.auth.signup.SignUpScreen
import dev.fenix.ui.transition.FenixTransition
import dev.fenix.customer.navigation.Route.*
import dev.fenix.customer.feature.hub.HubScreen

@Composable
fun Navigator(
    startRoute: Route
) {
    val backStack = rememberNavBackStack(startRoute)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        transitionSpec = { FenixTransition.slideRight },
        popTransitionSpec = { FenixTransition.slideLeft },
        predictivePopTransitionSpec = { FenixTransition.slideLeft },
        entryProvider = entryProvider {
            entry<Login> {
                LoginScreen(
                    navigateToHome = { backStack.navigateTo(screen = Home) },
                    navigateToSignUp = { backStack.navigateTo(screen = SignUp) }
                )
            }

            entry<SignUp> {
                SignUpScreen(
                    navigateToBack = { backStack.back() },
                    navigateToHome = { backStack.navigateTo(screen = Home) }
                )
            }

            entry<Home> {
                HubScreen(
                    navigateToLogin = {
                        backStack.resetTo(screen = Login)
                    }
                )
            }
        }
    )
}