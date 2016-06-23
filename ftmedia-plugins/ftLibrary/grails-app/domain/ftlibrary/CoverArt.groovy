package ftlibrary

class CoverArt {

    String  title
    String  path
    byte[]  data

    static constraints = {
        title   nullable: false, maxSize: 255
        path    nullable: false, unique: true, maxSize: 255
        data    nullable: false
    }

    static mapping = {
        data    sqlType: "blob"
    }
}
