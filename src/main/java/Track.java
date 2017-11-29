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

        Track t2=new Track(2,"abc","def");
        t2.insert();
        Pepita t1=new Pepita(1,"ciao",false,1.3);
        t1.insert();
        t1=new Pepita(2,"hello",false,1.3);
        t1.insert();
        String[] cosas=new String[2];
        cosas[0]="numeroTal";
        cosas[1]="co";
        String[] id=new String[2];
        id[0]="numeroTal";
        id[1]="co";
        Object[] obj=new Object[2];
        obj[0]=2;
        obj[1]="hello";
        t1.select(cosas,id,obj);
        //Object[] a = null;
        //t1.update("co",a) ;
        //t1.insert();



        //t2.update("id",a) ;
        //t2.insert();

    }
}
