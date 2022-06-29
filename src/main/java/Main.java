import com.CodeGym.service.DBHandler;
import com.CodeGym.model.AppUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DBHandler<AppUser> dbHandler = DBHandler.getInstance();

        ResultSet rs = dbHandler.findAllByCondition("user", "");
        try {
            while (rs.next()){
                System.out.println(rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
