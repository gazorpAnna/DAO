import java.util.ArrayList;

public class Track extends DAO {
    public final int id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }


    public static void main(String[] Args) throws Exception{

        //Track t2=new Track(2,"budy-holy","abcd");
        //t2.insert();

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
        Pepita t1=new Pepita(2,"hello",false,0);
        t1.insert();
        ArrayList<Object[]> datos1=t1.select();
        t1=new Pepita(2,"ciao",false,0);
        t1.insert();
        ArrayList<Object[]> datos2=t1.select();
        t1.setNumeroTal(3);
        t1.setPop(true);
        t1.setTre(0.25);
        t1.update();
        ArrayList<Object[]> datos3=t1.select();
        t1.delete();
        ArrayList<Object[]> datos4=t1.select();
        int a=0;

        //Object[] a = null;
        //t1.update("co",a) ;
        //t1.insert();



        //t2.update("id",a) ;
        //t2.insert();

    }
}
