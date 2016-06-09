package ftcore

/**
 @author:    atzscherlich
 @version:   0.2
 @date:      2016-06-05
 */


class FileObject {
    String   id
    String  path
    String  name
    String  extension
    Integer size
    String  creator
    Date    dateCreated
    Date    lastModified
    String  checksum


    static constraints = {
        path nullable: false, unique: true
        name nullable: false
        extension nullable: false
        size nullable: false
        creator nullable: false
    }

    static mapping = {
        id generator: 'uuid'
    }

    static belongsTo = [mediaAsset: MediaAsset]
}