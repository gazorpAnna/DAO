import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        sb.append(") VALUES (");
        for (Field f:atributos) {
            sb.append("?,");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(")");
        //sb.append(") VALUES (?,?,?)");
        System.out.println(sb);
        return sb.toString();
    }

    public void insert() throws InvocationTargetException, IllegalAccessException {
        //String query = getInsert();
        //Connection c = getConnection();
        //c.prepareStatement(query);
        Object[] cosasBonitas = new Object[atributos.length];
        for (int i=0;i<atributos.length;i++)
        {
            Method[] metodos=this.getClass().getMethods();
            int j;
            String ab="get"+atributos[i].getName().substring(0,1).toUpperCase()+atributos[i].getName().substring(1,atributos[i].getName().length());

            for (j=0;j<metodos.length;j++)
            {
                //metodos.toString().con
                String nombre=metodos[j].toString();
                if (nombre.contains("get"+atributos[i].getName().substring(0,1).toUpperCase()+atributos[i].getName().substring(1,atributos[i].getName().length())))
                {
                    break;
                }
            }
            int abc=j;
            cosasBonitas[i]= metodos[j].invoke(this,null);//INVOKE ES LA CLAVE
            System.out.println(cosasBonitas[i].toString()+" ");
            //statement.setString(i+1, metodos[j] );
        }
        /*

        statement.setString(1, "bill");
        statement.setString(2, "secretpass");
        statement.setString(3, "Bill Gates");


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

    // UPDATE Track SET name=?, desc=? WHERE id=?
    public void update(String idString, Object[] parametros){
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(this.getClass().getSimpleName()).append(" SET ");
        atributos = this.getClass().getFields();
        for (Field f: atributos)
        {
            if( f.getName() != idString)
                sb.append(f.getName()).append("=?,");
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(" WHERE ");
        sb.append(idString).append("=?");
        System.out.println(sb);
        /*reparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, parametros);
        statement.setString(2, );
        statement.setString(3, "bill.gates@microsoft.com");
        statement.setString(4, "bill");
        */

    }

    // DELETE FROM Track WHERE id=?
    public void delete(){
        StringBuffer sb = new StringBuffer("DELETE FROM ");
        sb.append(this.getClass().getSimpleName()).append(" WHERE ");

    }

}
