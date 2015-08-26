// import java.time.LocalDateTime;
// import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Restaurant {
  private int id;
  private int cuisine_id;
  private String name;

  public int getId() {
    return id;
  }

  public int getCuisine_id() {
    return cuisine_id;
  }

  public String getName() {
    return name;
  }

  public Restaurant(String name, int cuisine_id) {
    this.name = name;
    this.cuisine_id = cuisine_id;
  }

  @Override
  public boolean equals(Object otherRestaurant) {
    if(!(otherRestaurant instanceof Restaurant)) {
      return false;
    } else {
      Restaurant newRestaurant = (Restaurant) otherRestaurant;
      return this.getName().equals(newRestaurant.getName()) &&
             this.getId() == newRestaurant.getId() &&
             this.getCuisine_id() == newRestaurant.getCuisine_id();
    }
  }

  public static List<Restaurant> all() {
    String sql = "SELECT id, name, cuisine_id FROM restaurants";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Restaurant.class);
    }
  }

  // public void save() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "INSERT INTO tasks (description, categoryId) VALUES (:description, :categoryId)";
  //     this.id = (int) con.createQuery(sql, true)
  //       .addParameter("description", this.description)
  //       .addParameter("categoryId", this.categoryId)
  //       .executeUpdate()
  //       .getKey();
  //   }
  // }
  //
  // public static Task find(int id) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM tasks where id=:id";
  //     Task task = con.createQuery(sql)
  //         .addParameter("id", id)
  //         .executeAndFetchFirst(Task.class);
  //         return task;
  //   }
  // }

  // private String mDescription;
  // private LocalDateTime mCreatedAt;
  // private boolean mCompleted;
  // private int mId;
  //
  //
  // public Task(String description){
  //   mDescription = description;
  //   mCreatedAt = LocalDateTime.now();
  //   mCompleted = false;
  //   instances.add(this);
  //   mId = instances.size();
  // }

  // public boolean isCompleted() {
  //   return mCompleted;
  // }

  // public void completeTask() {
  //   mCompleted = true;
  // }

  //
  // public static void clear() {
  //   instances.clear();
  // }
}
