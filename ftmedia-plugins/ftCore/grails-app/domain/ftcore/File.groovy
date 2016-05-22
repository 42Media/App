package ftCore

/**
    @author:    atzscherlich
    @version:   0.1
    @date:      2016-05-18
*/


class File {
    Long    id
    String  path
    String  name
    String  extension
    Integer size
    String  creator
    Date    dateAdded
    Date    lastModified
    String  checksum
    
    
    static constraints = {
        id {nullable: false}
        path {nullable: false}
        name {nullable: false}
        extension {nullable: false}
        size {nullable: false}
        creator {nullable: false}
        checksum {nullable: false}
        
    }
}
