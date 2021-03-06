import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ftmedia_plugins_ftLibrary_musicAssetshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/musicAsset/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('set','g',4,['var':("entityName"),'value':(message(code: 'musicAsset.label', default: 'MusicAsset'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',5,['code':("default.show.label"),'args':([musicAsset])],-1)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('message','g',9,['code':("default.show.label"),'args':([musicAsset])],-1)
printHtmlPart(4)
invokeTag('display','f',14,['bean':("musicAsset")],-1)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
createTagBody(3, {->
invokeTag('message','g',18,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',18,['class':("edit btn btn-primary"),'data-toggle':("modal"),'data-target':("#modal-edit"),'action':("edit"),'resource':(this.musicAsset)],3)
printHtmlPart(7)
expressionOut.print(message(code: 'default.button.delete.label', default: 'Delete'))
printHtmlPart(8)
expressionOut.print(message(code: 'default.button.delete.confirm.message', default: 'Are you sure?'))
printHtmlPart(9)
})
invokeTag('form','g',21,['resource':(this.musicAsset),'method':("DELETE")],2)
printHtmlPart(10)
for( data in (mapData) ) {
printHtmlPart(11)
expressionOut.print(data.key)
printHtmlPart(12)
expressionOut.print(data.value)
printHtmlPart(13)
}
printHtmlPart(14)
for( data in (mapDataArtist) ) {
printHtmlPart(11)
expressionOut.print(data.key)
printHtmlPart(12)
expressionOut.print(data.value)
printHtmlPart(13)
}
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',39,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1467660794470L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
