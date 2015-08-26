import java.util.List;
import org.sql2o.*;

public class Cuisine {
  private int id;
  private String description;

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public Cuisine (String description) {
    this.description = description;
  }
//
//   public static List<Category> all() {
//     String sql = "SELECT id, name FROM categories";
//     try(Connection con = DB.sql2o.open()) {
//       return con.createQuery(sql).executeAndFetch(Category.class);
//     }
//   }
//
//   @Override
//   public boolean equals(Object otherCategory) {
//     if (!(otherCategory instanceof Category)) {
//       return false;
//     } else {
//       Category newCategory = (Category) otherCategory;
//       return this.getName().equals(newCategory.getName());
//     }
//   }
//
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO cuisines (description) VALUES (:description)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("description", this.description)
        .executeUpdate()
        .getKey();
    }
  }
//
//   public static Category find(int id) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM categories WHERE id=:id";
//       Category category = con.createQuery(sql)
//         .addParameter("id", id)
//         .executeAndFetchFirst(Category.class);
//         return category;
//     }
//   }
//
//   public List<Task> getTasks() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM tasks WHERE categoryId=:id";
//       return con.createQuery(sql)
//         .addParameter("id", this.id)
//         .executeAndFetch(Task.class);
//     }
//   }
//
//   public void delete() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "DELETE FROM categories WHERE id = :id;";
//       con.createQuery(sql)
//         .addParameter("id", id)
//         .executeUpdate();
//     }
//   }
//
//     public void update(String name) {
//       try(Connection con = DB.sql2o.open()) {
//         String sql = "UPDATE categories SET name = :name WHERE id = :id";
//         con.createQuery(sql)
//           .addParameter("name", name)
//           .addParameter("id", id)
//           .executeUpdate();
//       }
//     }
//
//
}
