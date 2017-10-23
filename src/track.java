public class track extends DAO {
    int id;
    String name, desc;

    public track(){
        id = 1;
        name = "hola";
        desc = "Descripción de la track";
    }

    public track(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static void main(String[] Args){

        track t1=new track();
        track t2=new track(2,"abc","def");
        t2.insert();
    }
}
