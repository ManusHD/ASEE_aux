package es.unex.gps.weathevent.view

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import es.unex.gps.weathevent.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class FavoritosTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(IniciarSesionActivity::class.java)

    @Test
    fun anadirFavoritos(){
        val materialButton = Espresso.onView(
            ViewMatchers.withId(R.id.registro)
        )
        materialButton.perform(ViewActions.click())

        val appCompatEditText = Espresso.onView(
            ViewMatchers.withId(R.id.nombreRegistro)
        )
        appCompatEditText.perform(
            ViewActions.replaceText("test fav"),
            ViewActions.closeSoftKeyboard()
        )

        val appCompatEditText2 = Espresso.onView(
            ViewMatchers.withId(R.id.usernameRegistro)
        )
        appCompatEditText2.perform(
            ViewActions.replaceText("testAnadirFavorito"),
            ViewActions.closeSoftKeyboard()
        )

        val appCompatEditText3 = Espresso.onView(
            ViewMatchers.withId(R.id.emailRegistro)
        )
        appCompatEditText3.perform(
            ViewActions.replaceText("test@test.es"),
            ViewActions.closeSoftKeyboard()
        )

        val appCompatEditText4 = Espresso.onView(
            ViewMatchers.withId(R.id.passRegistro)
        )
        appCompatEditText4.perform(ViewActions.replaceText("test"), ViewActions.closeSoftKeyboard())

        val materialButton2 = Espresso.onView(
            ViewMatchers.withId(R.id.confirmarRegistro)
        )
        materialButton2.perform(ViewActions.click())

        val frameLayout = Espresso.onView(
            ViewMatchers.withId(R.id.bottom_navigation)
        )
        frameLayout.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val bottomNavigationItemView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buscarFragment),
                ViewMatchers.withContentDescription("Búsqueda"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.bottom_navigation),
                        0
                    ),
                    1
                ),
                ViewMatchers.isDisplayed()
            )
        )
        bottomNavigationItemView.perform(ViewActions.click())

        Thread.sleep(15000)

        val textInputEditText = Espresso.onView(
            Matchers.allOf(
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.editText),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        textInputEditText.perform(
            ViewActions.replaceText("La Coronada"),
            ViewActions.closeSoftKeyboard()
        )


    }

    @Test
    fun verFavoritos(){

    }

    @Test
    fun eliminarFavoritos(){

    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}