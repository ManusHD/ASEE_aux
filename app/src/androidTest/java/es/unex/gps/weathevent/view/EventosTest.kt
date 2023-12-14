package es.unex.gps.weathevent.view


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
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
import org.hamcrest.Matchers.`is`
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class EventosTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(IniciarSesionActivity::class.java)

    @Test
    fun eventosTest() {
        val materialButton = onView(
            allOf(
                withId(R.id.registro), withText("Registrarse"),
                childAtPosition(
                    allOf(
                        withId(R.id.fondo),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.nombreRegistro),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("1"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.usernameRegistro),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("1"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.emailRegistro),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("1@1.es"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.passRegistro),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("1"), closeSoftKeyboard())

        val materialButton7 = onView(
            withId(R.id.confirmarRegistro)
        )
        materialButton7.perform(click())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.listEventFragment), withContentDescription("Eventos"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val floatingActionButton = onView(
            allOf(
                withId(R.id.add_event_button), withContentDescription("Añadir evento"),
                childAtPosition(
                    allOf(
                        withId(R.id.listEventFragment),
                        childAtPosition(
                            withId(R.id.nav_host_fragment),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        floatingActionButton.perform(click())

        val textInputEditText = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.event_name_view),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("Evento Test"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.location_view),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("La Coronada"), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.date_picker_btn), withText("Seleccionar fecha"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

        val materialButton3 = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton3.perform(scrollTo(), click())

        val materialButton4 = onView(
            allOf(
                withId(R.id.hour_picker_btn), withText("Seleccionar hora"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        materialButton4.perform(click())

        val materialButton5 = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton5.perform(scrollTo(), click())

        Thread.sleep(10000)

        val materialButton6 = onView(
            allOf(
                withId(R.id.save_event_btn), withText("Guardar"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    8
                ),
                isDisplayed()
            )
        )
        materialButton6.perform(click())

        val viewGroup = onView(
            allOf(
                withParent(
                    allOf(
                        withId(R.id.rv_list_events),
                        withParent(withId(R.id.listEventFragment))
                    )
                ),
                isDisplayed()
            )
        )
        viewGroup.check(matches(isDisplayed()))
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
