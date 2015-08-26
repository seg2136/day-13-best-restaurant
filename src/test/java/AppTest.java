// import java.util.ArrayList;

import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.rules.ExternalResource;
import org.sql2o.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Your Favorite Restaurants!");
  }

  @Test
  public void cuisineIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#description").with("Italian");
    submit(".btn");
    assertThat(pageSource()).contains("Italian");
  }

  @Test
  public void cuisineIsDisplayedTest() {
    Cuisine myCuisine = new Cuisine("Italian");
    myCuisine.save();
    String cuisinePath = String.format("http://localhost:4567/cuisines/%d", myCuisine.getId());
    goTo(cuisinePath);
    assertThat(pageSource()).contains("Italian");
  }

  // @Test
  // public void categoryTasksFromIsDisplayed() {
  //   goTo("http://localhost:4567/categories/new");
  //   fill("#name").with("Shopping");
  //   submit(".btn");
  //   System.out.println(pageSource());
  //   click("a", withText("View categories"));
  //   click("a", withText("Shopping"));
  //   click("a", withText("Add a new task"));
  //   assertThat(pageSource()).contains("Add a Task to Shopping");
  // }
  //
  // @Test
  // public void tasksIsAddedAndDisplayed() {
  //   goTo("http://localhost:4567/categories/new");
  //   fill("#name").with("Banking");
  //   submit(".btn");
  //   click("a", withText("View categories"));
  //   click("a", withText("Banking"));
  //   click("a", withText("Add a new task"));
  //   fill("#description").with("Deposit paycheck");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Deposit paycheck");
  // }
}
