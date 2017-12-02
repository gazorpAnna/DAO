import java.util.ArrayList;

public class Track extends DAO {
    public int id;
    public String name, description;

    public Track(){
        id = 1;
        name = "hola";
        description = "Descripción de la Track";
    }

    public Track(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.description = desc;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }


    public static void main(String[] Args) throws Exception{

        //Track t2=new Track(2,"budy-holy","abcd");
        //t2.insert();
        Pepita t1=new Pepita(2,"hello",false,0);
        //t1.insert();

        /*
        String[] cosas=new String[2];
        cosas[0]="pop";
        cosas[1]="tre";
        String[] id=new String[2];
        id[0]="numeroTal";
        id[1]="co";
        Object[] obj=new Object[2];
        obj[0]=2;
        obj[1]="hello";
        ArrayList<Object[]> resultado=t1.select(cosas,id,obj);
        int a=0;
        */

        //Parametros que quiero cambiar
        String[] parametros=new String[2];
        parametros[0]="numeroTal";
        parametros[1]="co";
        //nuevos datos que quiero en esos parametros
        Object[] nuevos=new Object[2];
        nuevos[0]=3;
        nuevos[1]="mamarracho";

        //Condiciones para que cambie de toda la tabla las lineas que yo quiera
        //columnas que quiero que mire para la condicion
        String[] cond1=new String[2];
        cond1[0]="numeroTal";
        cond1[1]="co";
        //valores que quiero que tengan esas columnas para la condicion
        Object[] cond2=new Object[2];
        cond2[0]=2;
        cond2[1]="hello";
        t1.update(parametros,nuevos,cond1,cond2);

        //Object[] a = null;
        //t1.update("co",a) ;
        //t1.insert();



        //t2.update("id",a) ;
        //t2.insert();

    }
}
