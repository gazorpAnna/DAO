import com.mysql.jdbc.Statement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;

public abstract class DAO {

    //Field[]
    Field[] atributos;
    
    //INSERT INTO Track (id, name, desc) VALUES (?, ?, ?)
    public String getInsert() throws Exception{
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(this.getClass().getSimpleName().substring(0,1).toLowerCase()+this.getClass().getSimpleName().substring(1,this.getClass().getSimpleName().length())).append(" ("); //Track
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
        try{
            String query = getInsert();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba","root", "dsa.upc");
            PreparedStatement statement=c.prepareStatement(query);

        Method[] metodos=this.getClass().getMethods();
        Object[] cosasBonitas = new Object[atributos.length];
        for (int i=0;i<atributos.length;i++)
        {
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

            //System.out.println(cosasBonitas[i].toString()+" ");
            statement.setObject(i+1, cosasBonitas[i] );

        }
        statement.executeUpdate();
        int a=0;
        statement.close();
        c.close();
        }catch (Exception e){
            int a=0;
        }

    }

    /*public Connection getConnection(){
        return
    }*/

    // SELECT * FROM Track WHERE id=?
    public void select(String[] datos,String[] id,Object[] obj){
        try {
            StringBuffer sb = new StringBuffer("SELECT ");
            for (String f : datos) {
                sb.append(f).append(",");

            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append(" FROM ");
            sb.append(this.getClass().getSimpleName().substring(0, 1).toLowerCase() + this.getClass().getSimpleName().substring(1, this.getClass().getSimpleName().length())).append(" ("); //Track
            //sb.append(this.getClass().getSimpleName());
            //sb.append(bdname);
            sb.append(" WHERE ");
            for(String a:id){
                sb.append(a).append("=?").append(" && ");
            }
            sb.delete(sb.length()-4,sb.length());
            String query = sb.toString();
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "dsa.upc");
            PreparedStatement statement = c.prepareStatement(query);
            for(int i=0;i<obj.length;i++){
                statement.setObject(i+1,obj[i]);
            }
            ResultSet abc=statement.executeQuery();
            while(abc.next()) {
                System.out.println();
            }
            int a=0;
            statement.close();
            c.close();

        }catch (Exception e){

        }



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
