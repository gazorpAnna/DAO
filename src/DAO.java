import java.sql.Connection;

public abstract class DAO {


    public String getInsert() {
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(this.getClass().getSimpleName());
        sb.append(" ");
        return sb.toString();
    }

    public void insert()
    {
        String query = getInsert();
        Connection c = getConnection();
        c.prepareStatement(query);
    }

    public Connection getConnection(){

    }


    public void select(String bdname){
        StringBuffer sb = new StringBuffer("SELECT * FROM ");
        sb.append(bdname);
    }

    public void update(){

    }

    public void delete(){

    }

}
