import java.lang.reflect.Field;
import java.sql.Connection;
import java.text.Format;

public abstract class DAO {

    //Field[]
    Field[] atributos;
    
    //INSERT INTO Track (id, name, desc) VALUES (?, ?, ?)
    public String getInsert() throws Exception{
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(this.getClass().getSimpleName()).append(" ("); //Track
        atributos = this.getClass().getFields();
        for (Field f:atributos) {
            sb.append(f.getName()).append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(") VALUES (?,?,?)");
        //System.out.println(sb);
        return sb.toString();
    }

    public void insert()
    {
        //String query = getInsert();
        //Connection c = getConnection();
        //c.prepareStatement(query);
        /*
        statement.setString(1, "bill");
        statement.setString(2, "secretpass");
        statement.setString(3, "Bill Gates");
        statement.setString(4, "bill.gates@microsoft.com");

        int rowsInserted = statement.executeUpdate();*/
    }

    /*public Connection getConnection(){
        return
    }*/

    // SELECT * FROM Track
    public void select(String[] datos){
        StringBuffer sb = new StringBuffer("SELECT ");
        for (String f:datos)
        {
            sb.append(f).append(",");

        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(" FROM ");
        sb.append(this.getClass().getSimpleName());
        //sb.append(bdname);
    }

    // UPDATE Track SET id=?, name=?, desc=? WHERE username=?
    public void update(String[] datos,String id){
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(this.getClass().getSimpleName()).append(" SET ");
        for (String f:datos)
        {
            sb.append(f).append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(" WHERE ");
        sb.append(id);

    }

    // DELETE FROM Track WHERE id=?
    public void delete(){
        StringBuffer sb = new StringBuffer("DELETE FROM ");
        sb.append(this.getClass().getSimpleName()).append(" WHERE ");

    }

}
