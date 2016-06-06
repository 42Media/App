package ftlibrary

import grails.transaction.Transactional
import groovy.util.slurpersupport.GPathResult
import groovy.util.slurpersupport.NodeChildren
import org.grails.core.DefaultGrailsDomainClass

import java.nio.file.Files

@Transactional
class MapperService {

    static Map mapMovieNfo(File nfo)
    {
        Map param = [:]
        GPathResult data = new XmlSlurper().parse(nfo)

        def properties = new DefaultGrailsDomainClass(VideoAsset.class).persistentProperties

        properties.each
        {
            if(it.name && data?.(it.name.toLowerCase()))
            {

                def key = it.name
                def targetType = it.getTypePropertyName()
                def value = data?.(key.toLowerCase())
                if(value.text().size())
                    param.put(key,  cast(value, targetType))
            }

        }

        return param
    }

    static Map mapFile(File src)
    {
        def path = src.toPath()
        def Map params = [:]

        params.put 'creator', Files?.getOwner(path).toString() ?: ''
        // 2015-01-12T12:47:29.206642Z
        // yyyy-MM-ddTHH:mm:ss.SSS
        params.put 'lastModified', new Date(Files?.getLastModifiedTime(path).toMillis()) ?: new Date()
        params.put 'size', Files?.size(path).intValue() ?: 0
        params.put 'name', path?.fileName.toString() ?: ''
        params.put 'path', path?.parent.toString() ?: ''
        params.put 'extension', path?.fileName.toString().split('\\.')[-1].toLowerCase() ?: ''
        params.put 'checksum', new Date().toString()

        return params
    }

    private static cast(NodeChildren node, String targetType)
    {
        assert !node.isEmpty()
        println("cast " + node.text() + " as " + targetType)
        switch(targetType)
        {
            case 'int':
                return node?.toInteger(); break;
            case 'double':
                return node.toDouble(); break;
            case 'float':
                return node.toFloat(); break;
            case 'string':
                return node.toString(); break;
            case 'boolean':
                return node.toBoolean(); break;
            case 'list':
                return node.toList(); break;
            default:
                return node.text();
        }
    }

    /*
    def private static Map<String, String> fileObjectProperties =
    {
        def targetProperties = new DefaultGrailsDomainClass(FileObject.class).persistentProperties
        def Map props = [:]
        targetProperties.each
        {
            prop ->
                props.put prop.name , prop.getTypePropertyName()
        }
        return props
    }
    */

}

