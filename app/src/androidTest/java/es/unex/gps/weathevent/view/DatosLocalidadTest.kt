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
class DatosLocalidadTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(IniciarSesionActivity::class.java)

    @Test
    fun datosLocalidadTest() {
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
        appCompatEditText.perform(replaceText("1"), closeSoftKeyboard())
        
        val appCompatEditText2 = onView(
allOf(withId(R.id.usernameRegistro),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        appCompatEditText2.perform(replaceText("1"), closeSoftKeyboard())
        
        val appCompatEditText3 = onView(
allOf(withId(R.id.emailRegistro),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
6),
isDisplayed()))
        appCompatEditText3.perform(replaceText("1@1.es"), closeSoftKeyboard())
        
        val appCompatEditText4 = onView(
allOf(withId(R.id.passRegistro),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
8),
isDisplayed()))
        appCompatEditText4.perform(replaceText("1"), closeSoftKeyboard())
        
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
        textInputEditText.perform(replaceText(""), closeSoftKeyboard())
        
        val bottomNavigationItemView2 = onView(
allOf(withId(R.id.favoritosFragment), withContentDescription("Favoritos"),
childAtPosition(
childAtPosition(
withId(R.id.bottom_navigation),
0),
2),
isDisplayed()))
        bottomNavigationItemView2.perform(click())
        
        val bottomNavigationItemView3 = onView(
allOf(withId(R.id.buscarFragment), withContentDescription("Búsqueda"),
childAtPosition(
childAtPosition(
withId(R.id.bottom_navigation),
0),
1),
isDisplayed()))
        bottomNavigationItemView3.perform(click())
        
        val textInputEditText2 = onView(
allOf(childAtPosition(
childAtPosition(
withId(R.id.editText),
0),
0),
isDisplayed()))
        textInputEditText2.perform(replaceText("La coro"), closeSoftKeyboard())
        
        val appCompatImageView = onView(
allOf(withId(R.id.favoriteIcon),
childAtPosition(
childAtPosition(
withId(R.id.search_item),
0),
1),
isDisplayed()))
        appCompatImageView.perform(click())
        
        val bottomNavigationItemView4 = onView(
allOf(withId(R.id.favoritosFragment), withContentDescription("Favoritos"),
childAtPosition(
childAtPosition(
withId(R.id.bottom_navigation),
0),
2),
isDisplayed()))
        bottomNavigationItemView4.perform(click())
        
        val cardView = onView(
allOf(withId(R.id.cv_Item),
childAtPosition(
childAtPosition(
withId(R.id.rvFavoritos),
0),
0),
isDisplayed()))
        cardView.perform(click())
        
        pressBack()
        
        val bottomNavigationItemView5 = onView(
allOf(withId(R.id.buscarFragment), withContentDescription("Búsqueda"),
childAtPosition(
childAtPosition(
withId(R.id.bottom_navigation),
0),
1),
isDisplayed()))
        bottomNavigationItemView5.perform(click())
        
        val textInputEditText3 = onView(
allOf(childAtPosition(
childAtPosition(
withId(R.id.editText),
0),
0),
isDisplayed()))
        textInputEditText3.perform(replaceText("la coronada"), closeSoftKeyboard())
        
        val materialTextView = onView(
allOf(withId(R.id.cityName), withText("La Coronada"),
childAtPosition(
childAtPosition(
withId(R.id.search_item),
0),
0),
isDisplayed()))
        materialTextView.perform(click())
        
        val textView = onView(
allOf(withId(R.id.temperature_view), withText("7º C"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        textView.check(matches(isDisplayed()))
        
        val textView2 = onView(
allOf(withId(R.id.temperature_view), withText("7º C"),
withParent(withParent(withId(android.R.id.content))),
isDisplayed()))
        textView2.check(matches(isDisplayed()))
        
        val bottomNavigationItemView6 = onView(
allOf(withId(R.id.proximosDiasFragment), withContentDescription("Próximos días"),
childAtPosition(
childAtPosition(
withId(R.id.pronostico_navigation),
0),
1),
isDisplayed()))
        bottomNavigationItemView6.perform(click())
        
        val bottomNavigationItemView7 = onView(
allOf(withId(R.id.proximasHorasFragment), withContentDescription("Próximas horas"),
childAtPosition(
childAtPosition(
withId(R.id.pronostico_navigation),
0),
0),
isDisplayed()))
        bottomNavigationItemView7.perform(click())
        
        val viewGroup = onView(
allOf(withParent(allOf(withId(android.R.id.content),
withParent(withId(androidx.appcompat.R.id.action_bar_root)))),
isDisplayed()))
        viewGroup.check(matches(isDisplayed()))
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
