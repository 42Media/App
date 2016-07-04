import grails.plugins.metadata.GrailsPlugin
import org.grails.gsp.compiler.transform.LineNumber
import org.grails.gsp.GroovyPage
import org.grails.web.taglib.*
import org.grails.taglib.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_ftmedia_plugins_ftLibrary_musicAssetindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/musicAsset/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',5,['var':("entityName"),'value':(message(code: 'musicAsset.label', default: 'MusicAsset'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('actionSubmit','g',27,['class':("btn btn-success"),'value':("Filtern"),'action':("filter")],-1)
printHtmlPart(5)
})
invokeTag('form','g',28,['controller':("musicAsset"),'method':("POST")],2)
printHtmlPart(6)
for( music in (musicAssetList) ) {
printHtmlPart(7)
expressionOut.print(music.id)
printHtmlPart(8)
expressionOut.print(music.title)
printHtmlPart(9)
}
printHtmlPart(10)
invokeTag('paginate','g',50,['total':(musicAssetCount ?: 0)],-1)
printHtmlPart(11)
invokeTag('message','g',68,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(12)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(13)
invokeTag('message','g',71,['code':("default.home.label")],-1)
printHtmlPart(14)
createTagBody(2, {->
invokeTag('message','g',72,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',72,['class':("create"),'action':("create")],2)
printHtmlPart(15)
invokeTag('message','g',76,['code':("default.list.label"),'args':([entityName])],-1)
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
invokeTag('table','f',80,['collection':(musicAssetList)],-1)
printHtmlPart(20)
invokeTag('paginate','g',83,['total':(musicAssetCount ?: 0)],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',86,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1467663127758L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'none'
public static final String TAGLIB_CODEC = 'none'
}
