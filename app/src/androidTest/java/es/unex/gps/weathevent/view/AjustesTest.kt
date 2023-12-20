package es.unex.gps.weathevent.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
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
class AjustesTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(IniciarSesionActivity::class.java)

    @Test
    fun preferenciasTest() {

        val materialButton = onView(
            withId(R.id.registro)
        )
        materialButton.perform(click())

        val appCompatEditText = Espresso.onView(
            ViewMatchers.withId(R.id.nombreRegistro)
        )
        appCompatEditText.perform(
            ViewActions.replaceText("test preferencias"),
            ViewActions.closeSoftKeyboard()
        )

        val appCompatEditText2 = Espresso.onView(
            ViewMatchers.withId(R.id.usernameRegistro)
        )
        appCompatEditText2.perform(
            ViewActions.replaceText("testPreferencias"),
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

        val overflowMenuButton = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.toolbar),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        overflowMenuButton.perform(ViewActions.click())

        val materialTextView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.action_settings), ViewMatchers.withText("Ajustes"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(androidx.appcompat.R.id.content),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialTextView.perform(ViewActions.click())
/*
        val recyclerView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(androidx.preference.R.id.recycler_view),
                childAtPosition(
                    ViewMatchers.withId(android.R.id.list_container),
                    0
                )
            )
        )
        recyclerView.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )

        val recyclerView2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(androidx.preference.R.id.recycler_view),
                childAtPosition(
                    ViewMatchers.withId(android.R.id.list_container),
                    0
                )
            )
        )
        recyclerView2.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                ViewActions.click()
            )
        )


        val appCompatCheckedTextView = Espresso.onData(Matchers.anything())
            .inAdapterView(
                Matchers.allOf(
                    ViewMatchers.withId(androidx.appcompat.R.id.select_dialog_listview),
                    childAtPosition(
                        ViewMatchers.withId(androidx.appcompat.R.id.contentPanel),
                        0
                    )
                )
            )
            .atPosition(1)
        appCompatCheckedTextView.perform(ViewActions.click())

        val recyclerView3 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(androidx.preference.R.id.recycler_view),
                childAtPosition(
                    ViewMatchers.withId(android.R.id.list_container),
                    0
                )
            )
        )
        recyclerView3.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                ViewActions.click()
            )
        )

 */

        val appCompatCheckedTextView2 = Espresso.onData(Matchers.anything())
            .inAdapterView(
                Matchers.allOf(
                    ViewMatchers.withId(androidx.appcompat.R.id.select_dialog_listview),
                    childAtPosition(
                        ViewMatchers.withId(androidx.appcompat.R.id.contentPanel),
                        0
                    )
                )
            )
            .atPosition(1)
        appCompatCheckedTextView2.perform(ViewActions.click())

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
            ViewActions.replaceText("Montijo"),
            ViewActions.closeSoftKeyboard()
        )

        val materialTextView2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.cityName), ViewMatchers.withText("Montijo"),
                childAtPosition(
                    childAtPosition(
                        ViewMatchers.withId(R.id.search_item),
                        0
                    ),
                    0
                ),
                ViewMatchers.isDisplayed()
            )
        )
        materialTextView2.perform(ViewActions.click())

        val textView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.temperature_view),
                ViewMatchers.withText(Matchers.endsWith("º F")),
                ViewMatchers.withParent(ViewMatchers.withParent(ViewMatchers.withId(android.R.id.content))),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.withText(Matchers.endsWith("º F"))))
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