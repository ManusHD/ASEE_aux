package es.unex.gps.weathevent.view


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import es.unex.gps.weathevent.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class BusquedaTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(IniciarSesionActivity::class.java)

    @Test
    fun busquedaTest() {
        val materialButton = onView(
allOf(withId(R.id.registro), withText("Registrarse"),
childAtPosition(
allOf(withId(R.id.fondo),
childAtPosition(
withId(android.R.id.content),
0)),
7),
isDisplayed()))
        materialButton.perform(click())
        
        val appCompatEditText = onView(
allOf(withId(R.id.nombreRegistro),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
2),
isDisplayed()))
        appCompatEditText.perform(replaceText("test"), closeSoftKeyboard())
        
        val appCompatEditText2 = onView(
allOf(withId(R.id.usernameRegistro),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        appCompatEditText2.perform(replaceText("test"), closeSoftKeyboard())
        
        val appCompatEditText3 = onView(
allOf(withId(R.id.emailRegistro),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
6),
isDisplayed()))
        appCompatEditText3.perform(replaceText("test@test.es"), closeSoftKeyboard())
        
        val appCompatEditText4 = onView(
allOf(withId(R.id.passRegistro),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
8),
isDisplayed()))
        appCompatEditText4.perform(replaceText("test"), closeSoftKeyboard())
        
        val bottomNavigationItemView = onView(
allOf(withId(R.id.buscarFragment), withContentDescription("Búsqueda"),
childAtPosition(
childAtPosition(
withId(R.id.bottom_navigation),
0),
1),
isDisplayed()))
        bottomNavigationItemView.perform(click())
        
        val textInputEditText = onView(
allOf(childAtPosition(
childAtPosition(
withId(R.id.editText),
0),
0),
isDisplayed()))
        textInputEditText.perform(replaceText("La Coronada"), closeSoftKeyboard())
        
        val materialTextView = onView(
allOf(withId(R.id.cityName), withText("La Coronada"),
childAtPosition(
childAtPosition(
withId(R.id.search_item),
0),
0),
isDisplayed()))
        materialTextView.perform(click())
        
        val bottomNavigationItemView2 = onView(
allOf(withId(R.id.proximosDiasFragment), withContentDescription("Próximos días"),
childAtPosition(
childAtPosition(
withId(R.id.pronostico_navigation),
0),
1),
isDisplayed()))
        bottomNavigationItemView2.perform(click())
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

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
