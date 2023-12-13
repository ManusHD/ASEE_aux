package es.unex.gps.weathevent.view

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import es.unex.gps.weathevent.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class IniciarSesionActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(IniciarSesionActivity::class.java)

    @Test
    fun iniciarSesionActivityTest() {
        val materialButton = onView(
            withId(R.id.registro)
        )
        materialButton.perform(click())

        val appCompatEditText = onView(
            withId(R.id.nombreRegistro)
        )
        appCompatEditText.perform(replaceText("test registro"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            withId(R.id.usernameRegistro)
        )
        appCompatEditText2.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            withId(R.id.emailRegistro)
        )
        appCompatEditText3.perform(replaceText("test@test.es"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            withId(R.id.passRegistro)
        )
        appCompatEditText4.perform(replaceText("test123"), closeSoftKeyboard())

        val materialButton2 = onView(
            withId(R.id.confirmarRegistro)
        )
        materialButton2.perform(click())

        pressBack()

        val materialButton3 = onView(
            withId(R.id.inicarsesionRegistro)
        )
        materialButton3.perform(click())

        val appCompatEditText12 = onView(
            withId(R.id.userLogin)
        )
        appCompatEditText12.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatEditText13 = onView(
            withId(R.id.passLogin)
        )
        appCompatEditText13.perform(replaceText("test123"), closeSoftKeyboard())

        val materialButton4 = onView(
            withId(R.id.entrar)
        )
        materialButton4.perform(click())

        val frameLayout = onView(
            withId(R.id.bottom_navigation)
        )
        frameLayout.check(matches(isDisplayed()))
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
